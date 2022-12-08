/*
Kedvezmények
        Hozz létre egy Discount nevű enumot, amelyben kétféle kedvezmény legyen: SPECIAL_OFFER és BLACK_FRIDAY_OFFER! Legyen ezenkívül egy absztrakt metódus is az enumban: double getAmountToPay(int price, int pieces), mely egy termék árát és darabszámát várja paraméterül, és mindkét kedvezmény esetében kiszámítja a fizetendő végösszeget! A kedvezmény mértéke sima akció esetén 20 %-os legyen, Black Friday idején viszont a következőképpen alakuljon: 1 vagy 2 ugyanolyan termék vásárlása esetén 25%-os a kedvezmény mértéke, 3 vagy több ugyanolyan termék vásárlása esetén pedig egy termékre 50%-os, a többire 25%-os legyen!
*/

package enumabstract.discount;

public enum Discount {

    SPECIAL_OFFER {
        @Override
        public double getAmountToPay(int price, int pieces) {
            return price * pieces * 0.8;
        }
    },

    BLACK_FRIDAY_OFFER {
        @Override
        public double getAmountToPay(int price, int pieces) {
            if (pieces < 3) return price * pieces * 0.75;

            return price * 0.5 + price * (pieces - 1) * 0.75;
        }

    };

    public abstract double getAmountToPay(int price, int pieces);
}
