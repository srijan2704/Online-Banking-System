import { Component, OnInit } from '@angular/core';
import {ContactRequestServiceService} from '../contact-request.service'
import { ContactId } from "../contact-request/ContactId";


@Component({
  selector: 'app-contact-request',
  templateUrl: './contact-request.component.html',
  styleUrls: ['./contact-request.component.css']
})
export class ContactRequestComponent implements OnInit {

  constructor(private service:ContactRequestServiceService) { }

  data:any;
  contactId=new ContactId();

  viewContacts(){
    this.service.getContacts().subscribe(data=>{
      this.data=data;
        })
      }


      contact(x){
        
        this.contactId=this.data[x].contactId;
        alert(this.contactId);
        this.service.updateStatus(this.contactId)
      }
  ngOnInit(): void {
  }

}
