import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class CreateUnitService {
  serviceContext = "/clientManagementCreateUnit/";

  constructor(private httpClient: HttpClient) { }

  createUnit(requestData:any){
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'client-mgmt-create-unit', requestData, Constants.httpOptions_app_json);
  }
  getUnit(unitType:any,unitName:any): Observable<any>{
    console.log("getUnit :", unitType,unitName);
    let requestData = {            
      clientGroupId: unitType,
      unitName: unitName
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'get-client-mgmt-unit', requestData, Constants.httpOptions_app_json);
  }
  
  getUnits(requestData:any): Observable<any>{
    console.log("getUnits :", requestData);
    
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'get-client-mgmt-all-unit', requestData, Constants.httpOptions_app_json);
  }
}
