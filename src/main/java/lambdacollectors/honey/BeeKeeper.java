/*
Termelői méz
        Egy méhész csak meghatározott fajtájú mézeket termel, és azokat csak meghatározott méretű üvegekben adja el. A mézek fajtáit a HoneyType enum reprezentálja: MULTIFLORAL(1200), ACACIA(1800), LINDEN(1500). A különböző fajták után zárójelben álló szám minden fajtának a kilogrammonkénti ára (ez az osztály attribútuma). Az üvegek típusait a GlassSize enum tárolja: BIG(1.0), SMALL(0.5), TASTER_SIZE(0.05). Az egyes típusok után zárójelben álló szám az üveg méretét adja meg oly módon, hogy hány kilogramm mézet lehet az adott fajta üvegbe tenni. Legyen egy Honey osztály, és annak legyen mindkét enum típusú attribútuma! Végül legyen egy BeeKeeper osztály, amely egy listában tárolja az összes megtermelt mézet. Ebben az osztályban Collectorok segítségével valósítsd meg az alábbi metódusokat:
        int getTotalValueOfGivenGlasses(GlassSize size): visszaadja a paraméterül kapott méretű üvegben lévő mézek összértékét (fajtától függetlenül).
        Map<GlassSize, Long> getAmountsOfGivenType(HoneyType type): visszaad egy Map-et, melyben csak a paraméterül kapot fajta mézet tartalmazó üvegek vannak. A Map kulcsai az egyes üvegméretek, értékei pedig az, hogy egyféle méretű üvegnyi mézből hány darab van.
        Map<Boolean, List<Honey>> getGroupsByGivenTypeAndSize(HoneyType type, GlassSize size): visszaad egy Map-et, melyben a mézek két csoportra vannak osztva: az egyik csoportban true kulccsal szerepelnek azok, amelyek a paraméterül kapott típusúak és a paraméterül kapott méretű üvegben vannak, a másik csoportban false kulccsal szerepel az összes többi méz.
*/

package lambdacollectors.honey;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BeeKeeper {
    private final List<Honey> honeyList;

    public BeeKeeper(List<Honey> honeyList) {
        this.honeyList = new ArrayList<>(honeyList);
    }

    public List<Honey> getHoneyList() {
        return new ArrayList<>(honeyList);
    }

    public void addHoney(Honey honey) {
        honeyList.add(honey);
    }

    public double getTotalValueOfGivenGlasses(GlassSize size) {
        return honeyList.stream()
                .filter(h -> h.glassSize() == size)
                .mapToDouble(Honey::price)
                .sum();
    }

    public Map<GlassSize, Long> getAmountsOfGivenType(HoneyType type) {
        return honeyList.stream()
                .filter(h -> h.type() == type)
                .collect(Collectors.groupingBy(Honey::glassSize, Collectors.counting()));
    }

    public Map<Boolean, List<Honey>> getGroupsByGivenTypeAndSize(HoneyType type, GlassSize size) {
        return honeyList.stream()
                .collect(Collectors.partitioningBy(h -> h.type() == type && h.glassSize() == size));
    }
}
