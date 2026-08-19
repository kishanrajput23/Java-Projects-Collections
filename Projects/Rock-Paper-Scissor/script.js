var userScore=0;
var compScore=0;
function checker(input){
var choice=["Rock","Paper","Scissor"];
var num=Math.floor(Math.random()*3);
var user=document.getElementById("user");
var comp=document.getElementById("comp");


// var user=0;
// var comp=0;

 document.getElementById("Comp-choice").innerHTML=`Computer chose ${choice[num]}`;
 document.getElementById("user-choice").innerHTML=`You chose ${input}`;

 if(input=='rock' && choice[num]=='Rock'){
     document.getElementById("result").innerHTML=`DRAW`;
     document.getElementById("result").style.color='purple'
 }
 else if(input=='rock' && choice[num]=='Scissor')
 {
     document.getElementById("result").innerHTML=`You WIN`;
     document.getElementById("result").style.color='green';
     userScore++;
     document.getElementById("user").innerHTML=`You :- ${userScore}`;

 }
  else if(input=='rock' && choice[num]=='Paper')
 {
     document.getElementById("result").innerHTML=`You LOOSE`;
     document.getElementById("result").style.color='red';
     compScore++;
     document.getElementById("comp").innerHTML=`Computer :-${compScore}`;
 }




 else if(input=='scissor' && choice[num]=='Scissor'){
     document.getElementById("result").innerHTML=`DRAW`;
     document.getElementById("result").style.color='purple'
 }
 else if(input=='scissor' && choice[num]=='Paper')
 {
     document.getElementById("result").innerHTML=`You WIN`;
     document.getElementById("result").style.color='green';
     userScore++;
     document.getElementById("user").innerHTML=`You :- ${userScore}`;
 }
 else if(input=='scissor' && choice[num]=='Rock')
 {
     document.getElementById("result").innerHTML=`You LOOSE`;
     document.getElementById("result").style.color='red';
     compScore++;
     document.getElementById("comp").innerHTML=`Computer :-${compScore}`;
 }




else if(input=='paper' && choice[num]=='Paper'){
     document.getElementById("result").innerHTML=`DRAW`;
     document.getElementById("result").style.color='purple'
 }
 else if(input=='paper' && choice[num]=='Rock')
 {
     document.getElementById("result").innerHTML=`You WIN`;
     document.getElementById("result").style.color='green';
     userScore++;
    document.getElementById("user").innerHTML=`You :- ${userScore}`;
 }
 else if(input=='paper' && choice[num]=='Scissor')
 {
     document.getElementById("result").innerHTML=`You LOOSE`;
     document.getElementById("result").style.color='red';
     compScore++;
     document.getElementById("comp").innerHTML=`Computer :-${compScore}`;
 }

}