const userScore = document.getElementById('user-score');
const cpuScore = document.getElementById('cpu-score');
const userSelect = document.getElementById('user-select')
const cpuSelect = document.getElementById('cpu-select')
const result = document.getElementById('winner')
const snakeBtn = document.getElementById('snake-btn')
const waterBtn = document.getElementById('water-btn')
const gunBtn = document.getElementById('gun-btn')
const reset = document.getElementById('reset')
let userCount =0;
let cpuCount=0;

let user;
const arr = ["snake", "water", "gun"]

let index;
 let cpu;

snakeBtn.addEventListener('click',()=>{
  index = Math.floor(Math.random() * 3)
  cpu=arr[index];
userSelect.innerHTML="snake"
cpuSelect.innerHTML=cpu
user="snake"

winner(user,cpu)

})
waterBtn.addEventListener('click',()=>{
  index = Math.floor(Math.random() * 3)
  cpu=arr[index];
  userSelect.innerHTML="water"
  cpuSelect.innerHTML=cpu
  user="water"
  
  winner(user,cpu)
})
gunBtn.addEventListener('click',()=>{
  index = Math.floor(Math.random() * 3)
  cpu=arr[index];
  userSelect.innerHTML="gun"
  cpuSelect.innerHTML=cpu
  user="gun"
  
  winner(user,cpu)
})



const winner = (user,cpu) => {
 

  if (user === cpu) {
    result.innerHTML="Nobody"
    
  } else if (user === "snake" && cpu === "water") {
    result.innerHTML="User"
    userCount++;

  } else if (user === "snake" && cpu === "gun") {
    result.innerHTML="cpu"
    cpuCount++
  } else if (user === "water" && cpu === "snake") {
    result.innerHTML="cpu"
    cpuCount++
  } else if (user === "water" && cpu === "gun") {
    result.innerHTML="user"
    userCount++
  } else if (user === "gun" && cpu === "snake") {
    result.innerHTML="user"
    userCount++
    
  } else if (user === "gun" && cpu == "water") {
    result.innerHTML="cpu"
    cpuCount++
  } else {
    result.innerHTML="Sorry some error !"
  }
  userScore.innerHTML = userCount;
  cpuScore.innerHTML = cpuCount;
}




reset.addEventListener('click',()=>{
 userCount=0
 cpuCount=0
 userScore.innerHTML = userCount;
  cpuScore.innerHTML = cpuCount;

})