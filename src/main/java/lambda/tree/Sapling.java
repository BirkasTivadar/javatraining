/*
Hozz létre egy Sapling (facsemete) nevű osztályt, amelynek attribútumai a következők legyenek: String species, int height (centiméterben vett magasság!
*/

package lambda.tree;

public class Sapling {

    private final String species;
    private int height;

    public Sapling(String species, int height) {
        this.species = species;
        this.height = height;
    }

    public void cut(int maxHeight) {
        if (height > maxHeight) setHeight(maxHeight);
    }

    public String getSpecies() {
        return species;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
