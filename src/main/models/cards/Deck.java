package models.cards;

import helpers.IContainer;
import helpers.IHeld;

import java.util.ArrayList;

public class Deck implements IContainer {

    private ArrayList<IHeld> cards;

    public Deck(){
        this.cards = new ArrayList<>();
    }

    @Override
    public void addItem(IHeld item) {
        cards.add(item);
    }

    public int getSize() {
        return cards.size();
    }

    public IHeld getItem() throws IndexOutOfBoundsException {
        try {
            return this.cards.remove(0);
        } catch (IndexOutOfBoundsException e) {
            throw e;
        }

    }
}
