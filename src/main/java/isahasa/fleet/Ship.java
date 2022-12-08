/*
Flotta
    A flottában vegyesen vannak teherszállító hajók (cargo ship), személyszállító hajók (liner) és kompok (ferry boat). A kompok személyeket és terhet is szállíthatnak. Ha a flotta behajóz, akkor folyamatosan töltik fel a hajókat, mindaddig, amíg meg nem telnek, el nem fogy az utas vagy a teher.
        Hozz létre egy Ship interfészt, mely a hajót jelöli (marker interfész, metódus nélkül), egy CanCarryGoods és egy CanCarryPassengers interfészt, mely azt jelöli, hogy egy hajó tud-e személyeket vagy terhet szállítani! A CanCarryGoods interfészben hozz létre egy int loadCargo(int cargoWeight) és int getCargoWeight() metódust, a CanCarryPassengers interfészben pedig egy int loadPassenger(int passengers) és egy int getPassengers() metódust!
        A CanCarryGoodsBehaviour implementálja a CanCarryGoods interfészt! Ennek az osztálynak két attribútuma van: int cargoWeight és int maxCargoWeight. Implementáld a loadCargo(int cargoWeight) metódust, melynek paramétere a betöltendő rakomány súlya, és a cargoWeight attribútumban eltárolja azt a rakományt, amit el bír vinni a hajó. Visszatér annak a rakománynak a súlyával, amelyet már nem sikerült a hajóra feltenni.
        Vezessünk be egy CanCarryPassengersBehaviour osztályt, ami implementálja a CanCarryPassengers interfészt! Ennek az osztálynak két attribútuma van: int passengers és int maxPassengers. Implementáld a loadPassenger(int passengers) metódust, melynek paramétere a beszálló utasok száma, és a passengers attribútumban eltárolja a beszállt utasok számát. Visszatér a kint maradó utasok számával.
        A Liner osztály implementálja a Ship és a CanCarryPassengers interfészeket, és legyen egy CanCarryPassengers típusú attribútuma!
        A CargoShip osztály implementálja a Ship és a CanCarryGoods interfészeket, és legyen egy CanCarryGoods típusú attribútuma!
        A FerryBoat osztály implementálja a Ship, CanCarryGoods, CanCarryPassengers interfészeket, és legyen mindkét típusú attribútuma!
        Mindhárom osztálynak legyen olyan konstruktora, mely elvárja a CanXxxBehaviour osztályok konstruktoraiban elvárt adatokat, és az attribútumoknak a nekik megfelelő nevű osztály egy-egy új példányát adják értékül!
        Minden szükséges (interfész által kikényszerített) metódust úgy implementálj, hogy delegáld a kérést a megfelelő attribútum megfelelő metódusának!
        Azaz pl. a FerryBoat osztály loadCargo() metódusa hívja a CanCarryGoods loadCargo() metódusát!
        Készíts egy Fleet osztályt, melynek van egy List<Ship> attribútuma, mely a hajókat tartalmazza! A loadShip(int passengers, int cargoWeight) metódusa végigmegy a listán, és sorban feltölti a hajókat a személyekkel és a terhekkel. A maradék személyeket és terheket (melyek nem fértek el) a waitingPersons és waitingCargo attribútumokban tárolja el. Ez utóbbiakhoz generálj getter metódusokat is!
*/

package isahasa.fleet;

public interface Ship {
}
