package streamsalgorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    Company company = new Company();
    int actualYear = 2022;

    @BeforeEach
    void init() {
        company.addEmployees(new Employee("Jane Doe", 1995));
        company.addEmployees(new Employee("John Doe", 1980));
        company.addEmployees(new Employee("Jack Doe", 2003));
    }

    @Test
    void testSumYearsOfBirths() {
        assertEquals(5978, company.sumYearsOfBirths());
    }

    @Test
    void testSumAges() {
        assertEquals(88, company.sumAges(actualYear));

    }

    @Test
    void ntestNumberOfEmployees() {
        assertEquals(3, company.numberOfEmployees());
    }

    @Test
    void testNumberOfEmployeesBirthBefore() {
        assertEquals(1, company.numberOfEmployeesBirthBefore(1990));
        assertEquals(2, company.numberOfEmployeesBirthBefore(2000));
    }

    @Test
    void testEarliestBirthOfYear() {
        assertEquals(1980, company.earliestBirthOfYear());
    }

    @Test
    void testNameOfEarliestBirthOfYear() {
        assertEquals("John Doe", company.nameOfEarliestBirthOfYear().get());
    }

    @Test
    void testIsAllEmployeeBirtBefore() {
        assertTrue(company.isAllEmployeeBirtBefore(2010));
        assertFalse(company.isAllEmployeeBirtBefore(2000));
    }

    @Test
    void testEmployeesBirthBefore() {
        assertEquals(2, company.EmployeesBeforeBirth(2000).size());
        assertEquals(1, company.EmployeesBeforeBirth(1990).size());
    }

    @Test
    void names() {
        assertEquals(3, company.names().size());
        assertTrue(company.names().contains("John Doe"));
    }

    @Test
    void namesOfEmployeesBeforeBirth() {
        assertEquals(2, company.namesOfEmployeesBeforeBirth(2000).size());
        assertTrue(company.namesOfEmployeesBeforeBirth(2000).contains("Jane Doe"));
    }
}