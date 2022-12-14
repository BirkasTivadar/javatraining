/*
Nevek
        Az első feladatban egyszerűen neveket fogunk eltárolni fájlban és listában egyaránt. A NameWriter osztály konstruktorban megkapja az írni kívánt fájlt. Az addAndWrite() metódus egy nevet vár paraméterül, amelyet hozzáfűzi a fájlhoz. A hozzáfűzéshez használd a korábban megismert StandardOpenOption.Append paramétert a newBufferedWriter() metódusban.
*/

package iowriter.names;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NameWriter {

    private final Path file;

    public NameWriter(Path file) {
        this.file = file;
    }

    public void addAndWrite(String name) {

        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardOpenOption.APPEND)) {
            writer.write(name);
            writer.newLine();
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not open file", ioException);
        }
    }
}
