#include <bits/stdc++.h>
using namespace std;

const int N = 1e5 + 5;
vector<int> tree(N);

// return sum of arr[1...idx];
int read(int idx)
{
    int sum = 0;
    while (idx)
    {
        sum += tree[idx];
        idx -= (idx & -idx);
    }
    return sum;
}

// add=newvalue-oldvalue;
void update(int idx, int add)
{
    while (idx < N)
    {
        tree[idx] += add;
        idx += (idx & -idx);
    }
}

int main()
{
    int n;
    cin >> n;
    vector<int> arr(n), temp(n);

    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    temp = arr;
    sort(temp.begin(), temp.end());

    for (int i = 0; i < n; i++)
    {
        arr[i] = lower_bound(temp.begin(), temp.end(), arr[i]) - temp.begin() + 1;
    }

    int inv = 0;
    for (int i = n - 1; i >= 0; i--)
    {
        inv += read(arr[i] - 1);
        update(arr[i], 1);
    }

    cout << inv << endl;

    return 0;
}