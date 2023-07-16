import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ErrorHandler } from '../error/error.handler';

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

  constructor(private formBuilder: FormBuilder, private errorHandler: ErrorHandler) {
  }

  ngOnInit(): void {
    this.languageTemplateForm = this.formBuilder.group({
      ddapBank: ['', [Validators.required]],
      creditSector: ['', [Validators.required]],
      templateOption: ['', [Validators.required]],      
      templateData: this.formBuilder.array([
        this.getTemplateData()
     ])
    });
    this.errorHandler.handleErrors(this.languageTemplateForm, this.pageErrors);
    //console.log("schemeData",this.loanSchemeForm.controls.schemeData.controls.length); 
    //this.addUnit();

  }

  // now we create some service methods for create, add and remove 
// row inside form
// create form row.
private getTemplateData() { 
  
  return this.formBuilder.group({
    templateName: ['', Validators.required],
    templateWorksheetName: ['']
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
