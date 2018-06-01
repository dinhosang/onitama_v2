package helpers;

import constants.CoordinateAxis;

import java.util.HashMap;

public final class convertMoves {

    // created so that if method of storing moves changes, I do not need to change all the tests, just the methods here.
    // Will also help with game logic, preventing extra modifications there as well.

    public static Integer getCoordX(HashMap<CoordinateAxis, Integer> move) {
        return move.get(CoordinateAxis.X);
    }

    public static Integer getCoordY(HashMap<CoordinateAxis, Integer> move) {
        return move.get(CoordinateAxis.Y);
    }
}
