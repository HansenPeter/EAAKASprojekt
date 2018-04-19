package application.model;

import java.util.ArrayList;

public class Beboelse {
	private ArrayList<Booking> bookings;
	private ArrayList<Service> services;
	private double prisEnkeltVaerelse;
	private double prisDobbeltVaerelse;
	private int ledigeEnkeltVaerelser;
	private int ledigeDobbeltVaerelser;

	public Beboelse(double prisEnkeltvaerelse, double prisDobbeltVaerelse, int ledigeEnkeltVaerelser,
			int ledigeDobbeltVaerelser) {
		// TODO Auto-generated constructor stub
		this.bookings = new ArrayList<Booking>();
		this.services = new ArrayList<Service>();
		this.prisEnkeltVaerelse = prisEnkeltvaerelse;
		this.prisDobbeltVaerelse = prisDobbeltVaerelse;
		this.ledigeEnkeltVaerelser = ledigeDobbeltVaerelser;
		this.ledigeDobbeltVaerelser = ledigeDobbeltVaerelser;
	}

	public ArrayList<Booking> getBookings() {
		return new ArrayList<>(bookings);
	}

	public ArrayList<Service> getServices() {
		return new ArrayList<>(services);
	}

	public int getLedigeEnkeltVaerelser() {
		return ledigeEnkeltVaerelser;
	}

	public int getLedigeDobbeltVaerelser() {
		return ledigeDobbeltVaerelser;
	}

	public double getPris(Booking booking) {
		if (booking.isDoubleRoom()) {
			return prisDobbeltVaerelse;
		} else {
			return prisEnkeltVaerelse;
		}
	}

	public Service createService(String serviceNavn, String serviceBeskrivelse, double servicePris) {
		// TODO Auto-generated method stub
		Service service = new Service(serviceNavn, serviceBeskrivelse, servicePris);
		this.services.add(service);
		return service;
	}

	public void removeService(Service service) {
		this.services.remove(service);
	}

}
