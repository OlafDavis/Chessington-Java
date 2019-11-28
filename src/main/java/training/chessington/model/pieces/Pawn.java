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
        Move forwardStep, forwardTwoSteps, capture;
        List<Move> moveList = new ArrayList<Move>();
        if (this.colour.equals(PlayerColour.WHITE)) {
            if (board.isEmpty(from.plus(-1,0))) {
                forwardStep = new Move(from, from.plus(-1, 0));
                moveList.add(forwardStep);
                if (from.getRow() == 6) {
                    forwardTwoSteps = new Move(from, from.plus(-2, 0));
                    moveList.add(forwardTwoSteps);
                }
            }
            if (from.plus(-1,1).inBounds()
                    && !board.isEmpty(from.plus(-1,1))
                    && board.get(from.plus(-1,1)).getColour() == PlayerColour.BLACK) {
                capture = new Move(from, from.plus(-1,1));
                moveList.add(capture);
            }
            if (from.plus(-1,-1).inBounds()
                    && !board.isEmpty(from.plus(-1,-1))
                    && board.get(from.plus(-1,-1)).getColour() == PlayerColour.BLACK) {
                capture = new Move(from, from.plus(-1,-1));
                moveList.add(capture);
            }
        } else if (this.colour.equals(PlayerColour.BLACK)) {
            if (board.isEmpty(from.plus(1,0))) {
                forwardStep = new Move(from, from.plus(1, 0));
                moveList.add(forwardStep);
                if (from.getRow() == 1) {
                    forwardTwoSteps = new Move(from, from.plus(2, 0));
                    moveList.add(forwardTwoSteps);
                }
            }
            if (from.plus(1,1).inBounds()
                    && !board.isEmpty(from.plus(1,1))
                    && board.get(from.plus(1,1)).getColour() == PlayerColour.WHITE) {
                capture = new Move(from, from.plus(1,1));
                moveList.add(capture);
            }
            if (from.plus(1,-1).inBounds()
                    && !board.isEmpty(from.plus(1,-1))
                    && board.get(from.plus(1,-1)).getColour() == PlayerColour.WHITE) {
                capture = new Move(from, from.plus(1,-1));
                moveList.add(capture);
            }
        }
        return moveList;
    }
    

}
