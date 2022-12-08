/*
Építészeti terv
    Az architect csomagban modellezd egy építészeti tervdokumentáció elkészülésének egyes fázisait!
        A Plan egy absztrakt osztály legyen, egyetlen attribútummal: protected int pagesOfDocumentation! Az osztály ezenkívül tartalmazzon egy konstruktort az attribútum értékének beállítására, valamint egy getPagesOfDocumentation() absztrakt metódust!
        A SketchPlan osztály a Plan leszármazottja legyen és valósítsa meg annak absztrakt metódusát (adja vissza az attribútum értékét)! Ezenkívül tartalmazzon egy újabb attribútumot: protected String title, melynek értékét a konstruktora állítsa be, valamint legyen hozzá getter metódus is!
        A Header interfész két absztrakt metódust tartalmazzon: String getNameOfClient() és String getAddressOfBuilding()!
        A PermitPlan osztály a SketchPlan leszármazottja legyen és implementálja a Header interfészt is! Legyen két attribútuma: protected String nameOfClient és protected String addressOfBuilding! Valósítsa meg az interfész két metódusát (adja vissza az attribútumok értékét, amelyet a konstruktor állítson be)! Ezenkívül tartalmazzon egy String getHeader() metódust, amely szövegesen adja vissza a tervdokumentáció címét, az építtető nevét és az építési helyszín címét is!
        Legyen egy ConstructionPlan osztály, amelynek van egy private int sheetsOfConstructionDrawings attribútuma, az osztály konstruktorában beállítva, valamint getter is legyen ehhez az attribútumhoz! Az osztály legyen a PermitPlan leszármazottja!
        Az Architect osztály main() metódusában hozz létre változókat a következő módokon:
            Plan statikus típussal és SketchPlan dinamikus típussal.
            Plan statikus típussal és PermitPlan dinamikus típussal.
            Plan statikus típussal és ConstructionPlan dinamikus típussal.
            SketchPlan statikus típussal és SketchPlan dinamikus típussal.
            SketchPlan statikus típussal és PermitPlan dinamikus típussal.
            SketchPlan statikus típussal és ConstructionPlan dinamikus típussal.
            Header statikus típussal és PermitPlan dinamikus típussal.
            Header statikus típussal és ConstructionPlan dinamikus típussal.
            PermitPlan statikus típussal és PermitPlan dinamikus típussal.
            PermitPlan statikus típussal és ConstructionPlan dinamikus típussal.
            ConstructionPlan statikus típussal és ConstructionPlan dinamikus típussal.
        Végül mindegyik létrehozott változón hívj meg minden, az adott változó számára elérhető metódust (a változó statikus típusa határozza meg, hogy milyen metódusokat tud használni), és írd ki a kapott értékeket a konzolra!
*/

package polymorphism.architect;

public abstract class Plan {

    protected int pagesOfDocumentation;

    public Plan(int pagesOfDocumentation) {
        this.pagesOfDocumentation = pagesOfDocumentation;
    }

    public int getPagesOfDocumentation() {
        return pagesOfDocumentation;
    }
}
