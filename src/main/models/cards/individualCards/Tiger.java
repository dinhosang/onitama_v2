package models.cards.individualCards;

import constants.CoordinateAxis;
import constants.PieceFaction;
import models.cards.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Tiger extends Card {

    public Tiger(){

        super("Tiger", PieceFaction.BLUE);
        this.prepareMoves();
    }

    @Override
    protected void prepareMoves() {

        ArrayList<HashMap<CoordinateAxis, Integer>> moves;
        HashMap<CoordinateAxis, Integer> move1, move2;

        move1 = new HashMap<>();
        move2 = new HashMap<>();

        move1.put(CoordinateAxis.X, 0);
        move1.put(CoordinateAxis.Y, 2);

        move2.put(CoordinateAxis.X, 0);
        move2.put(CoordinateAxis.Y, -1);

        moves = new ArrayList<>(Arrays.asList(move1, move2));

        this.setMoves(moves);
    }
}
