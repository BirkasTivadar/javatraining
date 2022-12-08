/*
A PhrasalVerb (igekötős ige) egy osztály legyen, amely a Verb osztály leszármazottja, és implementálja a Preposition interfészt! Tartalmazzon egy protected String preposition attribútumot és egy konstruktort, amely beállítja az attribútum értékét! Az interfésztől kapott getPreposition() metódus csak adja vissza az attribútum értékét, a getWholeWord() metódus viszont fűzze össze az igekötőt az igével (a magyar nyelvtani szabályok szerint), és az így kapott szót adja vissza!
*/

package virtualmethod.grammar;

public class PhrasalVerb extends Verb implements Preposition {

    protected String preposition;

    public PhrasalVerb(String word, String preposition) {
        super(word);
        this.preposition = preposition;
    }

    @Override
    public String getPreposition() {
        return preposition;
    }

    @Override
    public String getWholeWord() {
        return preposition.concat(word);
    }
}
