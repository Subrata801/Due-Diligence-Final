import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { distinctUntilChanged } from 'rxjs/operators';
import { ErrorHandler } from '../../error/error.handler';
import { LanguageTemplateService } from '../../services/template/template.service';


@Component({
  selector: 'app-language-template',
  templateUrl: './language-template.component.html',
  styleUrls: ['./language-template.component.scss']
})
export class LanguageTemplateComponent implements OnInit {

  languageTemplateForm: FormGroup;
  pageErrors: any = {};

  customOptions: any[] = [
    { value: 'option-1', viewValue: 'One' },
    { value: 'option-2', viewValue: 'Two' },
    { value: 'option-3', viewValue: 'Three' }
  ];

  constructor(private formBuilder: FormBuilder, private errorHandler: ErrorHandler, private languageTemplateService: LanguageTemplateService) {
  }

  ngOnInit(): void {

    this.languageTemplateForm = this.formBuilder.group({
      clientTypeId: ['', [Validators.required]],
      creditScoreTypeId: ['', [Validators.required]],
      riskTypeId: ['', [Validators.required]],
      templateData: this.formBuilder.array([
        this.getTemplateData()
      ])
    });
    this.fetchPageData();
    //this.errorHandler.handleErrors(this.languageTemplateForm, this.pageErrors);
    //console.log("schemeData",this.loanSchemeForm.controls.schemeData.controls.length); 
    //this.addUnit();
    this.registerValueChanges();
    (this.languageTemplateForm.get('templateData') as FormArray).clear();

  }

  registerValueChanges() {
    this.languageTemplateForm.get('clientTypeId').valueChanges.pipe(
      distinctUntilChanged()
    ).subscribe(clientTypeIdValue => {
      this.fetchPageData();
    });
    this.languageTemplateForm.get('creditScoreTypeId').valueChanges.pipe(
      distinctUntilChanged()).subscribe(creditScoreTypeIdValue => {
        this.fetchPageData();
      });
    this.languageTemplateForm.get('riskTypeId').valueChanges.pipe(
      distinctUntilChanged()).subscribe(riskTypeIdValue => {
        this.fetchPageData();
      });
  }

  fetchPageData() {
    if (this.languageTemplateForm.get('clientTypeId').value && this.languageTemplateForm.get('clientTypeId').value != undefined
      && this.languageTemplateForm.get('creditScoreTypeId').value && this.languageTemplateForm.get('creditScoreTypeId').value != undefined
      && this.languageTemplateForm.get('riskTypeId').value && this.languageTemplateForm.get('riskTypeId').value != undefined
    ) {
      // let requestPayLoad = {
      //   "clientTypeId":  this.languageTemplateForm.get('clientTypeId').value,
      //   "creditScoreTypeId":  this.languageTemplateForm.get('creditScoreTypeId').value,
      //   "riskTypeId":  this.languageTemplateForm.get('riskTypeId').value,
      // };
      (this.languageTemplateForm.get('templateData') as FormArray).clear();
      this.languageTemplateService.getLanguageTemplates(this.languageTemplateForm.get('clientTypeId').value,
        this.languageTemplateForm.get('creditScoreTypeId').value, this.languageTemplateForm.get('riskTypeId').value).subscribe(result => {
          console.log("result", result);
          let templateOptionArr: any = [];
          let clientTypeIdFromBe = "";
          let creditScoreTypeIdFromBe = "";
          let riskTypeIdFromBe = "";
          if (result && result.data) {
            result.data.forEach(eachData => {
              clientTypeIdFromBe = eachData.clientTypeId,
                creditScoreTypeIdFromBe = eachData.creditScoreTypeId,
                riskTypeIdFromBe = eachData.riskTypeId,
                templateOptionArr.push({
                  languageId: eachData.languageId,
                  languageName: eachData.languageName,
                  templateId: eachData.templateId,
                  importTemplateName: eachData.importTemplateName
                })
              console.log("clientTypeId", clientTypeIdFromBe, "creditScoreTypeId", creditScoreTypeIdFromBe, "riskTypeId", riskTypeIdFromBe, "templateOptionArr", templateOptionArr);
            });
            templateOptionArr.forEach((eachArray, index) => {
              if (index < templateOptionArr.length ) {
                this.addUnit();
              }
            });
            this.languageTemplateForm.patchValue({
              // clientTypeId: clientTypeIdFromBe+"",
              // creditScoreTypeId: creditScoreTypeIdFromBe+"",
              // riskTypeId: riskTypeIdFromBe+"",
              templateData: templateOptionArr
            });
            //this.languageTemplateForm.updateValueAndValidity();
          }

        });
    }


  }

  // now we create some service methods for create, add and remove 
  // row inside form
  // create form row.
  private getTemplateData() {

    return this.formBuilder.group({
      languageId: [''],
      languageName: ['', Validators.required],
      templateId: [''],
      importTemplateName: ['']
    });
  }

  // add new row
  addUnit() {
    const control = <FormArray>this.languageTemplateForm.controls['templateData'];
    control.push(this.getTemplateData());
  }

  // remove row
  removeUnit(i: number) {
    const control = <FormArray>this.languageTemplateForm.controls['templateData'];
    control.removeAt(i);
  }

  getTemplateDataArrayControl() {
    return (this.languageTemplateForm.get('templateData') as FormArray).controls;
  }

}
