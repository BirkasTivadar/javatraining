/*
A CanCarryGoods interfészben hozz létre egy int loadCargo(int cargoWeight) és int getCargoWeight() metódust,
*/

package isahasa.fleet;

public interface CanCarryGoods {

    int loadCargo(int cargoWeight);

    int getCargoWeight();
}
