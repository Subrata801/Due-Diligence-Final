import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class DueDeligenceService {
  serviceContext = "/clientConfiguration/";

  constructor(private httpClient: HttpClient) { }

  
  getDueDeligence(headerKey:any): Observable<any>{
    let requestData = {            
      headerKey: headerKey
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'due-deligence', requestData, Constants.httpOptions_app_json);
  }
  saveDueDeligence(requestData:any,action:String,headerKey:String){
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'save-due-deligence/'+action+'/'+headerKey, requestData, Constants.httpOptions_app_json);
  }
  
  deleteDueDeligence(module:String,ddId:number,reqData:any): Observable<any> {   
    return this.httpClient.post(environment.apiHost + this.serviceContext+ 'delete-duedeligence/'+module+'/'+ddId,reqData, Constants.httpOptions_app_json);
  }
  
  getListOfHeader(ddId:number,moduleName:String): Observable<any>{
    console.log("getListOfHeader", ddId,moduleName);
    let requestData = {            
      ddId: ddId,
      moduleName: moduleName
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'client-module-headers/'+ddId+'/'+moduleName, requestData, Constants.httpOptions_app_json);
  }
  
  getNewDeligence(ddId:number): Observable<any>{
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'new-due-deligence/'+ddId,Constants.httpOptions_app_json);
  }
}
