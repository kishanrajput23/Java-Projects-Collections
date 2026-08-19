#include <bits/stdc++.h>
using namespace std;

/*

binary     001    010      011      100      101     110     111    1000
tree idx-   1      2        3        4        5       6       7       8
store sum  1-1    1-2      3-3      1-4      5-5     5-6     7-7     1-8

tree[i] store sum of arr[L.....i] where,
L=i-(i & -i)+1    //keep LSB of i off and increase by 1

Now,if we have to calculate sum[1...7],then
    7 = 4 + 2 + 1    ( 111 = 100 + 010 + 001 )

    sum[1..7] = sum[7...7] + sum[5...6] + sum[1...4]
    sum[1..7] =   tree[7]  +   tree[6]  +  tree[4]             (7-->6-->4-->0)


*/

const int N = 1e5 + 5;
vector<int> arr(N), tree(N);

// LSB of x = (x & -x)

// return sum of arr[1...idx];
int read(int idx)                   // O(log2n)
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
void update(int idx, int add)       // O(log2n)
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

    for (int i = 1; i <= n; i++)
    {
        cin >> arr[i];
        update(i, arr[i]);
    }

    int q;
    cin >> q;
    while (q--)
    {
        int type;
        cin >> type;
        if (type == 1)
        {
            int idx;
            cin >> idx;
            int ans = read(idx);
            cout << ans << endl;
        }
        else
        {
            int idx, val;
            cin >> idx >> val;
            int add = val - arr[idx];
            arr[idx] = val;
            update(idx, add);
        }
    }

    return 0;
}