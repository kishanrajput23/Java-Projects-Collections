#include <bits/stdc++.h>
#include <iostream>
using namespace std;

int sum(int n){
    int sum = n*(n+1)/2;
    return sum;
}

int sum1(int n){
    int sum = 0;
    for (int i = 1; i <= n; i++)
    {
        sum = sum + i;
    }
    
    return sum;
}

int sumRecursion(int n){
    if(n==0)
        return 0;
    return n + sum(n-1);
}

int main()
{
    int n=5;
    cout<<sum(n);
    cout<<sum1(n);
    cout<<sumRecursion(n);
    return 0;
}