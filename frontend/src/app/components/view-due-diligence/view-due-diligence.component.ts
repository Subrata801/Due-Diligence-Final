import { Component, OnInit } from '@angular/core';
import { FormArray,FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';
import { ActivatedRoute, Router } from '@angular/router';
import { InitiateDueDiligenceService } from '../../services/initiate-due-diligence/initiate-due-diligence.service';
import { TokenStorageService } from '../../services/token-service/token-storage.service';
import { AuthService } from '../../services/auth-service/auth.service';

@Component({
  selector: 'app-view-due-diligence',
  templateUrl: './view-due-diligence.component.html',
  styleUrls: ['./view-due-diligence.component.scss']
})
export class viewDueDiligenceComponent implements OnInit {

  loadHeaders = false;
  isError = false;
  action: boolean = false;
  //isHeader1 = false;
  //isHeader2 = false;
  //isHeader3 = false;
  //isHeader4 = false;
  //isHeader5 = false;
  errorMessage = '';
  loanAppId: any;
  clientId: any;
  headerObj: any;
  //header2: any;
  //header3: any;
  //header4: any;
  moduleName :any;
  clientTypeId:any;
  clientName:any;
  status : any;
  templateStatus : any;
  roles: string[] = [];
  bankAdmin: boolean = false;
  moduleDesc: any;

  constructor(private formBuilder: FormBuilder,
    private activatedroute: ActivatedRoute,
    private router: Router,
    private errorHandler: ErrorHandler,private tokenService: TokenStorageService,private authService: AuthService,
    private initiateDueDiligenceService: InitiateDueDiligenceService,
    private toastr: ToastrService) {
      this.loanAppId = this.activatedroute.snapshot.paramMap.get("loanAppId");
	  this.moduleName = this.getModuleNameFromLoanStatus(this.activatedroute.snapshot.paramMap.get("moduleName"));
  }

  ngOnInit(): void {
     if(this.moduleName != '' && this.loanAppId !='' && this.moduleName != 'undefined' && this.loanAppId !='undefined') {
       this.loadApi(this.moduleName);
     }
     //this.roles = this.tokenService.getUser().roles;
     //if(this.roles[0] == 'BNAdmin' || this.roles[0] == 'BNMGMT' || this.roles[0] =='AFAdmin' || this.roles[0] =='AFMgmt'){
     //   this.bankAdmin = true;
     //}
     this.moduleDesc = this.getModuleDesc(this.moduleName);
  }

  getModuleNameFromLoanStatus(loanStatus:string){
    console.log('getModuleNameFromLoanStatus:loanStatus:'+loanStatus);
    if(loanStatus.length>1) {
      let transactionModuleNum = loanStatus.charAt(1);
      console.log('getModuleNameFromLoanStatus:transactionModuleNum:'+transactionModuleNum);
      return parseInt(transactionModuleNum);
    } else {
      console.log('getModuleNameFromLoanStatus:Parsing not needed, use as it is moduleName:'+loanStatus);
      return loanStatus;
    }
  }

  getModuleDesc(moduleName){
    console.log('getModuleDesc:for moduleName:'+moduleName);
    if(moduleName==1){
      return 'Module 1 - Scrutiny of Application';
    }else if(moduleName==2){
      return 'Module 2 - Documentation,Creation of Securities,Insurance And Loan Disbursement';
    }else if(moduleName==3){
      return 'Module 3 - Confirmation of Securities Obtained,to be done within 1Month of Loan Disbursement';
    }else if(moduleName==4){
      return 'Module 4 - Periodic Monitoring & Follow up';
    }else {
      return 'Module 5 - Release of Securities on Closure of Account';
    }
  }

  loadHeadersList() {
    this.loadHeaders = true;
  }

  loadApi(moduleName) {
    console.log('loadApi:moduleName:',moduleName);
    this.headerObj = '';

    this.loadHeaders = false;
    this.initiateDueDiligenceService.getListOfDueDiligenceHeader(this.loanAppId,this.moduleName).subscribe(results => {
        if (results && results.data && results.data.length > 0) {
          let headerData = results.data;
          console.log('headerData :',headerData);
          console.log('module name:'+this.moduleName);
          this.loadHeaders = true;
          //this.moduleName = headerData[0].moduleName;
          this.headerObj = headerData[0].headerMap;
          this.isError = false;
        } else {
            this.errorMessage = 'No Headers configured for the module';
        	this.isError = true;
        }
    },
      err => {
        this.errorMessage = err.errorMessage;
        this.isError = true;
      });
  } 

  viewDD(headerKey){
    this.router.navigate(['home', {
      outlets: {
        appcontent: ['due-diligence-page',this.moduleName+'_'+headerKey]
      }
    }]);
  }
  asIsOrder(a, b) {
    return 1;
  }
  
}
