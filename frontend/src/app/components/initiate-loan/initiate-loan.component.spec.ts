import { ComponentFixture, TestBed } from '@angular/core/testing';
import { InitiateLoanComponent } from './initiate-loan.component';

describe('InitiateLoanComponent', () => {
  let component: InitiateLoanComponent;
  let fixture: ComponentFixture<InitiateLoanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InitiateLoanComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InitiateLoanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
