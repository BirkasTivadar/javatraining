package collectionsiterator.christmas;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChristmasShoppingTest {

    @Test
    void testRemovePresent() {
        List<ChristmasPresent> presents = new ArrayList<>();
        presents.add(new ChristmasPresent("távirányítós autó", "Józsika", 8000));
        presents.add(new ChristmasPresent("angol szótár", "Juci néni", 2000));
        presents.add(new ChristmasPresent("meleg harisnya", "anya", 600));
        ChristmasShopping shopping = new ChristmasShopping(presents);
        shopping.addNewPresent(new ChristmasPresent("legó", "Balázska", 20000));
        shopping.removeTooExpensivePresent(5000);

        assertEquals(2, shopping.getPresents().size());
        assertEquals("meleg harisnya", shopping.getPresents().get(1).description());
    }
}