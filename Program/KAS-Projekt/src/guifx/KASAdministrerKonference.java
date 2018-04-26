package guifx;

import application.model.Beboelse;
import application.model.Konference;
import application.model.Udflugt;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KASAdministrerKonference extends Stage {
	private Konference konference;

	public KASAdministrerKonference(Konference konference) {
		// TODO Auto-generated constructor stub
		this.konference = konference;
		setTitle("Administrer Konference");
		GridPane gridPane = new GridPane();
		initContent(gridPane);

		Scene scene = new Scene(gridPane);
		setScene(scene);

	}

	Label lblBeboelser, lblUdflugter, lblNavn;
	ListView<Beboelse> lvwBeboelser;
	ListView<Udflugt> lvwUdflugter;
	ListView<application.model.Service> lvwServices;

	Button btnAddBeboelse, btnAddServices, btnAddUdflugt;

	private void initContent(GridPane gridPane) {
		// TODO Auto-generated method stub
		gridPane.setPadding(new Insets(10));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		lblUdflugter = new Label("Udflugter");
		gridPane.add(lblUdflugter, 0, 0);

		lvwUdflugter = new ListView<>();
		lvwUdflugter.setMaxHeight(100);
		lvwUdflugter.getItems().addAll(Service.getUdflugter(konference));
		gridPane.add(lvwUdflugter, 0, 1);

		btnAddUdflugt = GUITools.stdButton("Tilfoej Udflugt");
		gridPane.add(btnAddUdflugt, 0, 2);
		btnAddUdflugt.setOnAction(event -> addUdflugtAction()); // MADE

		lblBeboelser = new Label("Beboelser");
		gridPane.add(lblBeboelser, 0, 3);

		lvwBeboelser = new ListView<>();
		lvwBeboelser.setMaxHeight(100);
		lvwBeboelser.getItems().addAll(Service.getBeboelser(konference));
		gridPane.add(lvwBeboelser, 0, 4);

		btnAddBeboelse = GUITools.stdButton("Tilfoej Beboelse");
		gridPane.add(btnAddBeboelse, 0, 5);
		btnAddBeboelse.setOnAction(event -> addBeboelseAction()); // MADE

		lvwServices = new ListView<>();
		lvwServices.setMaxHeight(100);
		gridPane.add(lvwServices, 1, 4);
		lvwBeboelser.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Beboelse>() {
			@Override
			public void changed(ObservableValue<? extends Beboelse> observable, Beboelse oldBeboelse,
					Beboelse newBeboelse) {
				lvwServices.getItems().clear();
				lvwServices.getItems().addAll(Service.getServices(lvwBeboelser.getSelectionModel().getSelectedItem()));
			}

		});
		;
		btnAddServices = GUITools.stdButton("Tilfoej Services");
		gridPane.add(btnAddServices, 1, 5);
		btnAddServices.setOnAction(event -> addServiceAction()); // MADE

	}

	// MADE
	public void addUdflugtAction() {
		KASTilfoejUdflugt udflugtWindow = new KASTilfoejUdflugt(this.konference);
		udflugtWindow.showAndWait();
		lvwUdflugter.getItems().setAll(Service.getUdflugter(konference));

	}

	// MADE
	public void addBeboelseAction() {
		KASOpretBeboelse beboelseWindow = new KASOpretBeboelse(this.konference);
		beboelseWindow.showAndWait();
		lvwBeboelser.getItems().setAll(Service.getBeboelser(konference));

	}

	// MADE
	public void addServiceAction() {
		KASTilfoejService serviceWindow = new KASTilfoejService(lvwBeboelser.getSelectionModel().getSelectedItem());
		serviceWindow.showAndWait();
		lvwUdflugter.getItems().setAll(Service.getUdflugter(konference));
	}
}
