package test;



import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import application.model.*;


import org.junit.jupiter.api.Test;

class ModelTest {
	static double dyrt = 100.0;
	private static Organisation o1 = new Organisation("navn");
	private static Konference k1 = o1.createKonferance(LocalDate.now(), "Odense", "Miljø", "Olie",dyrt );
	private static Deltager d1 = new Deltager("navn", "vej", "by", "landsbay", 0);
	private static Tilmelding t1 = d1.opretTilmelding(k1, LocalDate.now(), LocalDate.now(), true);
	private static Tilmelding t2 = d1.opretTilmelding(k1, LocalDate.now(), LocalDate.now(), false);
	private static Ledsager l1 = t2.createLedsager("Morten");
	private static Beboelse b1 = new Beboelse("bullShit Hotel", 100.0, 150.0);
	private static Service s1 = b1.createService("TV", "se tv - jeps", dyrt/2);
	private static Service s2 = b1.createService("netflix", "se netflix", dyrt*3);

	
	
	@Test
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
	
	@Test
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
	
	@Test
	void tilmeldingBeregnSamletPris() {
		ArrayList<Service> ss1 = new ArrayList<>(); 
	 
		t2.setLedsager(l1);
		Booking doubleBook = t2.createBooking(ss1, b1);
		t2.setBooking(doubleBook);
	
		doubleBook.addService(s1);
		doubleBook.addService(s2);
		
		Udflugt u1 = k1.createUdflugt("Her", LocalDate.now(), dyrt*2, false);
		Udflugt u2 = k1.createUdflugt("Der", LocalDate.now(), dyrt/2, true);
		
		l1.addUdflugt(u1);
		l1.addUdflugt(u2);
		double expectedPris = 850;
		assertEquals(expectedPris, t2.beregnSamletPris());
		
		
	}
	
	
	

}
