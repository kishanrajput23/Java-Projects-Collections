const btnCheck = document.getElementById('btn-check')
const input = document.getElementById('input')
const alertPara = document.getElementById('alert-para')
const newBtn = document.getElementById('new')
const count = document.getElementById('count')
const inputs = document.getElementById('inputs')
let total=0;
let pcGuess = Math.floor(Math.random()*100)+1

const quit = document.getElementById('quit')



btnCheck.addEventListener('click',()=>{

    let inputValue = Number(input.value)
    quit.style.display="block"
    if(input.value==""){
        alert("Input field is empty")
    }else{
        
        if(inputValue <= 0){
            alert("Number should greater than 0")
        }else if(inputValue >= 100){
            alert("Number should less than 100")
        }else{

            if(inputValue == pcGuess){
                total++
                count.innerHTML=total
                alertPara.classList.add('text-success')
                alertPara.innerHTML = "Congrats You guessed the correct number."
               
                btnCheck.disabled="true"
                newBtn.style.display="block"
                inputs.innerHTML += inputValue + " ";
                quit.style.display="none"
                

            }else if(inputValue>pcGuess){
                total++
                count.innerHTML=total
                alertPara.innerHTML = "Too High ! Guess Again."
               
                inputs.innerHTML += inputValue + " ";
                setTimeout(()=>{
                    alertPara.innerHTML = ""
                },3000)
                input.value=""
            }else{
                total++
                count.innerHTML=total
                alertPara.innerHTML = "Too Low ! Guess Again."
                
                inputs.innerHTML += inputValue + " ";
                setTimeout(()=>{
                    alertPara.innerHTML = ""
                },3000)
                input.value=""
            }
        }
    }
     
})

newBtn.addEventListener('click',()=>{
    window.location.reload()
})


function quitGame(btn){
   
    alertPara.innerHTML = "The Correct Number is " + pcGuess+"."
    btn.style.display="none"
    btnCheck.disabled="true"
    newBtn.style.display="block"

}
