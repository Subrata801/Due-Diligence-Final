import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute, Router } from '@angular/router';
import { ErrorHandler } from '../../error/error.handler';
import { AuthService } from '../../services/auth-service/auth.service';
import { ReferenceService } from '../../services/reference-service/reference.service';
import { ClientConfigurationService } from '../../services/client-configuration/client-configuration.service';
import { forkJoin } from 'rxjs';

@Component({
  selector: 'app-search-users',
  templateUrl: './search-users.component.html',
  styleUrls: ['./search-users.component.scss']
})
export class SearchUsersComponent implements OnInit {

  updateUserForm: FormGroup;
  addUserForm: FormGroup;
  searchUserForm: FormGroup;
  pageErrors: any = {};
  showHeader: boolean = true;
  errorMessage = '';
  isSearchUserFailed = false;
  isSearchFailed = false;
  clientTypeOptions: any = [];
  clientOptions: any = [];
  clientGroupOptions: any = [];
  userRoleOptions: any = [];
  isUserTypeSearch: boolean = false;
  constructor(private formBuilder: FormBuilder, private errorHandler: ErrorHandler, private toastr: ToastrService,
    private clientConfigurationService: ClientConfigurationService, private referenceService: ReferenceService,
    private authService: AuthService, private router: Router) {
  }

  ngOnInit(): void {
    this.searchUserForm = this.formBuilder.group({
      keywordType: [''],
      keyword: [''],
      clientTypeId: [''],
      clientId: [''],
      clientGroupId: [''],
      userRoleId: ['']
    });
    this.addUserForm = this.formBuilder.group({
      userName: [''],
      fullName: [''],
      email: [''],
      mobileNumber: [''],
      userStatus: [''],
      userId:['']
    });
    this.updateUserForm = this.formBuilder.group({
      userData: this.formBuilder.array([
        this.getUserData()
      ])
    });
    this.fetchPageData();
    this.errorHandler.handleErrors(this.searchUserForm, this.pageErrors);
    this.registerValues();
    this.registerValueChanges();
  }

  fetchPageData() {
    (this.updateUserForm.get('userData') as FormArray).clear();
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

  getUserDataArrayControl() {
    return (this.updateUserForm.get('userData') as FormArray).controls;
  }

  // now we create some service methods for create, add and remove 
  // row inside form
  // create form row.
  private getUserData() {
    return this.formBuilder.group({
      userName: [''],
      fullName: [''],
      email: [''],
      mobileNumber: [''],
      userStatus: [''],
      userId:['']
    });
  }

  // add new row
  addUnit() {
    const control = <FormArray>this.updateUserForm.controls['userData'];
    control.push(this.getUserData());
  }

  registerValues() {
    this.searchUserForm.get('keywordType').valueChanges.subscribe(value => {
      this.searchUserForm.get('keyword').reset();
      this.searchUserForm.get('clientTypeId').reset();
      this.searchUserForm.get('clientId').reset();
      this.searchUserForm.get('clientGroupId').reset();
      this.searchUserForm.get('userRoleId').reset();
      this.isSearchUserFailed = false;
      (this.updateUserForm.get('userData') as FormArray).clear();
      if(value!=null && value!='undefined' && value == 'usertypesearch') {
         this.isUserTypeSearch= true;
         this.fetchData();
      } else {
         this.isUserTypeSearch= false;
      }
    });
    
  }

 fetchData() {
    forkJoin([this.referenceService.getReferenceClientTypes()])
      .subscribe(results => {
        //console.log("results", results);
        if (results) {
          if (results[0] && results[0].data) {
            this.clientTypeOptions = results[0].data;
          }
        }
      });
  }
  performSearch() {
    let requestData = this.searchUserForm.value;
    let userArrData: any = [];
    this.isSearchUserFailed = false;
    this.isSearchFailed = false;
    (this.updateUserForm.get('userData') as FormArray).clear();
 
    this.authService.searchUser(requestData).subscribe(result => {
      console.log("result", result);

      if (result && result.data) {
        result.data.forEach(eachData => {
          userArrData.push({
            userName: eachData.userName,
            fullName: eachData.fullName,
            email: eachData.email,
            mobileNumber: eachData.mobileNumber,
            userStatus: eachData.userStatus,
            userId :eachData.userId
          });
        });
        userArrData.forEach((eachArray, index) => {
          this.addUnit();
        });

      }
      console.log("userArrData", userArrData);
      this.updateUserForm.patchValue({
        userData: userArrData
      });
    },
    err => {
      console.log("err", err);
      this.errorMessage = err.error.errorMessage;
      this.isSearchUserFailed = true;
      this.isSearchFailed = false;
    });
  }
  
  addNewUser() {
    this.router.navigate(['home', {
      outlets: {
        appcontent: ['user',null]
      }
    }]);
  }
  
  openUser(userId) {
    this.router.navigate(['home', {
      outlets: {
        appcontent: ['user',userId]
      }
    }]);
  }

}
