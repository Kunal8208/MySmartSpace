import { TestBed } from '@angular/core/testing';

import { LoginstateserviceService } from './loginstateservice.service';

describe('LoginstateserviceService', () => {
  let service: LoginstateserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoginstateserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
