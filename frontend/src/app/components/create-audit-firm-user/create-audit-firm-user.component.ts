import { Component, OnInit } from '@angular/core';
import { FormArray,FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';
import { ReferenceService } from '../../services/reference-service/reference.service';
import { ClientConfigurationService } from '../../services/client-configuration/client-configuration.service';
import { CreateAuditFirmUserService } from '../../services/create-audit-firm-user/create-audit-firm-user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { forkJoin, Observable } from 'rxjs';
import { AuthService } from '../../services/auth-service/auth.service';
import { BranchUserService } from '../../services/branch-users/branch-users.service';

@Component({
  selector: 'app-create-audit-firm-user',
  templateUrl: './create-audit-firm-user.component.html',
  styleUrls: ['./create-audit-firm-user.component.scss']
})
export class createAuditFirmUserComponent implements OnInit {
  searchAuditUserForm: FormGroup;
  createAuditFirmForm: FormGroup;
  searchAuditFirmForm: FormGroup;
  isSearchFailed = false;
  clientTypeOptions: any = [];
  pageErrors: any = {};
  isError: boolean = false;
  isSuccess: boolean = false;
  errorMessage = '';
  search: boolean = true;
  isChecked: boolean = false;
  searchResults: boolean = false;
  cncStatus: string = "D";
  selectedUnit: any;
  isUserTypeSearch: boolean = false;
  isSearchUserFailed = false;
  clientOptions: any = [];
  clientGroupOptions: any = [];
  userRoleOptions: any = [];
  isSearchResultFailed = false;
  isCreateAuditFirmFailed = false;
  employeeName: any;
  userName: any;
  clientId: any;
  clientGroupId: any;
  clientName: any;
  clientTypesId: any;
  
  constructor(private formBuilder: FormBuilder,
    private activatedroute: ActivatedRoute,
    private router: Router,    
    private errorHandler: ErrorHandler, private slideToggle: MatSlideToggleModule, private referenceService: ReferenceService,
    private clientConfigurationService: ClientConfigurationService,private branchUserService: BranchUserService, private toastr: ToastrService,private authService: AuthService,
    private createAuditFirmUserService: CreateAuditFirmUserService) {
      //this.employeeName = this.activatedroute.snapshot.paramMap.get("employeeName");
      //this.userName = this.activatedroute.snapshot.paramMap.get("userName");
      //alert('Hello topp :'+this.employeeName + ' userName :'+this.userName);
  }

  ngOnInit(): void {
    this.activatedroute.params.subscribe(params => {this.loadAuditFirm(this.activatedroute.snapshot.paramMap.get("employeeName"),this.activatedroute.snapshot.paramMap.get("userName"));});
    this.createAuditFirmForm = this.formBuilder.group({
      userRoleId: [''],
      bankName: [''],
      employeeId: [''],
      employeeName: [''],
      employeeMail: [''],
      mobileNum: [''],
      userName: [''],
      password: [''],
      cncStatus: ['']
    });
    this.searchAuditFirmForm = this.formBuilder.group({
      searchType: [''],
      searchKeyword: [''],
      clientId: [''],
      clientGroupId: [''],
      userRoleId: ['']
    });
    
    this.searchAuditUserForm = this.formBuilder.group({
      auditFirmData: this.formBuilder.array([
        this.getAuditFirmData()
      ])
    });
    this.fetchUserData();
    this.registerValues();
    this.registerValueChanges();
  }
  
  fetchUserTypeData() {
      if(this.clientTypesId != '' && this.clientTypesId != null && this.clientTypesId != 'null' && this.clientTypesId != 'undefined') {
	    this.searchAuditFirmForm.get('clientGroupId').reset();
	    this.searchAuditFirmForm.get('clientId').reset();
	    this.searchAuditFirmForm.get('userRoleId').reset();
	      
        this.clientOptions = [];
        this.userRoleOptions = [];
        this.clientConfigurationService.getClients(this.clientTypesId).subscribe(result => {
          if (result && result.data) {
            this.clientOptions = result.data;

          }
        });
        this.referenceService.getReferenceuserRoles(this.clientTypesId).subscribe(result => {
          if (result && result.data) {
            this.userRoleOptions = result.data;
          }
        });
	   
    }
  }
  
  private getAuditFirmData() {
    return this.formBuilder.group({
        employeeName: [''],
        userName: [''],
        employeeId : [''],
        lastUpdatedBy : [''],
        updatedDate: ['']
    });
  }
  registerValues() {
    this.searchAuditFirmForm.get('searchType').valueChanges.subscribe(value => {
      this.searchAuditFirmForm.get('searchKeyword').reset();
      this.searchAuditFirmForm.get('clientId').reset();
      this.searchAuditFirmForm.get('clientGroupId').reset();
      this.searchAuditFirmForm.get('userRoleId').reset();
      this.isSearchUserFailed = false;
      if(value!=null && value!='undefined' && value == 'usertypesearch') {
        this.isUserTypeSearch= true;
     } else {
        this.isUserTypeSearch= false;
     }
    });
  }
  
  registerValueChanges() {
    
    if(this.searchAuditFirmForm.get('clientId') !=null && this.searchAuditFirmForm.get('clientId').value != 'undefined') {
	    this.searchAuditFirmForm.get('clientId').valueChanges.subscribe(clientId => {
	      console.log("value", clientId);
	      this.searchAuditFirmForm.get('clientGroupId').reset();
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
  
  loadAuditFirm(employeeName,userName) { 
    this.search = true;
    this.isSearchResultFailed = false;
    this.searchResults = false;
    
    if(employeeName!=null && employeeName!='undefined' && userName!=null && userName!='undefined') {
	    this.createAuditFirmUserService.getAuditFirmUser(employeeName,userName).subscribe(results => {
	    console.log("results", results);
	    if (results[0] && results[0].data) {
		    this.search = false;
		    //this.searchResults = true;
		    this.createAuditFirmForm.patchValue({
	          userRoleId: results.data.userRoleId,
		      employeeId: results.data.employeeId,
		      employeeName: results.data.employeeName,
		      employeeMail: results.data.employeeMail,
		      mobileNum: results.data.mobileNum,
		      userName: results.data.userName,
		      password: results.data.password,
		      cncStatus: results.data.cncStatus
		      }) 
	      } 
	    },
      err => {
        this.errorMessage = err.errorMessage;
        this.isSearchResultFailed = true;
        this.searchResults = false;
      });
    }
  }
  
  onChangeEmployeeId(e) {
    if(e.target.value!=null && e.target.value !='null' && e.target.value!=undefined) {
	    forkJoin([this.branchUserService.getEmployeeName(e.target.value)])
	      .subscribe(results => {
	        if (results[0] && results[0].data) {
	            console.log('User Info :',results[0].data);
	            this.employeeName = results[0].data.employeeName;
	       }
	      });
      }
  }
  // add new row
  addAuditFirmUser() {
    const control = <FormArray>this.searchAuditUserForm.controls['auditFirmData'];
    control.push(this.getAuditFirmData());
  }
  getAuditFirmUserDataArrayControl() {
    return (this.searchAuditUserForm.get('auditFirmData') as FormArray).controls;
  }
  toggleChanged() {
    this.isChecked = !this.isChecked;
    if(this.isChecked) {
      this.cncStatus = "A";
    } else {
      this.cncStatus = "D";
    }
  }
  performSearch() {
    let requestData = this.searchAuditFirmForm.value;
    let unitArrData: any = [];
    this.searchResults = false;
    this.isSearchResultFailed = false;
    //(this.searchAuditFirmForm.get('auditFirmData') as FormArray).clear();
    requestData.clientTypeId = this.clientTypesId;
    console.log('performSearch :'+requestData);
    this.createAuditFirmUserService.getAuditFirmUsers(requestData).subscribe(result => {
      console.log("result", result);

      if (result && result.data) {
        this.search = true;
        this.searchResults = true;
        result.data.forEach(eachData => {
          unitArrData.push({
            employeeName: eachData.employeeName,
            userName: eachData.userName,
            employeeId : eachData.employeeId,
            lastUpdatedBy : eachData.lastUpdatedBy,
            updatedDate: eachData.updatedDate
          });
        });
        unitArrData.forEach((eachArray, index) => {
          this.addAuditFirmUser();
        });

      }
      console.log("unitArrData", unitArrData);
      this.searchAuditUserForm.patchValue({
        auditFirmData: unitArrData
      });
      
    },
    err => {
      console.log("err", err);
      this.errorMessage = err.error.errorMessage;
      this.search = true;
      this.isSearchResultFailed = true;
      this.searchResults = false;
    });
    
  }

  fetchUserData() {
    var clntId = '';
    forkJoin([this.authService.getUserInfo()])
      .subscribe(results => {
        console.log('User Info :'+results[0].data);
        if (results[0] && results[0].data) {
            console.log('User Info :',results[0].data);
	        this.clientId = results[0].data.clientId;
	        this.clientName = results[0].data.clientName;
	        this.clientGroupId = results[0].data.clientGroupId;
	        this.clientTypesId = results[0].data.clientTypeId;
        }
        this.fetchUserTypeData();
      });
  }
  searchForm() {
    this.search = true;
    this.searchResults = false;
    this.isCreateAuditFirmFailed = false;
  }
  createForm() {
    this.search = false;
    this.searchResults = false;
    this.isSearchResultFailed= false;
    //this.clientTypesId = 3;
    //if(null!=this.clientTypesId && 'null'!=this.clientTypesId && undefined!=this.clientTypesId) {
    //    this.clientTypesId = parseInt(this.clientTypesId);
        this.referenceService.getReferenceuserRoles(3).subscribe(result => {
          if (result && result.data) {
            this.userRoleOptions = result.data;
          }
	   });
    //}
    
  }
  
  performSubmit() {
    const createAuditFirmRequestData: any = this.createAuditFirmForm.value;
    createAuditFirmRequestData.cncStatus = this.cncStatus;
    createAuditFirmRequestData.clientId = this.clientId;
    createAuditFirmRequestData.clientName = this.clientName;
    console.log("createAuditFirmRequestData :",createAuditFirmRequestData);
    this.createAuditFirmUserService.createAuditFirmUser(createAuditFirmRequestData).subscribe(result => {      
      console.log("createAuditFirmRsponseData", result);
      this.toastr.success('EmployeeName has been created successfully ' + createAuditFirmRequestData.employeeName, 'Information', {
      timeOut: 3000,
   	   });
   	   this.createAuditFirmForm.reset();
     },err => {
	    this.errorMessage = err.error.errorMessage;
	    this.isCreateAuditFirmFailed = true;
	  });
	
  }
  openAuditFirm(employeeName,userName) {
    this.router.navigate(['home', {
      outlets: {
        appcontent: ['create-audit-firm-user',employeeName,userName]
      }
    }]);
  }
}