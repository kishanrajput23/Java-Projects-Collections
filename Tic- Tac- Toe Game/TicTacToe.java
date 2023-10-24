import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';
    private static boolean gameWon = false;

    public static void main(String[] args) {
        initializeBoard();
        printBoard();

        while (!gameWon) {
            makeMove();
            printBoard();
            checkForWin();
            switchPlayer();
        }

        if (gameWon) {
            System.out.println("Player " + currentPlayer + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private static void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
    }

    private static void printBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col]);
                if (col < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (row < 2) {
                System.out.println("---------");
            }
        }
    }

    private static void makeMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        do {
            System.out.print("Player " + currentPlayer + ", enter your row (0, 1, 2) and column (0, 1, 2): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
        } while (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ');
        board[row][col] = currentPlayer;
    }

    private static void checkForWin() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer
                    || board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer
                    || board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer
                    || board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
                gameWon = true;
                return;
            }
        }

        // Check for a draw
        boolean isFull = true;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    isFull = false;
                    break;
                }
            }
        }
        if (isFull) {
            gameWon = true;
        }
    }

    private static void switchPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }
}
