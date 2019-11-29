package training.chessington.model.pieces;

import training.chessington.model.*;

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
        movesList.addAll(getCastlingMoves(from, board));
        return movesList;
    }

    private List<Move> getCastlingMoves(Coordinates from, Board board) {
        Boolean blocked;
        List<Move> movesList = new ArrayList<Move>();
        Integer backRow = board.get(from).getColour().getBackRow();
        Coordinates leftTarget = from.plus(0,-2);
        Coordinates leftRookCoords = new Coordinates(backRow, 0);
        Piece leftCornerPiece = board.get(leftRookCoords);
        blocked = false;
        for (Integer col = 1; col < from.getCol(); col++) {
            if (!board.isEmpty(new Coordinates(backRow, col))) {
                blocked = true;
            }
        }
        if (!blocked && !getHasMoved() && !leftCornerPiece.getHasMoved()) {
            movesList.add(new Move(from, leftTarget, MoveType.LEFTCASTLE));
        }
        Coordinates rightTarget = from.plus(0,2);
        Coordinates rightRookCoords = new Coordinates(backRow, 7);
        Piece rightCornerPiece = board.get(rightRookCoords);
        blocked = false;
        for (Integer col = 6; col > from.getCol(); col--) {
            if (!board.isEmpty(new Coordinates(backRow, col))) {
                blocked = true;
            }
        }
        if (!blocked && !getHasMoved() && !rightCornerPiece.getHasMoved()) {
            movesList.add(new Move(from, rightTarget, MoveType.RIGHTCASTLE));
        }
        return movesList;
    }

}
