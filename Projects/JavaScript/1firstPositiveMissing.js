/**
 * @param {number[]} nums
 * @return {number}
 */
 var firstMissingPositive = function(nums) {
    let ans = nums.filter(v => v > 0 ).sort((a, b) => a - b
    )
  
let unique = []; 
  for(let i =0; i< ans.length; i++){
      unique.push(ans[i])
      if(unique[i] === unique[i+1]) unique.pop(ans[i])   
  }
          let j = 0
  while (unique[j] === j+1) {
  j++;
}
return j+1;
};
  
 // Because Set. prototype.has() has a time complexity of just O(1),
  // let uniqueChars = [...new Set(ans)];
//   let j = 0
//   while (uniqueChars[j] === j+1) {
//   j++;
// }
// return j+1;
// };
