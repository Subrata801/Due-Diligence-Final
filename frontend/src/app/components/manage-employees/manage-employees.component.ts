import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { EmployeeService } from '../../services/employees/employees.service';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';
import { AuthService } from '../../services/auth-service/auth.service';
import { forkJoin, Observable } from 'rxjs';
import { ManageEmployeeService } from '../../services/manage-employees/manage-employees.service';

@Component({
  selector: 'app-manage-employees',
  templateUrl: './manage-employees.component.html',
  styleUrls: ['./manage-employees.component.scss']
})
export class ManageEmployeesComponent implements OnInit {
  employeeListForm: FormGroup;
  manageEmployeesForm: FormGroup;
  uploadEmployeesForm: FormGroup;
  pageErrors: any = {};
  isError: boolean = false;
  isSuccess: boolean = false;
  errorMessage = '';
  showImportEmployees: boolean = false;
  showView: boolean = false;
  showExistingView: boolean = false;
  isUploadFailed: boolean = false;
  
  //file upload
  selectedFiles?: FileList;
  currentFile?: File;
  progress = 0;
  message = '';
  resultData: any = [];
  clientId: any;
  searchErrorMessage = '';
  isSearchResultFailed: boolean = false;
  searchResults: boolean = false;
  isDownloadAllowed: boolean = true;
  fileInfos?: Observable<any>;
  statusLabel: string = "Inactive";

  constructor(private formBuilder: FormBuilder,
    private errorHandler: ErrorHandler,
    private slideToggle: MatSlideToggleModule,private toastrService: ToastrService,
    private fileUploadService: EmployeeService,private authService: AuthService,
    private toastr: ToastrService,private manageEmployeeService: ManageEmployeeService) {
  }

  ngOnInit(): void {
    this.manageEmployeesForm = this.formBuilder.group({
      unitName: [''],
      ifscCode: ['']
    });

    this.employeeListForm = this.formBuilder.group({
      unitData: this.formBuilder.array([
        this.getEmployeeData()
      ])
    });
    this.fetchUserData();
    this.uploadEmployeesForm = this.formBuilder.group({
      
    });
  }

  fetchUserData() {
    var clntId = '';
    forkJoin([this.authService.getUserInfo()])
      .subscribe(results => {
        console.log('User Info :'+results[0].data);
        if (results[0] && results[0].data) {
            console.log('User Info :',results[0].data);
	        this.clientId = results[0].data.clientId;
        }
      });
  }
  
  selectFile(event: any): void {
    this.selectedFiles = event.target.files;
  }
  changed(){
    console.log(this.statusLabel);
  }

  viewExistingTemplate() {
    //this.progress = 0;
    //this.currentFile = undefined;
    //let unitName = this.manageEmployeesForm.get('unitName').value;
    //let ifscCode = this.manageEmployeesForm.get('ifscCode').value;
    //if(unitName!= undefined && ifscCode != undefined) {
	//    this.fileUploadService.getListOfEmployees(this.manageEmployeesForm.get('branchId').value,
	//         this.manageEmployeesForm.get('branchCode').value).subscribe(result => {
	//      console.log("result", result);
	
	
	//      if (result && result.data) {
	//       this.populateImportResultData(result);
	//       this.showExistingView = true;
	//       this.showView = false;
    //	       this.showImportEmployees = false;
    //	      }
	
	//    },
	//	  (err: any) => {
    //    console.log('Error Found ......',err.error.errorMessage);
    //    this.message = err.error.errorMessage;
    //    this.showView = false;
    //    this.showImportEmployees = false;
    //    this.showExistingView = false;
	//	  });
	//  }
  }
  
  populateImportResultData(result) {
    let importedArrData: any = [];
    this.manageEmployeesForm.patchValue({
      importUploadedData: importedArrData
    });
    console.log("result", result);
    this.resultData = result;
    if (result && result.data) {
      result.data.forEach(eachData => {

      });
      console.log("importedArrData", importedArrData);
      importedArrData.forEach((eachArray, index) => {
        //if (index < headerArrData.length - 1) {
        this.addUnit();
        //}
      });

    }
    this.manageEmployeesForm.patchValue({
      importUploadedData: importedArrData
    });
    this.showView = true;
    this.isUploadFailed=false;
    this.showImportEmployees = false;
    this.showExistingView = false;
  }

  getImportUploadDataControls() {
    return (this.uploadEmployeesForm.get('importUploadedData') as FormArray).controls;
  }

  addUnit() {
    const control = <FormArray>this.uploadEmployeesForm.controls['importUploadedData'];
    control.push(this.getImportUploadData());
  }

