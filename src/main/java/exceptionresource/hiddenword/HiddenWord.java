/*
Elrejtett szó
    Egy fájlban minden egyes sorban található egy csomó számjegy és a számok között egy-egy betű is. Minden sorban csak egy betű van, vagy egy sem. A hiddenword.HiddenWord osztályban hozd létre a getHiddenWord(Path path) metódust, amely a Scanner osztály használatával megnyitja a paraméterként kapott fájlt, megkeresi a soronként elrejtőzött betűket, és visszaadja a belőlük összeolvasható szót! Ha a metódus nem talál betűt a sorban, akkor szóköz karaktert illesszen be arra a helyre!
    Írd meg a tesztet is! Teszteléshez hozd létre a hiddenword.txt nevű fájlt, például az alábbi tartalommal:
        421421421A43243
        532L55357642617984797978
        46397189969606950M6479647921
        326A4261798
        23251646752718557
        32461756K463821679689
        Ö4321756853821
        6796281968426R6721867
        2467T5632815785
        5628157843628968291578E5785
*/

package exceptionresource.hiddenword;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class HiddenWord {

    public String getHiddenWord(Path path) {
        StringBuilder result = new StringBuilder();
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                result.append(getCharacter(scanner.nextLine()));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return result.toString();
    }

    private char getCharacter(String str) {
        for (Character c : str.toCharArray()) {
            if (Character.isAlphabetic(c)) return c;
        }
        return ' ';
    }
}

