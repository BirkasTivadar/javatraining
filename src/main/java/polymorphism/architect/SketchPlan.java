/*
A SketchPlan osztály a Plan leszármazottja legyen és valósítsa meg annak absztrakt metódusát (adja vissza az attribútum értékét)! Ezenkívül tartalmazzon egy újabb attribútumot: protected String title, melynek értékét a konstruktora állítsa be, valamint legyen hozzá getter metódus is!
*/

package polymorphism.architect;

public class SketchPlan extends Plan {

    protected String title;

    public SketchPlan(int pagesOfDocumentation, String title) {
        super(pagesOfDocumentation);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
