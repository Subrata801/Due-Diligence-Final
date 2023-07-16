import { ComponentFixture, TestBed } from '@angular/core/testing';
import { e2eUserDashboardComponent } from './e2e-user-dashboard.component';

describe('e2eUserDashboardComponent', () => {
  let component: e2eUserDashboardComponent;
  let fixture: ComponentFixture<e2eUserDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ e2eUserDashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(e2eUserDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
