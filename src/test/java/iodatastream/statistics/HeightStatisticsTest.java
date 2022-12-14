package iodatastream.statistics;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class HeightStatisticsTest {

   @TempDir
   public File folder;

    @Test
    void testSaveHeights() throws IOException {
        File file = new File(folder,"test.txt");
        Path path = file.toPath();
        HeightStatistics statistics = new HeightStatistics();

        List<Integer> heights = List.of(198, 201, 211, 195, 214, 208, 203, 198);
        statistics.saveHeights(heights, path);

        byte[] original = Objects.requireNonNull(this.getClass().getResourceAsStream("/statistics.dat")).readAllBytes();
        byte[] saved = Files.readAllBytes(path);

        assertArrayEquals(original, saved);
    }
}
