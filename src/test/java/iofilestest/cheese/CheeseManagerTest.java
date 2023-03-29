package iofilestest.cheese;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CheeseManagerTest {

    @TempDir
    public File folder;

    Path path;

    Cheese manchego = new Cheese("Manchego", 2.66);
    Cheese trappista = new Cheese("Trappista", 1.58);
    Cheese mackosajt = new Cheese("Mackósajt", 3.23);

    CheeseManager cheeseManager = new CheeseManager();

    List<Cheese> cheeseList = new ArrayList<>();

    @BeforeEach
    public void init() {
        File file = new File(folder, "test.txt");
        path = file.toPath();
        cheeseList.add(manchego);
        cheeseList.add(trappista);
        cheeseList.add(mackosajt);
    }

    @Test
    void testSaveToFileAndFind() throws IOException {
        cheeseManager.saveToFile(path, cheeseList);
        Cheese testCheese = cheeseManager.findCheese(path, "Trappista");
        assertEquals("Trappista: 1,58", testCheese.toString());

        IllegalArgumentException ioe = assertThrows(IllegalArgumentException.class, () -> {
            cheeseManager.findCheese(path, "Edami");
        });
        assertEquals("Wrong name", ioe.getMessage());
    }
}