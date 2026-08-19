/*
PROBLEM - 3
find positive Cumulative Sum of Array.
The cumulative sum of an array at index i is defined as the sum of all elements of the array from index 0 to index i.

NOTE: if possible try to use map and reduce

EXAMPLES ::
Initial Array: [1, 3, 5, 7]           => Cumulative Sum: [1, 4, 9, 16]       => Positive Cumulative Sum: [1, 4, 9, 16]
Initial Array: [1, -2, 3, 4, -6]      => Cumulative Sum: [1, -1, 2, 6, 0]    => Positive Cumulative Sum: [1, 2, 6]
Initial Array: [1, -1, -1, -1, 1]     => Cumulative Sum: [1, 0, -1, -2, -1]  => Positive Cumulative Sum: [1]
*/


// solution 1 :- using for loop

function getPositiveCumulativeSum(arr) {
    //Cumulative Sum 
    let sum = 0;
    let ans = [];
    for (let i = 0; i < arr.length; i++) {
        sum += arr[i]
        ans.push(sum);
    }
    return ans.filter(e => e > 0)

}
console.log(getPositiveCumulativeSum([1, -2, 3, 4, -6]))
console.log(getPositiveCumulativeSum([1, 3, 5, 7]))
console.log(getPositiveCumulativeSum([1, -1, -1, -1, 1]))


// solution 2;- using reduce mathod

// function getPositiveCumulativeSum(arr = []){
//     return arr.reduce((p,c) => (!p.length ? [c] : [...p, c+p[p.length-1]]), []).filter((x) => x >0);
// }
// console.log(getPositiveCumulativeSum([1, 3, 5, 7] ))