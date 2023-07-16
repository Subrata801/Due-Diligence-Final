import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class ReferenceService {
  serviceContext = "/references/";

  constructor(private httpClient: HttpClient) { }

  getReferenceLanguages(): Observable<any> {
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'reference-languages', Constants.httpOptions_app_json);
  }

  getReferenceClientTypes(): Observable<any> {
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'reference-clienttype', Constants.httpOptions_app_json);
  }

  getReferenceClientGroup(clientType: string): Observable<any> {
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'reference-clientgroup?clientId=' + clientType, Constants.httpOptions_app_json);
  }

  getReferenceuserRoles(clientType: number): Observable<any> {
    return this.httpClient.get(environment.apiHost + this.serviceContext + "reference-roles?clientTypeId=" + clientType, Constants.httpOptions_app_json);
  }

  getReferenceAuditfirms(): Observable<any> {
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'reference-auditfirms', Constants.httpOptions_app_json);
  }

  getReferenceSubscriptionSubType(subscriptionTypeId: string): Observable<any> {
    //http://localhost:8081/references/reference-subscriptionSubType?subscriptionTypeId=1   
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'reference-subscriptionSubType?subscriptionTypeId=' + subscriptionTypeId, Constants.httpOptions_app_json);
  }
  getReferenceAllSubscriptionType(productTypeId: any): Observable<any> {
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'reference-subscriptionType?productTypeId=' + productTypeId, Constants.httpOptions_app_json);
  }
  
  getReferenceSecurityQuestions(): Observable<any> {
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'reference-securityquestions', Constants.httpOptions_app_json);
  }
  
  getReferenceHO(clientId:any): Observable<any> {
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'reference-ho?clientId=' + clientId, Constants.httpOptions_app_json);
  }
  
  getReferenceZO(clientId:any,hoId:any): Observable<any> {
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'reference-zo?clientId=' + clientId +'&hoId='+hoId, Constants.httpOptions_app_json);
  }
  
  getReferenceCPC(clientId:any,zoId:any): Observable<any> {
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'reference-cpc?clientId=' + clientId +'&zoId='+zoId, Constants.httpOptions_app_json);
  }
  
  getReferenceUnitType(): Observable<any> {
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'reference-unitType', Constants.httpOptions_app_json);
  }


}
