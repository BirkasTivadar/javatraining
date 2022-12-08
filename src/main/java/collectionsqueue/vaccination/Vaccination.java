/*
Oltási sorrend
        Egy járványos betegségre kifejlesztett vakcina nem adható gyerekeknek (18 év alattiaknak), valamint 65 év feletti felnőtteknek sem. Sőt, mivel eléggé megterheli a szervezetet, az a legjobb, ha minél fiatalabb, aki kapja.
        Hozz létre egy Person osztályt, melynek két attribútuma van: név és életkor! Hozz létre egy Vaccination osztályt is, amelyben legyen egy Queue<Integer> getVaccinationOrder(List<Person> people) metódus, amely az emberek listájából kiválogatja a 18 évnél nem fiatalabb és a 65 évnél nem idősebb embereket, és az életkorukat egy PriorityQueue-ban adja vissza. Az osztály main() metódusában példányosítsd le a listát, adj hozzá néhány embert (mindenféle életkorút), majd hívd meg a listával a getVaccinationOrder() metódust! Írd ki a kapott értéket a konzolra! Majd hívd meg a kapott PriorityQueue-n a poll() metódust, és írd ki a konzolra, melyik értéket veszi ki először!
*/

package collectionsqueue.vaccination;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class Vaccination {

    public Queue<Integer> getVaccinationOrder(List<Person> people) {
        return people.stream()
                .filter(p -> p.age() > 18 && p.age() < 65)
                .map(Person::age)
                .sorted()
                .collect(Collectors.toCollection(PriorityQueue::new));
    }

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John Doe", 45),
                new Person("Old John Doe", 65),
                new Person("Very Old John Doe", 95),
                new Person("Jack Doe", 36),
                new Person("Jane Doe", 20),
                new Person("Young Jane Doe", 18)
        );

        Vaccination vaccination = new Vaccination();

        Queue<Integer> ages = vaccination.getVaccinationOrder(people);
        System.out.println(ages);
        System.out.println(ages.poll());
    }
}
