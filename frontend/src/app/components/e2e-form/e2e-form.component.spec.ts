import { ComponentFixture, TestBed } from '@angular/core/testing';
import { e2eFormComponent } from './e2e-form.component';

describe('e2eFormComponent', () => {
  let component: e2eFormComponent;
  let fixture: ComponentFixture<e2eFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ e2eFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(e2eFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
