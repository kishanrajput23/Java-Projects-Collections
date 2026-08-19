// Initialize game variables
var timer = 60; // Total game time in seconds
var score = 0; // Player's score
var hit = 0; // Target number to hit
var bubbleNumbers = []; // Array to hold numbers for bubble generation

// Function to create bubbles with all numbers 0 to 9
function bubbleMaker() {
    var clut = "";

    // Create an array of numbers from 0 to 9
    bubbleNumbers = Array.from({ length: 10 }, (_, i) => i);

    // Generate 200 bubbles
    for (var i = 0; i < 200; i++) {
        // Reset bubbleNumbers if all numbers have been used
        if (bubbleNumbers.length === 0) {
            bubbleNumbers = Array.from({ length: 10 }, (_, i) => i);
        }

        // Select a random number from bubbleNumbers and remove it
        const randomIndex = Math.floor(Math.random() * bubbleNumbers.length);
        const num = bubbleNumbers.splice(randomIndex, 1)[0];

        // Generate random left and top positions (0-90% and 0-80%)
        const left = Math.random() * 90;
        const top = Math.random() * 80;

        // Create the bubble element with a number and style
        clut += `<div class="bubble" style="left:${left}%; top:${top}%;">${num}</div>`;
    }

    // Display the bubbles in the game area
    document.querySelector('#pbtm').innerHTML = clut;
}

// Function to set and update the game timer
function setTimer() {
    var time = setInterval(function () {
        if (timer > 0) {
            timer--;
            document.querySelector("#timer").textContent = timer;
        } else {
            clearInterval(time);
            document.querySelector("#pbtm").innerHTML = " ";
            document.querySelector("#pbtm").innerHTML = `<h1> Game Over! </h1><Button>Restart</Button>`;
            document.querySelector("#pbtm Button").addEventListener("click", restartGame);
        }
    }, 1000);
}

// Function to set the target number to hit
function hitVAl() {
    hit = Math.floor(Math.random() * 10);
    document.querySelector("#hit").textContent = hit;
}

// Function to update the player's score
function scoreVAl() {
    score += 10;
    document.querySelector("#score").textContent = score;
}

// Function to restart the game
function restartGame() {
    document.querySelector("#pbtm").innerHTML = "";
    timer = 60; // Reset the timer
    score = 0; // Reset the score
    hit = 0; // Reset the target number
    hitVAl(); // Set a new target number
    setTimer(); // Start the timer
    bubbleMaker(); // Generate new bubbles
}

// Event listener for clicking on bubbles
document.querySelector("#pbtm").addEventListener("click", function (dets) {
    var clickNum = Number(dets.target.textContent);
    if (hit == clickNum) {
        scoreVAl(); // Increase the score if the clicked number matches the target
        hitVAl(); // Set a new target number
        bubbleMaker(); // Generate new bubbles
    }
});

// Initialize the game
hitVAl(); // Set the initial target number
setTimer(); // Start the timer
bubbleMaker(); // Generate initial bubbles