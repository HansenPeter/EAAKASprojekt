package guifx;

import application.model.Konference;
import application.model.Organisation;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
	Label lblOrganisation, lblkonferencer;
	ListView<Organisation> lvwOrganisations;
	ListView<Konference> lvwKonferencer;
	TextField txfOrganisationName;
	Button btnPickOrganisation;
	Button btnAddOrganisation;
	Button btnOK;
	Button btnAddKonference;
	Button btnAdminKonference;
	VBox VBOrganisation, VBKonference;

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

		lvwOrganisations = new ListView<Organisation>();
		gridPane.add(lvwOrganisations, 0, 1, 1, 3);
		lvwOrganisations.getItems().addAll(Service.getOrganisations());
		lvwOrganisations.setMaxHeight(200);
		lvwOrganisations.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Organisation>() {
			@Override
			public void changed(ObservableValue<? extends Organisation> observable, Organisation oldOrganisation,
					Organisation newOrganisation) {
				lvwKonferencer.getItems().clear();
				lvwKonferencer.getItems().addAll(
						Service.getSpecifikkeKonferencer(lvwOrganisations.getSelectionModel().getSelectedItem()));
			}
		});

		VBOrganisation = new VBox();
		gridPane.add(VBOrganisation, 1, 2);

		txfOrganisationName = new TextField("Ny Organisation");
		VBOrganisation.getChildren().add(txfOrganisationName);

		btnAddOrganisation = GUITools.stdButton("Tilføj organisation");
		btnAddOrganisation.setOnAction(event -> this.addOrganisation());
		VBOrganisation.getChildren().add(btnAddOrganisation);

		btnPickOrganisation = GUITools.stdButton("Vælg Organisation");
		btnPickOrganisation.setOnAction(event -> this.addKonference());

		lblkonferencer = new Label("Konferencer");
		gridPane.add(lblkonferencer, 0, 4);

		lvwKonferencer = new ListView<Konference>();
		lvwKonferencer.setMaxHeight(200);
		gridPane.add(lvwKonferencer, 0, 5);

		VBKonference = new VBox();
		gridPane.add(VBKonference, 1, 5);

		btnAddKonference = GUITools.stdButton("Ny Konference");
		btnAddKonference.setOnAction(event -> addKonference());

		btnAdminKonference = GUITools.stdButton("Administrer Konference");
		btnAdminKonference.setOnAction(event -> administerKonference());

		VBKonference.getChildren().add(btnAddKonference);
		VBKonference.getChildren().add(btnAdminKonference);

		btnOK = GUITools.stdButton("Close");
		btnOK.setOnAction(event -> this.close());
		gridPane.add(btnOK, 1, 6);

	}

	private void administerKonference() {
		// TODO Auto-generated method stub
		if (lvwKonferencer.getSelectionModel().getSelectedItem() != null) {
			KASAdministrerKonference window = new KASAdministrerKonference(
					lvwKonferencer.getSelectionModel().getSelectedItem());
			window.showAndWait();
		}
	}

	private void addKonference() {
		// TODO Auto-generated method stub
		if (lvwOrganisations.getSelectionModel().getSelectedItem() != null) {
			KasOpretKonference window = new KasOpretKonference(lvwOrganisations.getSelectionModel().getSelectedItem());
			window.showAndWait();
			lvwKonferencer.getItems()
					.setAll(Service.getSpecifikkeKonferencer(lvwOrganisations.getSelectionModel().getSelectedItem()));
		}
	}

	private void addOrganisation() {
		// TODO Auto-generated method stub
		if (!txfOrganisationName.getText().equals("Ny Organisation")) {
			Service.createOrganisation(txfOrganisationName.getText());
			lvwOrganisations.getItems().clear();
			lvwOrganisations.getItems().addAll(Service.getOrganisations());
			txfOrganisationName.clear();
		}
		// else do nothing
	}
}
