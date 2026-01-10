// Java Program to print pattern 
// Square hollow pattern 
import java.util.*; 

public class GeeksForGeeks { 
	// Function to demonstrate pattern 
	public static void printPattern(int n) 
	{ 
		int i, j; 
		// outer loop to handle number of rows 
		for (i = 0; i < n; i++) { 
			// inner loop to handle number of columns 
			for (j = 0; j < n; j++) { 
				// star will print only when it is in first 
				// row or last row or first column or last 
				// column 
				if (i == 0 || j == 0 || i == n - 1
					|| j == n - 1) { 
					System.out.print("*"); 
				} 
				// otherwise print space only. 
				else { 
					System.out.print(" "); 
				} 
			} 
			System.out.println(); 
		} 
	} 

	// Driver Function 
	public static void main(String args[]) 
	{ 
		int n = 6; 
		printPattern(n); 
	} 
}
