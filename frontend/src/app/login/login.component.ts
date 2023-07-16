import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth-service/auth.service';
import { TokenStorageService } from '../services/token-service/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
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
    //console.log("uname", this.loginForm.get('uname').value, "pword", this.loginForm.get('pword').value);
    this.authService.login(this.loginForm.get('uname').value, this.loginForm.get('pword').value).subscribe(
      result => {
        console.log("data",result.data);
        this.tokenStorage.saveToken(result.data.jwt);
        this.tokenStorage.saveUser(result.data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
        console.log("this.roles", this.roles);
        this.router.navigate(["/home"]);
      },
      err => {
      	this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );


  }

  reloadPage(): void {
    window.location.reload();
  }

}
