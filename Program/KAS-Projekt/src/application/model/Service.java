package application.model;

public class Service {
	private String serviceNavn;
	private String serviceBeskrivelse;
	private double servicePris;

	Service(String serviceNavn, String serviceBeskrivelse, double servicePris) {
		// TODO Auto-generated constructor stub
		this.serviceNavn = serviceNavn;
		this.serviceBeskrivelse = serviceBeskrivelse;
		this.servicePris = servicePris;
	}

	public String getServiceBeskrivelse() {
		return serviceBeskrivelse;
	}

	public String getServiceNavn() {
		return serviceNavn;
	}

	public double getServicePris() {
		return servicePris;
	}

	public void setServiceBeskrivelse(String serviceBeskrivelse) {
		this.serviceBeskrivelse = serviceBeskrivelse;
	}

	public void setServiceNavn(String serviceNavn) {
		this.serviceNavn = serviceNavn;
	}

	public void setServicePris(double servicePris) {
		this.servicePris = servicePris;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.serviceNavn + ": " + this.servicePris;
	}
}
