import { Component, OnInit } from '@angular/core';
import {TransactionDetail} from '../transactions/transactionsDetails';
import {TransactionDetailService} from '../transaction-detail.service';
import {CustomerId} from './CustomerId';
import {AccountSummaryService} from '../account-summary.service';
@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {
  transactionDetail = new TransactionDetail();
  customerId = new CustomerId();
  value:any;
  user:any;
  constructor(private service:TransactionDetailService,private service1:AccountSummaryService) {
  
   }
  ngOnInit(): void {
    this.customerId.customerId = Number(sessionStorage.getItem("customerId"));
    this.service.getTransactionDetails(this.customerId).subscribe(data=>{
      this.value=data;
    //  alert(JSON.stringify(this.value));

      this.customerId.customerId = Number(sessionStorage.getItem("customerId"));
    this.service1.getAccountSummary(this.customerId).subscribe(data=>{
      this.user=data;
    //  alert(JSON.stringify(this.user));
    })
    })
  }
}
