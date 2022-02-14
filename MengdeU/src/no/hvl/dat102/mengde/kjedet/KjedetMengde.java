package no.hvl.dat102.mengde.kjedet;

import java.util.Iterator;
import java.util.Random;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.MengdeADT;

public class KjedetMengde<T> implements MengdeADT<T> {
	private static Random rand = new Random();
	private int antall;
	private LinearNode<T> start;

	public KjedetMengde() {
		antall = 0;
		start = null;
	}

	@Override
	public void leggTil(T element) {
		if (!(inneholder(element))) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNeste(start);
			start = node;
			antall++;
		}
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.iterator();
		while (teller.hasNext()) {
			leggTil(teller.next());
		}
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom())
			throw new EmptyCollectionException("mengde");

		LinearNode<T> forgjenger, aktuell;
		T resultat = null;

		int valg = rand.nextInt(antall) + 1;
		if (valg == 1) {
			resultat = start.getElement();
			start = start.getNeste();
		} else {
			forgjenger = start;
			for (int nr = 2; nr < valg; nr++) {
				forgjenger = forgjenger.getNeste();
			}
			aktuell = forgjenger.getNeste();
			resultat = aktuell.getElement();
			forgjenger.setNeste(aktuell.getNeste());
		}
		antall--;

		return resultat;

	}

	@Override
	public T fjern(T element) {

		if (erTom())
			throw new EmptyCollectionException("mengde");

		boolean funnet = false;
		LinearNode<T> forgjenger, aktuell;
		T resultat = null;
		if (start.getElement().equals(element)) {
			resultat = start.getElement();
			start = start.getNeste();
			antall--;
		} else {
			forgjenger = start;
			aktuell = start.getNeste();
			for (int sok = 2; sok <= antall && !funnet; sok++) {
				if (aktuell.getElement().equals(element))
					funnet = true;
				else {
					forgjenger = aktuell;
					aktuell = aktuell.getNeste();
				}
			}
			if (funnet) {
				resultat = aktuell.getElement();
				forgjenger.setNeste(aktuell.getNeste());
				antall--;
			}
		}
		return resultat;

	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = start;
		for (int soek = 0; soek < antall && !funnet; soek++) {
			if (aktuell.getElement().equals(element)) {
				funnet = true;
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return funnet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + antall;
		result = prime * result + ((start == null) ? 0 : start.hashCode());
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

		MengdeADT<T> m2 = (KjedetMengde<T>) ny;

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
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> _union = new KjedetMengde<T>();

		_union.leggTilAlle(m2);
		_union.leggTilAlle(this);

		return _union;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> _snitt = new KjedetMengde<T>();
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
		MengdeADT<T> _differens = new KjedetMengde<T>();
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
		return new KjedetIterator<T>(start);
	}

}
