/*
Hibabejelentések
        Egy hibabejelentő rendszer egy alkalmazással kapcsolatosan bejelentett hibákat tartalmazza.
        Legyen egy issuetracker.Issue osztály, mely a rendszerben lévő hibákat reprezentálja, egy name attribútummal, LocalDateTime time és egy Status status attribútummal! A Status egy enum NEW, IN_PROGRESS és CLOSED értékekkel.
        Legyen egy Comment osztály, amely tartalmazzon egy String text és egy LocalDateTime time attribútumot! A megjegyzések copy konstruktorral legyenek másolhatóak!
        Az Issue tartalmazzon egy Comment listát!
        A Issue osztálynak is legyen egy copy konstruktora, mely kap egy másik Issue példányt, valamint egy CopyMode enum értéket! Ez vagy CopyMode.WITH_COMMENTS vagy CopyMode.WITHOUT_COMMENTS! Előbbi esetben a megjegyzéseket is másolja, utóbbi esetben nem! A megjegyzések másolásakor azoknak a copy konstruktora kerüljön meghívásra (deep copy)!
*/

package clone.issuetracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Issue {
    private final String name;
    private final LocalDateTime time;
    private final Status status;

    private final List<Comment> comments = new ArrayList<>();

    public Issue(String name, LocalDateTime time, Status status) {
        this.name = name;
        this.time = time;
        this.status = status;
    }

    public Issue(Issue issue, CopyMode copyMode) {
        name = issue.name;
        time = issue.time;
        status = issue.status;
        if (copyMode == CopyMode.WITH_COMMENTS) issue.comments.forEach(c -> comments.add(new Comment(c)));
    }

    public void addComments(Comment comment) {
        comments.add(comment);
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Status getStatus() {
        return status;
    }

    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }
}
