/*
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

public class FerryBoat extends Vehicle {

    public static final int MAX_CARRY_WEIGHT = 2000;

    private Car car;

    public FerryBoat(int vehicleWeight) {
        super(vehicleWeight);
    }

    @Override
    public int getGrossLoad() {
        return car != null ? super.getGrossLoad() + car.getGrossLoad() : super.getGrossLoad();
    }

    public boolean canCarry(Car car) {
        return car.getGrossLoad() < MAX_CARRY_WEIGHT;
    }

    public boolean load(Car car) {
        if (canCarry(car)) {
            this.car = car;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "FerryBoat{car=" + car.toString() + "}";
    }
}
