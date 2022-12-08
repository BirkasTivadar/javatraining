/*
Készíts egy Fleet osztályt, melynek van egy List<Ship> attribútuma, mely a hajókat tartalmazza! A loadShip(int passengers, int cargoWeight) metódusa végigmegy a listán, és sorban feltölti a hajókat a személyekkel és a terhekkel. A maradék személyeket és terheket (melyek nem fértek el) a waitingPersons és waitingCargo attribútumokban tárolja el. Ez utóbbiakhoz generálj getter metódusokat is!
*/

package isahasa.fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet {

    private final List<Ship> ships = new ArrayList<>();

    private int waitingPeople;

    private int waitingCargo;

    public void loadShip(int passengers, int cargoWeight) {
        for (Ship ship : ships) {
            if (ship instanceof CanCarryPassengers canCarryPassengers) {
                passengers = canCarryPassengers.loadPassenger(passengers);
            }
            if (ship instanceof CanCarryGoods canCarryGoods) {
                cargoWeight = canCarryGoods.loadCargo(cargoWeight);
            }
            waitingPeople = passengers;
            waitingCargo = cargoWeight;
        }
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public int getWaitingPeople() {
        return waitingPeople;
    }

    public int getWaitingCargo() {
        return waitingCargo;
    }
}
