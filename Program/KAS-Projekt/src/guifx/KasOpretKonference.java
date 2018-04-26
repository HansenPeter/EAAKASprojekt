package guifx;

import application.model.Beboelse;
import application.model.Organisation;
import application.model.Udflugt;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KasOpretKonference extends Stage {

	private Organisation organisation;

	public KasOpretKonference(Organisation organisation) {
		// TODO Auto-generated constructor stub
		this.organisation = organisation;
		setTitle("Opret Konference");
		GridPane gridPane = new GridPane();
		initContent(gridPane);

		Scene scene = new Scene(gridPane);
		setScene(scene);
	}

	Label lblBeboelser, lblUdflugter, lblNavn, lblStartDato, lblSlutDato, lblTema, lblLokation;
	ListView<Beboelse> lvwBeboelser;
	ListView<Udflugt> lvwUdflugter;
	Button btnAddBeboelse, btnAddServices, btnAddUdflugt, btnOK, btnCancel;
	TextField txfNavn, txfTema, txfLokation, txfStartDato, txfSlutDato;

	public void initContent(GridPane gridPane) {
		gridPane.setPadding(new Insets(10));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		lblNavn = new Label("Navn");
		gridPane.add(lblNavn, 0, 0);

		txfNavn = GUITools.stdTextField();
		gridPane.add(txfNavn, 0, 1);

		lblStartDato = new Label("Startdato");
		GridPane.setValignment(lblStartDato, VPos.BOTTOM);
		gridPane.add(lblStartDato, 0, 2);

		txfStartDato = GUITools.stdTextField();
		gridPane.add(txfStartDato, 0, 3);

		lblTema = new Label("Tema");
		gridPane.add(lblTema, 0, 4);

		txfTema = GUITools.stdTextField();
		gridPane.add(txfTema, 0, 5);

		btnOK = GUITools.stdButton("OK");
		gridPane.add(btnOK, 0, 7);

		gridPane.add(new ImageView(GUITools.kasKas()), 1, 0, 1, 2);

		lblSlutDato = new Label("SlutDato");
		GridPane.setValignment(lblSlutDato, VPos.BOTTOM);
		gridPane.add(lblSlutDato, 1, 2);

		txfSlutDato = GUITools.stdTextField();
		gridPane.add(txfSlutDato, 1, 3);

		lblLokation = new Label("Lokation");
		gridPane.add(lblLokation, 1, 4);

		txfLokation = GUITools.stdTextField();
		gridPane.add(txfLokation, 1, 5);

		btnCancel = GUITools.stdButton("Annuller");
		gridPane.add(btnCancel, 1, 7);
	}

}
