import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';

@Component({
  selector: 'app-e2e-form',
  templateUrl: './e2e-form.component.html',
  styleUrls: ['./e2e-form.component.scss']
})
export class e2eFormComponent implements OnInit {
  
  e2eForm: FormGroup;
  pageErrors: any = {};
  isError: boolean = false;
  isSuccess: boolean = false;
  errorMessage = '';
  search: boolean = true;
  isChecked: boolean = false;
  searchResults: boolean = false;
  status: string = "Inactive";
  selectedUnit: any;
  movablePropertyTypesList: string[] = ['Stock of Goods', 'Book Debts', 'Receivables', 'Plant & Machinery / Equipments', 'Vehicle', 'Bank Deposit', 'NSC/KVP/BONDS', 'Life Insurance Policy', 'Gold Jewellery', 'Shares'];

  constructor(private formBuilder: FormBuilder,
    private errorHandler: ErrorHandler, private slideToggle: MatSlideToggleModule,
    private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.e2eForm = this.formBuilder.group({
      e2eNumber: [''],
      e2eM4ReviewNumber: [''],
      e2eM5ReviewNumber: [''],
      e2eDate: [''],
      branchName: [''],
      cifNumber: [''],
      borrowerName: [''],
      creditSector: [''],
      selectExistingAccNo: [''],
      selectLoanSchemeType: [''],
      selectVariantType: [''],
      selecte2e: [''],
      accountNumber: [''],
      sanctionDate: [''],
      sanctionedAmount: [''],
      sanctionedAmountWords: [''],
      loanTenor: [''],
      revisedLoanTenor: [''],
      loanApplicationNumber: [''],
      loanApplicationDate: [''],
      moduleStartDate: [''],
      moduleCompletionDate: [''],
      sanctionAcceptanceDate: [''],
      m4ReviewStartDate: [''],
      m4ReviewCompletionDate: [''],
      m4ReviewSanctionDate: [''],
      auditAccountType: [''],
      borrowerType: [''],
      borrowerCategory: [''],
      security: [''],
      securityType: [''],
      movablePropertyTypes: [''],
      assignBranchMaker: [''],
      assignBranchChecker: [''],
      assignSanctioningAuthority: [''],
      assignSanctioningAuthority2: [''],
      accountStatus: [''],
      closureDate: [''],
      cpcUnit: [''],
      accountStatus2: [''],
      periodicReviews: [''],
      comments: ['']
    });
  }
}