import { TestBed } from '@angular/core/testing';

import { CNCRealTimeDashboardService } from './cnc-realtime-dashboard.service';

describe('CNCRealTimeDashboardService', () => {
  let service: CNCRealTimeDashboardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CNCRealTimeDashboardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
