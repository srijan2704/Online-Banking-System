import { Component, OnInit } from '@angular/core';
import { AdminVerificationService } from "../admin-verification.service";
import { ReferenceNo } from "../reference-no";

@Component({
  selector: 'app-admin-verification',
  templateUrl: './admin-verification.component.html',
  styleUrls: ['./admin-verification.component.css']
})
export class AdminVerificationComponent implements OnInit {
  
  constructor(private service:AdminVerificationService) { }
  data:any;
  data1:any;
  r:ReferenceNo;
  viewVisitors(){
    this.service.getVisitors().subscribe(data=>{
      this.data=data;
        })
     
  }

//   deleteVisitor(r){
//     this.service.deleteVisitor(r).subscribe(data1=>{
//       this.data1=data1;
//       alert(JSON.stringify(data1));
//     })
//  }

  ngOnInit(): void {
  }
  
  deleteRow(x){
    var delBtn = confirm(" Do you want to delete ?");
     this.r=this.r=this.data[x].serviceRefNo;
     // alert(this.r);
    this.service.deleteVisitor(this.r).subscribe(data=>{
      this.data1=data;
    //  alert(JSON.stringify(data));
    })

    if ( delBtn == true ) {
    this.data.splice(x,1);
    }
  }  

  addCustomer(x)
  {
    var delBtn = confirm(" Do you want to create account ?");
    this.r=this.r=this.data[x].serviceRefNo;
   // alert(this.r);
    this.service.addCustomer(this.r).subscribe(data=>{
      this.data1=data;
    //  alert(JSON.stringify(data));
    })
    
    if ( delBtn == true ) {
      this.data.splice(x,1);
    }
  }
}
