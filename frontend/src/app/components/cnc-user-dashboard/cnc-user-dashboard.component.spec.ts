import { ComponentFixture, TestBed } from '@angular/core/testing';
import { cncUserDashboardComponent } from './cnc-user-dashboard.component';

describe('cncUserDashboardComponent', () => {
  let component: cncUserDashboardComponent;
  let fixture: ComponentFixture<cncUserDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ cncUserDashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(cncUserDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
