package guifx;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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

	public void initContent(GridPane gridPane) {
		// TODO Auto-generated method stub
		gridPane.setPadding(new Insets(10));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		// gridPane.add(kasKassen, 1, 0);

		lblOrganisation = new Label("Organisationer");
		gridPane.add(lblOrganisation, 0, 0);

		lvwOrganisations = new ListView<String>();
		gridPane.add(lvwOrganisations, 0, 1);
	}
}
