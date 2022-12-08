/*
Úticélok
        Hozd létre a Destination osztályt, amelynek attribútumai legyenek: String name, String description, int kmFromHome! Majd hozd létre a BucketList osztályt, melynek legyen egy listája az úticélokkal! Az osztály Optional<Destination> getDestinationWithKeyword(String keyword) metódusa adja vissza az első úticélt a listából, amelynek leírásában szerepel a paraméterként megadott kulcsszó! A Optional<Destination> getDestinationNearerThanGiven(int maxKm) metódus pedig adja vissza az első olyan úticélt a listából, amely a paraméterként megadott kilométernél közelebb van!
*/

package optional.destinations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BucketList {

    private final List<Destination> destinations = new ArrayList<>();

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public Optional<Destination> getDestinationWithKeyword(String keyword) {
        return destinations.stream()
                .filter(d -> d.description().contains(keyword))
                .findFirst();
    }

    public Optional<Destination> getDestinationNearerThanGiven(int maxKm) {
        return destinations.stream()
                .filter(d -> d.kmFromHome() < maxKm)
                .findFirst();
    }
}
