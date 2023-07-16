import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AnyStageProcessingComponent } from './any-stage-processing.component';

describe('AnyStageProcessingComponent', () => {
  let component: AnyStageProcessingComponent;
  let fixture: ComponentFixture<AnyStageProcessingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnyStageProcessingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnyStageProcessingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
