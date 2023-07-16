import { Component, OnInit, Pipe, PipeTransform } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';
import { MatTableDataSource } from '@angular/material/table';
export interface loanApplications {
  name: string;
  e2eRef: string;
  appNo: string;
  accNo: string;
}

const ELEMENT_DATA: loanApplications[] = [
  {
    "name": "Anil Ambani",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "7575678787778"
  }, {
    "name": "Mukesh Ambani",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "4574578767867"
  }, {
    "name": "Ratan Tata",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "3453547456757"
  }, {
    "name": "Jamdesh Tata",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "3345687978678"
  }, {
    "name": "Sapna",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "5634563456768"
  }, {
    "name": "Nirupama",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "3453423567886"
  }, {
    "name": "Anil Ambani",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "7575678787778"
  }, {
    "name": "Mukesh Ambani",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "4574578767867"
  }, {
    "name": "Ratan Tata",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "3453547456757"
  }, {
    "name": "Jamdesh Tata",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "3345687978678"
  }, {
    "name": "Sapna",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "5634563456768"
  }, {
    "name": "Nirupama",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "3453423567886"
  }, {
    "name": "Anil Ambani",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "7575678787778"
  }, {
    "name": "Mukesh Ambani",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "4574578767867"
  }, {
    "name": "Ratan Tata",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "3453547456757"
  }, {
    "name": "Jamdesh Tata",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "3345687978678"
  }, {
    "name": "Sapna",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "5634563456768"
  }, {
    "name": "Nirupama",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "3453423567886"
  }, {
    "name": "Anil Ambani",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "7575678787778"
  }, {
    "name": "Mukesh Ambani",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "4574578767867"
  }, {
    "name": "Ratan Tata",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "3453547456757"
  }, {
    "name": "Jamdesh Tata",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "3345687978678"
  }, {
    "name": "Sapna",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "5634563456768"
  }, {
    "name": "Nirupama",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "3453423567886"
  }, {
    "name": "Anil Ambani",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "7575678787778"
  }, {
    "name": "Mukesh Ambani",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "4574578767867"
  }, {
    "name": "Ratan Tata",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "3453547456757"
  }, {
    "name": "Jamdesh Tata",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "3345687978678"
  }, {
    "name": "Sapna",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "5634563456768"
  }, {
    "name": "Nirupama",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "3453423567886"
  }, {
    "name": "Anil Ambani",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "7575678787778"
  }, {
    "name": "Mukesh Ambani",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "4574578767867"
  }, {
    "name": "Ratan Tata",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "3453547456757"
  }, {
    "name": "Jamdesh Tata",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "3345687978678"
  }, {
    "name": "Sapna",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "5634563456768"
  }, {
    "name": "Nirupama",
    "e2eRef": "e2eABC654654",
    "appNo": "5645464645654",
    "accNo": "3453423567886"
  }
];

@Component({
  selector: 'app-any-stage-processing',
  templateUrl: './any-stage-processing.component.html',
  styleUrls: ['./any-stage-processing.component.scss']
})

export class AnyStageProcessingComponent implements OnInit {
  
  anyStageForm: FormGroup;
  pageErrors: any = {};
  isError: boolean = false;
  isSuccess: boolean = false;
  show: boolean = false;
  errorMessage = '';
  selectAccountOptions1: any;
  selectAccountOptions2: any;
  selectM4Options: any;
  selectM3Options: any;
  displayedColumns: string[] = ['sno', 'name', 'e2eRef', 'appNo', 'accNo', 'action'];
  dataSource: any = ELEMENT_DATA;

  constructor(private formBuilder: FormBuilder,
    private errorHandler: ErrorHandler, private datepicker: MatDatepickerModule,
    private toastr: ToastrService) {
  }

  //public dataSource = new MatTableDataSource<loanApplications>();
  public doFilter = (value: string) => {
    console.log("filter value :: ", value);
    console.log("filter trim :: ", value.trim().toLocaleLowerCase());
    this.dataSource.filter = value.trim().toLocaleLowerCase();
  }

  ngOnInit(): void {
    //this.searchFormInit();
    this.anyStageForm = this.formBuilder.group({
      selectAccount: [''],
      selectModuleA: [''],
      selectModuleB: [''],
      selectM4: [''],
      selectM3: ['']
    });
  }

  search() {
    this.show = !this.show;
    this.selectAccountOptions1 = this.anyStageForm.get('selectAccount').value;
    this.selectAccountOptions2 = this.anyStageForm.get('selectModuleB').value;
    this.selectM4Options = this.anyStageForm.get('selectM4').value;
    this.selectM3Options = this.anyStageForm.get('selectM3').value;

    console.log("selectAccountOptions1 ::", this.selectAccountOptions1, " | selectAccountOptions2 ::", this.selectAccountOptions2, " | selectM4Options ::", this.selectM4Options, " | selectM3Options ::", this.selectM3Options);
  }
  resetAccount() {
    this.show = false;
    this.anyStageForm.get('selectModuleB').reset();
    this.anyStageForm.get('selectM4').reset();
    this.anyStageForm.get('selectM3').reset();
    this.selectAccountOptions2 = '';
    this.selectM4Options = '';
    this.selectAccountOptions1 = this.anyStageForm.get('selectAccount').value;
  }
  resetModuleB() {
    this.show = false;
    this.anyStageForm.get('selectM4').reset();
    this.anyStageForm.get('selectM3').reset();
    this.selectM4Options = '';
    this.selectAccountOptions2 = this.anyStageForm.get('selectModuleB').value;
  }
  resetM4() {
    this.show = false;
    this.anyStageForm.get('selectM3').reset();
    this.selectM4Options = this.anyStageForm.get('selectM4').value;
  }
  resetM3() {
    this.show = false;
  }
}