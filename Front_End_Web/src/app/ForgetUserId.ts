import { Component, OnInit } from '@angular/core';

@Component({
    selector:'app-forgetUserId',
    template:`
    
    <div class="row">
  <div class="main">
      <div class="card" style="height: 540px;">
      <h3 style="text-align:right;">Forgot User Id? Enter the details</h3>

    <form #forgotUserIdForm='ngForm' style="float:right;">

        <div class="container"style="text-align:center;border:2px solid black;
        border-radius: 10px;">
            <label for="uid"><b>Enter Account Number</b></label><br>
            <input type="text" id="uid" placeholder="enter account number" required ngModel><br>


            <button class="otp">send OTP</button><br>
            <label for="otp"><b>Enter Otp</b></label><br>
            <input type="tel" id="otp" placeholder="enter Otp" required ngModel><br><br>
            
            <div class="container" style="background-color:#f1f1f1;height:60px;width:80%">
            <button type="reset" class="cancelbtn">Reset</button>

            <button type="submit" class="proceed1" >
            <a [routerLink]="['/loginLink']" class="prcd">Back</a>
            </button> 

            <button type="submit" class="proceed1" >
            <a [routerLink]="['/setPaaswordLink']" class="prcd">Proceed</a>
            </button>
            </div>
</div>
</form>
</div>
</div>
</div>

    `,
    styleUrls: ['./main.css']

})


export class ForgetUserIdComponent implements OnInit {

    constructor() { }
  
    ngOnInit(): void {
    }
  
  }