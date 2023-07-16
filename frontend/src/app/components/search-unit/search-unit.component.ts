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

@Component({
  selector: 'app-search-unit',
  templateUrl: './search-unit.component.html',
  styleUrls: ['./search-unit.component.scss']
})
export class searchUnitComponent implements OnInit {
  searchResultUnitForm: FormGroup;
  searchUnitForm: FormGroup;
  pageErrors: any = {};
  isSuccess: boolean = false;
  errorMessage = '';
  search: boolean = true;
  isChecked: boolean = false;
  searchResults: boolean = false;
  unitStatus: string = "D";
  selectedUnit: any;
  isUnitTypeSearch: boolean = false;
  clientOptions: any = [];
  unitTypeOptions: any = [];
  clientGroupOptions: any = [];
  userRoleOptions: any = [];
  hoOptions: any = [];
  zoOptions: any = [];
  cpcOptions: any = [];
  unitName: any;
  isSearchResultFailed = false;
  isCreateUnitFailed = false;
  clientId: any;
  clientGroupId: any;
  clientName: any;
  unitType:any;

  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private errorHandler: ErrorHandler, private slideToggle: MatSlideToggleModule, private referenceService: ReferenceService,
    private clientConfigurationService: ClientConfigurationService, private branchUserService: BranchUserService,private toastr: ToastrService, private authService: AuthService,
    private createUnitService: CreateUnitService,
    private activatedroute: ActivatedRoute)  {
  }

  ngOnInit(): void {
    this.searchUnitForm = this.formBuilder.group({
      searchType: [''],
      searchKeyword: [''],
      clientTypeId: [''],
      clientId: [''],
      unitType: [''],
      clientGroupId: [''],
      userRoleId: ['']
    });
    this.searchResultUnitForm = this.formBuilder.group({
      unitData: this.formBuilder.array([
        this.getUnitData()
      ])
    });
    this.fetchUserData();
    this.registerValues();
    this.registerValueChanges();
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
      });
  }
  registerValues() {
    this.searchUnitForm.get('searchType').valueChanges.subscribe(value => {
      this.searchUnitForm.get('searchKeyword').reset();
      this.searchUnitForm.get('clientTypeId').reset();
      this.searchUnitForm.get('clientId').reset();
      this.searchUnitForm.get('clientGroupId').reset();
      this.searchUnitForm.get('userRoleId').reset();
      this.isSearchResultFailed = false;
      if(value!=null && value!='undefined' && value == 'unittypesearch') {
        this.isUnitTypeSearch= true;
        this.unitTypeOptions = [];
        this.referenceService.getReferenceUnitType().subscribe(result => {
          if (result && result.data) {
            this.unitTypeOptions = result.data;

          }
        });
        
     } else {
        this.isUnitTypeSearch= false;
     }
    });
  }
  
  registerValueChanges() {
   
    if(this.searchUnitForm.get('clientTypeId') !=null && this.searchUnitForm.get('clientTypeId').value != 'undefined') {
	    this.searchUnitForm.get('clientTypeId').valueChanges.subscribe(clientTypeID => {
	      console.log("value", clientTypeID);
	      this.searchUnitForm.get('clientGroupId').reset();
	      this.searchUnitForm.get('clientId').reset();
	      this.searchUnitForm.get('userRoleId').reset();
	      if (clientTypeID && clientTypeID !== undefined) {
	        this.clientOptions = [];
	        this.userRoleOptions = [];
	        this.clientConfigurationService.getClients(clientTypeID).subscribe(result => {
	          if (result && result.data) {
	            this.clientOptions = result.data;
	
	          }
	        });
	        this.referenceService.getReferenceuserRoles(clientTypeID).subscribe(result => {
	          if (result && result.data) {
	            this.userRoleOptions = result.data;
	          }
	        });
	      }
	    });
    }
    if(this.searchUnitForm.get('clientId') !=null && this.searchUnitForm.get('clientId').value != 'undefined') {
	    this.searchUnitForm.get('clientId').valueChanges.subscribe(clientId => {
	      //console.log("value", clientId);
	      this.searchUnitForm.get('clientGroupId').reset();
	      if (clientId && clientId !== undefined) {
	        this.clientGroupOptions = [];
	        this.referenceService.getReferenceClientGroup(clientId).subscribe(result => {
	          if (result && result.data) {
	            this.clientGroupOptions = result.data;
	          }
	        });
	        
	      }
	    });
	  }
  }

  // now we create some service methods for create, add and remove 
  // row inside form
  // create form row.
  private getUnitData() {
    return this.formBuilder.group({
        clientGroupId :[''],
        unitType: [''],
	    unitName: [''],
	    ifscCode: [''],
	    city: [''],
	    unitStatus: [''],
	    createdBy :[''],
	    lastUpdatedDate :['']
    });
  }
  
  // add new row
  addUnit() {
    const control = <FormArray>this.searchResultUnitForm.controls['unitData'];
    control.push(this.getUnitData());
  }
  getUnitDataArrayControl() {
    return (this.searchResultUnitForm.get('unitData') as FormArray).controls;
  }
  
  toggleChanged() {
    this.isChecked = !this.isChecked;
    if(this.isChecked) {
      this.unitStatus = "A";
    } else {
      this.unitStatus = "D";
    }
  }
  
  performSearch() {
    this.searchResults = true;
    let requestData = this.searchUnitForm.value;
    let unitArrData: any = [];
    this.search = false;
    this.searchResults = false;
    this.isSearchResultFailed = false;
    (this.searchResultUnitForm.get('unitData') as FormArray).clear();
    requestData.clientId = this.clientId;
    console.log('performSearch :'+requestData);
    this.createUnitService.getUnits(requestData).subscribe(result => {
      console.log("performSearch:result", result);
      this.searchResults = true;
      if (result && result.data) {
        result.data.forEach(eachData => {
          unitArrData.push({
            clientGroupId: eachData.clientGroupId,
            unitType: eachData.clientGroupType,
            unitName: eachData.unitName,
            ifscCode: eachData.ifscCode,
            city: eachData.city,
            unitStatus: eachData.unitStatus,
            createdBy :eachData.createdBy,
            lastUpdatedDate : eachData.lastUpdatedDate
          });
        });
        unitArrData.forEach((eachArray, index) => {
          this.addUnit();
        });
        this.search = true;
        this.searchResults = true;
      }
      console.log("unitArrData", unitArrData);
      this.searchResultUnitForm.patchValue({
        unitData: unitArrData
      });
    },
    err => {
      console.log("err", err);
      this.errorMessage = err.error.errorMessage;
      this.search = true;
      this.isSearchResultFailed = true;
      this.searchResults = false;
    });
    
  }
  createUnit() {
    this.router.navigate(['home', {
      outlets: {
        appcontent: ['create-unit',null,null]
      }
    }]);
  }

  openUnit(clientGroupId,unitName) {
    this.router.navigate(['home', {
      outlets: {
        appcontent: ['create-unit',clientGroupId,unitName]
      }
    }]);
  }
}