import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth-service/auth.service';
import { TokenStorageService } from '../../services/token-service/token-storage.service';
import { DashboardComponent} from '../dashboard/dashboard.component';
import { forkJoin } from 'rxjs';
import { ReferenceService } from '../../services/reference-service/reference.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.scss']
})
export class ForgotPasswordComponent implements OnInit {
  forgotPasswordForm: FormGroup;
  isLoggedIn = false;
  isSubmitForgotPasswordFailed = false;
  errorMessage = '';
  roles: string[] = [];
  secretQuestOptions: any = [];

  constructor(private formBuilder: FormBuilder, private router: Router,
    private authService: AuthService, private tokenStorage: TokenStorageService,private referenceService: ReferenceService) {
  }

  ngOnInit(): void {
    this.fetchData();
    this.forgotPasswordForm = this.formBuilder.group({
      uname: ['', Validators.required],
      newPword: ['', Validators.required],
      confirmPword: ['', Validators.required],
      secretAnswer: ['', Validators.required],
      secretQuestionId: ['', [Validators.required]]
    })
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    }
  }

  performAction() {
    //console.log("uname", this.forgotPasswordForm.get('uname').value, "pword", this.forgotPasswordForm.get('pword').value);
    this.authService.resetPassword(this.forgotPasswordForm.get('uname').value,this.forgotPasswordForm.get('secretQuestionId').value,
    this.forgotPasswordForm.get('secretAnswer').value,
    this.forgotPasswordForm.get('newPword').value, this.forgotPasswordForm.get('confirmPword').value).subscribe(
      result => {
        //console.log("data",result.data);
        //this.tokenStorage.saveToken(result.data.jwt);
        //this.tokenStorage.saveUser(result.data);

        this.isSubmitForgotPasswordFailed = false;
        //this.isLoggedIn = true;
        //this.roles = this.tokenStorage.getUser().roles;
        //console.log("this.roles", this.roles);
        //this.router.navigate([{ outlets: { home: [ 'dashboard' ] }}]);
        this.router.navigate(["/login"]);
      },
      err => {
        this.errorMessage = err.error.errorMessage;
        this.isSubmitForgotPasswordFailed = true;
      }
    );
  }
  fetchData() {
    forkJoin([this.referenceService.getReferenceSecurityQuestions()])
      .subscribe(results => {
        console.log("results", results);
        if (results) {
          if (results[0] && results[0].data) {
            this.secretQuestOptions = results[0].data;
          }
        }
      });
  }
  reloadPage(): void {
    window.location.reload();
  }

}
