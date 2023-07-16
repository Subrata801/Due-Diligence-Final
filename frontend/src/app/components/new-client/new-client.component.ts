import { StepperSelectionEvent } from '@angular/cdk/stepper';
import { Inject, ViewChild } from '@angular/core';
import { ErrorHandler, Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSlideToggleChange, MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatStepper } from '@angular/material/stepper';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { forkJoin, Observable } from 'rxjs';
import { distinctUntilChanged } from 'rxjs/operators';
import { ClientConfigurationService } from 'src/app/services/client-configuration/client-configuration.service';
import { CreateNewClientService } from 'src/app/services/client-new/create-new-client.service';
import { ReferenceService } from 'src/app/services/reference-service/reference.service';
import { SubscriptionService } from 'src/app/services/subscription/subscription.service';
import { LanguageTemplateService } from 'src/app/services/template/template.service';
import { createNewVersionDialogComponent } from '../create-new-version-dialog/create-new-version-dialog.component';
import * as moment from 'moment';
@Component({
  selector: 'app-new-client',
  templateUrl: './new-client.component.html',
  styleUrls: ['./new-client.component.scss']
})
export class NewClientComponent implements OnInit {
  createClientForm: FormGroup;
  newClientForm: FormGroup;
  clientSubscriptionForm: FormGroup;
  bankDetailsForm: FormGroup;
  loanSchemeForm: FormGroup;
  loanVariantForm: FormGroup;
  V1TemplatesForm: FormGroup;
  subscriptionDetailsForm: FormGroup;
  pageErrors: any = {};
  languageOptions: any = [];
  productTypeOptions: any = [];
  subscriptionTypeOptions: any = [];
  subscriptionSubTypeOptions: any = [];
  subscriptionModelOptions: any = [];
  availableLoanSchemeOptions: any = [];
  isError: boolean = false;
  isSuccess: boolean = false;
  v1TemplateCount : boolean = false;
  subscriptionHistCount : boolean = false;
  errorMessage = '';
  clientId: any;
  clientTypeId: any;
  clientName: any;
  clientTypeName: any;
  action: any;
  clientStatus: any;
  isEditMode: boolean = false;
  isClientTypeAuditFirm: boolean = false;
  minDate = new Date();
  status: boolean = false;
  statusLabel: any = "Inactive";
  isTemplatewithRisk: boolean = false;
  isTemplatewithOutRiskDisable: boolean = false;

  @ViewChild('stepper') private clientStepper: MatStepper;

  constructor(private formBuilder: FormBuilder, private errorHandler: ErrorHandler, private datepicker: MatDatepickerModule, public dialog: MatDialog,
    private toastrService: ToastrService, private activatedroute: ActivatedRoute, private createNewClientService: CreateNewClientService,
    private referenceService: ReferenceService, private router: Router, private subscriptionService: SubscriptionService,
    private languageTemplateService: LanguageTemplateService, private clientConfigurationService: ClientConfigurationService) {
    //console.log("All param map :", this.activatedroute.snapshot.paramMap);
    this.clientTypeId = this.activatedroute.snapshot.paramMap.get("clientTypeId");
    this.clientName = this.activatedroute.snapshot.paramMap.get("clientName");
    this.clientId = this.activatedroute.snapshot.paramMap.get("clientId");
    this.action = this.activatedroute.snapshot.paramMap.get("action");
    this.clientStatus = this.activatedroute.snapshot.paramMap.get("status");
    
    if(this.clientName == 'null')
       this.clientName = '';
    //console.log("this.clientId", this.clientId);
    if (this.clientId === '' || this.clientId === 'undefined') {
      this.clientId = "-1"
      this.isEditMode = false;
    } else {
      this.isEditMode = true;
    }
    if ("2" === this.clientTypeId) {
      this.isClientTypeAuditFirm = false;
      this.clientTypeName = "Client Bank";

    } else if ("3" === this.clientTypeId) {
      this.isClientTypeAuditFirm = true;
      this.clientTypeName = "Client Audit Firm";
    }

    console.log(this.clientId, "isEditMode", this.clientId, this.isEditMode);
    this.productTypeOptions = [{ productTypeId: 1, productTypename: "e 2 e Solution" },
    { productTypeId: 2, productTypename: "c n c Solution in Audit" }];
  }

  goBackToSearchScreen() {
    this.router.navigate(['home', { outlets: { appcontent: ['search-client'] } }]);
  }

  private getAddressInfoData() {
    return this.formBuilder.group({
      address: [''],
      pincode: ['', Validators.required],
      state: ['', Validators.required],
      city: ['', Validators.required]
    });
  }

  getAddressInfoControl() {
    return ((this.newClientForm.get('addressInfo') as FormArray).controls[0] as FormGroup);
  }

  
  private getContactInfoData() {
    return this.formBuilder.group({
      contactStatus: [''],
      designation: [''],
      mobileNum: [''],
      officialEmailId: [''],
      pointOfContact: [''],
    });
  }

  // add new row
  addContactInfo() {
    const control = <FormArray>this.newClientForm.controls['contactInfo'];
    control.push(this.getContactInfoData());
  }

  // remove row
  removeContactInfo(i: number) {
    const control = <FormArray>this.newClientForm.controls['contactInfo'];
    control.removeAt(i);
  }

  getContactInfoArrayControl() {
    return (this.newClientForm.get('contactInfo') as FormArray).controls;
  }

  clearAllErrors() {
    this.isError = false;
    this.errorMessage = "";
  }

  
  getLoanSchemeVariant() {
    let loanSchemeVariant: FormGroup = this.formBuilder.group({
      action: [''],
      loanSchemeName: [''],
      loanSchemeId: [''],
      loanVariantId: ['', Validators.required],
      loanVariantKeyword: ['', Validators.required],
      preferredLoanVariantName: [''],
      availableLoanSchemeVariantOptions: [],
      clientGroupId:['']
    });
    loanSchemeVariant.get('loanSchemeId').valueChanges.pipe(
      distinctUntilChanged()
    ).subscribe(loanSchemeIdValue => {
      //console.log("loanSchemeIdValue", loanSchemeIdValue);
      forkJoin([this.languageTemplateService.getAvailableLoanVariants(loanSchemeIdValue)]).subscribe(results => {
        //console.log("loan variant results", results);
        if (results[0] && results[0].data) {
          loanSchemeVariant.patchValue({
            availableLoanSchemeVariantOptions: results[0].data
          });
          loanSchemeVariant.updateValueAndValidity();
        }
      });
    });
    return loanSchemeVariant;
  }
  // add new row
  addLoanSchemeVariantDetails() {
    const control = <FormArray>this.loanVariantForm.controls['loanSchemeVariantDetails'];
    control.push(this.getLoanSchemeVariant());
  }

