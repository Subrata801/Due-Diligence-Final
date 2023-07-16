import { ComponentFixture, TestBed } from '@angular/core/testing';
import { createUnitComponent } from './create-unit.component';

describe('createUnitComponent', () => {
  let component: createUnitComponent;
  let fixture: ComponentFixture<createUnitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ createUnitComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(createUnitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
