package models.cards.individualCards;

import constants.CoordinateAxis;
import constants.PieceFaction;
import models.cards.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Dragon extends Card {

    public Dragon(){

        super("Dragon", PieceFaction.RED);
        this.prepareMoves();
    }

    @Override
    protected void prepareMoves() {

        ArrayList<HashMap<CoordinateAxis, Integer>> moves;
        HashMap<CoordinateAxis, Integer> move1, move2, move3, move4;

        move1 = new HashMap<>();
        move2 = new HashMap<>();
        move3 = new HashMap<>();
        move4 = new HashMap<>();

        move1.put(CoordinateAxis.X, 2);
        move1.put(CoordinateAxis.Y, 1);

        move2.put(CoordinateAxis.X, -2);
        move2.put(CoordinateAxis.Y, 1);

        move3.put(CoordinateAxis.X, 1);
        move3.put(CoordinateAxis.Y, -1);

        move4.put(CoordinateAxis.X, -1);
        move4.put(CoordinateAxis.Y, -1);

        moves = new ArrayList<>(Arrays.asList(move1, move2, move3, move4));

        this.setMoves(moves);
    }

}
