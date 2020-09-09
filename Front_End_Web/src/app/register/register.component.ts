import { Component, OnInit } from '@angular/core';
import { VisitorRegister } from "./visitor-register";
import { VisitorServiceService } from "../visitor-service.service";
import * as _ from 'lodash';
import { VisitorStatus } from "../visitor-status/visitor-status";
import { Router } from '@angular/router';
@Component({
  selector: 'app-register',
  templateUrl: `./register.component.html`,
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  visitor = new VisitorRegister();
  genderId: number;
  genderName: string;
  visitorStatus = new VisitorStatus();
  constructor(private VisitorService: VisitorServiceService, private router: Router) {

  }
  text: string;
  update() {
    this.visitor.permanentAddress = this.visitor.localAddress;
    this.visitor.permanentCity = this.visitor.localCity;
    this.visitor.permanentPincode = this.visitor.localPincode;
    this.visitor.permanentState = this.visitor.localState;
    console.log(this.visitor.permanentPincode);
  }
  onSubmit() {
    console.log(this.visitor.aadharNo);
    console.log(this.visitor.phoneNumber);
    console.log(this.visitor.localAddress);
    console.log(this.visitor.permanentCity);
    console.log(this.visitor.sourceOfIncome);
    this.VisitorService.addVisitor(this.visitor).subscribe(data => {
      this.text = data;
    })
  }

  redirect() {
    alert("Hi " + this.visitor.firstName + "!, Thanks for registering. Please Check your email.");
    this.router.navigate(['/homeLink']);
  }

  ngOnInit(): void {


    const slidePage: HTMLInputElement = document.querySelector(".slidepage");
    const firstNextBtn: HTMLInputElement = document.querySelector(".nextBtn")
    const prevBtnSec: HTMLInputElement = document.querySelector(".prev-1");
    const nextBtnSec: HTMLInputElement = document.querySelector(".next-1");

    const prevBtnThird: HTMLInputElement = document.querySelector(".prev-2");
    const submitBtn: HTMLInputElement = document.querySelector(".submit");


    const progressText = (<HTMLScriptElement[]><any>document.querySelectorAll(".step p"));
    const progressCheck = (<HTMLScriptElement[]><any>document.querySelectorAll(".step .check"));
    const bullet = (<HTMLScriptElement[]><any>document.querySelectorAll(".step .bullet"));
    let max = 3;
    let current = 1;


    firstNextBtn.addEventListener("click", function () {
      slidePage.style.marginLeft = "-25%";
      bullet[current - 1].classList.add("active");
      progressCheck[current - 1].classList.add("active");
      progressText[current - 1].classList.add("active");
      current += 1;
    });

    nextBtnSec.addEventListener("click", function () {
      slidePage.style.marginLeft = "-50%";
      bullet[current - 1].classList.add("active");
      progressCheck[current - 1].classList.add("active");
      progressText[current - 1].classList.add("active");
      current += 1;
    });

    prevBtnSec.addEventListener("click", function () {
      slidePage.style.marginLeft = "0%";
      bullet[current - 2].classList.remove("active");
      progressCheck[current - 2].classList.remove("active");
      progressText[current - 2].classList.remove("active");
      current -= 1;

    });
    prevBtnThird.addEventListener("click", function () {
      slidePage.style.marginLeft = "-25%";
      bullet[current - 2].classList.remove("active");
      progressCheck[current - 2].classList.remove("active");
      progressText[current - 2].classList.remove("active");
      current -= 1;
    });

    submitBtn.addEventListener("click", function () {
      bullet[current - 1].classList.add("active");
      progressCheck[current - 1].classList.add("active");
      progressText[current - 1].classList.add("active");
      current += 1;
      setTimeout(function () {
        alert("Your Form Successfully Signed up");
        location.reload();
      }, 800);
    });


    var slideIndex = 0;

    function showSlides() {
      var i;



      var slides = <HTMLElement[]><any>document.getElementsByClassName("mySlides");
      var dots = <HTMLElement[]><any>document.getElementsByClassName("dot");


      for (i = 0; i < 3; i++) {
        slides[i].style.display = "none";
      }
      slideIndex++;
      if (slideIndex > slides.length) { slideIndex = 1 }
      for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
      }
      slides[slideIndex - 1].style.display = "block";
      dots[slideIndex - 1].className += " active";
      setTimeout(showSlides, 4000); // Change image every 2 seconds
    }
    showSlides();
  }


  State = ["Andhra Pradesh",
    "Arunachal Pradesh",
    "Assam",
    "Bihar",
    "Chhattisgarh",
    "Goa",
    "Gujarat",
    "Haryana",
    "Himachal Pradesh",
    "Jammu and Kashmir",
    "Jharkhand",
    "Karnataka",
    "Kerala",
    "Madhya Pradesh",
    "Maharashtra",
    "Manipur",
    "Meghalaya",
    "Mizoram",
    "Nagaland",
    "Odisha",
    "Punjab",
    "Rajasthan",
    "Sikkim",
    "Tamil Nadu",
    "Telangana",
    "Tripura",
    "Uttarakhand",
    "Uttar Pradesh",
    "West Bengal",
    "Andaman and Nicobar Islands",
    "Chandigarh",
    "Dadra and Nagar Haveli",
    "Daman and Diu",
    "Delhi",
    "Lakshadweep",
    "Puducherry"]

  Occupation = ["Bussiness", "Service", "Self", "Management", "Education instruction"]

}
