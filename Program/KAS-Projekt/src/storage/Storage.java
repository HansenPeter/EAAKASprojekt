package storage;

import java.time.LocalDate;
import java.util.ArrayList;

import application.model.Beboelse;
import application.model.Deltager;
import application.model.Konference;
import application.model.Ledsager;
import application.model.Organisation;
import application.model.Tilmelding;
import application.model.Udflugt;
import application.service.Service;

public class Storage {
	private static ArrayList<Beboelse> beboelser = new ArrayList<>();
	private static ArrayList<Deltager> deltagere = new ArrayList<>();
	private static ArrayList<Organisation> organisations = new ArrayList<>();
	private static ArrayList<Konference> konferencer = new ArrayList<>();

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

	// -----Konferencer----- //
	public static void addKonference(Konference konference) {
		konferencer.add(konference);
	}

	public static ArrayList<Konference> getKonferencer() {
		return new ArrayList<>(konferencer);
	}

	public static ArrayList<Konference> getSpecifikkeKonferencer(Organisation organisation) {
		return new ArrayList<>(organisation.getKonferencer());
	}

	public static void removeKonference(Konference konference) {
		konferencer.remove(konference);
	}

	// ---------------------------------------------------------------------------------------------------
	// init content

	public static void initContent() {
		Organisation odense = Service.createOrganisation("Odense Universitet");
		Konference havOgHimmel = Service.createKonference(odense, LocalDate.of(2018, 05, 18),
				LocalDate.of(2018, 05, 20), "Odense Universitet", "Hav og Himmel", "Miljø", 1500);
		Konference hyggeligheden = Service.createKonference(odense, LocalDate.of(2018, 04, 30),
				LocalDate.of(2018, 05, 10), "Smilets By", "Hyggeligheden", "Godt humør", 115);
		Udflugt egeskov = havOgHimmel.createUdflugt("Egeskov", LocalDate.of(2018, 05, 19), 75, false);
		Udflugt bytur = havOgHimmel.createUdflugt("Bytur, Odense", LocalDate.of(2018, 05, 18), 125, true);
		Udflugt hyggeligeStunder = hyggeligheden.createUdflugt("Hyggelige stunder", LocalDate.of(2018, 05, 18), 125,
				true);
		Beboelse hoetelPhoenix = new Beboelse("Hoetel Phoenix", 700, 800);
		application.model.Service phoenixBad = hoetelPhoenix.createService("Bad", "Dejligt bad", 200);
		Beboelse denHvideSvane = new Beboelse("Den Hvide Svane", 1050, 1250);
		application.model.Service phoenixWiFi = hoetelPhoenix.createService("Wi-Fi", "Det er lynlangsomt", 75);
		havOgHimmel.addBeboelse(hoetelPhoenix);
		application.model.Service svaneWiFi = denHvideSvane.createService("Wi-Fi", "50/10 forbindelse", 50);
		havOgHimmel.addBeboelse(denHvideSvane);
		
		Deltager d1 = Service.createDeltager("Peter", "Baunehoej", "Esbjerg", "Sverige", "888");
		Tilmelding tilmelding1 = Service.createTilmelding(d1, havOgHimmel, LocalDate.now(), LocalDate.now().plusDays(2), true);
		Ledsager jens = tilmelding1.createLedsager("Jens");
		jens.addUdflugt(bytur);
		jens.addUdflugt(egeskov);
		tilmelding1.createBooking(denHvideSvane);
		
		Deltager d2 = Service.createDeltager("Camina", "Paa en lille oe", "Meget taet ved Aekvator", "Sverige", "777");
		Tilmelding tilmelding2 = Service.createTilmelding(d2, hyggeligheden, LocalDate.now(), LocalDate.now().plusDays(1), false);
		Ledsager carlos = tilmelding2.createLedsager("Carlos");
		carlos.addUdflugt(hyggeligeStunder);
		
		

	}
}