import { ComponentFixture, TestBed } from '@angular/core/testing';
import { e2eManagementDashboardComponent } from './e2e-management-dashboard.component';

describe('e2eManagementDashboardComponent', () => {
  let component: e2eManagementDashboardComponent;
  let fixture: ComponentFixture<e2eManagementDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ e2eManagementDashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(e2eManagementDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
