/*
Telepítés
        Készíts egy Installer osztályt, egyetlen install() metódussal, mely paraméterként a telepítési mappát kapja meg String-ként. A megadott mappán belülre másold át a classpathról az install mappában lévő fájlokat és mappákat az install mappából! Az install.txt fájlban a / jelre végződő sorok mappákat jelölnek, ezeket létre kell hoznod, mielőtt fájlokat másolnál bele. Az esetleges sikertelen telepítésből visszamaradt fájlokat mindig írd felül! Ha a paraméterül kapott mappa nem létezik vagy nem is mappa, dobj IllegalArgumentException kivételt!
*/

package iofiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

public class Installer {
    public void install(String targetDirectory) {
        Path path = createPath(targetDirectory);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(this.getClass().getResourceAsStream("/install/install.txt"))))) {
            copyFiles(path, reader);
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not copy files");
        }
    }

    private void copyFiles(Path path, BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.endsWith("/"))
                Files.createDirectories(path.resolve(line));
            else
                Files.copy(Objects.requireNonNull(this.getClass().getResourceAsStream(String.format("/install/%s", line))), path.resolve(line), StandardCopyOption.REPLACE_EXISTING);
        }
    }

    private static Path createPath(String targetDirectory) {
        Path path = Path.of(targetDirectory);
        if (!Files.exists(path) || !Files.isDirectory(path))
            throw new IllegalArgumentException("The given directory doesn't exist");
        return path;
    }
}
