import { Component, OnInit } from '@angular/core';
import { FormArray,FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';
import { InitiateDueDiligenceService} from '../../services/initiate-due-diligence/initiate-due-diligence.service';
import { AuthService } from '../../services/auth-service/auth.service';
import { forkJoin, Observable } from 'rxjs';
import { Router } from '@angular/router';


@Component({
  selector: 'app-initiate-audit',
  templateUrl: './initiate-audit.component.html',
  styleUrls: ['./initiate-audit.component.scss']
})
export class initiateAuditComponent implements OnInit {
  
  initiateAuditForm: FormGroup;
  pageErrors: any = {};
  isError: boolean = false;
  isSuccess: boolean = false;
  errorMessage = '';
  search: boolean = true;
  isChecked: boolean = false;
  searchResults: boolean = false;
  status: string = "Inactive";
  selectedUnit: any;
  clientId: any;
  clientGroupId: any;
  clientName: any;
  isInitiateAuditDueDeligenceFailed: boolean = false;
  auditCheckerOptions: any = [];
  accountTypeOptions: any = [];
  borrowerTypeOptions: any = [];
  loanSchemeOptions: any = [];
  loanVariantOptions: any = [];
  branchOptions: any = [];
  borrowerCategoryOptions: any = [];
  loanSchemeFacilitiesOptions: any = [];
  creditSectorType:any;
  loanSchemeId:any;
  movablePropertyTypesList: string[] = [];

  constructor(private formBuilder: FormBuilder,
    private errorHandler: ErrorHandler, private slideToggle: MatSlideToggleModule,
    private toastrService: ToastrService,private authService: AuthService,
    private initiateDueDiligenceService: InitiateDueDiligenceService, private router: Router) {
  }

  ngOnInit(): void {
    this.initiateAuditForm = this.formBuilder.group({
      selectModule: [''],
      cncNumber: [''],
      cncDate: [''],
      selectIFSCCode: [''],
      branchName: [''],
      ifscCode: [''],
      auditChecker: [''],
      auditController: [''],
      borrowerName: [''],
      cifNumber: [''],
      creditSectorId: [''],
      loanSchemeId:[''],
      loanVariantId:[''],
      loanAccountNum: [''],
      sanctionDate: [''],
      sanctionAmount: [''],
      sanctionAmountWords: [''],
      loanTenor: [''],
      accountStatus: [''],
      releaseOfSecurity: [''],
      dateOfclosure: [''],
      typeOfAuditAccount: [''],
      typeOfBorrower: [''],
      borrowerCategory: [''],
      security: [''],
      typeOfSecurity: [''],
      movablePropertyTypes: [''],
      assignAuditFirmChecker: [''],
      assignAuditFirmControllingAuthority: [''],
      closureDate: [''],
      comments: [''],
      nameOfCoApplicant1:[''],
      nameOfCoApplicant2:[''],
      nameOfCoApplicant3:[''],
      nameOfCoApplicant4:[''],
      nameOfCoApplicant5:[''],
      
      designation1:[''],
      designation2:[''],
      designation3:[''],
      designation4:[''],
      designation5:[''],
      guarantor:[''],
      nameOfGuarantor1:[''],
      nameOfGuarantor2:[''],
      nameOfGuarantor3:[''],
      nameOfGuarantor4:[''],
      collateralSecurityTypeId:[''],  
      facilityDetails: this.formBuilder.array([
        this.getLoanScheme()
      ])
    });
    this.fetchUserData();
    this.registerValueChanges();
    
  }
  
  getLoanScheme() {
    return this.formBuilder.group({
      loanSchemeFacilities: [''],
      accountNum: [''],
      dateOfSanction: [''],
      sanctionedLimit:[''],
      sanctionedLimitWords:[''],
      loanTenor:['']
    });
  }
  // add new row
  addFacilityDetails() {
    const control = <FormArray>this.initiateAuditForm.controls['facilityDetails'];
    control.push(this.getLoanScheme());
  }
  getCommercialFacilitiesArrayControl() {
    return (this.initiateAuditForm.get('facilityDetails') as FormArray).controls;
  }
  // remove row
  removeFacility(i: number) {
    const control = <FormArray>this.initiateAuditForm.controls['facilityDetails'];
    
    let facilityDetailsFromUI = this.getCommercialFacilitiesArrayControl()[i].value;
    //var clntGroupId = -1;
    //if(this.clientTypeId==3){
    //   clntGroupId = facilityDetailsFromUI.clientGroupId;
    //}
    if(facilityDetailsFromUI.action != 'add'){
      let reqData: any;
      reqData = {
        clientId: this.clientId,
      }

      let facilityDetails = this.getCommercialFacilitiesArrayControl()[i].value;
      let facilityDetailsArr = [];
      facilityDetailsArr.push(facilityDetails);
      reqData.facilityDetails = facilityDetailsArr;
      
      
      this.initiateDueDiligenceService.deleteCommercialFacility(reqData).subscribe(result=>{
        console.log("result",result);
        this.toastrService.success('Commercial Facility deleted successfully', 'Information', {
          timeOut: 3000,
        });
      },
      err => {
        console.log("err",err);
        this.toastrService.error('Unable to delete commercial facility', 'Information', {
          timeOut: 3000,
        });       
      });
    }
    control.removeAt(i);
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
        }
        this.fetchAllDropDownData();
      });
  }
 
  fetchAllDropDownData() {
        this.auditCheckerOptions = [];
        this.accountTypeOptions = [];
        this.borrowerTypeOptions=[];
        this.branchOptions=[];
        this.borrowerCategoryOptions = [];
        this.movablePropertyTypesList = [];
        this.initiateDueDiligenceService.getListOfBranchNames(this.clientId).subscribe(result => {
          if (result && result.data) {
            this.branchOptions = result.data;

          }
        });
        
        this.initiateDueDiligenceService.getListOfAuditFirmChecker(this.clientId).subscribe(result => {
          if (result && result.data) {
            this.auditCheckerOptions = result.data;

          }
        });
        this.initiateDueDiligenceService.getListOfAccountTypes().subscribe(result => {
          if (result && result.data) {
            this.accountTypeOptions = result.data;
          }
        });
        this.initiateDueDiligenceService.getListOfBorrowerCategory().subscribe(result => {
          if (result && result.data) {
            this.borrowerCategoryOptions = result.data;
          }
        });
        this.initiateDueDiligenceService.getListOfBorrowerTypes().subscribe(result => {
          if (result && result.data) {
            this.borrowerTypeOptions = result.data;
          }
        });
        
        this.initiateDueDiligenceService.getListOfMovableProperties().subscribe(result => {
          if (result && result.data) {
            this.movablePropertyTypesList = result.data;

          }
        });
        
  }
  registerValueChanges() {
     this.creditSectorType = this.initiateAuditForm.get('creditSectorId').value;
     if(this.creditSectorType!='' && this.creditSectorType!=undefined){
	    this.initiateAuditForm.get('loanSchemeId').valueChanges.subscribe(creditSector => {
	      if (creditSector && creditSector !== undefined) {
	        this.loanSchemeOptions = [];
	        this.initiateDueDiligenceService.getListOfLoanSchemes('Audit',this.initiateAuditForm.get('branchName').value,this.creditSectorType,this.clientId).subscribe(result => {
	          if (result && result.data) {
	            this.loanSchemeOptions = result.data;
	          }
	        });
	    
	      }
	    });
	   }
	   this.loanSchemeId = this.initiateAuditForm.get('loanSchemeId').value
	   if(this.loanSchemeId!='' && this.loanSchemeId!=undefined){
	    this.initiateAuditForm.get('loanSchemeId').valueChanges.subscribe(loanScheme => {
	        this.loanVariantOptions = [];
	        this.initiateDueDiligenceService.getListOfLoanVariants('Audit',this.loanSchemeId,this.clientId).subscribe(result => {
	          if (result && result.data) {
	            this.loanVariantOptions = result.data;
	          }
	        });
	    
	    });
	     
        this.initiateDueDiligenceService.getListOfLoanSchemeFacilities(this.loanSchemeId).subscribe(result => {
          this.loanSchemeFacilitiesOptions = [];
          if (result && result.data) {
            this.loanSchemeFacilitiesOptions = result.data;
          }
        });
	   }
   }
   
   loadCommercialFacilities() {
     this.initiateDueDiligenceService.getListOfCommercialCreditFacilities
         (this.initiateAuditForm.get('cncNumber').value).subscribe((results: any) => {
       if (results && results.data && results.data.length > 0) {
          let loanScheme: [] = results.data;
          (this.initiateAuditForm.get('facilityDetails') as FormArray).clear();
          const facilityDetailsControl = <FormArray>this.initiateAuditForm.controls['facilityDetails'];
          if (loanScheme.length > 0) {
            loanScheme.forEach((eachLoanScheme: any) => {
              facilityDetailsControl.push(this.formBuilder.group({
                  loanSchemeFacilities: eachLoanScheme.facility,
                  accountNum: eachLoanScheme.accountNum,
			      dateOfSanction: eachLoanScheme.dateOfSanction,
			      sanctionedLimit:eachLoanScheme.sanctionedLimit,
			      sanctionedLimitWords:eachLoanScheme.sanctionedLimitWords,
			      loanTenor:eachLoanScheme.loanTenor
              }));
            });
            
            this.initiateAuditForm.setControl('facilityDetails', facilityDetailsControl);
          }
        }
     });
  
  }
  performSubmit() {
    const initiateDueDeligenceRequestData: any = this.initiateAuditForm.value;
    
    
    console.log("initiateDueDeligenceRequestData : ",initiateDueDeligenceRequestData);
    this.initiateDueDiligenceService.processDueDiligenceForAudit(initiateDueDeligenceRequestData).subscribe(result => {      
      console.log("initiateAuditDueDeligenceResponseData", result);
      this.toastrService.success('InitiateAuditDueDeligence has been created successfully ' + initiateDueDeligenceRequestData.cncNumber, 'Information', {
      timeOut: 3000,
   	   });
   	   this.initiateAuditForm.reset();
     },err => {
	    this.errorMessage = err.error.errorMessage;
	    this.isInitiateAuditDueDeligenceFailed = true;
	  });
	
  }
  viewReport() {
    this.router.navigate(['home', {
      outlets: {
        appcontent: ['due-diligence-non-compliant']
      }
    }]);
  }

  back() {
    console.log("Back to Headers");
    this.router.navigate(['home', {
      outlets: {
        appcontent: ['view-due-diligence']
      }
    }]);
  }

  viewDD() {
    console.log("Back to Headers");
    this.router.navigate(['home', {
      outlets: {
        appcontent: ['view-due-diligence']
      }
    }]);
  }
 
}