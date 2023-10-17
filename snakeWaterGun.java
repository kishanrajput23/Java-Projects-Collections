import java.util.Scanner;
import java.util.Random;

public class Mini_Project {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Random rand=new Random();
		int com=rand.nextInt(100);
		System.out.println("Enter the number of matches,You want to Play");
		int match=sc.nextInt();
		int won=0;
		int loose=0;
		int draw=0;
		for(int i=0;i<match;i++) {
		System.out.println("Please enter s for snake,g for gun or w for water");
		char v = sc.next().charAt(0);
		System.out.println("You have entered: "+v);
		if(v=='s'|| v=='g' || v=='w'){
			
		//System.out.println("The computer has selected:"+com);
		{ 
			
		if(com<33) //Selected Snake
		      { com=115;
		      		char s=(char)com;
		      			System.out.println("Computer has choose: "+s);
		      		if(s==v)
		      			{
		      			System.out.println("The match has drawn");
		      			draw++;
		      			}
		      		else if(v==103)
		      			{
		      			System.out.println("You won the match:)");
		      			won++;
		      			}
		      		else if(v==119)
		      			{
		      			System.out.println("You loose the match:(");
		      			loose++;
		      			}
		      }
		
		else if(com>33 &com<66) //Selected Gun g=103, s=115, w=119
				{   com=103;
					char g=(char)com;
					System.out.println("Computer has choose: "+g);
					if(g==v)
		      			{
						System.out.println("The match has drawn");
		      			draw++;}
					else if(v==115)
		      			{
						System.out.println("You loose the match:(");
		      			loose++;}
		      		else if(v==119)
		      			{
		      			System.out.println("You won the match:)");
		      			won++;}
				}
		else if (com>66)  //Selected Water
				{   com=119;
					char w=(char)com;
					System.out.println("Computer has choose: "+w);
					if(w==v)
		      			{
						System.out.println("The match has drawn");
		      			draw++;}
					else if(v==103)
		      			{
						System.out.println("You loose the match:(");
		      			loose++;}
		      		else if(v==115)
		      			{
		      			System.out.println("You won the match:)");
		      			won++;}
				}
	
		
	}
		
}
		else
			System.out.println("Please Enter the valid input");
}	
		System.out.println("********************************");
		System.out.println("STATATICS :)");
		System.out.println("You Won :"+won);
		System.out.println("You loose :"+loose);
		System.out.println("Drawn :"+draw);
		System.out.println("********************************");}}