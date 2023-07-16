import { ComponentFixture, TestBed } from '@angular/core/testing';
import { e2eReportsComponent } from './e2e-reports.component';

describe('e2eReportsComponent', () => {
  let component: e2eReportsComponent;
  let fixture: ComponentFixture<e2eReportsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ e2eReportsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(e2eReportsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
