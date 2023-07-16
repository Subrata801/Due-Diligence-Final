import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { forkJoin, Observable } from 'rxjs';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';
import { ActivatedRoute, Router } from '@angular/router';
import { InitiateDueDiligenceService } from 'src/app/services/initiate-due-diligence/initiate-due-diligence.service';
import { AuthService } from 'src/app/services/auth-service/auth.service';
import { HttpErrorResponse, HttpEvent, HttpEventType } from '@angular/common/http';
//import { saveAs } from 'file-saver';
@Component({
  selector: 'app-due-diligence-non-compliant',
  templateUrl: './due-diligence-non-compliant.component.html',
  styleUrls: ['./due-diligence-non-compliant.component.scss']
})
export class dueDiligenceNonCompliantComponent implements OnInit {
  
  @ViewChild('selectedAction') selectedDropdown: ElementRef;
  initiateDueDiligenceForm: FormGroup;
  pageErrors: any = {};
  e2e: any;
  isError: boolean = false;
  isSuccess: boolean = false;
  errorMessage = '';
  search: boolean = true;
  isChecked: boolean = false;
  searchResults: boolean = false;
  isNewTable: boolean;
  status: string = "Inactive";
  selectedUnit: any;
  panelOpenState: boolean = false;

  actionDropdownOptions: any = [];
  reportTableData: any=[];
  reportTableData2: any=[];
  selectedAction: any = [];
  assessmentForm: FormGroup;
  actionsForm: FormGroup;
  clientId: any;
  clientGroupId: any;
  clientName: any;
  userName: any;
  userId: any;
  constructor(private formBuilder: FormBuilder, private router: Router,
    private errorHandler: ErrorHandler, private slideToggle: MatSlideToggleModule,
    private toastr: ToastrService, private activatedroute: ActivatedRoute,
    private initiateDueDiligenceService: InitiateDueDiligenceService,private authService: AuthService,
    private toastrService: ToastrService) {
      this.e2e = this.activatedroute.snapshot.paramMap.get("e2e");
  }

  ngOnInit(): void {
    this.assessmentForm = this.formBuilder.group({
      applicantName: [''],
      e2eNumber: [''],
      cifNumber: [''],
      loanDate: [''],
      unit: [''],
      user: [''],
      loanScheme: [''],
      loanVariant: ['']
    });

    this.actionsForm = this.formBuilder.group({
      actionName: ['']
    });

    this.fetchUserData();
    this.loadHeader();
    //this.loadTableData();
    this.actionDropdown();
    this.getRiskType();
  }

 
  loadTableData() {
    console.log("loading report Table Data :: e2eNum", this.e2e);
    this.initiateDueDiligenceService.getReportTableData(this.e2e).subscribe(results => {
      console.log("loaded results :: fetched reporting table data ", results);
      if (results && results.data) {
        this.reportTableData = results.data;
       } 
    });
  }
  loadTableData2() {
    console.log("loading report Table Data2 :: e2eNum", this.e2e);
    this.initiateDueDiligenceService.getReportTableData(this.e2e).subscribe(results => {
      console.log("loaded results :: fetched reporting table data2 ", results);
      if (results && results.data) {
        this.reportTableData2 = results.data;
       } 
    });
  }
  getRiskType(){
    this.initiateDueDiligenceService.getRiskTypeId().subscribe(results =>{
      if(results && results.data){
        console.log('getRiskType:results.data:',results.data);
        if(results.data==1){
          this.isNewTable=true;
          this.loadTableData2();
        } else {
          this.isNewTable=false;
          this.loadTableData();
        }
      }
    })
  }
  actionDropdown() {
    console.log("loading actionDropdown :: userName", this.userName);
    this.initiateDueDiligenceService.getReportingActions(this.userName).subscribe(results => {
      console.log("loaded results :: fetched reporting actions", results);
      if (results && results.data) {
        this.actionDropdownOptions = results.data;
       }
    });
  }
  
  loadHeader() {
    this.initiateDueDiligenceService.getReportingHeader(this.e2e).subscribe(results => {
      console.log("loaded results :: fetched reporting headers", results);
      if (results && results.data) {
        this.assessmentForm.patchValue({
          applicantName: results.data.applicantName,
          e2eNumber: this.e2e,
          cifNumber: results.data.cifNumber,
          loanDate: results.data.loanDate,
          unit: results.data.loanUnit,
          user: results.data.loanUser,
          loanScheme: results.data.loanScheme,
          loanVariant: results.data.loanVariant
        })
      }
    });
  }

  fetchUserData() {
    var clntId = '';
    forkJoin([this.authService.getUserInfo()])
      .subscribe(results => {
        console.log('User Info all :'+results[0].data);
        if (results[0] && results[0].data) {
            console.log('User Info first :',results[0].data);
            console.log("results[0].data.userName:", results[0].data.userName);
	        this.clientId = results[0].data.clientId;
	        this.clientName = results[0].data.clientName;
	        this.clientGroupId = results[0].data.clientGroupId;
          this.userName = results[0].data.userName;
          this.userId = results[0].data.userId;
          console.log("user info fecthed successfully1 :: userId ::" + this.userId +" :: userName ::"+ this.userName);
        }
      });
    console.log("user info fecthed successfully2 :: userId ::" + this.userId +" :: userName ::"+ this.userName);
  }

  openActionPoints(i, rowName, columnName){
    let rowNum:any=i+1;
    console.log("table clicked on rowNo:"+rowNum+" :: rowName:"+rowName+" :: columnName:"+columnName+" :: e2eNum:"+this.e2e);
    this.initiateDueDiligenceService.generateReport(this.e2e, rowName, columnName).subscribe(results => {
      console.log("loaded results :: generate report status", results);
      if (!results.metaData.success) {
        this.isError = true;
        this.errorMessage = results.metaData.description;
      } else {
        this.toastrService.success('Report Generated Successfully', 'Information', {
          timeOut: 3000,
        });
        this.downloadFile(results.data);
      }
    },
    err => {
      console.log("err", err);
      this.errorMessage = err.error.errorMessage;
      this.isError = true;
    });
  }

  downloadFile(fileName: any) {
    this.initiateDueDiligenceService.getDownloadFile(fileName).subscribe(response=>{
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
    },
		err => {
		  console.log("err", err);
		  //alert("Error while downloading. File Not Found on the Server");
      this.toastrService.error('Error while downloading. File Not Found on the Server', 'Information', {
        timeOut: 3000,
      });
		})
  }

  selectAction(option) {
    console.log('action selected with value :',option.value);
    console.log('username :',this.userName);
    this.initiateDueDiligenceService.getUpdateStatus(this.e2e, option.value).subscribe(results => {
      console.log("loaded results :: updated status", results);
      if (!results.metaData.success) {
        this.isError = true;
        this.errorMessage = results.metaData.description;
      } else {
        this.toastrService.success('Report generated successfully', 'Information', {
          timeOut: 3000,
        });
      }
    },
    err => {
      console.log("err", err);
      this.errorMessage = err.error.errorMessage;
      this.isError = true;
    });
  }

  back() {
    console.log("Back to Due Diligence");
    this.router.navigate(['home', {
      outlets: {
        appcontent: ['initiate-due-diligence',this.e2e]
      }
    }]);
  }
}


