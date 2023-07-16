import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';

@Component({
  selector: 'app-close-loan',
  templateUrl: './close-loan.component.html',
  styleUrls: ['./close-loan.component.scss']
})
export class CloseLoanComponent implements OnInit {
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
      loanReference: [''],
      loanAccount: [''],
      applicantName: [''],
      loanMaker: [''],
      loanChecker: ['']
    });
  }
}