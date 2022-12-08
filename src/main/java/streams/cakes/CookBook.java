/*
Sütemények
        Készíts egy Cake nevű osztályt, amelynek attribútumai: név és a hozzávalók listája (String lista)! Majd készíts egy CookBook nevű osztályt, amelynek van egy listája a süteményekről, és van egy List<String> listCakeNamesWithGivenIngredient(String ingredient) metódusa, mely visszaadja azon sütemények neveit, amelyekhez szükséges a megadott hozzávaló! Írj egy List<String> listCakeNamesWithMaxIngredients(int max) metódust is, amely visszaadja azon sütemények neveit egy listában, amelyekhez legfeljebb annyi hozzávaló szükséges, mint a paraméterül kapott szám!
*/

package streams.cakes;

import java.util.ArrayList;
import java.util.List;

public class CookBook {

    List<Cake> cakes;

    public CookBook(List<Cake> cakes) {
        this.cakes = new ArrayList<>(cakes);
    }


    public List<String> listCakeNamesWithGivenIngredient(String ingredient) {
        return cakes.stream()
                .filter(c -> c.ingredients().contains(ingredient))
                .map(Cake::name)
                .toList();
    }

    public List<String> listCakeNamesWithMaxIngredients(int max) {
        return cakes.stream()
                .filter(c -> c.ingredients().size() <= max)
                .map(Cake::name)
                .toList();
    }
}
