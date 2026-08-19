/*
PROBLEM - 1
   An isogram is a word that has no duplicate letters.
   Create a function that takes a string and returns either true or false depending on whether or not it's an "isogram".

   NOTES : Ignore letter case (should not be case sensitive).
*/
//==========  using for loop


function isIsogram(word) {
    let str = word.toUpperCase();
    let ans = str.split('').sort();
    for (var i = 0; i <= ans.length; i++) {
        if (ans[i - 1] == ans[i]) {
            return false;
        }
    }
    return true;
}

// second using set

function isIsogram(word) {
    let iso = new Set([...word]);
    return iso.size === word.length;
    //     // return iso;
    //     // Set(8) { 'A', 'L', 'G', 'O', 'R', 'I', 'S', 'M' }
    //     // Set(7) { 'P', 'A', 'S', 'W', 'O', 'R', 'D' }
    //     // Set(9) { 'C', 'O', 'N', 'S', 'E', 'U', 'T', 'I', 'V' }
}

// third solution

function isIsogram(word) {
    const obj = {};
    for (let char of word) {
        const ascii = char.charCodeAt(0);
        if (ascii > 90) char = String.fromCharCode(ascii - 32);
        obj[char] > 0 ? (obj[char] += 1) : (obj[char] = 1);
        if (obj[char] > 1) return false;
    }
    return true;
}

console.log(isIsogram("Algorism"));      // true
console.log(isIsogram("PasSword"));      // false
console.log(isIsogram("Consecutive"));   // false


