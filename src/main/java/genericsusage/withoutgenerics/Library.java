/*
Generikusok használata nélkül
        Készíts egy Book osztályt, egyetlen attribútummal: String titleImplementálj egy könytárat (withoutgenerics.Library), ahol könyveket tárolhatunk! Valósítsd meg a getFirstBook(List books) metódust generikusok használata nélkül! Ha a könyvtárat reprezentáló kollekció null, a metódus dobjon NullPointerException kivételt! Ha a könyvtárat reprezentáló kollekció üres, a metódus dobjon IllegalArgumentException kivételt!
*/

package genericsusage.withoutgenerics;

import genericsusage.Book;

import java.util.List;

public class Library {

    public Book getFirstBook(List books) {
        if (books == null) throw new NullPointerException("Argument should not be null!");
        if (books.isEmpty()) throw new IllegalArgumentException("Argument should not be empty!");
        try {
            return (Book) books.get(0);
        } catch (ClassCastException cce) {
            throw new ClassCastException("Not a book");
        }
    }
}
