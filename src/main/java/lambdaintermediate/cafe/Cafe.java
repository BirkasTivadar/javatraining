/*
Kávézó
    Készíts egy Coffee osztályt! Attribútumai: type - a kávé típusa, price - a kávé ára. A konstruktor is ebben a sorrendben kapja meg az adatokat!
        A kávé típusához készíts egy CoffeeType enum-ot. Lehetséges értékei: ESPRESSO, MACCHIATO, RISTRETTO, MOCHA, LATTE, CAPPUCCINO, AMERICANO.
        A CoffeeOrder osztály tárolja az egy vásárló által megrendelt és leszámlázott kávékat. Attibútumai: coffeeList - a megrendelt kávék listája, dateTime - a vásárlás időpontja.
        A Cafe osztály tartalmazza a kávézó összes rendelését egy listában. A listát a konstruktorban kapja meg, de legyen lehetőség új rendelést hozzáadni. Készítsd el benne az alábbi metódusokat streamek segítségével:
            Integer getTotalIncome(): az eddigi összes bevétel
            Integer getTotalIncome(LocalDate date): adott napi teljes bevétel
            long getNumberOfCoffee(CoffeeType type): az adott típusú kávéból eladott összmennyiség
            List<CoffeeOrder> getOrdersAfter(LocalDateTime from): a megadott időpont utáni rendelések listája
            List<CoffeeOrder> getFirstFiveOrder(LocalDate date): adott napon az első 5 vásárlásban lévő rendelések listája
*/

package lambdaintermediate.cafe;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {

    private final List<CoffeeOrder> coffeeOrders;

    public Cafe(List<CoffeeOrder> coffeeOrders) {
        this.coffeeOrders = new ArrayList<>(coffeeOrders);
    }

    public void addOrder(CoffeeOrder coffeeOrder) {
        coffeeOrders.add(coffeeOrder);
    }

    public int getTotalIncome() {
        return coffeeOrders.stream()
                .mapToInt(coffeeOrders ->
                        coffeeOrders.coffees().stream()
                                .mapToInt(Coffee::price)
                                .sum())
                .sum();
    }

    public int getTotalIncome(LocalDate date) {
        LocalDateTime start = LocalDateTime.of(date, LocalTime.MIN);
        LocalDateTime end = LocalDateTime.of(date, LocalTime.MAX);
        return coffeeOrders.stream()
                .filter(coffeeOrder -> coffeeOrder.dateTime().isAfter(start) && coffeeOrder.dateTime().isBefore(end))
                .mapToInt(coffeeOrders ->
                        coffeeOrders.coffees().stream()
                                .mapToInt(Coffee::price)
                                .sum())
                .sum();
    }

    public long getNumberOfCoffee(CoffeeType type) {
        return coffeeOrders.stream()
                .mapToLong(coffeeOrders ->
                        coffeeOrders.coffees().stream()
                                .filter(c -> c.coffeeType() == type)
                                .count())
                .sum();
    }

    public List<CoffeeOrder> getOrdersAfter(LocalDateTime from) {
        return coffeeOrders.stream()
                .filter(coffeeOrder -> coffeeOrder.dateTime().isAfter(from))
                .toList();
    }

    public List<CoffeeOrder> getFirstFiveOrder(LocalDate date) {
        LocalDateTime start = LocalDateTime.of(date, LocalTime.MIN);
        LocalDateTime end = LocalDateTime.of(date, LocalTime.MAX);

        return coffeeOrders.stream()
                .filter(coffeeOrder -> coffeeOrder.dateTime().isAfter(start) && coffeeOrder.dateTime().isBefore(end))
                .sorted(Comparator.comparing(CoffeeOrder::dateTime))
                .limit(5)
                .toList();
    }
}
