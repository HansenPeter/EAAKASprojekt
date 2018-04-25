package application.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Tilmelding {
	private Deltager deltager;
	private Konference konference;
	private LocalDate ankomstdato;
	private LocalDate afrejsedato;
	private Ledsager ledsager;
	private Booking booking;
	private boolean foredragsholder;
	private int konferenceDage;

	Tilmelding(Deltager deltager, Konference konference, LocalDate ankomstdato, 
			LocalDate afrejsedato, Boolean foredragsholder) {
		this.deltager = deltager;
		this.konference = konference;
		this.ankomstdato = ankomstdato;
		this.afrejsedato = afrejsedato;
		this.foredragsholder = foredragsholder;
		this.konferenceDage = (int) ChronoUnit.DAYS.between(ankomstdato,afrejsedato) + 1;
		
		
	}

	public Booking getBooking() {
		return booking;
	}

	public Deltager getDeltager() {
		return deltager;
	}

	public Konference getKonference() {
		return konference;
	}

	public Ledsager getLedsager() {
		return ledsager;
	}

	public LocalDate getAfrejsedato() {
		return afrejsedato;
	}

	public LocalDate getAnkomstdato() {
		return ankomstdato;
	}

	public void setAfrejsedato(LocalDate afrejsedato) {
		this.afrejsedato = afrejsedato;
	}

	public void setAnkomstdato(LocalDate ankomstdato) {
		this.ankomstdato = ankomstdato;
	}

	public void setDeltager(Deltager deltager) {
		this.deltager = deltager;
	}

	public void setForedragsholder(boolean foredragsholder) {
		this.foredragsholder = foredragsholder;
	}

	public boolean isForedragsholder() {
		return foredragsholder;
	}

	public void setKonference(Konference konference) {
		this.konference = konference;
	}

	public void setLedsager(Ledsager ledsager) {
		this.ledsager = ledsager;
	}

	public double beregnSamletPris() {
		double samletPris = 0;
		
		if(booking != null) {
			samletPris += this.booking.beregnPris() * (konferenceDage-1);
		}
		
		if (ledsager != null) {
			samletPris += this.ledsager.beregnPris();
		}
		
		
		if(!this.isForedragsholder()) {
			samletPris += this.konference.getPris() * (konferenceDage);
		}
		
		return samletPris;
	}

	public Ledsager createLedsager(String navn) {
		Ledsager ledsager = new Ledsager(navn);
		this.ledsager = ledsager;
		return ledsager;
	}
	
	public Booking createBooking(ArrayList<Service> services, Beboelse beboelse) {
		Booking booking = new Booking(isDouble(), beboelse, services);
		this.booking = booking;
		return booking;
	}
	
	public Booking createBooking(Beboelse beboelse) {
		Booking booking = new Booking(isDouble(), beboelse);
		this.booking = booking;
		return booking;
	}

	public boolean isDouble() {
		if (this.ledsager != null) {
			return true;
		} else {
			return false;
		}
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	

}
