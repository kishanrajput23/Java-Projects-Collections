#include<bits/stdc++.h>
using namespace std;

struct stackusingArray
{
   int *arr;
   int capacity;
   int topindex;
	stackusingArray(int t){
		capacity = t;
		arr = new int[capacity];
		topindex=-1;
	}
   
   int size(){
   	return topindex + 1;
   }

   bool isempty(){
    return topindex==-1;
   }

   void push(int element){
   	// If satack is full then we have to do
   	if(topindex ==capacity-1){
   		cout<<"Stack is Full!"<<endl;
   		return;
   	}
   	topindex++;
    arr[topindex] = element;

   }

   int pop(){
    if(topindex == -1){
    	cout<<"Stack is Empty!"<<endl;
    	return INT_MIN;
    }
    int result = arr[topindex];
    topindex--;
    return result;

   }


   int top(){
   	if(topindex == -1){
   		cout<<"Stack is Empty"<<endl;
   		return INT_MIN;
   	}
    return arr[topindex];

   }
};
int main()
{
	stackusingArray s(5);
	s.push(2);
	s.push(3);
	s.push(4);
	cout<<s.pop()<<endl;
    cout<<s.size()<<endl;
    cout<<s.top()<<endl;
    cout<<s.isempty()<<endl;

	return 0;
}