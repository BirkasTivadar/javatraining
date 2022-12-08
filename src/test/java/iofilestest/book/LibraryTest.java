package iofilestest.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryTest {

    @TempDir
    public File folder;

    Path path;
    Book book1 = new Book("Solohov", "Csendes Don");
    Book book2 = new Book("Jókai Mór", "Arany ember");
    Book book3 = new Book("Solohov", "Csendes Don");

    Library library = new Library();

    @BeforeEach
    public void init() {
        File file = new File(folder, "test.txt");
        path = file.toPath();

        library.add(book1);
        library.add(book2);
        library.add(book3);
    }


    @Test
    void testAddBook() {
        assertEquals(2, library.getBooks().size());
        assertEquals("Solohov", library.getBooks().get(0).author());
    }

    @Test
    void testSaveBooks() throws IOException {
        library.saveBooks(path);
        List<String> books = Files.readAllLines(path);
        assertEquals(library.getBooks().get(0).toString(), books.get(0));
    }

    @Test
    void testLoadBooks() {
        Library testLibrary = new Library();

        library.saveBooks(path);
        testLibrary.loadBooks(path);

        assertEquals(2, testLibrary.getBooks().size());
        assertEquals("Solohov", testLibrary.getBooks().get(0).author());
    }
}