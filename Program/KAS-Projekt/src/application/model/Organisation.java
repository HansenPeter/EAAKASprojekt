package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Organisation {
	private String navn;
	private ArrayList<Konference> konferencer;

	public Organisation(String navn) {
		this.navn = navn;
		this.konferencer = new ArrayList<>();
	}

	public Konference createKonferance(LocalDate dato, String lokation, String navn, String tema, double pris) {
		Konference k = new Konference(dato, lokation, navn, tema, this, pris);
		this.konferencer.add(k);
		return k;
		// LocalDate dato, String lokation, String navn, String tema, Organisation
		// organisation, double pris) {
	}

	public void removeKonferance(Konference konference) {
		this.konferencer.remove(konference);
	}

	public ArrayList<Konference> getKonferencer() {
		return konferencer;
	}

	public String getNavn() {
		return navn;
	}
}