  addThisLoanSchemeVariantDetails(formGroup: FormGroup) {
    const control = <FormArray>this.loanVariantForm.controls['loanSchemeVariantDetails'];
    control.push(formGroup);
  }


  // remove row
  removeLoanSchemeVariant(i: number) {
    const control = <FormArray>this.loanVariantForm.controls['loanSchemeVariantDetails'];
    let loanSchemeVariantDetailsFromUI = this.getLoanSchemeVariantArrayControl()[i].value;
    var clentGroupId = -1;
    if(this.clientTypeId==3){
      clentGroupId = loanSchemeVariantDetailsFromUI.clientGroupId;
    }
    //alert(loanSchemeVariantDetailsFromUI.action);
    //if(loanSchemeVariantDetailsFromUI.action != 'add'){
      let reqData: any;
      reqData = {
        clientId: this.clientId,
        clientTypeId: this.clientTypeId, 
        clientGroupId: clentGroupId
      }

      let loanSchemeVariantDetails = this.getLoanSchemeVariantArrayControl()[i].value;
      delete loanSchemeVariantDetails.availableLoanSchemeVariantOptions;
      
      let loanSchemeVariantDetailsArr = [];
      loanSchemeVariantDetailsArr.push(loanSchemeVariantDetails);
      reqData.loanSchemeVariantDetails = loanSchemeVariantDetailsArr;

      this.clientConfigurationService.deleteLoanSchemeVariantInfo(reqData).subscribe(result=>{
        this.toastrService.success('Loan Variant deleted successfully', 'Information', {
          timeOut: 3000,
        });
      },
      err => {
        console.log("err",err);  
        this.toastrService.error('Unable to delete loan variant', 'Information', {
          timeOut: 3000,
        });      
      });
    //}
    control.removeAt(i);
  }

  getLoanSchemeVariantArrayControl() {
    return (this.loanVariantForm.get('loanSchemeVariantDetails') as FormArray).controls;
  }

  getLoanScheme() {
    return this.formBuilder.group({
      action: 'add',
      clientGroupId: [''],
      clientId: this.clientId,
      loanSchemeId: ['', Validators.required],
      loanSchemeNameKeyword: ['', Validators.required],
      loanSchemeName: [''],
      clientLoanSchemeName:['']
    });
  }
  // add new row
  addLoanSchemeDetails() {
    const control = <FormArray>this.loanSchemeForm.controls['loanSchemeDetails'];
    control.push(this.getLoanScheme());
  }

  // remove row
  removeLoanScheme(i: number) {
    const control = <FormArray>this.loanSchemeForm.controls['loanSchemeDetails'];
    
    let loanSchemeDetailsFromUI = this.getLoanSchemeArrayControl()[i].value;
    var clntGroupId = -1;
    if(this.clientTypeId==3){
       clntGroupId = loanSchemeDetailsFromUI.clientGroupId;
    }
    if(loanSchemeDetailsFromUI.action != 'add'){
      //console.log("control",this.getLoanSchemeArrayControl()[i].value);
      let reqData: any;
      reqData = {
        clientId: this.clientId,
        clientTypeId: this.clientTypeId, 
        clientGroupId: clntGroupId
      }

      let loanSchemeDetails = this.getLoanSchemeArrayControl()[i].value;
      //alert('Going to delete loan Scheme');
      let loanSchemeDetailsArr = [];
      loanSchemeDetailsArr.push(loanSchemeDetails);
      reqData.loanSchemeDetails = loanSchemeDetailsArr;
      
      
      this.clientConfigurationService.deleteLoanSchemeInfo(reqData).subscribe(result=>{
        console.log("result",result);
        this.toastrService.success('Loan scheme deleted successfully', 'Information', {
          timeOut: 3000,
        });
      },
      err => {
        console.log("err",err);
        this.toastrService.error('Unable to delete loan scheme', 'Information', {
          timeOut: 3000,
        });       
      });
    }
    control.removeAt(i);
  }

  getLoanSchemeArrayControl() {
    return (this.loanSchemeForm.get('loanSchemeDetails') as FormArray).controls;
  }
  getAvailableV1TemplateControl() {
    return (this.V1TemplatesForm.get('V1TemplatesFormDetails') as FormArray).controls;
  }
  
  getV1TemplateData() {
    return this.formBuilder.group({
      ddId :[''],
      clientLoanSchemeName : [''],
      templateStatus: [''],
      startDate: [''],
      endDate: ['']
    });
  }
  
  getSubscriptionHistData() {
    return this.formBuilder.group({
      subscriptionName : [''],
      price: [''],
      gst: [''],
      tax: [''],
      totalAmount: [''],
      startDate: [''],
      endDate: ['']
    });
  }
  getBankDetails() {
    return this.formBuilder.group({
      address: [''],
      bankName: ['', Validators.required],
      city: [''],
      pincode: [''],
      state: [''],
      status: [''],
      clientGroupId :['']
    });
  }
  // add new row
  addBankDetails() {
    const control = <FormArray>this.bankDetailsForm.controls['bankInfo'];
    control.push(this.getBankDetails());
  }

  addThisBankDetails(formGroup: FormGroup) {
    const control = <FormArray>this.bankDetailsForm.controls['bankInfo'];
    control.push(formGroup);
  }

  addSubscriptionHistory(formGroup :FormGroup) {
  	const control = <FormArray>this.clientSubscriptionForm.controls['subscriptionHistData'];
    control.push(formGroup);
  }
  
  addV1Template(formGroup :FormGroup) {
  	const control = <FormArray>this.V1TemplatesForm.controls['V1TemplatesFormDetails'];
    control.push(formGroup);
  }
  
  // remove row
  removeBankDetails(i: number) {
    const control = <FormArray>this.bankDetailsForm.controls['bankInfo'];
      let reqData: any;
	  reqData = {
	    clientId: this.clientId,
	    clientTypeId: this.clientTypeId
	  }
	
	  let bankDetails = this.getBankDetailsArrayControl()[i].value;
	  //delete bankDetails.availableLoanSchemeVariantOptions;
	  console.log("bankDetails :: "+bankDetails);
	  let bankDetailsArr = [];
	  bankDetailsArr.push(bankDetails);
	  reqData.bankDetails = bankDetailsArr;
	
	  this.clientConfigurationService.deleteBankInfo(reqData).subscribe(result=>{
	    this.toastrService.success('Bank details deleted successfully', 'Information', {
	      timeOut: 3000,
	    });
	  },
	  err => {
	    console.log("err",err);  
	    this.toastrService.error('Unable to delete bank details', 'Information', {
	      timeOut: 3000,
	    });      
	  });
    control.removeAt(i);
  }

