package lambdaintro.cars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @Test
    void testCreate() {
        Car car = new Car("Fiat", "Scudo", 3_000_000, 5.27);

        assertEquals("Fiat", car.brand());
        assertEquals("Scudo", car.type());
        assertEquals(3_000_000, car.price());
        assertEquals(5.27, car.length());
    }
}