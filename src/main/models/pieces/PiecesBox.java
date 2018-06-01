package models.pieces;

import helpers.IContainer;
import helpers.IHeld;

import java.util.ArrayList;


public class PiecesBox implements IContainer {


    private ArrayList<IHeld> pieces;


    public PiecesBox(){
        this.pieces = new ArrayList<>();
    }

    @Override
    public void addItem(IHeld item) {
        pieces.add(item);
    }

    public int getSize() {
        return pieces.size();
    }

    public IHeld getItem() throws IndexOutOfBoundsException {
        try {
            return this.pieces.remove(0);
        } catch (IndexOutOfBoundsException e) {
            throw e;
        }
    }


}
