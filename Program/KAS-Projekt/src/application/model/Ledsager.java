package application.model;

import java.util.ArrayList;

public class Ledsager {
	private String navn;
	private ArrayList<Udflugt> udflugter;

	Ledsager(String navn) {
		this.setNavn(navn);
		this.udflugter = new ArrayList<>();
	}

	public double beregnPris() {
		double samletPris = 0;
		
			for (Udflugt udflugt : this.udflugter) {
				samletPris += udflugt.getPris();

			}
		
		return samletPris;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public void addUdflugt(Udflugt udflugt) {
		this.udflugter.add(udflugt);
		udflugt.addLedsager(this);
	}

}
