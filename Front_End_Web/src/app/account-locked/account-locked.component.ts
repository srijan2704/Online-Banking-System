import { Component, OnInit } from '@angular/core';
import {Router,ActivatedRoute,ParamMap} from '@angular/router'
@Component({
  selector: 'app-account-locked',
  templateUrl: './account-locked.component.html',
  styleUrls: ['./account-locked.component.css']
})
export class AccountLockedComponent implements OnInit {

  timeLeft: number = 5;
  interval;
  route:ActivatedRoute;
    
  constructor(private router:Router) {
  
    this.startTimer(router);

   }

  ngOnInit(): void {
  }
  startTimer(router){
    this.interval = setInterval(()=>{
      if(this.timeLeft == 0)
      {
        this.router.navigate(['/forgetPasswordLink']);
      }
      else if(this.timeLeft > 0){
        this.timeLeft--;
      }
      else{
        this.timeLeft=60;
      }
    },1000)
  }
}
