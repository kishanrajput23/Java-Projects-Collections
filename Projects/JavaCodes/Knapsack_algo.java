import java.util.*;
public class knapsack {

		 
	    static int max(int a, int b)
	{ return (a > b) ? a : b; }

	    static int knapSack(int W, int wt[], int val[], int n)
	    {
	        int i, w;
	        int K[][] = new int[n + 1][W + 1];

	        for (i = 0; i<= n; i++) 
	        {
	            for (w = 0; w<= W; w++) 
	            {
	                if (i == 0 || w == 0)
	                    K[i][w] = 0;
	                
	                else if (wt[i - 1]<= w)
	                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
	                
	                else
	                    K[i][w] = K[i - 1][w];
	            }
	        }
	 
	        return K[n][W];
	    }
	 
	    public static void main(String args[])
	    {
	    	int i, x, W, val[], wt[];

		      Scanner s = new Scanner(System.in);
		      System.out.println("Enter capacity:");
		      W = s.nextInt(); 
		      
		      System.out.println("Enter no. of items:");
		      x = s.nextInt();

		      val = new int[x];

		      System.out.println("Enter " + x + " items:");

		      for (i = 0;i<x; i++)
		          val[i] = s.nextInt();
		      
		      wt = new int[x];

		      System.out.println("Enter " + x + " items weight:");

		      for (i = 0;i<x; i++)
		          wt[i] = s.nextInt();
		      

	        int n = val.length;
	        System.out.println("Maximum items possible is "+knapSack(W, wt, val, n));
	    }
	
}
