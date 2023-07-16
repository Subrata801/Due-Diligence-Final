import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class CNCRealTimeDashboardService {
  serviceContext = "/cncrealtimedashboard/";

  constructor(private httpClient: HttpClient) { }

  getCNCRealTimeDashBoardTasks(clientId:any,moduleName:any,userName:any): Observable<any>{
    console.log("getCNCRealTimeDashBoardTasks for module Name :"+moduleName+" client Id :"+clientId);
    let requestData = {            
      clientId: clientId,
      moduleName: moduleName,
      userName: userName
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'cnc-realtime-dashboard-tasks', requestData, Constants.httpOptions_app_json);
  }
  
}
