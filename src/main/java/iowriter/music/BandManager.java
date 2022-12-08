package iowriter.music;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BandManager {

    private final List<Band> bands = new ArrayList<>();

    public void writeBandsBefore(Path file, int year) {
        List<Band> bandsFoundedBeforeYear = getBandsFoundedBeforeYear(year);
        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            for (Band band : bandsFoundedBeforeYear) {
                writer.write(String.format("%s;%d", band.name(), band.year()));
                writer.newLine();
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not write file", ioException);
        }
    }

    private List<Band> getBandsFoundedBeforeYear(int year) {
        return bands.stream()
                .filter(b -> b.year() < year)
                .toList();
    }

    public void readBandsFromFile(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] bandArr = line.split(";");
                bands.add(new Band(bandArr[0], Integer.parseInt(bandArr[1])));
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read file", ioException);
        }

    }
}


