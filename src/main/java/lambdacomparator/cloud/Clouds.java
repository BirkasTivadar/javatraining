package lambdacomparator.cloud;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Clouds {
    public CloudStorage alphabeticallyFirst(List<CloudStorage> storages) {
        return storages.stream()
//               .sorted(Comparator.comparing(CloudStorage::getProvider, (p1,p2)->p1.toLowerCase().compareTo(p2.toLowerCase())))
                .sorted(Comparator.comparing(CloudStorage::getProvider, Comparator.comparing(String::toLowerCase)))
                .toList()
                .get(0);
    }

    public CloudStorage bestPriceForShortestPeriod(List<CloudStorage> storages) {
        Optional<CloudStorage> result = storages.stream()
                .sorted(Comparator.comparing(CloudStorage::getPeriod, Comparator.nullsFirst(Comparator.naturalOrder())))
                .min(Comparator.comparing(CloudStorage::getPrice));
        return result.orElseThrow(() -> new IllegalArgumentException("Wrong data"));
    }

    public List<CloudStorage> worstOffers(List<CloudStorage> storages) {
        return storages.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();
    }
}
