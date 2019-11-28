package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        Move forwardStep, forwardTwoSteps;
        List<Move> moveList = new ArrayList<Move>();
        if (this.colour.equals(PlayerColour.WHITE)) {
            forwardStep = new Move(from, from.plus(-1, 0));
            if (from.getRow() == 6) {
                forwardTwoSteps = new Move(from, from.plus(-2,0));
                moveList.add(forwardTwoSteps);
            }
        } else {
            forwardStep = new Move(from, from.plus(1, 0));
            if (from.getRow() == 1) {
                forwardTwoSteps = new Move(from, from.plus(2,0));
                moveList.add(forwardTwoSteps);
            }
        }
        moveList.add(forwardStep);
        return moveList;
    }
}
