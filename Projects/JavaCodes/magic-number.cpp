#include <iostream>
using namespace std;
int isMagicNumber(int n) {
   int digit_sum = 0;
   while (n > 0 || digit_sum > 9) {
      if (n == 0) {
         n = digit_sum;
         digit_sum = 0;
      }
      digit_sum += n % 10;
      n /= 10;
   }
   return (digit_sum == 1);
}
int main() {
   int number = 50311;
   if(isMagicNumber(number)){
      cout << number << " is magic number";
   } else {
      cout << number << " is not magic number";
   }
}
