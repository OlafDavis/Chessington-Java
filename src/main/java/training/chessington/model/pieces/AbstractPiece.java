package training.chessington.model.pieces;

import training.chessington.model.PlayerColour;

public abstract class AbstractPiece implements Piece {

    protected final Piece.PieceType type;
    protected final PlayerColour colour;
    protected Boolean hasMoved;

    protected AbstractPiece(Piece.PieceType type, PlayerColour colour) {
        this.type = type;
        this.colour = colour;
        this.hasMoved = false;
    }

    @Override
    public Boolean getHasMoved() {
        return hasMoved;
    }

    @Override
    public void setHasMoved() {
        hasMoved = true;
    }

    @Override
    public Piece.PieceType getType() {
        return type;
    }

    @Override
    public PlayerColour getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return colour.toString() + " " + type.toString();
    }
}
