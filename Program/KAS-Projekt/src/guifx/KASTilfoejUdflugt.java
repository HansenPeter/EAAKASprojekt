package guifx;

import java.time.LocalDate;

import application.model.Konference;
import application.model.Udflugt;
import application.service.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class KASTilfoejUdflugt extends Stage {

	private Konference konference;

	public KASTilfoejUdflugt(Konference konference) {
		this.konference = konference;
		this.setTitle("Opret Udflugt");
		GridPane gridPane = new GridPane();
		this.initContent(gridPane);

		Scene scene = new Scene(gridPane);
		this.setScene(scene);
	}

	private Label lblNavn, lblPris, lblDato, lblUdflugt;
	private Button btnOK, btnCancel;
	private TextField txfNavn, txfPris;
	private DatePicker dpDato;
	private ListView<Udflugt> lvwUdflugt;
	private CheckBox frokost;
	private Callback<DatePicker, DateCell> cbKonferencePeriode;

	public void initContent(GridPane gridPane) {
		gridPane.setPadding(new Insets(10));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		ImageView KASkas = new ImageView(GUITools.kasKas());
		GridPane.setValignment(KASkas, VPos.TOP);
		GridPane.setHalignment(KASkas, HPos.RIGHT);
		gridPane.add(KASkas, 2, 0, 1, 2);

		lblUdflugt = new Label("Udflugter");
		gridPane.add(lblUdflugt, 0, 0);

		lvwUdflugt = new ListView<>();
		lvwUdflugt.setMaxHeight(150);
		gridPane.add(lvwUdflugt, 0, 1, 1, 5);
		lvwUdflugt.getItems().addAll(Service.getUdflugter(konference));

		lblNavn = new Label("Udflugtsnavn");
		gridPane.add(lblNavn, 1, 0);

		txfNavn = GUITools.stdTextField();
		GridPane.setValignment(txfNavn, VPos.TOP);
		gridPane.add(txfNavn, 1, 1);

		lblDato = new Label("Dato");
		gridPane.add(lblDato, 1, 2);

		dpDato = new DatePicker(konference.getStartDato());
		
		cbKonferencePeriode = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item.isAfter(konference.getSlutDato()) || item.isBefore(konference.getStartDato())) {
                            setDisable(true);
                        }

                    }
                };
            }
        };
        
        dpDato.setDayCellFactory(cbKonferencePeriode);
		dpDato.setMaxWidth(150);
		gridPane.add(dpDato, 1, 3);

		lblPris = new Label("Pris");
		gridPane.add(lblPris, 2, 2);

		txfPris = GUITools.stdTextField();
		gridPane.add(txfPris, 2, 3);

		frokost = new CheckBox();
		frokost.setText("Frokost");
		gridPane.add(frokost, 1, 4);

		btnOK = GUITools.stdButton("OK");
		gridPane.add(btnOK, 1, 5);
		GridPane.setValignment(btnOK, VPos.BOTTOM);
		btnOK.setOnAction(event -> this.tilfoejAction());

		btnCancel = GUITools.stdButton("Annuller");
		gridPane.add(btnCancel, 2, 5);
		GridPane.setValignment(btnCancel, VPos.BOTTOM);
		btnCancel.setOnAction(event -> this.close());

	}

	private void tilfoejAction() {
		Alert alert;
		try {
			double pris = Double.parseDouble(txfPris.getText());
			Service.createUdflugt(konference, txfNavn.getText(), dpDato.getValue(), pris, frokost.isSelected());
			this.close();
		} catch (NumberFormatException e) {
			// TODO: handle exception
			alert = new Alert(AlertType.ERROR);
			alert.setContentText("Pris skal vaere et tal");
			alert.showAndWait();
		}
	}
}
