import { TestBed } from '@angular/core/testing';

import { CreateAuditFirmUserService } from './create-audit-firm-user.service';

describe('CreateAuditFirmUserService', () => {
  let service: CreateAuditFirmUserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateAuditFirmUserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
