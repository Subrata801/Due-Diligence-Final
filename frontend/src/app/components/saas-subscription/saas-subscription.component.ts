import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute, Router } from '@angular/router';
import { forkJoin } from 'rxjs';
import { ErrorHandler } from '../../error/error.handler';
import { ReferenceService } from '../../services/reference-service/reference.service';
import { SubscriptionService } from '../../services/subscription/subscription.service';

@Component({
  selector: 'app-saas-subscription',
  templateUrl: './saas-subscription.component.html',
  styleUrls: ['./saas-subscription.component.scss']
})
export class SaasSubscriptionComponent implements OnInit {
  saasSubscriptionForm: FormGroup;
  pageErrors: any = {};
  subscrptionSubTypeOptions: any = [];
  isError: boolean = false;
  isSuccess: boolean = false;
  isE2E: boolean = false;
  isCNC: boolean = false;
  errorMessage = '';
  subscriptionId: any;
  
  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private errorHandler: ErrorHandler,
    private referenceService: ReferenceService,
    private activatedroute: ActivatedRoute,
    private toastrService: ToastrService,
    private subscriptionService: SubscriptionService) {
      this.subscriptionId = this.activatedroute.snapshot.paramMap.get("subscriptionId");
  }

  ngOnInit(): void {
    this.fetchData();
    this.saasSubscriptionForm = this.formBuilder.group({
      dataValidityPeriod: ['',[Validators.required]],
      dbAction: [''],
      maxBanks: [''],
      maxBranches: [''],
      maxNumOfLoanSchemes: [''],
      pricePerMonth: ['', [Validators.required]],
      productTypeId: ['', [Validators.required]],
      renewalReminderDate: ['',[Validators.required]],
      subscriptionName: ['', [Validators.required]],
      subscriptionPeriod: ['', [Validators.required]],
      subscriptionReqType: ['', [Validators.required]],
      subscriptionSubTypeId: ['', [Validators.required]],
      subscriptionTypeId: ['', [Validators.required]]
    });
    //this.errorHandler.handleErrors(this.saasSubscriptionForm, this.pageErrors);
    this.registerValueChanges();
    if(this.subscriptionId!=null && this.subscriptionId!='' && this.subscriptionId != 'undefined' && this.subscriptionId!='null') {
       this.getSubscriptionInfo(this.subscriptionId);
    }
  }
  getSubscriptionInfo(subscriptionId) {
    this.subscriptionService.loadSubscriptionDetail(subscriptionId).subscribe((results: any) => {
        console.log("results", results.data[0]);
        if (!results.metaData.success) {
          this.isError = true;
          this.errorMessage = results.metaData.description;
        } else {
   
           if (results && results.data[0]) {
              this.saasSubscriptionForm.patchValue({
                  dataValidityPeriod: results.data[0].dataValidityPeriod,
			      maxBanks: results.data[0].maxBanks,
			      maxBranches: results.data[0].maxBranches,
			      maxNumOfLoanSchemes: results.data[0].maxNumOfLoanSchemes,
			      pricePerMonth: results.data[0].pricePerMonth,
			      productTypeId: results.data[0].productTypeId,
			      subscriptionTypeId: results.data[0].subscriptionTypeId,
			      renewalReminderDate: results.data[0].renewalReminderDate,
			      subscriptionName: results.data[0].subscriptionName,
			      subscriptionPeriod: results.data[0].subscriptionPeriod,
			      subscriptionReqType: results.data[0].subscriptionReqType,
			      subscriptionSubTypeId: results.data[0].subscriptionSubTypeId			      
              });
         }
       }
    },
	err => {
	  this.errorMessage = err.error.errorMessage;
	  this.isError = true;
	});
 }
  
  clearAllData() {
    this.saasSubscriptionForm.reset();
  }
  registerValueChanges() {
    this.saasSubscriptionForm.get('productTypeId').valueChanges.subscribe(value => {
       if(value !=null && 'undefined'!=value){
          //this.saasSubscriptionForm.get('maxBanks').reset();
          //this.saasSubscriptionForm.get('maxBranches').reset();
          //this.saasSubscriptionForm.get('maxNumOfLoanSchemes').reset();
          if(value == 1) {
          	this.isE2E = true;
          	this.isCNC = false;
          } else { 
            this.isCNC = true;
            this.isE2E = false;
          }
       } else {
          this.isE2E = false;
          this.isCNC = false;
       }
    });
    this.saasSubscriptionForm.get('subscriptionTypeId').valueChanges.subscribe(value => {
      if (value && value != undefined) {
        this.subscrptionSubTypeOptions = [];
        forkJoin([this.referenceService.getReferenceSubscriptionSubType(value)])
          .subscribe(results => {
            console.log("results", results);
            if (results) {
              if (results[0] && results[0].data) {
                this.subscrptionSubTypeOptions = results[0].data;
              }
            }
          });
      }

    });
  }

  fetchData() {

  }

  performSubmit() {
    let formData = this.saasSubscriptionForm.value;
    console.log("formData", formData);
    this.isError = false;
    this.isSuccess = false;
    //if(formData.valid) {
    this.subscriptionService.createSubscription(formData,this.subscriptionId).subscribe(result => {
      console.log("result", result);
      if (result && result.metaData) {
        // confirmationDialogData.message = result.metaData.description;
        if (!result.metaData.success) {
          this.isError = true;
          this.errorMessage = result.data.messageDescription;
        } else {
          //this.isSuccess = true;
          this.toastrService.success('Subscription is successful', 'Information', {
            timeOut: 3000,
            
          });
          this.saasSubscriptionForm.reset();
        }
      }

    },
      err => {
        this.errorMessage = err.error.errorMessage;
        this.isError = true;
      });
    //}
  }
  goBackToSearchScreen() {
    this.router.navigate(['home', { outlets: { appcontent: ['search-subscriptions'] } }]);
  }
}
