// Print all divisors eff

// Time -> ()
// Space -> O(1)

#include <bits/stdc++.h>
#include <iostream>
using namespace std;

void divisor(int n)
{
    for (int i = 1; i <= sqrt(n); i++)
    {
        if (n % i == 0)
        {
            cout << i << " ";
        }
        if (i != n / i)
        {
            cout << n / i << " ";
        }
    }
}

int main()
{
    int a;
    cin >> a;
    divisor(a);
    return 0;
}