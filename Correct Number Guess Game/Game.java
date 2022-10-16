import java.util.Random;
import java.util.Scanner;
class Game1{
    private int noofGuesses=0;
    public int inputno;
    private int Rando;
    public Game1(){
        Random rand = new Random();
        int upperbound=100;
        Rando= rand.nextInt(upperbound);
    }
    public void TakeUserinput(){
        System.out.print("Guess a no:");
        Scanner a1 = new Scanner(System.in);
        inputno= a1.nextInt();
        a1.close(); //scanner closed
    }
    public void SetnoofGuesses(int Guesses){
        this.noofGuesses=Guesses;
    }
    public int GetnoofGuesses(){
        return noofGuesses;
    }

    boolean NoofCorrectGuesses(){
        noofGuesses++;
        if (inputno==Rando){
            System.out.printf("You guesses the no right: "+ "%d",Rando);
            System.out.println("");
            System.out.printf("You guesses in " + "%d" +" attempts",noofGuesses);
            System.out.println("");
            return true;
        }
        else if(inputno>Rando){
            System.out.println("No is greater");
        }
        else if(inputno<Rando){
            System.out.println("No is less");
        }
        return false;
    }
}

//starting main function
public class Game {
    public static void main(String[] args) {
        Game1 gaming=new Game1();
        boolean b=false;
        while (!b) {
            gaming.TakeUserinput();
            b=gaming.NoofCorrectGuesses();
        }

    }
}
