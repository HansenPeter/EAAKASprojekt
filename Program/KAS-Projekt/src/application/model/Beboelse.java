package application.model;

import java.util.ArrayList;

public class Beboelse {
	private String name;
	private ArrayList<Booking> bookings;
	private ArrayList<Service> services;
	private double prisEnkeltVaerelse;
	private double prisDobbeltVaerelse;


	public Beboelse(String name, double prisEnkeltvaerelse, double prisDobbeltVaerelse) {
		this.name = name;
		this.bookings = new ArrayList<Booking>();
		this.services = new ArrayList<Service>();
		this.prisEnkeltVaerelse = prisEnkeltvaerelse;
		this.prisDobbeltVaerelse = prisDobbeltVaerelse;
		
	}

	public String getName() {
		return name;
	}

	public ArrayList<Booking> getBookings() {
		return new ArrayList<>(bookings);
	}

	public ArrayList<Service> getServices() {
		return new ArrayList<>(services);
	}



	public double getPris(Booking booking) {
		if (booking.isDoubleRoom()) {
			return prisDobbeltVaerelse;
		} else {
			return prisEnkeltVaerelse;
		}
	}

	public Service createService(String serviceNavn, String serviceBeskrivelse, double servicePris) {
		Service service = new Service(serviceNavn, serviceBeskrivelse, servicePris);
		this.services.add(service);
		return service;
	}

	public void removeService(Service service) {
		this.services.remove(service);
	}
	
	public void addBooking(Booking booking) {
		this.bookings.add(booking);
	}
	
	public void removeBooking(Booking booking) {
		this.bookings.remove(booking);
	}

}
