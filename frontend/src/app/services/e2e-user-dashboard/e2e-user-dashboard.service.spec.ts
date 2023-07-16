import { TestBed } from '@angular/core/testing';

import { E2EUserDashboardService } from './e2e-user-dashboard.service';

describe('E2EUserDashboardService', () => {
  let service: E2EUserDashboardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(E2EUserDashboardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
