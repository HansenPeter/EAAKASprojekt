package guifx;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KasOpretKonference extends Stage {

	public KasOpretKonference() {
		// TODO Auto-generated constructor stub
		this.setTitle("Opret Konference");
		GridPane gridPane = new GridPane();
		this.initContent(gridPane);

		Scene scene = new Scene(gridPane);
		this.setScene(scene);
	}

	Image KASkassen = new Image("File:resources/Kaskas.png");
	Label lblBeboelser, lblUdflugter, lblNavn, lblStartDato, lblSlutDato, lblTema, lblLokation;
	ListView<String> lvwBeboelser, lvwUdflugter;
	Button btnAddBeboelse, btnAddServices, btnAddUdflugt, btnOK, btnCancel;
	TextField txfNavn, txfTema, txfLokation, txfStartDato, txfSlutDato;
	int buttonWidth = 120;

	public void initContent(GridPane gridPane) {
		gridPane.setPadding(new Insets(10));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		lblBeboelser = new Label("Beboelser");
		gridPane.add(lblBeboelser, 0, 0);

		lvwBeboelser = new ListView<String>();
		lvwBeboelser.setMaxHeight(100);
		gridPane.add(lvwBeboelser, 0, 1, 2, 2);

		// Midlertidige beboelser
		lvwBeboelser.getItems().add("Huset på Christianshavn");
		lvwBeboelser.getItems().add("Høtel Phønix");
		lvwBeboelser.getItems().add("Comwell");

		btnAddBeboelse = new Button("Tilføj Beboelse");
		btnAddBeboelse.setMinWidth(buttonWidth);
		gridPane.add(btnAddBeboelse, 0, 3);

		btnAddServices = new Button("Tilføj Services");
		btnAddServices.setMinWidth(buttonWidth);
		gridPane.add(btnAddServices, 1, 3);

		lblUdflugter = new Label("Udflugter");
		gridPane.add(lblUdflugter, 0, 4);

		lvwUdflugter = new ListView<String>();
		lvwUdflugter.setMaxHeight(100);
		gridPane.add(lvwUdflugter, 0, 5, 2, 2);

		// Midlertidige udflugter
		lvwUdflugter.getItems().add("Kanal Rundfart");
		lvwUdflugter.getItems().add("Givskud Zoo");
		lvwUdflugter.getItems().add("LEGO Land Land");

		btnAddUdflugt = new Button("Tilføj Udflugt");
		btnAddUdflugt.setMinWidth(buttonWidth);
		gridPane.add(btnAddUdflugt, 0, 7);

		lblNavn = new Label("Navn");
		gridPane.add(lblNavn, 2, 0);

		txfNavn = new TextField();
		txfNavn.setMinWidth(buttonWidth);
		txfNavn.setMaxWidth(buttonWidth);
		gridPane.add(txfNavn, 2, 1);

		lblStartDato = new Label("Startdato");
		gridPane.add(lblStartDato, 2, 2);

		txfStartDato = new TextField();
		txfStartDato.setMinWidth(buttonWidth);
		txfStartDato.setMaxWidth(buttonWidth);
		gridPane.add(txfStartDato, 2, 3);

		lblTema = new Label("Tema");
		gridPane.add(lblTema, 2, 4);

		txfTema = new TextField();
		txfTema.setMinWidth(buttonWidth);
		txfTema.setMaxWidth(buttonWidth);
		gridPane.add(txfTema, 2, 5);

		btnOK = new Button("OK");
		btnOK.setMinWidth(buttonWidth);
		gridPane.add(btnOK, 2, 7);

		gridPane.add(new ImageView(KASkassen), 3, 0, 1, 2);

		lblSlutDato = new Label("SlutDato");
		gridPane.add(lblSlutDato, 3, 2);

		txfSlutDato = new TextField();
		txfSlutDato.setMinWidth(buttonWidth);
		txfSlutDato.setMaxWidth(buttonWidth);
		gridPane.add(txfSlutDato, 3, 3);

		lblLokation = new Label("Lokation");
		gridPane.add(lblLokation, 3, 4);

		txfLokation = new TextField();
		txfLokation.setMinWidth(buttonWidth);
		txfLokation.setMaxWidth(buttonWidth);
		gridPane.add(txfLokation, 3, 5);

		btnCancel = new Button("Annulér");
		btnCancel.setMinWidth(buttonWidth);
		gridPane.add(btnCancel, 3, 7);
	}
}
