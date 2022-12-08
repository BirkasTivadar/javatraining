/*
Legyen egy Comment osztály, amely tartalmazzon egy String text és egy LocalDateTime time attribútumot! A megjegyzések copy konstruktorral legyenek másolhatóak!
*/

package clone.issuetracker;

import java.time.LocalDateTime;

public class Comment {

    private String text;
    private final LocalDateTime time;

    public Comment(String text, LocalDateTime time) {
        this.text = text;
        this.time = time;
    }

    public Comment(Comment comment) {
        text = comment.text;
        time = comment.time;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setText(String text) {
        this.text = text;
    }
}
