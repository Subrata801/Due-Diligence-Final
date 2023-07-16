import { ComponentFixture, TestBed } from '@angular/core/testing';
import { LoanSchemeVariantComponent } from './loan-scheme-variant.component';

describe('LoanSchemeVariantComponent', () => {
  let component: LoanSchemeVariantComponent;
  let fixture: ComponentFixture<LoanSchemeVariantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoanSchemeVariantComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoanSchemeVariantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
