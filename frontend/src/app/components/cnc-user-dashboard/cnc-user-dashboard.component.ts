import { Component, OnInit } from '@angular/core';
import { FormArray,FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';
import { CNCUserDashboardService } from '../../services/cnc-user-dashboard/cnc-user-dashboard.service';
import { AuthService } from '../../services/auth-service/auth.service';
import { forkJoin, Observable } from 'rxjs';

@Component({
  selector: 'app-cnc-user-dashboard',
  templateUrl: './cnc-user-dashboard.component.html',
  styleUrls: ['./cnc-user-dashboard.component.scss']
})
export class cncUserDashboardComponent implements OnInit {
  cncDashboardForm: FormGroup;
  pageErrors: any = {};
  isError: boolean = false;
  isSuccess: boolean = false;
  errorMessage = '';
  search: boolean = true;
  isChecked: boolean = false;
  searchResults: boolean = false;
  status: string = "Inactive";
  selectedUnit: any;
  searchResultsM1: boolean = false;
  searchResultsM2: boolean = false;
  searchResultsM3: boolean = false;
  searchResultsM4: boolean = false;
  clientId: any;
  clientGroupId: any;
  clientName: any;
  isSearchResultFailed: boolean = false;
  moduleSelected = 'M1';

  constructor(private formBuilder: FormBuilder,
    private errorHandler: ErrorHandler, private slideToggle: MatSlideToggleModule,
    private toastr: ToastrService, private authService: AuthService,
    private cncUserDashboardService: CNCUserDashboardService) {
  }

  ngOnInit(): void {
    this.fetchUserData();
    
    if(this.moduleSelected == 'M1') {
	    this.cncDashboardForm = this.formBuilder.group({
	      unitM1Data: this.formBuilder.array([
	        this.getUnitData()
	      ])
	    });
    } else if(this.moduleSelected == 'M2') {
	    this.cncDashboardForm = this.formBuilder.group({
	      unitM2Data: this.formBuilder.array([
	        this.getUnitData()
	      ])
	    });
    } else if(this.moduleSelected == 'M3') {
	    this.cncDashboardForm = this.formBuilder.group({
	      unitM3Data: this.formBuilder.array([
	        this.getUnitData()
	      ])
	    });
    } else if(this.moduleSelected == 'M4') {
	    this.cncDashboardForm = this.formBuilder.group({
	      unitM4Data: this.formBuilder.array([
	        this.getUnitData()
	      ])
	    });
    } 
  }
  private getUnitData() {
    return this.formBuilder.group({
      date: [''],
      bankName: [''],
      branchName: [''],
      ifscCode: [''],
      cncNum: [''],
      borrowerName :[''],
      cifNumber:[''],
      userName:[''],
      auditStatus:[''],
      applicationFinalStatus:['']
    });
  }
  
    // add new row
  adde2eM1Data() {
    const control = <FormArray>this.cncDashboardForm.controls['unitM1Data'];
    control.push(this.getUnitData());
  }
  adde2eM2Data() {
    const control = <FormArray>this.cncDashboardForm.controls['unitM2Data'];
    control.push(this.getUnitData());
  }
  adde2eM3Data() {
    const control = <FormArray>this.cncDashboardForm.controls['unitM3Data'];
    control.push(this.getUnitData());
  }
  adde2eM4Data() {
    const control = <FormArray>this.cncDashboardForm.controls['unitM4Data'];
    control.push(this.getUnitData());
  }
  
    gete2eDataM1ArrayControl() {
    if(null!=this.cncDashboardForm.get('unitM1Data') ) {
    	return (this.cncDashboardForm.get('unitM1Data') as FormArray).controls;
    }
  }
  
  gete2eDataM2ArrayControl() {
    if(null!=this.cncDashboardForm.get('unitM2Data') ) {
    	return (this.cncDashboardForm.get('unitM2Data') as FormArray).controls;
    }
  }
  
  gete2eDataM3ArrayControl() {
    if(null!=this.cncDashboardForm.get('unitM3Data') ) {
    	return (this.cncDashboardForm.get('unitM3Data') as FormArray).controls;
    }
  }
  
  gete2eDataM4ArrayControl() {
    if(null!=this.cncDashboardForm.get('unitM4Data') ) {
    	return (this.cncDashboardForm.get('unitM4Data') as FormArray).controls;
    }
  }
  
  fetchUserData() {
    var clntId = '';
    forkJoin([this.authService.getUserInfo()])
      .subscribe(results => {
        console.log('User Info :'+results[0].data);
        if (results[0] && results[0].data) {
            console.log('User Info :',results[0].data);
	        this.clientId = results[0].data.clientId;
	        this.clientName = results[0].data.clientName;
	        this.clientGroupId = results[0].data.clientGroupId;
        }
        this.selectedModule(0,this.clientId,this.clientName,this.clientGroupId);
      });
  }
  
  selectedModule($event,clientId,clientName,clientGroupId){
    if($event.index==1) {
      this.moduleSelected = 'M2';
    } else if($event.index==2) {
      this.moduleSelected = 'M3';
    } else if($event.index==3) {
      this.moduleSelected = 'M4';
    } else {
      this.moduleSelected = 'M1';
    }
    
    
    let unitArrData: any = [];
    if(null!=this.clientId && 'null'!=this.clientId && undefined!=this.clientId ){
	    this.cncUserDashboardService.getCNCDashBoardTasks(this.clientId,this.moduleSelected,this.clientName).subscribe(results => {
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
		        } 
		        results.data.forEach(eachData => {
		          unitArrData.push({
		              date: eachData.date,
				      bankName: eachData.bankName,
				      branchName: eachData.branchName,
				      ifscCode: eachData.ifscCode,
				      cncNum: eachData.cncNum,
				      borrowerName :eachData.borrowerName,
				      cifNumber:eachData.cifNumber,
				      userName:eachData.userName,
				      auditStatus:eachData.auditStatus,
				      applicationFinalStatus:eachData.applicationFinalStatus
		          });
		        });
		        if(this.moduleSelected=='M1') {
		          unitArrData.forEach((eachArray, index) => {
		          this.adde2eM1Data();
		        });
		        } else if(this.moduleSelected=='M2') {
		          unitArrData.forEach((eachArray, index) => {
		          this.adde2eM2Data();
		        });
		        } else if(this.moduleSelected=='M3') {
		          unitArrData.forEach((eachArray, index) => {
			          this.adde2eM3Data();
			        });
		        } else if(this.moduleSelected=='M4') {
		            unitArrData.forEach((eachArray, index) => {
			          this.adde2eM4Data();
			        });
		        } 
		
		      }
		      console.log("unitArrData", unitArrData);
		      if(this.moduleSelected=='M1') {
		          this.cncDashboardForm.patchValue({
			        unitM1Data: unitArrData
			      });
		        } else if(this.moduleSelected=='M2') {
		          this.cncDashboardForm.patchValue({
			        unitM2Data: unitArrData
			      });
		        } else if(this.moduleSelected=='M3') {
		          this.cncDashboardForm.patchValue({
			        unitM3Data: unitArrData
			      });
		        } else if(this.moduleSelected=='M4') {
		          this.cncDashboardForm.patchValue({
			        unitM4Data: unitArrData
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
	        } 
	      });
	    }
    }
}