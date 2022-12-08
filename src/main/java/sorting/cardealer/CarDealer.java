/*
Autókereskedés
        Legyen egy Car osztály, amelynek három attribútuma legyen: egy márkanév, a gyártás éve és egy ár! Mivel az autóvásárláskor több szempont is felmerülhet, lehessen őket többféleképpen is összehasonlítani: legyen két segédosztály, egy CarConstructionComparator és egy CarPriceComparator, amely mindkettő implementálja a Comparator interfészt, és az első a gyártás éve, a második az ár alapján hasonlítja össze az autókat! Ezután legyen egy CarDealer osztály, amelynek legyen egy listája az eladni szándékozott autókról, és legyen két metódusa: az egyik adjon vissza egy listát a gyártási év alapján sorbarendezett autókról, a másik pedig adjon vissza egy listát az ár szerint sorbarendezett autókról! Vigyázz, hogy az eredeti lista sorrendje ne változzon!
*/

package sorting.cardealer;

import java.util.ArrayList;
import java.util.List;

public class CarDealer {

    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCarsOrderedByYearOfConstruction() {
        List<Car> result = new ArrayList<>(cars);
        result.sort(new CarConstructionComparator());
        return result;
    }

    public List<Car> getCarsOrderedByPrice() {
        List<Car> result = new ArrayList<>(cars);
        result.sort(new CarPriceComparator());
        return result;
    }
}
