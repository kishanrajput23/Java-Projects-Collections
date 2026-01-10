// Java OTP generator using random() method  

import java.util.*; 

class Main { 
	public static void main(String[] args) 
	{ 
		int length = 10; 
		System.out.println(Password(length)); 
	} 

	static char[] Password(int len) 
	{ 
		System.out.println("Generating password using random() : "); 
		System.out.print("Your new password is : "); 
 
		String Capital_letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		String Small_letters = "abcdefghijklmnopqrstuvwxyz"; 
		String numbers = "0123456789"; 
		String symbols = "!@#$%^&*_=+-/.?<>)"; 


		String values = Capital_letters + Small_letters + numbers + symbols; 

		Random random_method = new Random(); 

		char[] password = new char[len]; 

		for (int i = 0; i < len; i++) 
		{ 
			password[i] = 
			values.charAt(random_method.nextInt(values.length())); 

		} 
		return password; 
	} 
} 
