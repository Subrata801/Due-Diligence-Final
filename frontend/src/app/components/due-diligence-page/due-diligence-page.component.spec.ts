import { ComponentFixture, TestBed } from '@angular/core/testing';
import { dueDiligencePageComponent } from './due-diligence-page.component';

describe('dueDiligencePageComponent', () => {
  let component: dueDiligencePageComponent;
  let fixture: ComponentFixture<dueDiligencePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ dueDiligencePageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(dueDiligencePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
