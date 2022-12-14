package genericsusage.withgenerics;

import genericsusage.Book;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LibraryTest {

    @Test
    void testThrowExceptionIfArgumentIsNull() {
        Exception ex = assertThrows(NullPointerException.class, () -> new Library().getFirstBook(null));
        assertEquals("Argument should not be null!", ex.getMessage());
    }

    @Test
    void testThrowExceptionIfArgumentIsEmptyList() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Library().getFirstBook(Collections.emptyList()));
        assertEquals("Argument should not be empty!", ex.getMessage());
    }

    @Test
    void testGetFirstBook() {
        assertEquals("Egri Csillagok", new Library().getFirstBook(List.of(new Book("Egri Csillagok"))).title());
    }
}
