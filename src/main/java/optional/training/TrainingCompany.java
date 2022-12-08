/*
Tanfolyamok
        Egy felnőttképző cég mindenféle témájú tanfolyamokat kínál. Ennek modellezésére hozd létre a Course osztályt, amelynek attribútumai a tanfolyam neve, ára és a szintje! Ez utóbbi egy Level nevű enum az alábbi példányokkal: BEGINNER, ADVANCED, EXPERT. Ezek után írd meg a következő metódusokat:
        Course getCheaperCourse(int maxPrice): visszaad egy olyan kurzust, amely legfeljebb annyiba kerül, mint a megadott ár. Ha nem talál ilyet, kivételt dob (ennek üzenetét megtalálod a tesztben).
        int getPriceOfCourseWithGivenNameAndLevel(String name, Level level): megmondja annak a kurzusnak az árát, amelynek a neve és a szintje megegyezik a paraméterül átadott értékekkel. Ha nem talál ilyet, kivételt dob.
        String getNameOfCourseWithGivenLevel(Level level): visszaadja egy kurzus nevét, amelyik a megadottnak megfelelő szintű. Ha nem talál ilyet, visszaadja azt a szöveget, hogy "Sorry, there is no course at this level."
        Bár ezek a metódusok implementálhatóak Optional használata nélkül is, most azonban kifejezetten az a cél, hogy úgy írd meg őket, hogy közben használod az Optional osztály most megismert metódusait! Példányosíts egy Optional-t és tedd bele a keresés eredményét! Majd úgy térj vissza a metódusokból, hogy közben használd az orElse() vagy az orElseThrow() metódusok valamelyikét!
*/

package optional.training;

import java.util.ArrayList;
import java.util.List;

public class TrainingCompany {

    private final List<Course> courses;

    public TrainingCompany(List<Course> courses) {
        this.courses = new ArrayList<>(courses);
    }

    public Course getCheaperCourse(int maxPrice) {
        return courses.stream()
                .filter(c -> c.price() < maxPrice)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("No such course."));
    }

    public int getPriceOfCourseWithGivenNameAndLevel(String name, Level level) {
        return courses.stream()
                .filter(c -> c.name().equals(name) && c.level() == level)
                .map(Course::price)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("No such course."));
    }

    public String getNameOfCourseWithGivenLevel(Level level) {
        return courses.stream()
                .filter(c -> c.level() == level)
                .map(Course::name)
                .findAny()
                .orElse("Sorry, there is no course at this level.");
    }
}