  getBankDetailsArrayControl() {
    return (this.bankDetailsForm.get('bankInfo') as FormArray).controls;
  }

  getSubscriptionHistArrayControl() {
    if(this.subscriptionHistCount)
    	return (this.clientSubscriptionForm.get('subscriptionHistData') as FormArray).controls;
  }
  
  registerValueChanges() {
    this.createClientForm.get('clientId').valueChanges.subscribe(clientIdValue => {
      console.log("clientIdValue", clientIdValue);

    });
    this.createClientForm.get('subscriptionId').valueChanges.subscribe(subscriptionIdValue => {
      console.log("subscriptionIdValue", subscriptionIdValue);

    });
    this.createClientForm.get('loanSchemeId').valueChanges.subscribe(loanSchemeIdValue => {
      console.log("loanSchemeIdValue", loanSchemeIdValue);

    });
    this.createClientForm.get('loanVariantId').valueChanges.subscribe(loanVariantIdValue => {
      console.log("loanVariantIdValue", loanVariantIdValue);

    });
    this.clientSubscriptionForm.get('subscriptionTypeId').valueChanges.subscribe(value => {
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

  ngOnInit(): void {
    if(this.clientStatus == 'Completed') {
    	this.action = false;
    } else {
        this.action = true;
    }
    
    this.createClientForm = this.formBuilder.group({
      clientId: [this.clientId],
      subscriptionId: [''],
      loanSchemeId: [''],
      loanVariantId: [''],
    })
    this.newClientForm = this.formBuilder.group({
      clientId: this.clientId,
      clientLogoPath: [''],
      clientName: [this.clientName],
      clientPrefix: [''],
      riskTypeId : [''],
      clientTypeId: [this.clientTypeId],
      gstNum: [''],
      languageId: [''],
      subscriptionId: [''],
      addressInfo: this.formBuilder.array([
        this.getAddressInfoData()
      ]),
      contactInfo: this.formBuilder.array([
        this.getContactInfoData()
      ])
    });

    this.clientSubscriptionForm = this.formBuilder.group({
      clientId: this.clientId,
      clientName: [this.clientName, Validators.required],
      clientTypeId: [this.clientTypeId, Validators.required],
      productTypeId: [''],
      subscriptionTypeId: [''],
      subscriptionSubTypeId: [],
      subscriptionModelId: ['', Validators.required],
      newSubscriptionIndicator: 1,
      subscriptionId: 1,
      subscriptionStartDate : [''],
      subscriptionEndDate : [''],
      subscriptionHistData: this.formBuilder.array([
        this.getSubscriptionHistData()
      ])
    });
    
    this.loanSchemeForm = this.formBuilder.group({
      clientId: this.clientId,
      clientName: [this.clientName, Validators.required],
      clientTypeId: [this.clientTypeId, Validators.required],
      loanSchemeDetails: this.formBuilder.array([
        this.getLoanScheme()
      ])
    });

    this.loanVariantForm = this.formBuilder.group({
      clientId: this.clientId,
      clientName: [this.clientName, Validators.required],
      clientTypeId: [this.clientTypeId, Validators.required],
      loanSchemeVariantDetails: this.formBuilder.array([
        this.getLoanSchemeVariant()
      ])
    });

    this.V1TemplatesForm = this.formBuilder.group({
      V1TemplatesFormDetails: this.formBuilder.array([
        this.getV1TemplateData()
      ])
    });

    this.subscriptionDetailsForm = this.formBuilder.group({
      clientId: this.clientId,
      subscriptionId: [0],
      subscriptionName: [''],
      subscriptionPeriod: [''],
      maxNumberOfBranches: [''],
      maxLoanSchemeAllowed: [''],
      renewalReminderActivation: [''],
      pricePerMonth: [],
      dataValidityPeriod: [],
      subscriptionPrice: [],
      price: [],
      tax: [],
      gst: [],
      subscriptionStartDate: [''],
      subscriptionEndDate: [''],
      renewalReminderDate: [''],
      totalAmount: [],
      newSubscriptionIndicator: 0
    });

    this.bankDetailsForm = this.formBuilder.group({
      clientId: this.clientId,
      clientName: [this.clientName, Validators.required],
      clientTypeId: [this.clientTypeId, Validators.required],
      bankInfo: this.formBuilder.array([
        this.getBankDetails()
      ])
    });
    if(this.clientTypeId ==3) {
       this.isTemplatewithRisk = true;
       this.isTemplatewithOutRiskDisable = true ;
    } else {
        this.isTemplatewithRisk = false;
       this.isTemplatewithOutRiskDisable = false;
    }
    forkJoin([this.languageTemplateService.getAvailableAllLoanSchemes(),
    this.referenceService.getReferenceLanguages()
    ]).subscribe(results => {

      console.log("  results", results);
      var languageDropDown: any = []; 
      if (results[0] && results[0].data) {
        this.availableLoanSchemeOptions = results[0].data;
      }
      if (results[1] && results[1].data) {
        if(this.clientTypeId ==3) {
            
            for(var i = 0; i < results[1].data.length; i++) {
              if(results[1].data[i].languageId == 1) {
                languageDropDown.push(results[1].data[i]);
        	  }
        	}
        	this.languageOptions = languageDropDown;
        } else 
        	this.languageOptions = results[1].data;
      }
     
      
    });
    
    if (this.isEditMode) {
      let editScreenServiceCalls: Observable<any>[] = [];
      editScreenServiceCalls.push(this.clientConfigurationService.getClientInfo(this.createClientForm.get('clientId').value));
      editScreenServiceCalls.push(this.clientConfigurationService.loadClientSubscriptionDetails(this.createClientForm.get('clientId').value));
      editScreenServiceCalls.push(this.clientConfigurationService.getLoanSchemeInfo(this.createClientForm.get('clientId').value,this.clientTypeId));
      editScreenServiceCalls.push(this.clientConfigurationService.getLoanSchemeVariantInfo(this.createClientForm.get('clientId').value,this.clientTypeId));
      editScreenServiceCalls.push(this.clientConfigurationService.getBankInfo(this.createClientForm.get('clientId').value));
      if(!this.action) {
      	editScreenServiceCalls.push(this.clientConfigurationService.loadClientSubscriptionHistoryDetails(this.createClientForm.get('clientId').value));
      	editScreenServiceCalls.push(this.clientConfigurationService.loadV1TemplateDetails(this.createClientForm.get('clientId').value,this.clientTypeId));
      }
      forkJoin(editScreenServiceCalls).subscribe(editResults => {
        if (editResults[2] && editResults[2].data && editResults[2].data.length > 0) {
          let loanScheme: [] = editResults[2].data;
          //console.log("loanSchemeForm schem", loanScheme);
          (this.loanSchemeForm.get('loanSchemeDetails') as FormArray).clear();
          const loanSchemeDetailsControl = <FormArray>this.loanSchemeForm.controls['loanSchemeDetails'];
          if (loanScheme.length > 0) {
            loanScheme.forEach((eachLoanScheme: any) => {
              loanSchemeDetailsControl.push(this.formBuilder.group({
                clientGroupId: eachLoanScheme.clientGroupId,
                loanSchemeId: eachLoanScheme.loanSchemeId,
                loanSchemeNameKeyword: eachLoanScheme.loanSchemeNameKeyword,
                clientLoanSchemeName: eachLoanScheme.clientLoanSchemeName,
                loanSchemeName: eachLoanScheme.loanSchemeName
              }));
            });
            this.loanSchemeForm.patchValue({
              clientId: this.clientId,
              clientName: this.newClientForm.get('clientName').value,
              clientTypeId: this.clientTypeId,
              //loanSchemeDetails: loanSchemeDetailsControl
            });
            this.loanSchemeForm.setControl('loanSchemeDetails', loanSchemeDetailsControl);
          }
        }

        if (editResults[3] && editResults[3].data && editResults[3].data.length > 0) {
          let loanSchemeVariant: [] = editResults[3].data;
          //console.log("loanSchemeVariant schem", loanSchemeVariant);
          (this.loanVariantForm.get('loanSchemeVariantDetails') as FormArray).clear();
          if (loanSchemeVariant.length > 0) {
            this.loanVariantForm.patchValue({
              clientId: this.clientId,
              clientName: this.newClientForm.get('clientName').value,
              clientTypeId: this.clientTypeId,
              // loanSchemeVariantDetails: loanSchemeVariantDetailsControl
            });
            loanSchemeVariant.forEach((eachLoanSchemeVariant: any) => {
              const loanSchemeVariantDetailsControl = this.getLoanSchemeVariant();
              loanSchemeVariantDetailsControl.patchValue({
                loanSchemeId: eachLoanSchemeVariant.loanSchemeId,
                loanVariantId: eachLoanSchemeVariant.loanVariantId,
                loanVariantKeyword: eachLoanSchemeVariant.loanVariantKeyword,
                preferredLoanVariantName : eachLoanSchemeVariant.preferredLoanVariantName,
                loanSchemeName: eachLoanSchemeVariant.loanSchemeName
              })
              this.addThisLoanSchemeVariantDetails(loanSchemeVariantDetailsControl);
            });

            //this.loanVariantForm.setControl('loanSchemeVariantDetails', loanSchemeVariantDetailsControl);
          }
        }

        if (editResults[1] && editResults[1].data) {
          let clientSubscription = editResults[1].data;
          //console.log("clientSubscription", clientSubscription);
          this.clientSubscriptionForm.patchValue({
            clientId: this.clientId,
            clientName: this.newClientForm.get('clientName').value,
            clientTypeId: this.clientTypeId,
            productTypeId: clientSubscription.productId,
            subscriptionTypeId: clientSubscription.subscriptionTypeId,
            subscriptionSubTypeId: clientSubscription.subscriptionSubTypeId,
            subscriptionModelId: clientSubscription.subscriptionId,
            subscriptionName: clientSubscription.subscriptionName,
            newSubscriptionIndicator: 0,
            subscriptionId: clientSubscription.subscriptionId,
            subscriptionStartDate: clientSubscription.startDate,
            subscriptionEndDate: clientSubscription.endDate,
          });
          
          this.subscriptionDetailsForm.patchValue({
            clientId: this.clientId,
            subscriptionId: clientSubscription.subscriptionId,
            subscriptionName: clientSubscription.subscriptionName,
            subscriptionPeriod: clientSubscription.subscriptionPeriod,
            maxNumberOfBranches: clientSubscription.maxNumberOfBranches,
            maxLoanSchemeAllowed: clientSubscription.maxLoanSchemeAllowed,
            renewalReminderActivation: clientSubscription.renewalReminderActivation,
            pricePerMonth: clientSubscription.pricePerMonth,
            dataValidityPeriod: clientSubscription.dataValidityPeriod,
            subscriptionPrice: clientSubscription.subscriptionId,
            price: clientSubscription.pricePackage,
            tax: clientSubscription.tax,
            gst: clientSubscription.gst,
            subscriptionStartDate: clientSubscription.startDate,
            subscriptionEndDate: clientSubscription.endDate,
            renewalReminderDate : clientSubscription.renewalReminderDate,
            totalAmount: clientSubscription.totalAmount
          })
        }

        if (editResults[0] && editResults[0].data) {
          //console.log("editResults[0]", editResults[0]);
          //console.log("this.newClientForm", this.newClientForm);
          let clientInfoData = editResults[0].data;
          (this.newClientForm.get('contactInfo') as FormArray).clear();
          (this.newClientForm.get('addressInfo') as FormArray).clear();
          const addressInfoControl = <FormArray>this.newClientForm.controls['addressInfo'];
          addressInfoControl.push(this.formBuilder.group({
            address: clientInfoData.address,
            pincode: clientInfoData.pincode,
            state: clientInfoData.state,
            city: clientInfoData.city
          }));
          const contactDetailsControl = <FormArray>this.newClientForm.controls['contactInfo'];
          contactDetailsControl.push(this.formBuilder.group({
            designation: clientInfoData.primaryPocDesignation,
            mobileNum: clientInfoData.primaryPocNum,
            officialEmailId: clientInfoData.primaryPocEmail,
            pointOfContact: clientInfoData.primaryPoc
          }));
          if (clientInfoData.secondaryPoc || clientInfoData.secondaryPocNum ||
            clientInfoData.secondaryPocDesignation || clientInfoData.secondaryPocEmail) {
            contactDetailsControl.push(this.formBuilder.group({
              designation: clientInfoData.secondaryPocDesignation,
              mobileNum: clientInfoData.secondaryPocNum,
              officialEmailId: clientInfoData.secondaryPocEmail,
              pointOfContact: clientInfoData.secondaryPoc
            }));
          }
          this.newClientForm.patchValue({
            clientId: this.clientId,
            clientName: clientInfoData.clientName,
            clientPrefix: clientInfoData.clientPrefix,
            gstNum: clientInfoData.gstNum,
            languageId: clientInfoData.languageId,
            riskTypeId:clientInfoData.riskTypeId
            //addressInfo: addressInfoControl,
            //contactInfo: contactDetailsControl
          });
          this.newClientForm.setControl('addressInfo', addressInfoControl);
          this.newClientForm.setControl('contactInfo', contactDetailsControl);
        }

        if (editResults[4] && editResults[4].data && editResults[4].data.length > 0) {
          let bankData = editResults[4].data;
          //console.log("bankData", bankData);
          (this.bankDetailsForm.get('bankInfo') as FormArray).clear();
          this.bankDetailsForm.patchValue({
            clientId: this.clientId,
            clientName: this.newClientForm.get('clientName').value,
            clientTypeId: this.clientTypeId,
            //bankInfo: bankInfoControl,
          });
          bankData.forEach((eachBankData: any) => {
            const bankDetailsControl = this.getBankDetails();
            bankDetailsControl.patchValue({
              address: eachBankData.address,
              bankName: eachBankData.bankName,
              city: eachBankData.city,
              pincode: eachBankData.pincode,
              state: eachBankData.state,
              status: eachBankData.status,
              clientGroupId:eachBankData.clientGroupId
            })
            this.addThisBankDetails(bankDetailsControl);
          });
        }
        
         if (!this.action && editResults[5] && editResults[5].data && editResults[5].data.length > 0) {
           this.subscriptionHistCount = true;
           let subscriptionHistArrData = editResults[5].data;
           (this.clientSubscriptionForm.get('subscriptionHistData') as FormArray).clear();
           subscriptionHistArrData.forEach((eachData: any) => {
            const subHistControl = this.getSubscriptionHistData();
            subHistControl.patchValue({
              subscriptionName : eachData.subscriptionName,
	          price: eachData.price,
	          gst: eachData.gst,
	          tax: eachData.tax,
	          totalAmount: eachData.totalAmount,
	          startDate: eachData.startDate,
	          endDate :eachData.endDate
            })
            this.addSubscriptionHistory(subHistControl);
          });
        }
        
        if (!this.action && editResults[6] && editResults[6].data && editResults[6].data.length > 0) {
           this.v1TemplateCount = true;
           let v1TemplateArrData = editResults[6].data;
           (this.V1TemplatesForm.get('V1TemplatesFormDetails') as FormArray).clear();
           v1TemplateArrData.forEach((eachData: any) => {
            const v1TemplateControl = this.getV1TemplateData();
            v1TemplateControl.patchValue({
              ddId : eachData.ddId,
              clientLoanSchemeName : eachData.clientLoanSchemeName,
	          templateStatus: eachData.templateStatus,
	          startDate: eachData.startDate,
	          endDate: eachData.endDate
            })
            this.addV1Template(v1TemplateControl);
          });
        }
      });
    }
    this.registerValues();
    this.registerValueChanges();
  }

  selectionChange(event: StepperSelectionEvent) {
    //console.log("event.selectedStep Prev ::: ", event.previouslySelectedIndex);
    //console.log("event.selectedStep.label ::: ", event.selectedStep.label);
    //alert("event.selectedStep.label ::: "+ event.selectedStep.label);
    let prevStepLabel = event.previouslySelectedStep.label;
    let currentStepLabel = event.selectedStep.label;
    if (currentStepLabel == "Client Information") {
      //this.performNewClientDataSubmit();
    }
    if (currentStepLabel == "Subscriptions") {
      this.loadSubscriptionHistory();
    }
    if (currentStepLabel == "Bank Details") {
      //alert("prevStepLabel " + prevStepLabel);
      //this.performBankDetailsSubmit();
    }
    if (currentStepLabel == "Loan Schemes") {
      //alert("prevStepLabel " + prevStepLabel);
      this.loadLoanSchemeDetail();
    }
    if (currentStepLabel == "Loan Variants") {
      //alert("prevStepLabel " + prevStepLabel);
      this.loadLoanSchemeVariantDetail();
    }
    if (currentStepLabel == "Subscription Details") {
      this.loadSubscriptionDetails();
    }
    if (currentStepLabel == "V1 Templates") {
      this.loadV1TemplateDetails();
    }
  }
  

  performNewClientDataSubmit() {
    this.clearAllErrors();
    //console.log("form", this.newClientForm);
    let requestData = this.newClientForm.value;
    console.log('requestData ===='+requestData);
    //console.log("requestData.contactInfo", requestData.contactInfo);
    let primaryContactInfo: any = [];
    let secondaryContactInfo: any = [];
    //alert(requestData.contactInfo.length);
    //alert(alert(requestData.contactInfo[0]));
    if (requestData.contactInfo && requestData.contactInfo.length > 1) {
      secondaryContactInfo.push(requestData.contactInfo[1]);
      primaryContactInfo.push(requestData.contactInfo[0]);
    } else if (requestData.contactInfo && requestData.contactInfo.length == 1) {
      primaryContactInfo.push(requestData.contactInfo[0]);
    }
    requestData.secondaryContactInfo = secondaryContactInfo;
    requestData.primaryContactInfo = primaryContactInfo;
    delete requestData.contactInfo;
    let riskTypeId = this.newClientForm.get('riskTypeId').value;
    if(this.clientTypeId == 3) {
      requestData.riskTypeId = "2";
    }
    
    this.createNewClientService.createClient(requestData).subscribe((results: any) => {
      //console.log("results", results);
      this.clientName = requestData.clientName;
      if (!results.metaData.success || !results.data || !results.data.clientId) {
        this.isError = true;
        this.errorMessage = results.metaData.description;
      } else {
          this.createClientForm.patchValue({ clientName: this.clientName });
	      this.clientSubscriptionForm.patchValue({ clientName: this.clientName });
	      this.bankDetailsForm.patchValue({ clientName: this.clientName });
	      this.loanSchemeForm.patchValue({ clientName: this.clientName });
	      this.loanVariantForm.patchValue({ clientName: this.clientName });
	      this.subscriptionDetailsForm.patchValue({ clientName: this.clientName });
        if (!this.isEditMode) {
          this.action = true;
          this.clientId = results.data.clientId;
          this.createClientForm.patchValue({ clientId: results.data.clientId });
          this.clientSubscriptionForm.patchValue({ clientId: results.data.clientId });
          this.bankDetailsForm.patchValue({ clientId: results.data.clientId });
          this.loanSchemeForm.patchValue({ clientId: results.data.clientId });
          this.loanVariantForm.patchValue({ clientId: results.data.clientId });
          this.subscriptionDetailsForm.patchValue({ clientId: results.data.clientId });
        }
         
        //console.log("clientId createClientForm", this.createClientForm.get('clientId').value);
        //console.log("clientId", this.clientSubscriptionForm.get('clientId').value);
        this.toastrService.success('Client Information, saved successfully', 'Information', {
          timeOut: 3000,
        });
        //this.loadSubscriptionHistory();
        this.clientStepper.next();
      }
    },
      err => {
        this.errorMessage = err.error.errorMessage;
        this.isError = true;
      }
    );
  }
  loadSubscriptionHistory() {
      this.clientConfigurationService.loadClientSubscriptionHistoryDetails(this.createClientForm.get('clientId').value).subscribe((historyResults: any) => {
         if ( historyResults && historyResults.data && historyResults.data.length > 0) {
           this.subscriptionHistCount = true;
           let subscriptionHistArrData = historyResults.data;
           (this.clientSubscriptionForm.get('subscriptionHistData') as FormArray).clear();
           subscriptionHistArrData.forEach((eachData: any) => {
            const subHistControl = this.getSubscriptionHistData();
            subHistControl.patchValue({
              subscriptionName : eachData.subscriptionName,
	          price: eachData.price,
	          gst: eachData.gst,
	          tax: eachData.tax,
	          totalAmount: eachData.totalAmount,
	          startDate: eachData.startDate,
	          endDate :eachData.endDate
            })
            this.addSubscriptionHistory(subHistControl);
          });
        }
      });
  }
  
  performClientSubcriptionSubmit() {
    this.clearAllErrors();
    //console.log("form", this.clientSubscriptionForm);
    let requestData = this.clientSubscriptionForm.value;
    console.log("requestData performClientSubcriptionSubmit :", requestData);
    if(requestData.subscriptionStartDate!=null && requestData.subscriptionStartDate!='undefined' && requestData.subscriptionStartDate !='') {
	    let dateFormat = 'yyyy-MM-DD';
	    let asOfDate = moment(requestData.subscriptionStartDate).format(dateFormat);
	    
	    requestData.subscriptionStartDate = asOfDate;
	    console.log("requestData performClientSubcriptionSubmit after date updation:", requestData);
    }
    if(this.action == false) {
      this.clientConfigurationService.updateRenewSwitchSubscriptionDetails(requestData).subscribe((results: any) => {
        //console.log("results", results);
        if (!results.metaData.success) {
          this.isError = true;
          this.errorMessage = results.metaData.description;
        } else {
          this.toastrService.success('Client Subscription Information, saved successfully', 'Information', {
            timeOut: 3000,
          });
          this.clientStepper.next();
        }
      },
        err => {
          this.errorMessage = err.error.errorMessage;
          this.isError = true;
        });
    } else if (this.isEditMode) {
      this.clientConfigurationService.updateBasicSubscriptionDetails(requestData).subscribe((results: any) => {
        //console.log("results", results);
        if (!results.metaData.success) {
          this.isError = true;
          this.errorMessage = results.metaData.description;
        } else {
          this.toastrService.success('Client Subscription Information, saved successfully', 'Information', {
            timeOut: 3000,
          });
          this.clientStepper.next();
        }
      },
        err => {
          this.errorMessage = err.error.errorMessage;
          this.isError = true;
        });
    } else {
      this.clientConfigurationService.createClientSubscription(requestData).subscribe((results: any) => {
        //console.log("results", results);
        if (!results.metaData.success) {
          this.isError = true;
          this.errorMessage = results.metaData.description;
        } else {
          this.clientConfigurationService.loadClientSubscriptionDetails(this.createClientForm.get('clientId').value).subscribe(results => {
            //console.log("results", results);
            if (results && results.data) {
              this.subscriptionDetailsForm.patchValue({
                subscriptionName: results.data.subscriptionName,
                subscriptionPeriod: results.data.subscriptionPeriod,
                maxNumberOfBranches: results.data.maxNumberOfBranches,
                maxLoanSchemeAllowed: results.data.maxLoanSchemeAllowed,
                //renewalReminderDate: results.data.renewalReminderActivation,
                price: results.data.pricePerMonth,
                //dataValidityPeriod: results.data.dataValidityPeriod,
                tax: results.data.tax,
                gst: results.data.gst,
                subscriptionStartDate: results.data.startDate,
                subscriptionEndDate: results.data.endDate,
                renewalReminderDate : results.data.renewalReminderDate,
                totalAmount: results.data.totalAmount
              });
            }
          });
        }
        this.toastrService.success('Client Subscription Information, saved successfully', 'Information', {
          timeOut: 3000,
        });
        this.clientStepper.next();

      },
        err => {
          this.errorMessage = err.error.errorMessage;
          this.isError = true;
        }
      );
    }
  }

  performBankDetailsSubmit() {
    this.clearAllErrors();
    //console.log("form", this.bankDetailsForm);
    let requestData = this.bankDetailsForm.value;
    //console.log("requestData", requestData);
    this.createNewClientService.createBankDetails(requestData,this.clientTypeId).subscribe((results: any) => {
      //console.log("results", results);
      if (!results.metaData.success) {
        this.isError = true;
        this.errorMessage = results.metaData.description;
      } else {
        this.toastrService.success('Bank Details Information, saved successfully', 'Information', {
          timeOut: 3000,
        });
        this.clientStepper.next();
      }
    },
      err => {
        console.log("err", err);
        this.errorMessage = err.error.errorMessage;
        this.isError = true;
      }
    );
  }

  performLoanSchemeSubmit() {
    this.clearAllErrors();
    //console.log("form", this.loanSchemeForm);
    let requestData = this.loanSchemeForm.value;
    let loanSchemeDetailsArr = [];
    //console.log("requestData b4", requestData);
    //loanSchemeDetailsArr = requestData.loanSchemeDetails;
    if (requestData.loanSchemeDetails && requestData.loanSchemeDetails.length > 0) {
      requestData.loanSchemeDetails.forEach(eachLoanScheme => {
        eachLoanScheme.clientId = this.clientId;
      });
    }
    loanSchemeDetailsArr = requestData.loanSchemeDetails;
    //console.log("requestData of loan variant", requestData);
    this.createNewClientService.createLoanScheme(loanSchemeDetailsArr).subscribe((results: any) => {
      //console.log("results", results);
      if (!results.metaData.success) {
        this.isError = true;
        this.errorMessage = results.metaData.description;
      } else {
        this.toastrService.success('Loan Scheme Information, saved successfully', 'Information', {
          timeOut: 3000,
        });
        //Calling loan variant api to load fresh data
        this.loadLoanSchemeVariantDetail();
        this.clientStepper.next();
      }
    },
      err => {
        this.errorMessage = err.error.errorMessage;
        this.isError = true;
      }
    );
  }

  loadLoanSchemeDetail() {
    this.clientConfigurationService.getLoanSchemeInfo(this.createClientForm.get('clientId').value,this.clientTypeId).subscribe((results: any) => {
       if (results && results.data && results.data.length > 0) {
          let loanScheme: [] = results.data;
          //console.log("loanSchemeForm schem", loanScheme);
          (this.loanSchemeForm.get('loanSchemeDetails') as FormArray).clear();
          const loanSchemeDetailsControl = <FormArray>this.loanSchemeForm.controls['loanSchemeDetails'];
          if (loanScheme.length > 0) {
            loanScheme.forEach((eachLoanScheme: any) => {
              loanSchemeDetailsControl.push(this.formBuilder.group({
                clientGroupId: eachLoanScheme.clientGroupId,
                loanSchemeId: eachLoanScheme.loanSchemeId,
                loanSchemeNameKeyword: eachLoanScheme.loanSchemeNameKeyword,
                clientLoanSchemeName: eachLoanScheme.clientLoanSchemeName,
                loanSchemeName: eachLoanScheme.loanSchemeName
              }));
            });
            this.loanSchemeForm.patchValue({
              clientId: this.clientId,
              clientName: this.newClientForm.get('clientName').value,
              clientTypeId: this.clientTypeId,
              //loanSchemeDetails: loanSchemeDetailsControl
            });
            this.loanSchemeForm.setControl('loanSchemeDetails', loanSchemeDetailsControl);
          }
        }
     });
  
  }
  loadLoanSchemeVariantDetail() {
    this.clientConfigurationService.getLoanSchemeVariantInfo(this.createClientForm.get('clientId').value,this.clientTypeId).subscribe((results: any) => {
	        if (results && results.data && results.data.length > 0) {
	          let loanSchemeVariant: [] = results.data;
	          console.log("RefreshloanSchemeVariant schem", loanSchemeVariant);
	          (this.loanVariantForm.get('loanSchemeVariantDetails') as FormArray).clear();
	          if (loanSchemeVariant.length > 0) {
	            this.loanVariantForm.patchValue({
	              clientId: this.clientId,
	              clientName: this.newClientForm.get('clientName').value,
	              clientTypeId: this.clientTypeId,
	            });
	            loanSchemeVariant.forEach((eachLoanSchemeVariant: any) => {
	              const loanSchemeVariantDetailsControl = this.getLoanSchemeVariant();
	              loanSchemeVariantDetailsControl.patchValue({
	                clientGroupId: eachLoanSchemeVariant.clientGroupId,
	                loanSchemeName: eachLoanSchemeVariant.loanSchemeName,
	                loanSchemeId: eachLoanSchemeVariant.loanSchemeId,
	                loanVariantId: eachLoanSchemeVariant.loanVariantId,
	                loanVariantKeyword: eachLoanSchemeVariant.loanVariantKeyword,
	                preferredLoanVariantName: eachLoanSchemeVariant.preferredLoanVariantName,
	              })
	              this.addThisLoanSchemeVariantDetails(loanSchemeVariantDetailsControl);
	            });
	
	          }
	        }
	           
        });
  
  }
  performLoanVariantSubmit() {
    this.clearAllErrors();
    //console.log("form", this.loanVariantForm);
    let requestData = this.loanVariantForm.value;
    let loanSchemeVariantDetailsArr = [];
    loanSchemeVariantDetailsArr = requestData.loanSchemeVariantDetails;
    
    if (loanSchemeVariantDetailsArr && loanSchemeVariantDetailsArr.length > 0) {
      loanSchemeVariantDetailsArr.forEach(eachLoanSchemeVariantDetails => {
        eachLoanSchemeVariantDetails.loanVariantKeyword = eachLoanSchemeVariantDetails.loanVariantKeyword;
        delete eachLoanSchemeVariantDetails.availableLoanSchemeVariantOptions;
      });
    }
    //console.log("requestData", requestData);
    this.createNewClientService.createLoanVariant(requestData).subscribe((results: any) => {
      //console.log("results", results);
      if (!results.metaData.success) {
        this.isError = true;
        this.errorMessage = results.metaData.description;
      } else {
        this.toastrService.success('Loan Scheme Variant Information, saved successfully', 'Information', {
          timeOut: 3000,
        });
        //this.loadSubscriptionDetails();
        this.clientStepper.next();
      }
    },
      err => {
        this.errorMessage = err.error.errorMessage;
        this.isError = true;
      }
    );
  }
  loadSubscriptionDetails() {
     this.clientConfigurationService.loadClientSubscriptionDetails(this.createClientForm.get('clientId').value).subscribe(results => {
            //console.log("results", results);
            if (results && results.data) {
              this.subscriptionDetailsForm.patchValue({
                subscriptionId: results.data.subscriptionId,
	            subscriptionName: results.data.subscriptionName,
	            subscriptionPeriod: results.data.subscriptionPeriod,
	            maxNumberOfBranches: results.data.maxNumberOfBranches,
	            maxLoanSchemeAllowed: results.data.maxLoanSchemeAllowed,
	            renewalReminderActivation: results.data.renewalReminderActivation,
	            pricePerMonth: results.data.pricePerMonth,
	            dataValidityPeriod: results.data.dataValidityPeriod,
	            subscriptionPrice: results.data.subscriptionId,
	            price: results.data.pricePackage,
	            tax: results.data.tax,
	            gst: results.data.gst,
	            subscriptionStartDate: results.data.startDate,
	            subscriptionEndDate: results.data.endDate,
	            renewalReminderDate : results.data.renewalReminderDate,
	            totalAmount: results.data.totalAmount
              });
            }
          });
  
  }
  performSubscriptionDetailsSubmit() {
    this.clearAllErrors();
    //console.log("form", this.subscriptionDetailsForm);
    let requestData = this.subscriptionDetailsForm.value;

    let dateFormat = 'yyyy-MM-DD';
    if(!this.isEditMode) {
        if(requestData.subscriptionStartDate!=null && requestData.subscriptionStartDate!='undefined' && requestData.subscriptionStartDate !='') {
		    let asOfStartDate = moment(requestData.subscriptionStartDate).format(dateFormat);
		    requestData.subscriptionStartDate = asOfStartDate;
	    }
	    if(requestData.renewalReminderDate!=null && requestData.renewalReminderDate!='undefined' && requestData.renewalReminderDate !='') {
		    let asOfRenewalDate = moment(requestData.renewalReminderDate).format(dateFormat);
		    requestData.renewalReminderDate = asOfRenewalDate;
	    }
    }
    
    if(this.isEditMode) {
        if(requestData.renewalReminderDate!=null && requestData.renewalReminderDate!='undefined' && requestData.renewalReminderDate !='') {
		    let asOfRenewalDate = moment(requestData.renewalReminderDate).format(dateFormat);
		    requestData.renewalReminderDate = asOfRenewalDate;
	    }
    }
    
    //console.log("requestData", requestData);
    this.clientConfigurationService.updateSubscriptionDetails(requestData).subscribe((results: any) => {
      //console.log("results", results);
      if (!results.metaData.success) {
        this.isError = true;
        this.errorMessage = results.metaData.description;
      } else {
        this.toastrService.success('Subscripton Details Information, saved successfully', 'Information', {
          timeOut: 3000,
        });
        //this.clientStepper.next();
        this.router.navigate(['home', {
          outlets: {
            appcontent: ['search-client']
          }
        }]);
      }
    },
      err => {
        this.errorMessage = err.error.errorMessage;
        this.isError = true;
      }
    );
  }
  
  changed(){
    console.log(this.statusLabel);
  }

  labelHelper: any = [];
  toggleStatus(i) {
    this.status = !this.status;
    const controls = this.newClientForm.get('contactInfo')['controls'];
    this.labelHelper[i] = controls[i].get('contactStatus').value;
    controls[i].get('contactStatus').setValue(this.labelHelper[i]);
  }

  viewDD(ddId,key1,key2,key3,key4){
    this.router.navigate(['home', {
      outlets: {
        appcontent: ['edit-template',ddId,key1,key2,key3,key4,'']
      }
    }]);
  }
  public versionData = {
    date: '',
    option: ''
  }

  createNewVersion(e,ddId) {
    /* const control = <FormArray>this.V1TemplatesForm.controls['V1TemplatesFormDetails'];
    //control.push(this.getV1TemplateData());
    //createNewTemplate
    console.log(e);
    console.log(this.V1TemplatesForm.get('V1TemplatesFormDetails').value[e]);
    control.push(this.V1TemplatesForm.get('V1TemplatesFormDetails').value[e]); */
    const dialogRef = this.dialog.open(createNewVersionDialogComponent, {
      width: '500px',
      panelClass: 'new-version'
    });
    dialogRef.componentInstance.passEntry.subscribe((receivedEntry) => {
      console.log("New Version Date :: ", receivedEntry.controls.date.value);
      console.log("New Version Option :: ", receivedEntry.controls.option.value);
	  this.clientConfigurationService.createNewTemplate
	      (receivedEntry.controls.date.value,receivedEntry.controls.option.value,ddId).subscribe((results: any) => {
	      console.log("resultsForCreateNewVersion", results);
	      if (!results.metaData.success) {
	        this.isError = true;
	        this.errorMessage = results.metaData.description;
	      } else {
	        this.toastrService.success('New Version created successfully', 'Information', {
	          timeOut: 3000,
	        });
	        this.loadV1TemplateDetails();
		 }
	  },
      err => {
        this.errorMessage = err.error.errorMessage;
        this.isError = true;
      });
    });
    
     
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
  loadV1TemplateDetails() {
    this.clientConfigurationService.loadV1TemplateDetails
	  (this.createClientForm.get('clientId').value,this.clientTypeId).subscribe((results: any) => {
		if (results && results.data && results.data.length > 0) {
		   this.v1TemplateCount = true;
		   let v1TemplateArrData = results.data;
		   (this.V1TemplatesForm.get('V1TemplatesFormDetails') as FormArray).clear();
		   v1TemplateArrData.forEach((eachData: any) => {
			const v1TemplateControl = this.getV1TemplateData();
			v1TemplateControl.patchValue({
			  ddId : eachData.ddId,
			  clientLoanSchemeName : eachData.clientLoanSchemeName,
			  templateStatus: eachData.templateStatus,
			  startDate: eachData.startDate,
			  endDate: eachData.endDate
			})
			this.addV1Template(v1TemplateControl);
		  });
		} 
    });
  
  }
  registerValues() {
    if(this.clientSubscriptionForm.get('productTypeId').value !='undefined') {
	    this.clientSubscriptionForm.get('productTypeId').valueChanges.subscribe(value => {
	      if (value && value != undefined) {
	        this.subscriptionModelOptions = [];
	        let productTypeId = value;
	        let subscriptionTypeId = this.clientSubscriptionForm.get('subscriptionTypeId').value;
	        let subscriptionSubTypeId = this.clientSubscriptionForm.get('subscriptionSubTypeId').value;
	        
	        if (productTypeId && subscriptionTypeId && subscriptionSubTypeId) {
	          this.subscriptionService.getAllSubscriptionModels(productTypeId,subscriptionTypeId,subscriptionSubTypeId).subscribe(result => {
	            console.log("result", result)
	            if (result && result.data) {
	              this.subscriptionModelOptions = result.data;
	            }
	          });
	        }
	      }
	      this.referenceService.getReferenceAllSubscriptionType(this.clientSubscriptionForm.get('productTypeId').value).subscribe(result => {
	        console.log("result", result)
	        if (result && result.data) {
	          this.subscriptionTypeOptions = result.data;
	        }
	      });
	    });
	    
	    
	}
	if(this.clientSubscriptionForm.get('subscriptionTypeId').value !='undefined') {
	    this.clientSubscriptionForm.get('subscriptionTypeId').valueChanges.subscribe(value => {
	      if (value && value != undefined) {
	        this.subscriptionModelOptions = [];
	        let productTypeId = this.clientSubscriptionForm.get('productTypeId').value;
	        let subscriptionTypeId = value;
	        let subscriptionSubTypeId = this.clientSubscriptionForm.get('subscriptionSubTypeId').value;
	        
	        if (productTypeId && subscriptionTypeId && subscriptionSubTypeId) {
	          this.subscriptionService.getAllSubscriptionModels(productTypeId,subscriptionTypeId,subscriptionSubTypeId).subscribe(result => {
	            console.log("result", result)
	            if (result && result.data) {
	              this.subscriptionModelOptions = result.data;
	            }
	          });
	        }
	      }
	    });
    }
    
    if(this.clientSubscriptionForm.get('subscriptionSubTypeId').value !='undefined') {
	    this.clientSubscriptionForm.get('subscriptionSubTypeId').valueChanges.subscribe(value => {
	      if (value && value != undefined) {
	        
	        this.subscriptionModelOptions = [];
	        let productTypeId = this.clientSubscriptionForm.get('productTypeId').value;
	        let subscriptionTypeId = this.clientSubscriptionForm.get('subscriptionTypeId').value;
	        let subscriptionSubTypeId = value;
	        
	        if (productTypeId && subscriptionTypeId && subscriptionSubTypeId) {
	          this.subscriptionService.getAllSubscriptionModels(productTypeId,subscriptionTypeId,subscriptionSubTypeId).subscribe(result => {
	            console.log("result", result)
	            if (result && result.data) {
	              this.subscriptionModelOptions = result.data;
	            }
	          });
	        }
	      }
	    });
	 }
  }
  
  
  openEditTemplate(ddId,status){
    this.router.navigate(['home', {
      outlets: {
        appcontent: ['edit-template',ddId,this.clientId,this.clientName,this.clientStatus,this.clientTypeId,'',status]
      }
    }]);
  }
}