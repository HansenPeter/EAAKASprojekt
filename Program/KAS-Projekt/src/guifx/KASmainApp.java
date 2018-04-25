package guifx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
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

	Label lblWelcome;
	ListView lvwKonferences;
	GridPane gridButtons;
	Button btnAddConference, btnAddParticipant, btnClose;

	private void initGridPane(GridPane gridPane) {
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(20);
		gridPane.setVgap(10);
		gridPane.setGridLinesVisible(false);
		lblWelcome = new Label("Velkommen til Konference Administrations Systemet");
		gridPane.add(lblWelcome, 0, 0);

		lvwKonferences = new ListView<String>();
		lvwKonferences.setMinHeight(100);
		lvwKonferences.setMaxHeight(200);
		gridPane.add(lvwKonferences, 0, 1, 1, 2);

		// Midlertidig data til listview
		lvwKonferences.getItems().add("Torben");
		lvwKonferences.getItems().add("Peter");
		lvwKonferences.getItems().add("Made");

		gridPane.add(new ImageView(GUITools.kasKas()), 1, 0, 1, 2);

		gridButtons = new GridPane();
		gridButtons.setAlignment(Pos.CENTER);
		gridButtons.setHgap(20);
		gridButtons.setVgap(10);
		gridPane.add(gridButtons, 1, 2);
		btnAddConference = GUITools.stdButton("Tilføj Konference");
		gridButtons.add(btnAddConference, 0, 0);

		btnAddParticipant = GUITools.stdButton("Tilmeld Deltager");
		gridButtons.add(btnAddParticipant, 0, 1);

		btnClose = GUITools.stdButton("Luk Program");
		GridPane.setValignment(btnClose, VPos.BOTTOM);
		gridPane.add(btnClose, 1, 2);

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
