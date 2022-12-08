/*
Rakomány
        Hozz létre egy Cargo osztályt, amelynek attribútumai: String description, int weight és double length! Majd hozz létre egy Truck osztályt, amely tárol egy listát a rakományról: List<Cargo> thingsToLoad!
        Készítsd el a következő metódusokat streamek segítségével (minden metódusban alakítsd primitívek streamjévé a lista objektumait):
        double getShortestLength(): visszaadja a legrövidebb rakomány hosszát (ha üres a lista, adjon vissza 0.0-t).
        int getTotalWeight(): visszaadja az rakomány összsúlyát.
        double getAverageWeight(): visszaadja az átlagos súlyt, illetve ha nincs rakomány, amiből számoljon (üres a lista), akkor dobjon IllegalArgumentException-t "No cargo." szöveggel!
        int getMaxWeight(): visszaadja a legnehezebb rakomány súlyát (ha üres a lista, adjon vissza 0-t).
        String getWeightStatistics(): visszaad egy statisztikát a rakomány súlyát érintően a következőhöz hasonló formában:
        A rakományban található 5 tétel, melyeknek összsúlya 495 kg, közülük a legnehezebb 300 kg, a legkönnyebb 15 kg. A súlyuk átlagosan 99.0 kg.
        Ha nincs rakomány (üres a lista), akkor adja vissza a "No cargo." szöveget!
*/

package lambdaprimitives.cargo;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public record Truck(List<Cargo> thingsToLoad) {

    public double getShortestLength() {
        OptionalDouble result = thingsToLoad.stream()
                .mapToDouble(Cargo::length)
                .min();
        return result.orElse(0);
    }

    public int getTotalWeight() {
        return thingsToLoad.stream()
                .mapToInt(Cargo::weight)
                .sum();
    }

    public double getAverageWeight() {
        OptionalDouble result = thingsToLoad.stream()
                .mapToInt(Cargo::weight)
                .average();
        return result.orElseThrow(()-> new IllegalArgumentException("No cargo."));
    }

    public int getMaxWeight() {
        OptionalInt result = thingsToLoad.stream()
                .mapToInt(Cargo::weight)
                .max();
        return result.orElse(0);
    }

    public String getWeightStatistics() {
        DoubleSummaryStatistics stats = thingsToLoad.stream()
                .mapToDouble(Cargo::weight)
                .summaryStatistics();
        if (thingsToLoad.isEmpty()) return "No cargo.";
        return String.format("A rakományban található %d tétel, melyeknek összsúlya %,.0f kg, közülük a legnehezebb %,.0f kg, a legkönnyebb %,.0f kg. A súlyuk átlagosan %,.1f kg.", stats.getCount(), stats.getSum(), stats.getMax(), stats.getMin(), stats.getAverage());
    }
}
