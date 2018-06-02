package helpers;

public interface IContain {

    void addItem(IHeld item);

    int getSize();

    IHeld getItem() throws IndexOutOfBoundsException;

}
