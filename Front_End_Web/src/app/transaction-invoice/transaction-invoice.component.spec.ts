import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TransactionInvoiceComponent } from './transaction-invoice.component';

describe('TransactionInvoiceComponent', () => {
  let component: TransactionInvoiceComponent;
  let fixture: ComponentFixture<TransactionInvoiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TransactionInvoiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TransactionInvoiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
