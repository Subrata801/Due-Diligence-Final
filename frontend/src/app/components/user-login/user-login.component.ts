import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth-service/auth.service';
import { TokenStorageService } from '../../services/token-service/token-storage.service';
import { DashboardComponent} from '../dashboard/dashboard.component';
import { FirstTimeLoginComponent } from '../first-time-login/first-time-login.component';
import { preventCopyPaste } from '../preventCopyPaste.directive';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.scss']
})
export class UserLoginComponent implements OnInit {
  loginForm: FormGroup;
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];

  constructor(private formBuilder: FormBuilder, private router: Router,
    private authService: AuthService, private tokenStorage: TokenStorageService) {
  }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      uname: ['', Validators.required],
      pword: ['', Validators.required]
    })
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    }
  }

  performAction() {
    this.authService.login(this.loginForm.get('uname').value, this.loginForm.get('pword').value).subscribe(
      result => {
        //console.log("data",result.data);
        this.tokenStorage.saveToken(result.data.jwt);
        this.tokenStorage.saveUser(result.data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
        //console.log("this.roles", this.roles);
        
        //this.router.navigate([{ outlets: { home: [ 'dashboard' ] }}]);
        //result.data.lastlogin = null;
        if(result.data.lastlogin==null){
          this.router.navigate(["/first-time-login/"+this.loginForm.get('uname').value]);
        } else {
          this.router.navigate(["/home"]);
        }
        
      },
      err => {
        console.log('LoginError',err.error.errorMessage);
        this.errorMessage = err.error.errorMessage;
        this.isLoginFailed = true;
      }
    );
  }

  reloadPage(): void {
    window.location.reload();
  }

}
