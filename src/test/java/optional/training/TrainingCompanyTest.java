package optional.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrainingCompanyTest {

    TrainingCompany company;

    @BeforeEach
    void init() {
        List<Course> courses = Arrays.asList(
                new Course("Kertészkedés", Level.ADVANCED, 78000),
                new Course("Fodrász", Level.BEGINNER, 153000),
                new Course("Angol nyelvtanfolyam", Level.BEGINNER, 35000),
                new Course("Biztonsági őr", Level.ADVANCED, 145000),
                new Course("Bér- és TB ügyintéző", Level.BEGINNER, 86000)
        );
        company = new TrainingCompany(courses);
    }

    @Test
    void testGetCheaperCourse() {
        Course expected = company.getCheaperCourse(70000);

        assertEquals("Angol nyelvtanfolyam", expected.name());
        assertEquals(35000, expected.price());
    }

    @Test
    void testGetCheaperCourseNoSuchCourse() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> company.getCheaperCourse(100));
        assertEquals("No such course.", ex.getMessage());
    }

    @Test
    void testGetPriceOfCourseWithGivenNameAndLevel() {
        assertEquals(145000, company.getPriceOfCourseWithGivenNameAndLevel("Biztonsági őr", Level.ADVANCED));
    }

    @Test
    void testGetPriceOfCourseWithGivenNameAndLevelNoSuchCourse() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> company.getPriceOfCourseWithGivenNameAndLevel("Titkárnő", Level.BEGINNER));
        assertEquals("No such course.", ex.getMessage());
    }

    @Test
    void testGetNameOfCourseWithGivenLevel() {
        assertTrue(List.of("Fodrász", "Angol nyelvtanfolyam", "Bér- és TB ügyintéző").contains(company.getNameOfCourseWithGivenLevel(Level.BEGINNER)));
    }

    @Test
    void testGetNameOfCourseWithGivenLevelNoCourseFound() {
        assertEquals("Sorry, there is no course at this level.", company.getNameOfCourseWithGivenLevel(Level.EXPERT));
    }
}