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
        List<Move> moveList = getAllowedSteps(from, board);
        moveList.addAll(getAllowedCaptures(from, board));
        return moveList;
    }

    private List<Move> getAllowedSteps(Coordinates from, Board board) {
        Move forwardStep, forwardTwoSteps;
        Integer rowDiff = this.colour.equals(PlayerColour.WHITE) ? -1 : 1;
        Integer startRow = this.colour.equals(PlayerColour.WHITE) ? 6 : 1;
        Coordinates squareInFront = from.plus(rowDiff,0);
        Coordinates squareTwoInFront = from.plus(rowDiff * 2,0);
        List<Move> moveList = new ArrayList<Move>();
        if (board.isEmpty(squareInFront)) {
            forwardStep = new Move(from, from.plus(rowDiff, 0));
            moveList.add(forwardStep);
            if (from.getRow() == startRow && board.isEmpty(squareTwoInFront)) {
                forwardTwoSteps = new Move(from, from.plus(rowDiff * 2, 0));
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
            if (capturePossible(from.plus(rowDiff, colDiff), board, getColour())) {
                moveList.add(new Move(from, from.plus(rowDiff, colDiff)));
            }
        }
        return moveList;
    }

    private Boolean capturePossible(Coordinates to, Board board, PlayerColour myColour) {
            return (to.inBounds() && !board.isEmpty(to) && board.get(to).getColour() != myColour);
    }

}
