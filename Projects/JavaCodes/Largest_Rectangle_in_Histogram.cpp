/*Problem statement:
Given an array of integers heights representing the histogram's bar height where the 
width of each bar is 1, return the area of the largest rectangle in the histogram.

Input: 
heights = [2,1,5,6,2,3]
Output: 10
*/

#include <bits/stdc++.h>
using namespace std;

int largestRectangleArea(vector<int> &heights){
	int n = heights.size(), ans = 0;
	stack<int> s;
	s.push(-1);
	heights.push_back(0);

	for (int i = 0; i < n; i++){
		while (s.top() != -1 && heights[s.top()] >= heights[i]){
			int j = s.top();
			s.pop();

			int curr = (i - s.top() - 1) * heights[j];
			ans = max(ans, curr);
		}
		s.push(i);
	}

	return ans;
}

int main(){
	int n;
	cin >> n;
	vector<int> heights(n);
	for (int i = 0; i < n; i++) cin >> heights[i];
	
	cout << largestRectangleArea(heights);

	return 0;
}