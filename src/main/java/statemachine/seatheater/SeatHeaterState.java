/*
Ülésfűtés gomb
        Egy gombbal lehet állítani az autóban az ülésfűtést. Alapállapotban ki van kapcsolva. Ha ekkor megnyomjuk, akkor maximális (3-as) fokozatra kapcsol a fűtés, ha még egyszer megnyomjuk, akkor 2-es fokozatra áll, ha még egyszer, akkor 1-esre áll, és ha még egyszer, akkor kikapcsol. A seatheater.SeatHeaterState enumban szimuláljuk a gomb működését, ahogyan a 4 állapot között vált! A lecke szövegében olvasható példához hasonlóan itt is az enumban legyen az absztrakt metódus! Írj tesztet is a metódus implementációinak tesztelésére!
*/

package statemachine.seatheater;

public enum SeatHeaterState {
    OFF {
        @Override
        public SeatHeaterState next() {
            return SeatHeaterState.THREE;
        }

    },
    ONE {
        @Override
        public SeatHeaterState next() {
            return SeatHeaterState.OFF;
        }

    },
    TWO {
        @Override
        public SeatHeaterState next() {
            return SeatHeaterState.ONE;
        }

    },
    THREE {
        @Override
        public SeatHeaterState next() {
            return SeatHeaterState.TWO;
        }

    };

    abstract SeatHeaterState next();
}
