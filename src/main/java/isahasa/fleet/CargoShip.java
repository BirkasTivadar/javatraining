/*
A CargoShip osztály implementálja a Ship és a CanCarryGoods interfészeket, és legyen egy CanCarryGoods típusú attribútuma!
*/

package isahasa.fleet;

public class CargoShip implements Ship, CanCarryGoods {

    private final CanCarryGoods canCarryGoods;

    public CargoShip(int maxCargoWeight) {
        canCarryGoods = new CanCarryGoodsBehaviour(maxCargoWeight);
    }

    @Override
    public int loadCargo(int cargoWeight) {
        return canCarryGoods.loadCargo(cargoWeight);
    }

    @Override
    public int getCargoWeight() {
        return canCarryGoods.getCargoWeight();
    }
}
