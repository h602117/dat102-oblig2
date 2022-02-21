package no.hvl.dat102.stabel;

public class EmptyCollectionException extends RuntimeException {

	public EmptyCollectionException(String samling) {
		super("" + samling + " er tom.");
	}

}
