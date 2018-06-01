package models.pieces;

import constants.PieceFaction;
import constants.PieceType;
import helpers.IHeld;

public abstract class Piece implements IHeld {

    private PieceType     type;
    private PieceFaction  faction;

    public Piece(PieceFaction faction, PieceType type) {
        this.type      = type;
        this.faction   = faction;
    }

    public PieceFaction getFaction() {
        return this.faction;
    }

    public PieceType getType() {
        return this.type;
    }
}
