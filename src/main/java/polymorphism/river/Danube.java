/*
Hozz létre még egy Danube nevű osztályt, amely a River leszármazottja legyen, és tartalmazzon egy List<String> capitals nevű listát is, melyben azon fővárosok neve található, amiken keresztülfolyik! Ennek a tartalmát a konstruktoron keresztül kapja meg, és legyen hozzá egy getter metódus is!
        Végül a Danube tartalmazzon még egy main() metódust is, melyben hozz létre három változót, egyet Water, egyet River és egyet pedig Danube statikus típussal, és mindegyiknek adj értékül egy új Danube objektumot! Írd ki a konzolra az összes metódus által visszaadott értéket, amelyet az egyes változókon meg tudsz hívni (a változó statikus típusa határozza meg, hogy milyen metódusokat tud használni)!
*/

package polymorphism.river;

import java.util.ArrayList;
import java.util.List;

public class Danube extends River {

    private final List<String> capitals;

    public Danube(String name, int length, List<String> capitals) {
        super(name, length);
        this.capitals = new ArrayList<>(capitals);
    }

    public List<String> getCapitals() {
        return new ArrayList<>(capitals);
    }

    public static void main(String[] args) {
        Water water = new Danube("Duna", 2850, List.of("Bécs", "Pozsony"));
        River river = new Danube("Danube", 2850, List.of( "Budapest"));
        Danube danube = new Danube("Danubio", 2850, List.of("GYŐR","Belgrád"));

        System.out.println(river.getName());
        System.out.println(river.getLength());

        System.out.println(danube.getName());
        System.out.println(danube.getLength());
        System.out.println(danube.getCapitals());
    }
}
