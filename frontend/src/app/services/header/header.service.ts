import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class HeaderService {
  serviceContext = "/template/";

  constructor(private httpClient: HttpClient) { }

  getHeaders(): Observable<any>{
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'header', Constants.httpOptions_app_json);
  }

  searchHeaders(headerKey:string,englishDescription:string,nonEnglishDescription:string): Observable<any>{
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'header?headerKey='+headerKey+'&englishDescription='+englishDescription+'&nonEnglishDescription='+encodeURIComponent(nonEnglishDescription), Constants.httpOptions_app_json);
  }
 
  addHeader(reqData:any): Observable<any>{
    console.log("reqData",reqData);
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'header',reqData, Constants.httpOptions_app_json);
  }
  
  getRiskData(clientTypeId:any,clientId:any,firmId:any): Observable<any>{
    let requestData = {
      clientTypeId: clientTypeId,            
      clientId: clientId,
      firmId:firmId
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'get-risk-rating',requestData, Constants.httpOptions_app_json);
  }
  
  saveRiskData(reqData:any): Observable<any>{
    console.log("reqData",reqData);
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'risk-rating',reqData, Constants.httpOptions_app_json);
  }
}
