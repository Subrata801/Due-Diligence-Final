import { ComponentFixture, TestBed } from '@angular/core/testing';
import { dueDiligenceActionPointsComponent } from './due-diligence-action-points.component';

describe('dueDiligenceActionPointsComponent', () => {
  let component: dueDiligenceActionPointsComponent;
  let fixture: ComponentFixture<dueDiligenceActionPointsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ dueDiligenceActionPointsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(dueDiligenceActionPointsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
