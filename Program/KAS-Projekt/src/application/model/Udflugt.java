package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udflugt {
	private String lokation;
	private LocalDate dato;
	private double pris;
	private boolean frokost;
	private ArrayList<Ledsager> ledsagere;

	public Udflugt(String lokation, LocalDate dato, double pris, boolean frokost) {
		this.lokation = lokation;
		this.dato = dato;
		this.pris = pris;
		this.frokost = frokost;
	}

	public double getPris() {
		return this.pris;
	}

	public LocalDate getDato() {
		return this.dato;
	}

	public String getLokation() {
		return this.lokation;
	}

	public ArrayList<Ledsager> getLedsager() {
		return new ArrayList<Ledsager>();
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public void setDato(LocalDate dato) {
		this.dato = dato;
	}

	public void setFrokost(boolean frokost) {
		this.frokost = frokost;
	}

	public void setLokation(String lokation) {
		this.lokation = lokation;
	}

	public void addLedsager(Ledsager ledsager) {
		this.ledsagere.add(ledsager);

	}
}
