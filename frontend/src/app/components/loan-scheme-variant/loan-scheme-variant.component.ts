import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { forkJoin } from 'rxjs';
import { distinctUntilChanged } from 'rxjs/operators';
import { ErrorHandler } from '../../error/error.handler';
import { LanguageTemplateService } from '../../services/template/template.service';
import { ReferenceService } from '../../services/reference-service/reference.service';
import { find } from "lodash";
import { filter } from "lodash";
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-loan-scheme-variant',
  templateUrl: './loan-scheme-variant.component.html',
  styleUrls: ['./loan-scheme-variant.component.scss']
})
export class LoanSchemeVariantComponent implements OnInit {


  loanSchemeForm: FormGroup;
  pageErrors: any = {};
  languageOptions: any = [];
  isError: boolean = false;
  isSuccess: boolean = false;
  errorMessage = '';

  constructor(private formBuilder: FormBuilder, private errorHandler: ErrorHandler,
    private languageTemplateService: LanguageTemplateService, private referenceService: ReferenceService,
    private toastrService: ToastrService) {
  }

  ngOnInit(): void {
    this.loanSchemeForm = this.formBuilder.group({

      loanSchemeId: ['', [Validators.required]],
      templateId: ['', [Validators.required]],
      loanVariantDetails: this.formBuilder.array([
        this.getLoanSchemeData('existing')
      ])
    });

    //this.errorHandler.handleErrors(this.loanSchemeForm, this.pageErrors);
    //console.log("schemeData",this.loanSchemeForm.controls.schemeData.controls.length); 
    //this.addUnit();
    this.registerValueChanges();
    (this.loanSchemeForm.get('loanVariantDetails') as FormArray).clear();
    this.fetchPageData();


  }
  clearAllData() {
    this.loanSchemeForm.reset();
    (this.loanSchemeForm.get('loanVariantDetails') as FormArray).clear();
  }
  registerValueChanges() {

    this.loanSchemeForm.get('loanSchemeId').valueChanges.pipe(
      distinctUntilChanged()
    ).subscribe(loanSchemeIdValue => {

      let schemeDataArr: any = [];
      (this.loanSchemeForm.get('loanVariantDetails') as FormArray).clear();
      forkJoin([this.languageTemplateService.getAvailableLoanVariants(loanSchemeIdValue)]).subscribe(results => {
        console.log("results", results);

        if (results[0] && results[0].data) {

          results[0].data.forEach(eachData => {
            schemeDataArr.push({
              loanVariantId: eachData.loanVariantId,
              loanVariantName: eachData.loanVariantName,
              keyword: eachData.keyword,
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
            loanVariantDetails: schemeDataArr
          });
        }
      });
    });

  }

  fetchPageData() {

    (this.loanSchemeForm.get('loanVariantDetails') as FormArray).clear();

    forkJoin([this.languageTemplateService.getAvailableLoanSchemesDefault()]).subscribe(results => {
      console.log("results", results);
      if (results[0] && results[0].data) {
        this.languageOptions = results[0].data;
      }
    });

  }

  // now we create some service methods for create, add and remove 
  // row inside form
  // create form row.
  private getLoanSchemeData(action) {
    console.log("action", action);
    return this.formBuilder.group({
      loanVariantId: [{ value: '0', disabled: action === 'add' ? false : true }],
      loanVariantName: [{ value: '', disabled: action === 'add' ? false : true }, Validators.required],
      keyword: [{ value: '', disabled: action === 'add' ? false : true }, [Validators.required]],
      action: action
    });
  }


  // add new row
  addUnit(action) {
    const control = <FormArray>this.loanSchemeForm.controls['loanVariantDetails'];
    control.push(this.getLoanSchemeData(action));
  }

  // remove row
  removeUnit(i: number) {
    const control = <FormArray>this.loanSchemeForm.controls['loanVariantDetails'];
    control.removeAt(i);
  }

  getLoanSchemeArrayControl() {
    return (this.loanSchemeForm.get('loanVariantDetails') as FormArray).controls;
  }

  performSubmit() {
    let requestData = this.loanSchemeForm.value;
    console.log("requestData", requestData);
    let loanVariantDetailsAdded = filter(requestData.loanVariantDetails, { action: 'add' });
    console.log("loanVariantDetailsAdded", loanVariantDetailsAdded);
    if (loanVariantDetailsAdded) {
      requestData.loanVariantDetails = loanVariantDetailsAdded;
    }
    //let rwqData  = {loanSchemeId: 1,loanVariantDetails: [{loanVariantId: "", loanVariantName: "test", keyword: "test"}]}
    this.languageTemplateService.createLoanVariants(requestData).subscribe((results: any) => {
      console.log("results", results);
      // confirmationDialogData.message = result.metaData.description;
      if (!results.metaData.success) {
        this.isError = true;
        this.errorMessage = results.metaData.description;
      } else {
        //this.isSuccess = true;
        this.toastrService.success('Loan Scheme Variant is successful', 'Information', {
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



}
