/*
Megrendelések
    Egy webshop a megrendelések állapotát az OrderState enumban tárolja. Állapotai:
        NEW, ez az állapota minden újonnan leadott megrendelésnek.
        CONFIRMED, miután visszaigazolták a rendelést.
        PREPARED, miután a megrendelést összekészítették.
        ONBOARD, miután átadták a futárnak.
        DELIVERED, miután sikeresen kiszállították.
        RETURNED, sikertelen kiszállítási kísérlet után.
        DELETED, miután bármilyen okból a rendelést törölték.
        Egy megrendelést addig lehet visszamondani, amíg még nem adták át a futárnak.
        Készíts egy Deletable interfészt, és implementáld az enumban! Az interfész egyetlen absztrakt metódust tartalmazzon: boolean canDelete()! Az OrderState enum NEW, CONFIRMED és PREPARED értékei esetén igazat, minden más esetben hamisat kell visszaadjon.
*/

package enumabstract.orderstate;

public enum OrderState implements Deletable {
    NEW {
        @Override
        public boolean canDelete() {
            return true;
        }
    },
    CONFIRMED {
        @Override
        public boolean canDelete() {
            return true;
        }
    },
    PREPARED {
        @Override
        public boolean canDelete() {
            return true;
        }
    },
    ONBOARD {
        @Override
        public boolean canDelete() {
            return false;
        }
    },
    DELIVERED {
        @Override
        public boolean canDelete() {
            return false;
        }
    },
    RETURNED {
        @Override
        public boolean canDelete() {
            return false;
        }
    },
    DELETED {
        @Override
        public boolean canDelete() {
            return false;
        }
    }
}



