package ioreadstring.names;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HumanTest {

    private final Human human = new Human("John", "Doe");

    @Test
    void createHumanTest() {
        assertEquals("John", human.firstName());
        assertEquals("Doe", human.lastName());
    }

}
