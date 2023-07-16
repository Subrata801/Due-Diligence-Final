import { ErrorHandler, Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-client-config',
  templateUrl: './client-config.component.html',
  styleUrls: ['./client-config.component.scss']
})
export class ClientConfigComponent implements OnInit {

  pageErrors: any = {};
  isError: boolean = false;
  isSuccess: boolean = false;
  search = false;
  errorMessage = '';

  constructor(private formBuilder: FormBuilder, private errorHandler: ErrorHandler, private router: Router,
    private toastrService: ToastrService) {
  }

  ngOnInit(): void {
    this.router.navigate(['client',{ outlets: { appcontent: ['search-client'] } }]);   
    //this.router.navigate(['home',{ outlets: { appcontent: ['dashboard'] } }]);
  }

  searchClients() {
    this.search = !this.search;
  }
}
