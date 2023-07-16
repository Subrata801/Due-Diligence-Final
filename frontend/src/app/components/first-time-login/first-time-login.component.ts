import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../../services/auth-service/auth.service';
import { TokenStorageService } from '../../services/token-service/token-storage.service';
import { DashboardComponent} from '../dashboard/dashboard.component';
import { ReferenceService } from '../../services/reference-service/reference.service';
import { forkJoin } from 'rxjs';

@Component({
  selector: 'app-first-time-login',
  templateUrl: './first-time-login.component.html',
  styleUrls: ['./first-time-login.component.scss']
})
export class FirstTimeLoginComponent implements OnInit {
  firstTimeLoginForm: FormGroup;
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  secretQuestOptions: any = [];
  username: any;

  constructor(private formBuilder: FormBuilder, private router: Router,
    private authService: AuthService, private tokenStorage: TokenStorageService,private activatedroute: ActivatedRoute,private referenceService: ReferenceService) {
    this.username = this.activatedroute.snapshot.paramMap.get("username");
  }

  ngOnInit(): void {
    this.fetchData();
    this.firstTimeLoginForm = this.formBuilder.group({
      username: this.username,
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
    //console.log("uname", this.firstTimeLoginForm.get('uname').value, "pword", this.firstTimeLoginForm.get('pword').value);
    this.authService.firstTimeLogin(this.firstTimeLoginForm.get('username').value,this.firstTimeLoginForm.get('secretQuestionId').value,
    this.firstTimeLoginForm.get('secretAnswer').value,
    this.firstTimeLoginForm.get('newPword').value, this.firstTimeLoginForm.get('confirmPword').value).subscribe(
      result => {
        console.log("data",result.data);
        this.tokenStorage.saveToken(result.data.jwt);
        this.tokenStorage.saveUser(result.data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
        console.log("this.roles", this.roles);
        //this.router.navigate([{ outlets: { home: [ 'dashboard' ] }}]);
        this.router.navigate(["/home"]);
      },
      err => {
        this.errorMessage = err.error.errorMessage;
        this.isLoginFailed = true;
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
