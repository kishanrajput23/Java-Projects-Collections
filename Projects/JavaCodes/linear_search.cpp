#include <iostream>
using namespace std;

void lin_search(int size_arr,int pos,int arrTemp[50])
{
    cout << "\nNumber Found at Index No. ";
    size_arr = pos;
    for (int i = 0; i < size_arr; i++)
        cout << arrTemp[i] << " ";
}

int main()
{
    int arr[100], size_arr, i, num, arrTemp[50], j = 0, pos = 0;
    cout << "Enter the Size for Array Size: ";
    cin >> size_arr;
    cout << "Enter " << size_arr << " Array Elements: ";
    for (i = 0; i < size_arr; i++)
        cin >> arr[i];
    cout << "\nEnter the Number to Search: ";
    cin >> num;
    for (i = 0; i < size_arr; i++)
    {
        if (arr[i] == num)
        {
            arrTemp[j] = i;
            j++;
            pos++;
        }
    }
    if (pos > 0)
    {
        lin_search(size_arr,pos,arrTemp);
    }
    else
        cout << "\nNumber doesn't Found!";
    cout << endl;
    return 0;
}