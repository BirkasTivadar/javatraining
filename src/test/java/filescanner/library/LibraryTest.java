package filescanner.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryTest {

    @Test
    void testLoadFromFile() {
        Library library = new Library();

        library.loadFromFile();

        assertEquals(4, library.getBooks().size());
        assertEquals("Robert C. Martin", library.getBooks().get(2).author());
    }
}
