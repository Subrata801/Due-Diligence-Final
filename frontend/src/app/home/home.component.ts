import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from '../services/token-service/token-storage.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private router:Router,private tokenService: TokenStorageService) { }

  ngOnInit(): void {
  }

  userReg(){
    this.router.navigate([{ outlets: { home: [ 'user-registration' ] }}]); 
  }

  performLogout(){
    this.tokenService.signOut();
    this.router.navigate(['login']); 
  }

}
