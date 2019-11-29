package training.chessington.model;

import java.util.Objects;

import static training.chessington.model.MoveType.NORMAL;

public final class Move {
    private final Coordinates from;
    private final Coordinates to;
    private final MoveType type;

    public Move(Coordinates from, Coordinates to) {
        this.from = from;
        this.to = to;
        this.type = NORMAL;
    }

    public Move(Coordinates from, Coordinates to, MoveType type) {
        this.from = from;
        this.to = to;
        this.type = type;
    }

    public Coordinates getFrom() {
        return from;
    }

    public Coordinates getTo() {
        return to;
    }

    public MoveType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return Objects.equals(from, move.from) &&
                Objects.equals(to, move.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

    @Override
    public String toString() {
        return "from " + from + " to " + to;
    }
}
