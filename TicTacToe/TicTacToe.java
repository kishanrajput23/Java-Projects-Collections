import java.util.Scanner;

public class TicTacToe{
    public static void main(String[] args){
        char[][] board = new char[3][3];
        initialize(board);
        startGame(board, 'X');
    }

    public static void initialize(char[][] board){
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                board[row][col] = ' ';
            }
        }
    }

    public static void printBoard(char[][] board){
        for(int row=0;row<board.length;row++){
            System.out.println("-----------");
            for(int col=0;col<board[0].length;col++){
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
        System.out.println("-----------");
    }

    public static void startGame(char[][] board, char player){
        int c = 0;
        boolean gameOver = false;
        Scanner input = new Scanner(System.in);

        while(!gameOver){
            
            if(c == board.length * board.length){
                    System.err.println("Match Draw");
                    break;
            }
            printBoard(board);
            
            System.out.print("Player " + player + " Enter position: ");
            int row = input.nextInt();
            int col = input.nextInt();
            System.out.println();

            if(board[row][col] == ' '){
                board[row][col] = player;
                c++;
                gameOver = haveWon(board, player);

                if(gameOver){
                    System.out.println("Player " + player + " has won!");
                }
                else{
                    player = (player == 'X') ? 'O' : 'X';
                }
            }
            else{
                System.err.println("Invalid Position. Try Again!");
            }
        }
        printBoard(board);

    }

    public static boolean haveWon(char[][] board, char player){
        // row
        for(int row=0;row<board.length;row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }

        // column
        for(int col=0;col<board[0].length;col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }

        // diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

}