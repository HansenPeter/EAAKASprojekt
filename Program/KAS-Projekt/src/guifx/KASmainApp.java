package guifx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KASmainApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("KAS");
		BorderPane pane = new BorderPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setMinHeight(160);
		stage.setMinWidth(330);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private void initContent(BorderPane pane) {
		GridPane gridPane = new GridPane();
		this.initGridPane(gridPane);
		pane.setCenter(gridPane);
		pane.setPadding(new Insets(10));

	}

	private void initGridPane(GridPane gridPane) {
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(20);
		gridPane.setVgap(10);
		Label lblWelcome = new Label("Velkommen til Konference Administrations Systemet");
		gridPane.add(lblWelcome, 0, 0);

		ListView lvwKonferences = new ListView<String>();

		gridPane.add(lvwKonferences, 0, 1, 1, 2);

		// Midlertidig data til listview
		lvwKonferences.getItems().add("Torben");
		lvwKonferences.getItems().add("Peter");
		lvwKonferences.getItems().add("Made");

		GridPane gridButton = new GridPane();
		gridPane.add(gridButton, 1, 2);

		int addButtonWidth = 150;
		int addButtonHeight = 100;

		Button btnAddConference = new Button("Tilføj Konference");
		btnAddConference.setMinSize(addButtonWidth, addButtonHeight);
		GridPane.setHalignment(btnAddConference, HPos.CENTER);
		gridButton.add(btnAddConference, 0, 0);

		Button btnAddParticipant = new Button("Tilmeld Deltager");
		btnAddParticipant.setMinSize(addButtonWidth, addButtonHeight);
		GridPane.setHalignment(btnAddParticipant, HPos.CENTER);
		gridButton.add(btnAddParticipant, 0, 1);

		Button btnClose = new Button("Luk Program");
		btnClose.setMinWidth(150);
		GridPane.setHalignment(btnClose, HPos.CENTER);
		gridPane.add(btnClose, 1, 3);

		btnAddConference.setOnAction(event -> this.addConference());
		btnAddParticipant.setOnAction(event -> this.addParticipant());
		btnClose.setOnAction(event -> this.closeProgram());

	}

	private void addConference() {
		// TODO Auto-generated method stub
		KASOrganisationWindow window = new KASOrganisationWindow();
		window.showAndWait();

	}

	private void addParticipant() {
		
		KASTilmeldDeltagerWindow window = new KASTilmeldDeltagerWindow();
		window.showAndWait();
		
	}

	

	private void closeProgram() {
		// TODO Auto-generated method stub
		Platform.exit();
		System.exit(0);
	}
}
