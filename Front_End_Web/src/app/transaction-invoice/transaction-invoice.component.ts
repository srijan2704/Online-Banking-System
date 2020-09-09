import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-transaction-invoice',
  templateUrl: './transaction-invoice.component.html',
  styleUrls: ['./transaction-invoice.component.css']
})
export class TransactionInvoiceComponent implements OnInit {

  transactionId:string;
  transactionMethod:string;
  transactionAmount:String;
  fromAccount:string;
  toAccount:string;
  transactionDate:string;
  status:string;
  currentBalance:string;

  constructor() { 
    this.transactionId = sessionStorage.getItem("transactionId");
    this.transactionMethod = sessionStorage.getItem("transactionMethod");
    this.transactionAmount = sessionStorage.getItem("transactionAmount");
    this.fromAccount = sessionStorage.getItem("fromAccount");
    this.toAccount = sessionStorage.getItem("toAccount");
    this.transactionDate = sessionStorage.getItem("transactionDate");
    this.status = sessionStorage.getItem("status");
    this.currentBalance = sessionStorage.getItem("currentBalance");
  }

  ngOnInit(): void {
  }

}
