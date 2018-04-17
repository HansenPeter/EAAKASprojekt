package application.model;

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

	public Deltager() {
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

	public Tilmelding opretTilmelding() {
		// TODO færdiggør denne når du har Tilmelding-Klassen
		Tilmelding tilmelding = new Tilmelding(this);
		this.tilmeldinger.add(tilmelding);
		return tilmelding;
	}

	private void fjernTilmelding(Tilmelding tilmelding) {
		// TODO Auto-generated method stub
		this.tilmeldinger.remove(tilmelding);
	}
}
