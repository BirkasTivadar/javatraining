package lambdaoptional.costume;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CostumeTest {

    @Test
    void testCreate() {
        Costume costume = new Costume("tűzokádó sárkány jelmez", Size.S, 2500);

        assertEquals("tűzokádó sárkány jelmez", costume.description());
        assertEquals(Size.S, costume.size());
        assertEquals(2500, costume.price());
    }
}