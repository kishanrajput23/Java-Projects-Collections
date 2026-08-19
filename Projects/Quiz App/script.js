const questions = [
    {
        question: "What is the capital of France?",
        options: ["London", "Berlin", "Paris", "Madrid"],
        answer: "Paris"
    },
    {
        question: "Which programming language is known for its use in web development?",
        options: ["Java", "Python", "JavaScript", "C++"],
        answer: "JavaScript"
    },
    {
        question: "What is the result of 2 + 2?",
        options: ["3", "4", "5", "6"],
        answer: "4"
    },
    {
        question: "What does HTML stand for?",
        options: ["Hyper Text Markup Language", "High-Level Text Machine Language", "Hyperlink and Text Markup Language", "Home Tool Markup Language"],
        answer: "Hyper Text Markup Language"
    }
];


const nextBtn = document.getElementById('next-btn')
const quizContainer = document.getElementById('quiz-container')
const options = document.getElementById('options').querySelectorAll('.btn');
const question = document.getElementById('question')
let score = 0;
let index = 0;
let answer;


const loadQuestion = () => {
    nextBtn.setAttribute('disabled','true')
    if (index > 0) {
        resetAnswer()
    }
    question.innerHTML = `${index + 1}. ${questions[index].question}`
    options.forEach((option, i) => {
        option.textContent = questions[index].options[i];
        option.addEventListener('click', () => {

            nextBtn.removeAttribute('disabled')
            resetAnswer()
            option.classList.replace('btn-primary', 'btn-dark')
            answer = option.textContent
        })
    })
}

nextBtn.addEventListener('click', () => {

    checkAnswer()
    index++;
    if (index < questions.length) {
        loadQuestion()
    } else {
        endQuiz()
    }

})

const endQuiz = () => {
    quizContainer.innerHTML = `
    <h1>Your Score is ${score}/${questions.length}.</h1>
    <button class="btn btn-success mt-3" onclick="window.location.reload()">Play Again</button>
    `
}

const checkAnswer = () => {
    if (answer == questions[index].answer) {
        score++;
    }

}

const resetAnswer = () => {
    options.forEach((option) => {
        if (option.classList.contains('btn-dark')) {
            option.classList.replace('btn-dark', 'btn-primary')
        }
    })

}
loadQuestion()