import { ComponentFixture, TestBed } from '@angular/core/testing';
import { e2eApplicationServicesComponent } from './e2e-application-services.component';

describe('e2eApplicationServicesComponent', () => {
  let component: e2eApplicationServicesComponent;
  let fixture: ComponentFixture<e2eApplicationServicesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ e2eApplicationServicesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(e2eApplicationServicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
