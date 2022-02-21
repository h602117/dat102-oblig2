package no.hvl.dat102.datakontaktfirma;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class DataKontakt {

    private MengdeADT<Medlem> medlemmer;
    private int antall;

    public DataKontakt() {
        this.antall = 0;
        this.medlemmer = new TabellMengde<Medlem>();
    }

    public int getAntall() {
        return this.antall;
    }

    public void setAntall(int antall) {
        this.antall = antall;
    }

    public MengdeADT<Medlem> getMedlemmer() {
        return this.medlemmer;
    }

    public void leggTilMedlem(Medlem person) {
        this.medlemmer.leggTil(person);
    }

    public int finnMedmelsIndeks(String medlemsnavn) {
        for (int i = 0; i < this.antall; i++) {
            if (this.medlemmer.get(i).getNavn().equals(medlemsnavn)) {
                return i;
            }
        }

        return -1;
    }

    public int finnPartnerFor(String medlemsnavn) {
        Medlem m = this.medlemmer.get(this.finnMedmelsIndeks(medlemsnavn));
        for (int i = 0; i < this.antall; i++) {
            if (m.passerTil(this.medlemmer.get(i))) {
                m.setStatusIndeks(i);
                return i;
            }
        }

        return -1;
    }

    public void tilbakestillStatusIndex(String medlemsnavn) {
        for (int i = 0; i < this.antall; i++) {
            if (this.medlemmer.get(i).getNavn().equals(medlemsnavn)) {
                this.medlemmer.get(i).setStatusIndeks(-1);
            }
        }
    }
}