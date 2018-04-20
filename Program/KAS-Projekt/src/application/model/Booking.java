package application.model;

import java.util.ArrayList;

public class Booking {
	private boolean isDoubleRoom;
	ArrayList<Service> servicesValgt;
	private Beboelse beboelse;

	Booking(boolean isDoubleRoom, Beboelse beboelse, ArrayList<Service> services) {
		this.isDoubleRoom = isDoubleRoom;
		this.beboelse = beboelse;
		servicesValgt = new ArrayList<>(services);
	}
	Booking(boolean isDoubleRoom, Beboelse beboelse) {
		this.isDoubleRoom = isDoubleRoom;
		this.beboelse = beboelse;
		servicesValgt = new ArrayList<>();
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
