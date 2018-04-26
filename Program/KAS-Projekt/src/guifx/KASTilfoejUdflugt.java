package guifx;

import java.time.LocalDate;

import application.model.Konference;
import application.model.Udflugt;
import application.service.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KASTilfoejUdflugt extends Stage {

	private Konference konference;

	public KASTilfoejUdflugt(Konference konference) {
		this.konference = konference;
		this.setTitle("Opret Udflugt");
		GridPane gridPane = new GridPane();
		this.initContent(gridPane);

		Scene scene = new Scene(gridPane);
		this.setScene(scene);
	}

	Image KASkassen = new Image("File:resources/Kaskas.png");
	Label lblNavn, lblPris, lblDato, lblUdflugt;
	Button btnOK, btnCancel;
	TextField txfNavn, txfDato, txfPris;
	DatePicker dpDato;
	ListView<Udflugt> lvwUdflugt;
	CheckBox frokost;

	public void initContent(GridPane gridPane) {
		gridPane.setPadding(new Insets(10));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		ImageView KASkas = new ImageView(GUITools.kasKas());
		GridPane.setValignment(KASkas, VPos.TOP);
		GridPane.setHalignment(KASkas, HPos.RIGHT);
		gridPane.add(KASkas, 2, 0, 1, 2);

		lblUdflugt = new Label("Udflugter");
		gridPane.add(lblUdflugt, 0, 0);

		lvwUdflugt = new ListView<>();
		lvwUdflugt.setMaxHeight(150);
		gridPane.add(lvwUdflugt, 0, 1, 1, 5);
		lvwUdflugt.getItems().addAll(Service.getUdflugter(konference));

		lblNavn = new Label("Udflugtsnavn");
		gridPane.add(lblNavn, 1, 0);

		txfNavn = GUITools.stdTextField();
		GridPane.setValignment(txfNavn, VPos.TOP);
		gridPane.add(txfNavn, 1, 1);

		lblDato = new Label("Dato");
		gridPane.add(lblDato, 1, 2);

		dpDato = new DatePicker(LocalDate.now());
		dpDato.setMaxWidth(150);
		gridPane.add(dpDato, 1, 3);

		lblPris = new Label("Pris");
		gridPane.add(lblPris, 2, 2);

		txfPris = GUITools.stdTextField();
		gridPane.add(txfPris, 2, 3);

		frokost = new CheckBox();
		frokost.setText("Frokost");
		gridPane.add(frokost, 1, 4);

		btnOK = GUITools.stdButton("OK");
		gridPane.add(btnOK, 1, 5);
		GridPane.setValignment(btnOK, VPos.BOTTOM);
		btnOK.setOnAction(event -> this.tilfoejAction());

		btnCancel = GUITools.stdButton("Annuller");
		gridPane.add(btnCancel, 2, 5);
		GridPane.setValignment(btnCancel, VPos.BOTTOM);
		btnCancel.setOnAction(event -> this.close());

	}

	private void tilfoejAction() {
		Alert alert;
		try {
			double pris = Double.parseDouble(txfPris.getText());
			Service.createUdflugt(konference, txfNavn.getText(), dpDato.getValue(), pris, frokost.isSelected());
			this.close();
		} catch (NumberFormatException e) {
			// TODO: handle exception
			alert = new Alert(AlertType.ERROR);
			alert.setContentText("Pris skal være et tal");
		}
	}
}
