import java.util.*;
import java.lang.Math.*;

class NumberGuessingGame{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		var random = new Random();
		int randNum = (random.nextInt(100))+1;
		int guess,guessCount=0;
		do{	
		System.out.println("Guess the number: ");
		guess = scan.nextInt();
		if(guess==randNum){
			System.out.println("Your guess is correct!\nYour score is "+(100-guessCount));
		}
		else
			System.out.println(guess>randNum?"Smaller Number ":"Larger Number " + "Try again!");
			guessCount++;
		}while(guess!=randNum);
	}
}
