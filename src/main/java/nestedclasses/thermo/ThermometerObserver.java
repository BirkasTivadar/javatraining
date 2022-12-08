/*
A ThermometerObserver interfész tartalmazza azon metódus deklarációját, amellyel a hőmérő értesíti a figyelőket: void handleTemperatureChange(int temp, String room)
*/

package nestedclasses.thermo;

public interface ThermometerObserver {

    void handleTemperatureChange(int temp, String room);
}
