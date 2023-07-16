import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ErrorHandler } from '../error/error.handler';
import { ReferenceService } from '../services/reference-service/reference.service';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.scss']
})
export class UserRegistrationComponent implements OnInit {

  userRegistrationForm: FormGroup;
  pageErrors: any = {};
  isError: boolean = false;
  errorMessage = '';

  constructor(private formBuilder: FormBuilder, private errorHandler: ErrorHandler, private referenceService: ReferenceService) {
  }

  customOptions: any[] = [
    { value: 'option-1', viewValue: 'One' },
    { value: 'option-2', viewValue: 'Two' },
    { value: 'option-3', viewValue: 'Three' }
  ];

  page_error_messages = {
    userType: 'User Type is required',
    role: 'User Role is required',
    fname: 'Full Name is required',
    email: 'Email is required',
    uname: 'User Name is required',
    pword: 'Password is required',
    status: 'Status is required'
  };

  ngOnInit(): void {
    this.userRegistrationForm = this.formBuilder.group({
      userType: ['', [Validators.required]],
      firm: [''],
      bank: [''],
      role: ['', [Validators.required]],
      emp_id: [''],
      fname: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      mobile: [''],
      uname: ['', [Validators.required]],
      pword: ['', [Validators.required]],
      status: ['', [Validators.required]] 
    });
    this.errorHandler.handleErrors(this.userRegistrationForm, this.pageErrors);

  }

  performSubmit(){
    this.referenceService.getReferenceLanguages().subscribe(result=>{
      this.isError = false;
      console.log("result",result);

    },
    err => {
      this.errorMessage = err.error.message;
      this.isError;
    });
  }


}
