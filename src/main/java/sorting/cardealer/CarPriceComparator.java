/*
Mivel az autóvásárláskor több szempont is felmerülhet, lehessen őket többféleképpen is összehasonlítani: legyen két segédosztály, egy CarConstructionComparator és egy CarPriceComparator, amely mindkettő implementálja a Comparator interfészt, és az első a gyártás éve, a második az ár alapján hasonlítja össze az autókat!
*/

package sorting.cardealer;

import java.util.Comparator;

public class CarPriceComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return o1.price() - o2.price();
    }
}
