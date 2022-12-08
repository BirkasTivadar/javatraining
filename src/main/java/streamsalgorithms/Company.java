/*
Hozz létre egy Employee osztályt, melynek két attribútuma legyen, az alkalmazott neve és születési éve! Majd az osztály main() metódusában készíts egy néhány elemet tartalmazó listát az alkalmazottakból, és írd meg a következőket:
        Összegezd az alkalmazottak születési éveit!
        Összegezd az alkalmazottak életkorát!
        Add vissza streammel, hány alkalmazott van a listában!
        Add vissza, hány alkalmazott született 1990-nél korábban!
        Add vissza a legkorábban született alkalmazott születési évét!
        Add vissza a legkorábban született alkalmazott nevét! (Itt szükség lesz a findFirst() záróműveletre.)
        Add vissza, hogy igaz-e, hogy minden alkalmazott 1980 előtt született-e?
        Add vissza egy listában az összes, 1990-nél korábban született alkalmazottat!
        Add vissza egy listában az összes alkalmazott nevét!
        Az előző két feladat kombinációja: Add vissza egy listában az összes, 1990-nél korábban született alkalmazott nevét!
*/

package streamsalgorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Company {

    private final List<Employee> employees = new ArrayList<>();

    public void addEmployees(Employee employee) {
        employees.add(employee);
    }

    public int sumYearsOfBirths() {
        return employees.stream()
                .mapToInt(Employee::yearOfBirth)
                .sum();
    }

    public int sumAges(int actualYear) {
        return employees.stream()
                .mapToInt(e -> actualYear - e.yearOfBirth())
                .sum();
    }

    public long numberOfEmployees() {
        return employees.stream().count();
    }

    public long numberOfEmployeesBirthBefore(int maxYearOfBirth) {
        return employees.stream()
                .filter(e -> e.yearOfBirth() < maxYearOfBirth)
                .count();
    }

    public int earliestBirthOfYear() {
        return employees.stream()
                .mapToInt(Employee::yearOfBirth)
                .min()
                .getAsInt();
    }

    public Optional<String> nameOfEarliestBirthOfYear() {
        return employees.stream()
                .min(Comparator.comparing(Employee::yearOfBirth)).
                map(Employee::name);
    }

    public boolean isAllEmployeeBirtBefore(int maxYear) {
        return employees.stream()
                .allMatch(e -> e.yearOfBirth() < maxYear);
    }

    public List<Employee> EmployeesBeforeBirth(int year) {
        return employees.stream()
                .filter(e -> e.yearOfBirth() < year)
                .toList();
    }

    public List<String> names() {
        return employees.stream()
                .map(Employee::name)
                .toList();
    }

    public List<String> namesOfEmployeesBeforeBirth(int year) {
        return employees.stream()
                .filter(e -> e.yearOfBirth() < year)
                .map(Employee::name)
                .toList();
    }
}
