package iofilestest.cheese;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheeseTest {

    @Test
    void testCheese() {
        Cheese cheese = new Cheese("Manchego", 2.66);

        assertEquals("Manchego", cheese.name());
        assertEquals(2.66, cheese.lactoseContent());
    }
}