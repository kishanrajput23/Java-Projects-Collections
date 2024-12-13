package com.company;

import java.util.Random;
import java.util.Scanner;

class Game{
    public int Computer_input;
    public int User_input;
    //public int noOfGuesses;

   // public int getNoOfGuesses() {
      //  return noOfGuesses;
   // }

    //public void setNoOfGuesses(int noOfGuesses) {
       // this.noOfGuesses = noOfGuesses;
   // }

    public Game() {
        Random rand=new Random();
        Computer_input = rand.nextInt(100);
    }
    //method for taking input from user
    public void takeUserInput(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the Number That you want to guess it :");
        User_input=input.nextInt();
        input.close(); //input closed
    }
    boolean isCorrectNumber(){
        if(User_input==Computer_input){
            System.out.println("Congrats!!!You guess the Correct number..");
            return true;
        }
        else if(User_input<Computer_input){
            System.out.println("Your number is less than the computer number...");
        }
        else if (User_input>Computer_input){
            System.out.println("Your number is greater than the computer number ...");
        }
        return false;
    }
}
public class Number_Gusses {
    public static void main(String[] args) {
        Game g=new Game();
        boolean b=false;
        while(!b){
            g.takeUserInput();
            b= g.isCorrectNumber();
            System.out.println(b);
        }

    }
}
