/*
Nyelvtan
    A grammar csomagban hozd létre az alábbi osztályokat:
        A Verb (ige) absztrakt osztály legyen egy protected String word attribútummal, az ehhez tartozó (nem absztrakt) getter metódussal és egy konstruktorral, amely beállítja a word értékét!
        A Preposition (igekötő) egy interfész legyen, benne két absztrakt metódus: String getPreposition() és String getWholeWord()!
        A PhrasalVerb (igekötős ige) egy osztály legyen, amely a Verb osztály leszármazottja, és implementálja a Preposition interfészt! Tartalmazzon egy protected String preposition attribútumot és egy konstruktort, amely beállítja az attribútum értékét! Az interfésztől kapott getPreposition() metódus csak adja vissza az attribútum értékét, a getWholeWord() metódus viszont fűzze össze az igekötőt az igével (a magyar nyelvtani szabályok szerint), és az így kapott szót adja vissza!
        A Suffix (toldalék) egy interfész legyen, amelyben összesen egy absztrakt metódus található: String getSuffix()!
        A PhrasalVerbWithSuffix egy osztály legyen, amely a PhrasalVerb leszármazottja és implementálja a Suffix interfészt! Legyen benne egy private String suffix attribútum! Az interfésztől kapott getSuffix() metódus csak adja vissza az attribútum értékét! Írd felül a getWholeWord() metódust, amely most már fűzze hozzá az igekötős igéhez a megadott toldalékot is!
    A Grammar osztály main() metódusában hozz létre változókat a következő módokon:
        Verb statikus típussal és PhrasalVerb dinamikus típussal.
        Verb statikus típussal és PhrasalVerbWithSuffix dinamikus típussal.
        Preposition statikus típussal és PhrasalVerb dinamikus típussal.
        Preposition statikus típussal és PhrasalVerbWithSuffix dinamikus típussal.
        PhrasalVerb statikus típussal és PhrasalVerb dinamikus típussal.
        PhrasalVerb statikus típussal és PhrasalVerbWithSuffix dinamikus típussal.
        Suffix statikus típussal és PhrasalVerbWithSuffix dinamikus típussal.
        PhrasalVerbWithSuffix statikus típussal és PhrasalVerbWithSuffix dinamikus típussal.
    Végül mindegyik létrehozott változón hívj meg minden, az adott változó számára elérhető metódust (a változó statikus típusa határozza meg, hogy milyen metódusokat tud használni), és írd ki a kapott értékeket a konzolra (a változó dinamikus típusa határozza meg, hogy milyen értékeket adjanak vissza ezek a metódusok)!
*/

package virtualmethod.grammar;

public class Grammar {

    public static void main(String[] args) {
        Verb verbPhrasalVerb = new PhrasalVerb("jön", "el");
        Verb verbPhrasalVerbWithSuffix = new PhrasalVerbWithSuffix("jön", "el", "nek");

        Preposition prepositionPhrasalVerb = new PhrasalVerb("jön", "el");
        Preposition prepositionPhrasalVerbWithSuffix = new PhrasalVerbWithSuffix("jön", "el", "nek");

        PhrasalVerb phrasalVerb = new PhrasalVerb("jön", "el");
        PhrasalVerb phrasalVerbPhrasalVerbWithSuffix = new PhrasalVerbWithSuffix("jön", "el", "nek");

        Suffix suffixPhrasalVerbWithSuffix = new PhrasalVerbWithSuffix("jön", "el", "nek");

        PhrasalVerbWithSuffix phrasalVerbWithSuffix = new PhrasalVerbWithSuffix("jön", "el", "nek");

        System.out.println("VERB:");
        System.out.println(verbPhrasalVerb.getWord());
        System.out.println(verbPhrasalVerbWithSuffix.getWord());

        System.out.println("\nPREPOSITION:");
        System.out.println(prepositionPhrasalVerb.getPreposition());
        System.out.println(prepositionPhrasalVerb.getWholeWord());
        System.out.println(prepositionPhrasalVerbWithSuffix.getPreposition());
        System.out.println(prepositionPhrasalVerbWithSuffix.getWholeWord());

        System.out.println("\nPHRASALVERB:");
        System.out.println(phrasalVerb.getPreposition());
        System.out.println(phrasalVerb.getWord());
        System.out.println(phrasalVerb.getWholeWord());
        System.out.println(phrasalVerbPhrasalVerbWithSuffix.getPreposition());
        System.out.println(phrasalVerbPhrasalVerbWithSuffix.getWord());
        System.out.println(phrasalVerbPhrasalVerbWithSuffix.getWholeWord());

        System.out.println("\nSUFFIX:");
        System.out.println(suffixPhrasalVerbWithSuffix.getSuffix());

        System.out.println("\nPHRASALVERBWITHSUFFIX:");
        System.out.println(phrasalVerbWithSuffix.getPreposition());
        System.out.println(phrasalVerbWithSuffix.getWord());
        System.out.println(phrasalVerbWithSuffix.getSuffix());
        System.out.println(phrasalVerbWithSuffix.getWholeWord());


    }
}
