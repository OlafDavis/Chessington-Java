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
        while (true) {
            to = to.plus(rowDiff, colDiff);
            if (board.isEmptyOrColour(to, colour.getOpposite())){
                movesList.add(new Move(from, to));
            }
            if (!board.isEmpty(to)) { return movesList; }
        }
    }
}
