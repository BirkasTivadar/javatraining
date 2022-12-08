/*
A vehicle csomagban készítsd el az alábbi osztályokat!
    Hozz létre egy Vehicle osztályt! Ez az általános jármű osztály, van önsúlya és legalább egy vezetője. Ezek adják a teljes súlyát.
        Vezess be egy vehicleWeight privát attribútumot, ez a jármű súlya!
        Legyen egy PERSON_AVERAGE_WEIGHT konstans érték: egy személy átlagos súlyát tartalmazza. Az értéke legyen 75!
        Hozz létre egy konstruktort, amely megkap egy értéket az attribútum számára, és beállítja azt!
        Szükséges metódus a getGrossLoad(), amely visszaadja a mozgó jármű súlyát. (A jármű súlyához adjuk hozzá a sofőr súlyát!)
        Írd felül az osztály toString() metódusát, hogy a következő formában adja vissza a jármű adatait: Vehicle{vehicleWeight=1000}
        Hozz létre egy Car osztályt, amely az általánosabb jármű (Vehicle) osztályból származik a következők alapján:
        Az osztály tartalmazzon egy numberOfPassenger attribútumot: egész szám, amely az utasok számát jelenti (sofőr nélkül)!
        Legyen konstruktora, amely megkap két értéket az attribútumok számára, és beállítja azokat (az ős attribútumát a super hívással)!
        A getGrossLoad() metódus visszaadja a mozgó gépkocsi súlyát. Hívd az ős azonos nevű metódusát, és add hozzá az utasok súlyát! (Ez lesz a visszatérési érték.)
        Definiáld felül a toString() metódust a következő formára: Car{numberOfPassenger=4, vehicleWeight=1700}
        Hozz létre egy Van osztályt, amely egy kisteherautót modellez! Ez az osztály az általános autóból származik, kiterjeszti a Car osztályt.
        Az osztály tartalmazzon egy cargoWeight egész attribútumot a rakomány súlyának tárolására!
        Definiálj egy konstruktort, amely megkapja a rakománysúlyt és az ős osztály két attribútumához szükséges értékeket is (összesen három egész érték)! Hívd a super-t az ős attribútumok inicializálására, és a konstruktor állítsa be az új attribútum értékét is!
        Definiáld felül a getGrossLoad() metódust! Hívd az ős azonos nevű metódusát, és add hozzá a rakomány súlyát! (Ez lesz a visszatérési érték.)
        Definiáld felül a toString() metódust a következő formára: Van{cargoWeight=1222, numberOfPassenger=4, vehicleWeight=1200}
        A komp (FerryBoat) képes bármilyen autót tárolni, aminek kisebb a súlya a megengedett összsúlynál. Viszont a komp is egy speciális jármű.
        Definiálj egy állandót MAX_CARRY_WEIGHT néven, amely tárolja a maximálisan szállítható autó súlyát!
        Ha szállít autót, akkor azt egy Car típusú car attribútumban tárold! (Ha nem szállít, akkor ez null.)
        Hozz létre egy konstruktort, amely megkap egy egész értéket, amivel meghívod a super-t!
        Definiáld felül a getGrossLoad() metódust! Hívd az ős azonos nevű metódusát és add hozzá a szállított autó súlyát! (Ez lesz a visszatérési érték.)
        Definiálj egy canCarry() metódust, ami igazat ad vissza, ha a paraméterben kapott autót szállíthatja, azaz a szállítandó autó súlya kisebb, mint a MAX_CARRY_WEIGHT (egyébként hamis). (Akár autó, akár kisbusz a referencia célja, mindig a megfelelő metódus hívódik meg.)
        Definiálj egy load() metódust, ami igazat ad vissza, ha a paraméterben kapott autót berakodta, azaz a súlya kisebb, mint a MAX_CARRY_WEIGHT (ekkor tárolja el az autót az attribútumban)!
        Definiáld felül a toString() metódust a következő formára: FerryBoat{car= + a tárolt autó toString() eredménye + }, tehát a következő kettő közül valamelyiket adja vissza:
        FerryBoat{car=Van{cargoWeight=200, numberOfPassenger=1, vehicleWeight=1200}}
        FerryBoat{car=Car{numberOfPassenger=1, vehicleWeight=1200}}
*/

package virtualmethod.vehicle;

public class Vehicle {

    private final int vehicleWeight;
    public static final int PERSON_AVERAGE_WEIGHT = 75;

    public Vehicle(int vehicleWeight) {
        this.vehicleWeight = vehicleWeight;
    }

    public int getVehicleWeight() {
        return vehicleWeight;
    }

    public int getGrossLoad() {
        return vehicleWeight + PERSON_AVERAGE_WEIGHT;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleWeight=" + vehicleWeight +
                '}';
    }
}
