/*
Virágcsokor
        Készíts egy BunchOfFlowers osztályt, és ennek legyen egy LinkedList típusú listája, amely egy virágcsokrot reprezentál! A virágcsokorban String objektumok reprezentálják az egyes virágszálakat! Legyen az osztálynak egy addFlowerInTheMiddle(String flower)metódusa, amely a paraméterül átadott szál virágot éppen a csokor közepére illeszti be, ha a csokor páros számú szálat tartalmaz! Ha azonban a csokorban páratlan számú virág van, akkor pedig a középen lévő elem jobb és bal oldalára tegyen be egyet-egyet a paraméterként átadott szál virágból!
*/

package collectionslist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BunchOfFlowers {

    private final List<String> bunch = new LinkedList<>();

    public List<String> getBunch() {
        return new ArrayList<>(bunch);
    }

    public void addFlower(String flower) {
        bunch.add(flower);
    }

    public void addFlowerInTheMiddle(String flower) {
        int bunchSize = bunch.size();
        int center = bunchSize / 2;
        if (bunchSize % 2 == 0) bunch.add(center, flower);
        else {
            bunch.add(center, flower);
            bunch.add(center + 2, flower);
        }
    }
}
