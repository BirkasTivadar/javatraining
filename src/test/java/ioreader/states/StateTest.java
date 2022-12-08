package ioreader.states;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StateTest {

    private final State state = new State("Wyoming", "Cheyenne");

    @Test
    void createState() {
        assertEquals("Wyoming", state.stateName());
        assertEquals("Cheyenne", state.capital());
    }

}
