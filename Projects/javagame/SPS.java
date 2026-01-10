package com.company;


import java.util.Scanner;
import java.util.Random;

public class CWH_L20_EXERCISE_2_stone_paper_scissor {
    public static void main(String[] args) {
        // 1 for stone
        // 2 for paper
        // 3 for scissor

      Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO STONE,PAPER,SCISSOR GAME!");

        int stone = 1, paper = 2, scissor =3;
        System.out.println(" PLAYER 1 : Enter (1) for Stone , (2) for paper, (3) for scissor : ");
         int choiceplayer1= sc.nextInt();

       Random random= new Random();
       int computerInput = random.nextInt(3);

         if(choiceplayer1 == computerInput)    {
             System.out.println("It's a Tie");
         }
         else {
             switch (choiceplayer1) {
                 case 1 :
                     if (computerInput == 2)
                         System.out.println("computer wins!" + "computer choice: paper");

                     else
                         System.out.println("Player 1 wins!" + "Your choice : Stone");
                     break;

                 case 2:
                     if(computerInput == 3)
                         System.out.println("computer wins" + "Computer choice : Scissor");

                     else
                         System.out.println("Player 1 wins!" + "Your choice : Paper");
                     break;

                 case 3:
                     if(computerInput == 1)
                     System.out.println("computer wins!" + "computer choice : Stone");

                     else
                            System.out.println("Player 1 wins!" + "Your choice : scissor");
                     break;

                      default :
                     System.out.println("You have entered wrong number");



             }
         }