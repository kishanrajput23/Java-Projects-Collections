package main;

import java.util.Scanner;

class Account{
	
	 int balance;
     int prevTrans;
     String custName;
	 int custId;
	Scanner sc =new Scanner(System.in);
      
	  void deposit(int amt1) {
		  if(amt1 !=0) {
			  balance= balance+amt1;
			  prevTrans = amt1;
		  }
	  }
	  
	  void withdraw(int amt2) {
		  if(balance !=0) {
			  balance = balance-amt2;
			  prevTrans = -amt2;
		  }
	  }
	  
	  void getPrevTrans() {
		  
		  if(prevTrans>0) {
			  System.out.println("Deposited Amount: "+prevTrans);
		  }
		  else if(prevTrans<0) {
			  System.out.println("Withdrawn Amount: "+Math.abs(prevTrans));
		  }
		  else {
			  System.out.println("No Previous Transaction ");
		  }
			  
	  }
	  
      void start() {
		int z=0;	
    System.out.println("Greetings "+custName+"\nID : "+custId+"\n");
	System.out.println("What do you wish to do today?\n");
	System.out.println("1. Check Balance\n2. Deposit\n3. Withdraw\n4. View Previous Transaction\n5. Exit \n");
	
	do {
		System.out.println("******************");
		System.out.println("Enter your choice: ");
		System.out.println("******************");
         z=sc.nextInt();
         
		switch(z) {
		
		case 1:
			System.out.println("---------------");
			System.out.println("Current Balance : "+balance);
			System.out.println("---------------\n");
			break;
			
		case 2:
			System.out.println("------------------------");
            System.out.println("Enter amount to deposit:");
			System.out.println("------------------------");
             int a=sc.nextInt();
            deposit(a);
             System.out.println("\n");
             break;
             
		case 3:
			System.out.println("-------------------------");
            System.out.println("Enter amount to withdraw:");
			System.out.println("-------------------------");
            int b=sc.nextInt();
            withdraw(b);
             System.out.println("\n");  
             break;
             
		case 4:
			System.out.println("-------------------------");
            System.out.println("Previous Transaction : ");
            getPrevTrans();
			System.out.println("-------------------------\n");
			break;
         
		case 5:
			System.out.println("*******************************");
			break;
			
        default:
        	System.out.println("INVALID INPUT! \nPlease try again ");
        	break;
		}
		
	}while(z!=5);
		System.out.println("Thank you for using our services");
	}
}

 public class Bank {
 public static void main(String[] args) {
	
	
	 Account b1=new Account();
	 b1.custId= 9934823;
	 b1.custName="Paras Dongre";
	 b1.balance= 52000;
	 
	 Account b2=new Account();
	 b2.custId= 7842464;
	 b2.custName="Rahul Bhage";
	 b2.balance= 72000;
	 
	 Account b3=new Account();
	 b3.custId= 532568;
	 b3.custName="Anshul Pagle";
	 b3.balance= 34000;
	 
	 System.out.println("                 WELCOME TO THE PHD BANK");  
	 System.out.println("                 ***********************\nEnter your pin : ");  
	 
   Scanner s=new Scanner(System.in); 
   int  pin=s.nextInt();
	 
	 if(pin==1234) {
		 b1.start();
	 }
	 else if(pin==4321) {
		 b2.start();
	 }
	 else if(pin==9876) {
		 b3.start();
	 }
	 else {
		 System.out.println("Invalid PIN !! Try Again");
	 }
	 }
}
