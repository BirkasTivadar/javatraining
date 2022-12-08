/*
Bevásárlólista
        Az ioconvert.shopping csomagba készíts egy ShoppingListManager osztályt! A saveShoppingList() metódusa a paraméterül kapott OutputStream-re kiírja a szintén paraméterül kapott List<String> tartalmát szövegként, minden elemet külön sorba. A loadShoppingList() metódusa a paraméterül kapott Inputstream-ből beolvassa a bevásárlólista tartalmát, amit szöveglistaként ad vissza.
*/

package ioconvert.shopping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListManager {
    public void saveShoppingList(OutputStream os, List<String> shoppingList) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os))) {
            for (String product : shoppingList) {
                writer.write(product);
                writer.newLine();
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not write file", ioException);
        }
    }

    public List<String> loadShoppingList(InputStream is) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            List<String> result = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
            return result;
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read file", ioException);
        }
    }
}
