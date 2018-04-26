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
        initGridPane(gridPane);
        pane.setCenter(gridPane);
        pane.setPadding(new Insets(10));
        Storage.initContent();

    }

<<<<<<< HEAD
    private void initGridPane(GridPane gridPane) {
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(10);
        Label lblWelcome = new Label("Velkommen til Konference Administrations Systemet");
        gridPane.add(lblWelcome, 0, 0);

        ListView lvwKonferences = new ListView<String>();

        gridPane.add(lvwKonferences, 0, 1, 1, 2);
=======
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
>>>>>>> 92150fd20f2ec7054d75248243dd751f189c02ac

		// Midlertidig data til listview
		lvwKonferences.getItems().add("Torben");
		lvwKonferences.getItems().add("Peter");
		lvwKonferences.getItems().add("Made");
		lvwKonferences.getItems().add("Lars");

<<<<<<< HEAD
        VBox vbButton = new VBox();

        gridPane.add(vbButton, 1, 1);

        int addButtonWidth = 150;
        int addButtonHeight = 100;

        Button btnAddConference = new Button("Tilføj Konference");
        btnAddConference.setMinSize(addButtonWidth, addButtonHeight);
        GridPane.setHalignment(btnAddConference, HPos.CENTER);
        vbButton.getChildren().add(btnAddConference);

        Button btnAddParticipant = new Button("Tilmeld Deltager");
        btnAddParticipant.setMinSize(addButtonWidth, addButtonHeight);
        GridPane.setHalignment(btnAddParticipant, HPos.CENTER);
        vbButton.getChildren().add(btnAddParticipant);

        Button btnClose = new Button("Luk Program");
        btnClose.setMinWidth(150);
        GridPane.setHalignment(btnClose, HPos.CENTER);
        gridPane.add(btnClose, 1, 3);
=======
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
>>>>>>> 92150fd20f2ec7054d75248243dd751f189c02ac

        btnAddConference.setOnAction(event -> addConference());
        btnAddParticipant.setOnAction(event -> addParticipant());
        btnClose.setOnAction(event -> closeProgram());

    }

    private void addConference() {
        // TODO Auto-generated method stub
        KASOrganisationWindow window = new KASOrganisationWindow();
        window.showAndWait();

    }

<<<<<<< HEAD
    private void addParticipant() {

        KASTilmeldDeltagerWindow window = new KASTilmeldDeltagerWindow();
        window.showAndWait();
=======
	private void addParticipant() {

		KASTilmeldDeltagerWindow window = new KASTilmeldDeltagerWindow();
		window.showAndWait();

	}
>>>>>>> 92150fd20f2ec7054d75248243dd751f189c02ac

    }

    private void closeProgram() {
        // TODO Auto-generated method stub
        Platform.exit();
        System.exit(0);
    }
}
