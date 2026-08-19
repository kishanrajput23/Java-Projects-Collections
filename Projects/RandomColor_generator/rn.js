const getColor = ()=>{
   const randomNumber =Math.floor(Math.random()*16777215) ; 
   const randomCode = "#" + randomNumber.toString(16) ;
   document.body.style.backgroundColor = randomCode ;
   document.getElementById("color-code").innerText = randomCode ;
   navigator.clipboard.writeText(randomCode) //copy the random code on click 
}
//event call
document.getElementById("btnn").addEventListener("click" , getColor)

//init call
getColor();
