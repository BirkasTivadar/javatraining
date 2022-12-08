/*
Online tanórák nyilvántartása
        Készíts egy egyszerű alkalmazást, mellyel egy otthoni online tanulásra kényszerülő diák nyomon tudja követni, hogy mikor, melyik tanárral, milyen tanórája lesz. Legyen egy OnlineLesson osztály, amelynek három attribútuma van: a tanár neve, a tanóra címe és a tanóra kezdési időpontja! Mivel az otthoni online órák világa általában kaotikus és gyorsan változik, ezért szükség lesz néhány metódusra is. Ezekhez hozd létre a HomeSchooling osztályt, és következőket valósítsd meg: (Amit tudsz, azt iterátor használatával, amit nem, azt sima ciklussal.)
        addNewLesson(OnlineLesson lesson): ezzel a diák új órát tud betenni az órarendjébe, de fontos, hogy az időrendben a megfelelő helyre kerüljön be!
        getLessonsByTitle(String title): ezzel le lehet kérni az összes ugyanolyan típusú tanórát, pl. az összes matekórát.
        removeLesson(LocalDateTime startTime): ezzel lehet kezdési időpont alapján tanórát törölni. (Így a diák az olyan jellegű tanári e-mailekre tud reagálni, hogy “Kedves Gyerekek! A pénteki első óra elmarad.”)
*/

package collectionsiterator.lessons;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomeSchooling {

    private final List<OnlineLesson> lessons = new ArrayList<>();

    public List<OnlineLesson> getLessons() {
        return new ArrayList<>(lessons);
    }

    public void addNewLesson(OnlineLesson lesson) {
        if (lessons.isEmpty()) {
            lessons.add(lesson);
            return;
        }
        for (int i = 0; i < lessons.size(); i++) {
            if (lesson.startTime().isBefore(lessons.get(i).startTime())) {
                lessons.add(i, lesson);
                return;
            }
        }
        lessons.add(lesson);
    }

    public List<OnlineLesson> getLessonsByTitle(String lessonTitle) {
        List<OnlineLesson> result = new ArrayList<>();
        Iterator<OnlineLesson> oli = lessons.iterator();
        while (oli.hasNext()) {
            OnlineLesson lesson = oli.next();
            if (lesson.lessonTitle().equals(lessonTitle)) result.add(lesson);
        }
        return result;
    }

    public void removeLesson(LocalDateTime time) {
        Iterator<OnlineLesson> oli = lessons.iterator();
        while (oli.hasNext()) {
            if (oli.next().startTime().equals(time)) oli.remove();
        }
//      lessons.removeIf(lesson -> lesson.startTime().equals(time));
    }
}
