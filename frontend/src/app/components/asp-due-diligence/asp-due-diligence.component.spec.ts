import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AspDueDiligenceComponent } from './asp-due-diligence.component';

describe('AspDueDiligenceComponent', () => {
  let component: AspDueDiligenceComponent;
  let fixture: ComponentFixture<AspDueDiligenceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AspDueDiligenceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AspDueDiligenceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
