/*
Használt autók
        Hozz létre egy Car osztályt, amelynek attribútumai a következők: márka, típus, ár, hossz (méterben)!
        A UsedCars osztály tartalmazzon egy listát az eladni szándékozott autókról és legyen három metódusa:
        listCarsByPrice(): visszaad egy olyan listát, amelyben az autók áruk szerint sorbarendezve szerepelnek.
        listCarsByLengthDesc() : visszaad egy olyan listát, amelyben az autók hosszuk szerint fordított sorrendben szerepelnek (tehát a leghosszabb van elöl).
        listCarsOneBrandByType(String brand) : visszaad egy olyan listát, amelyben csak a megadott márkájú autók szerepelnek, típus szerint ábécé-sorrendben.
        Ahol csak lehet, használj lambda-kifejezést vagy metódus referenciát! Minden metódus egy-egy új listát adjon vissza, egyik se az eredeti lista tartalmát rendezze!
*/

package lambdaintro.cars;

import java.util.ArrayList;
import java.util.List;

public class UsedCars {

    private final List<Car> cars;

    public UsedCars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> listCarsByPrice() {
        List<Car> result = new ArrayList<>(cars);
        result.sort((c1, c2) -> c1.price() - c2.price());
        return result;
    }

    public List<Car> listCarsByLengthDesc() {
        List<Car> result = new ArrayList<>(cars);
        result.sort((c1, c2) -> Double.valueOf(c2.length()).compareTo(c1.length()));
        return result;
    }

    public List<Car> listCarsOneBrandByType(String brand) {
        List<Car> result = new ArrayList<>(cars);
        return result.stream()
                .filter(c -> c.brand().equals(brand))
                .sorted((c1, c2) -> c1.type().compareTo(c2.type()))
                .toList();
    }
}
