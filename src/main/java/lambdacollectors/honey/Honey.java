/*
Egy méhész csak meghatározott fajtájú mézeket termel, és azokat csak meghatározott méretű üvegekben adja el. A mézek fajtáit a HoneyType enum reprezentálja: MULTIFLORAL(1200), ACACIA(1800), LINDEN(1500). A különböző fajták után zárójelben álló szám minden fajtának a kilogrammonkénti ára (ez az osztály attribútuma). Az üvegek típusait a GlassSize enum tárolja: BIG(1.0), SMALL(0.5), TASTER_SIZE(0.05). Az egyes típusok után zárójelben álló szám az üveg méretét adja meg oly módon, hogy hány kilogramm mézet lehet az adott fajta üvegbe tenni. Legyen egy Honey osztály, és annak legyen mindkét enum típusú attribútuma!
*/

package lambdacollectors.honey;

public record Honey(HoneyType type, GlassSize glassSize) {
    public double price() {
        return type.getPricePerKilo() * glassSize.getSize();
    }
}
