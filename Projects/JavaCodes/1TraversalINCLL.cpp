#include<bits/stdc++.h>
using namespace std;

struct  Node
{
	int data;
	Node *next;
	Node(int y)
	{
		data = y;
		next = NULL;
	}
};

void print(Node *head)
{
	if(head == NULL){
		return;
	}
	Node *value = head;
	do{
		cout<<value->data<<" ";
		value = value->next;
	}
	while(value != head);

}
int main()
{
  Node *head = new Node(10);
  head->next = new Node(11);
  head->next->next = new Node(12);
  head->next->next->next = new Node(13);
  head->next->next->next->next = head;
  print(head);
	return 0;
}