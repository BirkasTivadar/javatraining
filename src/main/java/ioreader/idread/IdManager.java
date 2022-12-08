/*
Személyi igazolvány számok
        A idread csomagban készítsd el az IdManager osztályt. Ez az osztály felelős az idnumbers.txt (kitalált) személyi igazolvány számokat tartalmazó szöveges állomány feldolgozásáért. A readIdsFromFile() metódus megkap egy fájlnevet, és annak sorait tárolja el az List<String> ids listában.
*/

package ioreader.idread;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IdManager {

    private final List<String> ids = new ArrayList<>();

    public List<String> getIds() {
        return new ArrayList<>(ids);
    }

    public void readIdsFromFile(String file) {
        Path path = Path.of("src", "main", "resources", file);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                ids.add(line);
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read file", ioException);
        }
    }
}
