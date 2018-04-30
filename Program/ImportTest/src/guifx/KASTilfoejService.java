package guifx;

import application.model.Beboelse;
import application.service.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KASTilfoejService extends Stage {

	public KASTilfoejService(Beboelse beboelse) {
		this.beboelse = beboelse;
		this.setTitle("Tilfoej Service");
		GridPane gridPane = new GridPane();
		this.initContent(gridPane);

		Scene scene = new Scene(gridPane);
		this.setScene(scene);
	}

	private Beboelse beboelse;
	Image KASkassen = new Image("File:resources/Kaskas.png");
	Label lblServices, lblNavn, lblBeskrivelse, lblPris;
	ListView<application.model.Service> lvwServices;
	Button btnTilfoej, btnOK, btnAnnuller;
	TextField txfNavn, txfBeskrivelse, txfPris;
	int buttonWidth = 120;

	public void initContent(GridPane gridPane) {
		gridPane.setPadding(new Insets(10));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		ImageView KASkas = new ImageView(GUITools.kasKas());
		GridPane.setValignment(KASkas, VPos.TOP);
		GridPane.setHalignment(KASkas, HPos.RIGHT);
		gridPane.add(KASkas, 2, 0, 1, 2);

		lblServices = new Label("Services");
		gridPane.add(lblServices, 0, 0);

		lvwServices = new ListView<>();
		lvwServices.setMaxHeight(100);
		lvwServices.getItems().addAll(Service.getServices(beboelse));
		gridPane.add(lvwServices, 0, 1, 1, 4);

		lblNavn = new Label("Servicenavn");
		gridPane.add(lblNavn, 1, 0);

		txfNavn = GUITools.stdTextField();
		gridPane.add(txfNavn, 1, 1);

		lblBeskrivelse = new Label("Kort beskrivelse");
		GridPane.setValignment(lblBeskrivelse, VPos.BOTTOM);
		gridPane.add(lblBeskrivelse, 1, 2);

		txfBeskrivelse = GUITools.stdTextField();
		GridPane.setValignment(txfBeskrivelse, VPos.BOTTOM);
		gridPane.add(txfBeskrivelse, 1, 3);

		lblPris = new Label("Pris");
		GridPane.setValignment(lblPris, VPos.BOTTOM);
		gridPane.add(lblPris, 2, 2);

		txfPris = GUITools.stdTextField();
		GridPane.setValignment(txfPris, VPos.BOTTOM);
		gridPane.add(txfPris, 2, 3);

		btnOK = GUITools.stdButton("Okay");
		btnOK.setOnAction(event -> this.tilfoejAction());
		gridPane.add(btnOK, 1, 5);

		btnAnnuller = GUITools.stdButton("Annullér");
		btnAnnuller.setOnAction(event -> this.close());
		gridPane.add(btnAnnuller, 2, 5);
	}

	private void tilfoejAction() {
		Alert alert;
		try {
			double pris = Double.parseDouble(txfPris.getText());
			Service.addService(beboelse, txfNavn.getText(), txfBeskrivelse.getText(), pris);
			this.close();
		} catch (NumberFormatException e) {
			alert = new Alert(AlertType.ERROR);
			alert.setContentText("pris skal vaere et tal");
			alert.showAndWait();
		}
	}

}
