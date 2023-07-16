import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ErrorHandler } from '../error/error.handler';

@Component({
  selector: 'app-loan-scheme',
  templateUrl: './loan-scheme.component.html',
  styleUrls: ['./loan-scheme.component.scss']
})
export class LoanSchemeComponent implements OnInit {

  loanSchemeForm: FormGroup;
  pageErrors: any = {};

  customOptions: any[] = [
    { value: 'option-1', viewValue: 'One' },
    { value: 'option-2', viewValue: 'Two' },
    { value: 'option-3', viewValue: 'Three' }
  ];

  constructor(private formBuilder: FormBuilder, private errorHandler: ErrorHandler) {
  }

  ngOnInit(): void {
    this.loanSchemeForm = this.formBuilder.group({
      ddapBank: ['', [Validators.required]],
      creditSector: ['', [Validators.required]],
      templateOption: ['', [Validators.required]],
      languageTemplate: ['', [Validators.required]],
      schemeData: this.formBuilder.array([
        this.getLoanSchemeData()
     ])
    });
    this.errorHandler.handleErrors(this.loanSchemeForm, this.pageErrors);
    //console.log("schemeData",this.loanSchemeForm.controls.schemeData.controls.length); 
    //this.addUnit();

  }

  // now we create some service methods for create, add and remove 
// row inside form
// create form row.
private getLoanSchemeData() { 
  
  return this.formBuilder.group({
    schemeName: ['', Validators.required],
    schemeKeyword: ['', [Validators.required]],
    schemeWorksheetName: ['']
  });
}

// add new row
addUnit() {
  const control = <FormArray>this.loanSchemeForm.controls['schemeData'];
  control.push(this.getLoanSchemeData());
}

// remove row
removeUnit(i: number) {
  const control = <FormArray>this.loanSchemeForm.controls['schemeData'];
  control.removeAt(i);
}

getLoanSchemeArrayControl() {
  return (this.loanSchemeForm.get('schemeData') as FormArray).controls;
}

}
