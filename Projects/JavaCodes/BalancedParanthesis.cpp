// Time Complexity = O(n)
// Space Complexity = O(n)


#include<bits/stdc++.h>
using namespace std;

bool isBalanced(string str)
{
	stack<char> s;
	for (int i = 0; i < str.length(); i++)
	{
		if(str[i] == '(' || str[i] == '[' || str[i] == '{'){
			s.push(str[i]);
		}
		else{
			if(s.empty() == true){
				return  false;
			}
			char c = s.top();
			s.pop();
			if((str[i] == ')' && c == '(') || (str[i] == ']' && c == '[' ) || (str[i] == '}' &&  c == '{')){
				continue;
			}
			else{
				return false;
			}
		}
	}
	return (s.empty() == true);
}
int main()
{
	string str;
	cin>>str;
	if(isBalanced(str)){
		cout<<"Balanced";
	}
	else{
		cout<<"Not Balanced";
	}

	return 0;
}