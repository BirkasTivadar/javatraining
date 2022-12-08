/*
Webshop
        Írj egy webshop.Product osztályt name, price és LocalDateTime from attribútumokkal, konstruktorral, getterekkel! Írj egy webshop.WebShop osztályt mely tartalmaz egy Product lista attribútumot! Implementálj három metódust, melyek a termékeket különböző sorrendben adják vissza (mindegyik más attribútuma szerint rendezze a termékeket)! Ne az eredeti listát rendezd, hanem mindig készíts egy másolatot! A Comparator implementációkat anonymous inner classként add meg!
*/

package sorting.webshop;

import java.util.ArrayList;
import java.util.List;

public class WebShop {

    private final List<Product> products = new ArrayList<>();

    public void addProducts(Product product) {
        products.add(product);
    }

    public List<Product> getProductsOrderByName() {
        List<Product> result = new ArrayList<>(products);
        result.sort((o1, o2) -> o1.name().compareTo(o2.name()));
        return result;
    }

    public List<Product> getProductsOrderByPrice() {
        List<Product> result = new ArrayList<>(products);
        result.sort((o1, o2) -> o1.price() - o2.price());
        return result;
    }

    public List<Product> getProductsOrderByDate() {
        List<Product> result = new ArrayList<>(products);
        result.sort((o1, o2) -> o1.time().compareTo(o2.time()));
        return result;
    }
}
