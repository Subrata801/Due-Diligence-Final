import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RiskCustomizationComponent } from './risk-customization.component';

describe('RiskCustomizationComponent', () => {
  let component: RiskCustomizationComponent;
  let fixture: ComponentFixture<RiskCustomizationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RiskCustomizationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RiskCustomizationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
