/*
Majd készíts egy FoodStore osztályt, amelynek van egy LinkedList típusú listája a benne tárolt élelmiszerekről, melyhez legyen getter és addFood() metódus is! Legyen az osztálynak egy metódusa: sellFirst(Food food), amely megvizsgálja a kapott élelmiszer lejárati dátumát és ha az a mai nappal egyezik meg, akkor a lista legelejére illeszti be!
*/

package collectionslist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FoodStore {

    private final List<Food> foods = new LinkedList<>();

    public void addFood(Food food) {
        foods.add(food);
    }

    public List<Food> getFoods() {
        return new ArrayList<>(foods);
    }

    public void sellFirst(Food food) {
        if (food.expirationDate().equals(LocalDate.now())) foods.add(0, food);
    }
}
