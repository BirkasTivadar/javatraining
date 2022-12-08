/*
A PhrasalVerbWithSuffix egy osztály legyen, amely a PhrasalVerb leszármazottja és implementálja a Suffix interfészt! Legyen benne egy private String suffix attribútum! Az interfésztől kapott getSuffix() metódus csak adja vissza az attribútum értékét! Írd felül a getWholeWord() metódust, amely most már fűzze hozzá az igekötős igéhez a megadott toldalékot is!
*/

package virtualmethod.grammar;

public class PhrasalVerbWithSuffix extends PhrasalVerb implements Suffix {

    private String suffix;

    public PhrasalVerbWithSuffix(String word, String preposition, String suffix) {
        super(word, preposition);
        this.suffix = suffix;
    }

    @Override
    public String getSuffix() {
        return suffix;
    }

    @Override
    public String getWholeWord() {
        return super.getWholeWord().concat(suffix);
    }
}
