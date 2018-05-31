package models.cards;

import constants.CoordinateAxis;
import constants.PieceFaction;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Card {


    protected String name;
    protected PieceFaction faction;

    public Card(String name, PieceFaction faction, ArrayList<HashMap<CoordinateAxis,Integer>> moves) {
        this.name       = name;
        this.faction    = faction;
    }

    public String getName() {
        return this.name;
    }

    public PieceFaction getFaction() {
        return this.faction;
    }
}
