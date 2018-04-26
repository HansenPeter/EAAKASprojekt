package guifx;

import java.time.LocalDate;

import application.model.Organisation;
import application.service.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;

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

	private Label lblNavn, lblStartDato, lblSlutDato, lblTema, lblLokation, lblPris;
	private Button btnOK, btnCancel;
	private TextField txfNavn, txfTema, txfLokation, txfPris;
	private DatePicker dpStartDato, dpSlutDato;
	private Callback<DatePicker, DateCell> cbStartDato, cbSlutDato;

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

		dpStartDato = new DatePicker(LocalDate.now());
		dpStartDato.setMaxWidth(150);
		gridPane.add(dpStartDato, 0, 3);

		cbStartDato = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				// TODO Auto-generated method stub
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);
						if (item.isAfter(dpSlutDato.getValue())) {
							setDisable(true);
						}
					}
				};
			}
		};

		lblTema = new Label("Tema");
		gridPane.add(lblTema, 0, 4);

		txfTema = GUITools.stdTextField();
		gridPane.add(txfTema, 0, 5);

		btnOK = GUITools.stdButton("OK");
		btnOK.setOnAction(event -> createKonference());
		gridPane.add(btnOK, 0, 7);

		lblPris = new Label("Pris");
		gridPane.add(lblPris, 1, 0);

		txfPris = new TextField();
		gridPane.add(txfPris, 1, 1);
		txfPris.setMaxWidth(50);

		ImageView KASkas = new ImageView(GUITools.kasKas());
		GridPane.setHalignment(KASkas, HPos.RIGHT);
		gridPane.add(KASkas, 1, 0, 1, 2);

		lblSlutDato = new Label("SlutDato");
		GridPane.setValignment(lblSlutDato, VPos.BOTTOM);
		gridPane.add(lblSlutDato, 1, 2);

		dpSlutDato = new DatePicker(LocalDate.now().plusDays(1));
		dpSlutDato.setMaxWidth(150);
		gridPane.add(dpSlutDato, 1, 3);

		cbSlutDato = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				// TODO Auto-generated method stub
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);
						if (item.isBefore(dpSlutDato.getValue())) {
							setDisable(true);
						}
					}
				};
			}
		};

		lblLokation = new Label("Lokation");
		gridPane.add(lblLokation, 1, 4);

		txfLokation = GUITools.stdTextField();
		gridPane.add(txfLokation, 1, 5);

		btnCancel = GUITools.stdButton("Annuller");
		btnCancel.setOnAction(event -> close());
		gridPane.add(btnCancel, 1, 7);

	}

	private void createKonference() {
		Alert alert;
		try {

			double pris = Double.parseDouble(txfPris.getText());
			Service.createKonference(organisation, dpStartDato.getValue(), dpSlutDato.getValue(), txfLokation.getText(),
					txfNavn.getText(), txfTema.getText(), pris);
			this.close();
		} catch (NumberFormatException e) {
			// TODO: handle exception
			alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("Prisen skal være et tal");
			alert.showAndWait();

		}

	}

}
