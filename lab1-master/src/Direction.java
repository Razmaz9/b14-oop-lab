package src;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    private static final Direction[] directions = values();

    public Direction getNext() {
        return directions[(this.ordinal() + 1) % directions.length];
    }

    public Direction getPrevious() {
        return directions[(this.ordinal() + directions.length - 1) % directions.length];
    }
}
