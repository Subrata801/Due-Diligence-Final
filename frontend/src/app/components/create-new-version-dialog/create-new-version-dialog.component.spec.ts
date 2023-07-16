import { ComponentFixture, TestBed } from '@angular/core/testing';
import { createNewVersionDialogComponent } from './create-new-version-dialog.component';

describe('createNewVersionDialogComponent', () => {
  let component: createNewVersionDialogComponent;
  let fixture: ComponentFixture<createNewVersionDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ createNewVersionDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(createNewVersionDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
