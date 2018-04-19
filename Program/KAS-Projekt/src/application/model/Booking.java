package application.model;

import java.util.ArrayList;

public class Booking {
	private int vaerelsesnr;
	private boolean isDoubleRoom;
	ArrayList<Service> servicesValgt;
	private Beboelse beboelse;

	public Booking(boolean isDoubleRoom, Beboelse beboelse) {
		// TODO Auto-generated constructor stub
		this.vaerelsesnr = (int) Math.random();
		this.isDoubleRoom = isDoubleRoom;
		this.beboelse = beboelse;
		servicesValgt = new ArrayList<Service>();
	}

	public int getVaerelsesnr() {
		return vaerelsesnr;
	}

	public Beboelse getBeboelse() {
		return beboelse;
	}

	public ArrayList<Service> getServicesValgt() {
		return servicesValgt;
	}

	public void addService(Service service) {
		this.servicesValgt.add(service);
	}

	public void removeService(Service service) {
		this.servicesValgt.remove(service);
	}

	public void setVaerelsesnr(int vaerelsesnr) {
		this.vaerelsesnr = vaerelsesnr;
	}

	public void setServicesValgt(ArrayList<Service> servicesValgt) {
		this.servicesValgt = servicesValgt;
	}

	public void setBeboelse(Beboelse beboelse) {
		this.beboelse = beboelse;
	}

	public void setDoubleRoom(boolean isDoubleRoom) {
		this.isDoubleRoom = isDoubleRoom;
	}

	public boolean isDoubleRoom() {
		return isDoubleRoom;
	}

	public double beregnPris() {
		double pris = 0;
		pris += beboelse.getPris(this);
		for (Service service : servicesValgt) {
			pris += service.getServicePris();
		}
		return pris;
	}
}
