const leftArea = document.getElementById('left-area')
const rightArea = document.getElementById('right-area')
const translateBtn = document.getElementById('translate-btn')
const clearBtn = document.getElementById('clear-btn')
const leftCopyBtn = document.getElementById('left-copy')
const rightCopyBtn = document.getElementById('right-copy')
const alertMsg = document.getElementById('alert')
const leftMicro = document.getElementById('left-micro')
const rightMicro = document.getElementById('right-micro')
let speech = new SpeechSynthesisUtterance()


translateBtn.addEventListener('click', () => {
    const translateTo = document.getElementById('translate-to')
    const translateFrom = document.getElementById('translate-from')
    if (leftArea.value == "") {
        alert("Textarea is empty")
    } else {
        if(translateFrom.value===translateTo.value){
            alert("Same language in both")
        }else{
            translate(leftArea.value, translateFrom.value, translateTo.value)
        }
        
    }
})

const translate = async (word, translateFrom, translateTo) => {
    const res = await fetch(`https://api.mymemory.translated.net/get?q=${word}&langpair=${translateFrom}|${translateTo}`)
    const data = await res.json()

    rightArea.value = data.responseData.translatedText
}


clearBtn.addEventListener('click', () => {
    leftArea.value = ""
    rightArea.value = ""
})

leftCopyBtn.addEventListener('click',()=>{
    if(leftArea.value==""){
        alertMsg.innerHTML = "textarea is empty"
    }else{
        navigator.clipboard.writeText(leftArea.value);
        alertMsg.innerHTML = "text Copied"
    }
    hideAlert()
})

rightCopyBtn.addEventListener('click',()=>{
    if(rightArea.value==""){
        alertMsg.innerHTML = "textarea is empty !!"

    }else{
        navigator.clipboard.writeText(rightArea.value);
        alertMsg.innerHTML = "text Copied."
    }
    hideAlert()
})

const hideAlert = () =>{
    setTimeout(()=>{
        alertMsg.innerHTML=""
    },1500);
}

leftMicro.addEventListener('click',()=>{
    if(leftArea.value==""){
        alertMsg.innerHTML ="Noting to speak"
        hideAlert()
    }else{
        speech.text = leftArea.value;
        window.speechSynthesis.speak(speech)
    }
})

rightMicro.addEventListener('click',()=>{
    if(rightArea.value==""){
        alertMsg.innerHTML ="Noting to speak"
        hideAlert()
    }else{
        speech.text = rightArea.value;
        window.speechSynthesis.speak(speech)
    }
})