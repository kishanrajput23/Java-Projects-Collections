import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    private static final int SIZE = 10;
    private static final int MINES = 15;

    private char[][] board;
    private boolean[][] mines;
    private boolean[][] revealed;
    private boolean gameOver;

    public Minesweeper() {
        board = new char[SIZE][SIZE];
        mines = new boolean[SIZE][SIZE];
        revealed = new boolean[SIZE][SIZE];
        gameOver = false;
    }

    public void initialize() {
        // Initialize the board and randomly place mines
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = ' ';
                mines[i][j] = false;
                revealed[i][j] = false;
            }
        }
        placeMines();
    }

    public void placeMines() {
        Random random = new Random();
        int minesPlaced = 0;

        while (minesPlaced < MINES) {
            int x = random.nextInt(SIZE);
            int y = random.nextInt(SIZE);

            if (!mines[x][y]) {
                mines[x][y] = true;
                minesPlaced++;
            }
        }
    }

    public void printBoard() {
        System.out.println("Minesweeper");
        System.out.print("   ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < SIZE; j++) {
                char cell = revealed[i][j] ? board[i][j] : ' ';
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public void revealCell(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE || revealed[x][y] || gameOver) {
            return;
        }

        if (mines[x][y]) {
            gameOver = true;
            return;
        }

        revealed[x][y] = true;
        int count = countMinesAround(x, y);
        if (count > 0) {
            board[x][y] = (char) (count + '0');
        } else {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    revealCell(x + i, y + j);
                }
            }
        }
    }

    public int countMinesAround(int x, int y) {
        int count = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nx = x + i;
                int ny = y + j;
                if (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE && mines[nx][ny]) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isGameWon() {
        int unrevealedCells = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (!revealed[i][j]) {
                    unrevealedCells++;
                }
            }
        }
        return unrevealedCells == MINES;
    }

    public static void main(String[] args) {
        Minesweeper game = new Minesweeper();
        game.initialize();

        Scanner scanner = new Scanner(System.in);

        while (!game.isGameOver() && !game.isGameWon()) {
            game.printBoard();
            System.out.print("Enter row and column (e.g., '1 2'): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            game.revealCell(x, y);
        }

        game.printBoard();
        if (game.isGameWon()) {
            System.out.println("You won! Congratulations!");
        } else {
            System.out.println("Game over! You hit a mine!");
        }

        scanner.close();
    }
}
