#include<bits/stdc++.h>
using namespace std;


/*problem statement:-
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate the span of stocks price for all n days. 
The span Si of the stocks price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.

Input:
N = 7, price[] = [100 80 60 70 60 75 85]
Output:
1 1 1 2 1 4 6
*/


class Solution
{
    public:
    //Function to calculate the span of stockâ€™s price for all n days.
    vector <int> calculateSpan(int price[], int n)
    {

    vector<int> v;
    stack<pair<int,int>> s;
    v.push_back(1);
    s.push({price[0],1});
    for(int i=1;i<n;i++){
        int count=0;
        while(s.size()!=0){
            auto it=s.top();
            if(it.first>price[i]){
                break;
            }
            else{
                count=count+it.second;
                s.pop();
            }
        }
        v.push_back(count+1);
        s.push({price[i],count+1});
    }
    return v;
    }
};

int main(){
    // taking input:
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        int i,a[n];
        for(i=0;i<n;i++){
            cin>>a[i];
        }
        Solution obj;
        vector<int> s=obj.calculateSpan(a,n);

        for(i=0;i<n;i++){
            cout<<s[i]<<" ";
        }
        cout<<endl;
    }

    return 0;

}