package no.hvl.dat102.datakontaktfirma;

public class Hobby {

    private String hobbyNavn;

    public Hobby(String hobby) {
        hobbyNavn = hobby;
    }

    public String getHobbyNavn() {
        return this.hobbyNavn;
    }

    public void setHobbyNavn(String hobbyNavn) {
        this.hobbyNavn = hobbyNavn;
    }

    @Override
    public String toString() {
        return "<" + this.hobbyNavn + ">";
    }

    public boolean equals(Object hobby2) {
        Hobby hobbyDenAndre = (Hobby) hobby2;
        return (hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
    }
}