/*
Hozz létre egy Car osztályt, amely az általánosabb jármű (Vehicle) osztályból származik a következők alapján:
        Az osztály tartalmazzon egy numberOfPassenger attribútumot: egész szám, amely az utasok számát jelenti (sofőr nélkül)!
        Legyen konstruktora, amely megkap két értéket az attribútumok számára, és beállítja azokat (az ős attribútumát a super hívással)!
        A getGrossLoad() metódus visszaadja a mozgó gépkocsi súlyát. Hívd az ős azonos nevű metódusát, és add hozzá az utasok súlyát! (Ez lesz a visszatérési érték.)
        Definiáld felül a toString() metódust a következő formára: Car{numberOfPassenger=4, vehicleWeight=1700}
*/

package virtualmethod.vehicle;

public class Car extends Vehicle {

    protected int numberOfPassenger;

    public Car(int vehicleWeight, int numberOfPassenger) {
        super(vehicleWeight);
        this.numberOfPassenger = numberOfPassenger;
    }


    @Override
    public int getGrossLoad() {
        return super.getGrossLoad() + (numberOfPassenger * PERSON_AVERAGE_WEIGHT);
    }

    @Override
    public String toString() {
        return String.format("Car{numberOfPassenger=%d, vehicleWeight=%d}", numberOfPassenger, getVehicleWeight());
    }
}
