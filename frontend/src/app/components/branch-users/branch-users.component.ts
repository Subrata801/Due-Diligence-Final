import { Component, OnInit } from '@angular/core';
import { FormArray,FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';
import { ReferenceService } from '../../services/reference-service/reference.service';
import { ClientConfigurationService } from '../../services/client-configuration/client-configuration.service';
import { BranchUserService } from '../../services/branch-users/branch-users.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../../services/auth-service/auth.service';
import { forkJoin, Observable } from 'rxjs';

@Component({
  selector: 'app-branch-users',
  templateUrl: './branch-users.component.html',
  styleUrls: ['./branch-users.component.scss']
})
export class BranchUsersComponent implements OnInit {
  branchUserListForm :FormGroup;
  branchUsersForm: FormGroup;
  searchUserForm: FormGroup;
  isSearchUserFailed = false;
  isSearchFailed = false;
  clientTypeOptions: any = [];
  clientOptions: any = [];
  clientGroupOptions: any = [];
  userRoleOptions: any = [];
  unitTypeOptions: any = [];
  isUnitTypeSearch: boolean = false;
  pageErrors: any = {};
  isError: boolean = false;
  isSuccess: boolean = false;
  errorMessage = '';
  isChecked: boolean = false;
  search: boolean = true;
  searchResults: boolean = false;
  e2eStatus: string = "D";
  userRoles: string[] ;
  branches: string[] = ['Magarpatta','Koregaon','Chinchwad','Kharadi','Keshav Nagar','Pimpri','Kothrud','Khed','Khadki','Shivaji Nagar','Alandi'];
  isSearchResultFailed = false;
  isCreateBranchUserFailed = false;
  unitType: any;
  unitName: any;
  employeeId :any;
  clientId: any;
  clientTypeId: any;
  clientName: any;
  unitNames: any = [];
  employeeName: any;
  clientGroupId:any;
  
  constructor(private formBuilder: FormBuilder,
    private activatedroute: ActivatedRoute,
    private router: Router,
    private errorHandler: ErrorHandler, private slideToggle: MatSlideToggleModule, private referenceService: ReferenceService,
    private clientConfigurationService: ClientConfigurationService, private toastr: ToastrService, private authService: AuthService,
    private branchUserService: BranchUserService)  {
  }

  ngOnInit(): void {
    this.fetchUserData();
    this.searchUserForm = this.formBuilder.group({
      searchType: [''],
      searchKeyword: [''],
      clientTypeId: [''],
      clientId: [''],
      //unitType: [''],
      clientGroupId: [''],
      userRoleId: [''],
      unitName: ['']
    });
    this.branchUserListForm = this.formBuilder.group({
      userData: this.formBuilder.array([
        this.getUserData()
      ])
    });
    
    this.registerValues();
    this.registerValueChanges();
  }

  fetchUserData() {
    var clntId = '';
    forkJoin([this.authService.getUserInfo()])
      .subscribe(results => {
        if (results[0] && results[0].data) {
            console.log('User Info :',results[0].data);
	        this.clientId = results[0].data.clientId;
	        this.clientName = results[0].data.clientName;
	        this.clientTypeId = results[0].data.clientTypeId;
        }
      });
  }

  registerValues() {
    this.searchUserForm.get('searchType').valueChanges.subscribe(value => {
      this.searchUserForm.get('searchKeyword').reset();
      this.searchUserForm.get('clientTypeId').reset();
      this.searchUserForm.get('clientId').reset();
      this.searchUserForm.get('clientGroupId').reset();
      this.searchUserForm.get('userRoleId').reset();
      this.isSearchUserFailed = false;
      this.isUnitTypeSearch= false;
      //if(value!=null && value!='undefined' && value == 'unittypesearch') {
      //  this.isUnitTypeSearch= true;
      //  this.unitTypeOptions = [];
      //  this.referenceService.getReferenceUnitType().subscribe(result => {
      //    if (result && result.data) {
      //      this.unitTypeOptions = result.data;

      //    }
      //  });
        
      //} else {
      //  this.isUnitTypeSearch= false;
      //}
    });
  }
  
  registerValueChanges() {
    if(this.searchUserForm.get('clientTypeId') !=null && this.searchUserForm.get('clientTypeId').value != 'undefined') {
	    this.searchUserForm.get('clientTypeId').valueChanges.subscribe(clientTypeID => {
	      console.log("value", clientTypeID);
	      this.searchUserForm.get('clientGroupId').reset();
	      this.searchUserForm.get('clientId').reset();
	      this.searchUserForm.get('userRoleId').reset();
	      if (clientTypeID && clientTypeID !== undefined) {
	        this.clientOptions = [];
	        this.userRoleOptions = [];
	        this.clientConfigurationService.getClients(clientTypeID).subscribe(result => {
	          if (result && result.data) {
	            this.clientOptions = result.data;
	
	          }
	        });
	        this.referenceService.getReferenceuserRoles(clientTypeID).subscribe(result => {
	          if (result && result.data) {
	            this.userRoleOptions = result.data;
	          }
	        });
	      }
	    });
    }
    if(this.searchUserForm.get('clientId') !=null && this.searchUserForm.get('clientId').value != 'undefined') {
	    this.searchUserForm.get('clientId').valueChanges.subscribe(clientId => {
	      //console.log("value", clientId);
	      this.searchUserForm.get('clientGroupId').reset();
	      if (clientId && clientId !== undefined) {
	        this.clientGroupOptions = [];
	        this.referenceService.getReferenceClientGroup(clientId).subscribe(result => {
	          if (result && result.data) {
	            this.clientGroupOptions = result.data;
	          }
	        });
	        
	      }
	    });
	  }
  }
  
  
  private getUserData() {
    return this.formBuilder.group({
        clientGroupId: [''],
        unitName: [''],
        userRoleId :[''],
        employeeName: [''],
        employeeId: [''],
        userName :[''],
        updatedDate : [''],
        e2eStatus :['']
    });
  }
  
  // add new row
  addBranchUser() {
    const control = <FormArray>this.branchUserListForm.controls['userData'];
    control.push(this.getUserData());
  }
  getUserDataArrayControl() {
    return (this.branchUserListForm.get('userData') as FormArray).controls;
  }
  searchForm() {
    this.search = true;
    this.searchResults = false;
    this.isCreateBranchUserFailed = false;
  }
  performSearch() {
    let requestData = this.searchUserForm.value;
    let unitArrData: any = [];
    this.search = true;
    this.isSearchResultFailed = false;
    this.searchResults = false;
    requestData.clientId = this.clientId;
    (this.branchUserListForm.get('userData') as FormArray).clear();
    console.log('branch user: performSearch :'+requestData);
    this.branchUserService.getBranchUsers(requestData).subscribe(result => {
      console.log("result", result);
      
      if (result && result.data) {
        this.searchResults = true;
        result.data.forEach(eachData => {
          unitArrData.push({
            clientGroupId: eachData.clientGroupId,
            unitName: eachData.unitName,
            userRoleId :eachData.userRoleId,
            employeeName: eachData.employeeName,
            employeeId: eachData.employeeId,
            userName :eachData.userName,
            updatedDate : eachData.updatedDate,
            e2eStatus :eachData.e2eStatus
          });
        });
        unitArrData.forEach((eachArray, index) => {
          this.addBranchUser();
        });

      }
      console.log("unitArrData", unitArrData);
      this.branchUserListForm.patchValue({
        userData: unitArrData
      });
    },
    err => {
      console.log("err", err);
      this.errorMessage = err.error.errorMessage;
      this.searchResults = false;
      this.isSearchResultFailed = true;
    });
    
  }
  createForm() {
    this.router.navigate(['home', { outlets: { appcontent: ['create-branch-users',null] } }]);
  }

  openBranchUser(userName) {
    this.router.navigate(['home', {
      outlets: {
        appcontent: ['create-branch-users',userName]
      }
    }]);
  }
  
}