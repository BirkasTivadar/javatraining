/*
Könyvtár
        Egy könyvtár nyilvántartása a könyvek leltári számát, szerzőjét, címét és a kiadás évét tartalmazza. Készíts egy Book osztályt, mely konstruktorában megkapja ezeket az adatokat! Minden adata lekérdezhető, de egyik sem módosítható. A Library osztály attribútumként egy List<Book>-ot tartalmaz. A loadFromFile() metódusa a classpath-on található books.csv fájlból tölti be a könyvek adatait. A fájl minden sora egy könyv adatait tartalmazza pontosvesszővel elválasztva.
        Tipp: Könnyebb a fájl olvasása, ha mind a ;-t, mind a sorvége karaktert beállítod a Scanner elválasztójaként. Ehhez használd delimiterként a ";|(\r\n)" kifejezést!
*/

package filescanner.library;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    private final List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public void loadFromFile() {
        try (Scanner scanner = new Scanner(Path.of("src", "main", "resources", "books.csv"))) {
            loadBooks(scanner);
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read file", ioException);
        }
    }

    private void loadBooks(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] bookArr = line.split(";");
            String regNumber = bookArr[0];
            String author = bookArr[1];
            String title = bookArr[2];
            int yearOfPublish = Integer.parseInt(bookArr[3]);
            books.add(new Book(regNumber, author, title, yearOfPublish));
        }
    }

//    public void loadFromFile() {
//        try(Scanner scanner = new Scanner(Path.of("src", "main", "resources", "books.csv"))) {
//            scanner.useDelimiter(";|(\r\n)|\n");
//            while (scanner.hasNextLine()) {
//                String regNum = scanner.next();
//                String author = scanner.next();
//                String title = scanner.next();
//                int yearOfPublish = scanner.nextInt();
//                books.add(new Book(regNum, author, title, yearOfPublish));
//            }
//        } catch (IOException ioException) {
//            throw new IllegalStateException("Can not read file", ioException);
//        }
//    }
}
