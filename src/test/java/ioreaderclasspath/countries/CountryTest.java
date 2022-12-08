package ioreaderclasspath.countries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountryTest {

    private final Country country = new Country("Hungary", 7);

    @Test
    void createCountryTest() {
        assertEquals("Hungary", country.name());
        assertEquals(7, country.borderCountries());
    }
}
