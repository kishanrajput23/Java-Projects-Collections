#include <iostream>
#include <stack>
using namespace std;
bool isBalanced(string exp) {
   stack<char> stack;
   char x;
   for (int i=0; i<exp.length(); i++) {
      if (exp[i]=='('||exp[i]=='['||exp[i]=='{') {
         stack.push(exp[i]);
         continue;
      }
      if (stack.empty())
         return false;
      switch (exp[i]) {
      case ')':
         x = stack.top();
         stack.pop();
         if (x=='{' || x=='[')
            return false;
         break;
      case '}':
         x = stack.top();
         stack.pop();
         if (x=='(' || x=='[')
            return false;
         break;
      case ']':
         x = stack.top();
         stack.pop();
         if (x =='(' || x == '{')
            return false;
         break;
      }
   }
   return (stack.empty());
}
int main() {
   cout << "Enter An Expression" << endl;
   string expresion;
   cin >> expresion;
   if (isBalanced(expresion))
      cout << "Valid Expression";
   else
      cout << "Not Valid Expression";
}
