/*
Majd legyen egy WebShop osztályod is, amelynek van egy listája, ahol nyilvántartja az általa árusított termékeket! Készíts egy findHowMany(Product product) metódust, amely a paraméterként átadott termék equals() metódusát felhasználva visszaadja, hogy hányszor szerepel az adott termék a webáruház listájában. Ezután az osztály main() metódusában próbáld is ki, hogy több különböző, de ugyanolyan regisztrációs számmal rendelkező terméket adsz a listához, majd meghívod a findHowMany() metódust, átadva neki egy szintén újonnan példányosított, de ugyanolyan regisztrációs számú terméket! Írd ki a metódus visszatérési értékét a konzolra!
*/

package collectionsequalshash;

import java.util.ArrayList;
import java.util.List;

public class WebShop {

    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public int findHowMany(Product product) {
        return (int) products.stream().filter(p -> p.equals(product)).count();
    }

    public static void main(String[] args) {
        WebShop webShop = new WebShop();

        webShop.addProduct(new Product("miel", "1234"));
        webShop.addProduct(new Product("miel", "356"));
        webShop.addProduct(new Product("mantequilla", "1234"));
        webShop.addProduct(new Product("pan", "1234"));
        webShop.addProduct(new Product("coche", "1111"));

        System.out.println(webShop.findHowMany(new Product("azúcar", "1234")));  //3
        System.out.println(webShop.findHowMany(new Product("miel", "1234"))); //3
        System.out.println(webShop.findHowMany(new Product("miel", "356"))); //1
        System.out.println(webShop.findHowMany(new Product("miel", "456"))); //0
        System.out.println(webShop.findHowMany(new Product("frigorífico", "1111"))); //1
    }
}
