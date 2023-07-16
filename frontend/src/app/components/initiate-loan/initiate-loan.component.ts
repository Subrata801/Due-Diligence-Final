import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';

@Component({
  selector: 'app-initiate-loan',
  templateUrl: './initiate-loan.component.html',
  styleUrls: ['./initiate-loan.component.scss']
})
export class InitiateLoanComponent implements OnInit {
  
  loanApplicationForm: FormGroup;
  pageErrors: any = {};
  isError: boolean = false;
  isSuccess: boolean = false;
  errorMessage = '';
  selectModule: any;

  constructor(private formBuilder: FormBuilder,
    private errorHandler: ErrorHandler, private datepicker: MatDatepickerModule,
    private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.loanApplicationForm = this.formBuilder.group({
      loanModule: [''],
      loanReference: [''],
      loanAccount: [''],
      applicantName: [''],
      sanctioningAuthority: [''],
      moduleStartDate: [''],
      moduleEndDate: [''],
      dateofAcceptance: [''],
      disbursementDate: [''],
      loanReviewer: [''],
      loanMaker: [''],
      loanChecker: ['']
    });
  }
  changeModule() {
    this.loanApplicationForm.get('loanReference').reset();
    this.loanApplicationForm.get('loanAccount').reset();
    this.loanApplicationForm.get('applicantName').reset();
    this.loanApplicationForm.get('sanctioningAuthority').reset();
    this.loanApplicationForm.get('moduleStartDate').reset();
    this.loanApplicationForm.get('moduleEndDate').reset();
    this.loanApplicationForm.get('dateofAcceptance').reset();
    this.loanApplicationForm.get('disbursementDate').reset();
    this.loanApplicationForm.get('loanReviewer').reset();
    this.loanApplicationForm.get('loanMaker').reset();
    this.loanApplicationForm.get('loanChecker').reset();
    this.selectModule = this.loanApplicationForm.get('loanModule').value;
    console.log("selectModule :: ", this.selectModule);
  }
}