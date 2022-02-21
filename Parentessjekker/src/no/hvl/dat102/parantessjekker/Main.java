package no.hvl.dat102.parantessjekker;

public class Main {

    public static void main(String[] args) {

        String[] src = new String[] {
                "(]",
                "][",
                "((())",
                "()[]{}",
                "([{}])",
                "func()"
        };

        Sjekker sjekker = new Sjekker();

        for (String s : src) {
            System.out.println(sjekker.erBalansert(s));
        }

    }
}
