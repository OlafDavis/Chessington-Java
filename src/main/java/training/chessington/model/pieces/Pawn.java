package training.chessington.model.pieces;

import training.chessington.model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> moveList = getAllowedSteps(from, board);
        moveList.addAll(getAllowedCaptures(from, board));
        return moveList;
    }

    private List<Move> getAllowedSteps(Coordinates from, Board board) {
        Move forwardStep, forwardTwoSteps;
        Integer rowDiff = this.colour.equals(PlayerColour.WHITE) ? -1 : 1;
        Coordinates squareInFront = from.plus(rowDiff,0);
        Coordinates squareTwoInFront = from.plus(rowDiff * 2,0);
        List<Move> moveList = new ArrayList<Move>();
        if (board.isEmpty(squareInFront)) {
            forwardStep = pawnMove(from, from.plus(rowDiff, 0));
            moveList.add(forwardStep);
            if (!getHasMoved() && board.isEmpty(squareTwoInFront)) {
                forwardTwoSteps = pawnMove(from, from.plus(rowDiff * 2, 0));
                moveList.add(forwardTwoSteps);
            }
        }
        return moveList;
    }

    private List<Move> getAllowedCaptures(Coordinates from, Board board) {
        List<Move> moveList = new ArrayList<Move>();
        Integer rowDiff = this.colour.equals(PlayerColour.WHITE) ? -1 : 1;
        Integer[] colDiffs =  {1,-1};
        for (Integer colDiff : colDiffs) {
            if (board.isColour(from.plus(rowDiff, colDiff), colour.getOpposite())) {
                moveList.add(pawnMove(from, from.plus(rowDiff, colDiff)));
            }
        }
        return moveList;
    }

    private Move pawnMove(Coordinates from, Coordinates to) {
        if (to.getRow() == colour.getEndRow()) {
            return new Move(from, to, MoveType.PROMOTION);
        } else {
            return new Move(from, to);
        }
    }

}
