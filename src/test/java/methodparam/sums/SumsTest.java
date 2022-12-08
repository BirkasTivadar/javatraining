package methodparam.sums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumsTest {

    @Test
    void testCreate() {
        Sums sums = new Sums(67.2, -52.3);

        assertEquals(67.2, sums.sumPositives(), 0.00001);
        assertEquals(-52.3, sums.sumNegatives(), 0.00001);
    }
}