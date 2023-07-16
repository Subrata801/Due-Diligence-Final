import { Component, OnInit } from '@angular/core';
import { FormArray,FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';
import { ReassignUserAppService } from '../../services/reassign-user-application/reassign-user-application.service';
import { AuthService } from '../../services/auth-service/auth.service';
import { forkJoin, Observable } from 'rxjs';
import { E2EUserDashboardService } from '../../services/e2e-user-dashboard/e2e-user-dashboard.service';
import { InitiateDueDiligenceService } from 'src/app/services/initiate-due-diligence/initiate-due-diligence.service';

@Component({
  selector: 'app-e2e-application-services',
  templateUrl: './e2e-application-services.component.html',
  styleUrls: ['./e2e-application-services.component.scss']
})
export class e2eApplicationServicesComponent implements OnInit {
  
  e2eAppDashboardForm: FormGroup;
  searchUnitForm: FormGroup;
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
  isSearchResultFailed: boolean = false;
  moduleSelected = 'M1';
  bankName: any;
  branchName: any;
  ifscCode: any;
  unitMakers: any = [];
  unitCheckerOptions: any = [];
  branchMakerOptions: any = [];
  saveReq: any ={};

  constructor(private formBuilder: FormBuilder,
    private errorHandler: ErrorHandler, private slideToggle: MatSlideToggleModule,
    private toastr: ToastrService, private authService: AuthService,
    private reassignUserAppService: ReassignUserAppService,
    private e2eUserDashboardService: E2EUserDashboardService,
	private initiateDueDiligenceService: InitiateDueDiligenceService) {
  }

  ngOnInit(): void {
    this.fetchUserData();
    this.e2eAppDashboardForm = this.formBuilder.group({
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
  }
  

  private getUnitData() {
    return this.formBuilder.group({
      date: [''],
	  e2eNum: [''],
	  nameOfApplicant: [''],
	  appStatus: [''],
	  appFinalStatus: [''],
	  maker: [''],
	  checker : [''],
	  sanctioningAuth:[''],
	  cancelApplication:[''],
	  reasonOfCancellation:[''],
	  securityReleaseNum:['']
    });
  }
  // add new row
  adde2eM1Data() {
    const control = <FormArray>this.e2eAppDashboardForm.controls['unitM1Data'];
    control.push(this.getUnitData());
  }
  adde2eM2Data() {
    const control = <FormArray>this.e2eAppDashboardForm.controls['unitM2Data'];
    control.push(this.getUnitData());
  }
  adde2eM3Data() {
    const control = <FormArray>this.e2eAppDashboardForm.controls['unitM3Data'];
    control.push(this.getUnitData());
  }
  adde2eM4Data() {
    const control = <FormArray>this.e2eAppDashboardForm.controls['unitM4Data'];
    control.push(this.getUnitData());
  }
  adde2eM5Data() {
    const control = <FormArray>this.e2eAppDashboardForm.controls['unitM5Data'];
    control.push(this.getUnitData());
  }
  gete2eDataM1ArrayControl() {
    if(null!=this.e2eAppDashboardForm.get('unitM1Data') ) {
		let arr = (this.e2eAppDashboardForm.get('unitM1Data') as FormArray).controls;
		return arr;
    }
  }
  
  gete2eDataM2ArrayControl() {
    if(null!=this.e2eAppDashboardForm.get('unitM2Data') ) {
    	return (this.e2eAppDashboardForm.get('unitM2Data') as FormArray).controls;
    }
  }
  
  gete2eDataM3ArrayControl() {
    if(null!=this.e2eAppDashboardForm.get('unitM3Data') ) {
    	return (this.e2eAppDashboardForm.get('unitM3Data') as FormArray).controls;
    }
  }
  
  gete2eDataM4ArrayControl() {
    if(null!=this.e2eAppDashboardForm.get('unitM4Data') ) {
    	return (this.e2eAppDashboardForm.get('unitM4Data') as FormArray).controls;
    }
  }
  
  gete2eDataM5ArrayControl() {
    if(null!=this.e2eAppDashboardForm.get('unitM5Data') ) {
    	return (this.e2eAppDashboardForm.get('unitM5Data') as FormArray).controls;
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
        this.fetchBankDetails(this.clientGroupId);
        this.selectedModule(0,this.clientId,this.clientName,this.clientGroupId);
		this.getDropDownData(this.clientId, this.clientGroupId);
      });
  }
  private getDropDownData(clntId:any, clientGrpId:any) {
	this.initiateDueDiligenceService.getUnitChecker(clientGrpId).subscribe(results => {
		console.log("results :: loaded unit checkers", results);
		if (results && results.data) {
		  this.unitCheckerOptions = results.data;
		}
	  });

	  this.initiateDueDiligenceService.getListOfBranchMakers(clientGrpId).subscribe(results => {
		console.log("results :: loaded unit makers", results);
		if (results && results.data) {
		  this.branchMakerOptions = results.data;
		}
	  });
  }
  fetchBankDetails(clientGroupId:any) {
    forkJoin([this.e2eUserDashboardService.getE2EBankDetails(clientGroupId)])
      .subscribe(results => {
        if (results[0] && results[0].data) {
            console.log('User Info :',results[0].data);
            this.bankName = results[0].data.bankName;
            this.branchName = results[0].data.branchName,
            this.ifscCode= results[0].data.ifscCode
       }
      });
   
  }
  
  selectedModule($event,clientId,clientName,clientGroupId){
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
	    this.reassignUserAppService.getModuleSpecificUserAppDetails(this.clientId,this.clientGroupId,this.moduleSelected,this.clientName).subscribe(results => {
		    console.log("reassigned:results:", results);
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
		              date: eachData.date,
					  e2eNum: eachData.e2eNum,
					  nameOfApplicant: eachData.nameOfApplicant,
					  appStatus: eachData.appStatus,
					  appFinalStatus: eachData.appFinalStatus,
					  maker: eachData.maker,
					  checker :eachData.checker,
					  sanctioningAuth:eachData.sanctioningAuth,
					  cancelApplication:eachData.cancelApplication,
					  reasonOfCancellation:eachData.reasonOfCancellation,
					  securityReleaseNum:eachData.securityReleaseNum
		          });
		        });
		        if(this.moduleSelected=='M1') {
		          (this.e2eAppDashboardForm.get('unitM1Data') as FormArray).clear();
		          unitArrData.forEach((eachArray, index) => {
		          this.adde2eM1Data();
		        });
		        } else if(this.moduleSelected=='M2') {
		          (this.e2eAppDashboardForm.get('unitM2Data') as FormArray).clear();
		          unitArrData.forEach((eachArray, index) => {
		          this.adde2eM2Data();
		        });
		        } else if(this.moduleSelected=='M3') {
		          (this.e2eAppDashboardForm.get('unitM3Data') as FormArray).clear();
		          unitArrData.forEach((eachArray, index) => {
			          this.adde2eM3Data();
			        });
		        } else if(this.moduleSelected=='M4') {
		           (this.e2eAppDashboardForm.get('unitM4Data') as FormArray).clear();
		            unitArrData.forEach((eachArray, index) => {
			          this.adde2eM4Data();
			        });
		        } else if(this.moduleSelected=='M5') {
		          (this.e2eAppDashboardForm.get('unitM5Data') as FormArray).clear();
		          unitArrData.forEach((eachArray, index) => {
		            this.adde2eM5Data();
		          });
		        } 
		        
		
		      }
		      console.log("unitArrData", unitArrData);
		      if(this.moduleSelected=='M1') {
		          this.e2eAppDashboardForm.patchValue({
			        unitM1Data: unitArrData
			      });
		        } else if(this.moduleSelected=='M2') {
		          this.e2eAppDashboardForm.patchValue({
			        unitM2Data: unitArrData
			      });
		        } else if(this.moduleSelected=='M3') {
		          this.e2eAppDashboardForm.patchValue({
			        unitM3Data: unitArrData
			      });
		        } else if(this.moduleSelected=='M4') {
		          this.e2eAppDashboardForm.patchValue({
			        unitM4Data: unitArrData
			      });
		        } else if(this.moduleSelected=='M5') {
		          this.e2eAppDashboardForm.patchValue({
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

	save(e2eNo:any,bMaker:any,uChecher:any,SA:any,isCancel:any,cancelReason:any) {
		console.log('save:e2eNo='+e2eNo+':bMaker='+bMaker.value+':uChecker='+uChecher.value+":SA="+SA.value+":isCancel="+isCancel.value
		+":cancelReason:"+cancelReason.value);
		this.saveReq.e2e = e2eNo;
		this.saveReq.branchMaker = bMaker.value;
		this.saveReq.unitChecker = uChecher.value;
		this.saveReq.sanctionedAuthority = SA.value;
		this.saveReq.isCancel = isCancel.value;
		this.saveReq.cancelReason = cancelReason.value;

		console.log('saveReassignUser:saveReq:', this.saveReq);
    	this.reassignUserAppService.saveReassignUser(this.saveReq).subscribe(results => {
      	console.log('saveReassignUser:response:',results);
			if (!results.metaData.success) {
			this.isError = true;
			this.errorMessage = results.metaData.description;
			this.toastr.error('Error while saving', 'Information', {
			timeOut: 3000,
			});
      	} else {
			let successMessage = results.data.messageDescription;
			console.log('status message:', successMessage);
			this.toastr.success('Saved Successfully', 'Information', {
			timeOut: 3000,
			});
          }
		},
		err => {
			console.log("saveViewDD:err", err);
			this.errorMessage = err.error.errorMessage;
			this.isError = true;
			this.toastr.error('Error while saving', 'Information', {
				timeOut: 3000,
			});
		});
	}
    
}