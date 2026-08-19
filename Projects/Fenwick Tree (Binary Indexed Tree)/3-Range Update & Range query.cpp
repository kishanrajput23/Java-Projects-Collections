#include <bits/stdc++.h>
using namespace std;

/*
After the range update (l,r,x) the range sum query should return the following values:

sum[0,i] = 0                             // i < l
sum[0,i] = x*i − x*(l−1)                 // l ≤ i ≤ r
sum[0,i] = x*r − x*(l-1)                 // i > r

sum[0,i] = 0*i - (0)                     // i < l
sum[0,i] = x*i − (x*(l−1))               // l ≤ i ≤ r
sum[0,i] = 0*i - (x*(l-1)-x*r)           // i > r

We can write the range sum as difference of two terms,
where we use B1 for first term and B2 for second term.
The difference of the queries will give us prefix sum over [0,i].

sum[0,i] = sum(B1,i) * i − sum(B2,i);

*/

const int N = 1e5 + 5;
vector<int> tree1(N), tree2(N);

int read(vector<int> &tree, int idx)
{
    int sum = 0;
    while (idx)
    {
        sum += tree[idx];
        idx -= (idx & -idx);
    }
    return sum;
}

int prefix_sum(int idx)
{
    return (read(tree1, idx) * idx - read(tree2, idx));
}

void update(vector<int> &tree, int idx, int add)
{
    while (idx < N)
    {
        tree[idx] += add;
        idx += (idx & -idx);
    }
}

void range_add(int l, int r, int add)
{
    update(tree1, l, add);
    update(tree1, r + 1, -add);

    update(tree2, l, add * (l - 1));
    update(tree2, r + 1, -add * r);
}

int main()
{
    int n, a;
    cin >> n;

    for (int i = 1; i <= n; i++)
    {
        cin >> a;
        range_add(i, i, a);
    }

    int q;
    cin >> q;
    while (q--)
    {
        int type;
        cin >> type;
        if (type == 1)
        {
            int l, r;
            cin >> l >> r;
            int ans = prefix_sum(r) - prefix_sum(l - 1);
            cout << ans << endl;
        }
        else
        {
            int l, r, add;
            cin >> l >> r >> add;
            range_add(l, r, add);
        }
    }

    return 0;
}