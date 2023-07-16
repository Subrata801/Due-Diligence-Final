import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class SubscriptionService {

  serviceContext = "/subscription/";

  constructor(private httpClient: HttpClient) { }  

  getAllSubscriptionModels(productTypeId:any,subscriptionTypeId:any,subscriptionSubTypeId:any): Observable<any>{
    let request = {
      "productTypeId" : productTypeId,
      "subscriptionSubTypeId": subscriptionSubTypeId,
      "subscriptionTypeId": subscriptionTypeId
    }
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'subscription-model',request, Constants.httpOptions_app_json);
  }

  getSubscriptionModels(): Observable<any>{
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'subscription-model', Constants.httpOptions_app_json);
  }
  
  createSubscription(reqData:any,subscriptionId:any): Observable<any>{
    console.log("reqData",reqData);
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'create-subscription/'+subscriptionId,reqData, Constants.httpOptions_app_json);
  } 

  loadSubscription(clientId:any): Observable<any>{
    console.log("clientId",clientId);
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'load-clientsubscription?clientId='+clientId, Constants.httpOptions_app_json);
  }
  
  loadSubscriptionList(productTypeId:any,subscriptionTypeId:any,subscriptionSubTypeId:any): Observable<any>{
    let request = {
      "productTypeId" : productTypeId,
      "subscriptionTypeId" : subscriptionTypeId,
      "subscriptionSubTypeId" : subscriptionSubTypeId
    }
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'subscriptions',request, Constants.httpOptions_app_json);
  }
  
   loadSubscriptionDetail(subscriptionId:any): Observable<any>{
    let request = {
      "subscriptionId" : subscriptionId
    }
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'subscriptions',request, Constants.httpOptions_app_json);
  }
 
}
