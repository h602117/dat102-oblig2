package no.hvl.dat102.stabel;

public class TabellStabel<T> implements StabelADT<T> {
	private final static int STDK = 100;
	private int topp; // indikerer toppen
	private T[] stabel;

	public TabellStabel() {
		this(STDK);
	}

	public TabellStabel(int startKapasitet) {
		topp = -1;
		stabel = (T[]) (new Object[startKapasitet]);
	}

	@Override
	public void push(T element) {
		if (topp == stabel.length - 1)
			utvid();
		topp++;
		stabel[topp] = element;
	}

	@Override
	public T pop() {
		if (erTom())
			throw new EmptyCollectionException("Stabel");
		T resultat = stabel[topp];
		stabel[topp] = null;
		topp--;
		return resultat;
	}

	@Override
	public T peek() {
		if (erTom())
			throw new EmptyCollectionException("Stabel");

		return stabel[topp];

	}

	@Override
	public boolean erTom() {
		return (topp < 0);
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Object[stabel.length * 2]);

		for (int indeks = 0; indeks < stabel.length; indeks++)
			hjelpeTabell[indeks] = stabel[indeks];

		stabel = hjelpeTabell;
	}
}
