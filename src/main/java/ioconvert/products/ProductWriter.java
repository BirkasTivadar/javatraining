/*
Termékek
        Az ioconvert.products csomagba hozd létre a ProductWriter osztályt, és benne a saveProduct() metódust, mely két paramétert kap: egy OutputStream-et és egy List<Product>-ot. A feladata a lista adatait kiírni csv formátumban az OutputStream-re, azaz pontosvesszővel elválasztva a Product adatait. Minden termék külön sorba kerüljön, a sor végére nem kell ;. Kiíráshoz használd a PrintStream osztályt!
        A Product tartalmazza a termék nevét (String) és az árát (int).
*/

package ioconvert.products;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class ProductWriter {
    public void saveProduct(OutputStream os, List<Product> products) {
        try (PrintStream printStream = new PrintStream(os)) {
            for (Product product : products) {
                printStream.print(product.name());
                printStream.print(";");
                printStream.println(product.price());
            }
        }
    }
}
