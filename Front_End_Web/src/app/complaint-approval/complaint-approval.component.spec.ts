import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComplaintApprovalComponent } from './complaint-approval.component';

describe('ComplaintApprovalComponent', () => {
  let component: ComplaintApprovalComponent;
  let fixture: ComponentFixture<ComplaintApprovalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComplaintApprovalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComplaintApprovalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
