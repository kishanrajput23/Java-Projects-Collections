/*
PROBLEM - 2
    Parity bits are used as very simple checksum to ensure that binary data isn't corrupted during transit. Here's how they work:

    If a binary string has an odd number of 1's, the parity bit is a 1.
    If a binary string has an even number of 1's, the parity bit is a 0.
    The parity bit is appended to the end of the binary string.

    Create a function 'validateBinary' that validates whether a binary string is valid, using parity bits.

    Explanation:
        validateBinary("10110010") ➞ true

        The last digit is the parity bit.
        0 is the last digit.
        0 means that there should be an even number of 1's.
        There are four 1's.
        Return true.

*/
// uisng 2 for loop
function validateBinary(bits) {
    if (bits.charAt(bits.length - 1) == 0) {
        let ans = bits.split('');
        let count = 0;
        for (let i = 0; i < ans.length - 1; i++) {
            if (ans[i] == 1) count++;
        }
        return count % 2 == 0;
    }
    if (bits.charAt(bits.length - 1) == 1) {
        let ans = bits.split('');
        let count = 0;
        for (let i = 0; i < ans.length - 1; i++) {
            if (ans[i] == 1) count++;
        }
        return count % 2 != 0;
    }
}

// second

function validateBinary(bits) {
    let ans = bits.split("");
    let count = 0;
    for (let i = 0; i < ans.length - 1; i++) {
        if (ans[i] == 1) count++;
    } if (bits.charAt(bits.length - 1) == 0) {
        return count % 2 == 0;
    } else {
        return count % 2 != 0;
    }
}

// third solution

function validateBinary(bits) {
    let count = 0;
    for (let i = 0; i < bits.length - 1; i++) {
        if (bits[i] == 1) count++;
    } if (bits[bits.length - 1] == 0) {
        return count % 2 == 0;
    } else {
        return count % 2 != 0;
    }
}
// fourth

function validateBinary(bits) {
    return Array.from(bits).filter((x) => x == 1).length % 2 == 0;
}



console.log(validateBinary("00111101")) // true
console.log(validateBinary("00101101")) // true
console.log(validateBinary("11000000")) // true
console.log(validateBinary("11000001")) // false
