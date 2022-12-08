/*
Országok
        A src/main/resources/country.txt állományban országnevek és a szomszédos országok száma található. Hozz létre egy az ország tárolására alkalmas osztályt Country néven!
        Hozz létre egy CountryStatistics osztályt, ahol beolvasod file tartalmát egy listába, amjd írj metódusokat amelyek visszatérési értéke választ ad a következő kérdésekre: * Hány országot olvastál be? * Melyik országnak van a legtöbb szomszédja?
*/

package ioreaderclasspath.countries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class CountryStatistics {

    private final List<Country> countryList = new ArrayList<>();

    public List<Country> getCountryList() {
        return new ArrayList<>(countryList);
    }

    public void readFromFile(String file) {
        try (BufferedReader reader = new BufferedReader((new InputStreamReader(Objects.requireNonNull(CountryStatistics.class.getResourceAsStream("/" + file)))))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] strArr = line.split(" ");
                countryList.add(new Country(strArr[0], Integer.parseInt(strArr[1])));
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read file", ioException);
        }
    }

    public int numberOFCountries() {
        return countryList.size();
    }

    public Country mostBorderCountries() {
        return countryList.stream()
                .max(Comparator.comparingInt(Country::borderCountries))
                .orElseThrow(() -> new IllegalArgumentException("Empty list"));
    }
}
