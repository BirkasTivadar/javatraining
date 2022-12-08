/*
Meghallgatás
        Egy meghallgatáson sorszámot kapnak a jelentkezők, és a számok sorrendjében hívják be őket. Aki éppen nincs ott abban a pillanatban, amikor hívják, azt kihagyják és majd később foglalkoznak vele. Írd meg a Casting osztályban a String callNextApplicant(int lastNumber, Map<Integer, String> applicants) metódust, amely paraméterül várja az utolsóként behívott ember sorszámát, valamint a várakozó jelentkezőket egy Map-ben, ahol a kulcsok a sorszámok, az értékek pedig a jelentkezők nevei. A feladat az, hogy iterálj végig a Map kulcsain, és add vissza a sorban következő számmal rendelkező ember nevét! (Ha például a 77, 105, 19, 45 és 82 sorszámú emberek várakoznak éppen, és az utolsóként behívott jelentkező sorszáma 40 volt, akkor a jelenlévők közül a 45-öst fogják behívni következőnek.)
*/

package collectionsmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

public class Casting {

    public String callNextApplicant(int lastNumber, Map<Integer, String> applicants) {
        Optional<Integer> opKey = applicants.keySet().stream()
                .filter(i -> lastNumber - i < 0)
                .min(Comparator.comparingInt(i -> (i - lastNumber)));
        if (opKey.isPresent()) return applicants.get(opKey.get());
        throw new IllegalArgumentException(("Wrong last number"));
    }
}
