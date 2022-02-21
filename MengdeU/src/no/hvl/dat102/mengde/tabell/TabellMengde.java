package no.hvl.dat102.mengde.tabell;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.MengdeADT;

public class TabellMengde<T> implements MengdeADT<T> {
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}

	@Override
	public T get(int idx) {
		if (idx < 0 || idx >= this.antall) {
			return null;
		}

		return this.tab[idx];
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.iterator();
		while (teller.hasNext())
			leggTil(teller.next());
	}

	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom())
			throw new EmptyCollectionException("mengde");

		T svar = null;
		int indeks = tilf.nextInt(antall);
		svar = tab[indeks];
		tab[indeks] = tab[antall - 1];
		tab[antall - 1] = null;
		antall--;

		return svar;
	}

	@Override
	public T fjern(T element) {

		if (erTom())
			throw new EmptyCollectionException("mengde");

		boolean funnet = false;
		T svar = null;
		for (int i = 0; (i < antall && !funnet); i++) {
			if (tab[i].equals(element)) {
				svar = tab[i];
				tab[i] = tab[antall - 1];
				tab[antall - 1] = null;
				antall--;
				funnet = true;

			}
		}
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		for (int i = 0; (i < antall) && (!funnet); i++) {
			if (tab[i].equals(element)) {
				funnet = true;
			}
		}
		return (funnet);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + antall;
		result = prime * result + Arrays.deepHashCode(tab);
		return result;
	}

	@Override
	public boolean equals(Object ny) {
		if (this == ny) {
			return true;
		}

		if (ny == null) {
			return false;
		}

		if (getClass() != ny.getClass()) {
			return false;
		}

		MengdeADT<T> m2 = (TabellMengde<T>) ny;

		if (this.antall != m2.antall()) {
			return false;
		}

		Iterator<T> it = m2.iterator();
		while (it.hasNext()) {
			if (!this.inneholder(it.next())) {
				return false;
			}
		}

		return true;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> _union = new TabellMengde<T>();

		_union.leggTilAlle(m2);
		_union.leggTilAlle(this);

		return _union;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> _snitt = new TabellMengde<T>();
		Iterator<T> it = m2.iterator();

		while (it.hasNext()) {
			T el = it.next();
			if (this.inneholder(el)) {
				_snitt.leggTil(el);
			}
		}

		return _snitt;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> _differens = new TabellMengde<T>();
		Iterator<T> it = this.iterator();

		while (it.hasNext()) {
			T el = it.next();
			if (!m2.inneholder(el)) {
				_differens.leggTil(el);
			}
		}

		return _differens;
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		Iterator<T> it = m2.iterator();

		while (it.hasNext()) {
			if (!this.inneholder(it.next())) {
				return false;
			}
		}

		return true;
	}

	@Override
	public Iterator<T> iterator() {
		return new TabellIterator<T>(tab, antall);
	}

	@Override
	public String toString() {
		String resultat = "<";

		for (int i = 0; i < this.antall; i++) {
			resultat += this.tab[i].toString();
			if (i < this.antall - 1)
				resultat += ", ";
		}

		resultat += ">";

		return resultat;
	}

}
