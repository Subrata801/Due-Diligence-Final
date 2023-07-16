import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import { ErrorHandler } from '../../error/error.handler';
import { FileUploadService } from '../../services/file-upload/file-upload.service';
import { ReferenceService } from '../../services/reference-service/reference.service';
import { LanguageTemplateService } from '../../services/template/template.service';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth-service/auth.service';
import { forkJoin, Observable } from 'rxjs';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {

  UserProfileForm: FormGroup;
  pageErrors: any = {};
  isUpdateProfileFailed = false;
  errorMessage = '';
  userName = '';

  constructor(private formBuilder: FormBuilder,
    private errorHandler: ErrorHandler,
    private referenceService: ReferenceService,
    private authService: AuthService,
    private _router: Router,
    private toastrService: ToastrService) {
  }

  ngOnInit(): void {
    this.UserProfileForm = this.formBuilder.group({
      userName: [''],
      userMobile: [''],
      userEmail: [''],
      fullName: ['']
    });
    this.fetchData();
  }
   performAction() {
    this.authService.updateUser(this.UserProfileForm.get('userName').value,
    this.UserProfileForm.get('userMobile').value, this.UserProfileForm.get('userEmail').value,
    this.UserProfileForm.get('fullName').value).subscribe(
      result => {
        //console.log("data",result.data);
        this.isUpdateProfileFailed = false;
        this.toastrService.success('Profile updated successfully', 'Information', {
          timeOut: 3000,
        });
      },
      err => {
        this.errorMessage = err.error.errorMessage;
        this.isUpdateProfileFailed = true;
      }
    );
  }
  
  fetchData() {
    forkJoin([this.authService.getUserInfo()])
      .subscribe(results => {
        console.log("results", results);
        if (results[0] && results[0].data) {
	        this.UserProfileForm.patchValue({
	          userName: results[0].data.userName,
	          userMobile: results[0].data.mobileNumber,
	          userEmail: results[0].data.email,
	          fullName: results[0].data.fullName
	        })
        }
      });
  
  }
  
 }
