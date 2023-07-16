import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';

@Component({
  selector: 'app-substitute-user',
  templateUrl: './substitute-user.component.html',
  styleUrls: ['./substitute-user.component.scss']
})
export class substituteUserComponent implements OnInit {
  
  pageErrors: any = {};
  isError: boolean = false;
  isSuccess: boolean = false;
  errorMessage = '';
  search: boolean = true;
  isChecked: boolean = false;
  searchResults: boolean = false;
  status: string = "Inactive";
  selectedUnit: any;

  constructor(private formBuilder: FormBuilder,
    private errorHandler: ErrorHandler, private slideToggle: MatSlideToggleModule,
    private toastr: ToastrService) {
  }

  ngOnInit(): void {
  }
}