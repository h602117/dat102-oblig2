package no.hvl.dat102.parantessjekker;

public class Main {

	public static void main(String[] args) {

		String[] src = new String[] { "(]", "][", "((())", "()[]{}", "([{}])", "func()" };

		Sjekker sjekker = new Sjekker();

		System.out.println("Er balansert:");
		for (String s : src) {
			System.out.println("'" + s + "': " + sjekker.erBalansert(s));
		}

	}
}
