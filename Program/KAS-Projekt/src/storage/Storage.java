package storage;

import java.util.ArrayList;

import application.model.Beboelse;
import application.model.Deltager;
import application.model.Organisation;


public class Storage {
	private static ArrayList<Beboelse> beboelser = new ArrayList<>();
	private static ArrayList<Deltager> deltagere = new ArrayList<>();
	private static ArrayList<Organisation> organisations = new ArrayList<Organisation>();

	// ----Beboelse----//

	public static ArrayList<Beboelse> getBeboelses() {
		return new ArrayList<>(beboelser);
	}

	public static void addBeboelse(Beboelse beboelse) {
		beboelser.add(beboelse);
	}

	public static void removeBeboelse(Beboelse beboelse) {
		beboelser.remove(beboelse);
	}
	// ----Deltager----//

	public static ArrayList<Deltager> getDeltagers() {
		return new ArrayList<>(deltagere);
	}

	public static void addDeltager(Deltager deltager) {
		deltagere.add(deltager);
	}

	public static void removeDeltager(Deltager deltager) {
		deltagere.remove(deltager);
	}
		// ----Organisation----//

	public static ArrayList<Organisation> getOrganisations() {
		return new ArrayList<>(organisations);
	}

	public static void addOrganisation(Organisation organisation) {
		organisations.add(organisation);
	}

	public static void removeOrganisation(Organisation organisation) {
		organisations.remove(organisation);
	}
}