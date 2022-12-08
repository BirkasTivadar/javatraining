/*
Postás
        A Postman osztályban legyen egy String lista, mely a címeket tartalmazza, ahová valamilyen küldeményt kézbesíteni kell! Legyen a listához getter és addAddress(String address) metódus is! Egy cím többször is előfordulhat a listában, de a postás igyekszik nagyjából a lista sorrendjében haladni a kézbesítéssel. Ezért írj egy removeAddress() metódust, amelyet akkor lehet használni, ha egy küldemény kézbesítve lett: a metódus megkap paraméterül egy címet majd törli azt a listából annak legelső előfordulását!
*/

package collectionslist;

import java.util.ArrayList;
import java.util.List;

public class Postman {

    private final List<String> addresses = new ArrayList<>();

    public List<String> getAddresses() {
        return new ArrayList<>(addresses);
    }

    public void addAddress(String address) {
        addresses.add(address);
    }

    public void removeAddress(String address) {
        int index = addresses.indexOf(address);
        if (index > -1) addresses.remove(index);
    }
}
