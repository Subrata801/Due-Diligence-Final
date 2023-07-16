import { Component, OnInit } from '@angular/core';
import { FormControl, FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute, Router } from '@angular/router';
import { ErrorHandler } from '../../error/error.handler';
import { ClientConfigurationService } from 'src/app/services/client-configuration/client-configuration.service';
import { DueDeligenceService } from 'src/app/services/due-deligence/due-deligence.service';
import { forkJoin, Observable } from 'rxjs';
import { TokenStorageService } from '../../services/token-service/token-storage.service';

@Component({
  selector: 'app-due-diligence',
  templateUrl: './due-diligence.component.html',
  styleUrls: ['./due-diligence.component.scss']
})
export class DueDiligenceComponent implements OnInit {

  dueDiligenceForm: FormGroup;
  isError: boolean = false;
  isSuccess: boolean = false;
  errorMessage = '';
  headerKey: any;
  ddId: any;
  key1: any;
  key2: any;
  key3: any;
  key4: any;
  roles: string[] = [];
  ddoptions1 = new FormControl();
  ddoptions2 = new FormControl();
  ddoptions3 = new FormControl();
  ddoptions4 = new FormControl();
  //ddoptionsList: string[] = ["y",'n','y0','n0',"n1",'n2','n3','n4','n5','n6','n7','n8','n9',"O"];
  generalOption: any ;
  applicantOption: any;
  coApplicantOption: any;
  guarantorOption: any;
  complianceOption :any;
  //ddOptionsSelected1: string[] = ['y','n','n0','O'];
  //ddOptionsSelected2: string[] = ['y','n','n0','n5'];
  //ddOptionsSelected3: string[] = ['n1','n3','n5','n7'];
  //ddOptionsSelected4: string[] = ['n6','n7','n8','n9'];
  clientId:any;
  templateStatus:any;
  isNonM1Module: boolean = false;
  showSubmitButton: boolean = false;
  showApproveButton: boolean = false;
  showFreezeButton: boolean = false;
  isBankAdmin: boolean = false;
  isBankMitraAdmin: boolean = false;
  isAdmin: boolean = false;

  constructor(private formBuilder: FormBuilder,
    private errorHandler: ErrorHandler,
    private toastrService: ToastrService,
    private activatedroute: ActivatedRoute, private tokenService: TokenStorageService,
    private router: Router,
    private dueDeligenceService: DueDeligenceService) {
      this.headerKey = this.activatedroute.snapshot.paramMap.get("headerKey");
    this.clientId = this.activatedroute.snapshot.paramMap.get("clientId");
    this.templateStatus = this.activatedroute.snapshot.paramMap.get("templateStatus");
  }

