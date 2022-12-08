/*
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
    Végül mindegyik létrehozott változón hívj meg minden, az adott változó számára elérhető metódust (a változó statikus típusa határozza meg, hogy milyen metódusokat tud használni), és írd ki a kapott értékeket a konzolr
*/

package polymorphism.architect;

public class Architect {

    public static void main(String[] args) {
        Plan planSkecth = new SketchPlan(1, "White House");
        Plan planPermit = new PermitPlan(2, "Al Aksza", "Mohamed", "Temple Mount");
        Plan planConstruction = new ConstructionPlan(3, "Lánchíd", "Széchenyi", "Budapest", 33);

        SketchPlan sketchPlan = new SketchPlan(4, "Kreml");
        SketchPlan sketchPlanPermit = new PermitPlan(5, "Kreml", "Stalin", "Red Square");
        SketchPlan sketchPlanConstruction = new ConstructionPlan(6, "Kreml", "Stalin", "Red Square", 66);

        Header headerPermitPlan = new PermitPlan(7, "Al Aksza", "Mohamed", "Temple Mount");
        Header headerConstructionPlan = new ConstructionPlan(8, "Al Aksza", "Mohamed", "Temple Mount", 88);

        PermitPlan permitPlan = new PermitPlan(9, "Lánchíd", "Széchenyi", "Budapest");
        PermitPlan permitPlanConstruction = new ConstructionPlan(10, "Lánchíd", "Széchenyi", "Budapest", 1010);

        ConstructionPlan constructionPlan = new ConstructionPlan(11, "Forbidden City", "Hszi Csi Ping", "Beijing", 1111);

        System.out.println("PLAN:");
        System.out.println(planSkecth.getPagesOfDocumentation());
        System.out.println(planPermit.getPagesOfDocumentation());
        System.out.println(planConstruction.getPagesOfDocumentation());

        System.out.println("\nSKETCH:");
        System.out.println(sketchPlan.getPagesOfDocumentation());
        System.out.println(sketchPlan.getTitle());
        System.out.println(sketchPlanPermit.getPagesOfDocumentation());
        System.out.println(sketchPlanPermit.getTitle());
        System.out.println(sketchPlanConstruction.getPagesOfDocumentation());
        System.out.println(sketchPlanConstruction.getTitle());

        System.out.println("\nHEADER:");
        System.out.println(headerPermitPlan.getNameOfClient());
        System.out.println(headerPermitPlan.getAddressOfBuilding());
        System.out.println(headerConstructionPlan.getNameOfClient());
        System.out.println(headerConstructionPlan.getAddressOfBuilding());

        System.out.println("\nPERMIT:");
        System.out.println(permitPlan.getPagesOfDocumentation());
        System.out.println(permitPlan.getTitle());
        System.out.println(permitPlan.getNameOfClient());
        System.out.println(permitPlan.getAddressOfBuilding());
        System.out.println(permitPlan.getHeader());
        System.out.println(permitPlanConstruction.getPagesOfDocumentation());
        System.out.println(permitPlanConstruction.getTitle());
        System.out.println(permitPlanConstruction.getNameOfClient());
        System.out.println(permitPlanConstruction.getAddressOfBuilding());
        System.out.println(permitPlanConstruction.getHeader());

        System.out.println("\nCONSTRUCTION:");
        System.out.println(constructionPlan.getPagesOfDocumentation());
        System.out.println(constructionPlan.getTitle());
        System.out.println(constructionPlan.getNameOfClient());
        System.out.println(constructionPlan.getAddressOfBuilding());
        System.out.println(constructionPlan.getSheetsOfConstructionDrawings());
        System.out.println(constructionPlan.getHeader());


    }
}
