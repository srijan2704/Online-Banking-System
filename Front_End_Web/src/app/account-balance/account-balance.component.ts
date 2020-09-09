import { Component, OnInit } from '@angular/core';
import {CustomerId} from '../transactions/CustomerId';
import {AccountSummaryService} from '../account-summary.service'
@Component({
  selector: 'app-account-balance',
  templateUrl: './account-balance.component.html',
  styleUrls: ['./account-balance.component.css']
})
export class AccountBalanceComponent implements OnInit {

  customerId = new CustomerId();
  user:any;
  customerName:string = sessionStorage.getItem("customerName");
  constructor(private service:AccountSummaryService) { 
  }
  ngOnInit(): void {
    this.customerId.customerId = Number(sessionStorage.getItem("customerId"));
    this.service.getAccountSummary(this.customerId).subscribe(data=>
      {
        this.user = data;
       // alert(JSON.stringify(this.user));
      })
  }

}
