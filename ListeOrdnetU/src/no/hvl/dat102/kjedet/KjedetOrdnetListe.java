package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T el = this.foerste.getElement();
		this.foerste = this.foerste.getNeste();
		this.antall--;

		return el;
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T el = this.siste.getElement();

		LinearNode<T> n = this.foerste;
		for (int i = 0; i < this.antall - 2; i++) {
			n = n.getNeste();
		}

		this.siste = n;
		this.antall--;

		return el;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		return foerste.getElement();
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		return siste.getElement();
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
		LinearNode<T> newNode = new LinearNode<T>(element);
		if (this.foerste == null) {
			this.foerste = newNode;
			this.antall++;
			return;
		}

		LinearNode<T> curr = this.foerste;
		LinearNode<T> prev = null;
		for (int i = 0; i < this.antall; i++) {
			if (curr.getElement().compareTo(element) < 0) {
				prev = curr;
				curr = curr.getNeste();
				if (curr == null) {
					prev.setNeste(newNode);
					this.siste = newNode;
					break;
				}
			} else {
				if (prev != null) {
					prev.setNeste(newNode);
					newNode.setNeste(curr);
				} else {
					this.foerste = newNode;
					this.foerste.setNeste(curr);
				}

				break;
			}
		}

		this.antall++;
	}

	@Override
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) {
			antall--;
			svar = denne.getElement();
			if (forrige == null) {
				foerste = foerste.getNeste();
				if (foerste == null) {
					siste = null;
				}
			} else {
				forrige.setNeste(denne.getNeste());
				if (denne == siste) {
					siste = forrige;
				}
			}
		}
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		}
		return resultat;
	}

	@Override
	public String toString() {
		String out = "";
		LinearNode<T> node = this.foerste;

		while (node != null) {
			out += node.getElement().toString() + " ";
			node = node.getNeste();
		}

		return out;
	}

}