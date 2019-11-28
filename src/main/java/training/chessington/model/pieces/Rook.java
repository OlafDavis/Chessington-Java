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
        Integer step;
        Coordinates to;
        List<Move> movesList = new ArrayList<>();
        Boolean canMove = true;
        while (canMove) {

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
