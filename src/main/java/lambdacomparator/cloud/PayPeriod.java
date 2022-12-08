/*
Az enumnak is van egy attribútuma, amelynek értéke a hossz hónapokban megadva (lifetime esetén 60 hónap).
*/

package lambdacomparator.cloud;

public enum PayPeriod {
    MONTHLY (1),
    ANNUAL (12),
    LIFETIME(60);

    private final int length;

    PayPeriod(int length) {
        this.length = length;
    }

    public Integer getLength() {
        return length;
    }
}
