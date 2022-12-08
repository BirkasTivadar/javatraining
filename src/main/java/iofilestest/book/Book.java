/*
Készíts egy Book osztályt, amely a könyv címét és szerzőjét tartalmazza.
*/

package iofilestest.book;

import java.util.Objects;

public record Book(String author, String title) {

    @Override
    public String toString() {
        return String.format("%s: %s", this.author, this.title);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(author, book.author) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title);
    }
}
