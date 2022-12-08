/*
Legyen egy PatientComparator osztályod is, amely Comparator segédosztályként összehasonlíthatóvá teszi a pácienseket az időpontjuk alapján!
*/

package sorting.medical;

import java.util.Comparator;

public class PatientComparator implements Comparator<Patient> {

    @Override
    public int compare(Patient o1, Patient o2) {
        return o1.getTime().compareTo(o2.getTime());
    }
}
