import { TestBed } from '@angular/core/testing';

import { DueDeligenceService } from './due-deligence.service';

describe('DueDeligenceService', () => {
  let service: DueDeligenceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DueDeligenceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
