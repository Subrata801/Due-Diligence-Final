import { Component, OnInit } from '@angular/core';
import { FormArray,FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';
import { ClientConfigurationService } from '../../services/client-configuration/client-configuration.service';
import { BranchUserService  } from '../../services/branch-users/branch-users.service';
import {HeaderService} from '../../services/header/header.service';
import { AuthService } from '../../services/auth-service/auth.service';
import { forkJoin, Observable } from 'rxjs';


@Component({
  selector: 'app-risk-customization',
  templateUrl: './risk-customization.component.html',
  styleUrls: ['./risk-customization.component.scss']
})
export class RiskCustomizationComponent implements OnInit {
  searchResultRiskForm: FormGroup;
  riskScoreForm: FormGroup;
  pageErrors: any = {};
  isError: boolean = false;
  isSuccess: boolean = false;
  errorMessage = '';
  clientOptions: any = [];
  auditFirmOptions: any = [];
  clientId: any;
  clientName:any;
  isClientTypeAuditFirm: boolean = false;
  isClientTypeBank: boolean = false;
  showCategory: boolean = false;
  showSearchResults: boolean = false;
  isSearchResultFailed: boolean = false;
  isEditGeneralScore: boolean = false;
  isEditApplicantScore: boolean = false;
  isEditCoApplicantScore: boolean = false;
  isEditGuarantorScore: boolean = false;
  
  constructor(private formBuilder: FormBuilder,
    private errorHandler: ErrorHandler,private headerService:HeaderService,private clientConfigurationService: ClientConfigurationService, private authService: AuthService,private branchUserService: BranchUserService,private datepicker: MatDatepickerModule,
    private toastrService: ToastrService) {
  }

  ngOnInit(): void {
    this.riskScoreForm = this.formBuilder.group({
      clientTypeId: [''],
      selectedFirm: [''],
      selectedBank: [''],
      selectedCategory: ['']
    });
    this.registerValueChanges();
    this.searchResultRiskForm = this.formBuilder.group({
      riskScoreList: this.formBuilder.array([
        this.getRiskData()
      ])
    });
  }
  private getRiskData() {
    return this.formBuilder.group({
        responseId: [''],
	    responseKey: [''],
	    responseDesc: [''],
	    colorCode: [''],
	    generalScore: [''],
	    applicantScore :[''],
	    coApplicantScore :[''],
	    guarantorScore :['']
    });
  }
  
  // add new row
  addRiskData() {
    const control = <FormArray>this.searchResultRiskForm.controls['riskScoreList'];
    control.push(this.getRiskData());
  }
  getRiskDataArrayControl() {
    return (this.searchResultRiskForm.get('riskScoreList') as FormArray).controls;
  }
  loadRiskData(clientTypeId:any,clientId:any,firmId:any) {
    //let requestData = this.searchResultRiskForm.value;
    let unitArrData: any = [];
    this.headerService.getRiskData(clientTypeId,clientId,firmId).subscribe(result => {
      console.log("result", result);
      //this.searchResults = true;
      if (result && result.data) {
        result.data.forEach(eachData => {
          unitArrData.push({
            responseId: eachData.responseId,
            responseKey: eachData.responseKey,
            responseDesc: eachData.responseDesc,
            colorCode: eachData.colorCode,
            generalScore: eachData.generalScore,
            applicantScore: eachData.applicantScore,
            coApplicantScore :eachData.coApplicantScore,
            guarantorScore : eachData.guarantorScore
          });
        });
        (this.searchResultRiskForm.get('riskScoreList') as FormArray).clear();
        unitArrData.forEach((eachArray, index) => {
          this.addRiskData();
        });
        this.isSearchResultFailed = false;
        this.showSearchResults = true;
      }
      console.log("unitArrData", unitArrData);
      this.searchResultRiskForm.patchValue({
        riskScoreList: unitArrData
      });
    },
    err => {
      console.log("err", err);
      this.errorMessage = err.error.errorMessage;
      this.isSearchResultFailed = true;
      this.showSearchResults = false;
    });
    
  }
  selectBank() {
    console.log("selectBank :: ");
  }
  selectFirm() {
    console.log("selectFirm :: ");
  }
  
  registerValueChanges() {
    this.riskScoreForm.get('clientTypeId').valueChanges.subscribe(clientTypeID => {
	      console.log("value", clientTypeID);
	      this.riskScoreForm.get('selectedFirm').reset();
	      this.riskScoreForm.get('selectedBank').reset();
	      this.riskScoreForm.get('selectedCategory').reset();
	      this.showSearchResults = false;
	      this.isEditGeneralScore = false;
	      this.isEditApplicantScore = false;
	      this.isEditCoApplicantScore = false;
	      this.isEditGuarantorScore = false;
	      if (clientTypeID && clientTypeID !== undefined) {
	        this.clientOptions = [];
	        if(clientTypeID ==2) {
	            this.isClientTypeAuditFirm = false;
	            this.isClientTypeBank = true;
	            this.showCategory = true;
		        this.clientConfigurationService.getClient(clientTypeID).subscribe(result => {
		          if (result && result.data) {
		            this.clientOptions = result.data;
		          }
		        });
	        }
	        if(clientTypeID ==3) {
	            this.isClientTypeAuditFirm = true;
	            this.isClientTypeBank = false;
	            this.showCategory = true;
	            this.clientConfigurationService.getClient(clientTypeID).subscribe(result => {
		          if (result && result.data) {
		            this.clientOptions = result.data;
		          }
		        });
	          
	        }
	      }
	    });
	   
      this.riskScoreForm.get('selectedBank').valueChanges.subscribe(clientId => {
        if(this.riskScoreForm.get('clientTypeId').value ==2 && null!=clientId) { 	   
         this.loadRiskData(this.riskScoreForm.get('clientTypeId').value,clientId,null);
        }
        if(this.riskScoreForm.get('clientTypeId').value ==3) { 
          var clientID = -1;
		  var firmId = clientId;
           this.riskScoreForm.get('selectedFirm').valueChanges.subscribe(clientId => {	   
		      clientID = clientId;
		   });
		   if(clientID ==-1) {
		     clientID = this.riskScoreForm.get('selectedFirm').value;
		   }
		   if(firmId!=null && null!=clientID) {
		  	 this.loadRiskData(this.riskScoreForm.get('clientTypeId').value,clientID,firmId);
		   }
          }
        });
       this.riskScoreForm.get('selectedFirm').valueChanges.subscribe(clientId => {
	      this.riskScoreForm.get('selectedBank').reset();
	      if (clientId && clientId !== undefined) {
	        this.auditFirmOptions = [];
	         this.branchUserService.getUnitNames(this.riskScoreForm.get('selectedFirm').value).subscribe(result => {
		          if (result && result.data) {
		            this.auditFirmOptions = result.data;
		          }
		     });
	        
	      }
	   });
	  this.riskScoreForm.get('selectedCategory').valueChanges.subscribe(categoryId => {
	      console.log("value", categoryId);
	       if (categoryId && categoryId !== undefined) {
	          if(categoryId ==1) {
	             this.isEditGeneralScore = true;
	             this.isEditApplicantScore = false;
			     this.isEditCoApplicantScore = false;
			     this.isEditGuarantorScore = false;
	          } else if(categoryId ==2) {
	             this.isEditGeneralScore = false;
	             this.isEditApplicantScore = true;
			     this.isEditCoApplicantScore = false;
			     this.isEditGuarantorScore = false;
	          } else if(categoryId ==3) {
	             this.isEditGeneralScore = false;
	             this.isEditApplicantScore = false;
			     this.isEditCoApplicantScore = true;
			     this.isEditGuarantorScore = false;
	          } else if(categoryId ==4) {
	             this.isEditGeneralScore = false;
	             this.isEditApplicantScore = false;
			     this.isEditCoApplicantScore = false;
			     this.isEditGuarantorScore = true;
	          }
	       }
	    });
  }
  
  performSubmit() {
    this.clearAllErrors();
    let searchResultRequestData = this.searchResultRiskForm.value;
    let riskFormRequestData = this.riskScoreForm.value;
    
    searchResultRequestData.clientTypeId = riskFormRequestData.clientTypeId;
    
    searchResultRequestData.categoryId=riskFormRequestData.selectedCategory;
    
    if(riskFormRequestData.clientTypeId ==3) {
    	searchResultRequestData.clientId = riskFormRequestData.selectedFirm;
    } else if(riskFormRequestData.clientTypeId ==2) {
       searchResultRequestData.clientId = riskFormRequestData.selectedBank;
    }
    
    if(riskFormRequestData.clientTypeId ==3) {
    	searchResultRequestData.clientGroupId= riskFormRequestData.selectedBank;
    } else {
       searchResultRequestData.clientGroupId= -1;
    }
    
    this.headerService.saveRiskData(searchResultRequestData).subscribe((results: any) => {
      if (!results.metaData.success) {
        this.errorMessage = results.metaData.description;
      } else {
        this.toastrService.success('This risk data is saved Successfully', 'Information', {
          timeOut: 3000,
        });
      }
    },
      err => {
        this.isSearchResultFailed=true;
        this.errorMessage = err.error.errorMessage;
      }
    );
  }
  
  clearAllErrors() {
    this.errorMessage = "";
  }
}