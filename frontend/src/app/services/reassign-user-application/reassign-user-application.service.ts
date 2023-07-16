import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class ReassignUserAppService {
  serviceContext = "/reassignuserapplication/";

  constructor(private httpClient: HttpClient) { }

  raAssignUserApplication(requestData:any){
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'reassign-userapp', requestData, Constants.httpOptions_app_json);
  }
  getModuleSpecificUserAppDetails(clientId:any,clientGroupId:any,moduleName:any,userName:any): Observable<any>{
    console.log("getModuleSpecificUserAppDetails :", clientId,clientGroupId,moduleName,userName);
    let requestData = {            
      clientId: clientId,
      clientGroupId: clientGroupId,
      moduleName: moduleName,
      userName: userName
    }
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'get-reassign-userapp', requestData, Constants.httpOptions_app_json);
  }
  
  getMakerList(clientGroupId:any): Observable<any>{
    console.log("getMakerList :", clientGroupId);
    let requestData = { 
      clientGroupId: clientGroupId
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'makers', requestData, Constants.httpOptions_app_json);
  }
  
  getCheckerList(clientGroupId:any): Observable<any>{
    console.log("getMakerList :", clientGroupId);
    let requestData = { 
      clientGroupId: clientGroupId
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'checkers', requestData, Constants.httpOptions_app_json);
  }
  
  getCpcList(clientGroupId:any): Observable<any>{
    console.log("getMakerList :", clientGroupId);
    let requestData = { 
      clientGroupId: clientGroupId
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'sanctioning-authority', requestData, Constants.httpOptions_app_json);
  }
  
  saveReassignUser(requestData:any): Observable<any>{
    console.log('saveReassignUser:requestData:'+requestData);
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'save-reassign-user', requestData, Constants.httpOptions_app_json);
  }
}
