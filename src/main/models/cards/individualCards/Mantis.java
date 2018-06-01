package models.cards.individualCards;

import constants.CoordinateAxis;
import constants.PieceFaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Mantis extends models.cards.Card {

    public Mantis(){

        super("Mantis", PieceFaction.RED);
        this.prepareMoves();
    }

    @Override
    protected void prepareMoves() {

        ArrayList<HashMap<CoordinateAxis, Integer>> moves;
        HashMap<CoordinateAxis, Integer> move1, move2, move3;

        move1 = new HashMap<>();
        move2 = new HashMap<>();
        move3 = new HashMap<>();

        move1.put(CoordinateAxis.X, 0);
        move1.put(CoordinateAxis.Y, -1);

        move2.put(CoordinateAxis.X, 1);
        move2.put(CoordinateAxis.Y, 1);

        move3.put(CoordinateAxis.X, -1);
        move3.put(CoordinateAxis.Y, 1);

        moves = new ArrayList<>(Arrays.asList(move1, move2, move3));

        this.setMoves(moves);
    }
}
