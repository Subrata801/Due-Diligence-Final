import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class ClientConfigurationService {
  serviceContext = "/clientConfiguration/";

  constructor(private httpClient: HttpClient) { }

  getClient(clientType :string): Observable<any> {    
    let reqBody = {  
      "clientTypeId": clientType
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext+ 'clients',reqBody, Constants.httpOptions_app_json);
  }
  getClients(clientType :string): Observable<any> {    
    let reqBody = {  
      "clientTypeId": clientType
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext+ 'registration-clients',reqBody, Constants.httpOptions_app_json);
  }

  getClientInfo(clientId :string): Observable<any> {    
    let reqBody = {  
      "clientId": clientId
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext+ 'client-info',reqBody, Constants.httpOptions_app_json);
  }

  getBankInfo(clientId :string): Observable<any> {    
    let reqBody = {  
      "clientId": clientId
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext+ 'get-bank-details',reqBody, Constants.httpOptions_app_json);
  }

  getLoanSchemeInfo(clientId :string,clientTypeId:any): Observable<any> {    
    let reqBody = {  
      "clientId": clientId,
      "clientTypeId":clientTypeId
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext+ 'client-loanschemes',reqBody, Constants.httpOptions_app_json);
  }

  deleteLoanSchemeInfo(reqData:any): Observable<any> {   
    return this.httpClient.post(environment.apiHost + this.serviceContext+ 'delete-clientloanscheme',reqData, Constants.httpOptions_app_json);
  }

  deleteLoanSchemeVariantInfo(reqData:any): Observable<any> {   
    return this.httpClient.post(environment.apiHost + this.serviceContext+ 'delete-clientloanvariant',reqData, Constants.httpOptions_app_json);
  }

  getLoanSchemeVariantInfo(clientId :string,clientTypeId:any): Observable<any> {    
    let reqBody = {  
      "clientId": clientId,
      "clientTypeId":clientTypeId
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext+ 'client-loanvariants',reqBody, Constants.httpOptions_app_json);
  }

  createClientSubscription(reqData:any): Observable<any>{
    console.log("reqData",reqData);
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'create-clientsubscription',reqData, Constants.httpOptions_app_json);
  }

  createNewTemplate(startDate:any,cloneMethod:string,ddId:any): Observable<any>{
    let reqBody = {  
      "startDate": startDate,
      "cloneMethod":cloneMethod,
      "ddId":ddId
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'client-customize-template-newversion',reqBody, Constants.httpOptions_app_json);
  }
  
  
  loadClientSubscriptionDetails(clientId:any): Observable<any>{
    console.log("clientId",clientId);
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'load-clientsubscription?clientId='+clientId, Constants.httpOptions_app_json);
  }
  
  loadV1TemplateDetails(clientId:any,clientTypeId:any): Observable<any>{
    console.log("clientId",clientId);
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'client-customize-template?clientId='+clientId+'&clientTypeId='+clientTypeId, Constants.httpOptions_app_json);
  }
  
  updateRenewSwitchSubscriptionDetails(reqData:any): Observable<any>{
    //console.log("reqData",reqData);
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'update-clientsubscription/renewDetails',reqData, Constants.httpOptions_app_json);
  }
  
  updateBasicSubscriptionDetails(reqData:any): Observable<any>{
    //console.log("reqData",reqData);
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'update-clientsubscription/basicDetails',reqData, Constants.httpOptions_app_json);
  }
  updateSubscriptionDetails(reqData:any): Observable<any>{
    console.log("reqData",reqData);
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'update-clientsubscription/completeDetails',reqData, Constants.httpOptions_app_json);
  }
  
   loadClientSubscriptionHistoryDetails(clientId:any): Observable<any>{
    console.log("clientId",clientId);
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'clientsubscription-history?clientId='+clientId, Constants.httpOptions_app_json);
  }
  
   deleteBankInfo(reqData:any): Observable<any> {   
    return this.httpClient.post(environment.apiHost + this.serviceContext+ 'delete-clientbank',reqData, Constants.httpOptions_app_json);
  }
  
  
}
