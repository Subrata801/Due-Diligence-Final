import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class BranchUserService {
  serviceContext = "/clientManagementBranchUser/";

  constructor(private httpClient: HttpClient) { }

  createBranchUser(requestData:any){
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'client-mgmt-create-branch-user', requestData, Constants.httpOptions_app_json);
  }
  
  getBranchUser(userName:any): Observable<any>{
    console.log("getBranchUser request param :", userName);
    let requestData = {
      userName : userName
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'get-client-mgmt-branch-user', requestData, Constants.httpOptions_app_json);
  }
  
  getBranchUsers(requestData:any): Observable<any>{
    console.log("manageEmployees :", requestData);
    
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'get-client-mgmt-all-branch-users', requestData, Constants.httpOptions_app_json);
  }
  
  getUnitNames(clientId:any): Observable<any>{
    console.log("getUnitNames :", clientId);
    let requestData = {
      clientId : clientId
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'unit-names', requestData, Constants.httpOptions_app_json);
  }
  
  getUserRoles(uniId:any): Observable<any>{
    console.log("getUserRoles :", uniId);
    let requestData = {
      clientGroupId : uniId
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'userrole-names', requestData, Constants.httpOptions_app_json);
  }
  
  getEmployeeName(employeeId:any): Observable<any>{
    console.log("getEmployeeName :", employeeId);
    let requestData = {
      employeeId : employeeId
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'employee-names', requestData, Constants.httpOptions_app_json);
  }
}
