import java.util.Random;
import java.util.Scanner;

class Game {
    public int number;
    public int usernumber;
    public int gusses = 0;

    public int getGusses( ) {
        return this.gusses;
    }

    public void setGusses( ) {
        this.gusses = gusses;
    }

    Game( ) {
        Random rand = new Random( );
        this.number = rand.nextInt( 100 );
    }

    void userinput( ) {
        System.out.println( "Guess the number" );
        Scanner sc = new Scanner( System.in );
        usernumber = sc.nextInt( );
    }

    boolean check( ) {
        gusses++;
        if ( usernumber == number ) {
            System.out.format( "Yes you guessed it right, it was %d\nYou guessed it in %d attempts" , number , gusses );
            return true;
        }
        else if ( usernumber < number ) {
            System.out.println( "Too low..." );
        }
        else if ( usernumber > number ) {
            System.out.println( "Too high..." );
        }
        return false;
    }

}

public class GuessTheNumber {

    public static void main( String[] args ) {
        Game g = new Game( );
        boolean b = false;
        while ( ! b ) {
            g.userinput( );
            b = g.check( );
        }
    }
}
