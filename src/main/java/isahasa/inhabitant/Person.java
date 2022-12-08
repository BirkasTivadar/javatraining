/*
A lakók parkolóhelyei
        Az inhabitant csomagban hozz létre három osztályt, amelyekre legyenek igazak a következő állítások:
        Az egyik osztály neve Person, akinek van neve.
        Inhabitant is-a Person.
        Inhabitant has-a ParkingPlace.
        A parkolóhelyeket szám alapján különböztetik meg egymástól.
        A hiányzó információkat olvasd ki a tesztesetekből! A lakóknak legyen lehetőségük arra, hogy el tudják cserélni a parkolóhelyüket egy másikra, ha az valamiért nem megfelelő nekik: a changeParkingPlace(int newNumber) metódus példányosítson egy új parkolóhelyet a kapott számmal és állítsa be azt az adott lakóhoz!
*/

package isahasa.inhabitant;

public class Person {

    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
