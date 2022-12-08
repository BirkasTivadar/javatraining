/*
Papírgyűjtés
        Az iskolában papírgyűjtést hirdetnek, amely egy osztályok közötti verseny. Az egyes diákok által behozott papír súlya mindig az adott diák osztálya által behozott mennyiséget gyarapítja. A pillanatnyi állást egy Map-ben tárolják, ahol a kulcsok az osztályok nevei (String), az értékek pedig az adott osztályba járó diákok által idáig összesen behozott papír (kilogrammban). Tehát olyan módon kell elképzelni az egyes Map-bejegyzéseket, hogy:
        "1.a" - 235
        "5.b" - 421
        "8.a" - 398
        A Paper osztály tárolja attribútumként ezt a Map-et, és legyen hozzá getter metódusa és egy putFurtherPaper(String className, int kilogramms) metódus, amellyel egy adott osztályhoz tartozó mennyiséget gyarapítani lehet. A Map-ben nincs benne alapértelmezetten az osztályok neve, tehát azt nem kell tárolni, hogy egy osztály eddig 0 kg papírt gyűjtött. Az osztály neve akkor kerüljön bele a Map-be, amikor az adott osztályból az első diák behoz valamennyi papírt! Legyen az osztályban még két másik metódus is:
        String getWinnerClass() - ez a metódus adja vissza, hogy a pillanatnyi állás alapján melyik osztály a verseny győztese!
        int getTotalWeight() ez a metódus pedig adja vissza, hogy összesen mennyi papírt gyűjtöttek az iskola tanulói!
*/

package collectionsautoboxing;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Paper {

    private final Map<String, Integer> paper = new HashMap<>();

    public Map<String, Integer> getPaper() {
        return new HashMap<>(paper);
    }

    public void putFurtherPaper(String className, int kilogramms) {
        if (!paper.containsKey(className)) paper.put(className, kilogramms);
        else paper.put(className, paper.get(className) + kilogramms);
//      paper.put(className, paper.containsKey(className) ? paper.get(className) + kilogramms : kilogramms);
    }

    public String getWinnerClass() {
        Optional<Map.Entry<String, Integer>> winner = paper.entrySet().stream()
                .max(Map.Entry.comparingByValue());
        if (winner.isPresent()) return winner.get().getKey();
        throw new IllegalArgumentException("Wrong data.");
    }

    public int getTotalWeight() {
        return paper.values().stream().reduce(0, Integer::sum);
    }
}
