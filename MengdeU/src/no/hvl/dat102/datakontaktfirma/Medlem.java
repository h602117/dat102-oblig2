package no.hvl.dat102.datakontaktfirma;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Medlem {

    private String navn;
    private MengdeADT<Hobby> hobbyer;
    private int statusIndeks;

    public Medlem(String navn) {
        this.navn = navn;
        this.hobbyer = new TabellMengde<Hobby>();
        this.statusIndeks = -1;
    }

    public String getNavn() {
        return this.navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public MengdeADT<Hobby> getHobbyer() {
        return this.hobbyer;
    }

    public void setHobbyer(MengdeADT<Hobby> hobbyer) {
        this.hobbyer = hobbyer;
    }

    public int getStatusIndeks() {
        return this.statusIndeks;
    }

    public void setStatusIndeks(int statusIndeks) {
        this.statusIndeks = statusIndeks;
    }

    public boolean passerTil(Medlem medlem2) {
        return this.equals(medlem2);
    }

}