import { Component, EventEmitter, Inject, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-create-new-version-dialog',
  templateUrl: './create-new-version-dialog.component.html',
  styleUrls: ['./create-new-version-dialog.component.scss']
})
export class createNewVersionDialogComponent implements OnInit {
  @Input() public date;
  @Input() public option;
  @Output() passEntry: EventEmitter<any> = new EventEmitter();
  newVersionForm: FormGroup;
    
  constructor(private formBuilder: FormBuilder,
    public dialogRef: MatDialogRef<createNewVersionDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  cancelClick(): void {
    this.dialogRef.close();
  }

  okClick(): void {
    this.passEntry.emit(this.newVersionForm);
    this.dialogRef.close();
  }

  ngOnInit() {
    this.newVersionForm = this.formBuilder.group({
      date: this.date,
      option: this.option
    });
  }

}
