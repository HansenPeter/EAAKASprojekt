package guifx;

import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KasOpretKonference extends Stage {

    public KasOpretKonference() {
        // TODO Auto-generated constructor stub
        setTitle("Opret Konference");
        GridPane gridPane = new GridPane();
        initContent(gridPane);

        Scene scene = new Scene(gridPane);
        setScene(scene);
    }

    Label lblBeboelser, lblUdflugter, lblNavn, lblStartDato, lblSlutDato, lblTema, lblLokation;
    ListView<String> lvwBeboelser, lvwUdflugter;
    Button btnAddBeboelse, btnAddServices, btnAddUdflugt, btnOK, btnCancel;
    TextField txfNavn, txfTema, txfLokation, txfStartDato, txfSlutDato;

    public void initContent(GridPane gridPane) {
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        lblBeboelser = new Label("Beboelser");
        gridPane.add(lblBeboelser, 0, 0);

        lvwBeboelser = new ListView<>();
        lvwBeboelser.setMaxHeight(100);
        gridPane.add(lvwBeboelser, 0, 1, 2, 2);

        // Midlertidige beboelser
        lvwBeboelser.getItems().add("Huset paa Christianshavn");
        lvwBeboelser.getItems().add("Hoetel Phoenix");
        lvwBeboelser.getItems().add("Comwell");

        btnAddBeboelse = GUITools.stdButton("Tilfoej Beboelse");
        gridPane.add(btnAddBeboelse, 0, 3);
        btnAddBeboelse.setOnAction(event -> addBeboelseAction()); // MADE

        btnAddServices = GUITools.stdButton("Tilfoej Services");
        gridPane.add(btnAddServices, 1, 3);
        btnAddServices.setOnAction(event -> addServiceAction()); // MADE

        lblUdflugter = new Label("Udflugter");
        gridPane.add(lblUdflugter, 0, 4);

        lvwUdflugter = new ListView<>();
        lvwUdflugter.setMaxHeight(100);
        gridPane.add(lvwUdflugter, 0, 5, 2, 2);

        // Midlertidige udflugter
        lvwUdflugter.getItems().add("Kanal Rundfart");
        lvwUdflugter.getItems().add("Givskud Zoo");
        lvwUdflugter.getItems().add("LEGO Land Land");

        btnAddUdflugt = GUITools.stdButton("Tilfoej Udflugt");
        gridPane.add(btnAddUdflugt, 0, 7);
        btnAddUdflugt.setOnAction(event -> addUdflugtAction()); // MADE

        lblNavn = new Label("Navn");
        gridPane.add(lblNavn, 2, 0);

        txfNavn = GUITools.stdTextField();
        gridPane.add(txfNavn, 2, 1);

        lblStartDato = new Label("Startdato");
        GridPane.setValignment(lblStartDato, VPos.BOTTOM);
        gridPane.add(lblStartDato, 2, 2);

        txfStartDato = GUITools.stdTextField();
        gridPane.add(txfStartDato, 2, 3);

        lblTema = new Label("Tema");
        gridPane.add(lblTema, 2, 4);

        txfTema = GUITools.stdTextField();
        gridPane.add(txfTema, 2, 5);

        btnOK = GUITools.stdButton("OK");
        gridPane.add(btnOK, 2, 7);

        gridPane.add(new ImageView(GUITools.kasKas()), 3, 0, 1, 2);

        lblSlutDato = new Label("SlutDato");
        GridPane.setValignment(lblSlutDato, VPos.BOTTOM);
        gridPane.add(lblSlutDato, 3, 2);

        txfSlutDato = GUITools.stdTextField();
        gridPane.add(txfSlutDato, 3, 3);

        lblLokation = new Label("Lokation");
        gridPane.add(lblLokation, 3, 4);

        txfLokation = GUITools.stdTextField();
        gridPane.add(txfLokation, 3, 5);

        btnCancel = GUITools.stdButton("Annuller");
        gridPane.add(btnCancel, 3, 7);
    }

	// MADE
	public void addUdflugtAction() {
		KASTilfoejUdflugt udflugtWindow = new KASTilfoejUdflugt();
		udflugtWindow.showAndWait();

    }

	// MADE
	public void addBeboelseAction() {
		KASOpretBeboelse beboelseWindow = new KASOpretBeboelse();
		beboelseWindow.showAndWait();
	}

	// MADE
	public void addServiceAction() {
		KASTilfoejService serviceWindow = new KASTilfoejService();
		serviceWindow.showAndWait();
	}
}
