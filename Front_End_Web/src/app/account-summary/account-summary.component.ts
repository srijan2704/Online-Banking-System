import { Component, OnInit } from '@angular/core';
import {CustomerId} from '../transactions/CustomerId';
import {AccountSummaryService} from '../account-summary.service'
import { TransactionDetailService } from '../transaction-detail.service';
@Component({
  selector: 'app-account-summary',
  templateUrl: './account-summary.component.html',
  styleUrls: ['./account-summary.component.css']
})
export class AccountSummaryComponent implements OnInit {

  constructor(private service:AccountSummaryService,private service1:TransactionDetailService) { }
  customerId = new CustomerId();
  user:any;
  value:any;
  ngOnInit(): void {
    this.customerId.customerId = Number(sessionStorage.getItem("customerId"));
    this.service1.getTransactionDetails(this.customerId).subscribe(data=>{
      this.value=data;
     // alert(JSON.stringify(this.value));

      this.customerId.customerId = Number(sessionStorage.getItem("customerId"));
    this.service.getAccountSummary(this.customerId).subscribe(data=>{
      this.user=data;
     // alert(JSON.stringify(this.user));
      console.log(this.user.accountNo);
      sessionStorage.setItem("accountNo",this.user.accountNo);
    })
    })
  }
  
}
