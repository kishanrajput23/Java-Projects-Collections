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

Node *DeleteKth(Node *head, int k)
{
   if(head == NULL){
   	return head;
   }
   if(k==1){
   	return deleteHead(head);
   }
   Node *curr = head;
   for (int i = 0; i < k-2; ++i)
   {
      curr = curr->next;
   }
   Node *temp = curr->next;
   curr->next = curr->next->next;
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
  int k;
  cin>>k;
  head = DeleteKth(head, k);
  print(head);

	return 0;
}