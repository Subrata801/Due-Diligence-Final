import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class ManagementDashboardService {
  serviceContext = "/clientManagementDashBoard/";

  constructor(private httpClient: HttpClient) { }

  updateTask(requestData:any){
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'client-mgmt-dashboard-task', requestData, Constants.httpOptions_app_json);
  }
  
  getManagementDashBoardTask(module:any,e2eApplicationNum:any): Observable<any>{
    console.log("getManagementDashBoardTask :", module,e2eApplicationNum);
    let requestData = {            
      module: module,
      e2eApplicationNum: e2eApplicationNum
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'get-client-mgmt-dashboard-task', requestData, Constants.httpOptions_app_json);
  }
  
  getListOfTask(requestData:any): Observable<any>{
    console.log("getListOfTask :", requestData);
    
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'get-client-mgmt-dashboard-tasks', requestData, Constants.httpOptions_app_json);
  }
}
