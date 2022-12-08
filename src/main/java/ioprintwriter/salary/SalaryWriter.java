/*
Fizetések
        Ebben a feladatban emberek fizetését kell meghatároznod titulus alapján. A SalaryWriter osztály konstruktorban kap egy név listát. A writeNamesAndSalaries(Path file) metódus kiírja a fájlba név: összeg formátumban. A fizetések a következő képpen alakulnak:
        Ha tartalmazza a név a "Dr" előtagot, akkor 500000
        Ha a "Mr" vagy "Mrs" előtagot akkor 200000
        Különben 100000
*/

package ioprintwriter.salary;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SalaryWriter {

    List<String> names;

    public SalaryWriter(List<String> names) {
        this.names = new ArrayList<>(names);
    }

    public void writeNamesAndSalaries(Path file) {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file))) {
            for (String name : names) {
                writer.print(String.format("%s: ", name));
                if (name.startsWith("Dr")) writer.println(500000);
                else if (name.startsWith("Mr") || name.startsWith("Mrs")) writer.println(200000);
                else writer.println(100000);
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not write file", ioException);
        }
    }
}
