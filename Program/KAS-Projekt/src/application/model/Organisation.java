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
	

	public Konference createKonference(LocalDate startDato, LocalDate slutDato, String lokation, String navn, String tema, double pris) {
		Konference k = new Konference(startDato, slutDato, lokation, navn, tema, this, pris);
		
		return k;
		// LocalDate dato, String lokation, String navn, String tema, Organisation
		// organisation, double pris) {
	}
	
	public void addKonference(Konference konference) {
		this.konferencer.add(konference);
	}

	public void removeKonference(Konference konference) {
		this.konferencer.remove(konference);
	}

	public ArrayList<Konference> getKonferencer() {
		return konferencer;
	}

	public String getNavn() {
		return navn;
	}
}
