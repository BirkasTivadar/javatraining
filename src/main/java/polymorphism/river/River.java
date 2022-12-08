/*
Folyó
    A river csomagban készíts egy Water nevű üres (marker) interfészt! Ezt implementálja egy River nevű absztrakt osztály, amelynek van két attribútuma (private String name és private int length), az ezek értékét beállító konstruktora, valamint getter metódusai. Hozz létre még egy Danube nevű osztályt, amely a River leszármazottja legyen, és tartalmazzon egy List<String> capitals nevű listát is, melyben azon fővárosok neve található, amiken keresztülfolyik! Ennek a tartalmát a konstruktoron keresztül kapja meg, és legyen hozzá egy getter metódus is!
        Végül a Danube tartalmazzon még egy main() metódust is, melyben hozz létre három változót, egyet Water, egyet River és egyet pedig Danube statikus típussal, és mindegyiknek adj értékül egy új Danube objektumot! Írd ki a konzolra az összes metódus által visszaadott értéket, amelyet az egyes változókon meg tudsz hívni (a változó statikus típusa határozza meg, hogy milyen metódusokat tud használni)!
*/

package polymorphism.river;

public abstract class River implements Water {

    private final String name;
    private final int length;

    public River(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }
}
