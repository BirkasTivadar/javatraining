/*
Vezessünk be egy CanCarryPassengersBehaviour osztályt, ami implementálja a CanCarryPassengers interfészt! Ennek az osztálynak két attribútuma van: int passengers és int maxPassengers. Implementáld a loadPassenger(int passengers) metódust, melynek paramétere a beszálló utasok száma, és a passengers attribútumban eltárolja a beszállt utasok számát. Visszatér a kint maradó utas
*/

package isahasa.fleet;

public class CanCarryPassengersBehaviour implements CanCarryPassengers {
    private int passengers;

    private final int maxPassengers;

    public CanCarryPassengersBehaviour(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public int getPassengers() {
        return passengers;
    }

    @Override
    public int loadPassenger(int passengers) {
        int possiblePassengers = maxPassengers - getPassengers();
        if (possiblePassengers > passengers) {
            this.passengers += passengers;
            return 0;
        } else {
            this.passengers += possiblePassengers;
            return passengers - possiblePassengers;
        }
    }
}
