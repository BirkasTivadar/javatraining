/*
Könyvcímek
        Készíts egy Book osztályt, melynek attribútumai: szerző, cím és az oldalak száma! Majd készíts egy Read osztályt, amelynek van egy könyveket tartalmazó lista attribútuma! Legyen az osztálynak egy List<String> listBookTitlesShorterThanGiven(int maxNumberOfPages) metódusa, amely kiválogatja és egy listában visszaadja azon könyvek címét, amelyek a megadott paraméternél kevesebb oldalból állnak! Írj egy List<String> listBookTitlesWithGivenAuthor(String author) metódust, amely ábécé-sorrendben adja vissza egy paraméterül kapott szerző könyveinek címeit! Végül írj egy List<String> listAuthors() metódust, amely egy listában visszaadja a szerzők neveit! Fontos, hogy minden szerző neve csak egyszer szerepeljen!
*/

package streams.books;

import java.util.ArrayList;
import java.util.List;

public class Read {

    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<String> listBookTitlesShorterThanGiven(int maxNumberOfPages) {
        return books.stream()
                .filter(b -> b.pages() < maxNumberOfPages)
                .map(Book::title)
                .toList();
    }

    public List<String> listBookTitlesWithGivenAuthor(String author) {
        return books.stream()
                .filter(b -> b.author().equals(author))
                .map(Book::title)
                .sorted()
                .toList();
    }

    public List<String> listAuthors() {
        return books.stream()
                .map(Book::author)
                .distinct()
                .toList();
    }
}
