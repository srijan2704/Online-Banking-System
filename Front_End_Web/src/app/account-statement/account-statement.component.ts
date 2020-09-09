import { Component, OnInit } from '@angular/core';
import {accountStatement} from './accountStatement';
import {AccountStatementService} from '../account-statement.service';
import {AccountSummaryService} from '../account-summary.service';
import {CustomerId} from './customerIdAcccountStatement';
@Component({
  selector: 'app-account-statement',
  templateUrl: './account-statement.component.html',
  styleUrls: ['./account-statement.component.css']
})
export class AccountStatementComponent implements OnInit {
  customerId = new CustomerId();
  customerName:string= sessionStorage.getItem("customerName");
  user:any;
  constructor(private service:AccountStatementService,private service1:AccountSummaryService) {
    
   }
  
  ngOnInit(): void {

    this.service1.getAccountSummary(this.customerId).subscribe(data=>{
      this.user=data;
     // alert(JSON.stringify(this.user));
     // alert(JSON.stringify(data));
      console.log(this.user.accountNo);
      sessionStorage.setItem("accountNo",this.user.accountNo);
    })
    
  }
  printStatement:any;
  accountStatement = new accountStatement();
  getStatement()
  {
    this.service.getAccountStatement(this.accountStatement).subscribe(data=>{
      this.printStatement = data;
    //  alert(JSON.stringify(data));
    })
  }

}
