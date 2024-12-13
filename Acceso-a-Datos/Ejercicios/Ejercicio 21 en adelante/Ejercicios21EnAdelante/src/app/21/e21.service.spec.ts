import { TestBed } from '@angular/core/testing';

import { E21Service } from './e21.service';

describe('E21Service', () => {
  let service: E21Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(E21Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
