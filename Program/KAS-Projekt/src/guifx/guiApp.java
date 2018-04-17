package guifx;

import application.service.Service;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class guiApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void init() {
		Service.initStorage();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("KAS System");
		BorderPane pane = new BorderPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private void initContent(BorderPane pane) {
		GridPane gridPane = new GridPane();
		this.initGridPane(gridPane);
		pane.setCenter(gridPane);

	}

	private void initGridPane(GridPane gridPane) {
		Label lblWelcome = new Label("Velkommen til Konference Administrations Systemet");
		gridPane.add(lblWelcome, 0, 0);

		Button btnAddConference = new Button("Tilføj Konference");
		btnAddConference.setMinWidth(150);
		gridPane.add(btnAddConference, 0, 1);

		Button btnAddOrganization = new Button("Tilføj Organisation");
		btnAddOrganization.setMinWidth(150);
		gridPane.add(btnAddOrganization, 0, 2);

		Button btnAddParticipant = new Button("Tilføj Deltager");
		btnAddParticipant.setMinWidth(150);
		gridPane.add(btnAddParticipant, 0, 3);

		btnAddConference.setOnAction(event -> this.addConference());
		btnAddOrganization.setOnAction(event -> this.addOrganization());
		btnAddParticipant.setOnAction(event -> this.addParticipant());

	}

	private void addParticipant() {
		// TODO Auto-generated method stub
		Alert alert = new Alert(AlertType.INFORMATION, "Her skal ske noget fedt!", ButtonType.CLOSE);
		alert.setHeaderText("INFO");
		alert.showAndWait();
	}

	private void addOrganization() {
		// TODO Auto-generated method stub
		Alert alert = new Alert(AlertType.INFORMATION, "Her skal ske noget fedt!", ButtonType.CLOSE);
		alert.setHeaderText("INFO");
		alert.showAndWait();
	}

	private void addConference() {
		// TODO Auto-generated method stub
		Alert alert = new Alert(AlertType.INFORMATION, "Her skal ske noget fedt!", ButtonType.CLOSE);
		alert.setHeaderText("INFO");
		alert.showAndWait();
	}
}
