
let slideIndex=1;
showSlide(slideIndex);


setInterval(function() {
    moveSlideShow(1);
}, 5000);

function moveSlideShow(n){

    showSlide(slideIndex+=n);


}

function currentSlide(n) {
    showSlide(slideIndex = n);
  }

function showSlide(n){

let i;
let x= document.getElementsByClassName("slide-fade");
let nav= document.getElementsByClassName("nav-item");

if(n>x.length){slideIndex=1}
if(n<1){slideIndex=x.length}

for(i=0; i<x.length; i++){
    x[i].style.display="none";
}

for (i = 0; i < nav.length; i++) {
    nav[i].className = nav[i].className.replace(" navActive", "");
  }


x[slideIndex - 1].style.display="block";

nav[slideIndex-1].className += " navActive";



}


document.querySelectorAll('.nav-item').forEach(item => {
  item.addEventListener('keydown', event => {
      if (event.key === 'Enter' || event.key === ' ') {
          item.click();
      }
  });
});