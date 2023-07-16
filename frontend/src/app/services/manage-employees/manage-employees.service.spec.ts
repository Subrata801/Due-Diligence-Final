import { TestBed } from '@angular/core/testing';

import { ManageEmployeeService } from './manage-employees.service';

describe('ManageEmployeeService', () => {
  let service: ManageEmployeeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ManageEmployeeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
