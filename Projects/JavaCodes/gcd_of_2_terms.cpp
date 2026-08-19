// GCD of 2 numbers eff using Euclidean's Theorem

// Time ->
// Space -> O(1)

#include <bits/stdc++.h>
#include <iostream>
using namespace std;

int gcd(int a, int b)
{
    if (b == 0)
    {
        return a;
    }
    else
    {
        return gcd(b, a % b);
    }
}

int main()
{
    int a, b;
    cin >> a >> b;
    cout << gcd(a, b);
    return 0;
}