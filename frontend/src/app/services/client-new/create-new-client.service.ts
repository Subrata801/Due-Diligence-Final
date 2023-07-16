import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class CreateNewClientService {
  serviceContext = "/clientConfiguration/";

  constructor(private httpClient: HttpClient) { }

  createClient(requestData:any){
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'client', requestData, Constants.httpOptions_app_json);
  }
  getMatchingClients(clientTypeId:any,clientName:any): Observable<any>{
    console.log("getMatchingClients", clientTypeId,clientName);
    let requestData = {            
      clientTypeId: clientTypeId,
      clientName: clientName
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'clients', requestData, Constants.httpOptions_app_json);
  }
  
  getMatchingClientsByTemplate(clientId:any,templateStatus:any): Observable<any>{
    console.log("getMatchingClientsByTemplate", clientId,templateStatus);
    let requestData = {            
      clientId: clientId,
      v1TemplateStatus: templateStatus
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'clients', requestData, Constants.httpOptions_app_json);
  }
  createBankDetails(requestData:any,clientTypeId:any){
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'bank-details/'+clientTypeId, requestData, Constants.httpOptions_app_json);
  }
  createLoanScheme(requestData:any){
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'create-clientloanscheme', requestData, Constants.httpOptions_app_json);
  }
  createLoanVariant(requestData:any){
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'create-clientloanvariant', requestData, Constants.httpOptions_app_json);
  }
  
  getActiveClient() {
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'active-clients', Constants.httpOptions_app_json);
  }
}
