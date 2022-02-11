package no.hvl.dat102.mengde.tabell;

import no.hvl.dat102.mengde.adt.*;

public class TabellMengdeTest extends MengdeADTTest {
    
    @Override
    public MengdeADT<Integer> reset() {
        return new TabellMengde<Integer>();
    }

}
