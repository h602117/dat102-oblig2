package no.hvl.dat102.adt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.exceptions.EmptyCollectionException;

public abstract class OrdnetListeADTTest {

    private OrdnetListeADT<Integer> liste;

    private Integer e0 = 0;
    private Integer e1 = 1;
    private Integer e2 = 2;
    private Integer e3 = 3;
    private Integer e4 = 4;

    protected abstract OrdnetListeADT<Integer> reset();

    @BeforeEach
    public void setup() {
        liste = reset();
    }

    @Test
    public void nyListeErTom() {
        assert liste.erTom();
    }

    @Test
    public void leggTilOgFjern() {
        liste.leggTil(e0);
        liste.leggTil(e1);
        liste.leggTil(e2);
        liste.leggTil(e3);
        liste.leggTil(e4);
        assert liste.fjern(e0).equals(e0);
        assert liste.fjern(e1).equals(e1);
        assert liste.fjern(e2).equals(e2);
        assert liste.fjern(e3).equals(e3);
        assert liste.fjern(e4).equals(e4);
        assert liste.erTom();
    }

    @Test
    public void viseOrdnetIkkeAvtagende() {
        liste.leggTil(e0);
        liste.leggTil(e1);
        liste.leggTil(e2);
        liste.leggTil(e3);
        liste.leggTil(e4);
        assert liste.fjernFoerste().equals(e0);
        assert liste.fjernFoerste().equals(e1);
        assert liste.fjernFoerste().equals(e2);
        assert liste.fjernFoerste().equals(e3);
        assert liste.fjernFoerste().equals(e4);
    }

    @Test
    public void visOrdnetIkkeStigende() {
        liste.leggTil(e0);
        liste.leggTil(e1);
        liste.leggTil(e2);
        liste.leggTil(e3);
        liste.leggTil(e4);
        assert liste.fjernSiste().equals(e4);
        assert liste.fjernSiste().equals(e3);
        assert liste.fjernSiste().equals(e2);
        assert liste.fjernSiste().equals(e1);
        assert liste.fjernSiste().equals(e0);
    }

    @Test
    public void leggTilOgFjernMedDuplikater() {
        liste.leggTil(e0);
        liste.leggTil(e1);
        liste.leggTil(e4);
        liste.leggTil(e1);
        liste.leggTil(e2);
        liste.leggTil(e3);
        assert liste.fjern(e0).equals(e0);
        assert liste.fjern(e1).equals(e1);
        assert liste.fjern(e4).equals(e4);
        assert liste.fjern(e1).equals(e1);
        assert liste.fjern(e2).equals(e2);
        assert liste.fjern(e3).equals(e3);
    }

    @Test
    public void leggTilOgInneholder() {
        liste.leggTil(e0);
        liste.leggTil(e1);
        liste.leggTil(e2);
        liste.leggTil(e3);

        assert liste.inneholder(e0);
        assert liste.inneholder(e1);
        assert liste.inneholder(e2);
        assert liste.inneholder(e3);
        assert !liste.inneholder(e4);
    }

    @Test
    public void erIkkeTom() {
        liste.leggTil(e0);
        liste.leggTil(e1);
        liste.leggTil(e2);
        liste.leggTil(e3);
        liste.leggTil(e4);
        assert !liste.erTom();
    }

    @Test
    public void leggTilOgFjernErTom() {
        liste.leggTil(e0);
        liste.leggTil(e1);
        liste.leggTil(e2);
        liste.leggTil(e3);
        liste.leggTil(e4);
        liste.fjern(e0);
        liste.fjern(e1);
        liste.fjern(e2);
        liste.fjern(e3);
        liste.fjern(e4);
        assert liste.erTom();
    }

    @Test
    public void fjernFraTomListe() {
        Assertions.assertThrows(EmptyCollectionException.class, () -> {
            liste.fjernFoerste();
        });
    }
}