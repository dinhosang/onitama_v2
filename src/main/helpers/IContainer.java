package helpers;

public interface IContainer {

    void addItem(IHeld item) throws IllegalArgumentException;

    int getSize();

    IHeld getItem() throws IndexOutOfBoundsException;

}
