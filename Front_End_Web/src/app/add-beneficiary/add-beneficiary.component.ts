import { Component, OnInit } from '@angular/core';
import { AddBeneficiary } from '../dto-classes/AddBeneficiary';
import {AddBeneficiaryService} from '../add-beneficiary.service';
import { CustomerIdGet } from './CustomerIdGet';
import { GetBeneficiary } from '../dto-classes/getBeneficiaryDetails';

@Component({
  selector: 'app-add-beneficiary',
  templateUrl: './add-beneficiary.component.html',
  styleUrls: ['./add-beneficiary.component.css']
})
export class AddBeneficiaryComponent implements OnInit {
  
  setCustomerId = new CustomerIdGet();
  getBeneficiaryDetails = new GetBeneficiary();
  values:any;
  constructor(private service:AddBeneficiaryService) { 
    this.service.getBeneficiaryList(this.setCustomerId).subscribe(data=>{
      this.values = data;
      console.log(data);
    })
  }

  ngOnInit(): void {
  }

  customerId:number = Number(sessionStorage.getItem("customerId"));
  beneficiaryName:string;
  beneficiaryNickName:string;
  beneficiaryAccountNo:string;
  beneficiary = new AddBeneficiary(this.customerId,this.beneficiaryAccountNo,this.beneficiaryName,this.beneficiaryNickName);
  row:AddBeneficiary[] = [this.beneficiary];
  message:string;
  addTable() {

    this.service.addBeneficiary(this.beneficiary).subscribe(data=>{
      console.log(data.message);
      this.message = data.message;
      console.log(this.message);
      alert(this.message);
      
    }
    )
    var addBtn = confirm("Do you want to add a contact?");
    if (addBtn == true)
    {
      this.isShow=false;
      const obj = {
      customerId:this.beneficiary.customerId,
      beneficiaryName:this.beneficiary.beneficiaryName,
      beneficiaryNickName:this.beneficiary.beneficiaryNickName,
      beneficiaryAccountNo:this.beneficiary.beneficiaryAccountNo
     }
    this.row.push(obj);
    }
  }


  deleteRow(x){
    var delBtn = confirm(" Do you want to delete ?");
    if ( delBtn == true ) {
      this.row.splice(x, 1 );
    }   
  }

  isShow:boolean=false;
  show(){
    this.isShow=true;
  }

  hide(){
    this.isShow=false;
  }
}
