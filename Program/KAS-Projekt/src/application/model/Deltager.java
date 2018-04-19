package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Deltager {
	private String navn;
	private String firmanavn;
	private String adresse;
	private String by;
	private String land;
	private long tlfnr;
	private long firmatlfnr;
	private ArrayList<Tilmelding> tilmeldinger;

	public Deltager(String navn, String firmanavn, String adresse, String by, String land, long tlfnr,
			long firmatlfnr) {
		// TODO Auto-generated constructor stub

		this.navn = navn;
		this.firmanavn = firmanavn;
		this.adresse = adresse;
		this.by = by;
		this.land = land;
		this.tlfnr = tlfnr;
		this.firmatlfnr = firmatlfnr;
		this.tilmeldinger = new ArrayList<Tilmelding>();
	}
	
	public Deltager(String navn, String adresse, String by, String land, long tlfnr) {
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

	public long getFirmatlfnr() {
		return firmatlfnr;
	}

	public String getLand() {
		return land;
	}

	public ArrayList<Tilmelding> getTilmeldinger() {
		return new ArrayList<>(tilmeldinger);
	}

	public long getTlfnr() {
		return tlfnr;
	}

	public Tilmelding opretTilmelding(Konference konference, LocalDate ankomstdato, LocalDate afrejsedato,
			boolean foredragsholder) {
		// TODO færdiggør denne når du har Tilmelding-Klassen
		Tilmelding tilmelding = new Tilmelding(this, konference, ankomstdato, afrejsedato, foredragsholder);
		this.tilmeldinger.add(tilmelding);
		return tilmelding;
	}

	public void fjernTilmelding(Tilmelding tilmelding) {
		// TODO Auto-generated method stub
		this.tilmeldinger.remove(tilmelding);
	}


	
	
	
	
}
