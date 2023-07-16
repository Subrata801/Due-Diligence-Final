import { TestBed } from '@angular/core/testing';

import { CreateNewClientService } from './create-new-client.service';

describe('CreateNewClientService', () => {
  let service: CreateNewClientService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateNewClientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
