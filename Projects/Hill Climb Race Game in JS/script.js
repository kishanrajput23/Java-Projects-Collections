document.addEventListener('DOMContentLoaded', () => {
    const car = document.getElementById('car');
    let carPosition = 20; // Initial car position
    let speed = 5; // Initial speed

    function moveCar() {
        carPosition += speed;
        car.style.left = carPosition + 'px';

        // Reverse direction if the car reaches the edge of the screen
        if (carPosition >= 360 || carPosition <= 0) {
            speed = -speed;
        }
    }

    setInterval(moveCar, 100); // Move the car every 100 milliseconds
});
