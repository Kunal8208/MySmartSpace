import { TestBed } from '@angular/core/testing';

import { ProductstateserviceService } from './productstateservice.service';

describe('ProductstateserviceService', () => {
  let service: ProductstateserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductstateserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
