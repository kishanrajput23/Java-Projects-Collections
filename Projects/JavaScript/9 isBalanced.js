
/*
        Given an expression string exp, write a program to examine whether the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct or not.
        return either true or false
 */
// 1

function isBalanced(str){
    // write your code here ...
    let arr = [];
    for(let i = 0; i < str.length; i++) {
        if(str[i] == '[' || str[i] == '(' || str[i] == '{' ) {     
            arr.push(str[i]);
        }
        else if (arr.length != 0 && str[i] === '}' && arr[arr.length - 1] === "{") {
            arr.pop()
        }
        else if (arr.length != 0 && str[i] === ')' && arr[arr.length - 1] === "(") {
            arr.pop()
        }
        else if (arr.length != 0 && str[i] === ']' && arr[arr.length - 1] === "[") {
            arr.pop()
        } 
        else {
            return false;
        }
    }
    return arr.length ==0 ;
    
}

//2

// function isBalanced(s) {
//     let arr = [];
//     for (let c of s){
//         if (c == '(' || c == '{' || c == '[') {
//             arr.push(c);
//         }
//         else if (arr.length != 0 && c === '}' && arr[arr.length - 1] === "{") {
//             arr.pop()
//         }
//         else if (arr.length != 0 && c === ')' && arr[arr.length - 1] === "(") {
//             arr.pop()
//         }
//         else if (arr.length != 0 && c === ']' && arr[arr.length - 1] === "[") {
//             arr.pop()
//         } else {
//             return false;
//         }
//     }
//     return true;
// };

//3
// function isBalanced(s) {
//     let arr = [];
//     for (let c of s){
//             if(c==='('|| c==='['|| c==='{'){
//                 arr.push(c);
//             }
//             else{
//                 switch(c){
//                     case ')':
//                         if(arr.length !=0 && arr[arr.length-1] == '(') arr.pop(); 
//                         break;
//                     case ']':
//                         if(arr.length !=0 && arr[arr.length-1] == '[') arr.pop(); 
//                         break;
//                     case '}':
//                         if(arr.length !=0 && arr[arr.length-1] == '{') arr.pop(); 
//                         break;
//                 }
//             }
//         }
//     if(arr.length == 0) return true;
//     return false;
// };


console.log(isBalanced('[()]{}{[()()]()}')) // true
console.log(isBalanced('[(])')) // false
console.log(isBalanced('[({}])')) // fasle
console.log(isBalanced('[]{}()')) // true
console.log(isBalanced('[(){()}{}]')) // true
console.log(isBalanced('[[[')) // true

