import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';

@Component({
  selector: 'app-risk-score',
  templateUrl: './risk-score.component.html',
  styleUrls: ['./risk-score.component.scss']
})
export class RiskScoreComponent implements OnInit {
  
  riskScoreForm: FormGroup;
  pageErrors: any = {};
  isError: boolean = false;
  isSuccess: boolean = false;
  errorMessage = '';

  constructor(private formBuilder: FormBuilder,
    private errorHandler: ErrorHandler, private datepicker: MatDatepickerModule,
    private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.riskScoreForm = this.formBuilder.group({
      DocumentDate1: [''],
      DocumentDate2: [''],
      formControl1: [''],
      formControl2: [''],
      formControl3: ['']
    });
  }
}