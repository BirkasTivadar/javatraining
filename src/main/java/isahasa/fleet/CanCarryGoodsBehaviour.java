/*
A CanCarryGoodsBehaviour implementálja a CanCarryGoods interfészt! Ennek az osztálynak két attribútuma van: int cargoWeight és int maxCargoWeight. Implementáld a loadCargo(int cargoWeight) metódust, melynek paramétere a betöltendő rakomány súlya, és a cargoWeight attribútumban eltárolja azt a rakományt, amit el bír vinni a hajó. Visszatér annak a rakománynak a súlyával, amelyet már nem sikerült a hajóra feltenni.
*/

package isahasa.fleet;

public class CanCarryGoodsBehaviour implements CanCarryGoods {

    private int cargoWeight;
    private final int maxCargoWeight;

    public CanCarryGoodsBehaviour(int maxCargoWeight) {
        this.maxCargoWeight = maxCargoWeight;
    }

    @Override
    public int getCargoWeight() {
        return cargoWeight;
    }

    @Override
    public int loadCargo(int cargoWeight) {
        int possibleCargoWeight = maxCargoWeight - getCargoWeight();
        if (possibleCargoWeight > cargoWeight) {
            this.cargoWeight += cargoWeight;
            return 0;
        } else {
            this.cargoWeight += possibleCargoWeight;
            return cargoWeight - possibleCargoWeight;
        }
    }
}
