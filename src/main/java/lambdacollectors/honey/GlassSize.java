/*
Az üvegek típusait a GlassSize enum tárolja: BIG(1.0), SMALL(0.5), TASTER_SIZE(0.05).
*/

package lambdacollectors.honey;

public enum GlassSize {

    BIG(1.0), SMALL(0.5), TASTER_SIZE(0.05);

    private final double size;

    GlassSize(double size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }
}
