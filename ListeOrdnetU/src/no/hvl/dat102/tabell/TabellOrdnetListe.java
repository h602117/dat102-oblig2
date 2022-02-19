package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private final static int STDK = 100;
	private int antall;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		antall = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T el = this.liste[--this.antall];
		this.liste[this.antall] = null;

		return el;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T el = this.liste[0];

		System.arraycopy(this.liste, 1, this.liste, 0, this.antall);
		this.liste[this.antall] = null;
		this.antall--;

		return el;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		return resultat;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		return this.liste[this.antall];
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T element) {
		if (this.antall == this.liste.length - 1) {
			this.utvid();
		}

		this.liste[this.antall++] = element;
	}

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != -1);
	}

	@Override
	public T fjern(T element) {
		int idx = this.finn(element);
		if (idx == -1)
			return null;

		if (idx == this.antall - 1)
			return this.fjernSiste();

		T el = this.liste[idx];
		System.arraycopy(this.liste, idx + 1, this.liste, idx, this.antall - idx);
		this.liste[this.antall] = null;
		this.antall--;

		return el;
	}

	private int finn(T el) {
		for (int i = 0; i < this.antall; i++) {
			if (this.liste[i].equals(el)) {
				return i;
			}
		}

		return -1;
	}

	@Override
	public String toString() {
		String resultat = "";

		for (int i = 0; i < antall; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}

		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}

}
