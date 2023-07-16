import { ComponentFixture, TestBed } from '@angular/core/testing';
import { initiateDueDiligenceComponent } from './initiate-due-diligence.component';

describe('initiateDueDiligenceComponent', () => {
  let component: initiateDueDiligenceComponent;
  let fixture: ComponentFixture<initiateDueDiligenceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ initiateDueDiligenceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(initiateDueDiligenceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
