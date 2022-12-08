package ioreaderclasspath.countries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountryStatisticsTest {

    private final CountryStatistics countryStatistics = new CountryStatistics();

    @Test
    void createListTest() {
        assertEquals(0, countryStatistics.getCountryList().size());

        countryStatistics.getCountryList().add(new Country("Test", 3));

        assertEquals(0, countryStatistics.getCountryList().size());
    }

    @Test
    void readFromFileTest() {
        assertEquals(0, countryStatistics.getCountryList().size());
        countryStatistics.readFromFile("country.txt");

        assertEquals(8, countryStatistics.getCountryList().size());

        assertEquals("Austria", countryStatistics.getCountryList().get(1).name());
        assertEquals(1, countryStatistics.getCountryList().get(5).borderCountries());
    }

    @Test
     void numberOfCountriesTest() {
        assertEquals(0, countryStatistics.numberOFCountries());
        countryStatistics.readFromFile("country.txt");

        assertEquals(8, countryStatistics.numberOFCountries());
    }


    @Test
     void mostBorderCountriesTest() {
        countryStatistics.readFromFile("country.txt");

        assertEquals("Germany", countryStatistics.mostBorderCountries().name());
        assertEquals(8, countryStatistics.mostBorderCountries().borderCountries());
    }
}
