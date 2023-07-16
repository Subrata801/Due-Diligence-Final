import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';

@Component({
  selector: 'app-initiate-loan-application',
  templateUrl: './initiate-loan-application.component.html',
  styleUrls: ['./initiate-loan-application.component.scss']
})
export class initiateLoanApplicationComponent implements OnInit {
  
  initiateLoanApplicationForm: FormGroup;
  pageErrors: any = {};
  isError: boolean = false;
  isSuccess: boolean = false;
  errorMessage = '';
  search: boolean = true;
  isChecked: boolean = false;
  searchResults: boolean = false;
  status: string = "Inactive";
  selectedUnit: any;

  constructor(private formBuilder: FormBuilder,
    private errorHandler: ErrorHandler, private slideToggle: MatSlideToggleModule,
    private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.initiateLoanApplicationForm = this.formBuilder.group({
      selectModuleA: [''],
      selectModuleB: [''],
      cifNumberAvailability: [''],
      cifNumber: [''],
      selectCifNumber: [''],
      borrowerName: [''],
      creditSector: [''],
      selectAccountNumber: [''],
      selectLoanSchemeType: [''],
      selecte2e: [''],
      moduleStartDate: [''],
      moduleCompletionDate: [''],
      assignBranchMaker: [''],
      comments: ['']
    });
  }
}