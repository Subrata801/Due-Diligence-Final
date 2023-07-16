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
  selector: 'app-create-branch-users',
  templateUrl: './create-branch-users.component.html',
  styleUrls: ['./create-branch-users.component.scss']
})
export class CreateBranchUsersComponent implements OnInit {
  branchUsersForm: FormGroup;
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
  isEditUser: boolean = false;
  errorMessage = '';
  isChecked: boolean = false;
  e2eStatus: string = "D";
  userRoles: string[] ;
  isSearchResultFailed = false;
  isCreateBranchUserFailed = false;
  unitType: any;
  unitName: any;
  employeeId :any;
  clientId: any;
  clientTypeId: any;
  clientName: string;
  unitNames: any = [];
  employeeName: any='';
  uName:any='';
  uPassword:any='';
  clientGroupId:any;
  
  constructor(private formBuilder: FormBuilder,
    private activatedroute: ActivatedRoute,
    private router: Router,
    private errorHandler: ErrorHandler, private slideToggle: MatSlideToggleModule, private referenceService: ReferenceService,
    private clientConfigurationService: ClientConfigurationService, private toastr: ToastrService, private authService: AuthService,
    private branchUserService: BranchUserService)  {
      this.clientGroupId = this.activatedroute.snapshot.paramMap.get("clientGroupId");
  }

  ngOnInit(): void {
    this.fetchUserData();
    this.branchUsersForm = this.formBuilder.group({
      clientType: [''],
      clientFirm: [''],
      clientBranch: [''],
      unitName: [''],
      userRoleId: [''],
      employeeId: [''],
      employeeName: [''],
      userName: [''],
      password: [''],
      e2eStatus: ['']
    });
    this.registerValueChanges();
    if(this.clientGroupId!=null && this.clientGroupId!='null') {
   		 this.loadBranchUser(this.clientGroupId);
    }
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
        this.loadUnitName(this.clientId);
      });
  }
  loadBranchUser(clientGroupId) { 
    console.log('loadBranchUser:clientGroupId:'+clientGroupId);
    if(clientGroupId!=null && clientGroupId!='null' && clientGroupId!=undefined) {
        this.isEditUser = true;
	    this.branchUserService.getBranchUser(clientGroupId).subscribe(results => {
	    console.log("results :: load branch user", results);
      this.uName=results.data.userName;
      this.uPassword = results.data.password;
      this.employeeName = results.data.employeeName;
      this.employeeId = results.data.employeeId;
	    this.branchUsersForm.patchValue({
            unitName: results.data.clientGroupId,
            userRoleId: results.data.userRoleId,
            // employeeName: results.data.employeeName,
            // employeeId: results.data.employeeId,
            // userName: results.data.userName,
            // password: results.data.password,
            e2eStatus :results.data.e2eStatus
	      })  
	    },
      err => {
        this.errorMessage = err.errorMessage;
        this.isSearchResultFailed = true;
        this.isCreateBranchUserFailed = true;
      });
    }
  }
  loadUnitName(clientId:any) {
    this.branchUserService.getUnitNames(clientId).subscribe(result => {
      if (result && result.data) {
        this.unitNames = result.data;
      }
    });
  }
  
  registerValueChanges() {
    
	if(this.branchUsersForm.get('unitName') !=null && this.branchUsersForm.get('unitName').value != 'undefined') {
	    this.branchUsersForm.get('unitName').valueChanges.subscribe(unitName => {
	      //console.log("value", clientId);
	      if (unitName && unitName !== undefined) {
	        this.clientGroupOptions = [];
	        this.branchUserService.getUserRoles(unitName).subscribe(result => {
	          if (result && result.data) {
              console.log("user roles based on unitName :", result.data);
	            this.userRoles = result.data;
	          }
	        });
	      }
	    });
	  }
  }
  
  onChangeEmployeeId(e) {
    let empId = e.target.value;
    let clientPrefix = (this.clientName!=null && this.clientName!=undefined && 
            this.clientName.split(" ").length>1)?this.clientName.split(" ")[0]:'';
    if(e.target.value!=null && e.target.value !='null' && e.target.value!=undefined) {
	    forkJoin([this.branchUserService.getEmployeeName(e.target.value)])
	      .subscribe(results => {
	        if (results[0] && results[0].data && results[0].data[0]) {
              this.isCreateBranchUserFailed = false;
              this.errorMessage = '';
	            console.log('User Info :',results[0].data);
	            this.employeeName = results[0].data[0].employeeName;
              this.uName = clientPrefix+"_"+empId;
              this.uPassword = empId;
              console.log('this.employeeName:'+this.employeeName);
	       } else{
          console.log('onChangeEmployeeId: no employee found for this empId:'+empId);
          this.errorMessage = 'No employee found';
          this.isCreateBranchUserFailed = true;
  
          this.uName='';
          this.uPassword='';
         }
	      });
      }

      // if(this.employeeName==''|| this.employeeName==null || this.employeeName==undefined) {
      //   console.log('onChangeEmployeeId: no employee found for this empId:'+empId);
      //   this.errorMessage = 'No employee found';
	    //   this.isCreateBranchUserFailed = true;

      //   this.uName='';
      //   this.uPassword='';
      // }
  }

  toggleChanged() {
    this.isChecked = !this.isChecked;
    if(this.isChecked) {
      this.e2eStatus = "A";
    } else {
      this.e2eStatus = "D";
    }
  }
  
  searchForm() {
    this.router.navigate(['home', { outlets: { appcontent: ['branch-users',null] } }]);
  }
  
  performSubmit() {
    let successMessage = '';
    const branchUserRequestData: any = this.branchUsersForm.value;
    //branchUserRequestData.e2eStatus = this.e2eStatus;
    //branchUserRequestData.userRoleId=2;
    branchUserRequestData.clientId = this.clientId;
    branchUserRequestData.clientName = this.clientName;
    branchUserRequestData.isEditUser = this.isEditUser;
    branchUserRequestData.employeeName = this.employeeName;
    branchUserRequestData.userName = this.uName;
    branchUserRequestData.password = this.uPassword;

    if(this.isEditUser) {
      successMessage = 'Branch User details has been updated successfully';
      branchUserRequestData.employeeId = this.employeeId;
    } else {
      successMessage = 'Branch User has been created successfully';
    }
    
    

    console.log("branchUserRequestData : ",branchUserRequestData);
    this.branchUserService.createBranchUser(branchUserRequestData).subscribe(result => {      
      console.log("branchUserResponseData", result);
      this.isCreateBranchUserFailed = false;
      this.toastr.success(successMessage, 'Information', {
      timeOut: 3000,
   	   });
     },err => {
	    this.errorMessage = err.error.errorMessage;
	    this.isCreateBranchUserFailed = true;
	  });
	
  }
  
}