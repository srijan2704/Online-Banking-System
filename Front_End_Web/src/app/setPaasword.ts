import { Component, OnInit } from '@angular/core';
import { ResetPass } from "./dto-classes/ResetPass";
import { ForgetPasswordService } from "./Customer.service";
import { Router } from "@angular/router";

@Component({
  selector: 'app-setPassword',
  template: `


<div class="row">
<div class="main">
    <div class="card" style="height: 540px;">
    <h3 style="text-align:right;">Set your New Password</h3>
 

  <form #setPasswordForm='ngForm' style="float:right;">

      <div class="container" style="text-align:center;border:2px solid black;
      border-radius: 10px;">
      <label for="psw"><b>Login Password</b></label><br>

      <input class="pswrd" type="password" name="pswrd" placeholder="Enter Password (minLength=6)" id="psw" required [(ngModel)]=resetPass.password><span class="show">SHOW</span><br>

      <label for="psw"><b>Confirm Password</b></label><br>
      <input class="pswrd1" type="password" name="pswrd" placeholder="Re-enter password (minLength=6)" id="psw1" required ><span class="view">SHOW</span><br>
      <span *ngIf='confirm' style="color: red;font-weight:bold"> Oops!! Password mismatch </span>

          <div class="container" style="background-color:#f1f1f1;height:60px;width:80%;margin-left:3px;">
          <button type="reset" class="cancelbtn">Reset</button>
          <button type="submit" class="proceed1" (click)='confirmPassword();' >Submit</button>
          <!-- <button class="proceed1" >
          <a [routerLink]="['/loginLink']" class="prcd">Login</a>
          </button> -->
          </div>
          </div> 
         
</form>
</div>
</div>
</div>

`,
  styleUrls: ['./main.css']

})

export class SetPasswordComponent implements OnInit {

  constructor(private service: ForgetPasswordService, private router: Router) { }

  ngOnInit(): void {
    var input: HTMLInputElement = document.querySelector('.pswrd');
    var show: HTMLInputElement = document.querySelector('.show');
    show.addEventListener('click', active);
    function active() {

      if (input.type === "password") {
        input.type = "text";
        show.style.color = "#1DA1F2";
        show.textContent = "HIDE";
      }
      else {
        input.type = "password";
        show.textContent = "SHOW";
        show.style.color = "#111";
      }
    }
    var input1: HTMLInputElement = document.querySelector('.pswrd1');
    var show1: HTMLInputElement = document.querySelector('.view');
    show1.addEventListener('click', active1);
    function active1() {
      if (input1.type === "password") {
        input1.type = "text";
        show1.style.color = "#1DA1F2";
        show1.textContent = "HIDE";
      }
      else {
        input1.type = "password";
        show1.textContent = "SHOW";
        show1.style.color = "#111";
      }


    }

  }

  resetPass = new ResetPass;
  setPass() {
    console.log(this.resetPass);
    this.service.setPass(this.resetPass).subscribe(
      data => {
        //alert(JSON.stringify(data));
        if (data.status == 'Success') {
          this.router.navigate(['/loginLink']);
        }
      }
    )
  }
  confirm: boolean = false;
  confirmPassword() {
    var pass = (<HTMLInputElement>document.getElementById('psw1'));
    if (this.resetPass.password != pass.value) {
      this.confirm = true;
    }
    if (this.resetPass.password == pass.value) {
      this.confirm = false;
      this.setPass();
    }
  }

}

