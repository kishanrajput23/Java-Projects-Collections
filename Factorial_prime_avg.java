package calculate;
import java.util.Scanner;
public class lab2 {

		public static void Factorial(int n)
		{
			int fact = 1;
			if(n==0)
				return;
			for(int i= 1; i<=n; i++)
			{
				fact = fact*i;
			}
			System.out.println("Factorial of "+n+" is "+fact+"  ");
			
		}
		public static void Average(int n)
		{
			int sum = 0;
			for(int i=0; i<=n; i++)
			{
				sum = sum + i ;
			}
			int avg = sum/n;
			System.out.println("Sum: "+sum+"  ");
			System.out.println("Average: "+avg+"  ");
		}
		public static void Prime()
		{
			int counter = 0;
			int i=2;
			
			for(i=2; i<=50; i++)
			{
				
				for(int j=1; j<=i; j++)
				{
					if(i%j==0)
						counter++;
				}
				if(counter<=2)
				{
					System.out.print(i+"  ");
					counter =0;
				}
				else
					counter=0;
				
			}
				System.out.println("");
			
		}


		public static void main(String[] args) 
		{
			 Scanner s = new Scanner(System.in);
			 int opt,n;
			 boolean flag = true;
		        
		        while(flag)
		        {
		        	 System.out.println("choose a option from following: ");
		        	 System.out.println("1. Factorial");
		        	 System.out.println("2. Prime numbers");
		        	 System.out.println("3. Average");
		             System.out.println("4 for exit");
		            opt = s.nextInt();
		            switch(opt)
		            {
		                case 1:
		                	System.out.print("Enter number to find factorial: ");
		    	            n = s.nextInt();
		    	            Factorial(n);
		                break;
		 
		                case 2:
		                Prime();
		                break;
		 
		                case 3:
		                	System.out.print("Enter number of itiration: ");
		    	            n = s.nextInt();
		                Average(n);
		                break;
		 
		                case 4:
		                flag = false;
		                break;
		            }
		        }
		}
	}

