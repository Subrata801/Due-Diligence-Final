import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { ErrorHandler } from '../../error/error.handler';
import { ActivatedRoute, Router } from '@angular/router';
import { DueDeligenceService } from 'src/app/services/due-deligence/due-deligence.service';

@Component({
  selector: 'app-module-headers',
  templateUrl: './module-headers.component.html',
  styleUrls: ['./module-headers.component.scss']
})
export class ModuleHeadersComponent implements OnInit {
  
  loadHeaders = false;
  isError = false;
  isHeader1 = false;
  isHeader2 = false;
  isHeader3 = false;
  isHeader4 = false;
  isHeader5 = false;
  errorMessage = '';
  ddId: any;
  key1: any;
  key2: any;
  key3: any;
  key4: any;

  constructor(private formBuilder: FormBuilder,
    private activatedroute: ActivatedRoute,
    private router: Router,
    private errorHandler: ErrorHandler,
    private toastr: ToastrService,
    private dueDeligenceService: DueDeligenceService) {
      this.ddId = this.activatedroute.snapshot.paramMap.get("ddId");
      this.key1 = this.activatedroute.snapshot.paramMap.get("key1");
      this.key2 = this.activatedroute.snapshot.paramMap.get("key2");
      this.key3 = this.activatedroute.snapshot.paramMap.get("key3");
      this.key4 = this.activatedroute.snapshot.paramMap.get("key4");
  }

  ngOnInit(): void {

  }

  viewDD(){
    this.router.navigate(['home', {
      outlets: {
        appcontent: ['asp-due-diligence']
      }
    }]);
  }
}