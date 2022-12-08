/*
Sportbolt
        Hozz létre egy Product osztályt, amely a sportszer nevét, árát, darabszámát tárolja! A konstruktora is ezeket kapja meg, ugyanebben a sorrendben! A SportGadgetStore osztály tárolja a termékek listáját, és különböző statisztikákat készít belőle. Az osztály kapja meg a listát kívülről!
        Készítsd el a következő metódusokat streamek segítségével (minden metódusban alakítsd primitívek streamjévé a lista objektumait):
        int getNumberOfProducts(): összesen hány termék van a boltban.
        double getAveragePrice(): átlagosan mennyibe kerül egy termék. Ha nincs termék, 0-t adjon vissza.
        String getExpensiveProductStatistics(double minPrice): adott árnál drágább termékek darabszámáról szolgáltat statisztikát. Az összesítést szövegként adja vissza az alábbi formában:
        Összesen 3 féle termék, amelyekből minimum 1 db, maximum 52 db, összesen 74 db van.
        Ha nincs ilyen, akkor a visszaadott szöveg a Nincs ilyen termék. legyen!
*/

package lambdaprimitives.sportsstore;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;

public record SportGadgetStore(List<Product> products) {

    public int getNumberOfProducts() {
        return products.stream()
                .mapToInt(Product::pieces)
                .sum();
    }

    public double getAveragePrice() {
        OptionalDouble result = products.stream()
                .mapToDouble(Product::price)
                .average();
        return result.orElse(0);
    }

    public String getExpensiveProductStatistics(double minPrice) {
        IntSummaryStatistics stats = products.stream()
                .filter(p -> p.price() > minPrice)
                .mapToInt(Product::pieces)
                .summaryStatistics();
        if (stats.getCount() == 0) return "Nincs ilyen termék.";
        return String.format("Összesen %d féle termék, amelyekből minimum %d db, maximum %d db, összesen %d db van.", stats.getCount(), stats.getMin(), stats.getMax(), stats.getSum());

    }
}
