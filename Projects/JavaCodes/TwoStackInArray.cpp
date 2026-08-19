// Time Complexity : O(n)

#include<bits/stdc++.h>
using namespace std;
struct Stacks
{
	int *arr;
	int cap;
	int top1, top2;
	Stacks(int n){
		cap = n;
		arr =  new int[n];
		top1 = -1;
		top2 = cap;
	}

	void push1(int data)
	{
		if(top1 < top2-1){
			top1++;
			arr[top1] = data;
		}
		else{
			cout<<"Stack Overflow"<<endl;
			exit(1);
		}
	}

	void push2(int data){
        if(top1 < top2-1){
        	top2--;
        	arr[top2] = data;
        }
        else{
        	cout<<"Stack Overflow"<<endl;
        	exit(1);
        }
	}

	int pop1()
	{
		if(top1 >=0){
			int data  = arr[top1];
			top1--;
			return data;
		}
		else{
			cout<<"Stack underflow"<<endl;
			exit(1);
		}
	}

	int pop2()
	{
		if(top2 < cap){
			int data = arr[top2];
			top2++;
			return data;
		}
		else{
			cout<<"Stack underflow"<<endl;
			exit(1);
		}
	}
  
};
int main()
{
	
  Stacks ts(5); 
    ts.push1(5); 
    ts.push2(10); 
    ts.push2(15); 
    ts.push1(11); 
    ts.push2(7); 
    cout << "Popped element from stack1 is "<<ts.pop1(); 
    ts.push2(40); 
    cout << "\nPopped element from stack2 is "<< ts.pop2(); 
    return 0; 
	return 0;
}