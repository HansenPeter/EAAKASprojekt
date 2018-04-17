package application.model;

import java.time.LocalDate;

public class Tilmelding {
	private Deltager deltager;
	private Konference konference;
	private LocalDate ankomstdato;
	private LocalDate afrejsedato;
	private Ledsager ledsager;
	private Booking booking;
	private boolean foredragsholder;

	public Tilmelding(Deltager deltager, Konference konference, LocalDate ankomstdato, String ledsagernavn,
			LocalDate afrejsedato, Boolean foredragsholder) {
		this.deltager = deltager;
		this.konference = konference;
		this.ankomstdato = ankomstdato;
		this.afrejsedato = afrejsedato;
		this.ledsager = createLedsager(ledsagernavn);
		this.foredragsholder = foredragsholder;
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
		return this.booking.beregnPris() + this.ledsager.beregnPris();
	}

	public Ledsager createLedsager(String navn) {
		Ledsager l = new Ledsager(navn);
		return l;
	}

	public boolean isDouble() {
		if (this.ledsager != null) {
			return true;
		} else {
			return false;
		}
	}

	public void setBooking(Beboelse beboelse) {
		this.booking = new Booking(this.isDouble(), beboelse);
	}

}
