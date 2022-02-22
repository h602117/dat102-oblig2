package no.hvl.dat102;

import java.util.Scanner;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.listeklient.Person;
import no.hvl.dat102.tabell.TabellOrdnetListe;

public class Main {

	private static int EG_VIL_IKKJE_SKRIVA = 1;

	public static void main(String[] args) {
		System.out.println("Tabell:");
		tabell();
		System.out.println("Kjedet:");
		kjedet();
	}

	private static void kjedet() {
		OrdnetListeADT<Person> personer = new KjedetOrdnetListe<Person>();

		if (EG_VIL_IKKJE_SKRIVA == 1) {
			juks(personer);
		} else {
			for (int i = 0; i < 5; i++) {
				personer.leggTil(skaffPerson());
			}
		}

		while (!personer.erTom()) {
			System.out.println(personer.fjernSiste().toString());
		}
	}

	private static void tabell() {
		OrdnetListeADT<Person> personer = new TabellOrdnetListe<Person>();

		if (EG_VIL_IKKJE_SKRIVA == 1) {
			juks(personer);
		} else {
			for (int i = 0; i < 5; i++) {
				personer.leggTil(skaffPerson());
			}
		}

		while (!personer.erTom()) {
			System.out.println(personer.fjernSiste().toString());
		}
	}

	private static void juks(OrdnetListeADT<Person> l) {
		l.leggTil(new Person("Ola", "Nordmann", 1945));
		l.leggTil(new Person("Kari", "Nordmann", 1945));
		l.leggTil(new Person("Navn", "Navnesen", 2000));
		l.leggTil(new Person("Test", "Testesen", 1945));
		l.leggTil(new Person("Ivar", "Aasen", 1813));
	}

	private static Person skaffPerson() {
		Scanner sc = new Scanner(System.in);
		String fnavn = skaffString(sc, "Fornavn: ");
		String enavn = skaffString(sc, "Etternavn: ");
		int faar = skaffNummer(sc, "Foedselsaar: ");
		return new Person(fnavn, enavn, faar);
	}

	private static String skaffString(Scanner s, String prompt) {
		String str = "";
		while (str.equals("")) {
			System.out.print(prompt);
			str = s.nextLine();
		}

		return str;
	}

	private static int skaffNummer(Scanner s, String prompt) {
		System.out.print(prompt);
		try {
			int number = Integer.parseInt(s.nextLine());
			return number;
		} catch (NumberFormatException e) {
			return skaffNummer(s, prompt);
		}
	}
}
