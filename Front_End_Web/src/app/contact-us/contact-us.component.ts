import { Component, OnInit } from '@angular/core';
import { Contact} from './ContactUs'
import {ContactRequestServiceService} from '../contact-request.service';
import {Router} from '@angular/router';
@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css']
})
export class ContactUsComponent implements OnInit {

  constructor(private contactService:ContactRequestServiceService,private router:Router) { }

  ngOnInit(): void {
  }
 
  contact = new Contact();
  name:string;
  onSubmitContact()
  {
    console.log(this.contact.firstName);
    console.log(this.contact.lastName);
    console.log(this.contact.place);
    console.log(this.contact.subject);
    console.log(this.contact.status);
    this.contactService.addContact(this.contact).subscribe(data=>{
      alert(JSON.stringify(data));
    
    })
    this.popUp();
  }

  popUp()
  {
    alert("Hi "+this.contact.firstName+" We will contact you. Thank you!");
    this.router.navigate(['/homeLink']);
  }
}
