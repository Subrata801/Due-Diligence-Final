import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AnyStageProcessingComponentLevel2 } from './any-stage-processing-level2.component';

describe('AnyStageProcessingComponentLevel2', () => {
  let component: AnyStageProcessingComponentLevel2;
  let fixture: ComponentFixture<AnyStageProcessingComponentLevel2>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnyStageProcessingComponentLevel2 ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnyStageProcessingComponentLevel2);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
