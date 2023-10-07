public class SudokuPuzzle {

    // Check if it's safe to place 'n' in the cell at row 'r' and column 'c'
    public boolean isSafe(int[][] board, int r, int c, int n) {
        // Check for clashes in the row
        for (int d = 0; d < board.length; d++) {
            if (board[r][d] == n) {
                return false;
            }
        }

        // Check for clashes in the column
        for (int r1 = 0; r1 < board.length; r1++) {
            if (board[r1][c] == n) {
                return false;
            }
        }

        // Check for clashes in the sub-grid
        int sqrt = (int) Math.sqrt(board.length);
        int boxRowStart = r - r % sqrt;
        int boxColStart = c - c % sqrt;

        for (int r1 = boxRowStart; r1 < boxRowStart + sqrt; r1++) {
            for (int d = boxColStart; d < boxColStart + sqrt; d++) {
                if (board[r1][d] == n) {
                    return false;
                }
            }
        }

        return true;
    }

    // Solve the Sudoku puzzle using backtracking
    public boolean solveSudoku(int[][] board, int num) {
        int r = -1;
        int c = -1;
        boolean isVacant = true;

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (board[i][j] == 0) {
                    r = i;
                    c = j;
                    isVacant = false;
                    break;
                }
            }
            if (!isVacant) {
                break;
            }
        }

        if (isVacant) {
            return true; // No empty cells left, the puzzle is solved
        }

        // Try placing numbers from 1 to num in the cell
        for (int no = 1; no <= num; no++) {
            if (isSafe(board, r, c, no)) {
                board[r][c] = no;
                if (solveSudoku(board, num)) {
                    return true;
                } else {
                    board[r][c] = 0; // Backtrack
                }
            }
        }
        return false; // No solution found for the current configuration
    }

    // Display the Sudoku grid
    public void display(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int d = 0; d < n; d++) {
                System.out.print(board[i][d] + " ");
            }
            System.out.println();
            if ((i + 1) % (int) Math.sqrt(n) == 0) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[][] {
            {7, 0, 0, 0, 0, 0, 2, 0, 0},
            {4, 0, 2, 0, 0, 0, 0, 0, 3},
            {0, 0, 0, 2, 0, 1, 0, 0, 0},
            {3, 0, 0, 1, 8, 0, 0, 9, 7},
            {0, 0, 9, 0, 7, 0, 6, 0, 0},
            {6, 5, 0, 0, 3, 2, 0, 0, 1},
            {0, 0, 0, 4, 0, 9, 0, 0, 0},
            {5, 0, 0, 0, 0, 0, 1, 0, 6},
            {0, 0, 6, 0, 0, 0, 0, 0, 8}
        };

        SudokuPuzzle obj = new SudokuPuzzle();
        int size = board.length;

        System.out.println("The input grid is:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        if (obj.solveSudoku(board, size)) {
            System.out.println("The solution to the Sudoku puzzle is:");
            obj.display(board, size);
        } else {
            System.out.println("There is no solution available.");
        }
    }
}
