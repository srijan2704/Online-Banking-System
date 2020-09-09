import { Component, OnInit } from '@angular/core';
import { AddBeneficiary } from '../dto-classes/AddBeneficiary';
import { AddBeneficiaryService } from '../add-beneficiary.service';
import { CustomerIdGet } from '../add-beneficiary/CustomerIdGet';
import { GetBeneficiary } from '../dto-classes/getBeneficiaryDetails';
import { AccountSummaryService } from '../account-summary.service'
import { TransactionDetailService } from '../transaction-detail.service';
import { TransactionService } from '../transaction.service';
import { Transaction } from '../dto-classes/transaction';
import { Router } from '@angular/router';
import { ResetCheck } from "../dto-classes/ResetCheck";
import { Otp } from "../dto-classes/Otp";
import { ForgetPasswordService } from "../Customer.service";
import { TransactionOtp } from '../dto-classes/transactionOpt';
@Component({
  selector: 'app-fund-transfer',
  templateUrl: './fund-transfer.component.html',
  styleUrls: ['./fund-transfer.component.css']
})
export class FundTransferComponent implements OnInit {
  setCustomerId = new CustomerIdGet();
  values: any;
  accountValue: any;
  placeholdertxt: string;
  constructor(private service: AddBeneficiaryService, private service1: AccountSummaryService, private service2: TransactionService, private router: Router, private service3: ForgetPasswordService) {
    this.service.getBeneficiaryList(this.setCustomerId).subscribe(data => {
      this.values = data;
      console.log(data);
    })

    this.service1.getAccountSummary(this.setCustomerId).subscribe(data => {
      this.accountValue = data;
    })

    console.log(this.transaction.methodtype);

  }
  ngOnInit(): void {

    console.log(this.values.beneficiaryAccountNo);

  }

  transaction = new Transaction();
  transactionArr: any;
  fundTransfer() {
    this.service2.getTransactionDetails(this.transaction).subscribe(data => {
      this.transactionArr = data;
      console.log(data.transactionId);
      sessionStorage.setItem("transactionId", data.transactionId);
      sessionStorage.setItem("transactionMethod", data.transactionMethod);
      sessionStorage.setItem("transactionAmount", data.transactionAmount);
      sessionStorage.setItem("fromAccount", data.fromAccount);
      sessionStorage.setItem("toAccount", data.toAccount);
      sessionStorage.setItem("transactionDate", data.transactionDate);
      sessionStorage.setItem("status", data.status);
      sessionStorage.setItem("currentBalance", data.currentBalance);
      this.router.navigate(['/userDashboard/invoice']);
    })
  }
  contentVisible: boolean = true;
  setVisible() {
    this.contentVisible = false;
  }
  resetCheck = new ResetCheck;
  otp = new Otp;
  transactionOtp = new TransactionOtp();
  send() {
    console.log(this.transactionOtp);
    // alert(JSON.stringify(this.transactionOtp));
    this.service3.send(this.transactionOtp).subscribe(
      data => {
       // alert(JSON.stringify(data));
      }
    )

  }

  message: string;
  validate() {
    console.log(this.otp);
    // alert(JSON.stringify(this.otp));
    this.service3.validate(this.otp).subscribe(
      data => {
        // alert(JSON.stringify(data));
        if (data.status == 'Success') {

          //  alert("Sent");
          this.fundTransfer();
        }
        else {
          this.message = "Invalid OTP";
        }
      }
    )

  }

  textinfo: String;
  setMethod() {
    console.log(this.transaction.methodtype);
    if (this.transaction.methodtype == "NEFT") {
      this.textinfo = "LIMIT 20,00,000";
    }
    if (this.transaction.methodtype == "IMPS") {
      this.textinfo = "LIMIT BELOW 2,00,000";
    }
    if (this.transaction.methodtype == "RTGS") {
      this.textinfo = "LIMIT 2,00,000 TO 20,00,000";
    }
  }

}
