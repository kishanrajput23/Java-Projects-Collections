#include<bits/stdc++.h>
using namespace std;

struct Node 
{
	int data;
	Node *next;
	Node(int y){
		data = y;
		next= NULL;
	}
};

void print(Node *head)
{
	if(head == NULL){
		return ;
	}
	Node *curr = head;
	do{
		cout<<curr->data<<" ";
		curr = curr->next;
	}
	while(curr!=head);
}

Node *deleteHead(Node *head)
{
	if(head == NULL){
		return NULL;
	}
	if(head->next == head){
		delete head;
		return NULL;
	}
	head->data = head->next->data;
	Node * temp = head->next;
	head->next = head->next->next;
	delete temp;
	return head;

}
int main()
{
  Node *head = new Node(10);
  head->next = new Node(11);
  head->next->next = new Node(12);
  head->next->next->next = new Node(13);
  head->next->next->next->next = head;
  print(head);
  cout<<endl;
  head = deleteHead(head);
  print(head);
	
	return 0;
}