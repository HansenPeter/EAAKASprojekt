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

	public Konference createKonference(LocalDate startDato, LocalDate slutDato, String lokation, String navn,
			String tema, double pris) {
		Konference konference = new Konference(startDato, slutDato, lokation, navn, tema, this, pris);
		this.konferencer.add(konference);
		return konference;
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.navn;
	}
}
