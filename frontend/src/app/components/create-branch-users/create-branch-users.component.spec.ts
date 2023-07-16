import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CreateBranchUsersComponent } from './branch-users.component';

describe('CreateBranchUsersComponent', () => {
  let component: CreateBranchUsersComponent;
  let fixture: ComponentFixture<CreateBranchUsersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateBranchUsersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateBranchUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
