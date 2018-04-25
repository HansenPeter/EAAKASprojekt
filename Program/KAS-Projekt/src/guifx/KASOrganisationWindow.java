package guifx;

import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KASOrganisationWindow extends Stage {

	public KASOrganisationWindow() {
		this.setTitle("Organisationsvalg");
		GridPane gridPane = new GridPane();
		this.initContent(gridPane);

		Scene scene = new Scene(gridPane);
		this.setScene(scene);
	}

	// Image kasKassen = KASkas.png
	Label lblOrganisation;
	ListView lvwOrganisations;
	TextField txfOrganisationName;
	Button btnPickOrganisation;
	Button btnAddOrganisation;
	Button btnOK;
	int buttonWidth = 120;
	Image KASkassen = new Image("File:resources/Kaskas.png");

	public void initContent(GridPane gridPane) {
		// TODO Auto-generated method stub
		gridPane.setPadding(new Insets(10));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		// gridPane.add(kasKassen, 1, 0);

		lblOrganisation = new Label("Organisationer");
		gridPane.add(lblOrganisation, 0, 0);

		ImageView KASkas = new ImageView(GUITools.kasKas());
		GridPane.setValignment(KASkas, VPos.BASELINE);
		gridPane.add(KASkas, 1, 0, 1, 2);

		lvwOrganisations = new ListView<String>();
		gridPane.add(lvwOrganisations, 0, 1);
		// Midlertidigt indhold
		lvwOrganisations.getItems().add("Odense Universitet");
		lvwOrganisations.getItems().add("Erhvervsakademiet Aarhus");
		lvwOrganisations.getItems().add("Aarhus Universitet");
		lvwOrganisations.getItems().add("Peters Praksis");
		lvwOrganisations.getItems().add("Jyllands Posten");
		lvwOrganisations.getItems().add("Vatikanet");

		btnPickOrganisation = GUITools.stdButton("Vælg Organisation");
		btnPickOrganisation.setOnAction(event -> this.addKonference());
		gridPane.add(btnPickOrganisation, 1, 1);

		txfOrganisationName = new TextField("Ny Organisation");
		gridPane.add(txfOrganisationName, 0, 2);

		btnAddOrganisation = GUITools.stdButton("Tilføj");
		btnAddOrganisation.setOnAction(event -> this.addOrganisation());
		gridPane.add(btnAddOrganisation, 1, 2);

		btnOK = GUITools.stdButton("OK");
		btnOK.setOnAction(event -> this.closeWindow());
		gridPane.add(btnOK, 1, 3);

	}

	private void addKonference() {
		// TODO Auto-generated method stub
		KasOpretKonference window = new KasOpretKonference();
		window.showAndWait();
	}

	private void addOrganisation() {
		// TODO Auto-generated method stub
		lvwOrganisations.getItems().add(txfOrganisationName.getText());
	}

	private void closeWindow() {
		// TODO Auto-generated method stub
		this.close();
	}
}
