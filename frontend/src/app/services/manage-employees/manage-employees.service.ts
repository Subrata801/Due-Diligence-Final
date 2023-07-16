import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class ManageEmployeeService {
  serviceContext = "/clientManagementManageEmployee/";

  constructor(private httpClient: HttpClient) { }

  manageEmployee(requestData:any){
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'manage-employee', requestData, Constants.httpOptions_app_json);
  }
  
  manageEmployees(requestData:any): Observable<any>{
    console.log("manageEmployees :", requestData);
    
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'client-mgmt-view-employees', requestData, Constants.httpOptions_app_json);
  }
  updateEmployee(requestData:any): Observable<any>{
    console.log("updateEmployee :", requestData);
    
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'client-mgmt-update-employee', requestData, Constants.httpOptions_app_json);
  }
  downloadErrorData(clientId:number): Observable<any>{
    console.log("downloadErrorData for clientId:", clientId);
    
   return this.httpClient.get(environment.apiHost + this.serviceContext + 
       'client-mgmt-download-error?clientId='+clientId,{responseType:'blob'});
  }
  
  uploadEmployeeFile(file: File ): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('file', file);

    const req = new HttpRequest('POST', environment.apiHost + this.serviceContext + 'employee-upload', formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.httpClient.request(req);
  }
}
