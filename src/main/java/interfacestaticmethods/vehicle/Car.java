/*
Készíts egy vehicle.Vehicle nevű interfészt és két osztályt, amely ezt az interfészt implementálja: Bicycle és Car! A biciklinek csak egy attribútuma legyen: int numberOfWheels, és a konstruktora állítsa be ennek értékét! Az autónak két attribútuma legyen: String brand és int numberOfWheels, és legyen ezekhez getter és setter metódus! Legyen többféle paraméterezésű konstruktor is az osztályban!
*/

package interfacestaticmethods.vehicle;

public class Car implements Vehicle {

    private String brand;

    private int numberOfWheels;

    public Car(String brand) {
        this.brand = brand;
    }

    public Car(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public Car(String brand, int numberOfWheels) {
        this.brand = brand;
        this.numberOfWheels = numberOfWheels;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }
}
