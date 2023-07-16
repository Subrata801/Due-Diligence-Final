import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';

@Component({
  selector: 'app-bank-services',
  templateUrl: './bank-services.component.html',
  styleUrls: ['./bank-services.component.scss']
})
export class BankServicesComponent implements OnInit {
  
  bankServicesForm: FormGroup;
  pageErrors: any = {};
  isError: boolean = false;
  isSuccess: boolean = false;
  errorMessage = '';
  isChecked: boolean = false;
  confirmation: boolean = false;
  status: string = "Inactive";
  selectService: any;
  selectUnitType: any;
  selectBranch: any;
  selectUser: any;
  selectScheme: any;
  selectdeactivationActions1: any;
  selectdeactivationActions2: any;
  actionsDate: any;
  
  users: string[] = ['Ravi','Anis','Amit','Prem','Sanket','Yuvaraj','Arun','Devi','Rathika','Arpita'];
  userRoles: string[] = ['BRMKR','BRMKR-STDBY','BRCHKR','BRCHKR-STDBY','BRSA','CPCCHKR','CPCCHKR-STDBY','CPCSA','ZOCHKR','ZOCHKR-STDBY','ZOSA','HOCHKR','HOCHKR-STDBY','HOSA','AFMKR','AFCHKR','AFSA','BNADMIN','BNMGMT','BMTRADMIN','BMTRMGMT'];
  loanSchemes: string[] = ['Personal Loan','Consumer Loan','Mortgage Loan','Vehicle Loan','Home Loan','Business Loan','Educational Loan','Gold Loan','Overdraft Loan'];
  branches: string[] = ['Magarpatta','Koregaon','Chinchwad','Kharadi','Keshav Nagar','Pimpri','Kothrud','Khed','Khadki','Shivaji Nagar','Alandi'];

  constructor(private formBuilder: FormBuilder,
    private errorHandler: ErrorHandler, private datepicker: MatDatepickerModule,
    private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.bankServicesForm = this.formBuilder.group({
      service: [''],
      unitType: [''],
      unit: [''],
      user: [''],
      branch: [''],
      loanScheme: [''],
      employeeID: [''],
      employeeName: [''],
      deactivationActions1: [''],
      deactivationActions2: [''],
      deactivationActions3: [''],
      deactivationUnit: [''],
      mergingUnit: [''],
      userNewRole: [''],
      actionsEffectiveDate: [''],
      actionDate: [''],
      circularNumber: [''],
      circularDate: [''],
      modifierEmployeeID: [''],
      modifierEmployeeName: [''],
      designation: [''],
      effectiveDate: ['']
    });
  }

  toggleChanged() {
    this.isChecked = !this.isChecked;
    if(this.isChecked) {
      this.status = "Active";
    } else {
      this.status = "Inactive";
    }
  }

