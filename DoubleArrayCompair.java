// Java program to compare two double arrays 

import java.util.*; 
import java.lang.*; 
import java.io.*; 

class GFG { 

	public static void main(String[] args) throws java.lang.Exception 
	{	 
		// Two double arrays array1 and array2 
		double[] array1 = { 1.5, 2.5, 3.5, 4.5 }; 
		double[] array2 = { 1.5, 2.5, 3.5 }; 

		// when the length of two arrays are not 
		// same, then both the arrays cannot be equal 
		// so no need of comparing each element 
		if (array1.length != array2.length) 

			System.out.println("Arrays are not Equal"); 
		
		else { 
			for (int i = 0; i < array1.length; i++) 
			{ 
				// comparing each and every element 
				if (array1[i] != array2[i]) 
				{ 
					System.out.println("Arrays are not Equal"); 
					System.exit(0); 
				} 
			} 
			
			System.out.println("Arrays are Equal"); 
		} 
	} 
}
