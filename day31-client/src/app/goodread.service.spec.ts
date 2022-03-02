import { TestBed } from '@angular/core/testing';

import { GoodreadService } from './goodread.service';

describe('GoodreadService', () => {
  let service: GoodreadService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GoodreadService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
