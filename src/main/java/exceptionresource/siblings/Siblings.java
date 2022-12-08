/*
Testvérek
    A siblings.Siblings osztályban hozd létre a List<String> getFullNames(String lastName, Path path) metódust! Ez paraméterül megkap egy családnevet (pl. Szabó) és egy fájl elérési útját. A fájlban az adott családhoz tartozó gyerekek neve van, egymás alatti sorokban, pl. így:
        Emese
        Ferenc
        A metódus a Scanner osztály használatával nyissa meg a fájlt, olvassa be annak sorait, és adja vissza a testvérek teljes nevét egy String listában, tehát így:
        "Szabó Emese"
        "Szabó Ferenc"
    Hozz létre egy tesztfájlt és teszteld is a metódusod működését!
*/

package exceptionresource.siblings;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Siblings {

    public List<String> getFullNames(String lastName, Path path) {
        List<String> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                result.add(lastName.concat(" " + scanner.nextLine()));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return result;
    }
}
