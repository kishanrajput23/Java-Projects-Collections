/*
PROBLEM

    You will be given a string of characters containing only the following characters: "(", ")", ":"
    Create a function that returns a number based on the number of sad and happy smiley faces there is.
        * The happy faces :) and (: are worth 1.
        * The sad faces :( and ): are worth -1.
        * Invalid faces are worth 0.
    EXPLANATION :
            happinessNumber(":):(") ➞ -1
                The first 2 characters are :)        +1      Total: 1
                The next 2 are ):                    -1      Total: 0
                The last 2 are :(                    -1      Total: -1
*/

function happinessNumber(smilies) {
    let arr = smilies.split('');
    let count = 0;
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] + arr[i + 1] == ':)') count += 1;

        if (arr[i] + arr[i + 1] == '(:') count += 1;

        if (arr[i] + arr[i + 1] == '):') count -= 1;

        if (arr[i] + arr[i + 1] == ':(') count -= 1;
    }
    return count;
}

// console.log(happinessNumber(":):(")) // -1
// console.log(happinessNumber("(:)"))  //  2
// console.log(happinessNumber("::::")) //  0
// console.log(happinessNumber("(:):(:)(?):(:))")) // ?=>false
