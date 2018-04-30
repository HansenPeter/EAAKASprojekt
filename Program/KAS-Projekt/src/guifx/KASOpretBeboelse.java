package guifx;

import application.model.Konference;
import application.service.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KASOpretBeboelse extends Stage {

	public KASOpretBeboelse(Konference konference) {
		this.konference = konference;
		this.setTitle("Opret Beboelse");
		GridPane gridPane = new GridPane();
		this.initContent(gridPane);

		Scene scene = new Scene(gridPane);
		this.setScene(scene);

	}

	private Konference konference;
	ImageView KASKas;
	Label lblNavn, lblPrisEnkelt, lblPrisDobbelt;
	Button btnOK, btnCancel;
	TextField txfNavn, txfEnkelt, txfDobblet;

	public void initContent(GridPane gridPane) {
		gridPane.setPadding(new Insets(10));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		KASKas = new ImageView(GUITools.kasKas());
		GridPane.setHalignment(KASKas, HPos.RIGHT);
		gridPane.add(KASKas, 1, 0, 1, 2);

		lblNavn = new Label("Navn:");
		gridPane.add(lblNavn, 0, 0);

		txfNavn = GUITools.stdTextField();
		gridPane.add(txfNavn, 0, 1);

		lblPrisEnkelt = new Label("Pris for enkeltvaerelse");
		gridPane.add(lblPrisEnkelt, 0, 2);

		txfEnkelt = GUITools.stdTextField();
		gridPane.add(txfEnkelt, 0, 3);

		lblPrisDobbelt = new Label("Pris for dobbelvaerelse");
		gridPane.add(lblPrisDobbelt, 1, 2);

		txfDobblet = GUITools.stdTextField();
		gridPane.add(txfDobblet, 1, 3);

		btnOK = GUITools.stdButton("Okay");
		gridPane.add(btnOK, 0, 4);

		btnCancel = GUITools.stdButton("Annuller");
		gridPane.add(btnCancel, 1, 4);

		btnOK.setOnAction(event -> this.okAction());
		btnCancel.setOnAction(event -> this.close());

	}

	private void okAction() {
		String name = txfNavn.getText().trim();
		String prisEnkelt = txfEnkelt.getText().trim();
		String prisDobbelt = txfDobblet.getText().trim();

		if (name.length() > 0) {
			try {
				double enkelt = Double.parseDouble(prisEnkelt);
				double dobbelt = Double.parseDouble(prisDobbelt);
				Service.addBeboelseToKonference(konference, txfNavn.getText(), enkelt, dobbelt);
				this.close();
			} catch (NumberFormatException e) {
				Alert a1 = new Alert(Alert.AlertType.ERROR);
				a1.setTitle("Error");
				a1.setContentText("Udfyld venligst priser med tal");
				a1.showAndWait();

			}
		} else {
			Alert nameAlert = new Alert(Alert.AlertType.ERROR);
			nameAlert.setTitle("Error");
			nameAlert.setContentText("Udfyld venligst navn");
		}
	}
}
