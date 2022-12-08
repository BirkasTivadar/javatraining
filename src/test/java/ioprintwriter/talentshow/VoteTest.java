package ioprintwriter.talentshow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VoteTest {

    private final Vote vote = new Vote(1, 10);

    @Test
    void createVote() {
        assertEquals(1, vote.getId());
        assertEquals(10, vote.getNumber());
    }

    @Test
    void incNumberTest() {
        assertEquals(10, vote.getNumber());
        vote.incNum();
        assertEquals(11, vote.getNumber());
    }
}
