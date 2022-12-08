/*
Írj egy webshop.Product osztályt name, price és LocalDateTime from attribútumokkal, konstruktorral, getterekkel!
*/

package sorting.webshop;

import java.time.LocalDateTime;

public record Product(String name, int price, LocalDateTime time) {
}
