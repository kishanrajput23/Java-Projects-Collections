// Time Complexity = O👎


#include<bits/stdc++.h>
using namespace std;
struct Node
{
	int data;
	Node *next;
	Node(int d){
		data = d;
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

Node *InsertBegin(Node *head, int data)
{
	Node *temp = new Node(data);
	if(head == NULL){
		temp->next = temp;
		return temp;
	}
	else{
		temp->next = head->next;
		head->next = temp;
		int t =  head->data;
		head->data = temp->data;
        temp->data = t;
        return head;
	}
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
  head = InsertBegin(head, 9);
  print(head);
	

	return 0;
}