  private getImportUploadData() {
    return this.formBuilder.group({
      
    });
  }

  
  upload(): void {
    this.progress = 0;
    //(this.uploadEmployeesForm.get('importUploadedData') as FormArray).clear();
    if (this.selectedFiles) {
      const file: File | null = this.selectedFiles.item(0);

      if (file) {
        this.currentFile = file;
        this.isError = false;
        this.isSearchResultFailed = false;
        this.manageEmployeeService.uploadEmployeeFile(this.currentFile).subscribe(
          (event: any) => {
            if (event.type === HttpEventType.UploadProgress) {
              this.progress = Math.round(100 * event.loaded / event.total);
            } else if (event instanceof HttpResponse) {
              this.message = event.body.message;
              //this.fileInfos = this.uploadService.getFiles();
              if (event.body.metaData && event.body.metaData.success) {
                console.log("event.body.metaData", event.body.metaData);
                this.toastr.success('File uploaded successfully', 'Information', {timeOut: 3000,});
                //this.populateImportResultData(event.body);
                //this.showImportEmployees = true;
                //this.showView = true;
                this.isDownloadAllowed = false;
              }
            }
          },
          (err: any) => {
            
            this.progress = 0;
            console.log('Error Found ......',err.error.errorMessage);
            this.errorMessage = err.error.errorMessage;
            this.isError=true;
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
  
  // create form row.
  private getEmployeeData() {
    return this.formBuilder.group({
        unitType: [''],
        unitName: [''],
        ifscCode: [''],
        employeeName: [''],
        employeeId: [''],
        employeeDesignation : [''],
        e2eStatus: [''],
        updatedDate: [''],
        lastUpdatedBy :[''],
        status :['']
    });
  }
  
  // add new row
  addEmployee() {
    const control = <FormArray>this.employeeListForm.controls['unitData'];
    control.push(this.getEmployeeData());
  }
  
  getUnitDataArrayControl() {
    return (this.employeeListForm.get('unitData') as FormArray).controls;
  }
  
  performSearch() {
    this.progress = 0;
    this.searchErrorMessage = '';
    this.isSearchResultFailed = false;
    this.isError = false;
    this.currentFile = undefined;
    let unitArrData: any = [];
    let requestData = this.manageEmployeesForm.value;
    console.log('requestData :',requestData);
    if(null!=requestData && (requestData.unitName!=undefined || requestData.ifscCode != undefined)) {
	    this.manageEmployeeService.manageEmployees(requestData).subscribe(result => {
	      console.log("result", result);
	      if (result && result.data) {
	        this.searchResults = true;
	        result.data.forEach(eachData => {
	          unitArrData.push({
	            unitType: eachData.unitType,
	            unitName: eachData.unitName,
	            ifscCode: eachData.ifscCode,
	            employeeName: eachData.employeeName,
	            employeeId: eachData.employeeId,
	            employeeDesignation : eachData.employeeDesignation,
	            e2eStatus: eachData.e2eStatus,
	            updatedDate: eachData.updatedDate,
	            lastUpdatedBy :eachData.createdBy,
	            status: eachData.status
	          });
	        });
	        (this.employeeListForm.get('unitData') as FormArray).clear();
	        unitArrData.forEach((eachArray, index) => {
	          this.addEmployee();
	        });
	      }
	      //console.log("unitArrData", unitArrData);
	      this.employeeListForm.patchValue({
	        unitData: unitArrData
	      });
	    },
		  (err: any) => {
	        console.log('Error Found ......',err.error.errorMessage);
	        this.showView = false;
	        this.showImportEmployees = false;
	        this.showExistingView = false;
	        this.searchResults = false;
	        this.isSearchResultFailed = true;
	        this.searchErrorMessage = err.error.errorMessage;
		  });
	  } else {
	  	 this.isSearchResultFailed = true;
	  	 this.searchResults = false;
	     this.searchErrorMessage = 'Either Unit Name or IFSC code is required for viewing employee';
	  }
  }
  
  updateStatus(i,employeeId) {
      let employeeDetails = this.getUnitDataArrayControl()[i].value;
      console.log("employeeDetails :: "+employeeDetails);
      let reqData: any;
	  reqData = {
	    employeeId: employeeId
	  }
	
	  this.manageEmployeeService.updateEmployee(reqData).subscribe(result=>{
	    this.toastrService.success('Employee updated successfully', 'Information', {
	      timeOut: 3000,
	    });
	  },
	  err => {
	    console.log("err",err);  
	    this.toastrService.error('Unable to update status', 'Information', {
	      timeOut: 3000,
	    });      
	  });
    
  }
  
  downloadErrorFile() : void {
	   let fileName="EmployeeError_"+this.clientId+".xlsx";
	   this.manageEmployeeService.downloadErrorData(this.clientId).subscribe(response => {
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
		this.isDownloadAllowed = !this.isDownloadAllowed;
  }
}