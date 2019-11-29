package training.chessington.model;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import training.chessington.model.pieces.*;

import java.util.List;

public class Board {
    private static final Logger LOGGER = LogManager.getLogger();

    private Piece[][] board = new Piece[8][8];

    private Board() {
    }

    public static Board forNewGame() {
        Board board = new Board();
        board.setBackRow(0, PlayerColour.BLACK);
        board.setBackRow(7, PlayerColour.WHITE);

        for (int col = 0; col < 8; col++) {
            board.board[1][col] = new Pawn(PlayerColour.BLACK);
            board.board[6][col] = new Pawn(PlayerColour.WHITE);
        }
        return board;
    }

    public static Board empty() {
        return new Board();
    }

    private void setBackRow(int rowIndex, PlayerColour colour) {
        board[rowIndex][0] = new Rook(colour);
        board[rowIndex][1] = new Knight(colour);
        board[rowIndex][2] = new Bishop(colour);
        board[rowIndex][3] = new Queen(colour);
        board[rowIndex][4] = new King(colour);
        board[rowIndex][5] = new Bishop(colour);
        board[rowIndex][6] = new Knight(colour);
        board[rowIndex][7] = new Rook(colour);
    }

    public Piece get(Coordinates coords) {
        return board[coords.getRow()][coords.getCol()];
    }

    public Boolean isEmptyOrColour(Coordinates coords, PlayerColour colour) {
        if (coords.inBounds()) {
            Piece piece = board[coords.getRow()][coords.getCol()];
            return piece == null || piece.getColour() == colour;
        } else {
            return false;
        }
    }

    public Boolean isColour(Coordinates coords, PlayerColour colour) {
        if (coords.inBounds()) {
            Piece piece = board[coords.getRow()][coords.getCol()];
            return piece != null && piece.getColour() == colour;
        } else {
            return false;
        }
    }

    public Boolean isEmpty(Coordinates coords) {
        return (coords.inBounds() && board[coords.getRow()][coords.getCol()] == null);
    }

    public void move(Coordinates from, Coordinates to, MoveType type) {
        Piece piece = board[from.getRow()][from.getCol()];
        PlayerColour colour = piece.getColour();
        piece.setHasMoved();
        board[to.getRow()][to.getCol()] = piece;
        board[from.getRow()][from.getCol()] = null;
        switch (type) {
            case PROMOTION:
                promoteToQueen(to, colour);
                break;
            case LEFTCASTLE:
                moveRookCastle(colour, MoveType.LEFTCASTLE);
                break;
            case RIGHTCASTLE:
                moveRookCastle(colour, MoveType.RIGHTCASTLE);
                break;
        }
    }

    private void moveRookCastle(PlayerColour colour, MoveType type) {
        Integer backRow = colour.getBackRow();
        Integer fromCol = type.equals(MoveType.LEFTCASTLE) ? 0 : 7;
        Integer toCol = type.equals(MoveType.LEFTCASTLE) ? 3 : 5;
        Piece piece = board[backRow][fromCol];
        board[backRow][toCol] = piece;
        board[backRow][fromCol] = null;
    }

    private void promoteToQueen(Coordinates coords, PlayerColour colour) {
        board[coords.getRow()][coords.getCol()] = new Queen(colour);
    }

    public void placePiece(Coordinates coords, Piece piece) {
        board[coords.getRow()][coords.getCol()] = piece;
    }
}
