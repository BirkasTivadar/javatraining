/*
Karácsonyfa vásár
    Hozz létre egy christmastree.ChristmasTree osztályt, melynek attribútumai legyenek a következők: PineTreeType type, double height! A PineTreeType legyen egy enum, NORDMANN, SILVER, SPRUCE felsorolókkal, és legyen az enumnak egy int pricePerMeter attribútuma, amelynek értéke a különböző fenyőfajtáktól függően legyen rendre 10000 Ft, 8000 Ft és 4000 Ft! Ezután hozz létre egy ChristmasTreeFair osztályt, amely listában tárolja az eladó fenyőfákat! Collectorok segítségével valósítsd meg benne a következő metódusokat:
        Map<PineTreeType, Long> getCountByType(): egy Map-ben visszaadja, hogy fajtánként hány darab fa kapható.
        double getMaxHeightByType(PineTreeType type): visszaadja a paraméterül kapott típusból a legmagasabb fa méretét. Ha nem talál megfelelő fát vagy a lista üres, adjon vissza 0.0-t!
        double getAveragePrice(): visszaadja az összes kapható fa árából számolt átlagos árat. Ha üres a lista, 0.0-t adjon vissza!
*/

package lambdacollectors.christmastree;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public record ChristmasTreeFair(List<ChristmasTree> christmasTrees) {

    public Map<PineTreeType, Long> getCountByType() {
        return christmasTrees.stream()
                .collect(Collectors.groupingBy(ChristmasTree::type, Collectors.counting()));
    }

    public double getMaxHeightByType(PineTreeType type) {
        OptionalDouble result = christmasTrees.stream()
                .filter(ch -> ch.type() == type)
                .mapToDouble(ChristmasTree::height)
                .max();
        return result.orElse(0);
    }

    public double getAveragePrice() {
        return christmasTrees.stream()
                .collect(Collectors.averagingDouble(ChristmasTree::price));
    }
}
