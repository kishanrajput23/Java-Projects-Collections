#include <bits/stdc++.h>
using namespace std;

const int N = 1e5 + 5;
vector<int> tree(N);

// return arr[idx];
int read(int idx)                     // O(log2n)
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
void update(int idx, int add)         // O(log2n)
{ 
    while (idx < N)
    {
        tree[idx] += add;
        idx += (idx & -idx);
    }
}

int main()
{
    int n, a;
    cin >> n;

    for (int i = 1; i <= n; i++)
    {
        cin >> a;
        update(i, a);
        update(i + 1, -a);
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
            int l, r, add;
            cin >> l >> r >> add;
            update(l, add);
            update(r + 1, -add);
        }
    }

    return 0;
}