import { STEPPER_GLOBAL_OPTIONS } from '@angular/cdk/stepper';
import { Component, ErrorHandler, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-edit-client',
  templateUrl: './edit-client.component.html',
  styleUrls: ['./edit-client.component.scss'],
  providers: [{
    provide: STEPPER_GLOBAL_OPTIONS, useValue: {displayDefaultIndicatorType: false}
  }]
})
export class EditClientComponent implements OnInit {

  editClientForm: FormGroup;
  renewSubscriptionForm: FormGroup;
  switchSubscriptionForm: FormGroup;
  clientDetailsForm: FormGroup;
  viewSubscriptionForm: FormGroup;
  customizeV1Form: FormGroup;
  reviewSubscriptionForm: FormGroup;
  operationalTemplateForm: FormGroup;
  subscriptionForm: FormGroup;
  pageErrors: any = {};
  languageOptions: any = [];
  isError: boolean = false;
  isSuccess: boolean = false;
  errorMessage = '';

  clientInfoForm: FormGroup;
  bankDetailsForm: FormGroup;
  loanSchemeForm: FormGroup;
  loanVariantForm: FormGroup;
  subscriptionDetailsForm: FormGroup;
  panelOpenState = false;
  
  constructor(private formBuilder: FormBuilder, private errorHandler: ErrorHandler, private datepicker: MatDatepickerModule,
    private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.editClientForm = this.formBuilder.group({
      clientTypeId: ['', [Validators.required]],
      clientId	:[''],
      languageId	:[],
      subscriptionId:[],
      clientName: ['', [Validators.required]],
      clientPrefix	:[''],
      gstNum	:[''],
      address: [''],
      pincode: [''],
      city	: [''],
      state	: [''],
      // loanVariantDetails: this.formBuilder.array([
      //   this.getLoanSchemeData('existing')
      // ])
    });
    this.renewSubscriptionForm = this.formBuilder.group({
      formControl: ['']
    });
    this.switchSubscriptionForm = this.formBuilder.group({
      formControl: ['']
    });
    this.clientDetailsForm = this.formBuilder.group({
      formControl: ['']
    });
    this.viewSubscriptionForm = this.formBuilder.group({
    });
    this.customizeV1Form = this.formBuilder.group({
    });
    this.reviewSubscriptionForm = this.formBuilder.group({
    });
    this.operationalTemplateForm = this.formBuilder.group({
    });
    this.subscriptionForm = this.formBuilder.group({
      product: [''],
      subscription: [''],
      clientTypeId: [''],
      clientId	:[''],
      languageId	:[],
      subscriptionId:[],
      clientName: [''],
      clientPrefix	:[''],
      gst	:[''],
      city	: [''],
      state	: [''],
      price: [],
      subscriptionName: [],
      subscriptionType: [],
      subscriptionSubType1: [],
      subscriptionSubType2: [],
      subscriptionModel: [],
      tax:[],
      amount:[],
      subscriptionStartDate:[],
      subscriptionEndDate:[],
      totalAmount:[]
      // loanVariantDetails: this.formBuilder.array([
      //   this.getLoanSchemeData('existing')
      // ])
    });

    this.loanSchemeForm = this.formBuilder.group({
      formControl1: [''],
      formControl2: [''],
      formControl3: ['']
    });
    this.loanVariantForm = this.formBuilder.group({
      formControl4: [''],
      formControl5: [''],
      formControl6: [''],
      formControl7: ['']
    });
    this.subscriptionDetailsForm = this.formBuilder.group({
      subscriptionPrice: [''],
      subscriptionTax: [''],
      subscriptionGST: [''],
      subscriptionTentativeStart: [''],
      subscriptionActualStart: [''],
      subscriptionActualEnd: [''],
      subscriptionRenewal: ['']
    });
    this.bankDetailsForm = this.formBuilder.group({
      subscriptionPrice: [''],
      subscriptionTax: [''],
      subscriptionGST: [''],
      subscriptionTentativeStart: [''],
      subscriptionActualStart: [''],
      subscriptionActualEnd: [''],
      subscriptionRenewal: ['']
    });
  }

  clone() {
    this.toastr.success('The template is successfully cloned.', 'Information', {
      timeOut: 3000,
    });
  }

}
