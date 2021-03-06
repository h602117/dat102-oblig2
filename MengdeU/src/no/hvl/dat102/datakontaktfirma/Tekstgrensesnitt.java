package no.hvl.dat102.datakontaktfirma;

import java.util.Iterator;
import java.util.Scanner;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Tekstgrensesnitt {

	private static int TEST = 0;

	public static void main(String[] args) {

		DataKontakt arkiv = new DataKontakt();

		if (TEST == 1) {
			Medlem m1 = new Medlem("test");
			Medlem m2 = new Medlem("testine");
			Medlem m3 = new Medlem("tinder");
			Medlem m4 = new Medlem("tinderine");

			MengdeADT<Hobby> h1 = new TabellMengde<Hobby>();
			h1.leggTil(new Hobby("ski"));
			h1.leggTil(new Hobby("sjakk"));

			MengdeADT<Hobby> h2 = new TabellMengde<Hobby>();
			h2.leggTil(new Hobby("fotball"));

			m1.setHobbyer(h1);
			m2.setHobbyer(h2);
			m3.setHobbyer(h1);
			m4.setHobbyer(h2);

			arkiv.leggTilMedlem(m1);
			arkiv.leggTilMedlem(m2);
			arkiv.leggTilMedlem(m3);
			arkiv.leggTilMedlem(m4);
		} else {
			for (int i = 0; i < 4; i++) {
				arkiv.leggTilMedlem(lesMedlem());
			}
		}

		skrivParListe(arkiv);
	}

	private static String skaffString(Scanner s, String prompt) {
		String str = "";
		while (str.equals("")) {
			System.out.print(prompt);
			str = s.nextLine();
		}

		return str;
	}

	private static String skaffStringEllerNull(Scanner s, String prompt) {
		System.out.print(prompt);
		return s.nextLine();
	}

	public static Medlem lesMedlem() {
		Scanner sc = new Scanner(System.in);

		String navn = skaffString(sc, "Navn: ");
		String hobbyString = skaffStringEllerNull(sc, "Hobbyer: ");

		Medlem m = new Medlem(navn);

		if (!hobbyString.equals("")) {
			MengdeADT<Hobby> hobbyer = new TabellMengde<Hobby>();
			for (String h : hobbyString.split(",")) {
				hobbyer.leggTil(new Hobby(h.trim()));
			}

			m.setHobbyer(hobbyer);
		}

		return m;
	}

	public static void skrivHobbyListe(Medlem medlem) {
		System.out.println("Alle hobbyene:\n" + medlem.getHobbyer().toString());
	}

	public static void skrivParListe(DataKontakt arkiv) {
		MengdeADT<Medlem> altPrinta = new TabellMengde<Medlem>();
		Iterator<Medlem> it = arkiv.getMedlemmer().iterator();

		System.out.println("Par:");

		while (it.hasNext()) {
			Medlem m = it.next();
			int pIdx = arkiv.finnPartnerFor(m.getNavn());
			if (pIdx != -1) {
				Medlem partner = arkiv.getMedlemmer().get(m.getStatusIndeks());

				if (!altPrinta.inneholder(m) && !altPrinta.inneholder(partner)) {
					System.out.println(m.getNavn() + " og " + partner.getNavn() + " " + m.getHobbyer());
				}

				altPrinta.leggTil(m);
				altPrinta.leggTil(partner);
			}
		}
	}
}