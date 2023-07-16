import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class InitiateDueDiligenceService {
  
  serviceContext = "/initiateDueDeligence/";

  constructor(private httpClient: HttpClient) { }

  processDueDiligenceInitiation(requestData:any){
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'initiate-due-deligence-process', requestData, Constants.httpOptions_app_json);
  }
  
  processDueDiligenceForAudit(requestData:any){
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'initiate-due-deligence-audit-process', requestData, Constants.httpOptions_app_json);
  }
  
  initiateNewDueDiligence(requestData:any){
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'initiate-new-due-deligence-process', requestData, Constants.httpOptions_app_json);
  }
  
  getListOfDueDiligence(requestData:any): Observable<any>{
    console.log("getListOfDueDiligence :", requestData);
    
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'due-deligence', requestData, Constants.httpOptions_app_json);
  }
  
  getAutoGeneratedResponse(loanAppId:any): Observable<any>{
    console.log("getAutoGeneratedResponse :", loanAppId);
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'auto-generated-details?loanAppId='+loanAppId, Constants.httpOptions_app_json);
  }
  
  saveAdminitrativeDetails(requestData:any){
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'administrative-details', requestData, Constants.httpOptions_app_json);
  }
  
  getUnitChecker(clientGroupId:any): Observable<any>{
    console.log("getUnitChecker :", clientGroupId);
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'unit-checker?clientGroupId='+clientGroupId, Constants.httpOptions_app_json);
  }
  
   getDefaultUnitChecker(e2eNum:any): Observable<any>{
    console.log("getDefaultUnitChecker :", e2eNum);
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'default-unit-maker-checker?e2eNum='+e2eNum, Constants.httpOptions_app_json);
  }
  
  saveGeneralInfoDetails(requestData:any){
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'due-diligence-general-info', requestData, Constants.httpOptions_app_json);
  }
  
  saveCoApplicantDetails(requestData:any){
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'due-diligence-co-applicant', requestData, Constants.httpOptions_app_json);
  }
  
  getCoApplicantDetails(e2eNum:any): Observable<any>{
     return this.httpClient.get(environment.apiHost + this.serviceContext + 'due-diligence-co-applicant?e2eNum='+e2eNum, Constants.httpOptions_app_json);
  }
  getGurantorDetails(e2eNum:any): Observable<any>{
     return this.httpClient.get(environment.apiHost + this.serviceContext + 'due-diligence-coapp-gurantor?e2eNum='+e2eNum, Constants.httpOptions_app_json);
  }
  getCollateralSecurity(e2eNum:any): Observable<any>{
     return this.httpClient.get(environment.apiHost + this.serviceContext + 'due-diligence-coapp-collateral-security?e2eNum='+e2eNum, Constants.httpOptions_app_json);
  }
  
  getGeneralInfoDetails(e2eNum:any): Observable<any>{
    console.log("getGeneralInfoDetails :", e2eNum);
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'retieve-due-diligence-general-info?e2eNum='+e2eNum, Constants.httpOptions_app_json);
  }
  
  
  getListOfBranchNames(clientId:any): Observable<any>{
    console.log("getListOfBranchNames :", clientId);
    let requestData = {
      clientId : clientId
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'branch-names', requestData, Constants.httpOptions_app_json);
  }
  
  getListOfAuditFirmMaker(requestData:any): Observable<any>{
    console.log("getListOfAuditFirmMaker :", requestData);
    
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'audit-firm-makers', requestData, Constants.httpOptions_app_json);
  }
  getListOfAuditFirmChecker(clientId:any): Observable<any>{
    let requestData = {
      clientId : clientId
    };
    console.log("getListOfAuditFirmChecker :", requestData);
    
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'audit-firm-checkers', requestData, Constants.httpOptions_app_json);
  }
  
  getListOfLoanSchemes(typeOfDueDeligence:any,branchId:any,creditScoreTypeId:any,clientId:any): Observable<any>{
    
    let requestData = {
      typeOfDueDeligence : typeOfDueDeligence,
      branchId: branchId,
      creditScoreTypeId: creditScoreTypeId,
      clientId : clientId
    };
    console.log("getListOfLoanSchemes :", requestData);
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'loan-schemes', requestData, Constants.httpOptions_app_json);
  }
  
  getListOfLoanVariants(typeOfDueDeligence:any,loanScheme:any,clientId:any): Observable<any>{
    let requestData = {
      typeOfDueDeligence : typeOfDueDeligence,
      loanSchemeId: loanScheme,
      clientId : clientId
    };
    console.log("getListOfLoanVariants :", requestData);
    
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'loan-variants', requestData, Constants.httpOptions_app_json);
  }
  getListOfAccountTypes(): Observable<any>{
    console.log("getListOfAccountTypes ");
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'account-types', Constants.httpOptions_app_json);
  }
  
  getListOfBorrowerCategory(): Observable<any>{
    console.log("getListOfBorrowerCategory ");
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'borrower-category', Constants.httpOptions_app_json);
  }
  
  getListOfBorrowerTypes(): Observable<any>{
    console.log("getListOfBorrowerTypes ");
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'borrower-types', Constants.httpOptions_app_json);
  }
  
  getListOfLoanSchemeFacilities(loanScheme:any): Observable<any>{
    let requestData = {
      loanSchemeId: loanScheme,
    };
    console.log("getListOfLoanSchemeFacilities :", requestData);
    
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'loan-scheme-facilities', requestData, Constants.httpOptions_app_json);
  }
  
  getListOfCoApplicantDesignation(): Observable<any>{
    console.log("getListOfCoApplicantDesignation");
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'co-applicant-designation', Constants.httpOptions_app_json);
  }
  
  deleteCommercialFacility(reqData:any): Observable<any> {   
    return this.httpClient.post(environment.apiHost + this.serviceContext+ 'delete-commercialFacility',reqData, Constants.httpOptions_app_json);
  }
  
  getListOfCommercialCreditFacilities(e2eNumber:any): Observable<any>{
    let requestData = {
       e2eNumber : e2eNumber
    };
    console.log("getListOfCommercialCreditFacilities :", requestData);
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'commercial-credit-facilities', requestData, Constants.httpOptions_app_json);
  }
  
  getListOfCifDetails(clientId:any): Observable<any>{
    console.log("getListOfCifDetails :", clientId);
    return this.httpClient.get(environment.apiHost + this.serviceContext + "cif-details?clientId=" + clientId, Constants.httpOptions_app_json);
  }
  
  getListOfBranchMakers(clientGroupId:any): Observable<any>{
    console.log("getListOfBranchMakers :", clientGroupId);
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'branch-maker?clientGroupId='+clientGroupId, Constants.httpOptions_app_json);
  }
  
  getListOfBranchCheckers(requestData:any): Observable<any>{
    console.log("getListOfBranchCheckers :", requestData);
    
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'branch-checker', requestData, Constants.httpOptions_app_json);
  }

  getListOfBranchSA(requestData:any): Observable<any>{
    console.log("getListOfBranchSA :", requestData);
    
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'branch-sa', requestData, Constants.httpOptions_app_json);
  }
  
   getListOfLoanSA(requestData:any): Observable<any>{
    console.log("getListOfLoanSA :", requestData);
    
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'loan-sa', requestData, Constants.httpOptions_app_json);
  }
  
  getListOfMovableProperties(): Observable<any>{
    console.log("getListOfMovableProperties :");
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'movable-properties', Constants.httpOptions_app_json);    
  }
  
  getListOfDueDiligenceHeader(loanAppId:String,moduleName:String): Observable<any>{
    console.log("getListOfDueDiligenceHeader", loanAppId,moduleName);
    let requestData = {            
      loanAppId: loanAppId,
      moduleName: moduleName
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'view-due-diligence-header', requestData, Constants.httpOptions_app_json);
  }
  
  getListOfDueDeligenceAsPerHeader(headerKey:any): Observable<any>{
    let requestData = {            
      headerKey: headerKey
    };
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'view-due-diligence-details', requestData, Constants.httpOptions_app_json);
  }
  
  getListOfMovablePropertiesByE2ENo(e2eNum:any): Observable<any>{
     return this.httpClient.get(environment.apiHost + this.serviceContext + 'due-diligence-coapp-moveable-prop?e2eNum='+e2eNum, Constants.httpOptions_app_json);   
  }

  getReportingHeader(e2eNum:any): Observable<any>{ 
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'report-headers?e2eNum='+e2eNum, Constants.httpOptions_app_json);
  }

  getReportingActions(userName:any): Observable<any>{ 
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'report-actions?userName='+userName, Constants.httpOptions_app_json);
  }

  getReportTableData(e2eNum:any): Observable<any>{ 
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'report-table-data?e2eNum='+e2eNum, Constants.httpOptions_app_json);
  }
 
  getRiskTypeId(): Observable<any>{ 
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'risk-type', Constants.httpOptions_app_json);
  }

  getUpdateStatus(e2eNum:any,actionId:any): Observable<any>{ 
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'update-report-status?e2eNum='+e2eNum+'&actionId='+actionId, Constants.httpOptions_app_json);
  }

  generateReport(e2eNum:any,rowName:any, columnName:any): Observable<any>{ 
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'generate-report?e2eNum='+e2eNum+'&rowName='+rowName+'&columnName='+columnName, Constants.httpOptions_app_json);
  }

  getDownloadFile(fileName: string): Observable<any>{
    console.log("download report for fileName:", fileName);
    
   return this.httpClient.get(environment.apiHost + this.serviceContext + 
       'download-report?fileName='+fileName,{responseType:'blob'});
  }

  saveViewDDService(requestData:any): Observable<any>{
    console.log("saveViewDDService:data:", requestData);
    
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'save-viewDD', requestData, Constants.httpOptions_app_json);
  }

  saveViewDDM2M5Service(requestData:any): Observable<any>{
    console.log("saveViewDDM2M5Service:data:", requestData);
    
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'save-viewDD_M2_M5', requestData, Constants.httpOptions_app_json);
  }
}