package models.cards;

import constants.CoordinateAxis;
import constants.PieceFaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public abstract class Card {


    protected String name;
    protected PieceFaction faction;
    protected ArrayList<HashMap<CoordinateAxis, Integer>> moves;

    public Card(String name, PieceFaction faction, ArrayList<HashMap<CoordinateAxis,Integer>> moves) {
        this.name       = name;
        this.faction    = faction;
        this.moves      = moves;
    }

    public String getName() {
        return this.name;
    }

    public PieceFaction getFaction() {
        return this.faction;
    }

    public ArrayList<HashMap<CoordinateAxis,Integer>> getMoves() {
        ArrayList<HashMap<CoordinateAxis, Integer>> copyMoves = new ArrayList<>(this.moves);
        return copyMoves;
    }
}
