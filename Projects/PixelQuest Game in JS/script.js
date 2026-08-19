const canvas = document.getElementById("gameCanvas");
const ctx = canvas.getContext("2d");

// Player character
const player = {
    x: 50,
    y: canvas.height - 30,
    width: 20,
    height: 20,
    speed: 5,
};

// Game loop
function gameLoop() {
    // Clear the canvas
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    // Draw the player character
    ctx.fillStyle = "blue";
    ctx.fillRect(player.x, player.y, player.width, player.height);

    // Move the player
    if (rightPressed && player.x < canvas.width - player.width) {
        player.x += player.speed;
    }
    if (leftPressed && player.x > 0) {
        player.x -= player.speed;
    }

    requestAnimationFrame(gameLoop);
}

// Keyboard input
let rightPressed = false;
let leftPressed = false;

document.addEventListener("keydown", keyDownHandler);
document.addEventListener("keyup", keyUpHandler);

function keyDownHandler(e) {
    if (e.key === "Right" || e.key === "ArrowRight") {
        rightPressed = true;
    }
    if (e.key === "Left" || e.key === "ArrowLeft") {
        leftPressed = true;
    }
}

function keyUpHandler(e) {
    if (e.key === "Right" || e.key === "ArrowRight") {
        rightPressed = false;
    }
    if (e.key === "Left" || e.key === "ArrowLeft") {
        leftPressed = false;
    }
}

// Start the game loop
gameLoop();
