package com.company;
import java.util.Scanner;
import java.util.Random;

public class Project {
    public static void main(String[] args) {
        //0 for Rock
        //1 for paper
        //2 for scissors
        //taking input from user...
      
        Scanner input=new Scanner(System.in);
        System.out.print("Enter 0 for Rock, 1 for Paper, 2 for Scissors : ");
        int user_Input=input.nextInt();
        input.close();//closing the input
        //randomly takes input from computer....
      
        Random rand=new Random();
        int Computer_input=rand.nextInt(3);
      

        if(user_Input==Computer_input){
            System.out.println("Match Draw");
        }
        else if(user_Input==0 && Computer_input==1 || user_Input==2 && Computer_input==0 || user_Input==1 && Computer_input==2 ){
            System.out.println("Congrats You Win");
        }
        else{
            System.out.println("Computer Win");
        }
      
      
        if(Computer_input==0){
            System.out.println("Computer Choice = Rock");
        }
        else if(Computer_input==1){
            System.out.println("Computer Choice = Paper");
        }
        else if(Computer_input==2){
            System.out.println("Computer Choice = Scissors");
        }

    }
}
