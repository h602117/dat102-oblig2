package no.hvl.dat102.mengde.adt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class MengdeADTTest {

    private Integer e0 = 1;
    private Integer e1 = 2;
    private Integer e2 = 3;
    private Integer e3 = 4;
    private Integer e4 = 5;

    private MengdeADT<Integer> m1;
    private MengdeADT<Integer> m2;

    protected abstract MengdeADT<Integer> reset();

    @BeforeEach
    public void setup() {
        m1 = reset();
        m2 = reset();

        m1.leggTil(e0);
        m1.leggTil(e1);
        m1.leggTil(e2);
        
        m2.leggTil(e2);
        m2.leggTil(e3);
        m2.leggTil(e4);
    }

    @Test
    public void unionFelles() {
        MengdeADT<Integer> _union = m1.union(m2);

        assert (_union.antall() == 5);
        assert (_union.inneholder(e0));
        assert (_union.inneholder(e1));
        assert (_union.inneholder(e2));
        assert (_union.inneholder(e3));
        assert (_union.inneholder(e4));
    }

    @Test
    public void unionUtenFelles() {
        m1.fjern(e2);
        m2.fjern(e2);
        MengdeADT<Integer> _union = m1.union(m2);

        assert (_union.antall() == 4);
        assert (_union.inneholder(e0));
        assert (_union.inneholder(e1));
        assert (!_union.inneholder(e2));
        assert (_union.inneholder(e3));
        assert (_union.inneholder(e4));
    }

    @Test
    public void snittFelles() {
        m1.fjern(e2);
        m2.fjern(e2);

        MengdeADT<Integer> _snitt = m1.snitt(m2);

        assert(_snitt.antall() == 0);
        assert(!_snitt.inneholder(e0));
        assert(!_snitt.inneholder(e1));
        assert(!_snitt.inneholder(e2));
        assert(!_snitt.inneholder(e3));
        assert(!_snitt.inneholder(e4));

    }

    @Test
    public void snittUtenFelles() {
        MengdeADT<Integer> _snitt = m1.snitt(m2);

        assert(_snitt.antall() == 1);
        assert(!_snitt.inneholder(e0));
        assert(!_snitt.inneholder(e1));
        assert(_snitt.inneholder(e2));
        assert(!_snitt.inneholder(e3));
        assert(!_snitt.inneholder(e4));

    }

    @Test
    public void differensFelles() {
        MengdeADT<Integer> _differens = m1.differens(m2);

        assert(_differens.antall() == 2);
        assert(_differens.inneholder(e0));
        assert(_differens.inneholder(e1));
        assert(!_differens.inneholder(e2));
        assert(!_differens.inneholder(e3));
        assert(!_differens.inneholder(e4));
    }

    @Test
    public void differensUtenFelles() {
        m1.fjern(e2);
        m2.fjern(e2);
        MengdeADT<Integer> _differens = m1.differens(m2);

        assert(_differens.antall() == 2);
        assert(_differens.inneholder(e0));
        assert(_differens.inneholder(e1));
        assert(!_differens.inneholder(e2));
        assert(!_differens.inneholder(e3));
        assert(!_differens.inneholder(e4));
    }

}
