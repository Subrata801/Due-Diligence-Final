import { TestBed } from '@angular/core/testing';

import { CifRegistrationService } from './create-unit.service';

describe('CifRegistrationService', () => {
  let service: CifRegistrationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CifRegistrationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
