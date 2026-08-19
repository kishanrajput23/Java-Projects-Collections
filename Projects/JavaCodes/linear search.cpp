#include <iostream>
using namespace std;
   
int main(){
    int  n,i,c=0,num;
       
    cout << "Enter Number of Elements in Array\n";
    cin >> n;
     
    cout << "Enter " << n << " numbers \n";
      int input[n];
    // Read array elements
    for(int i = 0; i < n; i++){
        cin >> input[i];
    }
      
    cout << "Enter a number to search in Array\n";
    cin >> num;
      
   
    for(int i = 0; i < n; i++){
        if(input[i] == num){
            cout << "Element found at index " << i;
            break;
        }
        c++;
    }
      
    if(c == n){
        cout  << "Element Not Present in Input Array\n";
    }
 
    return 0;
}
