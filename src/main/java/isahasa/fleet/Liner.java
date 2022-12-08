/*
A Liner osztály implementálja a Ship és a CanCarryPassengers interfészeket, és legyen egy CanCarryPassengers típusú attribútuma!
*/

package isahasa.fleet;

public class Liner implements Ship, CanCarryPassengers {

    private final CanCarryPassengers canCarryPassengers;

    public Liner(int maxPassengers) {
        canCarryPassengers = new CanCarryPassengersBehaviour(maxPassengers);
    }

    @Override
    public int loadPassenger(int passengers) {
        return canCarryPassengers.loadPassenger(passengers);
    }

    @Override
    public int getPassengers() {
        return canCarryPassengers.getPassengers();
    }
}
