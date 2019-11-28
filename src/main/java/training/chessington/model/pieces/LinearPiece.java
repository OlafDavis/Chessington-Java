package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public abstract class LinearPiece extends AbstractPiece {
    public LinearPiece(Piece.PieceType type,  PlayerColour colour) {
        super(type, colour);
    }

    protected List<Move> getAllowedMovesOneDirection(Coordinates from, Board board, Integer rowDiff, Integer colDiff) {
        Coordinates to = from;
        List<Move> movesList = new ArrayList<>();
        while (true) {
            to = to.plus(rowDiff, colDiff);
            if (board.isEmptyOrColour(to, colour.getOpposite())){
                movesList.add(new Move(from, to));
            }
            if (!board.isEmpty(to)) { return movesList; }
        }
    }
}
