import { ComponentFixture, TestBed } from '@angular/core/testing';
import { initiateLoanApplicationComponent } from './initiate-loan-application.component';

describe('initiateLoanApplicationComponent', () => {
  let component: initiateLoanApplicationComponent;
  let fixture: ComponentFixture<initiateLoanApplicationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ initiateLoanApplicationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(initiateLoanApplicationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
