import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';
import { CifRegistrationService } from '../../services/cif-registration/cif-registration.service';

@Component({
  selector: 'app-register-applicant',
  templateUrl: './register-applicant.component.html',
  styleUrls: ['./register-applicant.component.scss']
})
export class registerApplicantComponent implements OnInit {
  
  registrationForm: FormGroup;
  pageErrors: any = {};
  isError: boolean = false;
  isSuccess: boolean = false;
  errorMessage = '';
  search: boolean = true;
  isChecked: boolean = false;
  searchResults: boolean = false;
  status: string = "Inactive";
  isCIFRegistrationFailed : boolean = false;

  constructor(private formBuilder: FormBuilder,
    private errorHandler: ErrorHandler, private slideToggle: MatSlideToggleModule,
    private toastr: ToastrService,private cifRegistrationService: CifRegistrationService) {
  }

  ngOnInit(): void {
    this.registrationForm = this.formBuilder.group({
      cifNum: [''],
      customerName: ['']
    });
  }
  
  performSubmit() {
    const cifRegistrationRequestData: any = this.registrationForm.value;
    
    console.log("cifRegistrationRequestData :",cifRegistrationRequestData);
    this.cifRegistrationService.registerCif(cifRegistrationRequestData).subscribe(result => {      
      console.log("cifRegistrationResponseData :", result);
      this.toastr.success('CIF number has been created successfully ' + cifRegistrationRequestData.cifNum, 'Information', {
      timeOut: 3000,
   	   });
     },err => {
	    this.errorMessage = err.error.errorMessage;
	    this.isCIFRegistrationFailed = true;
	  });
	
  }
  
}