package models.containers;

import helpers.IContain;
import helpers.IHeld;

import java.util.ArrayList;

public class Container implements IContain {

    private ArrayList<IHeld> items;

    public Container(){
        this.items = new ArrayList<>();
    }

    @Override
    public void addItem(IHeld item) {
        items.add(item);
    }

    public int getSize() {
        return items.size();
    }

    public IHeld getItem() throws IndexOutOfBoundsException {
        try {
            return this.items.remove(0);
        } catch (IndexOutOfBoundsException e) {
            throw e;
        }

    }
}
