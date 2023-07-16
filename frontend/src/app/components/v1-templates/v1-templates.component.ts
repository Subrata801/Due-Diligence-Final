import { StepperSelectionEvent } from '@angular/cdk/stepper';
import { ViewChild } from '@angular/core';
import { ErrorHandler, Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
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

@Component({
  selector: 'app-v1-templates',
  templateUrl: './v1-templates.component.html',
  styleUrls: ['./v1-templates.component.scss']
})
export class v1TemplatesComponent implements OnInit {
  V1TemplatesForm: FormGroup;
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

  @ViewChild('stepper') private clientStepper: MatStepper;

  constructor(private formBuilder: FormBuilder, private errorHandler: ErrorHandler, private datepicker: MatDatepickerModule,
    private toastrService: ToastrService, private activatedroute: ActivatedRoute, private createNewClientService: CreateNewClientService,
    private referenceService: ReferenceService, private router: Router, private subscriptionService: SubscriptionService,
    private languageTemplateService: LanguageTemplateService, private clientConfigurationService: ClientConfigurationService) {
    //console.log("All param map :", this.activatedroute.snapshot.paramMap);
    this.clientTypeId = this.activatedroute.snapshot.paramMap.get("clientTypeId");
    this.clientName = this.activatedroute.snapshot.paramMap.get("clientName");
    this.clientId = this.activatedroute.snapshot.paramMap.get("clientId");
    this.action = this.activatedroute.snapshot.paramMap.get("action");
    this.clientStatus = this.activatedroute.snapshot.paramMap.get("status");
    
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
    this.productTypeOptions = [{ productTypeId: 1, productTypename: "e 2 e Solution in Retail Lending" },
    { productTypeId: 2, productTypename: "c n c Solution in Audit" }];
  }

  getAvailableV1TemplateControl() {
    return (this.V1TemplatesForm.get('V1TemplatesFormDetails') as FormArray).controls;
  }
  // add new row
  
  addV1Template(formGroup :FormGroup) {
  	const control = <FormArray>this.V1TemplatesForm.controls['V1TemplatesFormDetails'];
    control.push(formGroup);
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

  ngOnInit(): void {
    this.V1TemplatesForm = this.formBuilder.group({
      V1TemplatesFormDetails: this.formBuilder.array([
        this.getV1TemplateData()
      ])
    });
  }
  
  openEditTemplate(ddId){
    this.router.navigate(['home', {
      outlets: {
        appcontent: ['edit-template',ddId,this.clientId,this.clientName,this.clientStatus,this.clientTypeId,'']
      }
    }]);
  }
}
