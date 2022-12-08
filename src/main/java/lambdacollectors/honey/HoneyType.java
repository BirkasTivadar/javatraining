/*
A mézek fajtáit a HoneyType enum reprezentálja: MULTIFLORAL(1200), ACACIA(1800), LINDEN(1500). A különböző fajták után zárójelben álló szám minden fajtának a kilogrammonkénti ára (ez az osztály attribútuma).
*/

package lambdacollectors.honey;

public enum HoneyType {
    MULTIFLORAL(1200), ACACIA(1800), LINDEN(1500);

    private final int pricePerKilo;

    HoneyType(int pricePerKilo) {
        this.pricePerKilo = pricePerKilo;
    }

    public int getPricePerKilo() {
        return pricePerKilo;
    }
}

