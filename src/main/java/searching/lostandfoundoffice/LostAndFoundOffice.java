/*
Talált tárgyak osztálya
        Készíts egy LostProperty osztályt, amelynek három attribútuma egy regisztrációs szám, egy rövid leírás az elveszett tárgyról és a talált tárgyak osztályára való bekerülésének dátuma! Az osztály implementálja a Comparable interfészt és valósítsa meg annak metódusát! Alapvetően a tárgyak leírása alapján hasonlítsa össze őket, ám ha az esetleg megegyezik, akkor a bekerülés dátuma alapján! Majd ezután legyen egy LostAndFoundOffice, amely egy listában tárolja az elhagyott tárgyakat! Az osztályban készíts egy LostProperty findLostProperty(LostProperty searched) metódust, amely bináris kereséssel megkeresi a listában a leírás alapján az elhagyott tárgyat! Ha nincs találat, dobjon a metódus IllegalArgumentException-t!
*/

package searching.lostandfoundoffice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LostAndFoundOffice {

    private final List<LostProperty> properties = new ArrayList<>();

    public void addProperty(LostProperty property) {
        properties.add(property);
    }

    public LostProperty findLostProperty(LostProperty property) {
        int index = Collections.binarySearch(properties, property);
        if (index < 0) throw new IllegalArgumentException("Property not found.");
        return properties.get(index);
    }
}
