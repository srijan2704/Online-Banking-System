import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-home',
  template: `
  <app-header-nav></app-header-nav>
  <div class="row" >
  <div class="main">
      <div class="card" >
         <h2 style="text-align:right;"> Register for internet banking</h2>
          
         <form #regForm='ngForm' style="float:right; border:2px solid black;">
         <div class="container" >
           <label for="Account"><b>Customer Id</b></label><br>
           <input type="tel" placeholder="Enter Customer ID" name="customerId" id="Account" required ngModel><br>
            <button style="border: none;cursor: pointer;width:37%;padding: 8px 0px;margin:10px 7px">send OTP</button><br>
            <input type="tel" id="otp" placeholder="Enter OTP Here"><br>
            <button type="submit">
            <a [routerLink]="['/loginLink']" class="prcd">Submit</a></button>
            </div>
            </form>       
      </div>
  </div>
</div>

  `,
  styleUrls: ['./main.css']
})

export class InternetBankingComponent implements OnInit {

    constructor() { }
  
    ngOnInit(): void {
    }
  
  }
  