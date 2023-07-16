import { ComponentFixture, TestBed } from '@angular/core/testing';
import { SaasSubscriptionComponent } from './saas-subscription.component';

describe('SaasSubscriptionComponent', () => {
  let component: SaasSubscriptionComponent;
  let fixture: ComponentFixture<SaasSubscriptionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SaasSubscriptionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SaasSubscriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
