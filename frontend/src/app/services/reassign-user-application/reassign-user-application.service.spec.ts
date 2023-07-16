import { TestBed } from '@angular/core/testing';

import { ReassignUserAppService } from './reassign-user-application.service';

describe('ReassignUserAppService', () => {
  let service: ReassignUserAppService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReassignUserAppService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
