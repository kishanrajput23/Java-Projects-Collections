// Java program to demonstrate 
// method calls of Random class 
import java.util.Random; 

public class Test 
{ 
	public static void main(String[] args) 
	{ 
		Random random = new Random(); 
		System.out.println(random.nextInt(10)); 
		System.out.println(random.nextBoolean()); 
		System.out.println(random.nextDouble()); 
		System.out.println(random.nextFloat()); 
		System.out.println(random.nextGaussian()); 
		byte[] bytes = new byte[10]; 
		random.nextBytes(bytes); 
		System.out.printf("["); 
		for(int i = 0; i< bytes.length; i++) 
		{ 
			System.out.printf("%d ", bytes[i]); 
		} 
		System.out.printf("]\n"); 
		
		System.out.println(random.nextLong()); 
	System.out.println(random.nextInt()); 
	
	long seed = 95; 
	random.setSeed(seed); 
		
	// Note: Running any of the code lines below 
	// will keep the program running as each of the 
	// methods below produce an unlimited random 
	// values of the corresponding type 

	/* System.out.println("Sum of all the elements in the IntStream returned = " + 
		random.ints().count()); 
	System.out.println("Count of all the elements in the DoubleStream returned = " + 
		random.doubles().count()); 
	System.out.println("Count of all the elements in the LongStream returned = " + 
		random.longs().count()); 
	
	*/
	
} 
}	 
