/*
Elromlott az írógép
        Képzeld el, hogy van egy régi hagyományos írógép, aminek a CAPS LOCK-ja elromlott és minden sor végén vált automatikusan: ha kisbetűs sort írtak vele, akkor nagybetűre vált, ha nagybetűs sort írtak, akkor kisbetűre vált. Mindezt a typewriter.TypeWriterState enumban modellezd! A lecke szövegében olvasható példához hasonlóan itt is az enumban legyen az absztrakt metódus! Írj tesztet is a metódus implementációinak tesztelésére!
*/

package statemachine.typewriter;

public enum TypeWriterState {
    LOWERCASE {
        @Override
        public TypeWriterState next() {
            return TypeWriterState.UPPERCASE;
        }
    },
    UPPERCASE {
        @Override
        public TypeWriterState next() {
            return TypeWriterState.LOWERCASE;
        }
    };

    abstract TypeWriterState next();
}
