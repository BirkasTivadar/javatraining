/*
SmallBox, amely S méretű és 1000 Ft-ért szállítja a futárcég.
*/

package interfacedependencyinversion.box;

public class SmallBox implements Box {

    @Override
    public Size getSize() {
        return Size.S;
    }

    @Override
    public int getPrice() {
        return 1000;
    }
}
