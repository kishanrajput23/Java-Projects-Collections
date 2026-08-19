#include <iostream>
#include<stdio.h>
using namespace std;

int main()
{
    int i,j,rows=4;
    for(i=0;i<rows;i++){
        for(j=0;j<rows;j++){
            if(j<=i)
            cout<<"* ";
            else
            cout<<"  ";
        }
            for(j=0;j<rows;j++){
            if(j<rows-1-i)
            cout<<"  ";
            else
            cout<<"* ";
            }
        cout<<endl;
    }
for(i=0;i<rows;i++){
    for(j=0;j<rows;j++){
            if(j<rows-1-i)
            cout<<"* ";
            else
            cout<<"  ";
            }
     for(j=0;j<rows;j++){
        if(j<=i)
            cout<<"  ";
            else
            cout<<"* ";
        }
            
        cout<<endl;
    }
    return 0;
}