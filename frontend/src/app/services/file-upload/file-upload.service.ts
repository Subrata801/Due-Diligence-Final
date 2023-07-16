import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class FileUploadService {
  serviceContext = "/fileUpload/";

  constructor(private httpClient: HttpClient) { }

  uploadFile(file: File, templateId:string, clientTypeId:number, creditScoreTypeId:number): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('file', file);

    const req = new HttpRequest('POST', environment.apiHost + this.serviceContext + 'template-upload/'+templateId+'/'+clientTypeId+'/'+creditScoreTypeId, formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.httpClient.request(req);
  }
  
  downloadFile(ddId:number,outputType:string): Observable<any> {
    console.log("outputType :: ",outputType);
    console.log("ddId :: ",ddId);
    
    return this.httpClient.get(environment.apiHost + this.serviceContext + 
       'template-download?ddId='+ddId+'&outputType='+outputType,{responseType:'blob'});
  }

   getListOfImportedTemplates(clientTypeId:number,creditScoreTypeId:number,riskTypeId:number): Observable<any>{
    return this.httpClient.get(environment.apiHost + this.serviceContext + 'view-imported-template'+'/'+clientTypeId+
        '/'+creditScoreTypeId+'/'+riskTypeId, Constants.httpOptions_app_json);
  }
}
