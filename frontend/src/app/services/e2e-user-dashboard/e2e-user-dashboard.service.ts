import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class E2EUserDashboardService {
  serviceContext = "/e2eDashboardController/";

  constructor(private httpClient: HttpClient) { }

  deleteCommercialFacility(requestData:any){
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'delete-e2e-commercial-credit-facility', requestData, Constants.httpOptions_app_json);
  }
  
  getE2EDashBoardTasks(clientId:any,clientGroupId:any,moduleName:any,userName:any): Observable<any>{
    console.log("getE2EDashBoardTasks :", clientId,clientGroupId,moduleName,userName);
    let requestData = {            
      clientId: clientId,
      clientGroupId: clientGroupId,
      moduleName: moduleName,
      userName: userName
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'e2e-dashboard-tasks', requestData, Constants.httpOptions_app_json);
  }

  getE2EBankDetails(clientGroupId:any): Observable<any>{
    console.log("getE2EBankDetails :", clientGroupId);
    let requestData = {            
      clientGroupId: clientGroupId
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'dashboard-bank-details', requestData, Constants.httpOptions_app_json);
  }
    
  getE2ETaskDtails(moduleName:any,e2eNum:any): Observable<any>{
    console.log("getE2ETaskDtails :");
    let requestData = {            
      moduleName: moduleName,
      e2eNum: e2eNum
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'get-e2e-details', requestData, Constants.httpOptions_app_json);
  }

  getE2EFullReport(e2eNum:any, moduleNum:any): Observable<any>{
    return this.httpClient.get(environment.apiHost + this.serviceContext + 
      'e2e-full-report?e2eNum='+e2eNum+'&moduleNum='+moduleNum,
      {responseType:'blob'});
  }
}

