package datenewtypes.dailyroutine;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DailyRoutineTest {

    @Test
    void testGetStartWithInt() {
        DailyRoutine time = new DailyRoutine(8, 45);

        assertEquals(time.getStart(), LocalTime.of(8, 45));
    }

    @Test
    void testGetStartWithString() {
        DailyRoutine time = new DailyRoutine("09:10");

        assertEquals(time.getStart(), LocalTime.of(9, 10));
    }

    @Test
    void testSetFutureTime() {
        DailyRoutine time = new DailyRoutine(9, 10);
        time.setFutureTime(100);

        assertEquals(time.getStart(), LocalTime.of(10, 50));
    }

    @Test
    void testIsBeforeNoonTrue() {
        DailyRoutine time = new DailyRoutine(8, 45);
        time.setFutureTime(180);

        assertTrue(time.isBeforeNoon());
    }

    @Test
    void testIsBeforeNoonFalse() {
        DailyRoutine time = new DailyRoutine(9, 15);
        time.setFutureTime(180);

        assertFalse(time.isBeforeNoon());
    }
}