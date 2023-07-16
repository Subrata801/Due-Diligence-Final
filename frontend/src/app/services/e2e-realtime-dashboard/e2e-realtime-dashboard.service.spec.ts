import { TestBed } from '@angular/core/testing';

import { E2ERealTimeDashboardService } from './e2e-realtime-dashboard.service';

describe('E2ERealTimeDashboardService', () => {
  let service: E2ERealTimeDashboardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(E2ERealTimeDashboardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
