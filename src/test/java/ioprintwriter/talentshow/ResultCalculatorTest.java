package ioprintwriter.talentshow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ResultCalculatorTest {

    @TempDir
    public File folder;

    private final ResultCalculator resultCalculator = new ResultCalculator();

    private Path talentsFile;

    private Path votesFile;

    @BeforeEach
    public void initFiles() throws IOException {
        talentsFile = new File(folder, "test.txt").toPath();
        Files.copy(Objects.requireNonNull(ResultCalculatorTest.class.getResourceAsStream("talents.txt")), talentsFile, StandardCopyOption.REPLACE_EXISTING);

        votesFile = new File(folder, "test2.txt").toPath();
        Files.copy(Objects.requireNonNull(ResultCalculatorTest.class.getResourceAsStream("votes.txt")), votesFile, StandardCopyOption.REPLACE_EXISTING);

    }

    @Test
    void readProductionsTest() {
        resultCalculator.readTalents(talentsFile);

        assertEquals(12, resultCalculator.getProductions().size());
        assertEquals(6, resultCalculator.getProductions().get(5).id());
        assertEquals("Magician", resultCalculator.getProductions().get(5).name());
    }

    @Test
    void calculateVotesTest() {
        resultCalculator.readTalents(talentsFile);
        resultCalculator.calculateVotes(votesFile);
        int testNum = 0;

        for (Vote v : resultCalculator.getVotes()) {
            if (v.getId() == 10) {
                testNum = v.getNumber();
            }
        }

        assertEquals(4, testNum);
    }

    @Test
    void writeResultToFileTest() throws IOException {
        resultCalculator.readTalents(talentsFile);
        resultCalculator.calculateVotes(votesFile);

        Path resultFile = new File(folder, "test3.txt").toPath();

       resultCalculator.writeResultToFile(resultFile);
        List<String> results = Files.readAllLines(resultFile);
        assertTrue(results.contains("9 Singer 6"));

        assertEquals("Winner: Actors_From_Shadow", results.get(results.size() - 1));
    }
}
