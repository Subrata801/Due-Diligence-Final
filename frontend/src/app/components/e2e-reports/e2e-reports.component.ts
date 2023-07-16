import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { ToastrService } from 'ngx-toastr';
import { E2EUserDashboardService } from 'src/app/services/e2e-user-dashboard/e2e-user-dashboard.service';
import { ErrorHandler } from '../../error/error.handler';

@Component({
  selector: 'app-e2e-reports',
  templateUrl: './e2e-reports.component.html',
  styleUrls: ['./e2e-reports.component.scss']
})
export class e2eReportsComponent implements OnInit {

  e2eReports: FormGroup;
  pageErrors: any = {};
  isError: boolean = false;
  isSuccess: boolean = false;
  errorMessage = '';

  constructor(private formBuilder: FormBuilder,
    private errorHandler: ErrorHandler, private slideToggle: MatSlideToggleModule,
    private toastr: ToastrService,
    private e2eUserDashboardService: E2EUserDashboardService) {
  }

  ngOnInit(): void {
    this.e2eReports = this.formBuilder.group({
      e2eNumber: [''],
      cncNumber: [''],
      moduleNo: ['']
    });
  }

  getFullReport() {
    let e2eNum = this.e2eReports.value.e2eNumber;
    let moduleNum = this.e2eReports.value.moduleNo;
    let fileName = 'e2e_FullReport.xlsx';
    console.log('e2eNumber : ' + e2eNum + ": moduleNum :" + moduleNum);
    if (e2eNum == undefined || e2eNum == null || e2eNum == '' || moduleNum == undefined || moduleNum == null || moduleNum == '') {
      this.isError = true;
      this.errorMessage = 'Please enter E2E number and module name';
    } else {
      this.e2eUserDashboardService.getE2EFullReport(e2eNum, moduleNum).subscribe((response) => {
        console.log('getFullReport:response:' + response);

        var blob = new Blob([response], { type: 'application/vnd.ms-excel' });

        if (window.navigator && window.navigator.msSaveOrOpenBlob) {
          window.navigator.msSaveOrOpenBlob(blob, fileName);
        } else {
          var a = document.createElement('a');
          a.href = URL.createObjectURL(blob);
          a.download = fileName;
          document.body.appendChild(a);
          a.click();
          document.body.removeChild(a);
        }

      }, (error) => {
        this.isError = true;
        this.errorMessage = 'Unable to generate report, please contact administrator';
        console.log('getFullReport:error:' + JSON.stringify(error));
      })
    }
  }
}