  resetDD() {
    this.bankServicesForm.get('unit').reset();
    this.bankServicesForm.get('user').reset();
    this.bankServicesForm.get('branch').reset();
    this.bankServicesForm.get('loanScheme').reset();
    this.bankServicesForm.get('deactivationActions1').reset();
    this.bankServicesForm.get('deactivationActions2').reset();
    this.bankServicesForm.get('deactivationActions3').reset();
    this.bankServicesForm.get('deactivationUnit').reset();
    this.bankServicesForm.get('mergingUnit').reset();
    this.bankServicesForm.get('userNewRole').reset();
    this.bankServicesForm.get('actionsEffectiveDate').reset();
    this.bankServicesForm.get('actionDate').reset();
    this.selectUser = '';
    this.selectScheme = '';
    this.selectUnitType = '';
    this.selectdeactivationActions1 = '';
    this.selectdeactivationActions2 = '';
    this.actionsDate = '';
    this.selectService = this.bankServicesForm.get('service').value;
  }
  changeUnit() {
    this.bankServicesForm.get('user').reset();
    this.bankServicesForm.get('branch').reset();
    this.bankServicesForm.get('loanScheme').reset();
    this.bankServicesForm.get('deactivationActions1').reset();
    this.bankServicesForm.get('deactivationActions2').reset();
    this.bankServicesForm.get('deactivationActions3').reset();
    this.bankServicesForm.get('deactivationUnit').reset();
    this.bankServicesForm.get('mergingUnit').reset();
    this.bankServicesForm.get('userNewRole').reset();
    this.bankServicesForm.get('actionsEffectiveDate').reset();
    this.bankServicesForm.get('actionDate').reset();
    this.selectUser = '';
    this.selectScheme = '';
    this.selectdeactivationActions1 = '';
    this.selectdeactivationActions2 = '';
    this.actionsDate = '';
    this.selectUnitType = this.bankServicesForm.get('unit').value;
  }
  changeUser() {
    this.bankServicesForm.get('branch').reset();
    this.bankServicesForm.get('loanScheme').reset();
    this.bankServicesForm.get('deactivationActions1').reset();
    this.bankServicesForm.get('deactivationActions2').reset();
    this.bankServicesForm.get('deactivationActions3').reset();
    this.bankServicesForm.get('deactivationUnit').reset();
    this.bankServicesForm.get('mergingUnit').reset();
    this.bankServicesForm.get('userNewRole').reset();
    this.bankServicesForm.get('actionsEffectiveDate').reset();
    this.bankServicesForm.get('actionDate').reset();
    this.selectdeactivationActions1 = '';
    this.selectdeactivationActions2 = '';
    this.actionsDate = '';
    this.selectUser = this.bankServicesForm.get('unit').value;
  }
  changeBranch() {
    this.bankServicesForm.get('loanScheme').reset();
    this.bankServicesForm.get('deactivationActions1').reset();
    this.bankServicesForm.get('deactivationActions2').reset();
    this.bankServicesForm.get('deactivationActions3').reset();
    this.bankServicesForm.get('deactivationUnit').reset();
    this.bankServicesForm.get('mergingUnit').reset();
    this.bankServicesForm.get('userNewRole').reset();
    this.bankServicesForm.get('actionsEffectiveDate').reset();
    this.bankServicesForm.get('actionDate').reset();
    this.selectdeactivationActions1 = '';
    this.selectdeactivationActions2 = '';
    this.actionsDate = '';
    this.selectBranch = this.bankServicesForm.get('branch').value;
  }
  changeScheme() {
    this.bankServicesForm.get('deactivationActions1').reset();
    this.bankServicesForm.get('deactivationActions2').reset();
    this.bankServicesForm.get('deactivationActions3').reset();
    this.bankServicesForm.get('deactivationUnit').reset();
    this.bankServicesForm.get('mergingUnit').reset();
    this.bankServicesForm.get('userNewRole').reset();
    this.bankServicesForm.get('actionsEffectiveDate').reset();
    this.bankServicesForm.get('actionDate').reset();
    this.selectdeactivationActions1 = '';
    this.selectdeactivationActions2 = '';
    this.actionsDate = '';
    this.selectScheme = this.bankServicesForm.get('loanScheme').value;
  }
  changeDeactivationActions1() {
    this.bankServicesForm.get('deactivationUnit').reset();
    this.bankServicesForm.get('mergingUnit').reset();
    this.bankServicesForm.get('userNewRole').reset();
    this.selectdeactivationActions2 = '';
    this.actionsDate = '';
    this.selectdeactivationActions1 = this.bankServicesForm.get('deactivationActions1').value;
  }
  changeDeactivationActions2() {
    this.bankServicesForm.get('deactivationUnit').reset();
    this.bankServicesForm.get('mergingUnit').reset();
    this.bankServicesForm.get('userNewRole').reset();
    this.actionsDate = '';
    this.selectdeactivationActions2 = this.bankServicesForm.get('deactivationActions2').value;
  }
  /* changeDeactivationActions3() {
    this.bankServicesForm.get('deactivationUnit').reset();
    this.bankServicesForm.get('mergingUnit').reset();
    this.bankServicesForm.get('userNewRole').reset();
  } */
  changeActionsDate() {
    this.actionsDate = this.bankServicesForm.get('actionsEffectiveDate').value;
  }
  save() {
    this.confirmation = !this.confirmation;
  }
  review() {
    this.confirmation = !this.confirmation;
    this.bankServicesForm.get('circularNumber').reset();
    this.bankServicesForm.get('circularDate').reset();
    this.bankServicesForm.get('modifierEmployeeID').reset();
    this.bankServicesForm.get('modifierEmployeeName').reset();
    this.bankServicesForm.get('designation').reset();
    this.bankServicesForm.get('effectiveDate').reset();
  }
  submit() {
    console.log("Submit this form");
  }
}