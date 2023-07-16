import { TestBed } from '@angular/core/testing';

import { InitiateDueDiligenceService } from './initiate-due-diligence.service';

describe('InitiateDueDiligenceService', () => {
  let service: InitiateDueDiligenceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InitiateDueDiligenceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
