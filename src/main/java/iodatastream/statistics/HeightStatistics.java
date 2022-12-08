/*
Számok
Az iodatastream.statistics csomagba készíts egy HeightStatistics osztályt, bele pedig egy saveHeights() metódust. A metódus egy kosárcsapat tagjainak testmagasságát kapja meg List<Integer> típusú paraméterben. A paraméterben kapott Path objektumként reprezentált fájlba menti először a lista méretét, majd egyenként a lista elemeit.

*/

package iodatastream.statistics;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HeightStatistics {
    public void saveHeights(List<Integer> heights, Path path) {
        try (DataOutputStream outputStream = new DataOutputStream(
                new BufferedOutputStream(Files.newOutputStream(path)))) {
            outputStream.writeInt(heights.size());
            for (int height : heights) {
                outputStream.writeInt(height);
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not write file", ioException);
        }
    }
}
