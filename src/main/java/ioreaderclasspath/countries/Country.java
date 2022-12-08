/*
Országok
        A src/main/resources/country.txt állományban országnevek és a szomszédos országok száma található. Hozz létre egy az ország tárolására alkalmas osztályt Country néven!
*/

package ioreaderclasspath.countries;

public record Country(String name, int borderCountries) {
}
