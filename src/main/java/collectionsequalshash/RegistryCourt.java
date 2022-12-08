/*
Hozz létre egy RegistryCourt (cégbíróság) osztályt, amelynek main() metódusában készíts egy Company típusú elemeket tartalmazó listát! Példányosíts ezenkívül néhány céget, amelyeket adj a listához, majd írd ki a konzolra, hogy a lista tartalmaz-e ilyen elemeket. A következő módon csináld ezt: Például ha hozzáadod a listához ezt a céget: new Company("Cég Kft", "1234");, akkor így hívd meg a lista contains() metódusát: contains(new Company("Cég Kft", "1234"))! (A lista contains() metódusa az átadott elem equals() metódusát hívja, és az alapján keresi az adott elemet a listában.)
*/

package collectionsequalshash;

import java.util.ArrayList;
import java.util.List;

public class RegistryCourt {

    public static void main(String[] args) {

        List<Company> companies = new ArrayList<>();

        companies.add(new Company("Pannónia Energo", "111222333"));
        System.out.println(companies.contains(new Company("Pannónia Energo", "111222333")));

        companies.add(new Company("Terra Stone Kft", "123123123"));
        System.out.println(companies.contains(new Company("Terra Stone Kft", "123123123")));

        companies.add(new Company("Eurodach Immo Kft.", "88888888"));
        System.out.println(companies.contains(new Company("Eurodach Immo Kft.", "88888888")));
    }
}
