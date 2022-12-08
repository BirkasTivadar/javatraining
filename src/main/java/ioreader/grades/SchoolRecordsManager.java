/*
Készíts egy SchoolRecordsManager osztályt, ami beolvassa fájlból az adatokat, eltárolja, és ezen felül még képes egy osztályátlag számítására is!
*/

package ioreader.grades;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SchoolRecordsManager {

    private final List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }


    public void readGradesFromFile(String file) {
        Path path = Path.of("src", "main", "resources", file);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            createAndAddStudentForFile(reader);
        } catch (IOException ioException) {
            throw new IllegalStateException("Can't read file!", ioException);
        }
    }

    private void createAndAddStudentForFile(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] studentArr = line.split(" ");
            String name = studentArr[0];
            List<Integer> gradelist = Arrays.stream(studentArr)
                    .skip(1)
                    .map(Integer::parseInt)
                    .toList();
            students.add(new Student(name, gradelist));
        }
    }

    public double classAverage() {
        return students.stream()
                .mapToDouble(Student::average)
                .average()
                .orElse(0);
    }
}
