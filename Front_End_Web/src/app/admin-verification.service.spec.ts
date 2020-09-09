import { TestBed } from '@angular/core/testing';

import { AdminVerificationService } from './admin-verification.service';

describe('AdminVerificationService', () => {
  let service: AdminVerificationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminVerificationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
