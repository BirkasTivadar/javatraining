/*
Bemeneti adatok ellenőrzése
    Hozz létre egy measurementdata.csv fájlt a következő tartalommal:
        1,12.4,John Doe
        2,12.4,John Doe,a
        a,12.4,John Doe
        3,12a.4,John Doe
        4,12.4,JohnDoe
        5,12.4,John Doe
        6,12.4,John Doe
        a1,12a.4,John Doe
        7,12a.4,John Doe
        8,12.4
        9,12.4,
    Ezek egy mérésből származó adatokat reprezentálnak, melyeket fájlban továbbítanak az adatok feldolgozásának helyére. Az adatsorok szerkezete: sorszám,mért érték,mérést végző neve. Pl. 1,12.4,John Doe. A feladat az, hogy ellenőrizd le a kapott adatokat és készíts jelentést a hibás sorokról, melyeket egy List<String> formájában adj vissza! Mindez a következőképpen történjen:
    A measurement.Measurement osztályban legyen egy List<String> readFromFile(Path path) metódus, mely beolvassa az adatokat, és legyen egy List<String> validate(List<String>) metódus, mely paraméterül megkapja a beolvasott értékek listáját és visszatér a hibalistával! A fájlbeolvasó metódus dobjon IllegalStateException kivételt, ha a fájl beolvasása során hiba történik, de a validáló metódus értelemszerűen ne dobjon kivételt, ha hibás sorra fut, hanem kezeld ezt a helyzetet megfelelően! Hibás adatnak minősül természetesen az az eset, ahol nem alakítható számmá a sorszám vagy a mért érték, illetve az is, ha a mérést végző neve nem áll legalább két tagból (vezeték- és keresztnév). A validálás egyes részeit érdemes külön, boolean visszatérési értékű privát metódusokban végezni!
    Írd meg a tesztet is a metódusok működésének ellenőrzésére!
*/

package exceptions.measurement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Measurement {

    public List<String> readFromFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.");
        }
    }

    public List<String> validate(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if(!isValidLine(line)) result.add(line);
        }
        return result;
    }

    private boolean isValidLine(String line){
            String[] lineArr = line.split(",");
            return isRightSize(lineArr) && isNumber(lineArr[0]) && isNumber(lineArr[1]) && isName(lineArr[2]);

    }

    private boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private boolean isRightSize(String[] stringArr) {
        return stringArr.length == 3;
    }

    private boolean isName(String name) {
        String[] nameArr = name.split(" ");
        return nameArr.length == 2;
    }
}
