import { Component, OnInit } from '@angular/core';
import { ResetCheck } from "./dto-classes/ResetCheck";
import { Otp } from "./dto-classes/Otp";
import { ForgetPasswordService } from "./Customer.service";
import { Router } from "@angular/router";

@Component({
    selector:'app-forgetpassword',
    template:`
    <app-header-nav></app-header-nav>
    <div class="row">
  <div class="main">
      <div class="card" style="height: 540px;">
      <h3 style="text-align:right;margin-right:23px;">Forgot password? Enter the details</h3>

    <form #forgotPasswordForm='ngForm' style="float:right;">

        <div class="container"style="text-align:center;border:2px solid black;
        border-radius: 10px;">
            <label for="uid"><b>Enter UserId</b></label><br>
            <input type="text" id="uid" name="uid" placeholder="enter user ID" required [(ngModel)]=resetCheck.customerId><br>

            <button class="otp" (click)='send()'>send OTP</button><br>
            <label for="otp"><b>Enter Otp</b></label><br>
            <input type="tel" id="otp" name="otp"  placeholder="enter Otp" required [(ngModel)]=otp.otp><br><br>
            
            <div class="container" style="background-color:#f1f1f1;height:60px;width:80%">
            <button type="reset" class="cancelbtn">Reset</button>

            <button type="submit" class="proceed1" >
            <a [routerLink]="['/loginLink']" class="prcd">Back</a>
            </button> 

            <button type="submit" class="proceed1" (click)='validate()'>
            <a class="prcd">Proceed</a>
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


export class ForgetPasswordComponent implements OnInit {

    constructor(private service:ForgetPasswordService, private router:Router) { }
  
    ngOnInit(): void {
    }

    
    resetCheck = new ResetCheck;
    otp = new Otp;
    send(){
        console.log(this.resetCheck);
      //  alert(JSON.stringify(this.resetCheck));
        this.service.send(this.resetCheck).subscribe(
            data=>{
                alert("OTP sent to your registered mobile number!");
            }
        )
        
    }

    
    validate(){
        console.log(this.otp);
       // alert(JSON.stringify(this.otp));
        this.service.validate(this.otp).subscribe(
            data=>{
               // alert(JSON.stringify(data));
                if(data.status == 'Success'){
                    
                    this.router.navigate(['/setPaaswordLink'])
                }
            }
        )
        
    }    
        
    
  
  }