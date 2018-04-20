package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import application.model.Beboelse;
import application.model.Booking;
import application.model.Deltager;
import application.model.Konference;
import application.model.Ledsager;
import application.model.Organisation;
import application.model.Service;
import application.model.Tilmelding;
import application.model.Udflugt;

class ModelTest {
	static double dyrt = 100.0;
	private static Organisation o1 = new Organisation("navn");
	private static Konference k1 = o1.createKonference(LocalDate.now(), LocalDate.now().plusDays(2), "Odense", "Miljï¿½", "Olie", dyrt);
	private static Deltager d1 = new Deltager("navn", "vej", "by", "landsbay", "0");
	private static Tilmelding t1 = d1.opretTilmelding(k1, LocalDate.now(), LocalDate.now(), true);
	private static Tilmelding t2 = d1.opretTilmelding(k1, LocalDate.now(), LocalDate.now(), false);
	private static Ledsager l1 = t2.createLedsager("Morten");
	private static Beboelse b1 = new Beboelse("bullShit Hotel", 100.0, 150.0);
	private static Service s1 = b1.createService("TV", "se tv - jeps", dyrt / 2);
	private static Service s2 = b1.createService("netflix", "se netflix", dyrt * 3);

	
	void testBeboelseGetPris() {
		ArrayList<Service> ss1 = new ArrayList<>();
		ArrayList<Service> ss2 = new ArrayList<>();

		t2.setLedsager(l1);
		ss1.add(s1);
		Booking singleBook = t1.createBooking(ss1, b1);
		Booking doubleBook = t2.createBooking(ss2, b1);

		double expectedPris = 100.0;
		assertEquals(expectedPris, b1.getPris(singleBook));

		expectedPris = 150.0;
		assertEquals(expectedPris, b1.getPris(doubleBook));
	}

	
	void testBookingBeregnPris() {

		ArrayList<Service> ss1 = new ArrayList<>();
		ArrayList<Service> ss2 = new ArrayList<>();
		t2.setLedsager(l1);
		Booking singleBook = t1.createBooking(ss1, b1);
		Booking doubleBook = t2.createBooking(ss2, b1);

		double expectedPris = 100.0;

		assertEquals(expectedPris, singleBook.beregnPris());
		expectedPris = 150.0;
		assertEquals(expectedPris, doubleBook.beregnPris());

		singleBook.addService(s1);
		singleBook.addService(s2);
		expectedPris = 300 + 50 + 100;
		assertEquals(expectedPris, singleBook.beregnPris());

	}

	
	void tilmeldingBeregnSamletPris() {
		ArrayList<Service> ss1 = new ArrayList<>();

		t2.setLedsager(l1);
		Booking doubleBook = t2.createBooking(ss1, b1);
		t2.setBooking(doubleBook);

		doubleBook.addService(s1);
		doubleBook.addService(s2);

		Udflugt u1 = k1.createUdflugt("Her", LocalDate.now(), dyrt * 2, false);
		Udflugt u2 = k1.createUdflugt("Der", LocalDate.now(), dyrt / 2, true);

		l1.addUdflugt(u1);
		l1.addUdflugt(u2);
		double expectedPris = 850;
		assertEquals(expectedPris, t2.beregnSamletPris());

	}
	
	@Test
	void havOgHimmel() {
		Organisation organisation = new Organisation("The Syndicate");
		LocalDate startDato = LocalDate.of(2018, 05, 18);
		LocalDate slutDato = LocalDate.parse("2018-05-20");
		
		Konference havOgHimmel = organisation.createKonference(startDato, slutDato, "Odense Universitet", "Hav og Himmel", "Miljø", 1500);
		Deltager finnMadsen = new Deltager("Finn Madsen", "Sammen med sin bror", "Vejle", "Danmark", "12345678");
		Deltager nielsPetersen = new Deltager("Niels Petersen", "Alene", "Stavtrup", "Danmark", "87654321");
		Deltager peterSommer = new Deltager("Peter Sommer", "8660", "Skanderborg", "Danmark", "86608660");
		Deltager loneJensen = new Deltager("Lone Jensen", "Sammen med Felix", "Gentofte", "Mozambique", "0025854867956"); 
		Beboelse hoetelPhoenix = new Beboelse("Hoetel Phoenix", 700, 800);
		Beboelse denHvideSvane = new Beboelse("Den Hvide Svane", 1050, 1250);
		Beboelse pensionTusindfryd = new Beboelse("Pension Tusindfryd", 500, 600);
		Service swanFi = denHvideSvane.createService("Wi-Fi", "Det er langsomt, men dyrt", 50);
		Service phoenixFi = hoetelPhoenix.createService("Wi-Fi", "Det er ikke helt så langsomt, men dyrere", 75);
		Service phoenixShower = hoetelPhoenix.createService("Bad", "Et UTROLIGT dyrt bad", 200);
		Service tusindfrydMad = pensionTusindfryd.createService("Maaj", "Morgenmaaj", 100);
		Udflugt byrundturIOdense = havOgHimmel.createUdflugt("Odense by", LocalDate.of(2018, 05, 18), 125, true);
		Udflugt egeskov = havOgHimmel.createUdflugt("På Egeskov", LocalDate.parse("2018-05-19"), 75, false);
		Udflugt trapholtMuseum = havOgHimmel.createUdflugt("Kolding", LocalDate.of(2018, 05, 20), 200, true);
		
		Tilmelding tFinn = finnMadsen.opretTilmelding(havOgHimmel, startDato, slutDato, false);
		Tilmelding tNiels = nielsPetersen.opretTilmelding(havOgHimmel, startDato, slutDato, false);
		tNiels.createBooking(denHvideSvane);
		
		Tilmelding tPeter = peterSommer.opretTilmelding(havOgHimmel, startDato, slutDato, false);
		Ledsager mieSommer = tPeter.createLedsager("Mie Sommer");
		mieSommer.addUdflugt(trapholtMuseum);
		mieSommer.addUdflugt(egeskov);
		
		Booking bookingtPeter = tPeter.createBooking( denHvideSvane);
		bookingtPeter.addService(swanFi);
		
		Tilmelding tLone = loneJensen.opretTilmelding(havOgHimmel, startDato, slutDato, true);
		Ledsager janMadsen = tLone.createLedsager("Jan Madsen");
		janMadsen.addUdflugt(byrundturIOdense);
		janMadsen.addUdflugt(egeskov);
		
		Booking bookingtLone = tLone.createBooking( denHvideSvane);
		bookingtLone.addService(swanFi);
		
		double tFinnExpected = 4500;
		double tNielsExpected = 6600;
		double tPeterExpected = 7375;
		double tLoneExpected = 2800;
		
		assertEquals(tFinnExpected,tFinn.beregnSamletPris());
		assertEquals(tNielsExpected,tNiels.beregnSamletPris());
		assertEquals(tPeterExpected,tPeter.beregnSamletPris());
		assertEquals(tLoneExpected,tLone.beregnSamletPris());
				
		
		
		
		
		
	}

}
