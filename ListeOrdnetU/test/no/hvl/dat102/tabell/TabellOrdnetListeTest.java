package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.adt.OrdnetListeADTTest;

public class TabellOrdnetListeTest extends OrdnetListeADTTest {

    @Override
    protected OrdnetListeADT<Integer> reset() {
        return new TabellOrdnetListe<Integer>();
    }

}