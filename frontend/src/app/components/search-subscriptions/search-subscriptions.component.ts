import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute, Router } from '@angular/router';
import { ErrorHandler } from '../../error/error.handler';
import { SubscriptionService } from '../../services/subscription/subscription.service';
import { forkJoin } from 'rxjs';
import { ReferenceService } from '../../services/reference-service/reference.service';

@Component({
  selector: 'app-search-subscriptions',
  templateUrl: './search-subscriptions.component.html',
  styleUrls: ['./search-subscriptions.component.scss']
})
export class SearchSubscriptionsComponent implements OnInit {

  subscriptionSubTypeOptions: any = [];
  productTypeOptions: any = [];
  subscriptionTypeOptions: any = [];
  subscriptionListForm: FormGroup;
  addSubscriptionForm: FormGroup;
  searchSubscriptionForm: FormGroup;
  pageErrors: any = {};
  isProductType: boolean = false;
  isSubscriptionType: boolean = false;
  isSearchDataAvailable: boolean = false;
  isSubscriptionSubType: boolean = false;
  errorMessage = '';
  isSearchSubscriptionFailed: boolean = false;
  isSearchFailed: boolean = false;
  
  constructor(private formBuilder: FormBuilder, private errorHandler: ErrorHandler, private toastr: ToastrService,
    private subscriptionService: SubscriptionService, private router: Router,private referenceService: ReferenceService) {
  }

  ngOnInit(): void {
    this.searchSubscriptionForm = this.formBuilder.group({
      productTypeId: [''],
      subscriptionTypeId: [''],
      subscriptionSubTypeId:['']
    });
    this.subscriptionListForm = this.formBuilder.group({
	      subscriptionData: this.formBuilder.array([
	        this.getSubscriptionData()
	      ])
	    });
    this.productTypeOptions = [{ productTypeId: 1, productTypename: "e 2 e Solution" },
    { productTypeId: 2, productTypename: "c n c Solution in Audit" }];

    //this.fetchPageData();
    //this.errorHandler.handleErrors(this.searchSubscriptionForm, this.pageErrors);
    this.registerValues();
    this.registerValueChanges();
  }

