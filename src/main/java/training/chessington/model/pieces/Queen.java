package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Queen extends LinearPiece {
    public Queen(PlayerColour colour) {
        super(PieceType.QUEEN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        Integer rowDiff, colDiff;
        List<Move> movesList = new ArrayList<Move>();
        for (rowDiff = -1; rowDiff <= 1; rowDiff++) {
            for (colDiff = -1; colDiff <= 1; colDiff++) {
                movesList.addAll(getAllowedMovesOneDirection(from, board, rowDiff,colDiff));
            }
        }
        return movesList;
    }
}
