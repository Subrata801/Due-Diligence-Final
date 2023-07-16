import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';

@Component({
  selector: 'app-any-stage-processing-level2',
  templateUrl: './any-stage-processing-level2.component.html',
  styleUrls: ['./any-stage-processing-level2.component.scss']
})
export class AnyStageProcessingComponentLevel2 implements OnInit {
  
  anyStageLevel2Form: FormGroup;
  pageErrors: any = {};
  isError: boolean = false;
  isSuccess: boolean = false;
  show: boolean = false;
  errorMessage = '';
  creditSectorOptions: any;
  securityOptions: any;
  key1: any;
  key3: any;
  key4: any;
  key5: any;
  module: any;
  viewComments: boolean = false;
  loanScheme: any;
  
  loanSchemes: string[] = ['Personal Loan','Consumer Loan','Mortgage Loan','Vehicle Loan','Home Loan','Business Loan','Educational Loan','Gold Loan','Overdraft Loan'];
  loanVariants: string[] = ['Salaried Load','Pension Loan','PERSONAL LOAN FOR MEETING EXPENSES FOR MARRIAGE / SOCIAL EVENTS','PERSONAL LOAN FOR MEETING MEDICAL EXPENSES','PERSONAL LOAN FOR PURCHASE OF HOUSEHOLD ARTICLES (FLEXI PAY - BUY NOW,PAY LATER)'];
  commercialLoanVariant: string[] = ['Clean Overdraft','Secured Overdraft against Book Debts','Secured Overdraft against Movable Property','Secured Overdraft against Immovable Property','Open Cash Credit','Packing Credit','Drawee Bills','Working Capital Term Loan (Demand Loan)','Inland Bills Purchased/Discontinued/Negotiated','Foreign Bills Purchased/Negotiated','Letter of Credit','Guarantees','Deferred Payment Guarantee'];
  applicables: string[] = ['Co-Applicant','Co-Applicant 1','Co-Applicant 2','Co-Applicant 3','Co-Applicant 4','Guarantor','Guarantor 1','Guarantor 2','Guarantor 3','Guarantor 4'];

  constructor(private formBuilder: FormBuilder, private activatedroute: ActivatedRoute,
    private errorHandler: ErrorHandler, private datepicker: MatDatepickerModule, private router: Router,
    private toastr: ToastrService) {
      this.key1 = this.activatedroute.snapshot.paramMap.get("key1");
      this.key3 = this.activatedroute.snapshot.paramMap.get("key3");
      this.key4 = this.activatedroute.snapshot.paramMap.get("key4");
      this.key5 = this.activatedroute.snapshot.paramMap.get("key5");
      this.module = this.activatedroute.snapshot.paramMap.get("module");
  }

  ngOnInit(): void {
    console.log("key1 :: ", this.key1);
    console.log("key3 :: ", this.key3);
    console.log("key4 :: ", this.key4);
    console.log("key5 :: ", this.key5);

    this.anyStageLevel2Form = this.formBuilder.group({
      e2eApplicationNumber: [''],
      M4e2eApplicationNumber: [''],
      applicationDate: [''],
      moduleStartDate: [''],
      moduleCompletionDate: [''],
      applicantName: [''],
      loanApplicationNumber: [''],
      applicationReceiptDate: [''],
      borrowerAcceptanceDate: [''],
      M4OpenDate: [''],
      M4CloseDate: [''],
      loanTenure: [''],
      revisedLoanTenure: [''],
      reviewCycle: [''],
      M4reviewSanctionDate: [''],
      creditSector: [''],
      rcLoanType: [''],
      ccLoanType: [''],
      retailLoanVariant: [''],
      commercialLoanVariants: [''],
      CC: [''],
      applicablesList: [''],
      retailBorrowerTypes: [''],
      commercialBorrowerTypes: [''],
      applicantProfession: [''],
      security: [''],
      securityTypesList: [''],
      movableSecurityTypesList: [''],
      reviewComments: ['']
    });
  }

  search() {

  }

  M4Date: any;
  datechanged() {
    var dt = this.anyStageLevel2Form.get('borrowerAcceptanceDate').value;
    dt.setMonth(dt.getMonth() + 5);
    this.M4Date = dt;
  }
  resetCreditSector() {
    console.log("resetCreditSector");
    this.anyStageLevel2Form.get('rcLoanType').reset();
    this.anyStageLevel2Form.get('ccLoanType').reset();
    this.anyStageLevel2Form.get('retailLoanVariant').reset();
    this.anyStageLevel2Form.get('commercialLoanVariants').reset();
    this.anyStageLevel2Form.get('CC').reset();
    this.anyStageLevel2Form.get('applicablesList').reset();
    this.anyStageLevel2Form.get('retailBorrowerTypes').reset();
    this.anyStageLevel2Form.get('commercialBorrowerTypes').reset();
    this.anyStageLevel2Form.get('applicantProfession').reset();
    this.anyStageLevel2Form.get('security').reset();
    this.anyStageLevel2Form.get('securityTypesList').reset();
    this.anyStageLevel2Form.get('movableSecurityTypesList').reset();
    this.anyStageLevel2Form.get('reviewComments').reset();
    this.creditSectorOptions = this.anyStageLevel2Form.get('creditSector').value;
  }
  changeSecurity() {
    this.securityOptions = this.anyStageLevel2Form.get('security').value;
  }
  securityTypes(e) {
    let selection = e;
    console.log("securityTypesList ::: ", selection);
    console.log("securityTypesList Selected ::: ", selection.options[0]._element.nativeElement.innerText);
  }
  clearData() {
    this.anyStageLevel2Form.reset();
    this.resetCreditSector();
  }
  comments() {
    this.viewComments = !this.viewComments;
    console.log("this.viewComments ::: ", this.viewComments);
  }
  changeScheme() {
    this.loanScheme = this.anyStageLevel2Form.get('rcLoanType').value;
  }
  
  review(){
    this.router.navigate(['home', {
      outlets: {
        appcontent: ['module-headers']
      }
    }]);
  }
}
