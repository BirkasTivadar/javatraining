/*
Épületek
        Készíts egy Building osztályt, melynek három attribútuma a címe (String), az alapterülete és a szintjeinek száma! Az osztály implementálja a Comparable interfészt, és az osztályból készült objektumok legyenek összehasonlíthatóak a szintek száma alapján! Mivel a compareTo() és az equals() metódus által visszaadott értékek összefüggenek, ezért írd felül az osztály equals() és hashCode() metódusát is, hogy ugyanúgy a szintek számát vegyék figyelembe! Írd felül az osztályban a toString() metódust is! Majd ezután az osztály main() metódusában példányosíts egy Building objektumokat tartalmazó TreeSet-et, amelyhez adj hozzá több különböző szintszámú épületet! Végül írd ki ezt a kollekciót a konzolra, és nézd meg, hogy a benne szereplő épületek szintszám szerinti növekvő sorrendben fognak a konzolon szerepelni!
*/

package collectionscomp;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Building implements Comparable<Building>{

    private final String address;
    private final int area;
    private final Integer floors;

    public Building(String address, int area, Integer floors) {
        this.address = address;
        this.area = area;
        this.floors = floors;
    }

    @Override
    public int compareTo(@NotNull Building other) {
        return floors.compareTo(other.floors);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Building building)) return false;
        return floors.equals(building.floors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(floors);
    }

    @Override
    public String toString() {
        return "Building{" +
                "address='" + address + '\'' +
                ", area=" + area +
                ", floors=" + floors +
                '}';
    }

    public static void main(String[] args) {
        Set<Building> buildings = new TreeSet<>();

        buildings.add(new Building("Moszkva", 2345, 5));
        buildings.add(new Building("Győr", 126, 10));
        buildings.add(new Building("Málaga", 345, 2));
        buildings.add(new Building("Havana", 25, 11));

        System.out.println(buildings);
    }
}
