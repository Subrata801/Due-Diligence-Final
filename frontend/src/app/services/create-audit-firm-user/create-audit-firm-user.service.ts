import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class CreateAuditFirmUserService {
  serviceContext = "/clientManagementAuditFirm/";

  constructor(private httpClient: HttpClient) { }

  createAuditFirmUser(requestData:any){
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'client-mgmt-create-auditfirm-user', requestData, Constants.httpOptions_app_json);
  }
  getAuditFirmUser(userName:any,employeeId:any): Observable<any>{
    console.log("getAuditFirmUser :", userName,employeeId);
    let requestData = {            
      userName: userName,
      employeeId: employeeId
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'get-client-mgmt-auditfirm-user', requestData, Constants.httpOptions_app_json);
  }
  
  getAuditFirmUsers(requestData:any): Observable<any>{
    console.log("getAuditFirmUsers :", requestData);
    
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'get-client-mgmt-all-auditfirm-user', requestData, Constants.httpOptions_app_json);
  }
}
