import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from '../../services/token-service/token-storage.service';
import { AuthService } from '../../services/auth-service/auth.service';
import { forkJoin, Observable } from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  roles: string[] = [];
  admin: boolean = false;
  allAdmin: boolean = false;
  nonadmin: boolean = false;
  isReviewTempleate: boolean = false;
  isClientManagement: boolean = false;
  isCreatUnit: boolean = false;
  isCreatAuditFirm: boolean = false;
  isManageEmployee: boolean = false;
  isBranchUsers: boolean = false;
  isUserPanel: boolean = true;
  isCIFRegistraion: boolean = false;
  ise2eDashboard: boolean = false;
  isReassignCancelUser: boolean = false;
  ise2eRealTimeDashboard: boolean = false;
  isDueDeligenceForAudit: boolean = false;
  isCncUserDashboard: boolean = false;
  isReAssignUserDashboard: boolean = false;
  isCncRealTimeUserDashboard: boolean = false;
  initiateDueDeligenceProcess: boolean = true;
  isE2EReport: boolean = false;
  isCNCReport: boolean = false;
  clientId:any;
  clientName:any;
  imageName:any;
  constructor(private router:Router, private tokenService: TokenStorageService,
    private authService: AuthService) { }

  ngOnInit(): void {
    this.fetchUserData();
    this.roles[0] = this.tokenService.getUser().roles;
    console.log("this.roles changed  in home page ", this.roles);

    if(this.roles[0] == 'BMTRADMIN') {
    	this.admin = true;
    	//this.router.navigate(['home',{ outlets: { appcontent: ['user',null] } }]);
    } 
    if(this.roles[0] == 'BMTRMGMT' || this.roles[0] == 'BNADMIN' || this.roles[0] == 'BNMGMT' || this.roles[0] == 'AFADMIN' || this.roles[0] == 'AFMGMT' || this.roles[0] == 'AFCA') {
    	this.isReviewTempleate = true;
    } 
    if(this.roles[0] == 'BRSA' || this.roles[0] == 'BNADMIN' || this.roles[0] == 'BNMGMT' || this.roles[0] == 'CPCSA' || this.roles[0] == 'ZOSA' || this.roles[0] == 'HOSA' || this.roles[0] == 'AFADMIN' || this.roles[0] == 'AFMGMT') {
    	this.isClientManagement = true;
    }
    if(this.roles[0] == 'BNADMIN' || this.roles[0] == 'BNMGMT') {
    	this.isCreatUnit = true;
    }
    //if(this.roles[0] == 'AFADMIN' || this.roles[0] == 'AFMGMT') {
    //	this.isCreatAuditFirm = true;
    //}
    if(this.roles[0] == 'BNADMIN' || this.roles[0] == 'BNMGMT') {
    	this.isManageEmployee = true;
    }
    if(this.roles[0] == 'BNADMIN' || this.roles[0] == 'BNMGMT' || this.roles[0] == 'BRSA' || this.roles[0] == 'CPCSA' || this.roles[0] == 'ZOSA' || this.roles[0] == 'HOSA') {
    	this.isBranchUsers = true;
    }
    if(this.roles[0] == 'BMTRMGMT' || this.roles[0] == 'BNADMIN' || this.roles[0] == 'BNMGMT' || this.roles[0] == 'BRMKR' || this.roles[0] == 'BRMKR-STDBY' || this.roles[0] == 'BRCHKR' || this.roles[0] == 'BRCHKR-STDBY' || 
             this.roles[0] == 'BRSA' || this.roles[0] == 'CPCMKR' || this.roles[0] == 'CPCCHKR' || this.roles[0] == 'CPCCHKR-STDBY' || this.roles[0] == 'CPC-MONITOR' 
             || this.roles[0] == 'CPCSA' || this.roles[0] == 'ZOMKR' || this.roles[0] == 'ZOCHKR' || this.roles[0] == 'ZOCHKR-STDBY' || this.roles[0] == 'ZO-MONITOR' 
             || this.roles[0] == 'ZOSA' || this.roles[0] == 'HOMKR' ||	this.roles[0] == 'HOCHKR' ||	this.roles[0] == 'HOCHKR-STDBY' ||	this.roles[0] == 'HO-MONITOR' 
             || this.roles[0] == 'HOSA' || this.roles[0] == 'AFADMIN' || this.roles[0] == 'AFMGMT' || this.roles[0] == 'AFMKR' || this.roles[0] == 'AFCHKR' || this.roles[0] == 'AFCA') {
    	this.isUserPanel = true;
    }
    if(this.roles[0] == 'BNADMIN' || this.roles[0] == 'BRSA' || this.roles[0] == 'CPCSA' || this.roles[0] == 'ZOSA' || this.roles[0] == 'HOSA') {
    	this.isCIFRegistraion = true;
    }
    if(this.roles[0] == 'BNADMIN' || this.roles[0] == 'BRMKR' || this.roles[0] == 'BRMKR-STDBY' || this.roles[0] == 'BRCHKR' || this.roles[0] == 'BRCHKR-STDBY' || 
             this.roles[0] == 'BRSA' || this.roles[0] == 'CPCMKR' || this.roles[0] == 'CPCCHKR' || this.roles[0] == 'CPCCHKR-STDBY' || this.roles[0] == 'CPC-MONITOR' 
             || this.roles[0] == 'CPCSA' || this.roles[0] == 'ZOMKR' || this.roles[0] == 'ZOCHKR' || this.roles[0] == 'ZOCHKR-STDBY' || this.roles[0] == 'ZO-MONITOR' 
             || this.roles[0] == 'ZOSA' || this.roles[0] == 'HOMKR' ||	this.roles[0] == 'HOCHKR' ||	this.roles[0] == 'HOCHKR-STDBY' ||	this.roles[0] == 'HO-MONITOR' 
             || this.roles[0] == 'HOSA'
             ) {
    	this.ise2eDashboard = true;
    }
    if(this.roles[0] == 'BNADMIN' || this.roles[0] == 'BRSA' || this.roles[0] == 'CPCSA' || this.roles[0] == 'ZOSA' || this.roles[0] == 'HOSA') {
    	this.isReassignCancelUser = true;
    }
    if(this.roles[0] == 'BNADMIN' || this.roles[0] =='BNMGMT' || this.roles[0] == 'BRSA' || this.roles[0] == 'CPC-MONITOR' 
            || this.roles[0] == 'CPCSA' || this.roles[0] == 'ZO-MONITOR' || this.roles[0] == 'ZOSA' || this.roles[0] == 'HO-MONITOR' || this.roles[0] == 'HOSA') {
    	this.ise2eRealTimeDashboard = true;
    }
    //if(this.roles[0] == 'BRSA' || this.roles[0] == 'CPCSA' || this.roles[0] == 'ZOSA' || this.roles[0] == 'HOSA' || this.roles[0] == 'BNADMIN' 
    //         || this.roles[0] == 'AFADMIN' || this.roles[0] == 'AFMGMT' || this.roles[0] == 'AFMKR' || this.roles[0] == 'AFCHKR' || this.roles[0] == 'AFCA') {
    //	this.isDueDeligenceForAudit = true;
    //}
    //if(this.roles[0] == 'AFADMIN' || this.roles[0] == 'AFMGMT' || this.roles[0] == 'AFMKR' || this.roles[0] == 'AFCHKR' || this.roles[0] == 'AFCA') {
    //	this.isCncUserDashboard = true;
    //}
    //if(this.roles[0] == 'AFADMIN' || this.roles[0] == 'AFMGMT' || this.roles[0] == 'AFCA') {
    //	this.isReAssignUserDashboard = true;
    //}
    //if(this.roles[0] == 'AFADMIN' || this.roles[0] == 'AFMGMT' || this.roles[0] == 'AFMKR' || this.roles[0] == 'AFCHKR' || this.roles[0] == 'AFCA') {
    //	this.isCncRealTimeUserDashboard = true;
    //}
    if(this.roles[0] == 'HOSA' || this.roles[0] == 'BRSA' || this.roles[0] == 'CPCSA' || this.roles[0] == 'ZOSA' || this.roles[0] == 'BNADMIN' || this.roles[0] == 'AFADMIN' || this.roles[0] == 'AFMGMT' || this.roles[0] == 'AFMKR') {
    	this.initiateDueDeligenceProcess = true;
    }
    if(this.roles[0] == 'BNADMIN' || this.roles[0] == 'BMTRMGMT' || this.roles[0] == 'BRSA' || this.roles[0] == 'CPCSA' || this.roles[0] == 'ZOSA' || this.roles[0] == 'HOSA') {
    	this.isE2EReport = true;
    }
    //if(this.roles[0] == 'BMTRMGMT' || this.roles[0] == 'AFMGMT' || this.roles[0] == 'AFCA') {
    //	this.isCNCReport = true;
    //}
    //if(this.roles[0] == 'BNAdmin' || this.roles[0] =='BNMGMT' || this.roles[0] =='AFAdmin' || this.roles[0] =='AFMgmt') {
    //	this.allAdmin = true;
    //	this.authService.getUserInfo()
	//      .subscribe(results => {
	//        if (results[0] && results[0].data) {
	//	        this.clientId = results[0].data.clientId;
	//        }
	//        this.router.navigate(['home', {
	//	      outlets: {
	//	        appcontent: ['v1-templatess',this.clientId]
	//	      }
	//	    }]);
	//      });


    	//this.router.navigate(['home',{ outlets: { appcontent: ['v1-templatess',null] } }]);
    	//this.router.navigate(['v1-templatess']);
    //} 
    if(this.roles[0] == 'BMTRADMIN' || this.roles[0] == 'BMTRADMIN') {
       this.router.navigate(['home',{ outlets: { appcontent: ['user',null] } }]);
    } else if(this.roles[0] == 'BNMGMT' || this.roles[0] == 'AFADMIN' || this.roles[0] == 'AFMGMT' || this.roles[0] == 'AFCA') {
       this.authService.getUserInfo()
	      .subscribe(results => {
	        if (results[0] && results[0].data) {
		        this.clientId = results[0].data.clientId;
	        }
	        this.router.navigate(['home', {
		      outlets: {
		        appcontent: ['v1-templatess',this.clientId]
		      }
		    }]);
	      });
    } else if(this.roles[0] == 'AFADMIN' || this.roles[0] == 'AFMGMT') {
       this.router.navigate(['home',{ outlets: { appcontent: ['create-audit-firm-user',null,null] } }]);
    } else if(this.roles[0] == 'AFADMIN' || this.roles[0] == 'AFMGMT') {
       this.router.navigate(['home',{ outlets: { appcontent: ['create-audit-firm-user',null,null] } }]);
    } else if (this.roles[0] == 'BRMKR' || this.roles[0] == 'BRMKR-STDBY' || this.roles[0] == 'BRCHKR' || 
	    this.roles[0] == 'BRCHKR-STDBY' || this.roles[0] == 'CPCMKR' || this.roles[0] == 'CPCCHKR' 
	    || this.roles[0] == 'CPCCHKR-STDBY' || this.roles[0] == 'CPC-MONITOR' || this.roles[0] == 'ZOMKR' || this.roles[0] == 'ZOCHKR' 
	    || this.roles[0] == 'ZOCHKR-STDBY' || this.roles[0] == 'ZO-MONITOR' || this.roles[0] == 'HOMKR' ||	this.roles[0] == 'HOCHKR'
	     ||	this.roles[0] == 'HOCHKR-STDBY' ||	this.roles[0] == 'HO-MONITOR') {
       this.router.navigate(['home',{ outlets: { appcontent: ['e2e-user-dashboard'] } }]);
    } else if (this.roles[0] == 'BRSA' || this.roles[0] == 'CPCSA' || this.roles[0] == 'ZOSA' || this.roles[0] == 'HOSA') {
        this.router.navigate(['home',{ outlets: { appcontent: ['branch-users',null] } }]);
    } else if (this.roles[0] == 'AFMKR' || this.roles[0] == 'AFCHKR') {
        this.router.navigate(['home',{ outlets: { appcontent: ['initiate-audit',null] } }]);
    }
    //else {
   	  //	this.nonadmin = true;
   	  //	this.router.navigate(['home',{ outlets: { appcontent: ['app-client-management-dashboard'] } }]);
    //}
  }

  updateImagename(){
    let imageFolder = "./assets/images/";
      let cName:string = this.clientName;
      let firstLetter:string = cName.split(" ")[0]; //If client name is=Indian Bank, then firstLetter=Indian
      console.log('updateImagename:firstLetter:'+firstLetter);
      console.log('name string:'+firstLetter.toLowerCase());
      this.imageName = imageFolder + firstLetter.toLowerCase() +".jpg"; //make sure a file already exist with same name
      //as per above example, ./assets/images/indian.jpg file should exist before only
      console.log('imageName:'+this.imageName);
  }

  fetchUserData() {
    var clntId = '';
    forkJoin([this.authService.getUserInfo()])
      .subscribe(results => {
        if (results[0] && results[0].data) {
            console.log('User Info :',results[0].data);
	        this.clientName = results[0].data.clientName;
	        this.updateImagename();
          //this.imageName="./assets/images/idbi.jpg"
        }
      });
      //alert(this.clientName);
  }
  
  performLogout(){
    this.tokenService.signOut();
    this.router.navigate(['login']);
  }

  goToClientConfig(){
    //this.router.navigate(['client',{ outlets: { clientcontent: ['search-client'] } }]);
    this.router.navigate(['home',{ outlets: { appcontent: ['client'] } }]);
  }

  openV1Template() {
	this.router.navigate(['home', {
      outlets: {
        appcontent: ['v1-templatess',this.clientId]
      }
    }]);
  }

}
