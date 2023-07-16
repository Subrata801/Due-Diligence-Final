import { ComponentFixture, TestBed } from '@angular/core/testing';
import { v1TemplatesComponent } from './v1-templates.component';

describe('v1TemplatesComponent', () => {
  let component: v1TemplatesComponent;
  let fixture: ComponentFixture<v1TemplatesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ v1TemplatesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(v1TemplatesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
