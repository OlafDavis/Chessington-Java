package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Knight extends AbstractPiece {
    public Knight(PlayerColour colour) {
        super(PieceType.KNIGHT, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        Integer aDiff, bDiff;
        Coordinates to;
        List<Move> moveList = new ArrayList<>();
        for (aDiff = -2; aDiff <= 2; aDiff += 4) {
            for (bDiff = -1; bDiff <= 1; bDiff += 2) {
                to = from.plus(aDiff, bDiff);
                if (board.isEmptyOrColour(to, colour.getOpposite())) {
                    moveList.add(new Move(from, to));
                }
                to = from.plus(bDiff, aDiff);
                if (board.isEmptyOrColour(to, colour.getOpposite())) {
                    moveList.add(new Move(from, to));
                }
            }
        }
        return moveList;
    }
}
