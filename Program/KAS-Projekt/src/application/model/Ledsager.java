package application.model;

import java.util.ArrayList;

public class Ledsager {
	private String navn;
	private ArrayList<Udflugt> udflugter;

	public Ledsager(String navn) {
		this.navn = navn;
		this.udflugter = new ArrayList<>();
	}

	public double beregnPris() {
		double samletPris = 0;
		if (this.udflugter.size() > 0) {
			for (Udflugt udflugt : this.udflugter) {
				samletPris += udflugt.getPris();

			}
		}
		return samletPris;
	}

}
