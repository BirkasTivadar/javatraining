/*
A PineTreeType legyen egy enum, NORDMANN, SILVER, SPRUCE felsorolókkal, és legyen az enumnak egy int pricePerMeter attribútuma, amelynek értéke a különböző fenyőfajtáktól függően legyen rendre 10000 Ft, 8000 Ft és 4000 Ft!
*/

package lambdacollectors.christmastree;

public enum PineTreeType {
    NORDMANN(10000),
    SILVER(8000),
    SPRUCE(4000);

    private final int pricePerMeter;

    PineTreeType(int pricePerMeter) {
        this.pricePerMeter = pricePerMeter;
    }

    public int getPricePerMeter() {
        return pricePerMeter;
    }
}
