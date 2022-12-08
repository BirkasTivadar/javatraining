package interfacerules.commonproperties;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommonPropertiesTest {

    @Test
    void testEquator() {
        Equator equator = new Equator();

        assertEquals("Equator", equator.name());
        assertEquals(40_075.0, equator.length());
    }

    @Test
    void testIkeaFurniture() {
        IkeaFurniture furniture = new IkeaFurniture("Jokkmokk asztal", 108.0, 68.0);

        assertEquals("Jokkmokk asztal", furniture.name());
        assertEquals(108.0, furniture.length());
        assertEquals(68.0, furniture.width());
    }

    @Test
    void testParkingPlace() {
        ParkingPlace parkingPlace = new ParkingPlace();

        assertEquals(5.0, parkingPlace.length());
        assertEquals(2.2, parkingPlace.width());
    }
}