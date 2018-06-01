package models.cards;

import constants.CoordinateAxis;
import constants.PieceFaction;
import helpers.IHeld;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Card implements IHeld {


    private String name;
    private PieceFaction faction;
    private ArrayList<HashMap<CoordinateAxis, Integer>> moves;

    public Card(String name, PieceFaction faction) {
        this.name       = name;
        this.faction    = faction;
        this.moves      = null;
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

    protected void setMoves(ArrayList<HashMap<CoordinateAxis,Integer>> movesList) {
        this.moves = movesList;
    }

    protected abstract void prepareMoves();
}
