/*
Sajtok
        Készíts egy immutable Cheese osztályt, mely a sajt nevét (String) és laktóztartalmát (double) tartalmazza. A CheeseManager osztályba készíts egy olyan saveToFile() metódust, amely a paraméterül kapott Path által reprezentált bináris fájlba menti a szintén paraméterül kapott Cheese lista tartalmát. A findCheese() metódusa a Path-ként kapott fájlban megkeresi név alapján a sajtot, és találat esetén egy Cheese objektumként adja vissza.
        Készíts az elkészült CheeseManager osztály metódusaihoz teszteket!
*/

package iofilestest.cheese;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CheeseManager {

    public void saveToFile(Path path, List<Cheese> cheeseList) {
        try (DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            for (Cheese cheese : cheeseList) {
                outputStream.writeUTF(cheese.name());
                outputStream.writeDouble(cheese.lactoseContent());
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not write file", ioException);
        }
    }

    public Cheese findCheese(Path path, String name) {
        try (DataInputStream inputStream = new DataInputStream(new BufferedInputStream(Files.newInputStream(path)))) {
            return getCheeseByName(name, inputStream);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private static Cheese getCheeseByName(String name, DataInputStream inputStream) {
        while (true) {
            try {
                String cheeseName = inputStream.readUTF();
                double lactoseContent = inputStream.readDouble();
                if (cheeseName.equals(name)) return new Cheese(cheeseName, lactoseContent);
            } catch (Exception e) {
                throw new IllegalArgumentException("Wrong name", e);
            }
        }
    }
}
