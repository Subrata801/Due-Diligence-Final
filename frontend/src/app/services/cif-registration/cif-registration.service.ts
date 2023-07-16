import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class CifRegistrationService {
  serviceContext = "/cifRegistraion/";

  constructor(private httpClient: HttpClient) { }

  registerCif(requestData:any){
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'cif-register', requestData, Constants.httpOptions_app_json);
  }
 }
