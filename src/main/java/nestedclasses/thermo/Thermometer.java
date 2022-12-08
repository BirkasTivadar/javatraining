/*
A Thermometer osztály egy hőmérő.
    Rendelkezik a szoba neve és hőmérséklete adatokkal, valamint egy ThermometerObserver referenciával, akit értesíteni kell! Általában tetszőleges számú figyelő lehet, de most legyen csak egyetlen figyelő!)
        Létrehozáskor a szoba nevét és a hőmérsékletét lehet megadni, figyelő nincsen (értéke null)!
        Legyenek getterei a tagokhoz!
        Legyen egy metódusa (onTemperatureChanged()), amely ha van bejegyzett figyelő meghívja a figyelő handleTemperatureChange metódusát!
        Legyen setter metódus a hőmérséklet adatra (setTemperature), amelyik az adatbeállításon kívül még meghívja az onTemperatureChanged metódust!
        Legyen metódusa, amely meghívásával a figyelő bejegyezheti magát mint figyelő (setThermometerObserver(ThermometerObserver observer))! (Figyeljünk rá, hogy a figyelő bejegyzése hőmérséklet változásnak számít.)
*/

package nestedclasses.thermo;

public class Thermometer {

    private final String roomName;

    private int temperature;

    private ThermometerObserver thermometerObserver;

    public Thermometer(String roomName, int temperature) {
        this.roomName = roomName;
        this.temperature = temperature;
    }

    public void onTemperatureChanged() {
        if (thermometerObserver != null) thermometerObserver.handleTemperatureChange(temperature, roomName);
    }

    public String getRoomName() {
        return roomName;
    }

    public int getTemperature() {
        return temperature;
    }

    public ThermometerObserver getThermometerObserver() {
        return thermometerObserver;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        onTemperatureChanged();
    }

    public void setThermometerObserver(ThermometerObserver thermometerObserver) {
        this.thermometerObserver = thermometerObserver;
        setTemperature(temperature);
    }
}
