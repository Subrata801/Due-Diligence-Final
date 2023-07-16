import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { ErrorHandler } from '../../error/error.handler';
import { FileUploadService } from '../../services/file-upload/file-upload.service';
import { ReferenceService } from '../../services/reference-service/reference.service';
import { LanguageTemplateService } from '../../services/template/template.service';

@Component({
  selector: 'app-view-templates',
  templateUrl: './view-templates.component.html',
  styleUrls: ['./view-templates.component.scss']
})
export class ViewTemplatesComponent implements OnInit {

  importTemplateForm: FormGroup;
  pageErrors: any = {};
  templateOptions: any = [];

  //file upload
  selectedFiles?: FileList;
  currentFile?: File;
  progress = 0;
  message = '';

  fileInfos?: Observable<any>;


  constructor(private formBuilder: FormBuilder,
    private errorHandler: ErrorHandler,
    private referenceService: ReferenceService,
    private languageTemplateService: LanguageTemplateService,
    private fileUploadService: FileUploadService) {
  }

  ngOnInit(): void {
    
    this.importTemplateForm = this.formBuilder.group({
      clientTypeId: [''],
      creditScoreId: [''],
      creditScoreTypeId: [''],
      importTemplateName: [''],
      incrementImportTemplateName: [''],
      languageId: [''],
      riskTypeId: [''],
      importUploadedData: this.formBuilder.array([
        this.getImportUploadData()
      ])
    });
    this.errorHandler.handleErrors(this.importTemplateForm, this.pageErrors);
    this.registerValues();
  }

  private getImportUploadData() {
    return this.formBuilder.group({
      numOfLoanSchemes: [''],
      workSheetName: [''],
      numOfDDaps: [''],
      successCount: [''],
      failureCount: [''],
      status: ['']
    });
  }

  getImportUploadDataControls() {
    return (this.importTemplateForm.get('importUploadedData') as FormArray).controls;
  }

  addUnit() {
    const control = <FormArray>this.importTemplateForm.controls['importUploadedData'];
    control.push(this.getImportUploadData());
  }

  //file upload

  selectFile(event: any): void {
    this.selectedFiles = event.target.files;
  }


  populateImportResultData(result){    
    let importedArrData: any = [];
    this.importTemplateForm.patchValue({
      importUploadedData: importedArrData
    });
    console.log("result",result)
    if (result && result.data) {
      result.data.forEach(eachData => {
        importedArrData.push({
          numOfLoanSchemes: eachData.numOfLoanSchemes,
          workSheetName: eachData.workSheetName,
          numOfDDaps: eachData.numOfDDaps,
          successCount: eachData.successCount,
          failureCount: eachData.failureCount,
          status: eachData.status
        });


      });
      console.log("importedArrData",importedArrData);
      importedArrData.forEach((eachArray, index) => {
        //if (index < headerArrData.length - 1) {
        this.addUnit();
        //}
      });

    }
    this.importTemplateForm.patchValue({
      importUploadedData: importedArrData
    });
    
  }

  upload(): void {
    this.progress = 0;
    (this.importTemplateForm.get('importUploadedData') as FormArray).clear();
    if (this.selectedFiles) {
      const file: File | null = this.selectedFiles.item(0);
  
      if (file) {
        this.currentFile = file;
  
        this.fileUploadService.uploadFile(this.currentFile,this.importTemplateForm.get("importTemplateName").value,
        this.importTemplateForm.get('clientTypeId').value,this.importTemplateForm.get('creditScoreTypeId').value).subscribe(
          (event: any) => {
            if (event.type === HttpEventType.UploadProgress) {
              this.progress = Math.round(100 * event.loaded / event.total);
            } else if (event instanceof HttpResponse) {              
              this.message = event.body.message;
              //this.fileInfos = this.uploadService.getFiles();
              if(event.body.metaData && event.body.metaData.success){ 
                console.log("event.body.metaData",event.body.metaData);              
                this.populateImportResultData(event.body);
              }
            }
          },
          (err: any) => {
            console.log(err);
            this.progress = 0;
  
            if (err.error && err.error.message) {
              this.message = err.error.message;
            } else {
              this.message = 'Could not upload the file!';
            }
  
            this.currentFile = undefined;
          });
      }
  
      this.selectedFiles = undefined;
    }
  }

  registerValues(){
    this.importTemplateForm.get('clientTypeId').valueChanges.subscribe(value=>{
      if(value && value !=undefined){
        this.templateOptions = [];
        let clientTypeId = value;
        let creditScoreId = this.importTemplateForm.get('creditScoreId').value;
        let creditScoreTypeId = this.importTemplateForm.get('creditScoreTypeId').value;
        if(creditScoreId && creditScoreTypeId) {
          this.languageTemplateService.getLanguageTemplates(clientTypeId,creditScoreId,creditScoreTypeId).subscribe(result=>{
            console.log("result" , result)
            if(result && result.data){
              this.templateOptions = result.data;
            }
          });
        }
      }
    });
    this.importTemplateForm.get('creditScoreId').valueChanges.subscribe(value=>{
      if(value && value !=undefined){
        this.templateOptions = [];
        let clientTypeId = this.importTemplateForm.get('clientTypeId').value;
        let creditScoreId = value;
        let creditScoreTypeId = this.importTemplateForm.get('creditScoreTypeId').value;
        if(creditScoreId && creditScoreTypeId) {
          this.languageTemplateService.getLanguageTemplates(clientTypeId,creditScoreId,creditScoreTypeId).subscribe(result=>{
            console.log("result" , result)
            if(result && result.data){
              this.templateOptions = result.data;
            }
          });
        }
      }
    });

    this.importTemplateForm.get('creditScoreTypeId').valueChanges.subscribe(value=>{
      if(value && value !=undefined){
        this.templateOptions = [];
        let clientTypeId = this.importTemplateForm.get('clientTypeId').value;
        let creditScoreId = this.importTemplateForm.get('creditScoreTypeId').value;
        let creditScoreTypeId = value;
        if(creditScoreId && creditScoreTypeId) {
          this.languageTemplateService.getLanguageTemplates(clientTypeId,creditScoreId,creditScoreTypeId).subscribe(result=>{
            console.log("result" , result)
            if(result && result.data){
              this.templateOptions = result.data;
            }
          });
        }
      }
    });

  }


}
