import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { ErrorHandler } from '../../error/error.handler';
import { FileUploadService } from '../../services/file-upload/file-upload.service';
import { ReferenceService } from '../../services/reference-service/reference.service';
import { LanguageTemplateService } from '../../services/template/template.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-import-template',
  templateUrl: './import-template.component.html',
  styleUrls: ['./import-template.component.scss']
})
export class ImportTemplateComponent implements OnInit {

  importTemplateForm: FormGroup;
  pageErrors: any = {};
  templateOptions: any = [];
  showImportTemplate: boolean = false;
  showImportExistingTemplate: boolean = false;
  showView: boolean = false;
  showExistingView: boolean = false;
  isUploadFailed: boolean = false;
  isTemplatewithRisk: boolean = false;
  isTemplatewithOutRiskDisable: boolean = false;

  //file upload
  selectedFiles?: FileList;
  currentFile?: File;
  progress = 0;
  message = '';
  resultData: any = [];

  fileInfos?: Observable<any>;


  constructor(private formBuilder: FormBuilder,
    private errorHandler: ErrorHandler,
    private referenceService: ReferenceService,
    private languageTemplateService: LanguageTemplateService,
    private fileUploadService: FileUploadService,
    private _router: Router) {
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
      status: [''],
      ddId :[''],
      importedDate :['']
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

  populateImportResultData(result) {
    let importedArrData: any = [];
    (this.importTemplateForm.get('importUploadedData') as FormArray).clear();
    //this.importTemplateForm.patchValue({
    //  importUploadedData: importedArrData
    //});
    console.log("populateImportResultDataresult", result);
    this.resultData = result;
    if (result && result.data) {
      result.data.forEach(eachData => {
        importedArrData.push({
          numOfLoanSchemes: eachData.numOfLoanSchemes,
          workSheetName: eachData.workSheetName,
          numOfDDaps: eachData.numOfDDaps,
          successCount: eachData.successCount,
          failureCount: eachData.failureCount,
          ddId :eachData.ddId,
          status: eachData.status,
          importedDate :eachData.importedDate
        });
      });
      console.log("importedArrData", importedArrData);
      importedArrData.forEach((eachArray, index) => {
        this.addUnit();
      });
    }
    this.importTemplateForm.patchValue({
      importUploadedData: importedArrData
    });
    this.showView = true;
    this.isUploadFailed=false;
    this.showImportTemplate = false;
    this.showImportExistingTemplate = false;
    this.showExistingView = false;
  }

  downloadSuccess(e) : void {
    var y = this.resultData.data[e];
    
    let fileName="SuccessTemplate-DDID_"+y.ddId+".xlsx";
    
    if (parseInt(this.resultData.data[e].successCount) > 0) {
		  this.fileUploadService.downloadFile(y.ddId, 'success').subscribe(response => {
		  var blob = new Blob([response], { type: 'application/vnd.ms-excel' });
		  if (window.navigator && window.navigator.msSaveOrOpenBlob) {
			window.navigator.msSaveOrOpenBlob(blob, fileName);
		  } else {
			var a = document.createElement('a');
			a.href = URL.createObjectURL(blob);
			a.download = fileName;
			document.body.appendChild(a);
			a.click();
			document.body.removeChild(a);
		  }
		},
		err => {
		  alert("Error while downloading. File Not Found on the Server");
		})
    } else {
      alert("There are no success records to download");
    }
  }
    
  downloadFailure(e) : void {
    var y = this.resultData.data[e];
    let fileName="FailureTemplate-DDID_"+y.ddId+".xlsx";
    if (parseInt(this.resultData.data[e].failureCount) > 0) {
      this.fileUploadService.downloadFile(y.ddId, 'failure').subscribe(response => {
		  var blob = new Blob([response], { type: 'application/vnd.ms-excel' });
	 
		  if (window.navigator && window.navigator.msSaveOrOpenBlob) {
			window.navigator.msSaveOrOpenBlob(blob, fileName);
		  } else {
			var a = document.createElement('a');
			a.href = URL.createObjectURL(blob);
			a.download = fileName;
			document.body.appendChild(a);
			a.click();
			document.body.removeChild(a);
		  }
		},
		err => {
		  alert("Error while downloading. File Not Found on the Server");
		})
    } else {
      alert("There are no failing records to download");
    }
  }
  
  upload(): void {
    this.progress = 0;
    (this.importTemplateForm.get('importUploadedData') as FormArray).clear();
    if (this.selectedFiles) {
      const file: File | null = this.selectedFiles.item(0);

      if (file) {
        this.currentFile = file;
        this.showView = false;
        this.isUploadFailed = false;
		console.log('templateName : ',this.importTemplateForm.get("importTemplateName").value);
  		console.log('clientTypeId : ',this.importTemplateForm.get('clientTypeId').value);
  		console.log('creditScoreTypeId : ',this.importTemplateForm.get('creditScoreTypeId').value);
        this.fileUploadService.uploadFile(this.currentFile,this.importTemplateForm.get("importTemplateName").value,
        this.importTemplateForm.get('clientTypeId').value,
        this.importTemplateForm.get('creditScoreTypeId').value).subscribe(
          (event: any) => {
            if (event.type === HttpEventType.UploadProgress) {
              this.progress = Math.round(100 * event.loaded / event.total);
            } else if (event instanceof HttpResponse) {
              this.message = event.body.message;
              //this.fileInfos = this.uploadService.getFiles();
              if (event.body.metaData && event.body.metaData.success) {
                console.log("event.body.metaData", event.body.metaData);
                this.populateImportResultData(event.body);
                this.showImportTemplate = true;
                this.showView = true;
              }
            }
          },
          (err: any) => {
            
            this.progress = 0;
			console.log('Error Found ......',err.error.errorMessage);
			this.message = err.error.errorMessage;
			this.isUploadFailed=true;
            //if (err.error.message!='') {
            //  console.log('Error Found ......',err.error.errorMessage);
            //  this.message = err.error.message;
            //} else {
            //  console.log('No Error Found ......');
            //  this.message = 'Could not upload the file!';
            //}

            this.currentFile = undefined;
          });
      }

      this.selectedFiles = undefined;
    }
  }

  registerValues() {
    this.importTemplateForm.get('clientTypeId').valueChanges.subscribe(value => {
      if (value && value != undefined) {
        this.templateOptions = [];
        let clientTypeId = value;
        let creditScoreTypeId = this.importTemplateForm.get('creditScoreTypeId').value;
        let riskTypeId = this.importTemplateForm.get('riskTypeId').value;
        if(value == 3) {
           riskTypeId = "2";
           this.isTemplatewithRisk = true;
           this.isTemplatewithOutRiskDisable = true ;
        } else {
           this.isTemplatewithRisk = false;
           this.isTemplatewithOutRiskDisable = false ;
        }
        if (clientTypeId && creditScoreTypeId && riskTypeId) {
          this.languageTemplateService.getLanguageTemplates(clientTypeId,creditScoreTypeId,riskTypeId).subscribe(result => {
            console.log("result", result)
            if (result && result.data) {
              this.templateOptions = result.data;
            }
          });
        }
      }
    });
    this.importTemplateForm.get('creditScoreTypeId').valueChanges.subscribe(value => {
      if (value && value != undefined) {
        this.templateOptions = [];
        let clientTypeId = this.importTemplateForm.get('clientTypeId').value;
        let creditScoreTypeId = value;
        let riskTypeId = this.importTemplateForm.get('riskTypeId').value;
        if (clientTypeId && creditScoreTypeId && riskTypeId) {
          this.languageTemplateService.getLanguageTemplates(clientTypeId,creditScoreTypeId,riskTypeId).subscribe(result => {
            console.log("result", result)
            if (result && result.data) {
              this.templateOptions = result.data;
            }
          });
        }
      }
    });

    this.importTemplateForm.get('riskTypeId').valueChanges.subscribe(value => {
      if (value && value != undefined) {
        this.templateOptions = [];
        let clientTypeId = this.importTemplateForm.get('clientTypeId').value;
        let creditScoreTypeId = this.importTemplateForm.get('creditScoreTypeId').value;
        let riskTypeId = value;
        if (clientTypeId && creditScoreTypeId && riskTypeId) {
          this.languageTemplateService.getLanguageTemplates(clientTypeId,creditScoreTypeId,riskTypeId).subscribe(result => {
            console.log("result", result)
            if (result && result.data) {
              this.templateOptions = result.data;
            }
          });
        }
      }
    });

  }
  viewTemplate() {
    this.showImportTemplate = true;
    this.showImportExistingTemplate = false;
  }
  viewExistingTemplate() {
    let importedArrData: any = [];
    this.importTemplateForm.patchValue({
      importUploadedData: importedArrData
    });
    this.showExistingView = false;
    this.showImportExistingTemplate = false;
    this.progress = 0;
    this.currentFile = undefined;
    let clientTypeId = this.importTemplateForm.get('clientTypeId').value;
    let creditScoreTypeId = this.importTemplateForm.get('creditScoreTypeId').value;
    let riskTypeId = this.importTemplateForm.get('riskTypeId').value;
    if(clientTypeId == 3)
       riskTypeId = "2";
    else
       riskTypeId = this.importTemplateForm.get('riskTypeId').value;
    if(clientTypeId!=undefined && creditScoreTypeId!= undefined && riskTypeId != undefined) {
	    this.fileUploadService.getListOfImportedTemplates(this.importTemplateForm.get('clientTypeId').value,
	         this.importTemplateForm.get('creditScoreTypeId').value,
	         riskTypeId).subscribe(result => {
	      console.log("result", result);
	
	
	      if (result && result.data) {
	       this.populateImportResultData(result);
	       this.showImportExistingTemplate = true;
	       this.showExistingView = true;
	       this.showView = false;
	       this.showImportTemplate = false;
	      }
	
	    },
		  (err: any) => {
			console.log('Error Found ......',err.error.errorMessage);
			this.message = err.error.errorMessage;
			this.showImportTemplate = false;
			this.showView = false;
		    this.showImportExistingTemplate = false;
	        this.showExistingView = false;
		  });
	  }
  }
}
