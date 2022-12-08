/*
Készíts egy Coffee osztályt! Attribútumai: type - a kávé típusa, price - a kávé ára. A konstruktor is ebben a sorrendben kapja meg az adatokat!
*/

package lambdaintermediate.cafe;

public record Coffee(CoffeeType coffeeType, int price) {
}
