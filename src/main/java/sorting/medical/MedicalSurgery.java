/*
Orvosi rendelés
        Készíts egy Patient osztályt, amelynek három attribútuma van: a páciens neve és TAJ-száma, valamint a foglalt időpontja! Legyen egy PatientComparator osztályod is, amely Comparator segédosztályként összehasonlíthatóvá teszi a pácienseket az időpontjuk alapján! Majd készíts egy MedicalSurgery osztályt, amely konstruktorban megkapja az aznapra időponttal rendelkező pácienseket tartalmazó listát, és a List<Patient> getPatientsInTimeOrder() metódusa pedig visszaadja az időpont szerint sorbarendezett pácienseket! Vigyázz, hogy az eredeti lista sorrendje ne változzon!
*/

package sorting.medical;

import java.util.ArrayList;
import java.util.List;

public class MedicalSurgery {

    private final List<Patient> patients;

    public MedicalSurgery(List<Patient> patients) {
        this.patients = new ArrayList<>(patients);
    }

    public List<Patient> getPatientsInTimeOrder() {
        patients.sort(new PatientComparator());
        return patients;
    }
}