  ngOnInit(): void {
    this.roles = this.tokenService.getUser().roles;

    var arrModule = this.headerKey.split('_');
    if(this.templateStatus != 'Freezed' && this.templateStatus != 'FREEZED') {
    	this.showSubmitButton = true;
    } else {
   		this.showSubmitButton = false;
    }
    console.log('Module == '+arrModule[0]);
    console.log('Role == '+this.roles[0]);
    console.log('templateStatus == '+this.templateStatus);
    if(arrModule[0]=='M5'
       && (this.templateStatus == 'DRAFT' || this.templateStatus == 'Pending Approval' || this.templateStatus == 'PENDING APPROVAL' )
       && (this.roles[0] == 'BNADMIN' || this.roles[0] =='BNMGMT' || this.roles[0] =='AFSA' || this.roles[0] =='AFAdmin' || this.roles[0] =='AFMgmt')) {
    	this.showApproveButton = true;
    } else {
   		this.showApproveButton = false;
    }
    console.log('Display of Approve'+this.showApproveButton);
    if(this.roles[0] == 'BNADMIN' || this.roles[0] == 'BNMGMT' || this.roles[0] =='AFAdmin' || this.roles[0] =='AFMgmt'){
      this.isBankAdmin = true;
    }
    if(this.roles[0] == 'BMTRADMIN'){
      this.isBankMitraAdmin = true;
    }
    if(this.roles[0] == 'BNADMIN') {
      this.isAdmin = true;
    }
    if(arrModule[0]=='M5' && (this.roles[0] == 'BMTRADMIN' || this.roles[0] == 'BMTRMGMT' )
        && (this.templateStatus == 'Approved' || this.templateStatus == 'APPROVED')) {
    	this.showFreezeButton = true;
    } else {
   		this.showFreezeButton = false;
    }
    this.dueDiligenceForm = this.formBuilder.group({
      dueDeligenceDetails: this.formBuilder.array([
        this.getExistingDueDeligence()
      ])
    });
     this.isError = false;
    let getDueDeligenceServiceCalls: Observable<any>[] = [];
    getDueDeligenceServiceCalls.push(this.dueDeligenceService.getDueDeligence(this.headerKey));
    var arr = this.headerKey.split('_');
    if(arr[0]=='M1')
	  	this.isNonM1Module = false;
	else
	    this.isNonM1Module = true;

    forkJoin(getDueDeligenceServiceCalls).subscribe(results => {
        if (results[0] && results[0].data && results[0].data.length > 0) {
          let dueDeligenceData = results[0].data;
          console.log("dueDeligenceData : ", dueDeligenceData);
          (this.dueDiligenceForm.get('dueDeligenceDetails') as FormArray).clear();

          dueDeligenceData.forEach((eachDueDeligenceData: any) => {
            const dueDeligenceDetailsControl = this.getExistingDueDeligence();

            dueDeligenceDetailsControl.setValue({
              ddSequence: eachDueDeligenceData.ddSequence,
              ddParentSequence: eachDueDeligenceData.ddParentSequence,
              headerSequence: eachDueDeligenceData.headerSequence,
              ddData : eachDueDeligenceData.ddData,
              generalOption :eachDueDeligenceData.generalOption,
              applicantOption :eachDueDeligenceData.applicantOption,
              coApplicantOption :eachDueDeligenceData.coApplicantOption,
              guarantorOption:eachDueDeligenceData.guarantorOption,
              complianceOption:eachDueDeligenceData.complianceOption,
              conditions :eachDueDeligenceData.conditions,
              creditSectorId :eachDueDeligenceData.creditSectorId,
              loanSchemeId :eachDueDeligenceData.loanSchemeId,
              loanVariant_keyword :eachDueDeligenceData.loanVariant_keyword,
              borrowerTypeId :eachDueDeligenceData.borrowerTypeId,
              criticaltyFactor :eachDueDeligenceData.criticaltyFactor,
              professionId :eachDueDeligenceData.professionId,
              loanApplicationTypeId :eachDueDeligenceData.loanApplicationTypeId,
              securityId :eachDueDeligenceData.securityId,
              securityTypeId :eachDueDeligenceData.securityTypeId,
              applicationTypeId :eachDueDeligenceData.applicationTypeId,
              assetTypeId :eachDueDeligenceData.assetTypeId,
              remarks: eachDueDeligenceData.remarks
            })

            this.addThisDueDeligenceDetails(dueDeligenceDetailsControl);
          });
        } else {
	        this.errorMessage = "No due deligience configured";
	        this.isError = true;
        }
    },
      err => {
        this.errorMessage = err.errorMessage;
        this.isError = true;
      });
  }
  getExistingDueDeligence() {
    return this.formBuilder.group({
      generalOption: [''] ,
      applicantOption :[''],
      coApplicantOption :[''],
      guarantorOption :[''],
      complianceOption:[''],
      remarks :[''],
      ddSequence :[''],
      ddParentSequence :[''],
      headerSequence :[''],
      ddData:[''],
      conditions :[''],
      creditSectorId :[''],
      loanSchemeId :[''],
      loanVariant_keyword :[''],
      borrowerTypeId :[''],
      criticaltyFactor :[''],
      professionId :[''],
      loanApplicationTypeId :[''],
      securityId :[''],
      securityTypeId :[''],
      applicationTypeId :[''],
      assetTypeId :['']
    });
  }
  getDueDeligenceArrayControl() {
    return (this.dueDiligenceForm.get('dueDeligenceDetails') as FormArray).controls;
  }

  addThisDueDeligenceDetails(formGroup: FormGroup) {
    const control = <FormArray>this.dueDiligenceForm.controls['dueDeligenceDetails'];
    //console.log('formGroup  :::::',formGroup);
    control.push(formGroup);
  }

