import java.util.Scanner;
public class Guess
{
	public static void main(String[] args) {
	    
	    //creating Scanner object
		Scanner in = new Scanner(System.in); 
		
		//Instructions to the Game
		System.out.println("NUMBER GUESSING GAME");
		System.out.println();
		
		System.out.println("INSTRUCTIONS:");

		System.out.println("1)Enter the minimum and maximum range of your choice");
		System.out.println("2)Your Aim is to guess the random number generated between the above range");
		System.out.println("3)If you find the random number in minimum number of guesses");
		System.out.println("You WIN or you LOSE the game");
		System.out.println();
		
		System.out.println("OK LET'S BEGIN");
		System.out.println();
		
		 //Declaring min and max variable for min and max range
		int min;
		int max;
		int res;
		int guess_count = 0;
		
		//To get min and max value from the user
		System.out.println("Enter your minimum range");
		min = in.nextInt();
		System.out.println("Enter your maximum range");
		max = in.nextInt();
		System.out.println();
		
		//Creating random number out of the min and max range
		int n = (int)(Math.random()*(max-min+1)+min);   
		int guess;
		
		/*
		//Determine the max guesses for the given range
		res = (int)(max / 4) + (min / 4);
		res = res/2;
		System.out.println(res);
		*/
		
		//Loop for guessing the number by the user
		System.out.println("Enter your guess (between '" + min +"' and '"+ max+ "' range)");
		while(true){ 
		    
		    //To input the guess
		    guess = in.nextInt(); 
		    
		    //To compare the user entered number with the guess
		    
		    //case 1
 		    if(guess > n){
		        System.out.println("NUMBER is LESS than your GUESS");
		        guess_count++;
		    }
		    
		    //case 2
		    if(guess < n){
		        System.out.println("NUMBER is GREATER than your GUESS");
		        guess_count++;
		    }
		    
		    //case 3
		    if(guess == n){
		        System.out.println("GUESS is CORRECT");
		        
		        //To Continue the Loop
		  /*      System.out.println("Do you want to play again(Press 1 else Press 0)");
		        res = in.nextInt();
		        
		        //To Break the Loop
		        if(!(res == 1)){
		  */
		        break;
		        //}
		    }
		    System.out.println();
		    System.out.println("Enter your new GUESS");
		}
		
		System.out.println();
		if(guess_count >= 5){
		    System.out.println("You LOST the game");
		}
		else{
		    System.out.println("You WON the game");
		}
		System.out.println();
		System.out.println("GAME ENDED");
	}
}
