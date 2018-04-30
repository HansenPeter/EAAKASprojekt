package guifx;

import java.util.ArrayList;

import application.model.Beboelse;
import application.model.Konference;
import application.model.Ledsager;
import application.model.Tilmelding;
import application.model.Udflugt;
import application.service.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KASDeltagerWindow extends Stage {
	private Label lblListenavn;
	private ImageView kaskas = new ImageView(GUITools.kasKas());
	private ListView<String> lvwListe;
	private ArrayList<String> alListeindhold = new ArrayList<>();
	private String listenavn;
	private Button btnClose;
	private GridPane gridPane = new GridPane();

	public KASDeltagerWindow(Konference konference) {		
		Scene scene = new Scene(gridPane);
		this.setScene(scene);
	}
	
	public KASDeltagerWindow(Konference konference, Udflugt udflugt) {
		this(konference);
		for(Ledsager ledsager : Service.getUdflugtTilmeldte(udflugt)) {
			alListeindhold.add(ledsager.getNavn());
		}
		this.listenavn = "Tilmeldte paa " + udflugt.getName();
		this.initContent(gridPane);
		this.setTitle(udflugt.getName());
	}
	
	public KASDeltagerWindow(Konference konference, Beboelse beboelse) {
		this(konference);
		for (Tilmelding tilmelding : konference.getTilmeldinger()) {
			if (tilmelding.getBooking() != null) {
				if(tilmelding.getBooking().getBeboelse() == beboelse) {
					if(tilmelding.getLedsager() != null) {
						alListeindhold.add(tilmelding.getDeltager().getNavn() + " & " + tilmelding.getLedsager().getNavn());					 
					} else {
					 alListeindhold.add(tilmelding.getDeltager().getNavn());
					}
				}
			}
		}
		
		this.listenavn = "Gaester paa " + beboelse.getName();
		this.initContent(gridPane);
		this.setTitle(beboelse.getName());
	}
	
	public KASDeltagerWindow(Konference konference, boolean isDeltagerListe) {
		this(konference);
		alListeindhold.addAll(Service.getDeltagere(konference));
		this.listenavn = "Deltagere paa konferencen " + konference.getNavn();
		this.initContent(gridPane);
		this.setTitle(konference.getNavn());
	}

	private void initContent(GridPane gridPane) {
		// TODO Auto-generated method stub
		gridPane.setPadding(new Insets(10));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		gridPane.add(kaskas, 1, 0, 2, 1);
		GridPane.setHalignment(kaskas, HPos.RIGHT);

		lblListenavn = new Label(listenavn);
		gridPane.add(lblListenavn, 0, 0);

		lvwListe = new ListView<>();
		lvwListe.getItems().setAll(alListeindhold);
		gridPane.add(lvwListe, 0, 1);

		btnClose = GUITools.stdButton("Close");
		gridPane.add(btnClose, 1, 2);
		btnClose.setOnAction(event -> this.close());
	}
}
