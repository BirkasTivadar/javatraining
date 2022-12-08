package ioreadstring.names;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private final Path path;

    private final List<Human> humans = new ArrayList<>();

    public FileManager(String path) {
        this.path = Path.of(path);
    }

    public List<Human> getHumans() {
        return new ArrayList<>(humans);
    }

    public Path getMyFile() {
        return path;
    }

    public void readFromFile() {
        try {
            List<String> names = Files.readAllLines(path);
            names.forEach(n -> humans.add(new Human(n.split(" ")[0], n.split(" ")[1])));
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read file.", ioException);
        }
    }
}
