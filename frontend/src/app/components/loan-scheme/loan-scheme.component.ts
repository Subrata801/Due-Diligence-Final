import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { forkJoin } from 'rxjs';
import { distinctUntilChanged } from 'rxjs/operators';
import { ErrorHandler } from '../../error/error.handler';
import { LanguageTemplateService } from '../../services/template/template.service';
import { ReferenceService } from '../../services/reference-service/reference.service';
import { find } from "lodash";
import { ToastrService } from 'ngx-toastr';
import { filter } from "lodash";
@Component({
  selector: 'app-loan-scheme',
  templateUrl: './loan-scheme.component.html',
  styleUrls: ['./loan-scheme.component.scss']
})
export class LoanSchemeComponent implements OnInit {

  loanSchemeForm: FormGroup;
  pageErrors: any = {};
  languageOptions: any = [];
  isError: boolean = false;
  isSuccess: boolean = false;
  errorMessage = '';
  availableLoanSchemeOptions: any = [];

  customOptions: any[] = [
    { value: 'option-1', viewValue: 'One' },
    { value: 'option-2', viewValue: 'Two' },
    { value: 'option-3', viewValue: 'Three' }
  ];

  constructor(private formBuilder: FormBuilder, private errorHandler: ErrorHandler,
    private languageTemplateService: LanguageTemplateService, private referenceService: ReferenceService,
    private toastrService: ToastrService) {
  }

  ngOnInit(): void {
    this.loanSchemeForm = this.formBuilder.group({
      clientTypeId: ['', [Validators.required]],
      creditScoreTypeId: ['', [Validators.required]],
      riskTypeId: ['', [Validators.required]],
      languageTemplate: ['', [Validators.required]],
      templateId: ['', [Validators.required]],
      loanSchemeDetails: this.formBuilder.array([
        this.getLoanSchemeData("existing")
      ])
    });
    //this.fetchPageData();
    //this.errorHandler.handleErrors(this.loanSchemeForm, this.pageErrors);
    //console.log("schemeData",this.loanSchemeForm.controls.schemeData.controls.length); 
    //this.addUnit();
    this.loadOptions();
    this.registerValueChanges();
    (this.loanSchemeForm.get('loanSchemeDetails') as FormArray).clear();


  }
  clearAllData() {
    this.loanSchemeForm.reset();
    (this.loanSchemeForm.get('loanSchemeDetails') as FormArray).clear();
  }
  loadOptions(){
    forkJoin([this.languageTemplateService.getAvailableAllLoanSchemes()]).subscribe(results => {
      console.log(" getAvailableLoanSchemes results", results);

        if (results[0] && results[0].data) {
          
          this.availableLoanSchemeOptions = results[0].data;
        }
    });

  }

  registerValueChanges() {
    this.languageOptions.value=null;
    this.loanSchemeForm.get('clientTypeId').valueChanges.pipe(
      distinctUntilChanged()
    ).subscribe(clientTypeIdValue => {
      this.fetchPageData();
    });
    this.loanSchemeForm.get('creditScoreTypeId').valueChanges.pipe(
      distinctUntilChanged()).subscribe(creditScoreTypeIdValue => {
        this.fetchPageData();
      });
    this.loanSchemeForm.get('riskTypeId').valueChanges.pipe(
      distinctUntilChanged()).subscribe(riskTypeIdValue => {
        this.fetchPageData();
      });
    this.loanSchemeForm.get('languageTemplate').valueChanges.pipe(
      distinctUntilChanged()
    ).subscribe(languageTemplateValue => {
      let matchedTemplateObj = find(this.languageOptions, { 'languageId': languageTemplateValue });
      
      if(matchedTemplateObj != undefined) {
          this.isError = false;
	      this.loanSchemeForm.patchValue({
	        templateId: matchedTemplateObj.templateId
	      });
      }

    });

   this.loanSchemeForm.get('templateId').valueChanges.pipe(
      distinctUntilChanged()
    ).subscribe(templateValue => {
      let schemeDataArr: any = [];
      (this.loanSchemeForm.get('loanSchemeDetails') as FormArray).clear();
	  let clientTypeId = this.loanSchemeForm.get('clientTypeId').value;
	  let creditScoreTypeId = this.loanSchemeForm.get('creditScoreTypeId').value;
	  let riskTypeId = this.loanSchemeForm.get('riskTypeId').value;
	  let languageTemplate = this.loanSchemeForm.get('languageTemplate').value;
      if(clientTypeId && creditScoreTypeId && riskTypeId && languageTemplate) {
		  forkJoin([this.languageTemplateService.getAvailableLoanSchemes(this.loanSchemeForm.get('clientTypeId').value,
		  this.loanSchemeForm.get('creditScoreTypeId').value,
		  this.loanSchemeForm.get('riskTypeId').value,
		  this.loanSchemeForm.get('languageTemplate').value,
		  templateValue)]).subscribe(results => {
			console.log("results", results);

			if (results[0] && results[0].data) {          
			  results[0].data.forEach(eachData => {
				schemeDataArr.push({
				  loanSchemeId: eachData.loanSchemeId,
				  loanSchemeName: eachData.loanSchemeName,
				  keyword: eachData.keyword,
				  worksheetName: eachData.worksheetName,
				  action: 'existing'
				})
				//
			  });
			  console.log("schemeDataArr", schemeDataArr);
			  schemeDataArr.forEach((eachArray, index) => {
				if (index < schemeDataArr.length) {
				  this.addUnit('existing');
				}
			  });
			  this.loanSchemeForm.patchValue({
				loanSchemeDetails: schemeDataArr
			  });
			}
		  });
	  
	 }
    });

  }

