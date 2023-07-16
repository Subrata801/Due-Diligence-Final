import { Component, OnInit } from '@angular/core';
import { FormArray,FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';
import { E2ERealTimeDashboardService } from '../../services/e2e-realtime-dashboard/e2e-realtime-dashboard.service';
import { AuthService } from '../../services/auth-service/auth.service';
import { forkJoin, Observable } from 'rxjs';

@Component({
  selector: 'app-e2e-management-dashboard',
  templateUrl: './e2e-management-dashboard.component.html',
  styleUrls: ['./e2e-management-dashboard.component.scss']
})
export class e2eManagementDashboardComponent implements OnInit {
  
  e2eRealTimeDashboardForm: FormGroup;
  pageErrors: any = {};
  isError: boolean = false;
  isSuccess: boolean = false;
  errorMessage = '';
  search: boolean = true;
  isChecked: boolean = false;
  searchResultsM1: boolean = false;
  searchResultsM2: boolean = false;
  searchResultsM3: boolean = false;
  searchResultsM4: boolean = false;
  searchResultsM5: boolean = false;
  status: string = "Inactive";
  selectedUnit: any;
  clientId: any;
  clientGroupId: any;
  clientName: any;
  zoName: any;
  cpcName: any;
  branchName: any;
  ifscCode: any;
  isSearchResultFailed: boolean = false;
  moduleSelected = 'M1';

  constructor(private formBuilder: FormBuilder,
    private errorHandler: ErrorHandler, private slideToggle: MatSlideToggleModule,
    private toastr: ToastrService,private authService:AuthService,
    private e2eRealTimeDashboardService:E2ERealTimeDashboardService) {
  }

  ngOnInit(): void {
    this.fetchUserData();
    
    this.e2eRealTimeDashboardForm = this.formBuilder.group({
      unitM1Data: this.formBuilder.array([
        this.getUnitData()
      ]),
      unitM2Data: this.formBuilder.array([
        this.getUnitData()
      ]),
      unitM3Data: this.formBuilder.array([
        this.getUnitData()
      ]),
      unitM4Data: this.formBuilder.array([
        this.getUnitData()
      ]),
      unitM5Data: this.formBuilder.array([
        this.getUnitData()
      ])
    });
    //this.selectedModule(0);
  }
  
  private getUnitData() {
    return this.formBuilder.group({
      date: [''],
      e2eNum: [''],
      borrowerName: [''],
      cifNum: [''],
      reviewNum: [''],
      loanApplicationNum: [''],
      reviewScheduleDate :[''],
      applicationStatus:[''],
      userName:[''],
      applicationFinalStatus:[''],
      m4ReviewNo:[''],
      m5SecurityReleaseNo:['']
    });
  }
  // add new row
  adde2eM1Data() {
    const control = <FormArray>this.e2eRealTimeDashboardForm.controls['unitM1Data'];
    control.push(this.getUnitData());
  }
  adde2eM2Data() {
    const control = <FormArray>this.e2eRealTimeDashboardForm.controls['unitM2Data'];
    control.push(this.getUnitData());
  }
  adde2eM3Data() {
    const control = <FormArray>this.e2eRealTimeDashboardForm.controls['unitM3Data'];
    control.push(this.getUnitData());
  }
  adde2eM4Data() {
    const control = <FormArray>this.e2eRealTimeDashboardForm.controls['unitM4Data'];
    control.push(this.getUnitData());
  }
  adde2eM5Data() {
    const control = <FormArray>this.e2eRealTimeDashboardForm.controls['unitM5Data'];
    control.push(this.getUnitData());
  }
  gete2eDataM1ArrayControl() {
    if(null!=this.e2eRealTimeDashboardForm.get('unitM1Data') ) {
    	return (this.e2eRealTimeDashboardForm.get('unitM1Data') as FormArray).controls;
    }
  }
  
  gete2eDataM2ArrayControl() {
    if(null!=this.e2eRealTimeDashboardForm.get('unitM2Data') ) {
    	return (this.e2eRealTimeDashboardForm.get('unitM2Data') as FormArray).controls;
    }
  }
  
  gete2eDataM3ArrayControl() {
    if(null!=this.e2eRealTimeDashboardForm.get('unitM3Data') ) {
    	return (this.e2eRealTimeDashboardForm.get('unitM3Data') as FormArray).controls;
    }
  }
  
  gete2eDataM4ArrayControl() {
    if(null!=this.e2eRealTimeDashboardForm.get('unitM4Data') ) {
    	return (this.e2eRealTimeDashboardForm.get('unitM4Data') as FormArray).controls;
    }
  }
  
  gete2eDataM5ArrayControl() {
    if(null!=this.e2eRealTimeDashboardForm.get('unitM5Data') ) {
    	return (this.e2eRealTimeDashboardForm.get('unitM5Data') as FormArray).controls;
    }
  }
  
  fetchUserData() {
    var clntId = '';
    forkJoin([this.authService.getUserInfo()])
      .subscribe(results => {
        if (results[0] && results[0].data) {
            console.log('User Info :',results[0].data);
	        this.clientId = results[0].data.clientId;
	        this.clientName = results[0].data.clientName;
	        this.clientGroupId = results[0].data.clientGroupId;
        }
        this.fetchBankDetails(this.clientName);
        this.selectedModule(0,this.clientId,this.clientName,this.clientGroupId);
      });
  }
  
  fetchBankDetails(clientName:any) {
    forkJoin([this.e2eRealTimeDashboardService.getE2EBankDetails(clientName)])
      .subscribe(results => {
        if (results[0] && results[0].data) {
            console.log('bank details loaded ::',results[0].data);
            this.zoName = results[0].data.zoName;
            this.cpcName = results[0].data.cpcName,
            this.branchName = results[0].data.branchName,
            this.ifscCode= results[0].data.ifscCode
       }
      });
   
  }
  
  selectedModule($event,clientId,clientName,clientGroupId){
    console.log('module changed');
    if($event.index==1) {
      this.moduleSelected = 'M2';
    } else if($event.index==2) {
      this.moduleSelected = 'M3';
    } else if($event.index==3) {
      this.moduleSelected = 'M4';
    }  else if($event.index==4) {
      this.moduleSelected = 'M5';
    } else {
      this.moduleSelected = 'M1';
    }
    
    let unitArrData: any = [];
    this.isSearchResultFailed = false;
    if(null!=this.clientId && 'null'!=this.clientId && undefined!=this.clientId ){
	    this.e2eRealTimeDashboardService.getE2ERealTimeDashBoardTasks(this.clientId,this.clientGroupId,this.moduleSelected,this.clientName).subscribe(results => {
		    console.log("results", results);
		    if (results && results.data) {
		        
		        if(this.moduleSelected=='M1') {
		          this.searchResultsM1 = true;
		        } else if(this.moduleSelected=='M2') {
		          this.searchResultsM2 = true;
		        } else if(this.moduleSelected=='M3') {
		          this.searchResultsM3 = true;
		        } else if(this.moduleSelected=='M4') {
		          this.searchResultsM4 = true;
		        } else if(this.moduleSelected=='M5') {
		          this.searchResultsM5 = true;
		        } 
		        results.data.forEach(eachData => {
		          unitArrData.push({
		              date: eachData.dateField,
					  e2eNum: eachData.e2eNum,
					  reviewNum: eachData.reviewNum,
					  borrowerName: eachData.borrowerName,
					  cifNum: eachData.cifNumber,
					  loanApplicationNum: eachData.loanApplicationNum,
					  reviewScheduleDate :eachData.reviewScheduleDate,
					  applicationStatus:eachData.applicationStatus,
					  userName:eachData.userName,
					  applicationFinalStatus:eachData.applicationFinalStatus,
            m4ReviewNo: eachData.m4ReviewNo,
            m5SecurityReleaseNo: eachData.m5SecurityReleaseNo
		          });
		        });
		        if(this.moduleSelected=='M1') {
		          (this.e2eRealTimeDashboardForm.get('unitM1Data') as FormArray).clear();
		          unitArrData.forEach((eachArray, index) => {
		          this.adde2eM1Data();
		        });
		        } else if(this.moduleSelected=='M2') {
		          (this.e2eRealTimeDashboardForm.get('unitM2Data') as FormArray).clear();
		          unitArrData.forEach((eachArray, index) => {
		          this.adde2eM2Data();
		        });
		        } else if(this.moduleSelected=='M3') {
		          (this.e2eRealTimeDashboardForm.get('unitM3Data') as FormArray).clear();
		          unitArrData.forEach((eachArray, index) => {
			          this.adde2eM3Data();
			        });
		        } else if(this.moduleSelected=='M4') {
		           (this.e2eRealTimeDashboardForm.get('unitM4Data') as FormArray).clear();
		            unitArrData.forEach((eachArray, index) => {
			          this.adde2eM4Data();
			        });
		        } else if(this.moduleSelected=='M5') {
		          (this.e2eRealTimeDashboardForm.get('unitM5Data') as FormArray).clear();
		          unitArrData.forEach((eachArray, index) => {
		            this.adde2eM5Data();
		          });
		        } 
		        
		        
		      }
		      console.log("unitArrData", unitArrData);
		      if(this.moduleSelected=='M1') {
		          this.e2eRealTimeDashboardForm.patchValue({
			        unitM1Data: unitArrData
			      });
		        } else if(this.moduleSelected=='M2') {
		          this.e2eRealTimeDashboardForm.patchValue({
			        unitM2Data: unitArrData
			      });
		        } else if(this.moduleSelected=='M3') {
		          this.e2eRealTimeDashboardForm.patchValue({
			        unitM3Data: unitArrData
			      });
		        } else if(this.moduleSelected=='M4') {
		          this.e2eRealTimeDashboardForm.patchValue({
			        unitM4Data: unitArrData
			      });
		        } else if(this.moduleSelected=='M5') {
		          this.e2eRealTimeDashboardForm.patchValue({
			        unitM5Data: unitArrData
			      });
		        }
		    },
	      err => {
	        this.errorMessage = err.error.errorMessage;
	        this.isSearchResultFailed = true;
	        if(this.moduleSelected=='M1') {
	          this.searchResultsM1 = false;
	        } else if(this.moduleSelected=='M2') {
	          this.searchResultsM2 = false;
	        } else if(this.moduleSelected=='M3') {
	          this.searchResultsM3 = false;
	        } else if(this.moduleSelected=='M4') {
	          this.searchResultsM4 = false;
	        } else if(this.moduleSelected=='M5') {
	          this.searchResultsM5 = false;
	        } 
	      });
	    }
	 }
}