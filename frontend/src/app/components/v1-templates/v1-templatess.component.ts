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
import { AuthService } from '../../services/auth-service/auth.service';

@Component({
  selector: 'app-v1-templatess',
  templateUrl: './v1-templatess.component.html',
  styleUrls: ['./v1-templatess.component.scss']
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
    private languageTemplateService: LanguageTemplateService, private clientConfigurationService: ClientConfigurationService,
    private authService: AuthService) {
    
    //this.clientId = this.activatedroute.snapshot.paramMap.get("clientId");
  }

  ngOnInit(): void {
    this.V1TemplatesForm = this.formBuilder.group({
      V1TemplatesFormDetails: this.formBuilder.array([
        this.getV1TemplateData()
      ])
    });
    this.fetchUserData();
  }

  addV1Template() {
  	const control = <FormArray>this.V1TemplatesForm.controls['V1TemplatesFormDetails'];
    control.push(this.getV1TemplateData());
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
  
  getAvailableV1TemplateControl() {
    return (this.V1TemplatesForm.get('V1TemplatesFormDetails') as FormArray).controls;
  }
  
  fetchUserData() {
    var clntId = '';
    forkJoin([this.authService.getUserInfo()])
      .subscribe(results => {
        if (results[0] && results[0].data) {
	        this.clientId = results[0].data.clientId;
	        this.clientName = results[0].data.clientName;
	        this.clientTypeId = results[0].data.clientTypeId;
	        this.clientStatus = 'COMPLETED';
        }
        this.fetchTemplateData(this.clientId,this.clientTypeId);
      });
  }
  fetchTemplateData(clientID,clientTypeId) {
    let v1TemplateDataArr: any = [];
    this.clientConfigurationService.loadV1TemplateDetails(clientID,this.clientTypeId).subscribe(results => {
       if (results && results.data) {
           this.v1TemplateCount = true;
           (this.V1TemplatesForm.get('V1TemplatesFormDetails') as FormArray).clear();
           results.data.forEach((eachData: any) => {
            v1TemplateDataArr.push({
              ddId : eachData.ddId,
              clientLoanSchemeName : eachData.clientLoanSchemeName,
	          templateStatus: eachData.templateStatus,
	          startDate: eachData.startDate,
	          endDate: eachData.endDate
            });
            
           });
        
			v1TemplateDataArr.forEach((eachArray, index) => {
				  this.addV1Template();
			});
        }
        this.V1TemplatesForm.patchValue({
            V1TemplatesFormDetails: v1TemplateDataArr
          });
    },
	  err => {
		console.log("err", err);
		this.errorMessage = err.error.errorMessage;
		this.isError = true;
		
	  });
  }
  
  openEditTemplate(ddId,status){
    this.router.navigate(['home', {
      outlets: {
        appcontent: ['edit-template',ddId,this.clientId,this.clientName,this.clientStatus,this.clientTypeId,'',status]
      }
    }]);
  }
}
