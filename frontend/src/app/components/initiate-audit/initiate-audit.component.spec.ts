import { ComponentFixture, TestBed } from '@angular/core/testing';
import { initiateAuditComponent } from './initiate-audit.component';

describe('initiateAuditComponent', () => {
  let component: initiateAuditComponent;
  let fixture: ComponentFixture<initiateAuditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ initiateAuditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(initiateAuditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
