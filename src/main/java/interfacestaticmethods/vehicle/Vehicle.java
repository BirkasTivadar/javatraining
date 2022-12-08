/*
Kerekek
    Készíts egy vehicle.Vehicle nevű interfészt és két osztályt, amely ezt az interfészt implementálja: Bicycle és Car! A biciklinek csak egy attribútuma legyen: int numberOfWheels, és a konstruktora állítsa be ennek értékét! Az autónak két attribútuma legyen: String brand és int numberOfWheels, és legyen ezekhez getter és setter metódus! Legyen többféle paraméterezésű konstruktor is az osztályban!
        Ezután készíts az interfészbe egy static Vehicle of(int numberOfWheels) metódust, amelynek visszatérési értéke:
        egy újonnan példányosított Bicycle objektum, ha a paraméterként kapott szám 2,
        egy újonnan példányosított Car objektum, ha a paraméterként kapott szám 4,
        minden egyéb esetben pedig dobjon a metódus IllegalArgumentException kivételt a megfelelő üzenettel!
*/

package interfacestaticmethods.vehicle;

public interface Vehicle {

    static Vehicle of(int numberOfWheels) {
        if (numberOfWheels == 2) return new Bicycle(2);

        if (numberOfWheels == 4) return new Car(4);

        throw new IllegalArgumentException("This is neither a bicycle nor a car.");
    }
}
