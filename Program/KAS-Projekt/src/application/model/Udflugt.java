package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udflugt {
	private String name;
	private LocalDate dato;
	private double pris;
	private boolean frokost;
	private ArrayList<Ledsager> ledsagere = new ArrayList<>();

	Udflugt(String name, LocalDate dato, double pris, boolean frokost) {
		this.name = name;
		this.dato = dato;
		this.pris = pris;
		this.frokost = frokost;
	}

	public boolean isFrokost() {
		return frokost;
	}

	public double getPris() {
		return this.pris;
	}

	public LocalDate getDato() {
		return this.dato;
	}

	public String getName() {
		return this.name;
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

	public void setName(String name) {
		this.name = name;
	}

	void addLedsager(Ledsager ledsager) {
		this.ledsagere.add(ledsager);
	}

	public void removeLedsager(Ledsager ledsager) {
		this.ledsagere.remove(ledsager);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
