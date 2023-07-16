import { ComponentFixture, TestBed } from '@angular/core/testing';
import { BankServicesComponent } from './bank-services.component';

describe('BankServicesComponent', () => {
  let component: BankServicesComponent;
  let fixture: ComponentFixture<BankServicesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BankServicesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BankServicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