  // add new row
  addDueDeligence() {
    this.clearAllErrors();
    const control = <FormArray>this.dueDiligenceForm.controls['dueDeligenceDetails'];
    var arr = this.headerKey.split('_');
    const dueDeligenceDetailsControl = this.getExistingDueDeligence();
    this.dueDeligenceService.getNewDeligence(arr[2]).subscribe(result=>{
	    console.log("result",result.data);
	    dueDeligenceDetailsControl.setValue({
              ddSequence: result.data,
              ddParentSequence: '',
              headerSequence: '',
              ddData : '',
              generalOption :'',
              applicantOption :'',
              coApplicantOption :'',
              guarantorOption:'',
              complianceOption:'',
              conditions :'',
              creditSectorId :'',
              loanSchemeId :'',
              loanVariant_keyword :'',
              borrowerTypeId :'',
              criticaltyFactor :'',
              professionId :'',
              loanApplicationTypeId :'',
              securityId :'',
              securityTypeId :'',
              applicationTypeId :'',
              assetTypeId :'',
              remarks: ''
        })

        this.addThisDueDeligenceDetails(dueDeligenceDetailsControl);
	  },
	  err => {
	    this.errorMessage = err.error.errorMessage;
        this.isError = true;
	  });
    //control.push(dueDeligenceDetailsControl);
  }

  removeDueDeligence(i: number) {
      this.clearAllErrors();
      var arrModule = this.headerKey.split('_');
      const control = <FormArray>this.dueDiligenceForm.controls['dueDeligenceDetails'];
	  //console.log("control",this.getDueDeligenceArrayControl()[i].value);

	  this.dueDeligenceService.deleteDueDeligence(arrModule[0],arrModule[2],this.getDueDeligenceArrayControl()[i].value).subscribe(result=>{
	    console.log("result",result);
	    this.toastrService.success('Due deligence details deleted successfully', 'Information', {
          timeOut: 3000,
        });
	  },
	  err => {
	    console.log("err",err);
	  });
    control.removeAt(i);
  }

  saveUnit(index) {
    this.clearAllErrors();
    console.log(this.getDueDeligenceArrayControl()[index].value);
    let updateRequestData:any = this.getDueDeligenceArrayControl()[index].value;
    console.log("updateRequestData",updateRequestData);
    this.dueDeligenceService.saveDueDeligence(updateRequestData,'save',this.headerKey).subscribe((results: any) => {
      console.log("updateRequestData", results);
      this.toastrService.success('Your changes has been saved for the DD sequence ' + this.getDueDeligenceArrayControl()[index].value.ddSequence, 'Information', {
      timeOut: 3000,
   	   });
     },err => {
	    this.errorMessage = err.error.errorMessage;
	    this.isError = true;
	  });
  }

  performSubmit(action) {
    this.clearAllErrors();
    let requestData = this.dueDiligenceForm.value;
	let dueDelegencyList = [];
    dueDelegencyList = requestData.dueDeligenceDetails;
    //var arr = this.headerKey.split('_');
    this.dueDeligenceService.saveDueDeligence(requestData,action,this.headerKey).subscribe((results: any) => {
      if (!results.metaData.success) {
        this.isError = true;
        this.errorMessage = results.metaData.description;
      } else {
        if(action=='Freezed') {
	        this.toastrService.success('This Module is Freezed Successfully', 'Information', {
	          timeOut: 3000,
	        });
        } else if (action == 'Approved') {
	        this.toastrService.success('This Module is approved Successfully', 'Information', {
	          timeOut: 3000,
        	});
        } else {
            this.toastrService.success('This Module is submitted Successfully', 'Information', {
	          timeOut: 3000,
        	});
        }
      }
    },
      err => {
        this.errorMessage = err.error.errorMessage;
        this.isError = true;
      }
    );
  }

  clearAllErrors() {
    this.isError = false;
    this.errorMessage = "";
  }

  goBackToEditTemplateScreen() {
    var arr = this.headerKey.split('_');
    this.router.navigate(['home', {
      outlets: {
        appcontent: ['edit-template',arr[2],this.clientId,'Test','Completed',2,arr[0],this.templateStatus]
      }
    }]);
  }
}
