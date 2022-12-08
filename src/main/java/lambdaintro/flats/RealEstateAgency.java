package lambdaintro.flats;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RealEstateAgency {

    private static final String NO_SUCH_FLAT = "No such flat.";
    private final List<Flat> flats;

    public RealEstateAgency(List<Flat> flats) {
        this.flats = new ArrayList<>(flats);
    }

    private Flat findFirst(Predicate<Flat> condition) {
        return flats.stream().filter(condition).findFirst().orElseThrow(() -> new IllegalArgumentException(NO_SUCH_FLAT));
    }

    public Flat findFirstCheaperFlat(int maxPrice) {
        return findFirst(flat -> flat.price() < maxPrice);
    }

    public Flat findFirstGreaterFlat(double minArea) {
        return findFirst(flat -> flat.area() > minArea);
    }

    public Flat findFirstFlatInSameTown(String town) {
        return findFirst(flat -> flat.address().startsWith(town));
    }
}
