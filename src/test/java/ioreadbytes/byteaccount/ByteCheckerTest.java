package ioreadbytes.byteaccount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ByteCheckerTest {

    ByteChecker byteChecker = new ByteChecker();

    @Test
    void readBytesAndFindAsTest() {
        assertEquals(116, byteChecker.readBytesAndFindAs("data.dat"));
    }
}
