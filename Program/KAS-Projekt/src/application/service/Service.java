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
import storage.Storage;

public class Service {

	public static Deltager createDeltager(String navn, String adresse, String by, String land, long tlfnr) {
		Deltager deltager = new Deltager(navn, adresse, by, land, tlfnr);
		Storage.addDeltager(deltager);
		
		return deltager;
	}

	public static Deltager createDeltager(String navn, String firmanavn, String adresse, String by, String land, long tlfnr, long firmatlfnr) {
		Deltager deltager = new Deltager(navn, firmanavn, adresse, by, land, tlfnr, firmatlfnr);
		Storage.addDeltager(deltager);
		
		return deltager;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------

	
	public static Tilmelding createTilmelding(Deltager deltager, Konference konference, LocalDate ankomstdato, LocalDate afrejsedato, boolean foredragsholder) {
		Tilmelding tilmelding = deltager.opretTilmelding(konference, ankomstdato, afrejsedato, foredragsholder);
		deltager.addTilmelding(tilmelding);
		Storage.addTilmelding(tilmelding);
		
		return tilmelding;
		
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------

	public static Booking createBooking(Tilmelding tilmelding, ArrayList<application.model.Service> services, Beboelse beboelse) {
		Booking booking = tilmelding.createBooking(services, beboelse);
		beboelse.addBooking(booking);
		Storage.addBooking(booking);
		return booking;
	}
	//---------------------------------------------------------------------------------------------------------------------------------------
	
	public static Beboelse createBeboelse(String name, double prisEnkeltvaerelse, double prisDobbeltvaerelse) {
		Beboelse beboelse = new Beboelse(name, prisEnkeltvaerelse, prisDobbeltvaerelse);
		Storage.addBeboelse(beboelse);
		return beboelse;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------
	
	public static Ledsager createLedsager(Tilmelding tilmelding, String navn) {
		Ledsager ledsager = tilmelding.createLedsager(navn);
		tilmelding.setLedsager(ledsager);
		Storage.addLedsager(ledsager);
		return ledsager;
	}
	//---------------------------------------------------------------------------------------------------------------------------------------
	
	public static Organisation createOrganisation(String navn) {
		Organisation organisation = new Organisation(navn);
		Storage.addOrganisation(organisation);
		return organisation;
	}
	//---------------------------------------------------------------------------------------------------------------------------------------
	
	public static Konference createKonference(Organisation organisation, LocalDate dato, String lokation, String navn, String tema, double pris) {
		Konference konference = organisation.createKonference(dato, lokation, navn, tema, pris);
		organisation.addKonference(konference);
		Storage.addKonference(konference);
		return konference;
	}
	
	
	
}
