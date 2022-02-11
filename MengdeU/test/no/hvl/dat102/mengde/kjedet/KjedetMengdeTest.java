package no.hvl.dat102.mengde.kjedet;

import no.hvl.dat102.mengde.adt.*;

public class KjedetMengdeTest extends MengdeADTTest {
    
    @Override
    public MengdeADT<Integer> reset() {
        return new KjedetMengde<Integer>();
    }
    
}
