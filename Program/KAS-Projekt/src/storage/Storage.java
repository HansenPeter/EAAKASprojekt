package storage;

import java.util.ArrayList;

import application.model.Beboelse;
import application.model.Booking;
import application.model.Deltager;
import application.model.Konference;
import application.model.Ledsager;
import application.model.Organisation;
import application.model.Service;
import application.model.Tilmelding;
import application.model.Udflugt;

public class Storage {
	private static ArrayList<Beboelse> beboelses = new ArrayList<>();
	private static ArrayList<Booking> bookings = new ArrayList<>();
	private static ArrayList<Deltager> deltagers = new ArrayList<>();
	private static ArrayList<Konference> konferences = new ArrayList<Konference>();
	private static ArrayList<Ledsager> ledsagers = new ArrayList<Ledsager>();
	private static ArrayList<Organisation> organisations = new ArrayList<Organisation>();
	private static ArrayList<Service> services = new ArrayList<Service>();
	private static ArrayList<Tilmelding> tilmeldings = new ArrayList<Tilmelding>();
	private static ArrayList<Udflugt> udflugts = new ArrayList<Udflugt>();

	// ----Beboelse----//

	public static ArrayList<Beboelse> getBeboelses() {
		return new ArrayList<>(beboelses);
	}

	public static void addBeboelse(Beboelse beboelse) {
		beboelses.add(beboelse);
	}

	public static void removeBeboelse(Beboelse beboelse) {
		beboelses.remove(beboelse);
	}
	// ----Booking----//

	public static ArrayList<Booking> getBookings() {
		return new ArrayList<>(bookings);
	}

	public static void addBooking(Booking booking) {
		bookings.add(booking);
	}

	public static void removeBooking(Booking booking) {
		bookings.remove(booking);
	}
	// ----Deltager----//

	public static ArrayList<Deltager> getDeltagers() {
		return new ArrayList<>(deltagers);
	}

	public static void addDeltager(Deltager deltager) {
		deltagers.add(deltager);
	}

	public static void removeDeltager(Deltager deltager) {
		deltagers.remove(deltager);
	}
	// ----Konference----//

	public static ArrayList<Konference> getKonferences() {
		return new ArrayList<>(konferences);
	}

	public static void addKonferense(Konference konference) {
		konferences.add(konference);
	}

	public static void removeKonferense(Konference konference) {
		konferences.remove(konference);
	}
	// ----Ledsager----//

	public static ArrayList<Ledsager> getLedsagers() {
		return new ArrayList<>(ledsagers);
	}

	public static void addLedsager(Ledsager ledsager) {
		ledsagers.add(ledsager);
	}

	public static void removeLedsager(Ledsager ledsager) {
		ledsagers.remove(ledsager);
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
	// ----Services----//

	public static ArrayList<Service> getServices() {
		return new ArrayList<>(services);
	}

	public static void addService(Service service) {
		services.add(service);
	}

	public static void removeService(Service service) {
		services.remove(service);
	}
	// ----Tilmelding----//

	public static ArrayList<Tilmelding> getTilmeldings() {
		return new ArrayList<>(tilmeldings);
	}

	public static void addTilmelding(Tilmelding tilmelding) {
		tilmeldings.add(tilmelding);
	}

	public static void removeTilmelding(Tilmelding tilmelding) {
		tilmeldings.remove(tilmelding);
	}
	// ----Udflugt----//

	public static ArrayList<Udflugt> getUdflugts() {
		return new ArrayList<>(udflugts);
	}

	public static void addUdflugt(Udflugt udflugt) {
		udflugts.add(udflugt);
	}

	public static void removeUdflugt(Udflugt udflugt) {
		udflugts.remove(udflugt);
	}
}
