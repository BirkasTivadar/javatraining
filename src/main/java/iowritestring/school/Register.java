/*
Napló
        Ebben a feladatban egy iskolai naplózó rendszert kell megvalósítanod.
        Készíts a school csomagban egy Register nevű osztályt benne registerStudent  metódussal ami paraméterül várja a tanuló nevét, és egy path objektumot.
        A registerNewMark(Path file) metódussal tudunk új jegyet beírni a fájlba!
         Azt, hogy létezik-e egy fájl a Files.exists(path) metódussal tudod eldönteni.
        Az év végén a tanár szeretné a tanuló fájl utolsó sorába az átlagot beírni. Írj egy metódust writeAverage(Path file) névvel, ami a fájl utolsó sorába a jegyek átlagát írja be! Például "average: 5".
*/

package iowritestring.school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.OptionalDouble;

public class Register {
    public void registerStudent(String name, Path file) {
        try {
            Files.writeString(file, name + "\n");
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not write file", ioException);
        }
    }

    public void registerNewMark(Path file, int mark) {
        if (!Files.exists(file)) throw new IllegalArgumentException("File does not exist");
        try {
            Files.writeString(file, mark + "\n", StandardOpenOption.APPEND);
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not write file", ioException);
        }
    }

    public void writeAverage(Path file) {
        if (!Files.exists(file)) throw new IllegalArgumentException("File does not exist");

        double average = getAverageForFile(file);
        writeAverageToFile(file, average);
    }

    private void writeAverageToFile(Path file, double average) {
        try {
            Files.writeString(file, "average: " + average, StandardOpenOption.APPEND);
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not write file", ioException);
        }
    }

    private Double getAverageForFile(Path file) {
        OptionalDouble optionalAverage;
        try {
            optionalAverage = Files.readAllLines(file).stream()
                    .skip(1)
                    .mapToInt(Integer::parseInt)
                    .average();
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read file", ioException);
        }
        return optionalAverage.orElse(0);
    }
}
