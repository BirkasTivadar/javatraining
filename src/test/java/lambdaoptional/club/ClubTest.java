package lambdaoptional.club;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ClubTest {

    @Test
    void testCreateMember() {
        Member member = new Member("John Doe", Arrays.asList("Java", "OOP"), Gender.MALE);

        assertEquals("John Doe", member.name());
        assertEquals(Arrays.asList("Java", "OOP"), member.skills());
        assertEquals(Gender.MALE, member.gender());
    }

    @Test
    void testFindFirst() {
        Club club = new Club(Arrays.asList(
                new Member("John Doe", Arrays.asList("Java", "OOP"), Gender.MALE),
                new Member("Jane Doe", Arrays.asList(".NET", "OOP"), Gender.FEMALE),
                new Member("James Doe", Arrays.asList("Python", "Java", "OOP"), Gender.MALE),
                new Member("Janet Doe", Arrays.asList("JavaScript", "scripting"), Gender.MALE)
        ));

        assertFalse(club.findFirst(m -> m.name().equals("Joe")).isPresent());
        assertTrue(club.findFirst(m -> m.name().equals("John Doe")).isPresent());
        Optional<Member> optMember = club.findFirst(m -> m.name().equals("John Doe"));

        Member member = optMember.orElse(null);
        assert member != null;

        assertEquals("John Doe", member.name());
    }

    @Test
    void testAverage() {
        assertFalse(new Club(Collections.emptyList()).averageNumberOfSkills().isPresent());

        Club club = new Club(Arrays.asList(
                new Member("John Doe", Arrays.asList("Java", "OOP"), Gender.MALE),
                new Member("Jane Doe", Arrays.asList(".NET", "OOP"), Gender.FEMALE),
                new Member("James Doe", Arrays.asList("Python", "Java", "OOP"), Gender.MALE),
                new Member("Janet Doe", Arrays.asList("JavaScript", "scripting"), Gender.MALE)
        ));

        Optional<Double> optDouble = club.averageNumberOfSkills();
        Double result = optDouble.orElse(0.0);

        assertEquals(2.25, result);
    }
}
