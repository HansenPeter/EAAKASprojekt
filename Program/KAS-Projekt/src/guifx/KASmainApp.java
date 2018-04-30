package guifx;

import application.model.Konference;
import application.service.Service;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import storage.Storage;

public class KASmainApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("KAS");
		BorderPane pane = new BorderPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setMinHeight(160);
		stage.setMinWidth(330);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private void initContent(BorderPane pane) {
		GridPane gridPane = new GridPane();
		Storage.initContent();
		initGridPane(gridPane);
		pane.setCenter(gridPane);
		pane.setPadding(new Insets(10));

	}

	Label lblWelcome;
	ListView<Konference> lvwKonferences;
	GridPane gridButtons;
	Button btnAddConference, btnAddParticipant, btnClose, btnVisDeltagere;
	ImageView KASkas;

	private void initGridPane(GridPane gridPane) {
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(20);
		gridPane.setVgap(10);
		gridPane.setGridLinesVisible(false);
		lblWelcome = new Label("Velkommen til Konference Administrations Systemet");
		gridPane.add(lblWelcome, 0, 0);

		lvwKonferences = new ListView<>();
		lvwKonferences.setMinHeight(100);
		lvwKonferences.setMaxHeight(200);
		gridPane.add(lvwKonferences, 0, 1, 1, 2);
		lvwKonferences.getItems().setAll(Service.getKonferencer());

		KASkas = new ImageView(GUITools.kasKas());
		gridPane.add(KASkas, 1, 0, 1, 2);
		GridPane.setHalignment(KASkas, HPos.RIGHT);

		btnAddConference = GUITools.stdButton("Administrer Konferencer");
		btnAddParticipant = GUITools.stdButton("Tilmeld Deltager");
		btnVisDeltagere = GUITools.stdButton("Vis Deltagere");
		VBox vbBtns = new VBox();
		vbBtns.setSpacing(10);
		vbBtns.getChildren().add(btnVisDeltagere);
		vbBtns.getChildren().add(btnAddConference);
		vbBtns.getChildren().add(btnAddParticipant);

		gridPane.add(vbBtns, 1, 2);

		btnClose = GUITools.stdButton("Luk Program");
		GridPane.setValignment(btnClose, VPos.BOTTOM);

		gridPane.add(btnClose, 1, 2);

		btnAddConference.setOnAction(event -> addConference());
		btnAddParticipant.setOnAction(event -> addParticipant());
		btnClose.setOnAction(event -> closeProgram());
		btnVisDeltagere.setOnAction(event -> visDeltagerWindow());

	}

	private void addConference() {
		// TODO Auto-generated method stub
		KASOrganisationWindow window = new KASOrganisationWindow();
		window.showAndWait();
		lvwKonferences.getItems().setAll(Service.getKonferencer());

	}

	private void addParticipant() {

		KASTilmeldDeltagerWindow window = new KASTilmeldDeltagerWindow();
		window.showAndWait();
		lvwKonferences.getItems().setAll(Service.getKonferencer());

	}

	private void closeProgram() {
		Platform.exit();
		System.exit(0);
	}

	private void visDeltagerWindow() {
		Konference curKonference = lvwKonferences.getSelectionModel().getSelectedItem();
		if (curKonference != null) {
			KASDeltagerWindow deltagerWindow = new KASDeltagerWindow(curKonference, true);
			deltagerWindow.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Ingen konference er valgt");
			alert.setContentText("Vaelg venligst en konference fra listen");
			alert.showAndWait();
		}

	}
}
