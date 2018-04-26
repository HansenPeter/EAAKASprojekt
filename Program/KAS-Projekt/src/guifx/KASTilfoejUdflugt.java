package guifx;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KASTilfoejUdflugt extends Stage {

	public KASTilfoejUdflugt() {
		this.setTitle("Opret Udflugt");
		GridPane gridPane = new GridPane();
		this.initContent(gridPane);

		Scene scene = new Scene(gridPane);
		this.setScene(scene);
	}

	Image KASkassen = new Image("File:resources/Kaskas.png");
	Label lblNavn, lblPris, lblDato, lblUdflugt;
	Button btnOK, btnCancel, btnTilfoej;
	TextField txfNavn, txfDato, txfPris;
	ListView<String> lvwUdflugt;
	CheckBox frokost;
	int buttonWidth = 120;

	public void initContent(GridPane gridPane) {
		gridPane.setPadding(new Insets(10));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		lblUdflugt = new Label("Udflugter");
		gridPane.add(lblUdflugt, 0, 0);

		lvwUdflugt = new ListView<>();
		lvwUdflugt.setMaxHeight(100);
		gridPane.add(lvwUdflugt, 0, 1);

		btnTilfoej = new Button("Tilfoej");
		btnTilfoej.setMinWidth(buttonWidth);
		gridPane.add(btnTilfoej, 0, 2);
		btnTilfoej.setOnAction(event -> this.tilfoejAction());

		lblNavn = new Label("Udflugtsnavn");
		gridPane.add(lblNavn, 1, 0);

		txfNavn = new TextField();
		txfNavn.setMinWidth(buttonWidth);
		txfNavn.setMaxWidth(buttonWidth);
		gridPane.add(txfNavn, 1, 1);

		lblDato = new Label("Dato");
		gridPane.add(lblDato, 1, 2);

		txfDato = new TextField();
		txfDato.setMinWidth(buttonWidth);
		txfDato.setMaxWidth(buttonWidth);
		gridPane.add(txfDato, 1, 3);

		lblPris = new Label("Pris");
		gridPane.add(lblPris, 2, 2);

		txfPris = new TextField();
		txfPris.setMinWidth(buttonWidth);
		txfPris.setMaxWidth(buttonWidth);
		gridPane.add(txfPris, 2, 3);

		btnOK = new Button("Okay");
		gridPane.add(btnOK, 1, 2);
		btnOK.setOnAction(event -> this.okAction());

		btnCancel = new Button("Annuller");
		gridPane.add(btnCancel, 2, 2);
		btnCancel.setOnAction(event -> this.annullerAction());

		frokost = new CheckBox();
		frokost.setText("Frokost");
	}

	private void okAction() {
		String name = txfNavn.getText().trim();
		// forts med ''peters super seje dato-kalender!

	}

	private void annullerAction() {

	}

	private void tilfoejAction() {

	}

}
