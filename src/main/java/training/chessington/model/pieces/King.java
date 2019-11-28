package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class King extends AbstractPiece {
    public King(PlayerColour colour) {
        super(PieceType.KING, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        Integer rowDiff, colDiff;
        Coordinates to;
        List<Move> movesList = new ArrayList<Move>();
        for (rowDiff = -1; rowDiff <= 1; rowDiff++) {
            for (colDiff = -1; colDiff <= 1; colDiff++) {
                to = from.plus(rowDiff, colDiff);
                if (board.isEmptyOrColour(to, colour.getOpposite())) {
                    movesList.add(new Move(from, to));
                }
            }
        }
        return movesList;
    }
}
