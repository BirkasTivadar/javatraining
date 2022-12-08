/*
Lejárati dátum
        Készíts egy Food osztályt, amelynek két attribútuma legyen: név és lejárati dátum (LocalDate)! Majd készíts egy FoodStore osztályt, amelynek van egy LinkedList típusú listája a benne tárolt élelmiszerekről, melyhez legyen getter és addFood() metódus is! Legyen az osztálynak egy metódusa: sellFirst(Food food), amely megvizsgálja a kapott élelmiszer lejárati dátumát és ha az a mai nappal egyezik meg, akkor a lista legelejére illeszti be!
*/

package collectionslist;

import java.time.LocalDate;

public record Food(String name, LocalDate expirationDate) {
}
