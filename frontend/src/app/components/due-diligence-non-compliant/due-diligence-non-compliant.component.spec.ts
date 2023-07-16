import { ComponentFixture, TestBed } from '@angular/core/testing';
import { dueDiligenceNonCompliantComponent } from './due-diligence-non-compliant.component';

describe('dueDiligenceNonCompliantComponent', () => {
  let component: dueDiligenceNonCompliantComponent;
  let fixture: ComponentFixture<dueDiligenceNonCompliantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ dueDiligenceNonCompliantComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(dueDiligenceNonCompliantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
