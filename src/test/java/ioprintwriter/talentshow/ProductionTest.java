package ioprintwriter.talentshow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductionTest {

    private final Production production = new Production(1, "The_Artist");

    @Test
    void createProduction() {
        assertEquals(1, production.id());
        assertEquals("The_Artist", production.name());
    }
}
