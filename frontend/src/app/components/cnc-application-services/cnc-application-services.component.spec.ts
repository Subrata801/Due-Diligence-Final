import { ComponentFixture, TestBed } from '@angular/core/testing';
import { cncApplicationServicesComponent } from './cnc-application-services.component';

describe('cncApplicationServicesComponent', () => {
  let component: cncApplicationServicesComponent;
  let fixture: ComponentFixture<cncApplicationServicesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ cncApplicationServicesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(cncApplicationServicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
