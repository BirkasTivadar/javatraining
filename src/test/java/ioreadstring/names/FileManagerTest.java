package ioreadstring.names;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileManagerTest {


    private final FileManager fm = new FileManager("src/test/resources/names.txt");

    @Test
    void createClassTest() {
        assertEquals("names.txt", fm.getMyFile().getFileName().toString());
        assertEquals(0, fm.getHumans().size());
    }


    @Test
    void readFromFileTest() {
        fm.readFromFile();
        assertEquals(5, fm.getHumans().size());
        assertEquals("Jane", fm.getHumans().get(1).firstName());
    }

}
