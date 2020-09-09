import { TestBed } from '@angular/core/testing';

import { UserDashboardPasswordRestService } from './user-dashboard-password-rest.service';

describe('UserDashboardPasswordRestService', () => {
  let service: UserDashboardPasswordRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserDashboardPasswordRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
