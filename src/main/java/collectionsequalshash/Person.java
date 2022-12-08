/*
Személyi adatok
        Hozz létre egy Person osztályt, amelyben három attribútum legyen: név, életkor és TAJ-szám. Különböző élethelyzetekben az ember neve és életkora lehet más, de a TAJ-száma mindig ugyanaz. Írd felül az osztályban az equals() és hashCode() metódusokat úgy, hogy azok a TAJ-szám értékét vegyék figyelembe két személy összehasonlításakor! Próbáld ki az osztály main() metódusában a következőt: példányosíts két különböző Person objektumot, akiknek az adatai közül csak a TAJ-szám egyezzen meg! Hasonlítsd össze őket az equals() metódussal, és az eredményt írd ki a konzolra! Hívd meg mindkettőn a hashCode() metódust is, és ennek az eredményét is írd ki a konzolra!
*/

package collectionsequalshash;

import java.util.Objects;

public record Person(String name, int age, String ssn) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(ssn, person.ssn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssn);
    }

    public static void main(String[] args) {
        Person johnDoe = new Person("John Doe", 45, "123456789");
        Person janeDoe = new Person("Jane Doe", 30, "123456789");

        System.out.println(johnDoe.equals(janeDoe));
    }
}
