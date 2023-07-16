import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  serviceContext = "/employees/";

  constructor(private httpClient: HttpClient) { }

  uploadFile(file: File): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('file', file);

    const req = new HttpRequest('POST', environment.apiHost + this.serviceContext + 'employees-upload/', formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.httpClient.request(req);
  }

   getListOfEmployees(branchId:string, branchCode:number): Observable<any>{
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'view-imported-employees'+'/'+branchId+
        '/'+branchCode, Constants.httpOptions_app_json);
  }
}
