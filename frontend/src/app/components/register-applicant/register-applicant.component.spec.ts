import { ComponentFixture, TestBed } from '@angular/core/testing';
import { registerApplicantComponent } from './register-applicant.component';

describe('registerApplicantComponent', () => {
  let component: registerApplicantComponent;
  let fixture: ComponentFixture<registerApplicantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ registerApplicantComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(registerApplicantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
