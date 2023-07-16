import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';
import { HeaderService } from '../../services/header/header.service';

@Component({
  selector: 'app-create-header',
  templateUrl: './create-header.component.html',
  styleUrls: ['./create-header.component.scss']
})
export class CreateHeaderComponent implements OnInit {

  updateHeaderForm: FormGroup;
  addHeaderForm: FormGroup;
  searchHeaderForm: FormGroup;
  pageErrors: any = {};
  showHeader: boolean = true;
  errorMessage = '';
  isAddHeaderFailed = false;
  isEditHeaderFailed = false;
  
  constructor(private formBuilder: FormBuilder, private errorHandler: ErrorHandler, private toastr: ToastrService,
    private headerService: HeaderService) {
  }

  ngOnInit(): void {
    this.searchHeaderForm = this.formBuilder.group({
      headerKey: [''],
      englishDescription: ['']
    });
    this.addHeaderForm = this.formBuilder.group({
      headerKey: ['', [Validators.required]],
      englishDescription: ['', [Validators.required]],
      nonEnglishDescription: [''],
      headerRequestType: ['']
    });
    this.updateHeaderForm = this.formBuilder.group({
      headerData: this.formBuilder.array([
        this.getHeaderData()
      ])
    });
    this.fetchPageData();
    this.errorHandler.handleErrors(this.searchHeaderForm, this.pageErrors);
    //console.log("schemeData",this.loanSchemeForm.controls.schemeData.controls.length); 
    //this.addUnit();
    //this.registerValueChanges();

  }

  fetchPageData() {

    // this.headerService.getHeaders().subscribe(result => {
    //   console.log("result", result);
    //   let headerArr: any = [];
    //   if (result && result.data) {
    //     result.data.forEach(eachData => {
    //       headerArr.push({
    //         headerKey: eachData.headerKey,
    //         englishDescription: eachData.englishDescription,
    //         nonEnglishDescription: eachData.nonEnglishDescription
    //       })

    //     });
    //   }

    //   headerArr.forEach((eachArray, index) => {
    //     if (index < headerArr.length - 1) {
    //       this.addUnit();
    //     }
    //   });
    //   this.createHeaderForm.patchValue({
    //     headerData: headerArr
    //   });

    // });
    (this.updateHeaderForm.get('headerData') as FormArray).clear();

  }

  getHeaderDataArrayControl() {
    return (this.updateHeaderForm.get('headerData') as FormArray).controls;
  }

  // now we create some service methods for create, add and remove 
  // row inside form
  // create form row.
  private getHeaderData() {
    return this.formBuilder.group({
      headerKey: ['', [Validators.required]],
      englishDescription: ['', [Validators.required]],
      nonEnglishDescription: [''],
      headerRequestType: ['']
    });
  }

  removeUnit(i: number) {
    const control = <FormArray>this.updateHeaderForm.controls['headerData'];
    control.removeAt(i);
  }

  // add new row
  addUnit() {
    const control = <FormArray>this.updateHeaderForm.controls['headerData'];
    control.push(this.getHeaderData());
  }

  performSubmit() {
    let requestData = this.addHeaderForm.value;
    requestData.headerRequestType = "createHeaderRequest";
    this.headerService.addHeader(requestData).subscribe(result => {      
      console.log("results", result);
      this.isAddHeaderFailed = false;
      this.isEditHeaderFailed = false;
      this.toastr.success('A new Header is added with HeaderKey: ' + this.addHeaderForm.value.headerKey, 'Information', {
      timeOut: 3000,
    });
    },
	  err => {
	    this.errorMessage = err.error.errorMessage;
	    this.isEditHeaderFailed = false;
	    this.isAddHeaderFailed = true;
	  });

    
  }

  saveUnit(index) {   
    console.log(this.getHeaderDataArrayControl()[index].value);
    let updateRequestData:any = this.getHeaderDataArrayControl()[index].value;
    console.log("updateRequestData",updateRequestData);
    updateRequestData.headerRequestType = "updateHeaderRequest";
    this.headerService.addHeader(updateRequestData).subscribe(result => {      
      console.log("updateRequestData", result);
      this.isEditHeaderFailed = false;
      this.toastr.success('Your changes has been saved for the record ' + this.getHeaderDataArrayControl()[index].value.headerKey, 'Information', {
      timeOut: 3000,
   	   });
     },err => {
	    this.errorMessage = err.error.errorMessage;
	    this.isAddHeaderFailed = false;
	    this.isEditHeaderFailed = true;
	  });

    
  }
  deleteUnit(index) {
    this.toastr.error('There are some issues saving your changes for ' + this.getHeaderDataArrayControl()[index].value.headerKey + '. Please try again.', 'Warning', {
      timeOut: 4000,
    });
  }

  performSearch() {
    //let requestData = this.searchHeaderForm.value;
    let requestData = this.addHeaderForm.value;
    let headerArrData: any = [];
    this.isAddHeaderFailed = false;
    this.isEditHeaderFailed = false;
    // // this.createHeaderForm.patchValue({
    // //   headerData: []
    // // });   
    // this.getHeaderDataArrayControl().forEach((eachData, index) => {
    //   console.log("index", index);
    //   this.removeUnit(index);
    // });
    (this.updateHeaderForm.get('headerData') as FormArray).clear();
    //  this.showHeader = false;
    // setTimeout(() => {this.showHeader=true;})

    // const control = <FormArray>this.createHeaderForm.controls['headerData'];
    // control.reset();
    // this.getHeaderDataArrayControl().forEach((eachData, index) => {
    //   control.removeAt(index)
    // });


    this.headerService.searchHeaders(requestData.headerKey, requestData.englishDescription,requestData.nonEnglishDescription).subscribe(result => {
      console.log("result", result);


      if (result && result.data) {
        result.data.forEach(eachData => {
          headerArrData.push({
            headerKey: eachData.headerKey,
            englishDescription: eachData.englishDescription,
            nonEnglishDescription: eachData.nonEnglishDescription
          });


        });
        headerArrData.forEach((eachArray, index) => {
          //if (index < headerArrData.length - 1) {
          this.addUnit();
          //}
        });

      }
      console.log("headerArrData", headerArrData);
      this.updateHeaderForm.patchValue({
        headerData: headerArrData
      });

    });
  }


}
