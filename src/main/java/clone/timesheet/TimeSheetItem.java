/*
Munkaidő kimutatás
        A timesheet.TimeSheetItem osztály tartalmazza, hogy egy alkalmazott mikor, min dolgozott. Van egy String employee, String project, LocalDateTime from és egy LocalDateTime to attribútuma.
        Legyen egy konstruktora, mely ezekkel az adatokkal inicializálja! Azonban legyen egy copy konstruktora is, mely paraméterül kap egy TimeSheetItem példányt, és annak adatait átmásolja az új példányba!
        Legyen egy copyWithDifferentEmployee(TimeSheetItem timeSheetItem, String newEmployee metódusa is, mely lemásolja a paraméterként átadott bejegyzést, az alkalmazott nevét kicseréli a második paraméterként kapottra, de a többi attribútumot érintetlenül hagyja! Ez a metódus hívja a copy konstruktort!
*/

package clone.timesheet;

import java.time.LocalDateTime;

public class TimeSheetItem {

    private String employee;
    private final String project;
    private final LocalDateTime from;
    private final LocalDateTime to;

    public TimeSheetItem(String employee, String project, LocalDateTime from, LocalDateTime to) {
        this.employee = employee;
        this.project = project;
        this.from = from;
        this.to = to;
    }

    public TimeSheetItem(TimeSheetItem timeSheetItem) {
        employee = timeSheetItem.employee;
        project = timeSheetItem.project;
        from = timeSheetItem.from;
        to = timeSheetItem.to;
    }

    public TimeSheetItem copyWithDifferentEmployee(TimeSheetItem timeSheetItem, String newEmployee) {
        TimeSheetItem result = new TimeSheetItem(timeSheetItem);
        result.employee = newEmployee;
        return result;
    }

    public String getEmployee() {
        return employee;
    }

    public String getProject() {
        return project;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

}
