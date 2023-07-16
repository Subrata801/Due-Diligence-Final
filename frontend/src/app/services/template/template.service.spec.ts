import { TestBed } from '@angular/core/testing';
import { LanguageTemplateService } from './template.service';

describe('LanguageTemplateService', () => {
  let service: LanguageTemplateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LanguageTemplateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
