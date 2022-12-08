/*
Hozz létre egy Van osztályt, amely egy kisteherautót modellez! Ez az osztály az általános autóból származik, kiterjeszti a Car osztályt.
        Az osztály tartalmazzon egy cargoWeight egész attribútumot a rakomány súlyának tárolására!
        Definiálj egy konstruktort, amely megkapja a rakománysúlyt és az ős osztály két attribútumához szükséges értékeket is (összesen három egész érték)! Hívd a super-t az ős attribútumok inicializálására, és a konstruktor állítsa be az új attribútum értékét is!
        Definiáld felül a getGrossLoad() metódust! Hívd az ős azonos nevű metódusát, és add hozzá a rakomány súlyát! (Ez lesz a visszatérési érték.)
        Definiáld felül a toString() metódust a következő formára: Van{cargoWeight=1222, numberOfPassenger=4, vehicleWeight=1200}
*/

package virtualmethod.vehicle;

public class Van extends Car {

    private final int cargoWeight;

    public Van(int vehicleWeight, int numberOfPassenger, int cargoWeight) {
        super(vehicleWeight, numberOfPassenger);
        this.cargoWeight = cargoWeight;
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad() + cargoWeight;
    }

    @Override
    public String toString() {
        return String.format("Van{cargoWeight=%d, numberOfPassenger=%d, vehicleWeight=%d}", cargoWeight, numberOfPassenger, getVehicleWeight());
    }
}
