// function sayHello() {
//     var uname = document.getElementById("username").value;
//     document.getElementById("welcomeMessage").innerHTML = "Hello " + uname;
// }

// function validateMobile() {
//     var mobile = document.getElementById("mobile").value;
//     if (isNaN(event.key) || mobile.length>9)
//         event.preventDefault();
//     else if (mobile.length != 9) {
//         document.getElementById("mbError").style.display = "block";
//     }
//     else 
//         document.getElementById("mbError").style.display = "none";

// }

// function checkMobile() {
//     var mobile = document.getElementById("mobile").value;
//     var pattern = /^\d{10}$/;
//     if (!pattern.test(mobile)) {
//         document.getElementById("mbError").style.display = "block";
//         return false;
//     }
//     else {
//         document.getElementById("mbError").style.display = "none";
//         return true;
//     }
// }

// function checkEmail() {
//     var email = document.getElementById("email").value;
//     var pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{1,3})+$/;
//     if (!pattern.test(email)) {
//         document.getElementById("emError").style.display = "block";
//         return false;
//     }
//     else {
//         document.getElementById("emError").style.display = "none";
//         return true;
//     }
// }

// function checkPassword() {
//     var password = document.getElementById("psw").value;
//     var pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*]).{8,14}$/;
//     if (!pattern.test(password)) {
//         document.getElementById("pswError").style.display = "block";
//         return false;
//     }
//     else {
//         document.getElementById("pswError").style.display = "none";
//         return true;
//     }
// }

// function checkForm() {
//     var formError = document.getElementById("formError");
//     if (!checkPassword()) {
//         formError.innerHTML = "Incorrect Password";
//         formError.style.display = "block";
//         return false;
//     }
//     else if (!checkEmail()) {
//         formError.innerHTML = "Incorrect Email Id";
//         formError.style.display = "block";
//         return false;
//     }
//     else if (!checkMobile()) {
//         formError.innerHTML = "Incorrect Mobile";
//         console.log(document.getElementById("mobile").value);
//         console.log(document.getElementById("mobile").value.length);
//         formError.style.display = "block";
//         return false;
//     }
//     return true;
// }




// function validate1(){
//     if(isNaN(event.key)){
//  event.preventDefault();
//     }
// }



const slidePage = document.querySelector(".slide-page");
const nextBtnFirst = document.querySelector(".firstNext");
const prevBtnSec = document.querySelector(".prev-1");
const nextBtnSec = document.querySelector(".next-1");
const prevBtnThird = document.querySelector(".prev-2");
const submitBtn = document.querySelector(".submit");
const progressText = [...document.querySelectorAll(".step p")];
const progressCheck = [...document.querySelectorAll(".step .check")];
const bullet = [...document.querySelectorAll(".step .bullet")];
let max = 4;
let current = 1;

nextBtnFirst.addEventListener("click", function(){
  slidePage.style.marginLeft = "-25%";
  bullet[current - 1].classList.add("active");
  progressCheck[current - 1].classList.add("active");
  progressText[current - 1].classList.add("active");
  current += 1;
});
nextBtnSec.addEventListener("click", function(){
  slidePage.style.marginLeft = "-50%";
  bullet[current - 1].classList.add("active");
  progressCheck[current - 1].classList.add("active");
  progressText[current - 1].classList.add("active");
  current += 1;
});
nextBtnThird.addEventListener("click", function(){
  slidePage.style.marginLeft = "-75%";
  bullet[current - 1].classList.add("active");
  progressCheck[current - 1].classList.add("active");
  progressText[current - 1].classList.add("active");
  current += 1;
});
submitBtn.addEventListener("click", function(){
  bullet[current - 1].classList.add("active");
  progressCheck[current - 1].classList.add("active");
  progressText[current - 1].classList.add("active");
  current += 1;
  setTimeout(function(){
    alert("Your Form Successfully Signed up");
    location.reload();
  },800);
});

prevBtnSec.addEventListener("click", function(){
  slidePage.style.marginLeft = "0%";
  bullet[current - 2].classList.remove("active");
  progressCheck[current - 2].classList.remove("active");
  progressText[current - 2].classList.remove("active");
  current -= 1;
});
prevBtnThird.addEventListener("click", function(){
  slidePage.style.marginLeft = "-25%";
  bullet[current - 2].classList.remove("active");
  progressCheck[current - 2].classList.remove("active");
  progressText[current - 2].classList.remove("active");
  current -= 1;
});
prevBtnFourth.addEventListener("click", function(){
  slidePage.style.marginLeft = "-50%";
  bullet[current - 2].classList.remove("active");
  progressCheck[current - 2].classList.remove("active");
  progressText[current - 2].classList.remove("active");
  current -= 1;
});


      var slideIndex = 0;

function showSlides() {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  for (i = 0; i < 3; i++) {
    slides[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}    
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
  setTimeout(showSlides, 4000); // Change image every 2 seconds
}
showSlides();