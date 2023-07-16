import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class UnitsService {
  serviceContext = "/units/";

  constructor(private httpClient: HttpClient) { }

  getUnitTypes(): Observable<any> {
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'unit-types', Constants.httpOptions_app_json);
  }

  getUnitHO(): Observable<any> {
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'unit-ho', Constants.httpOptions_app_json);
  }
  
  getUnitZones(): Observable<any> {
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'unit-zones', Constants.httpOptions_app_json);
  }
  
  getUnitCPC(): Observable<any> {
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'unit-cpc', Constants.httpOptions_app_json);
  }
  
  getUnitName(): Observable<any> {
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'unit-name', Constants.httpOptions_app_json);
  }
  
  getUnitCode(): Observable<any> {
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'unit-code', Constants.httpOptions_app_json);
  }
  
  getUnitAddress(): Observable<any> {
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'unit-address', Constants.httpOptions_app_json);
  }
  
  getUnitCity(): Observable<any> {
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'unit-city', Constants.httpOptions_app_json);
  }
  
  getUnitPincode(): Observable<any> {
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'unit-pincode', Constants.httpOptions_app_json);
  }
  
  getUnitState(): Observable<any> {
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'unit-state', Constants.httpOptions_app_json);
  }
  
  getUnitStatus(): Observable<any> {
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'unit-status', Constants.httpOptions_app_json);
  }

}
