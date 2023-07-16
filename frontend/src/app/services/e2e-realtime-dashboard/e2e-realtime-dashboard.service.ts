import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class E2ERealTimeDashboardService {
  serviceContext = "/e2eRealtimeDashboard/";

  constructor(private httpClient: HttpClient) { }

  getE2ERealTimeDashBoardTasks(clientId:any,clientGroupId:any,moduleName:any,userName:any): Observable<any>{
    console.log("getE2ERealTimeDashBoardTasks :"+clientId,clientGroupId,moduleName,userName);
    let requestData = {            
      clientId: clientId,
      clientGroupId: clientGroupId,
      moduleName: moduleName,
      userName: userName
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'e2e-realtime-dashboard-tasks', requestData, Constants.httpOptions_app_json);
  }
  
  getE2EBankDetails(clientGroupId:any): Observable<any>{
    console.log("getE2EBankDetails :", clientGroupId);
    let requestData = {            
      clientGroupId: clientGroupId
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'realtime-dashboard-bank-details', requestData, Constants.httpOptions_app_json);
  }
  
}
