package guifx;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KASTilfoejService extends Stage {
	public KASTilfoejService() {
		this.setTitle("Tilfoej Service");
		GridPane gridPane = new GridPane();
		this.initContent(gridPane);

		Scene scene = new Scene(gridPane);
		this.setScene(scene);
	}

	Image KASkassen = new Image("File:resources/Kaskas.png");
	Label lblServices, lblNavn, lblBeskrivelse, lblPris;
	ListView<String> lvwServices;
	Button btnTilfoej, btnOK, btnAnnuller;
	TextField txfNavn, txfBeskrivelse, txfPris;
	int buttonWidth = 120;

	public void initContent(GridPane gridPane) {
		gridPane.setPadding(new Insets(10));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		lblServices = new Label("Services");
		gridPane.add(lblServices, 0, 0);

		lvwServices = new ListView<>();
		lvwServices.setMaxHeight(100);
		gridPane.add(lvwServices, 0, 1);

		btnTilfoej = new Button("Tilfoej Service");
		gridPane.add(btnTilfoej, 0, 2);
		btnTilfoej.setOnAction(event -> this.tilfoejAction());

		lblNavn = new Label("Servicenavn");
		gridPane.add(lblNavn, 1, 0);

		txfNavn = new TextField();
		txfNavn.setMinWidth(buttonWidth);
		txfNavn.setMaxWidth(buttonWidth);
		gridPane.add(txfNavn, 1, 1);

		lblBeskrivelse = new Label("Kort beskrivelse");
		gridPane.add(lblBeskrivelse, 1, 2);

		txfBeskrivelse = new TextField();
		txfBeskrivelse.setMinWidth(buttonWidth);
		txfBeskrivelse.setMaxWidth(buttonWidth);
		gridPane.add(txfBeskrivelse, 1, 3);

		lblPris = new Label("Pris");
		gridPane.add(lblPris, 2, 2);

		txfPris = new TextField();
		txfPris.setMinWidth(buttonWidth);
		txfPris.setMaxWidth(buttonWidth);
		gridPane.add(txfPris, 2, 3);

		btnOK = new Button("Okay");
		btnOK.setMinWidth(buttonWidth);
		btnOK.setOnAction(event -> this.okAction());

		btnAnnuller = new Button("Annullér");
		btnAnnuller.setMinWidth(buttonWidth);
		btnAnnuller.setOnAction(event -> this.annulerAction());

	}

	private void tilfoejAction() {

	}

	private void okAction() {

	}

	private void annulerAction() {

	}

}
