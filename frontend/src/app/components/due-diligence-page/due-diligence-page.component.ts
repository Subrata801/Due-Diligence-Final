import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';
import { ActivatedRoute, Router } from '@angular/router';
import { forkJoin, Observable } from 'rxjs';
import { InitiateDueDiligenceService } from '../../services/initiate-due-diligence/initiate-due-diligence.service';

@Component({
  selector: 'app-due-diligence-page',
  templateUrl: './due-diligence-page.component.html',
  styleUrls: ['./due-diligence-page.component.scss']
})
export class dueDiligencePageComponent implements OnInit {

  initiateDueDiligenceForm: FormGroup;
  pageErrors: any = {};
  isError: boolean = false;
  isSuccess: boolean = false;
  errorMessage = '';
  search: boolean = true;
  isChecked: boolean = false;
  searchResults: boolean = false;
  status: string = "Inactive";
  selectedUnit: any;
  panelOpenState: boolean = false;
  totalCoapplicants: number = 2;
  totalGuarantors: number = 3;
  headerKey = '';
  isNonM1Module: boolean = false;
  isM1Module: boolean = false;
  moduleName = '';
  loanAppNum = '';
  assessmentForm: FormGroup;
  dueDiligenceCount: boolean = false;
  x: any = {};
  saveReq: any ={};

  constructor(private formBuilder: FormBuilder,
    private errorHandler: ErrorHandler, private slideToggle: MatSlideToggleModule,
    private activatedroute: ActivatedRoute, private initiateDueDiligenceService: InitiateDueDiligenceService,
    private toastr: ToastrService, private router: Router) {
    this.headerKey = this.activatedroute.snapshot.paramMap.get("headerKey");
  }

  ngOnInit(): void {
    this.assessmentForm = this.formBuilder.group({
      dueDeligenceDetails: this.formBuilder.array([
        this.getExistingDueDeligence()
      ])
    });

    var arr = this.headerKey.split('_');
    console.log('header key:'+this.headerKey);
    this.moduleName = arr[0];
    console.log("Module Name:"+this.moduleName);
    if(this.moduleName == '1') {
       this.isM1Module = true;
    } else {
       this.isM1Module = false;
    }
    this.loanAppNum = arr[2];
    this.fetchDueDiligenceData(this.headerKey);
  }
  getExistingDueDeligence() {
    return this.formBuilder.group({
      ddSequence: [''],
      ddParentSequence: [''],
      ddData: [''],
      schmemaNormColor: [''],
      applicantColor: [''],
      coapplicantcolor: [''],
      coapplicant1color: [''],
      coapplicant2color: [''],
      coapplicant3color: [''],
      coapplicant4color: [''],
      guarantorcolor: [''],
      guarantor1color: [''],
      guarantor2color: [''],
      guarantor3color: [''],
      guarantor4color: [''],
      schmemaNormPlaceHolderValues: [''],
      isSchemeDisabled : [''],
      schmemaNormUiValidValue: [''],
      applicantPlaceHolderValues: [''],
      isApplicantDisabled : [''],
      applicantUiValidValue: [''],
      coapplicantplaceholdervalues: [''],
      isCoapplicantDisabled : [''],
      coapplicantuivalidvalue: [''],
      coapplicant1placeholdervalues: [''],
      isCoapplicant1Disabled : [''],
      coapplicant1uivalidvalue: [''],
      coapplicant2placeholdervalues: [''],
      isCoapplicant2Disabled : [''],
      coapplicant2uivalidvalue: [''],
      coapplicant3placeholdervalues: [''],
      isCoapplicant3Disabled : [''],
      coapplicant3uivalidvalue: [''],
      coapplicant4placeholdervalues: [''],
      isCoapplicant4Disabled : [''],
      coapplicant4uivalidvalue: [''],
      guarantorplaceholdervalues: [''],
      isGurantorDisabled : [''],
      guarantoruivalidvalue: [''],
      guarantor1placeholdervalues: [''],
      isGurantor1Disabled : [''],
      guarantor1uivalidvalue: [''],
      guarantor2placeholdervalues: [''],
      isGurantor2Disabled : [''],
      guarantor2uivalidvalue: [''],
      guarantor3placeholdervalues: [''],
      isGurantor3Disabled : [''],
      guarantor3uivalidvalue: [''],
      guarantor4placeholdervalues: [''],
      isGurantor4Disabled : [''],
      guarantor4uivalidvalue: [''],
      compliancePlaceholdervalues: [''],
      complianceUivalidvalue:[''],
      complianceColor: [''],
      auditorComment: [''],
      comment: [''],
      schemaNormVal : ['']
    });
  }
  getDueDeligenceArrayControl() {
    this.x = (this.assessmentForm.get('dueDeligenceDetails') as FormArray).controls;
    //console.log("TESTING ::: ", this.x);
    return this.x;
  }

