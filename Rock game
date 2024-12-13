 import java.util.*;
 import java.util.Random;
 class Main{
     //ROCK PAPER SCISSOR GAME
     public static void main(String []args){
         Scanner sc=new Scanner(System.in);
         Random r=new Random();
         int a=0,b=0;
         //a:you,b:computer points
         System.out.println(" ROCK=0\n SCISSOR=1\n PAPER=2");
         for(int i=0;i<=5;i++){
         int x=sc.nextInt();
         int y=r.nextInt(2);
          
         if(x==y){
             System.out.println("you:"+x);
             System.out.println("computer:"+y);
             System.out.println("DRAW\n PLAY AGAIN");
             a++;
             b++;
         }
         else if(x==0&&y==1){
             System.out.println("you:"+x);
             System.out.println("computer:"+y);
             System.out.println("you win\n PLAY AGAIN");
             a++;
         }
         else if(x==0&&y==2){
             System.out.println("you:"+x);
             System.out.println("computer:"+y);
             System.out.println("computer win\n PLAY AGAIN");
             b++;
         }
         else if(x==1&&y==2){
             System.out.println("you:"+x);
             System.out.println("computer:"+y);
             System.out.println("you win\n PLAY AGAIN");
             a++;
         }
         else if(y==0&&x==1){
             System.out.println("you:"+x);
             System.out.println("computer:"+y);
             System.out.println("computer win\n PLAY AGAIN");
             b++;
         }
         else if(y==0&&x==2){
             System.out.println("you:"+x);
             System.out.println("computer:"+y);
             System.out.println("you win\n PLAY AGAIN");
             a++;
         }
         else if(x==2&&y==1){
             System.out.println("you:"+x);
             System.out.println("computer:"+y);
             System.out.println("computer win\n PLAY AGAIN");
             b++;
         }
         else{
             System.out.println("you:"+x);
             System.out.println("computer:"+y);
             System.out.println("invalid");
         }
        }
        if(a>b){
            System.out.println("\n YOU WIN.");
        }
        else{
             System.out.println("\n COMPUTER WIN.");
        }
     }
 }
