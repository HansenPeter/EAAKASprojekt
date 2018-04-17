package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
	private LocalDate dato;
	private String lokation;
	private String navn;
	private String tema;
	private Organisation organisation;
	private ArrayList<Beboelse> beboelser;
	private ArrayList<Udflugt> udflugter;
	private ArrayList<Tilmelding> tilmeldinger;
	private double pris;

	public Konference(LocalDate dato, String lokation, String navn, String tema, Organisation organisation,
			double pris) {
		this.dato = dato;
		this.lokation = lokation;
		this.navn = navn;
		this.tema = tema;
		this.organisation = organisation;
		this.pris = pris;
		this.udflugter = new ArrayList<Udflugt>();
		this.beboelser = new ArrayList<Beboelse>();
		this.tilmeldinger = new ArrayList<Tilmelding>();

	}

	public String getLokation() {
		return lokation;
	}

	public LocalDate getDato() {
		return dato;
	}

	public String getNavn() {
		return navn;
	}

	public String getTema() {
		return tema;
	}

	public double getPris() {
		return pris;
	}

	public ArrayList<Beboelse> getBeboelser() {
		return new ArrayList<Beboelse>(this.beboelser);
	}

	public ArrayList<Udflugt> getUdflugter() {
		return new ArrayList<>(this.udflugter);
	}

	public ArrayList<Tilmelding> getTilmeldinger() {
		return new ArrayList<Tilmelding>(this.tilmeldinger);
	}

	public void setLokation(String lokation) {
		this.lokation = lokation;
	}

	public void setDato(LocalDate dato) {
		this.dato = dato;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public void addBeboelse(Beboelse beboelse) {
		this.beboelser.add(beboelse);
	}

	public void removeBeboelse(Beboelse beboelse) {
		this.beboelser.remove(beboelse);
	}

	public void addUdflugt(Udflugt udflugt) {
		this.udflugter.add(udflugt);
	}

	public void removeUdflugt(Udflugt udflugt) {
		this.udflugter.remove(udflugt);
	}

	public void addTilmelding(Tilmelding tilmelding) {
		this.tilmeldinger.add(tilmelding);
	}

	public void removeTilmding(Tilmelding tilmelding) {
		this.tilmeldinger.remove(tilmelding);
	}

	public Udflugt createUdflugt(String lokation, LocalDate dato, double pris, boolean frokost) {
		Udflugt u = new Udflugt(lokation, dato, pris, frokost);
		this.udflugter.add(u);
		return u;

	}

	public Organisation getOrganisation() {
		return organisation;
	}

}
