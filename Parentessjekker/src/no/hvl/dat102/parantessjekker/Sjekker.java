package no.hvl.dat102.parantessjekker;

import no.hvl.dat102.stabel.EmptyCollectionException;
import no.hvl.dat102.stabel.StabelADT;
import no.hvl.dat102.stabel.TabellStabel;

public class Sjekker implements Parentessjekker {

    private StabelADT<Character> stabel;

    public Sjekker() {
        this.stabel = new TabellStabel<Character>();
    }

    @Override
    public boolean erVenstreparentes(char p) {
        return p == '(' || p == '[' || p == '{';
    }

    @Override
    public boolean erHogreparentes(char p) {
        return p == ')' || p == ']' || p == '}';
    }

    @Override
    public boolean erParentes(char p) {
        return this.erVenstreparentes(p) || this.erHogreparentes(p);
    }

    @Override
    public boolean erPar(char venstre, char hogre) {
        switch (venstre) {
            case '(':
                return hogre == ')';
            case '[':
                return hogre == ']';
            case '{':
                return hogre == '}';
            default:
                return false;
        }
    }

    @Override
    public boolean erBalansert(String s) {
        this.stabel = new TabellStabel<Character>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            if (this.erVenstreparentes(c)) {
                stabel.push(c);
            } else if (this.erHogreparentes(c)) {
                try {
                    if (!this.erPar(stabel.pop(), c))
                        return false;
                } catch (EmptyCollectionException e) {
                    return false;
                }
            }
        }

        return this.stabel.erTom();
    }

}