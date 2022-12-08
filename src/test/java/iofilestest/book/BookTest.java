package iofilestest.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testBook() {
        Book book1 = new Book("Solohov", "Csendes Don");
        Book book2 = new Book("Jókai Mór", "Arany ember");
        Book book3 = new Book("Solohov", "Csendes Don");

        assertEquals("Jókai Mór", book2.author());
        assertEquals("Arany ember", book2.title());

        assertEquals(book1, book3);
        assertNotEquals(book1, book2);
    }
}