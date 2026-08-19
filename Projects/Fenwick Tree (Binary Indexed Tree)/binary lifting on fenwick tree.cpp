#include <bits/stdc++.h>
using namespace std;

const int N = 1e5 + 5;
vector<int> arr(N), tree(N);
int n;

void update(int idx, int add)
{
    while (idx < N)
    {
        tree[idx] += add;
        idx += (idx & -idx);
    }
}

// return the lower index where cumulative sum >= val
// i.e sum[1....idx]>=val
int lower_bound(int val)
{
    int idx = 0, sum = 0;

    for (int i = log2(n); i >= 0; i--)
    {
        if (idx + (1 << i) > n)
            continue;

        int curr = tree[idx + (1 << i)];
        if (sum + curr < val)
        {
            sum += curr;
            idx += (1 << i);
        }
    }
    return idx + 1;
}

int main()
{
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
            int val;
            cin >> val;
            int ans = lower_bound(val);
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