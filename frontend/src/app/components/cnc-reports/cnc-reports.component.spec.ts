import { ComponentFixture, TestBed } from '@angular/core/testing';
import { cncReportsComponent } from './cnc-reports.component';

describe('cncReportsComponent', () => {
  let component: cncReportsComponent;
  let fixture: ComponentFixture<cncReportsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ cncReportsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(cncReportsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
