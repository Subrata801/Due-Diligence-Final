import { ErrorHandler, Component, OnInit, Input } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { CreateNewClientService } from 'src/app/services/client-new/create-new-client.service';
import { ReferenceService } from 'src/app/services/reference-service/reference.service';
import { filter } from "lodash";
import { TokenStorageService } from 'src/app/services/token-service/token-storage.service';

@Component({
  selector: 'app-search-client',
  templateUrl: './search-client.component.html',
  styleUrls: ['./search-client.component.scss']
})
export class SearchClientComponent implements OnInit {

  clientSearch: FormGroup;
  searchResults: FormGroup;
  pageErrors: any = {};
  isSuccess: boolean = false;
  isSearchResult: boolean = false;
  isError: boolean = false;
  search = false;
  errorMessage = '';
  clientTypesOptions: any = [];
  roles: string[] = [];
  @Input()
  admin: boolean = false;
  required: boolean = true;
  action: boolean = true;
  isClientNameSearch: boolean = false;
  isTemplateSearch: boolean = false;
  activeClientOptions: any = [];
  constructor(private formBuilder: FormBuilder, private errorHandler: ErrorHandler, private router: Router,
    private toastrService: ToastrService, private createNewClientService: CreateNewClientService,
    private referenceService: ReferenceService, private tokenService: TokenStorageService) {
  }

  ngOnInit(): void {
    this.roles = this.tokenService.getUser().roles;
    if(this.roles[0] == 'BMTRADMIN') {
    	this.admin = true;
    } else {
   		this.admin = false;
    }
    this.clientSearch = this.formBuilder.group({
      clientTypeId: ['2', { updateOn: 'change' }],
      clientName: ['', { updateOn: 'change' }],
      keywordType: [''],
      templateStatus:[''],
      clientId:['']
    });

    this.searchResults = this.formBuilder.group({
      searchResultData: this.formBuilder.array([
        this.getSearchResults()
      ])
    });

    this.referenceService.getReferenceClientTypes().subscribe((results: any) => {
      //console.log("results", results);
      if (results && results.data) {
        this.clientTypesOptions = results.data;
      }
    });
    this.registerValues();
  }

  registerValues() {
    this.clientSearch.get('keywordType').valueChanges.subscribe(value => {
      this.search = false;
      this.clientSearch.get('clientTypeId').reset();
      this.clientSearch.get('clientName').reset();
      this.clientSearch.get('templateStatus').reset();
      this.clientSearch.get('clientId').reset();
      this.isSearchResult = false;
      this.isError = false;
      this.errorMessage = '';
      (this.searchResults.get('searchResultData') as FormArray).clear();
      if(value!=null && value!='undefined') {
        if(value == 'clientnamesearch') {
          this.isClientNameSearch= true;
          this.isTemplateSearch = false;
	    } else if(value == 'templatesearch') {
          this.isClientNameSearch= false;
          this.isTemplateSearch = true;
          this.fetchActiveClientData();
	    } else {
	      this.isClientNameSearch= false;
          this.isTemplateSearch = false;
	    }
	   }   
    });
    
  }
  
  fetchActiveClientData() {
    this.createNewClientService.getActiveClient().subscribe((results: any) => {
      if (results && results.data) {
        this.activeClientOptions = results.data;
      }
    });
  }
  
  getSearchResults() {
    return this.formBuilder.group({
      clientId: [''],
      clientTypeId: [''],
      clientType: [''],
      clientName: [''],
      clientPrefix: [''],
      lastUpdatedDate: [''],
      updatedBy :[''],
      subscriptionStatus: [''],
      clientTemplateStatus: [''],
      clientLoanSchemeName:['']
    });
  }

  getSearchDataArrayControl() {
    return (this.searchResults.get('searchResultData') as FormArray).controls;
  }

  addSearchResult() {
    const control = <FormArray>this.searchResults.controls['searchResultData'];
    control.push(this.getSearchResults());
  }

  getMatchingClientTypeName(clientTypeId) {
    let clientTypeMatched = filter(this.clientTypesOptions, { clientTypeId: clientTypeId });
    if (clientTypeMatched && clientTypeMatched.clientTypeName) {
      return clientTypeMatched.clientTypeName;
    }
    return '';
  }

  clearSearchClients() {
        this.isError = false;
  		this.isSearchResult = false;
  		if(this.isTemplateSearch) {
  			this.clientSearch.get('templateStatus').reset();
        	this.clientSearch.get('clientId').reset();
        } else {
            this.search = !this.search;
        }
  }
  getMatchingSubscriptionStatus(subscriptionStatus) {
    if("PENDING"===subscriptionStatus){
      return "Pending";
    } else if ("COMPLETED"===subscriptionStatus) {
    	return "Completed";
    }
    
    return subscriptionStatus;
  }

