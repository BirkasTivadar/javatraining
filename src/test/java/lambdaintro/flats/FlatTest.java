package lambdaintro.flats;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlatTest {

    @Test
    void testCreate() {
        Flat flat = new Flat("Budapest, Fő utca 3.", 35.6, 45_000_000);

        assertEquals("Budapest, Fő utca 3.", flat.address());
        assertEquals(35.6, flat.area());
        assertEquals(45_000_000, flat.price());
    }
}