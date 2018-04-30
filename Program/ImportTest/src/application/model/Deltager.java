//Gruppe 1: Madeleine, Peter og Torben

package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Deltager {
	private String navn;
	private String firmanavn;
	private String adresse;
	private String by;
	private String land;
	private String tlfnr;
	private String firmatlfnr;
	private ArrayList<Tilmelding> tilmeldinger;
	

	public Deltager(String navn, String firmanavn, String adresse, String by, String land, String tlfnr,
			String firmatlfnr) {
		this.navn = navn;
		this.firmanavn = firmanavn;
		this.adresse = adresse;
		this.by = by;
		this.land = land;
		this.tlfnr = tlfnr;
		this.firmatlfnr = firmatlfnr;
		this.tilmeldinger = new ArrayList<Tilmelding>();
	}
	
	public Deltager(String navn, String adresse, String by, String land, String tlfnr) {
		this.navn = navn;
		this.adresse = adresse;
		this.by = by;
		this.land = land;
		this.tlfnr = tlfnr;
		this.tilmeldinger = new ArrayList<Tilmelding>();
	}

	public String getNavn() {
		return navn;
	}

	public String getFirmanavn() {
		return firmanavn;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getBy() {
		return by;
	}

	public String getFirmatlfnr() {
		return firmatlfnr;
	}

	public String getLand() {
		return land;
	}

	public ArrayList<Tilmelding> getTilmeldinger() {
		return new ArrayList<>(tilmeldinger);
	}

	public String getTlfnr() {
		return tlfnr;
	}

	public Tilmelding createTilmelding(Konference konference, LocalDate ankomstdato, LocalDate afrejsedato,
			boolean foredragsholder) {
		Tilmelding tilmelding = new Tilmelding(this, konference, ankomstdato, afrejsedato, foredragsholder);
		return tilmelding;
	}
	
	public void addTilmelding(Tilmelding tilmelding) {
		this.tilmeldinger.add(tilmelding);
	}

	public void fjernTilmelding(Tilmelding tilmelding) {
		this.tilmeldinger.remove(tilmelding);
	}
	
	public String toString() {
		return navn;
	}
	
}
