import { TestBed } from '@angular/core/testing';

import { CNCUserDashboardService } from './cnc-user-dashboard.service';

describe('CNCUserDashboardService', () => {
  let service: CNCUserDashboardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CNCUserDashboardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
