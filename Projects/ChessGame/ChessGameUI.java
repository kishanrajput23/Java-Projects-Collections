import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChessGameUI extends JFrame {
    private static final int BOARD_SIZE = 8;
    private static final int SQUARE_SIZE = 80;
    private JPanel boardPanel;
    private JButton[][] squares;
    private ChessGameEngine gameEngine;
    private int selectedRow = -1;
    private int selectedCol = -1;
    
    public ChessGameUI() {
        gameEngine = new ChessGameEngine();
        initializeUI();
    }
    
    private void initializeUI() {
        setTitle("Chess Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Create the board panel
        boardPanel = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        squares = new JButton[BOARD_SIZE][BOARD_SIZE];
        
        // Initialize the squares
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                squares[row][col] = new JButton();
                squares[row][col].setPreferredSize(new Dimension(SQUARE_SIZE, SQUARE_SIZE));
                squares[row][col].setBackground((row + col) % 2 == 0 ? Color.WHITE : Color.GRAY);
                final int finalRow = row;
                final int finalCol = col;
                squares[row][col].addActionListener(e -> handleSquareClick(finalRow, finalCol));
                boardPanel.add(squares[row][col]);
            }
        }
        
        add(boardPanel, BorderLayout.CENTER);
        
        // Add status panel
        JPanel statusPanel = new JPanel();
        JLabel statusLabel = new JLabel("White's turn");
        statusPanel.add(statusLabel);
        add(statusPanel, BorderLayout.SOUTH);
        
        // Update the board display
        updateBoardDisplay();
        
        pack();
        setLocationRelativeTo(null);
    }
    
    private void handleSquareClick(int row, int col) {
        if (selectedRow == -1) {
            // First click - select piece
            char piece = gameEngine.getBoard()[row][col];
            if (piece != ' ' && 
                (Character.isUpperCase(piece) == gameEngine.isWhiteTurn())) {
                selectedRow = row;
                selectedCol = col;
                squares[row][col].setBackground(Color.YELLOW);
            }
        } else {
            // Second click - attempt to move
            boolean moveSuccess = gameEngine.makeMove(selectedRow, selectedCol, row, col);
            
            // Reset selection
            squares[selectedRow][selectedCol].setBackground(
                (selectedRow + selectedCol) % 2 == 0 ? Color.WHITE : Color.GRAY
            );
            selectedRow = -1;
            selectedCol = -1;
            
            if (moveSuccess) {
                updateBoardDisplay();
            }
        }
    }
    
    private void updateBoardDisplay() {
        char[][] board = gameEngine.getBoard();
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                squares[row][col].setText(String.valueOf(board[row][col]));
                squares[row][col].setFont(new Font("Arial", Font.BOLD, 40));
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChessGameUI ui = new ChessGameUI();
            ui.setVisible(true);
        });
    }
}