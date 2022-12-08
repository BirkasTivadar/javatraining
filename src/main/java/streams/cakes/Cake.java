/*
Készíts egy Cake nevű osztályt, amelynek attribútumai: név és a hozzávalók listája (String lista)!
*/

package streams.cakes;

import java.util.List;

public record Cake(String name, List<String> ingredients) {
}
