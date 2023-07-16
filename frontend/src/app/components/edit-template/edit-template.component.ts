import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';
import { ActivatedRoute, Router } from '@angular/router';
import { DueDeligenceService } from 'src/app/services/due-deligence/due-deligence.service';
import { TokenStorageService } from '../../services/token-service/token-storage.service';

@Component({
  selector: 'app-edit-template',
  templateUrl: './edit-template.component.html',
  styleUrls: ['./edit-template.component.scss']
})
export class EditTemplateComponent implements OnInit {

  loadHeaders = false;
  isError = false;
  action: boolean = false;
  //isHeader1 = false;
  //isHeader2 = false;
  //isHeader3 = false;
  //isHeader4 = false;
  //isHeader5 = false;
  errorMessage = '';
  ddId: any;
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

  constructor(private formBuilder: FormBuilder,
    private activatedroute: ActivatedRoute,
    private router: Router,
    private errorHandler: ErrorHandler,private tokenService: TokenStorageService,
    private toastr: ToastrService,
    private dueDeligenceService: DueDeligenceService) {
      this.ddId = this.activatedroute.snapshot.paramMap.get("ddId");
      this.clientId = this.activatedroute.snapshot.paramMap.get("clientId");
	  this.clientTypeId = this.activatedroute.snapshot.paramMap.get("clientTypeId");
	  this.status = this.activatedroute.snapshot.paramMap.get("status");
	  this.clientName = this.activatedroute.snapshot.paramMap.get("clientName");
	  this.moduleName = this.activatedroute.snapshot.paramMap.get("moduleName");
	  this.templateStatus = this.activatedroute.snapshot.paramMap.get("templateStatus");
  }

  ngOnInit(): void {
     if(this.moduleName != '') {
       this.loadApi(this.moduleName);
     }
     this.roles = this.tokenService.getUser().roles;
     if(this.roles[0] == 'BNADMIN' || this.roles[0] == 'BNMGMT' || this.roles[0] =='AFAdmin' || this.roles[0] =='AFMgmt'){
        this.bankAdmin = true;
     }
  }

  loadApi(moduleName) {
    this.headerObj = '';

    this.loadHeaders = false;
    this.dueDeligenceService.getListOfHeader(this.ddId,moduleName).subscribe(results => {
        if (results && results.data && results.data.length > 0) {
          let headerData = results.data;
          console.log('headerData :',headerData);
          this.loadHeaders = true;
          this.moduleName = moduleName;
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
        appcontent: ['due-diligence',this.moduleName+'_'+headerKey,this.clientId,this.templateStatus]
      }
    }]);
  }
  asIsOrder(a, b) {
    return 1;
  }
  openClient() {
    this.action = false;
    if(this.bankAdmin) {
       this.router.navigate(['home', {
		      outlets: {
		        appcontent: ['v1-templatess',this.clientId]
		      }
		    }]);
    }  else {
	    this.router.navigate(['home', {
	      outlets: {
	        appcontent: ['new-client',this.clientTypeId,this.clientName,this.clientId,this.action,this.status]
	      }
	    }]);
    }
  }
}
