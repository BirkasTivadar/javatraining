/*
Osztálykirándulás
        A ClassTrip osztály egy Map<String, Integer> típusú attribútumban tárolja osztálykirándulásra már befizetett pénzeket. A Map-ben a kulcsok a tanulók nevei, az értékek pedig az, hogy ki mennyit fizetett eddig be. Hozd létre az osztályt, és benne ezt az attribútumot HashMap-ként, getterrel együtt! Az attribútum bejegyzéseit egy fájlból töltsd be a loadInpayments(Path path) metódussal, melynek formátuma:
        Kiss József: 12500
        Nagy Béla: 5000
        Szép Virág: 15000
        Hozd létre a fájlt is (inpayments.txt), hogy a metódust tesztelni lehessen!
*/

package collectionsmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ClassTrip {

    private final Map<String, Integer> inpayments = new HashMap<>();

    public Map<String, Integer> getInpayments() {
        return new HashMap<>(inpayments);
    }

    public void loadInpayments(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineArr = line.split(": ");
                String name = lineArr[0];
                int inpayment = Integer.parseInt(lineArr[1]);
                inpayments.put(name, inpayment);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }

    }
}
