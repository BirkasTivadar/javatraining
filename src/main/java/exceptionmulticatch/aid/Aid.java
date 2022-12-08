/*
Segély
        Segélyt osztanak a következő módon: minden településre ugyanakkora összeg jut, amelyet a rászorulók között osztanak szét. Mivel minden településen más a rászorulók létszáma, ezért szükség van arra, hogy a központilag kapott összeget elosszák az érintettek létszámával. A létszámok településenként egy fájlban találhatók, és egy olyan metódust kell létrehozni, amely a fájlból kinyert adatok segítségével kiszámolja és egy listában visszaadja, hogy melyik településen hány forint jut egy-egy főre. Fontos még, hogy egész számokkal számolnak, nem foglalkoznak az összegek kerekítésével. A fájl formátuma ez:
        Budapest: 1
        Kukutyin: 28
        Kiskunalsófelső: 532
        Ha 1 489 600 Ft az egy településre jutó összeg, akkor a következő, String típusú elemeket tartalmazó listát várjuk vissza:
        "Budapest: 1489600",
        "Kukutyin: 53200",
        "Kiskunalsófelső: 2800"
        Mindehhez szükség van egy aid.Aid nevű osztályra, amelynek attribútuma az egy településre jutó összeg (int amount). Ennek értékét a konstruktorban állítja be. Ezenkívül van az osztálynak még egy List<String> countAmountsOfAid(Path path) metódusa, amely a fájl elérési útvonalának ismeretében kiszámolja az egyes településeken az egy főre jutó összegeket, és azokat a már előzőleg említett listában visszaadja. Ezen műveletek közben sok hiba előfordulhat, például ha a metódus a fájl elérési útvonala helyett null értéket kap paraméterül, vagy ha a fájlban az egyik sor valamiért nem megfelelő (mondjuk hiányzik a településnév, nem megfelelő számot írtak be az egyik településhez vagy éppen az egyik településen nincs rászoruló ember). A sokféle kivétel keletkezésére mindre fel kell készülni (a konkrét kezelendő kivételek típusához segítséget nyújtanak a tesztesetek is). Használj multi catch-et!
        A metódus teszteléséhez szükséges lépés még, hogy hozd létre a projekted src/test/resources könyvtárában az alábbi négy fájlt a megadott tartalmakkal:
        A population1.txt tartalma:
        Budapest: 1
        Kukutyin: 28
        Kiskunalsófelső: 532
        A population2.txt tartalma:
        Budapest: 1
        Kukutyin: 28
        4421
        Kiskunalsófelső: 532
        A population3.txt tartalma:
        Budapest: 1
        Kukutyin: 28
        Alsómáriatelep: 342a1
        Kiskunalsófelső: 532
        A population4.txt tartalma:
        Budapest: 1
        Kukutyin: 28
        Világvégeutánkettővel: 0
        Kiskunalsófelső: 532
*/

package exceptionmulticatch.aid;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Aid {

    private final int amount;

    public Aid(int amount) {
        this.amount = amount;
    }

    public List<String> countAmountsOfAid(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            return getAidPerPerson(lines);
        } catch (NullPointerException | IOException | ArrayIndexOutOfBoundsException | NumberFormatException |
                 ArithmeticException e) {
            throw new IllegalStateException("Something went wrong while counting.", e);
        }
    }

    private List<String> getAidPerPerson(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            String[] lineArr = line.split(" ");
            String aidPerPerson = lineArr[0];
            int aidPopulation = Integer.parseInt(lineArr[1]);
            aidPerPerson = aidPerPerson + " " + amount / aidPopulation;
            result.add(aidPerPerson);
        }
        return result;
    }
}
