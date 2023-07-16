import { ComponentFixture, TestBed } from '@angular/core/testing';
import { substituteUserComponent } from './substitute-user.component';

describe('substituteUserComponent', () => {
  let component: substituteUserComponent;
  let fixture: ComponentFixture<substituteUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ substituteUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(substituteUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
