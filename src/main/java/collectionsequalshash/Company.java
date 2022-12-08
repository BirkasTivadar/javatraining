/*
Cégadatok
        Legyen egy Company osztályod, amelynek két attribútuma: a cég neve és adószáma! Írd felül az osztályban az equals() és a hashCode() metódusokat úgy, hogy mindkét attribútum értékét figyelembe vegyék, vagyis két céget akkor tekintsünk megegyezőnek, ha a neve és az adószáma is megegyezik! Hozz létre egy RegistryCourt (cégbíróság) osztályt, amelynek main() metódusában készíts egy Company típusú elemeket tartalmazó listát! Példányosíts ezenkívül néhány céget, amelyeket adj a listához, majd írd ki a konzolra, hogy a lista tartalmaz-e ilyen elemeket. A következő módon csináld ezt: Például ha hozzáadod a listához ezt a céget: new Company("Cég Kft", "1234");, akkor így hívd meg a lista contains() metódusát: contains(new Company("Cég Kft", "1234"))! (A lista contains() metódusa az átadott elem equals() metódusát hívja, és az alapján keresi az adott elemet a listában.)
*/

package collectionsequalshash;

import java.util.Objects;

public record Company(String name, String taxNumber) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company company)) return false;
        return Objects.equals(name, company.name) && Objects.equals(taxNumber, company.taxNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, taxNumber);
    }
}
