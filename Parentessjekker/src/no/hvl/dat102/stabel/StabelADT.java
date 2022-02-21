package no.hvl.dat102.stabel;

public interface StabelADT<T> {

	/**
	 * Legger et nytt element paa toppen av stabelen
	 *
	 * @param element
	 */
	public void push(T element);

	/**
	 * Fjerner og returnerer elementet fra toppen av stabelen
	 *
	 * @return element fra toppen av stabelen
	 */
	public T pop();

	/**
	 * Returnerer, men fjerner ikke, elementet fra toppen av stabelen
	 *
	 * @return element fra toppen av stabelen
	 */
	public T peek();

	/**
	 * Sjekk om stabelen er tom
	 *
	 * @return true om tom, ellers false
	 */
	public boolean erTom();

}