  addThisDueDeligenceDetails() {
    const control = <FormArray>this.assessmentForm.controls['dueDeligenceDetails'];
    control.push(this.getExistingDueDeligence());
  }

  isDisable(placeHolderValue:any) {
      if(placeHolderValue==null) {
        return true;
      } else {
        return false;
      }
  }

  fetchDueDiligenceData(headerKey) {
    let dueDiligenceDataArr: any = [];
    this.initiateDueDiligenceService.getListOfDueDeligenceAsPerHeader(headerKey).subscribe(results => {
      console.log('results length:'+results.data.length);
      console.log('1st result:', results.data[0]);
      //console.log('results data:'+results.data);
      if (results && results.data) {
        this.dueDiligenceCount = true;
        (this.assessmentForm.get('dueDeligenceDetails') as FormArray).clear();
        results.data.forEach((eachDueDeligenceData: any) => {
          dueDiligenceDataArr.push({
            ddSequence: eachDueDeligenceData.ddSequence,
            ddParentSequence: eachDueDeligenceData.ddParentSequence,
            ddData: eachDueDeligenceData.ddData,
            schmemaNormColor: eachDueDeligenceData.schmemaNormColor,
            applicantColor: eachDueDeligenceData.applicantColor,
            coapplicantcolor: eachDueDeligenceData.coapplicantcolor,
            coapplicant1color: eachDueDeligenceData.coapplicant1color,
            coapplicant2color: eachDueDeligenceData.coapplicant2color,
            coapplicant3color: eachDueDeligenceData.coapplicant3color,
            coapplicant4color: eachDueDeligenceData.coapplicant4color,
            guarantorcolor: eachDueDeligenceData.guarantorcolor,
            guarantor1color: eachDueDeligenceData.guarantor1color,
            guarantor2color: eachDueDeligenceData.guarantor2color,
            guarantor3color: eachDueDeligenceData.guarantor3color,
            guarantor4color: eachDueDeligenceData.guarantor4color,
            schmemaNormPlaceHolderValues: eachDueDeligenceData.schmemaNormPlaceHolderValues,
            isSchemeDisabled : this.isDisable (eachDueDeligenceData.schmemaNormPlaceHolderValues),
            schmemaNormUiValidValue: eachDueDeligenceData.schmemaNormUiValidValue,
            applicantPlaceHolderValues: eachDueDeligenceData.applicantPlaceHolderValues,
            isApplicantDisabled : this.isDisable (eachDueDeligenceData.applicantPlaceHolderValues),
            applicantUiValidValue: eachDueDeligenceData.applicantUiValidValue,
            coapplicantplaceholdervalues: eachDueDeligenceData.coapplicantplaceholdervalues,
            isCoapplicantDisabled : this.isDisable (eachDueDeligenceData.coapplicantplaceholdervalues),
            coapplicantuivalidvalue: eachDueDeligenceData.coapplicantuivalidvalue,
            coapplicant1placeholdervalues: eachDueDeligenceData.coapplicant1placeholdervalues,
            isCoapplicant1Disabled : this.isDisable (eachDueDeligenceData.coapplicant1placeholdervalues),
            coapplicant1uivalidvalue: eachDueDeligenceData.coapplicant1uivalidvalue,
            coapplicant2placeholdervalues: eachDueDeligenceData.coapplicant2placeholdervalues,
            isCoapplicant2Disabled : this.isDisable (eachDueDeligenceData.coapplicant2placeholdervalues),
            coapplicant2uivalidvalue: eachDueDeligenceData.coapplicant2uivalidvalue,
            coapplicant3placeholdervalues: eachDueDeligenceData.coapplicant3placeholdervalues,
            isCoapplicant3Disabled : this.isDisable (eachDueDeligenceData.coapplicant3placeholdervalues),
            coapplicant3uivalidvalue: eachDueDeligenceData.coapplicant3uivalidvalue,
            coapplicant4placeholdervalues: eachDueDeligenceData.coapplicant4placeholdervalues,
            isCoapplicant4Disabled : this.isDisable (eachDueDeligenceData.coapplicant4placeholdervalues),
            coapplicant4uivalidvalue: eachDueDeligenceData.coapplicant4uivalidvalue,
            guarantorplaceholdervalues: eachDueDeligenceData.guarantorplaceholdervalues,
            isGurantorDisabled : this.isDisable (eachDueDeligenceData.guarantorplaceholdervalues),
            guarantoruivalidvalue: eachDueDeligenceData.guarantoruivalidvalue,
            guarantor1placeholdervalues: eachDueDeligenceData.guarantor1placeholdervalues,
            isGurantor1Disabled : this.isDisable (eachDueDeligenceData.guarantor1placeholdervalues),
            guarantor1uivalidvalue: eachDueDeligenceData.guarantor1uivalidvalue,
            guarantor2placeholdervalues: eachDueDeligenceData.guarantor2placeholdervalues,
            isGurantor2Disabled : this.isDisable (eachDueDeligenceData.guarantor2placeholdervalues),
            guarantor2uivalidvalue: eachDueDeligenceData.guarantor2uivalidvalue,
            guarantor3placeholdervalues: eachDueDeligenceData.guarantor3placeholdervalues,
            isGurantor3Disabled : this.isDisable (eachDueDeligenceData.guarantor3placeholdervalues),
            guarantor3uivalidvalue: eachDueDeligenceData.guarantor3uivalidvalue,
            guarantor4placeholdervalues: eachDueDeligenceData.guarantor4placeholdervalues,
            isGurantor4Disabled : this.isDisable (eachDueDeligenceData.guarantor4placeholdervalues),
            guarantor4uivalidvalue: eachDueDeligenceData.guarantor4uivalidvalue,
            compliancePlaceholdervalues: eachDueDeligenceData.compliancePlaceholdervalues,
	        complianceUivalidvalue: eachDueDeligenceData.complianceUivalidvalue,
	        complianceColor: eachDueDeligenceData.complianceColor,
            auditorComment: eachDueDeligenceData.auditorComment,
            comment: eachDueDeligenceData.comment

          });

        });

        dueDiligenceDataArr.forEach((eachArray, index) => {
          this.addThisDueDeligenceDetails();
        });
      }
      this.assessmentForm.patchValue({
        dueDeligenceDetails: dueDiligenceDataArr
      });
      //console.log('dueDiligenceDataArr:',dueDiligenceDataArr);
    },
      err => {
        console.log("err", err);
        this.errorMessage = err.error.errorMessage;
        this.isError = true;

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
    console.log("Back to Headers with moduleName:"+this.moduleName);
    this.router.navigate(['home', {
      outlets: {
        appcontent: ['view-due-diligence', this.moduleName, this.loanAppNum]
      }
    }]);
  }

  clearAllErrors() {
    this.errorMessage = "";
  }
  saveViewDDNonM1(seq:any, parentSeq:any,complianceValue:any){
    let moduleVal='';
    if(this.moduleName=='2') {
      moduleVal='M2';
    }else if(this.moduleName=='3'){
      moduleVal='M3';
    }else if(this.moduleName=='4'){
      moduleVal='M4';
    }else {
      moduleVal='M5';
    }
    let remarks="";
    console.log("saveViewDDNonM1::loanAppNum:"+this.loanAppNum+":seq:"+seq+":parentSeq:"+
    parentSeq+":complianceValue:"+complianceValue.value+":moduleVal:"+moduleVal+":remarks:"+remarks);
    this.saveReq.loanAppNum = this.loanAppNum;
    this.saveReq.seq = seq;
    this.saveReq.parentSeq = parentSeq;
    this.saveReq.complianceValue = complianceValue.value;
    this.saveReq.remarks = remarks;
    this.saveReq.moduleVal = moduleVal;
    console.log('saveViewDDNonM1:saveReq:', this.saveReq);
    this.initiateDueDiligenceService.saveViewDDM2M5Service(this.saveReq).subscribe(results => {
      console.log('saveViewDDNonM1:response:',results);
      if (!results.metaData.success) {
        this.isError = true;
        this.errorMessage = results.metaData.description;
        this.toastr.error(this.errorMessage, 'Information', {
          timeOut: 3000,
        });
      } else {
        let successMessage = results.data.messageDescription;
        console.log('status message:', successMessage);
        this.toastr.success(successMessage, 'Information', {
          timeOut: 3000,
        });
      }
     },
    err => {
      console.log("saveViewDDNonM1:err", err);
      this.errorMessage = err.error.errorMessage;
      this.isError = true;
      this.toastr.error('Error while saving', 'Information', {
        timeOut: 3000,
      });
    });
  }

  validatePlaceholderData(actualValue:any, placeHolderValue:any){
    console.log('validatePlaceholderData:actualValue:'+actualValue+':placeHolderValue:'+placeHolderValue);
     if(placeHolderValue==undefined || placeHolderValue==null || placeHolderValue==''){
      return true;
     }
     if(actualValue==undefined || actualValue==null || actualValue==''){
      return true;
     }
     let splittedStr: string[] = placeHolderValue.split(",");
     //console.log('splittedStr:',splittedStr);
     if(splittedStr.includes(actualValue)){
      return true;
     }else {
      return false;
     }
  }

  saveViewDD(seq:any, parentSeq:any, schemaNormPlaceHolderValue:any, schemaNormValue:any, applicantPlaceHolderValue:any, applicantValue:any, 
    coAppPlaceHolderValue:any, coAppVal:any, coApp1PlaceHolderValue:any, coApp1Val:any, coApp2PlaceHolderValue:any,coApp2Val:any, 
    coApp3PlaceHolderValue:any,coApp3Val:any, coApp4PlaceHolderValue:any, coApp4Val:any, 
    gurantorPlaceHolderValue:any, gurantorVal:any, gurantor1PlaceHolderValue:any, gurantor1Val:any, 
    gurantor2PlaceHolderValue:any, gurantor2Val:any, gurantor3PlaceHolderValue:any, gurantor3Val:any, 
    gurantor4PlaceHolderValue:any, gurantor4Val:any) {
    console.log('this.headerKey:',this.headerKey);
    console.log("saveViewDD::loanAppNum:"+this.loanAppNum+":seq:"+seq+":parentSeq:"+parentSeq+":schemaNormPlaceHolderValue:"+schemaNormPlaceHolderValue+
    ":schemaNormValue:"+schemaNormValue+":applicantPlaceHolderValue:"+applicantPlaceHolderValue+":applicantValue:"+applicantValue+":coAppVal:"+coAppVal
    +":coApp1Val:"+coApp1Val+":coApp2Val:"+coApp2Val+":coApp3Val:"+coApp3Val+":coApp4Val:"+coApp4Val
    +":gurantorVal:"+gurantorVal+":gurantor1Val:"+gurantor1Val+":gurantor2Val:"+gurantor2Val
    +":gurantor3Val:"+gurantor3Val+":gurantor4Val:"+gurantor4Val);

    this.saveReq.loanAppNum = this.loanAppNum;
    this.saveReq.seq = seq;
    this.saveReq.parentSeq = parentSeq;
    this.saveReq.schemaNormValue = schemaNormValue!=undefined?schemaNormValue.value:'';
    this.saveReq.applicantValue = applicantValue!=undefined?applicantValue.value:'';
    this.saveReq.coAppVal = coAppVal!=undefined?coAppVal.value:'';
    this.saveReq.coApp1Val = coApp1Val!=undefined?coApp1Val.value:'';
    this.saveReq.coApp2Val = coApp2Val!=undefined?coApp2Val.value:'';
    this.saveReq.coApp3Val = coApp3Val!=undefined?coApp3Val.value:'';
    this.saveReq.coApp4Val = coApp4Val!=undefined?coApp4Val.value:'';
    this.saveReq.gurantorVal = gurantorVal!=undefined?gurantorVal.value:'';
    this.saveReq.gurantor1Val = gurantor1Val!=undefined?gurantor1Val.value:'';
    this.saveReq.gurantor2Val = gurantor2Val!=undefined?gurantor2Val.value:'';
    this.saveReq.gurantor3Val = gurantor3Val!=undefined?gurantor3Val.value:'';
    this.saveReq.gurantor4Val = gurantor4Val!=undefined?gurantor4Val.value:'';

    let isValited:boolean = this.validatePlaceholderData(this.saveReq.schemaNormValue, schemaNormPlaceHolderValue) && 
    this.validatePlaceholderData(this.saveReq.applicantValue, applicantPlaceHolderValue) && 
    this.validatePlaceholderData(this.saveReq.coAppVal, coAppPlaceHolderValue) &&
    this.validatePlaceholderData(this.saveReq.coApp1Val, coApp1PlaceHolderValue) &&
    this.validatePlaceholderData(this.saveReq.coApp2Val, coApp2PlaceHolderValue) &&
    this.validatePlaceholderData(this.saveReq.coApp3Val, coApp3PlaceHolderValue) &&
    this.validatePlaceholderData(this.saveReq.coApp4Val, coApp4PlaceHolderValue) &&
    this.validatePlaceholderData(this.saveReq.gurantorVal, gurantorPlaceHolderValue) &&
    this.validatePlaceholderData(this.saveReq.gurantor1Val, gurantor1PlaceHolderValue) &&
    this.validatePlaceholderData(this.saveReq.gurantor2Val, gurantor2PlaceHolderValue) &&
    this.validatePlaceholderData(this.saveReq.gurantor3Val, gurantor3PlaceHolderValue) &&
    this.validatePlaceholderData(this.saveReq.gurantor4Val, gurantor4PlaceHolderValue);

    console.log('isValited:',isValited);

    if(isValited) {
      console.log('placeholder validation successfull--->>>> proceed with data save---->>>>');
      console.log('saveViewDD:saveReq:', this.saveReq);
      this.initiateDueDiligenceService.saveViewDDService(this.saveReq).subscribe(results => {
        console.log('saveViewDD:response:',results);

        if (results.metaData.success && results.data.messageCode=='SUCCESS') {
          let successMessage = results.metaData.description
          console.log('status message:', successMessage);
          this.toastr.success(successMessage, 'Information', {
            timeOut: 3000,
          });
          
        } else {
          this.isError = true;
          this.errorMessage = results.data.messageDescription;
          this.toastr.error(this.errorMessage, 'Information', {
            timeOut: 3000,
          });
        }

        // if (!results.metaData.success) {
        //   this.isError = true;
        //   this.errorMessage = results.metaData.description;
        //   this.toastr.error(this.errorMessage, 'Information', {
        //     timeOut: 3000,
        //   });
        // } else {
        //   let successMessage = results.data.messageDescription;
        //   console.log('status message:', successMessage);
        //   this.toastr.success(successMessage, 'Information', {
        //     timeOut: 3000,
        //   });
        // }
       },
      err => {
        console.log("saveViewDD:err", err);
        this.errorMessage = err.error.errorMessage;
        this.isError = true;
        this.toastr.error('Error while saving', 'Information', {
          timeOut: 3000,
        });
      });
    } else {
      this.toastr.error('Data Validation Failure, please update the data as per suggested value', 'Information', {
        timeOut: 3000,
      });
    }

    
  }
  // saveViewDD(i:any, parentSeq:any, schemaNormVal:any) {
  //   console.log('save::dueDiligenceDataArr:',this.assessmentForm.get('dueDeligenceDetails').value);
  //   console.log("save::schemaNormVal:"+schemaNormVal.value);
  // }
  
}
