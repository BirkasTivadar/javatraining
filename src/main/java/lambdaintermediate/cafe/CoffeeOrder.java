/*
A CoffeeOrder osztály tárolja az egy vásárló által megrendelt és leszámlázott kávékat. Attibútumai: coffeeList - a megrendelt kávék listája, dateTime - a vásárlás időpontja.
*/

package lambdaintermediate.cafe;

import java.time.LocalDateTime;
import java.util.List;

public record CoffeeOrder(List<Coffee> coffees, LocalDateTime dateTime) {
}
