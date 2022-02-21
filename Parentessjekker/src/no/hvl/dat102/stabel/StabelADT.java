package no.hvl.dat102.stabel;

public interface StabelADT<T> {

	public void push(T element);

	public T pop();

	public T peek();

	public boolean erTom();

}
