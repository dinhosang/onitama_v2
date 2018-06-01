package helpers;

public interface IContainer {

    void addItem(IHeld item);

    int getSize();

    IHeld getItem() throws IndexOutOfBoundsException;

}
