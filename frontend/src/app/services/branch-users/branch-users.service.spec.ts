import { TestBed } from '@angular/core/testing';

import { ManageEmployeeService } from './branch-users.service';

describe('BranchUserService', () => {
  let service: BranchUserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BranchUserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
