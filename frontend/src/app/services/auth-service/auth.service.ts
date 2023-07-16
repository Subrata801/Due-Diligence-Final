import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Constants } from '../common/constants';


@Injectable({
  providedIn: 'root'
})

export class AuthService {
  serviceContext = "/auth/";
  serviceContextUser = "/user/";

  constructor(private httpClient: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'signin', {
      username: username,
      userPassword: password
    }, Constants.httpOptions_app_json);
  }

  firstTimeLogin(username: string, securityQuestionId: string,securityQuestionAnswer: string, newPassword: string, confirmPassword: string): Observable<any> {
    return this.httpClient.post(environment.apiHost + this.serviceContextUser + 'update-password', {
      username: username,
      newPassword: newPassword,
      securityQuestionId : securityQuestionId,
      securityQuestionAnswer: securityQuestionAnswer,
      confirmPassword: confirmPassword
    }, Constants.httpOptions_app_json);
  }

  resetPassword(username: string, securityQuestionId: string,securityQuestionAnswer: string, newPassword: string, confirmPassword: string): Observable<any> {
    return this.httpClient.post(environment.apiHost + this.serviceContext + 'reset-password', {
      username: username,
      newPassword: newPassword,
      securityQuestionId : securityQuestionId,
      securityQuestionAnswer: securityQuestionAnswer,
      confirmPassword: confirmPassword
    }, Constants.httpOptions_app_json);
  }
  
  updateUser(username: string, userMobile: number , userEmail :string,fullName: string): Observable<any> {
    return this.httpClient.post(environment.apiHost + this.serviceContextUser + 'update-user', {
      userName: username,
      mobileNumber: userMobile,
      email: userEmail,
      fullName : fullName      
    }, Constants.httpOptions_app_json);
   } 
   
  getUserInfo(): Observable<any> {
    return this.httpClient.get(environment.apiHost + this.serviceContextUser + 'user-details', Constants.httpOptions_app_json);
  }

  signUp(userData: any,userId:any){
    console.log("userData", userData);
    return this.httpClient.post(environment.apiHost + this.serviceContextUser + 'signup/'+userId, 
      userData, Constants.httpOptions_app_json);
  }
  searchUser(reqData:any): Observable<any>{
    return this.httpClient.post(environment.apiHost + this.serviceContextUser + 'users', reqData, Constants.httpOptions_app_json);
  }
  
  getUser(searchCriteria:any,userId:any): Observable<any>{
    let reqData = {
      "keywordType" : searchCriteria,
      "userId" : userId,
    }
    return this.httpClient.post(environment.apiHost + this.serviceContextUser + 'users', reqData, Constants.httpOptions_app_json);
  }
}
