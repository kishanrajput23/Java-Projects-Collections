//Program to Move the Zeros in an Arrays to the End of the Array.
#include<iostream>
using namespace std;

void Display(int* arr,int n){
    for(int i=0;i<=n-1;i++){
        cout<<arr[i]<<" ";
    }
}

int ZerosToEnd(int* arr,int n)
{
    int count=0;
    for(int i=0;i<=n-1;i++)
    {
        if(arr[i]!=0)
        {
            swap(arr[i],arr[count]);
            count++;
        }
    }
    Display(arr,n);
    
}


int main()
{
    int n;
    cout<<"Enter the Length of the Array:";
    cin>>n;
    
    int arr[n];
    
    for(int i=0;i<=n-1;i++)
    {
        if(i+1==1){
            cout<<"Enter the 1st Element of the Array:";
            cin>>arr[i];
        }
        else if(i+1==2){
            cout<<"Enter the 2nd Element of the Array:";
            cin>>arr[i];
        }
        else if(i+1==3){
            cout<<"Enter the 3rd Element of the Array:";
            cin>>arr[i];
        }
        else{
            cout<<"Enter the "<<i+1<<"th Element of the Array:";
            cin>>arr[i];
        }
    }
    ZerosToEnd(arr,n);

}
 
