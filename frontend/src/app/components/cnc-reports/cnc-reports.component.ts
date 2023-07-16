import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';

@Component({
  selector: 'app-cnc-reports',
  templateUrl: './cnc-reports.component.html',
  styleUrls: ['./cnc-reports.component.scss']
})
export class cncReportsComponent implements OnInit {
  
  cncReports: FormGroup;
  pageErrors: any = {};
  isError: boolean = false;
  isSuccess: boolean = false;
  errorMessage = '';

  constructor(private formBuilder: FormBuilder,
    private errorHandler: ErrorHandler, private slideToggle: MatSlideToggleModule,
    private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.cncReports = this.formBuilder.group({
      e2eNumber: [''],
      cncNumber: ['']
    });
  }
}