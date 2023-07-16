import { Component, OnInit } from '@angular/core';
import { FormArray,FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';
import { ReferenceService } from '../../services/reference-service/reference.service';
import { ClientConfigurationService } from '../../services/client-configuration/client-configuration.service';
import { CreateUnitService } from '../../services/create-unit/create-unit.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../../services/auth-service/auth.service';
import { forkJoin, Observable } from 'rxjs';
import { BranchUserService } from '../../services/branch-users/branch-users.service';
import { timer } from 'rxjs';


@Component({
  selector: 'app-create-unit',
  templateUrl: './create-unit.component.html',
  styleUrls: ['./create-unit.component.scss']
})
export class createUnitComponent implements OnInit {
  createUnitForm: FormGroup;
  pageErrors: any = {};
  isSuccess: boolean = false;
  errorMessage = '';
  search: boolean = true;
  isChecked: boolean = false;
  searchResults: boolean = false;
  unitStatus: string = "A";
  selectedUnit: any;
  isUserTypeSearch: boolean = false;
  clientOptions: any = [];
  clientGroupOptions: any = [];
  userRoleOptions: any = [];
  hoOptions: any = [];
  zoOptions: any = [];
  cpcOptions: any = [];
  unitType: any;
  unitName: any;
  isSearchResultFailed = false;
  isCreateUnitFailed = false;
  clientId: any;
  clientGroupId: any;
  clientName: any;

  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private errorHandler: ErrorHandler, private slideToggle: MatSlideToggleModule, private referenceService: ReferenceService,
    private clientConfigurationService: ClientConfigurationService, private branchUserService: BranchUserService,private toastr: ToastrService, private authService: AuthService,
    private createUnitService: CreateUnitService,
    private activatedroute: ActivatedRoute)  {
      this.clientGroupId = this.activatedroute.snapshot.paramMap.get("unitType");
      this.unitName = this.activatedroute.snapshot.paramMap.get("unitName");
  }

  ngOnInit(): void {
    this.createUnitForm = this.formBuilder.group({
      unitHO: [''],
      unitType: [''],
      unitZone: [''],
      unitCPC: [''],
      unitName: [''],
      ifscCode: [''],
      unitAddress: [''],
      city: [''],
      pincode: [''],
      state: [''],
      unitStatus: [''],
      clientId: ['']
    });
   
    this.fetchUserData();
    this.registerValues();
    this.registerValueChanges();
    if(this.clientGroupId!='null' && this.clientGroupId!=null) {
    	this.loadUnit(this.clientGroupId,this.unitName)
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
	        //this.clientGroupId = results[0].data.clientGroupId;
        }
      });
  }
  
  fetchUserDataBeforeChangeUnit(isFirstLoad,unitType) {
    var clntId = '';
    forkJoin([this.authService.getUserInfo()])
      .subscribe(results => {
        console.log('User Info :'+results[0].data);
        if (results[0] && results[0].data) {
            console.log('User Info :',results[0].data);
	        this.clientId = results[0].data.clientId;
	        this.clientName = results[0].data.clientName;
	        //this.clientGroupId = results[0].data.clientGroupId;
	        this.changeUnit(isFirstLoad,unitType);
        }
      });
  }
  registerValues() {
    
  }
  
  
  registerValueChanges() {
    this.selectedUnit = this.createUnitForm.get('unitType').value;
    if(this.selectedUnit== 2 || this.selectedUnit==3 || this.selectedUnit==4){
      if(this.createUnitForm.get('unitHO')!=null) {
	     this.createUnitForm.get('unitHO').valueChanges.subscribe(unitHO => {
	       if (unitHO && unitHO !== undefined) {
	         this.hoOptions = [];
	         this.zoOptions = [];
	         this.cpcOptions = [];
	         if(this.createUnitForm.get('unitHO')!=null) {
		         this.referenceService.getReferenceZO(this.clientId,this.createUnitForm.get('unitHO').value).subscribe(result => {
		           if (result && result.data) {
		             this.zoOptions = result.data;
		           }
		         });
	         }
	     
	       }
	     });
     }
    }
    if(this.selectedUnit==3 || this.selectedUnit==4){
      if(this.createUnitForm.get('unitZone')!=null) {
	      this.createUnitForm.get('unitZone').valueChanges.subscribe(unitZO => {
	        if (unitZO && unitZO !== undefined) {
	          this.hoOptions = [];
	          this.zoOptions = [];
	          this.cpcOptions = [];
	          if(this.createUnitForm.get('unitZone')!=null) {
		          this.referenceService.getReferenceCPC(this.clientId,this.createUnitForm.get('unitZone').value).subscribe(result => {
		            if (result && result.data) {
		              this.cpcOptions = result.data;
		            }
		          });
	          }
	        }
	      });
      }
    } 
    
  }

 
  loadUnit(clientGroupId,unitName) { 
    this.isCreateUnitFailed = false;
    if(clientGroupId!=null && clientGroupId!=undefined) {
	    this.createUnitService.getUnit(clientGroupId,unitName).subscribe(results => {
	    console.log("results", results);
	    this.createUnitForm.patchValue({
            unitType: results.data.unitType,
            unitName: results.data.unitName,
            ifscCode: results.data.ifscCode,
            city: results.data.city,
            unitAddress : results.data.unitAddress,
            pincode : results.data.pincode,
            state : results.data.state,
            unitStatus: results.data.unitStatus,
            unitHO:results.data.unitHO,
            unitZone:results.data.unitZone,
            unitCPC:results.data.unitCPC,
            clientId: results.data.clientId
	      })
	      this.fetchUserDataBeforeChangeUnit('0',results.data.unitType);
	    
	    },
      err => {
        this.errorMessage = err.errorMessage;
        this.isCreateUnitFailed = true;
      });
    }
  }
  
  toggleChanged() {
    this.isChecked = !this.isChecked;
    if(this.isChecked) {
      this.unitStatus = "A";
    } else {
      this.unitStatus = "D";
    }
  }
  
  sleep(milliseconds: number) {
    let resolve: { (): any; (value: unknown): void; };
    let promise = new Promise((_resolve) => {
      resolve = _resolve;
    });
    setTimeout(() => resolve(), milliseconds);
    return promise;
  }
  
  changeUnit(isFirstLoad,unitType) {
    //alert('isFirstLoad :'+isFirstLoad);
    //alert('unitType :'+unitType);
    if(isFirstLoad != '0') {
	    this.createUnitForm.get('unitHO').reset();
	    this.createUnitForm.get('unitZone').reset();
	    this.createUnitForm.get('unitCPC').reset();
	    this.createUnitForm.get('unitName').reset();
	    this.createUnitForm.get('ifscCode').reset();
	    this.createUnitForm.get('unitAddress').reset();
	    this.createUnitForm.get('city').reset();
	    this.createUnitForm.get('pincode').reset();
	    this.createUnitForm.get('state').reset();
	    this.createUnitForm.get('unitStatus').reset();
	    this.selectedUnit = this.createUnitForm.get('unitType').value;
	} else {
	  //alert('unitType :'+unitType);
	  this.selectedUnit = unitType;
	}
	
    if(this.selectedUnit==2 || this.selectedUnit==3 || this.selectedUnit==4){
      
      this.referenceService.getReferenceHO(this.clientId).subscribe(result => {
          if (result && result.data) {
            this.hoOptions = result.data;
            this.zoOptions = [];
	        this.cpcOptions = [];
	        if(this.createUnitForm.get('unitHO') !=null && this.createUnitForm.get('unitHO').value !=null) {
	            this.referenceService.getReferenceZO(this.clientId,this.createUnitForm.get('unitHO').value).subscribe(result => {
		          if (result && result.data) {
		            this.zoOptions = result.data;
		            //this.sleep(5000).then(() => this.loadCPC())
		            this.loadCPC();
		          }
		        });
	        }
	        
          }
        });
      
    } 
    
  }
  
  changeHOValue(event:any) {
    let hoData = event.value;
    let hoValue = this.hoOptions.filter(ho=>ho.hoId==hoData).map(ho=>ho.hoName);
    if(this.selectedUnit==3 || this.selectedUnit==4){
    	this.loadZO();
    }
  }
  loadZO() {
     this.zoOptions = [];
     if(this.createUnitForm.get('unitHO') !=null) {
	     this.referenceService.getReferenceZO(this.clientId,this.createUnitForm.get('unitHO').value).subscribe(result => {
	      if (result && result.data) {
	        this.zoOptions = result.data;
	        //this.sleep(5000).then(() => this.loadCPC())
	        //this.loadCPC();
	      }
	     });
     }
  }
  changeZOValue(event:any) {
    let zoData = event.value;
    let zoValue = this.zoOptions.filter(zo=>zo.zoId==zoData).map(zo=>zo.zoName);
    if(this.selectedUnit==4){
    	this.loadCPC();
    }
  }
  loadCPC() {
    if(this.createUnitForm.get('unitZone') !=null) {
	     this.referenceService.getReferenceCPC(this.clientId,this.createUnitForm.get('unitZone').value).subscribe(result => {
	      if (result && result.data) {
	        this.cpcOptions = result.data;
	      }
	    });
    }
  }
  searchUnit() {
    this.router.navigate(['home', { outlets: { appcontent: ['search-unit'] } }]);
  }


  performSubmit() {
    const createUnitRequestData: any = this.createUnitForm.value;
    this.isCreateUnitFailed = false;
    //createUnitRequestData.unitStatus = this.unitStatus;
    createUnitRequestData.clientName = this.clientName;
    console.log("createUnitRequestData",createUnitRequestData);
    this.createUnitService.createUnit(createUnitRequestData).subscribe(result => {      
      console.log("createUnitResponseData", result);
      this.toastr.success('Unit has been created successfully ' + createUnitRequestData.unitName, 'Information', {
      timeOut: 3000,
   	   });
   	   this.createUnitForm.reset();
     },err => {
	    this.errorMessage = err.error.errorMessage;
	    this.isCreateUnitFailed = true;
	  });
	
  }
  
  performCancel() {
     if(this.clientGroupId!='null' && this.clientGroupId!=null) {
       this.router.navigate(['home', { outlets: { appcontent: ['search-unit'] } }]);
     } else {
        this.createUnitForm.get('unitHO').reset();
	    this.createUnitForm.get('unitZone').reset();
	    this.createUnitForm.get('unitCPC').reset();
	    this.createUnitForm.get('unitName').reset();
	    this.createUnitForm.get('ifscCode').reset();
	    this.createUnitForm.get('unitAddress').reset();
	    this.createUnitForm.get('city').reset();
	    this.createUnitForm.get('pincode').reset();
	    this.createUnitForm.get('state').reset();
	    this.createUnitForm.get('unitStatus').reset();
	    this.createUnitForm.get('unitType').reset();
	    this.selectedUnit = '';
	 }   
  }

}