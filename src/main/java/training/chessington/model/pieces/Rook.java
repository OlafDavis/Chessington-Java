package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece {
    public Rook(PlayerColour colour) {
        super(PieceType.ROOK, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> movesList = getAllowedMovesOneDirection(from, board, 1,0);
        movesList.addAll(getAllowedMovesOneDirection(from, board, -1,0));
        movesList.addAll(getAllowedMovesOneDirection(from, board, 0,1));
        movesList.addAll(getAllowedMovesOneDirection(from, board, 0,-1));
        return movesList;
    }

    public List<Move> getAllowedMovesOneDirection(Coordinates from, Board board, Integer rowDiff, Integer colDiff) {
        Coordinates to = from;
        List<Move> movesList = new ArrayList<>();
        Boolean canMoveFurther = true;
        while (canMoveFurther) {
            to = to.plus(rowDiff, colDiff);
            if (!to.inBounds()) {
                canMoveFurther = false;
            }
            else if (board.isEmpty(to)) {
                movesList.add(new Move(from, to));
                canMoveFurther = true;
            } else if (board.get(to).getColour() != board.get(from).getColour()) {
                movesList.add(new Move(from, to));
                canMoveFurther = false;
            }
        }
        return movesList;
    }


//    public List<Move> getAllowedMoves(Coordinates from, Board board) {
//        Integer coord;
//        Coordinates to;
//        List<Move> movesList = new ArrayList<>();
//        for (coord = 0; coord <= 7; coord++) {
//            to = new Coordinates(coord,from.getCol());
//            movesList.add(new Move(from, to));
//            to = new Coordinates(from.getRow(),coord);
//            movesList.add(new Move(from, to));
//        }
//        return movesList;
//    }
}
