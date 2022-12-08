/*
Könyvesbolt
        Készíts egy bookstore.Book osztályt a könyv címével, kiadási évével, árával, darabszámával! A konstruktor is ebben a sorrendben kapja meg az adatokat!
        A BookStore osztály tartalmazza a könyvek listáját. A listát a konstruktorban kapja meg! Készítsd el benne az alábbi metódusokat streamek segítségével:
        Integer getNumberOfBooks(): a könyvek darabszámát adja meg.
        Optional<Book> findNewestBook(): a legújabb kiadású könyvet adja vissza.
        Integer getTotalValue(): a könyvek összértékét adja meg.
*/


package lambdastreams.bookstore;

import java.util.List;
import java.util.Optional;

public record BookStore(List<Book> books) {
    public int getNumberOfBooks() {
        return books.stream()
                .mapToInt(Book::pieces)
                .sum();
    }

    public Optional<Book> findNewestBook() {
        return books.stream()
                .min((b1, b2) -> b2.yearOfPublish() - b1.yearOfPublish());
    }

    public int getTotalValue() {
        return books.stream()
                .mapToInt(b -> b.pieces() * b.price())
                .sum();
    }
}
