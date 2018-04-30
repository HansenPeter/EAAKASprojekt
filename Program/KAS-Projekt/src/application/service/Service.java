//Gruppe 1: Madeleine, Peter og Torben

package application.service;

import java.time.LocalDate;
import java.util.ArrayList;

import application.model.Beboelse;
import application.model.Booking;
import application.model.Deltager;
import application.model.Konference;
import application.model.Ledsager;
import application.model.Organisation;
import application.model.Tilmelding;
import application.model.Udflugt;
import storage.Storage;

public class Service {

	public static Deltager createDeltager(String navn, String adresse, String by, String land, String tlfnr) {
		Deltager deltager = new Deltager(navn, adresse, by, land, tlfnr);
		Storage.addDeltager(deltager);
		return deltager;
	}

	public static ArrayList<Deltager> getDeltagere() {
		return Storage.getDeltagers();
	}

	public static Deltager createDeltager(String navn, String firmanavn, String adresse, String by, String land,
			String tlfnr, String firmatlfnr) {
		Deltager deltager = new Deltager(navn, firmanavn, adresse, by, land, tlfnr, firmatlfnr);
		Storage.addDeltager(deltager);
		return deltager;
	}

	public static void removeDeltager(Deltager deltager) {
		for (Tilmelding tilmelding : deltager.getTilmeldinger()) {
			tilmelding.getKonference().removeTilmelding(tilmelding);
			removeLedsager(tilmelding);
		}
		Storage.removeDeltager(deltager);
	}

	public static Deltager getDeltager(String tlfnr) {
		for (Deltager deltager : Storage.getDeltagers()) {
			if (tlfnr.equals(deltager.getTlfnr())) {
				return deltager;
			}
		}
		return null;
	}

	public static ArrayList<String> getDeltagere(Konference konference) {
		ArrayList<String> deltagere = new ArrayList<String>();
		
		for (Tilmelding tilmelding : konference.getTilmeldinger()) {
			String deltagerStreng = "";
			if (tilmelding.getLedsager() != null) {
				deltagerStreng += tilmelding.getDeltager().getNavn() + " & " + tilmelding.getLedsager().getNavn();
			} else {
				deltagerStreng += tilmelding.getDeltager().getNavn();
			}
			
			if(tilmelding.getDeltager().getFirmanavn() != null) {
				deltagerStreng += ", Firma: " + tilmelding.getDeltager().getFirmanavn() + ".";
			}
				
			deltagere.add(deltagerStreng);
		}
		
		return deltagere;
	}

	public static void removeLedsager(Tilmelding tilmelding) {
		Ledsager ledsager = tilmelding.getLedsager();
		for (Udflugt udflugt : ledsager.getUdflugter()) {
			udflugt.removeLedsager(ledsager);
		}
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------

	public static Tilmelding createTilmelding(Deltager deltager, Konference konference, LocalDate ankomstdato,
			LocalDate afrejsedato, boolean foredragsholder) {
		Tilmelding tilmelding = deltager.createTilmelding(konference, ankomstdato, afrejsedato, foredragsholder);
		deltager.addTilmelding(tilmelding);
		konference.addTilmelding(tilmelding);
		return tilmelding;
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------

	public static Booking createBooking(Tilmelding tilmelding, ArrayList<application.model.Service> services,
			Beboelse beboelse) {
		Booking booking = tilmelding.createBooking(services, beboelse);
		return booking;
	}

	public static Booking createBooking(Tilmelding tilmelding, Beboelse beboelse) {
		Booking booking = tilmelding.createBooking(beboelse);
		return booking;
	}
	// ---------------------------------------------------------------------------------------------------------------------------------------

	public static Beboelse createBeboelse(String name, double prisEnkeltvaerelse, double prisDobbeltvaerelse) {
		Beboelse beboelse = new Beboelse(name, prisEnkeltvaerelse, prisDobbeltvaerelse);
		Storage.addBeboelse(beboelse);
		return beboelse;
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------

	public static Ledsager createLedsager(Tilmelding tilmelding, String navn) {
		Ledsager ledsager = tilmelding.createLedsager(navn);
		return ledsager;
	}
	// ---------------------------------------------------------------------------------------------------------------------------------------

	public static Organisation createOrganisation(String navn) {
		Organisation organisation = new Organisation(navn);
		Storage.addOrganisation(organisation);
		return organisation;
	}

	public static ArrayList<Organisation> getOrganisations() {
		return new ArrayList<>(Storage.getOrganisations());
	}
	// ---------------------------------------------------------------------------------------------------------------------------------------

	public static Konference createKonference(Organisation organisation, LocalDate startDato, LocalDate slutDato,
			String lokation, String navn, String tema, double pris) {
		Konference konference = organisation.createKonference(startDato, slutDato, lokation, navn, tema, pris);
		Storage.addKonference(konference);
		return konference;
	}

	public static ArrayList<Konference> getSpecifikkeKonferencer(Organisation organisation) {
		return Storage.getSpecifikkeKonferencer(organisation);
	}

	public static ArrayList<Konference> getKonferencer() {
		return Storage.getKonferencer();
	}

	public static LocalDate getKonferenceStartdato(Konference konference) {
		return konference.getStartDato();
	}

	public static LocalDate getKonferenceSlutdato(Konference konference) {
		return konference.getSlutDato();
	}

	public static Beboelse addBeboelseToKonference(Konference konference, String navn, double prisEnkelvaerelse,
			double prisDobbeltvaerelse) {
		Beboelse beboelse = new Beboelse(navn, prisEnkelvaerelse, prisDobbeltvaerelse);
		konference.addBeboelse(beboelse);
		Storage.addBeboelse(beboelse);
		return beboelse;
	}
	// ---------------------------------------------------------------------------------------------------------------------------------------

	public static Udflugt createUdflugt(Konference konference, String navn, LocalDate dato, double pris,
			boolean frokost) {
		Udflugt udflugt = konference.createUdflugt(navn, dato, pris, frokost);
		return udflugt;
	}

	public static ArrayList<Udflugt> getUdflugter(Konference konference) {
		return new ArrayList<>(konference.getUdflugter());
	}
	
	public static ArrayList<Ledsager> getUdflugtTilmeldte(Udflugt udflugt){
		return new ArrayList<>(udflugt.getLedsagere());
		
	}

	// --------------------------------------------------------------------------------------------------------------------

	public static double beregnSamletPris(Tilmelding tilmelding) {
		return tilmelding.beregnSamletPris();
	}

	public static String getKonferenceNavn(Tilmelding tilmelding) {
		return tilmelding.getKonference().getNavn();
	}

	public static void removeTilmelding(Tilmelding tilmelding) {
		// TODO Auto-generated method stub
		tilmelding.getDeltager().fjernTilmelding(tilmelding);
	}

	public static ArrayList<Beboelse> getBeboelser(Konference konference) {
		return new ArrayList<>(konference.getBeboelser());
	}

	public static ArrayList<application.model.Service> getServices(Beboelse beboelse) {
		return new ArrayList<>(beboelse.getServices());
	}

	public static application.model.Service addService(Beboelse beboelse, String navn, String beskrivelse,
			double pris) {

		application.model.Service service = beboelse.createService(navn, beskrivelse, pris);
		return service;
	}

	public static Boolean hasLedsager(Tilmelding tilmelding) {
		return tilmelding.getLedsager() != null;
	}

	public static Boolean hasOvernatning(Tilmelding tilmelding) {
		return tilmelding.getBooking() != null;
	}
}