  printThis(value){
    console.log("value",value);
  }
  searchClients() {
    this.search = !this.search;
    
    if (!this.clientSearch.invalid && this.clientSearch.get('clientName').value != '') {
      let searchResultDataArr: any = [];
      (this.searchResults.get('searchResultData') as FormArray).clear();
      this.createNewClientService.
        getMatchingClients(this.clientSearch.get('clientTypeId').value, this.clientSearch.get('clientName').value)
        .subscribe(results => {
          //console.log("results", results);
          if (results && results.data) {
            results.data.forEach(eachData => {
              searchResultDataArr.push({
                clientId: eachData.clientId,
                clientName: eachData.clientName,
                clientType: this.getMatchingClientTypeName(eachData.clientType),
                clientPrefix: eachData.clientPrefix,
                lastUpdatedDate: eachData.lastUpdatedDate,
                updatedBy :eachData.updatedBy,
                subscriptionStatus: this.getMatchingSubscriptionStatus(eachData.status),
                clientTemplateStatus :eachData.clientTemplateStatus,
                clientLoanSchemeName :eachData.clientLoanSchemeName
              });
            });
            searchResultDataArr.forEach((eachArray, index) => {
              this.addSearchResult();
              this.isSearchResult = true;
              this.isError = false;
            });

          }
          //console.log("searchResultDataArr", searchResultDataArr,searchResultDataArr.length);
          this.searchResults.patchValue({
            searchResultData: searchResultDataArr
          });
        },
	      err => {
	        console.log("err", err);
	        this.errorMessage = err.error.errorMessage;
	        this.isError = true;
	        this.isSearchResult = false;
	      });
      //console.log("this.searchResults", this.getSearchDataArrayControl());
    } else {
   		 this.errorMessage = 'Client Type is required';
	     this.isError = true;
	     this.isSearchResult = false;
	     this.search = !this.search;
    }
  }

  searchTemplateClients() {
    //this.search = !this.search;
    if (this.clientSearch.get('clientId').value != null
      || this.clientSearch.get('templateStatus').value !=null) {
      let searchResultDataArr: any = [];
      (this.searchResults.get('searchResultData') as FormArray).clear();
      this.createNewClientService.
        getMatchingClientsByTemplate(this.clientSearch.get('clientId').value, this.clientSearch.get('templateStatus').value)
        .subscribe(results => {
          if (results && results.data) {
            results.data.forEach(eachData => {
              searchResultDataArr.push({
                clientId: eachData.clientId,
                clientName: eachData.clientName,
                clientType: this.getMatchingClientTypeName(eachData.clientType),
                clientPrefix: eachData.clientPrefix,
                lastUpdatedDate: eachData.lastUpdatedDate,
                updatedBy :eachData.updatedBy,
                subscriptionStatus: this.getMatchingSubscriptionStatus(eachData.status),
                clientTemplateStatus :eachData.clientTemplateStatus,
                clientLoanSchemeName :eachData.clientLoanSchemeName
              });
            });
            searchResultDataArr.forEach((eachArray, index) => {
              this.addSearchResult();
              this.isSearchResult = true;
              this.isError = false;
              this.search = true;
            });

          }
          //console.log("searchResultDataArr", searchResultDataArr,searchResultDataArr.length);
          this.searchResults.patchValue({
            searchResultData: searchResultDataArr
          });
        },
	      err => {
	        console.log("err", err);
	        this.errorMessage = err.error.errorMessage;
	        this.isError = true;
	        this.isSearchResult = false;
	      });
      //console.log("this.searchResults", this.getSearchDataArrayControl());
    } 
    else {
   		 this.errorMessage = 'ClientName / Template Status is required';
	     this.isError = true;
	     this.isSearchResult = false;
	     this.search = !this.search;
    }
  }


  openClient(clientTypeId,clientName,clientId,subscriptionStatus){
    this.action = false;
    //if (!this.admin) {
    //  this.router.navigate(['home', {
    //    outlets: {
    //      appcontent: ['v1-templates',
    //      this.clientSearch.get('clientTypeId').value, clientName, clientId, this.action, subscriptionStatus]
    //    }
    //  }]);
    //} else {
    //  this.router.navigate(['home', {
    //    outlets: {
    //      appcontent: ['new-client',
    //      this.clientSearch.get('clientTypeId').value, clientName, clientId, this.action, subscriptionStatus]
    //    }
    //  }]);
    //}
    
    this.router.navigate(['home', {
        outlets: {
          appcontent: ['new-client',
          this.clientSearch.get('clientTypeId').value, clientName, clientId, this.action, subscriptionStatus]
        }
      }]);
  }

  createNew() {
    this.action = true;
    if (!this.clientSearch.invalid && this.clientSearch.get('clientName').value != '' 
          &&  this.clientSearch.get('clientName').value != 'null' &&  this.clientSearch.get('clientName').value != null) {
      this.router.navigate(['home', {
        outlets: {
          appcontent: ['new-client',
            this.clientSearch.get('clientTypeId').value, this.clientSearch.get('clientName').value,undefined,this.action,undefined]
        }
      }]);
    } else {
   		 this.errorMessage = 'Client Name is required';
	     this.isError = true;
	     this.isSearchResult = false;
    }
  }


}
