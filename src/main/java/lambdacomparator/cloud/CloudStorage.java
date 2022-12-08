/*
Felhő tárhelyek
        Különböző felhő tárhely szolgáltatókat szeretnénk összehasonlítani, ezért a cloud.CloudStorage osztályban eltároljuk a különböző adataikat. Az osztály atribútumai: a szolgáltató neve, a tárhely mérete GB-ban, ár, és egy enum, amely a fizetési gyakoriságot reprezentálja. Az enumnak is van egy attribútuma, amelynek értéke a hossz hónapokban megadva (lifetime esetén 60 hónap). Az ingyenes csomagok esetén a fizetési gyakoriság nincs megadva. A CloudStorage implementálja a Comparable interfészt, a természetes rendezettségét az 1000 GB-ra eső éves díj nagysága adja.

        A Clouds osztály metódusai a paraméterként kapott listából bizonyos szempont szerint a legjobba(ka)t adják vissza. Amennyiben több ugyanolyan van, akkor közülük bármelyik visszaadható.
        alphabeticallyFirst(): a szolgáltató neve alapján betűrendben a legelső CloudStorage. Kis-nagybetű nem számít.
        bestPriceForShortestPeriod(): a legrövidebb időszakra vonatkozó legolcsóbb CloudStorage. Ha van ingyenes, akkor azok közül bármelyik megadható.
        List<CloudStorage> worstOffers(): a természetes rendezettség szerinti 3 legrosszabb ajánlat.
*/

package lambdacomparator.cloud;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CloudStorage implements Comparable<CloudStorage> {

    private final String provider;
    private final int space;
    private PayPeriod period;
    private double price;

    public CloudStorage(String provider, int space, PayPeriod payPeriod, double price) {
        this.provider = provider;
        this.space = space;
        this.period = payPeriod;
        this.price = price;
    }

    public CloudStorage(String provider, int space) {
        this.provider = provider;
        this.space = space;
    }

    private Double getAnnualPriceFor1000GB() {
        return period != null ? price * 12 / period.getLength() / space * 1000 : 0.0;
    }

    @Override
    public int compareTo(@NotNull CloudStorage other) {
        return getAnnualPriceFor1000GB().compareTo(other.getAnnualPriceFor1000GB());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CloudStorage that)) return false;
        return space == that.space && Double.compare(that.price, price) == 0 && Objects.equals(provider, that.provider) && period == that.period;
    }

    @Override
    public int hashCode() {
        return Objects.hash(provider, space, period, price);
    }

    public String getProvider() {
        return provider;
    }

    public int getSpace() {
        return space;
    }

    public double getPrice() {
        return price;
    }

    public PayPeriod getPeriod() {
        return period;
    }


}
