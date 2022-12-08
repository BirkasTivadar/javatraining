/*
Klubtagok
        Hozz létre egy Member osztályt, String name, List<String> skills, Gender gender attribútumokkal!
        Majd hozz létre egy Club osztályt, mely Member objektumokat képes tárolni!
        A Optional<Member> findFirst(Predicate<Member> predicate) metódusa paraméterként egy keresési feltételt kap, visszatérési típusa Optional. Ha talál a keresési feltételnek megfelelő tagot, akkor az elsőt adja vissza, ha nem talál, üres értékkel tér vissza.
        Az Optional<Double> averageNumberOfSkills() üres értékkel tér vissza, ha a klub nem tartalmaz tagot. Ellenkező esetben átlagolja a tagok szakértelmének számát, és azzal tér vissza.
*/

package lambdaoptional.club;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Club {
    private final List<Member> members;

    public Club(List<Member> members) {
        this.members = new ArrayList<>(members);
    }

    public Optional<Member> findFirst(Predicate<Member> predicate) {
        return members.stream().filter(predicate).findFirst();
    }

    public Optional<Double> averageNumberOfSkills() {
        if (members.isEmpty()) return Optional.empty();
        int sum = 0;
        for (Member member : members) {
            sum += member.skills().size();
        }
        return Optional.of((double) sum / members.size());
    }
}
