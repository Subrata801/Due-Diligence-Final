import { ComponentFixture, TestBed } from '@angular/core/testing';
import { viewDueDiligenceComponent } from './view-due-diligence.component';

describe('viewDueDiligenceComponent', () => {
  let component: viewDueDiligenceComponent;
  let fixture: ComponentFixture<viewDueDiligenceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ viewDueDiligenceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(viewDueDiligenceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
