import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ClientMgmtDashboardComponent } from './client-management-dashboard.component';

describe('LoanSchemeComponent', () => {
  let component: ClientMgmtDashboardComponent;
  let fixture: ComponentFixture<ClientMgmtDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientMgmtDashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientMgmtDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
