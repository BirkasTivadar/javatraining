/*
Könyvtár
        Készíts egy Book osztályt, amely a könyv címét és szerzőjét tartalmazza. A Library osztály a könyvek listáját attribútumként tárolja. Könyveket lehet hozzáadni az add(Book...) metódusával, mely csak azokat a könyveket adja a listához, amelyek még nem voltak benne. Az osztály aktuális állapotát szöveges fájlba lehet menteni, illetve fájlból be lehet tölteni az ott lévő könyveket.
        Készítsd el a teszteket is a Library osztályhoz.
*/

package iofilestest.book;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private final List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public void add(Book book) {
        if (!books.contains(book)) books.add(book);
    }

    public void saveBooks(Path path) {
        try (PrintStream printStream = new PrintStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            for (Book book : books) {
                printStream.print(book.author());
                printStream.print(": ");
                printStream.println(book.title());
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not write file", ioException);
        }
    }

    public void loadBooks(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] bookArr = line.split(": ");
                books.add(new Book(bookArr[0], bookArr[0]));
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read file", ioException);
        }
    }
}