  fetchPageData() {
    
    if (this.loanSchemeForm.get('clientTypeId').value && this.loanSchemeForm.get('clientTypeId').value != undefined
      && this.loanSchemeForm.get('creditScoreTypeId').value && this.loanSchemeForm.get('creditScoreTypeId').value != undefined
      && this.loanSchemeForm.get('riskTypeId').value && this.loanSchemeForm.get('riskTypeId').value != undefined
    ) {
      (this.loanSchemeForm.get('loanSchemeDetails') as FormArray).clear();

      forkJoin([this.languageTemplateService.getLanguageTemplates(this.loanSchemeForm.get('clientTypeId').value,
        this.loanSchemeForm.get('creditScoreTypeId').value,
        this.loanSchemeForm.get('riskTypeId').value)]).subscribe(results => {
          console.log("results", results);
          if (results[0] && results[0].data) {
            this.languageOptions = results[0].data;
          }

        });
    }

  }

  // now we create some service methods for create, add and remove 
  // row inside form
  // create form row.
  private getLoanSchemeData(action) {

    return this.formBuilder.group({
      loanSchemeId: [{ value: '0', disabled: action === 'add' ? false : true }],
      loanSchemeName: [{ value: '', disabled: action === 'add' ? false : true }, Validators.required],
      keyword: [{ value: '', disabled: action === 'add' ? false : true }, [Validators.required]],
      worksheetName: [{ value: '', disabled: action === 'add' ? false : true }],
      action: action
    });
  }

  // add new row
  addUnit(action) {
    const control = <FormArray>this.loanSchemeForm.controls['loanSchemeDetails'];
    control.push(this.getLoanSchemeData(action));
  }

  // remove row
  removeUnit(i: number) {
    const control = <FormArray>this.loanSchemeForm.controls['loanSchemeDetails'];
    control.removeAt(i);
  }

  getLoanSchemeArrayControl() {
    return (this.loanSchemeForm.get('loanSchemeDetails') as FormArray).controls;
  }

  performSubmit() {
    let requestData = this.loanSchemeForm.value;
    console.log("requestData", requestData);
    let loanSchemeDetailsAdded = filter(requestData.loanSchemeDetails, { action: 'add' });
    console.log("loanSchemeDetailsAdded", loanSchemeDetailsAdded);
    if (loanSchemeDetailsAdded) {
      requestData.loanSchemeDetails = loanSchemeDetailsAdded;
    }
    console.log("requestData", requestData);
    //let rwqs = {"clientTypeId":"2","creditScoreTypeId":"1","riskTypeId":"1","languageTemplate":2,"templateId":9,"loanSchemeDetails":[{"loanSchemeId":"","loanSchemeName":"test","keyword":"tst","worksheetName":"test"}]};
    this.languageTemplateService.createLoanScheme(requestData).subscribe((results: any) => {
      console.log("results", results);
      // confirmationDialogData.message = result.metaData.description;
      if (!results.metaData.success) {
        this.isError = true;
        this.errorMessage = results.metaData.description;
      } else {
        //this.isSuccess = true;
        this.toastrService.success('Loan Scheme is successful', 'Information', {
          timeOut: 3000,

        });
        this.loanSchemeForm.reset();
      }
    },
      err => {
        this.errorMessage = err.error.errorMessage;
        this.isError = true;
      }

    );

  }
  resetDD() {
    this.loanSchemeForm.get('languageTemplate').reset();
  }
}
