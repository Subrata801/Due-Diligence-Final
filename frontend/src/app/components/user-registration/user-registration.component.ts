import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { forkJoin } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { ConfirmationDialogData } from '../confirmation-dialog/confirmation-dialog-data';
import { ConfirmationDialogComponent } from '../confirmation-dialog/confirmation-dialog.component';
import { ErrorHandler } from '../../error/error.handler';
import { AuthService } from '../../services/auth-service/auth.service';
import { ClientConfigurationService } from '../../services/client-configuration/client-configuration.service';
import { Constants } from '../../services/common/constants';
import { ReferenceService } from '../../services/reference-service/reference.service';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.scss']
})
export class UserRegistrationComponent implements OnInit {

  userRegistrationForm: FormGroup;
  pageErrors: any = {};
  isError: boolean = false;
  isSuccess: boolean = false;
  errorMessage = '';
  userId: any;
  clientTypeOptions: any = [];
  clientOptions: any = [];
  clientGroupOptions: any = [];
  userRoleOptions: any = [];
  customIntegerValueOptions: any[] = Constants.customIntegerValueOptions;
  customOptions: any[] = Constants.customOptions;

  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private errorHandler: ErrorHandler,
    private referenceService: ReferenceService,
    public dialog: MatDialog,
    private activatedroute: ActivatedRoute,
    private clientConfigurationService: ClientConfigurationService,
    private authService: AuthService) {
      this.userId = this.activatedroute.snapshot.paramMap.get("userId");
    }
  


  page_error_messages = {
    clientTypeId: 'User Type is required',
    clientId: 'Client is required',
    clientGroupId : 'Client group is required',
    userRoleId: 'User Role is required',
    fullName: 'Full Name is required',
    email: 'Email is required',
    userName: 'User Name is required',
    mobileNum: 'User Name is required',
    password: 'Password is required',
    userStatus: 'Status is required'
  };

  ngOnInit(): void {
    this.fetchData();
    
    this.userRegistrationForm = this.formBuilder.group({
      clientTypeId: [''],
      clientId: [''],
      clientGroupId: [''],
      clientName: [''],
      userRoleId: [''],
      employeeId: [''],
      fullName: [''],
      email: [''],
      userName: [''],
      mobileNum: [''],
      password: [''],
      userStatus: ['']
    });
    //this.errorHandler.handleErrors(this.userRegistrationForm, this.pageErrors);
    this.registerValueChanges();
    if(this.userId!=null && this.userId!='' && this.userId != 'undefined' && this.userId!='null') {
       this.getUserInfo(this.userId);
    }
  }

  clearAllData() {
      this.isSuccess= false;
      this.userRegistrationForm.reset();
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
  
  getUserInfo(userId) {
    this.authService.getUser('useridsearch',userId).subscribe((results: any) => {
        console.log("results", results.data[0]);
        if (!results.metaData.success) {
          this.isError = true;
          this.errorMessage = results.metaData.description;
        } else {
   
           if (results && results.data[0]) {
              this.userRegistrationForm.patchValue({
                clientTypeId: results.data[0].clientTypeId,
                clientId: results.data[0].clientId,
                clientGroupId: results.data[0].clientGroupId,
                userRoleId: results.data[0].userRoleId,
                employeeId: results.data[0].employeeId,
                fullName: results.data[0].fullName,
                email: results.data[0].email,
                mobileNum: results.data[0].mobileNumber,
                userName: results.data[0].userName,
                userStatus : results.data[0].userStatus
              });
         }
       }
    },
	err => {
	  this.errorMessage = err.error.errorMessage;
	  this.isError = true;
	});
 }

  registerValueChanges() {
    this.userRegistrationForm.get('clientTypeId').valueChanges.subscribe(clientTypeID => {
      console.log("value", clientTypeID);
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
    this.userRegistrationForm.get('clientId').valueChanges.subscribe(clientId => {
      //console.log("value", clientId);
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

  performSubmit() {
    const formData: any = this.userRegistrationForm.value;
    formData.clientName = "BankerMitra";
	    this.authService.signUp(formData,this.userId).subscribe((result: any) => {
	      this.isError = false;
	      this.isSuccess = false;
	      if (result && result.metaData) {
	        if (!result.metaData.success) {
	          this.isError = true;
	          this.errorMessage = result.data.messageDescription;
	        } else {
	          this.isSuccess =true;
	        }
	      }
	
	    },
	      err => {
	        this.errorMessage = err.error.errorMessage;
	        this.isError = true;
	      });
  
  }

  /*
  /auth/signup
pass userTypeId,clientTypeId,clientId,clientName,userRoleId,employeeId,fullName,email,mobileNum,password,userStatus
  */

  openConfirmationDialog(data: ConfirmationDialogData): void {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      width: '250px',
      data: data
    });

    dialogRef.afterClosed().subscribe(res => {
      if (res && res === "reload") {
        window.location.reload();
      }
    });
  }

  goBackToSearchScreen() {
    this.router.navigate(['home', { outlets: { appcontent: ['search-users'] } }]);
  }

}

