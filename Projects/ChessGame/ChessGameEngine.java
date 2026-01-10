import java.util.*;

public class ChessGameEngine {
    private char[][] board;
    private boolean isWhiteTurn;
    private boolean[] castlingRights; // [whiteKingSide, whiteQueenSide, blackKingSide, blackQueenSide]
    private int[] enPassantSquare; // [row, col] of square where en passant capture is possible
    
    public ChessGameEngine() {
        initializeBoard();
        isWhiteTurn = true;
        castlingRights = new boolean[]{true, true, true, true};
        enPassantSquare = null;
    }
    
    private void initializeBoard() {
        board = new char[8][8];
        // Initialize pieces
        // Black pieces
        board[0] = new char[]{'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'};
        Arrays.fill(board[1], 'p');
        // Empty squares
        for (int i = 2; i < 6; i++) {
            Arrays.fill(board[i], ' ');
        }
        // White pieces
        Arrays.fill(board[6], 'P');
        board[7] = new char[]{'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'};
    }
    
    public boolean makeMove(int startRow, int startCol, int endRow, int endCol) {
        if (!isValidMove(startRow, startCol, endRow, endCol)) {
            return false;
        }
        
        // Store the move
        char piece = board[startRow][startCol];
        char capturedPiece = board[endRow][endCol];
        
        // Make the move
        board[endRow][endCol] = piece;
        board[startRow][startCol] = ' ';
        
        // Handle special moves
        handleSpecialMoves(piece, startRow, startCol, endRow, endCol);
        
        // Check if the move puts the current player in check
        if (isInCheck(isWhiteTurn)) {
            // Undo the move
            board[startRow][startCol] = piece;
            board[endRow][endCol] = capturedPiece;
            return false;
        }
        
        // Update game state
        isWhiteTurn = !isWhiteTurn;
        return true;
    }
    
    private boolean isValidMove(int startRow, int startCol, int endRow, int endCol) {
        // Basic boundary checks
        if (!isValidPosition(startRow, startCol) || !isValidPosition(endRow, endCol)) {
            return false;
        }
        
        char piece = board[startRow][startCol];
        boolean isWhitePiece = Character.isUpperCase(piece);
        
        // Check if it's the correct player's turn
        if (isWhiteTurn != isWhitePiece) {
            return false;
        }
        
        // Implement piece-specific move validation
        return validatePieceMove(piece, startRow, startCol, endRow, endCol);
    }
    
    private boolean validatePieceMove(char piece, int startRow, int startCol, int endRow, int endCol) {
        // Implement specific validation for each piece type
        switch (Character.toLowerCase(piece)) {
            case 'p': return validatePawnMove(piece, startRow, startCol, endRow, endCol);
            case 'r': return validateRookMove(startRow, startCol, endRow, endCol);
            case 'n': return validateKnightMove(startRow, startCol, endRow, endCol);
            case 'b': return validateBishopMove(startRow, startCol, endRow, endCol);
            case 'q': return validateQueenMove(startRow, startCol, endRow, endCol);
            case 'k': return validateKingMove(piece, startRow, startCol, endRow, endCol);
            default: return false;
        }
    }
    
    private void handleSpecialMoves(char piece, int startRow, int startCol, int endRow, int endCol) {
        // Handle castling
        if (Character.toLowerCase(piece) == 'k' && Math.abs(endCol - startCol) == 2) {
            handleCastling(startRow, startCol, endRow, endCol);
        }
        
        // Handle pawn promotion
        if (Character.toLowerCase(piece) == 'p' && (endRow == 0 || endRow == 7)) {
            handlePromotion(endRow, endCol);
        }
        
        // Handle en passant
        if (Character.toLowerCase(piece) == 'p' && startCol != endCol && board[endRow][endCol] == ' ') {
            handleEnPassant(startRow, endRow, endCol);
        }
    }
    
    private boolean isInCheck(boolean isWhiteKing) {
        // Find king's position
        int[] kingPos = findKing(isWhiteKing);
        if (kingPos == null) return false;
        
        // Check if any opponent's piece can capture the king
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char piece = board[i][j];
                if (piece != ' ' && isWhitePiece(piece) != isWhiteKing) {
                    if (isValidMove(i, j, kingPos[0], kingPos[1])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }
    
    private boolean isWhitePiece(char piece) {
        return Character.isUpperCase(piece);
    }
    
    // Helper methods for move validation and special moves
    private boolean validatePawnMove(char piece, int startRow, int startCol, int endRow, int endCol) {
        return PieceValidation.validatePawnMove(board, piece, startRow, startCol, endRow, endCol);
    }
    
    private boolean validateRookMove(int startRow, int startCol, int endRow, int endCol) {
        return PieceValidation.validateRookMove(board, startRow, startCol, endRow, endCol);
    }
    
    private boolean validateKnightMove(int startRow, int startCol, int endRow, int endCol) {
        return PieceValidation.validateKnightMove(board, startRow, startCol, endRow, endCol);
    }
    
    private boolean validateBishopMove(int startRow, int startCol, int endRow, int endCol) {
        return PieceValidation.validateBishopMove(board, startRow, startCol, endRow, endCol);
    }
    
    private boolean validateQueenMove(int startRow, int startCol, int endRow, int endCol) {
        return PieceValidation.validateQueenMove(board, startRow, startCol, endRow, endCol);
    }
    
    private boolean validateKingMove(char piece, int startRow, int startCol, int endRow, int endCol) {
        return PieceValidation.validateKingMove(board, startRow, startCol, endRow, endCol);
    }
    
    private void handleCastling(int startRow, int startCol, int endRow, int endCol) {
        SpecialMoves.handleCastling(board, startRow, startCol, endRow, endCol);
    }
    
    private void handlePromotion(int endRow, int endCol) {
        SpecialMoves.handlePromotion(board, endRow, endCol);
    }
    
    private void handleEnPassant(int startRow, int endRow, int endCol) {
        SpecialMoves.handleEnPassant(board, startRow, endRow, endCol);
    }
    
    private int[] findKing(boolean isWhiteKing) {
        char kingChar = isWhiteKing ? 'K' : 'k';
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == kingChar) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    
    public char[][] getBoard() {
        return board;
    }
    
    public boolean isWhiteTurn() {
        return isWhiteTurn;
    }
}