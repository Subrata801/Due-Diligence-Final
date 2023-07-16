import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class SubstituteUserAppService {
  serviceContext = "/substitue-userapplication/";

  constructor(private httpClient: HttpClient) { }

  raAssignUserApplication(requestData:any){
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'reassign-userapp', requestData, Constants.httpOptions_app_json);
  }
  getModuleSpecificSubstituteUserAppDetails(bankName:any,branchName:any,ifscCode:any,moduleName:any): Observable<any>{
    console.log("getModuleSpecificSubstituteUserAppDetails :", bankName,branchName,ifscCode,moduleName);
    let requestData = {            
      bankName: bankName,
      branchName: branchName,
      ifscCode: ifscCode,
      moduleName: moduleName
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'get-substitute-userapp', requestData, Constants.httpOptions_app_json);
  }
  
}
