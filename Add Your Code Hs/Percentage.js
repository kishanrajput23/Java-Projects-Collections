function calculatePercentage() {
    // Get input values
    var number = parseFloat(document.getElementById("number").value);
    var percentage = parseFloat(document.getElementById("percentage").value);

    // Calculate the result
    var result = (number * percentage) / 100;

    // Display the result
    document.getElementById("result").innerHTML = percentage + "% of " + number + " is " + result;
}
