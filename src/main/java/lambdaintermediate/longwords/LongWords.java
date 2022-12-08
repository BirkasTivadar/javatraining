/*
Hosszú szavak
        Készíts egy LongWords osztályt, amelynek legyen egy szavakat tartalmazó lista attribútuma! Az osztály metódusait streamek segítségével implementáld:
        long getNumberOfWordsStartWith(String keyWord): visszaadja, hány szó kezdődik a megadott kulcsszóval.
        List<String> getLongerWords(int number): visszaadja azon szavak listáját, amelyek a paraméterként megadott számnál több betűből állnak.
        Optional<String> getShortestWordContainingGivenCharacter(char character): visszaadja a legrövidebb olyan szót, amely tartalmazza a megadott karaktert.
*/

package lambdaintermediate.longwords;

import java.util.List;
import java.util.Optional;

public record LongWords(List<String> words) {

    public long getNumberOfWordsStartWith(String str) {
        return words.stream()
                .filter(w -> w.startsWith(str))
                .count();
    }

    public List<String> getLongerWords(int minNumberOfLetters) {
        return words.stream()
                .filter(w -> w.length() > minNumberOfLetters)
                .toList();
    }

    public Optional<String> getShortestWordContainingGivenCharacter(char character) {
        return words.stream()
                .filter(w -> w.contains(String.valueOf(character)))
                .min((w1, w2) -> w1.length() - w2.length());
    }
}
