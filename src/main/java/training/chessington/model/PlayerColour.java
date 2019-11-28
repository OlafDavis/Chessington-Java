package training.chessington.model;

public enum PlayerColour {
    WHITE, BLACK;
    public PlayerColour getOpposite() {
        return this == WHITE ? BLACK : WHITE;
    }
    public Integer getBackRow() {
        return this == WHITE ? 7 : 0;
    }
    public Integer getPawnRow() {
        return this == WHITE ? 6 : 1;
    }
    public Integer getEndRow() {
        return this == WHITE ? 0 : 7;
    }
}
