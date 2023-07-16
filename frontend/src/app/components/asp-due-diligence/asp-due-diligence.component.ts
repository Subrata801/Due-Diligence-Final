import { Component, OnInit } from '@angular/core';
import { FormControl, FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute, Router } from '@angular/router';
import { ErrorHandler } from '../../error/error.handler';
import { ClientConfigurationService } from 'src/app/services/client-configuration/client-configuration.service';
import { DueDeligenceService } from 'src/app/services/due-deligence/due-deligence.service';
import { forkJoin, Observable } from 'rxjs';

@Component({
  selector: 'app-asp-due-diligence',
  templateUrl: './asp-due-diligence.component.html',
  styleUrls: ['./asp-due-diligence.component.scss']
})
export class AspDueDiligenceComponent implements OnInit {
  
  aspDueDiligenceForm: FormGroup;
  isError: boolean = false;
  isSuccess: boolean = false;
  errorMessage = '';
  ddId: any;
  key1: any;
  key2: any;
  key3: any;
  key4: any;
  router: any;
  ddoptions1 = new FormControl();
  ddoptions2 = new FormControl();
  ddoptions3 = new FormControl();
  ddoptions4 = new FormControl();
  ddoptionsList: string[] = ['y','n','y0','n0','n1','n2','n3','n4','n5','n6','n7','n8','n9'];
  ddOptionsSelected1: string[] = ['n1','n2','n3','n4'];
  ddOptionsSelected2: string[] = ['y','n','n0','n5'];
  ddOptionsSelected3: string[] = ['n1','n3','n5','n7'];
  ddOptionsSelected4: string[] = ['n6','n7','n8','n9'];

  constructor(private formBuilder: FormBuilder,
    private errorHandler: ErrorHandler,
    private toastrService: ToastrService,
    private activatedroute: ActivatedRoute,
    private dueDeligenceService: DueDeligenceService) {
      this.ddId = this.activatedroute.snapshot.paramMap.get("ddId");
      this.key1 = this.activatedroute.snapshot.paramMap.get("key1");
      this.key2 = this.activatedroute.snapshot.paramMap.get("key2");
      this.key3 = this.activatedroute.snapshot.paramMap.get("key3");
      this.key4 = this.activatedroute.snapshot.paramMap.get("key4");
  }

  ngOnInit(): void {
    this.aspDueDiligenceForm = this.formBuilder.group({
      dueDeligenceDetails: this.formBuilder.array([
        this.getExistingDueDeligence()
      ])
    });
  }
  
  getExistingDueDeligence() {

  }

  clearAllErrors() {
    this.isError = false;
    this.errorMessage = "";
  }
}