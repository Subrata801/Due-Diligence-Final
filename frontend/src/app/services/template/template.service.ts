import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class LanguageTemplateService {
  serviceContext = "/template/";

  constructor(private httpClient: HttpClient) { }

  getLanguageTemplates(clientTypeId: string,creditScoreTypeId:string,riskTypeId:string): Observable<any> {
    console.log("requestData", clientTypeId,creditScoreTypeId,riskTypeId);
    let requestData = {
      clientTypeId: clientTypeId,
      creditSectorId: creditScoreTypeId,
      riskTypeId: riskTypeId
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'language-template', requestData, Constants.httpOptions_app_json);
  }

  getAvailableLoanSchemes(clientTypeId:string,creditScoreTypeId:string,riskTypeId:string,languageId:string,templateId:string): Observable<any> {
    console.log("loanSchemeRequest", templateId);
    let requestData = {            
      clientTypeId: clientTypeId,
      creditScoreTypeId: creditScoreTypeId,
      riskTypeId: riskTypeId,
      languageId: languageId,
      templateId: templateId,
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'available-loanschemes', requestData, Constants.httpOptions_app_json);
  }

  getAvailableAllLoanSchemes(): Observable<any> {
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'available-loanschemes', {}, Constants.httpOptions_app_json);
  }

  getAvailableLoanSchemesDefault(): Observable<any> {
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'available-loanschemes', {}, Constants.httpOptions_app_json);
  }

  getAvailableLoanVariants(loanSchemeId:string): Observable<any> {
    console.log("loanSchemeId", loanSchemeId);
    let requestData = {      
      loanSchemeId: loanSchemeId
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'available-loanvariants', requestData, Constants.httpOptions_app_json);
  }

  createLoanScheme(requestData:any){
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'create-loanschemes', requestData, Constants.httpOptions_app_json);
  }

  createLoanVariants(requestData:any){
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'create-loanvariants', requestData, Constants.httpOptions_app_json);
  }
}