  registerValueChanges() {

    this.searchSubscriptionForm.get('subscriptionTypeId').valueChanges.subscribe(value => {
      if (value && value != undefined) {
        this.subscriptionSubTypeOptions = [];
        forkJoin([this.referenceService.getReferenceSubscriptionSubType(value)])
          .subscribe(results => {
            console.log("results", results);
            if (results) {
              if (results[0] && results[0].data) {
                this.subscriptionSubTypeOptions = results[0].data;
              }
            }
          });
      }

    });
  }

    
  registerValues() {
    this.searchSubscriptionForm.get('productTypeId').valueChanges.subscribe(value => {
      if (value && value != undefined) {
        let productTypeId = value;
        let subscriptionTypeId = this.searchSubscriptionForm.get('subscriptionTypeId').value;
        let subscriptionSubTypeId = this.searchSubscriptionForm.get('subscriptionSubTypeId').value;
        let subscriptionArrData: any = [];
	    this.searchSubscriptionForm.patchValue({
	      subscriptionData: subscriptionArrData
	    });
                
        if (productTypeId && subscriptionTypeId && subscriptionSubTypeId) {
          this.subscriptionService.loadSubscriptionList(productTypeId,subscriptionTypeId,subscriptionSubTypeId).subscribe(result => {
            console.log("result", result)
            if (result && result.data) {
		        this.isSearchDataAvailable = true;
		        (this.subscriptionListForm.get('subscriptionData') as FormArray).clear();
		        result.data.forEach(eachData => {
		          subscriptionArrData.push({
		            productTypeId: eachData.productTypeId,
		            subscriptionTypeId: eachData.subscriptionTypeId,
		            subscriptionSubTypeId: eachData.subscriptionSubTypeId,
		            subscriptionName: eachData.subscriptionName,
		            subscriptionTypeName: eachData.subscriptionTypeName,
		            subscriptionSubTypeName: eachData.subscriptionSubTypeName,
		            productName: eachData.productName,
		            subscriptionId: eachData.subscriptionId
		          })
		        });
		        subscriptionArrData.forEach((eachArray, index) => {
		          this.addUnit();
		        });
		
		      console.log("subscriptionArrData", subscriptionArrData);
		    
		      this.subscriptionListForm.patchValue({
		        subscriptionData: subscriptionArrData
		      });
				this.isSearchSubscriptionFailed = false;
		        this.isSearchFailed = false;
		      }},
			  err => {
			    console.log("err", err);
			    this.errorMessage = err.error.errorMessage;
			    this.isSearchSubscriptionFailed = true;
			    this.isSearchFailed = false;
			    this.isSearchDataAvailable = false;
			  });
        }
        this.referenceService.getReferenceAllSubscriptionType(this.searchSubscriptionForm.get('productTypeId').value).subscribe(result => {
	        console.log("result", result)
	        if (result && result.data) {
	          this.subscriptionTypeOptions = result.data;
	        }
      	});
      }});
    this.searchSubscriptionForm.get('subscriptionTypeId').valueChanges.subscribe(value => {
      if (value && value != undefined) {
        let productTypeId = this.searchSubscriptionForm.get('productTypeId').value;
        let subscriptionTypeId = value;
        let subscriptionSubTypeId = this.searchSubscriptionForm.get('subscriptionSubTypeId').value;
        let subscriptionArrData: any = [];
	    this.searchSubscriptionForm.patchValue({
	      subscriptionData: subscriptionArrData
	    });
        
        if (productTypeId && subscriptionTypeId && subscriptionSubTypeId) {
          this.subscriptionService.loadSubscriptionList(productTypeId,subscriptionTypeId,subscriptionSubTypeId).subscribe(result => {
            console.log("result", result)
            if (result && result.data) {
		        this.isSearchDataAvailable = true;
		        (this.subscriptionListForm.get('subscriptionData') as FormArray).clear();
		        result.data.forEach(eachData => {
		          subscriptionArrData.push({
		            productTypeId: eachData.productTypeId,
		            subscriptionTypeId: eachData.subscriptionTypeId,
		            subscriptionSubTypeId: eachData.subscriptionSubTypeId,
		            subscriptionName: eachData.subscriptionName,
		            subscriptionTypeName: eachData.subscriptionTypeName,
		            subscriptionSubTypeName: eachData.subscriptionSubTypeName,
		            productName: eachData.productName,
		            subscriptionId: eachData.subscriptionId
		          })
		        });
		        subscriptionArrData.forEach((eachArray, index) => {
		          this.addUnit();
		        });
		      console.log("subscriptionArrData", subscriptionArrData);
		      this.subscriptionListForm.patchValue({
		        subscriptionData: subscriptionArrData
		      });
		      this.isSearchSubscriptionFailed = false;
		        this.isSearchFailed = false;
		      }},
			  err => {
			    console.log("err", err);
			    this.errorMessage = err.error.errorMessage;
			    this.isSearchSubscriptionFailed = true;
			    this.isSearchFailed = false;
			    this.isSearchDataAvailable = false;
			  });
        }
      }});
    this.searchSubscriptionForm.get('subscriptionSubTypeId').valueChanges.subscribe(value => {
      if (value && value != undefined) {
        let productTypeId = this.searchSubscriptionForm.get('productTypeId').value;
        let subscriptionTypeId = this.searchSubscriptionForm.get('subscriptionTypeId').value;
        let subscriptionSubTypeId = value;
        let subscriptionArrData: any = [];
	    this.searchSubscriptionForm.patchValue({
	      subscriptionData: subscriptionArrData
	    });
        
        if (productTypeId && subscriptionTypeId && subscriptionSubTypeId) {
          this.subscriptionService.loadSubscriptionList(productTypeId,subscriptionTypeId,subscriptionSubTypeId).subscribe(result => {
            console.log("result", result)
            if (result && result.data) {
		        this.isSearchDataAvailable = true;
		        (this.subscriptionListForm.get('subscriptionData') as FormArray).clear();
		        result.data.forEach(eachData => {
		          subscriptionArrData.push({
		            productTypeId: eachData.productTypeId,
		            subscriptionTypeId: eachData.subscriptionTypeId,
		            subscriptionSubTypeId: eachData.subscriptionSubTypeId,
		            subscriptionName: eachData.subscriptionName,
		            subscriptionTypeName: eachData.subscriptionTypeName,
		            subscriptionSubTypeName: eachData.subscriptionSubTypeName,
		            productName: eachData.productName,
		            subscriptionId: eachData.subscriptionId
		          })
		        });
		        subscriptionArrData.forEach((eachArray, index) => {
		          this.addUnit();
		        });
		
		      console.log("subscriptionArrData", subscriptionArrData);
		      
		      this.subscriptionListForm.patchValue({
		        subscriptionData: subscriptionArrData
		      });
		      this.isSearchSubscriptionFailed = false;
		        this.isSearchFailed = false;
		      }
			  },
			  err => {
			    console.log("err", err);
			    this.errorMessage = err.error.errorMessage;
			    this.isSearchSubscriptionFailed = true;
			    this.isSearchFailed = false;
			    this.isSearchDataAvailable = false;
			  });

          
        }
      }});
  }

  fetchPageData() {
    (this.subscriptionListForm.get('subscriptionData') as FormArray).clear();
  }

  getSubscriptionDataArrayControl() {
    return (this.subscriptionListForm.get('subscriptionData') as FormArray).controls;
  }

  // now we create some service methods for create, add and remove 
  // row inside form
  // create form row.
  private getSubscriptionData() {
    return this.formBuilder.group({
      productTypeId:[''],
	  subscriptionTypeId: [''],
	  subscriptionSubTypeId:[''],
      productName: [''],
      subscriptionTypeName: [''],
      subscriptionSubTypeName: [''],
      subscriptionName: [''],
      subscriptionId:['']
    });
  }

  removeUnit(i: number) {
    const control = <FormArray>this.subscriptionListForm.controls['subscriptionData'];
    control.removeAt(i);
  }

  // add new row
  addUnit() {
    const control = <FormArray>this.subscriptionListForm.controls['subscriptionData'];
    control.push(this.getSubscriptionData());
  }

  deleteUnit(index) {
    this.toastr.error('There are some issues saving your changes for ' + this.getSubscriptionDataArrayControl()[index].value.subscriptionName + '. Please try again.', 'Warning', {
      timeOut: 4000,
    });
  }


  
  addNewSubscription() {
    this.router.navigate(['home', {
      outlets: {
        appcontent: ['saas-subscription',null]
      }
    }]);
  }
  
  openSubscription(subscriptionId) {
    this.router.navigate(['home', {
      outlets: {
        appcontent: ['saas-subscription',subscriptionId]
      }
    }]);
  }
}
