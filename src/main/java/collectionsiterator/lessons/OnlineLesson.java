/*
Legyen egy OnlineLesson osztály, amelynek három attribútuma van: a tanár neve, a tanóra címe és a tanóra kezdési időpontja!
*/

package collectionsiterator.lessons;

import java.time.LocalDateTime;

public record OnlineLesson(String teacherName, String lessonTitle, LocalDateTime startTime) {

}
