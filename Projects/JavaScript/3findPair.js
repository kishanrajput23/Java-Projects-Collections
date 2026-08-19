// Find a pair with the given sum in an array
// Given an unsorted integer array, find a pair with the given sum in it.
/* For example,
Input:
nums = [8, 7, 2, 5, 3, 1]
target = 10
Output:
Pair found (8, 2)
or
Pair found (7, 3)
========================
Input:
nums  [5, 2, 6, 8, 1, 9]
target = 12
Output: Pair not found
*/          
let nums = [8, 7, 2, 5, 3, 1],
target = 10  
let ans = [];          
function findPair(nums, target) {
    for(let i =0; i<nums.length; i++){
        for(let j =i; j<nums.length; j++){
            if(nums[i] + nums[j] === target)
            ans.push(nums[i], nums[j])
        }
        return ans
    }
    return "Pair not found"
    
}
console.log(findPair(nums,target));