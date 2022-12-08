package introjunit;


//Gyakorlati feladat - Első teszt implementálása
//        A pom.xml állományba vedd fel függőségként a JUnit keretrendszert test scope-pal!
//<dependencies>
//<dependency>
//<groupId>junit</groupId>
//<artifactId>junit</artifactId>
//<version>4.12</version>
//<scope>test</scope>
//</dependency>
//</dependencies
//        Hozz létre egy introjunit.Gentleman osztályt, melyben van egy public String sayHello(String name) metódus, mely visszaad egy Stringet, mely egy üdvözlő szöveg (Hello), hozzáfűzve a paraméterként átadott név!
//        Majd hozz létre egy introjunit.GentlemanTest osztályt a teszt ágon, mely azt ellenőrzi, hogy John Doe nevet átadva a visszaadott szöveg valóban Hello John Doe!

public class Gentleman {

    public String sayHello(String name) {
//        Gyakorlati feladat - Tesztlefedettség mérése
//        Implementáld, hogy ha a sayHello() metódus null paramétert kap, a visszaadott szöveg Hello Anonymous legyen! Futtasd le a tesztlefedettség mérést, és nézd meg, hogy hogyan jelzi a fejlesztőeszköz, hogy az új ág nem lett lefedve! Implementáld a megfelelő tesztesetet a GentlemanTest osztályban, és futtasd le újra a lefedettség mérést!
        if (name == null) {
            return "Hello Anonymus";
        }
        return "Hello " + name;
//    Gyakorlati feladat - Hibás teszt
//        Rontsd el először a programot, hogy hibás üzenetet adjon vissza! Hogy jelzi a JUnit ezt? Rontsd el a tesztesetet, hogy hibás legyen, amire ellenőriz! Hogyan jelzi ezt a JUnit a futtatáskor?
//        return "Hell " + name;
    }

}

