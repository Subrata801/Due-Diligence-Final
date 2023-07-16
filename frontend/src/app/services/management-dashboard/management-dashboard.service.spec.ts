import { TestBed } from '@angular/core/testing';

import { ManagementDashboardService } from './management-dashboard.service';

describe('ManagementDashboardService', () => {
  let service: ManagementDashboardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ManagementDashboardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
