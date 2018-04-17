package application.model;

import java.util.ArrayList;

public class Beboelse {
	private ArrayList<Booking> bookings;
	private ArrayList<Service> services;
	private double prisEnkeltVærelse;
	private double prisDobbeltVærelse;
	private int ledigeEnkeltVærelser;
	private int ledigeDobbeltVærelser;

	public Beboelse(double prisEnkeltværelse, double prisDobbeltVærelse, int ledigeEnkeltVærelser,
			int ledigeDobbeltVærelser) {
		// TODO Auto-generated constructor stub
		this.bookings = new ArrayList<Booking>();
		this.services = new ArrayList<Service>();
		this.prisEnkeltVærelse = prisEnkeltværelse;
		this.prisDobbeltVærelse = prisDobbeltVærelse;
		this.ledigeEnkeltVærelser = ledigeDobbeltVærelser;
		this.ledigeDobbeltVærelser = ledigeDobbeltVærelser;
	}

	public ArrayList<Booking> getBookings() {
		return new ArrayList<>(bookings);
	}

	public ArrayList<Service> getServices() {
		return new ArrayList<>(services);
	}

	public int getLedigeEnkeltVærelser() {
		return ledigeEnkeltVærelser;
	}

	public int getLedigeDobbeltVærelser() {
		return ledigeDobbeltVærelser;
	}

	public double getPris(Booking booking) {
		if (booking.isDoubleRoom()) {
			return prisDobbeltVærelse;
		} else {
			return prisEnkeltVærelse;
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
