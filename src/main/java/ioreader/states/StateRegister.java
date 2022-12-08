/*
A StateRegister osztály felelős a file beolvasásáért és a State objektumok létrehozásáért, valamint a keresésért. Legyen benne egy lista states , State generikussal, amibe a readStatesfromFile(stringFileName) eltárolja a beolvasott adatokat. A findCapitalByStateName(String stateName) megkeresi a paraméterül kapott állam fővárosát. Ha nincs ilyen állam akkor IllegalArgument exception-t dob!
*/

package ioreader.states;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StateRegister {

    private final List<State> states = new ArrayList<>();

    public List<State> getStates() {
        return new ArrayList<>(states);
    }

    public void readStatesFromFile(String file) {
        Path path = Path.of("src", "main", "resources", file);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] stateArr = line.split("-");
                states.add(new State(stateArr[0], stateArr[1]));
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can't read file!", ioException);
        }
    }

    public String findCapitalByStateName(String stateName) {
        return states.stream()
                .filter(s -> s.stateName().equals(stateName))
                .findAny()
                .map(State::capital)
                .orElseThrow(() -> new IllegalArgumentException("No state with this name!"));
    }
}
