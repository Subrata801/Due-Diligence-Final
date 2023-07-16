import { ComponentFixture, TestBed } from '@angular/core/testing';
import { createAuditFirmUserComponent } from './create-audit-firm-user.component';

describe('createAuditFirmUserComponent', () => {
  let component: createAuditFirmUserComponent;
  let fixture: ComponentFixture<createAuditFirmUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ createAuditFirmUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(createAuditFirmUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
