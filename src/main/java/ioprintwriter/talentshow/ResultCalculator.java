/*
Szavazatszámlálás
        Ebben a feladatban egy tehetségkutató showt fogunk szimulálni. A feladat kicsit összetettebb. A talents.txt tartalmazza az indulók listáját, míg a votes.txt a leadott szavazatokat, azaz az előadó kódját.
        A te feladatod, hogy készíts egy kimutatást egy fájlba. A fájlnak tartalmaznia a kódot az előadás nevét illetve, hogy az adott előadás hány szavazatot kapott! Ezen felül az utolsó sornak tartalmaznia kell a győztes nevét a következő formátumban: Winner: győztes neve.
        A megoldáshoz használj nyugodtan private metódusokat.
*/

package ioprintwriter.talentshow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ResultCalculator {

    private final List<Production> productions = new ArrayList<>();

    private final List<Vote> votes = new ArrayList<>();

    public List<Production> getProductions() {
        return new ArrayList<>(productions);
    }

    public List<Vote> getVotes() {
        return new ArrayList<>(votes);
    }

    public void readTalents(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] talentArr = line.split(" ");
                productions.add(new Production(Integer.parseInt(talentArr[0]), talentArr[1]));
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read file", ioException);
        }
    }

    public void calculateVotes(Path file) {
        loadVotes();
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (Vote vote : votes) {
                    if (vote.getId() == Integer.parseInt(line)) vote.incNum();
                }
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read file", ioException);
        }
    }

    private void loadVotes() {
        int size = productions.size();
        for (int i = 1; i <= size; i++) {
            votes.add(new Vote(i, 0));
        }
    }

    public void writeResultToFile(Path file) {
        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            writeFile(writer);
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not write file", ioException);
        }
    }

    private void writeFile(BufferedWriter writer) throws IOException {
        int size = productions.size();
        int maxVotes = 0;
        String winner = "";
        for (int i = 0; i < size; i++) {
            String line = String.format("%d %s %d", i + 1, productions.get(i).name(), votes.get(i).getNumber());
            writer.write(line);
            writer.newLine();
            if (votes.get(i).getNumber() > maxVotes) {
                winner = productions.get(i).name();
                maxVotes = votes.get(i).getNumber();
            }
        }
        writer.write(String.format("Winner: %s", winner));
    }
}
