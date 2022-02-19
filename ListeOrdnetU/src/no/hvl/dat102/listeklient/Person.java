package no.hvl.dat102.listeklient;

public class Person implements Comparable<Person> {

	private String fornavn;
	private String etternavn;
	private int foedselsaar;

	public Person() {
		this("", "", 0);

	}

	public Person(String fornavn, String etternavn, int foedselsaar) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.foedselsaar = foedselsaar;

	}

	public void setFoedselsaar(int foedselsaar) {
		this.foedselsaar = foedselsaar;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	int getFoedselsaar() {
		return foedselsaar;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	@Override
	public String toString() {
		return (foedselsaar + "\t" + etternavn + ", " + fornavn);
	}

	@Override
	public int compareTo(Person denAndrePersonen) {
		if (this.foedselsaar != denAndrePersonen.getFoedselsaar())
			return this.foedselsaar > denAndrePersonen.getFoedselsaar() ? 1 : -1;

		if (!this.etternavn.equals(denAndrePersonen.getEtternavn()))
			return this.etternavn.compareTo(denAndrePersonen.getEtternavn());

		return this.fornavn.compareTo(denAndrePersonen.getFornavn());
	}
}