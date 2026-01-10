function calculateCompoundInterest() {
    // Get input values
    var principal = parseFloat(document.getElementById("principal").value);
    var annualRate = parseFloat(document.getElementById("annualRate").value);
    var compoundingFrequency = parseInt(document.getElementById("compoundingFrequency").value);
    var years = parseInt(document.getElementById("years").value);

    // Calculate compound interest
    var amount = principal * Math.pow(1 + (annualRate / compoundingFrequency), compoundingFrequency * years);

    // Round the result to two decimal places
    amount = Math.round(amount * 100) / 100;

    // Display the result
    document.getElementById("result").innerHTML = "The final amount after " + years + " years is: $" + amount;
}
