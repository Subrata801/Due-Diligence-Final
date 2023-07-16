import { TestBed } from '@angular/core/testing';

import { SubstituteUserAppService } from './substitute-user-application.service';

describe('SubstituteUserAppService', () => {
  let service: SubstituteUserAppService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SubstituteUserAppService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
