/*
A Verb (ige) absztrakt osztály legyen egy protected String word attribútummal, az ehhez tartozó (nem absztrakt) getter metódussal és egy konstruktorral, amely beállítja a word értékét!
*/

package virtualmethod.grammar;

public abstract class Verb {

    protected String word;

    public Verb(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}
