import { TestBed } from '@angular/core/testing';

import { CreateUnitService } from './create-unit.service';

describe('CreateUnitService', () => {
  let service: CreateUnitService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateUnitService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
