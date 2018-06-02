package constants;

public enum MoveDirection {

    UP(1),
    RIGHT(1),
    DOWN(-1),
    LEFT(-1);

    private final int value;

    MoveDirection(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
