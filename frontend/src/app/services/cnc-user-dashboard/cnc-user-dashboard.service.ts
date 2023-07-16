import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class CNCUserDashboardService {
  serviceContext = "/cncdashboard/";

  constructor(private httpClient: HttpClient) { }

  getCNCDashBoardTasks(clientId:any,moduleName:any,userName:any): Observable<any>{
    console.log("getCNCDashBoardTasks for module Name :",moduleName);
    let requestData = {            
      clientId: clientId,
      moduleName: moduleName,
      userName: userName
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'cnc-dashboard-tasks', requestData, Constants.httpOptions_app_json);
  }
  
}
