// Check number is palindrome or not

// Time -> O(n) Big-oh
// Space -> O(1)
#include <iostream>
using namespace std;

int reverse(int n)
{
    int num = 0;
    int rev = 0;
    while (n != 0)
    {
        num = n % 10;
        rev = rev * 10 + num;
        n = n / 10;
    }
    return rev;
}

int main()
{
    int n;
    cin >> n;
    int x = n;
    int y = reverse(n);
    if (x == y)
    {
        cout << "Palindrome" << endl;
    }
    else
    {
        cout << "False" << endl;
    }
    return 0;
}