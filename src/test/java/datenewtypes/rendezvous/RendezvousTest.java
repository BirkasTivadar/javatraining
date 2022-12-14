package datenewtypes.rendezvous;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RendezvousTest {


    @Test
    void emptyPatternShouldThrowException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Rendezvous("10:20", ""));
        assertEquals("Empty pattern string!", ex.getMessage());
    }

    @Test
    void emptyTimeStringShouldThrowException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Rendezvous("", "hh:mm"));
        assertEquals("Illegal time string: ", ex.getMessage());
    }

    @Test
    void illegalTimeStringShouldThrowException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Rendezvous("10:20:20", "hh:mm"));
        assertEquals("Illegal time string: 10:20:20", ex.getMessage());
    }

    @Test
    void testToString() {
        // Given
        Rendezvous rendezvous = new Rendezvous(21, 30);
        //Then
        assertEquals("21-30", rendezvous.toString("HH-mm"));
    }

    @Test
    void emptyPatternInToStringMethodShouldThrowException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Rendezvous("10:20", "HH:mm").toString("\t"));
        assertEquals("Empty pattern string!", ex.getMessage());
    }

    @Test
    void testCountMinutesLeft() {
        // Given
        LocalTime base = LocalTime.of(20, 30);
        Rendezvous rendezvous = new Rendezvous(22, 0);
        //Then
        assertEquals(90, rendezvous.countMinutesLeft(base));
    }

    @Test
    void tooLateToGoShouldThrowException() {
        LocalTime now = LocalTime.of(15, 0);
        Exception ex = assertThrows(MissedOpportunityException.class, () -> new Rendezvous(10, 30).countMinutesLeft(now));
        assertEquals("Too late!", ex.getMessage());
    }

    @Test
    void testPushLater() {
        // Given
        Rendezvous rendezvous = new Rendezvous(22, 0);
        //When
        rendezvous.pushLater(0, 90);
        //Then
        assertEquals("23:30", rendezvous.toString("HH:mm"));
    }

    @Test
    void testPullEarlier() {
        // Given
        Rendezvous rendezvous = new Rendezvous(22, 0);
        //When
        rendezvous.pullEarlier(1, 15);
        //Then
        assertEquals("20:45", rendezvous.toString("HH:mm"));
    }
}
