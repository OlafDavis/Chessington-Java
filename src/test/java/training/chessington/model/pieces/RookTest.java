package training.chessington.model.pieces;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

public class RookTest {

    @Test
    public void whiteRookCanMoveOnEmptyBoard() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-6, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, 3)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -4)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -1)));
    }

    @Test
    public void blackRookCanMoveOnEmptyBoard() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0, 7);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(4, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(7, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -3)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -4)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -7)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -1)));
    }

    @Test
    public void whiteRookCanCapture() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(3,5);
        board.placePiece(coords, rook);
        board.placePiece(new Coordinates(3, 7), new Rook(PlayerColour.BLACK));
        board.placePiece(new Coordinates(3, 1), new Rook(PlayerColour.BLACK));
        board.placePiece(new Coordinates(0, 5), new Rook(PlayerColour.BLACK));
        board.placePiece(new Coordinates(5, 5), new Rook(PlayerColour.BLACK));

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(0, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -4)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));
    }

    @Test
    public void blackRookCanCapture() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(3,5);
        board.placePiece(coords, rook);
        board.placePiece(new Coordinates(3, 7), new Rook(PlayerColour.WHITE));
        board.placePiece(new Coordinates(3, 1), new Rook(PlayerColour.WHITE));
        board.placePiece(new Coordinates(0, 5), new Rook(PlayerColour.WHITE));
        board.placePiece(new Coordinates(7, 5), new Rook(PlayerColour.WHITE));

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(0, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -4)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));
    }

    @Test
    public void blackRookCannotCaptureFriendly() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(3,5);
        board.placePiece(coords, rook);
        board.placePiece(new Coordinates(3, 7), new Rook(PlayerColour.BLACK));
        board.placePiece(new Coordinates(3, 1), new Rook(PlayerColour.BLACK));
        board.placePiece(new Coordinates(0, 5), new Rook(PlayerColour.BLACK));
        board.placePiece(new Coordinates(2, 5), new Rook(PlayerColour.BLACK));

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0, 2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0, -4)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-3, 0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1, 0)));
    }

    @Test
    public void whiteRookCannotCaptureFriendly() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(3,5);
        board.placePiece(coords, rook);
        board.placePiece(new Coordinates(3, 7), new Rook(PlayerColour.WHITE));
        board.placePiece(new Coordinates(3, 1), new Rook(PlayerColour.WHITE));
        board.placePiece(new Coordinates(0, 5), new Rook(PlayerColour.WHITE));
        board.placePiece(new Coordinates(2, 5), new Rook(PlayerColour.WHITE));

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0, 2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0, -4)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-3, 0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1, 0)));
    }

//    @Test
//    public void whiteRookCannotMoveIfPieceBlocking() {
//        // Arrange
//        Board board = Board.empty();
//        Piece rook = new Rook(PlayerColour.BLACK);
//        Coordinates coords = new Coordinates(3,5);
//        board.placePiece(coords, rook);
//        board.placePiece(new Coordinates(3, 7), new Rook(PlayerColour.WHITE));
//        board.placePiece(new Coordinates(3, 1), new Rook(PlayerColour.WHITE));
//        board.placePiece(new Coordinates(0, 5), new Rook(PlayerColour.WHITE));
//        board.placePiece(new Coordinates(2, 5), new Rook(PlayerColour.WHITE));
//
//        // Act
//        List<Move> moves = rook.getAllowedMoves(coords, board);
//
//        // Assert
//        assertThat(moves).contains(new Move(coords, coords.plus(0, 2)));
//        assertThat(moves).contains(new Move(coords, coords.plus(0, -4)));
//        assertThat(moves).contains(new Move(coords, coords.plus(-3, 0)));
//        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));
//    }

}
