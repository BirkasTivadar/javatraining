/*
Regisztrációs szám
        Legyen egy Product osztályod és azon belül két attribútum: név és regisztrációs szám! Egy webáruházban a regisztrációs számuk alapján különböztetik meg a termékeket, ezért a Product osztályban ez alapján írd felül az equals() és a hashCode() metódusokat! Majd legyen egy WebShop osztályod is, amelynek van egy listája, ahol nyilvántartja az általa árusított termékeket! Készíts egy findHowMany(Product product) metódust, amely a paraméterként átadott termék equals() metódusát felhasználva visszaadja, hogy hányszor szerepel az adott termék a webáruház listájában. Ezután az osztály main() metódusában próbáld is ki, hogy több különböző, de ugyanolyan regisztrációs számmal rendelkező terméket adsz a listához, majd meghívod a findHowMany() metódust, átadva neki egy szintén újonnan példányosított, de ugyanolyan regisztrációs számú terméket! Írd ki a metódus visszatérési értékét a konzolra!
*/

package collectionsequalshash;

import java.util.Objects;

public record Product(String name, String registerNumber) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(registerNumber, product.registerNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registerNumber);
    }
}
