/*
A ChristmasShopping osztálynak legyen egy ChristmasPresent lista attribútuma, amelyet konstruktorban kap meg! Legyen hozzá egy addNewPresent(ChristmasPresent present) metódusa, egy getter, valamint egy removeTooExpensivePresent(int maxPrice) metódus, amellyel törölni lehet a listából a paraméterként megadott árnál drágább ajándékokat! Ez utóbbit iterátorral valósítsd meg!
*/

package collectionsiterator.christmas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChristmasShopping {

    private final List<ChristmasPresent> presents;

    public ChristmasShopping(List<ChristmasPresent> presents) {
        this.presents = new ArrayList<>(presents);
    }

    public List<ChristmasPresent> getPresents() {
        return new ArrayList<>(presents);
    }

    public void addNewPresent(ChristmasPresent present) {
        presents.add(present);
    }

    public void removeTooExpensivePresent(int maxPrice) {
        Iterator<ChristmasPresent> cpi = presents.iterator();
        while (cpi.hasNext()) {
            if (cpi.next().price() > maxPrice) cpi.remove();
        }
//      presents.removeIf(christmasPresent -> christmasPresent.price() > maxPrice);


    }
}
