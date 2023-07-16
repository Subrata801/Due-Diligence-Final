import { ComponentFixture, TestBed } from '@angular/core/testing';
import { cncManagementDashboardComponent } from './cnc-management-dashboard.component';

describe('cncManagementDashboardComponent', () => {
  let component: cncManagementDashboardComponent;
  let fixture: ComponentFixture<cncManagementDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ cncManagementDashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(cncManagementDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
