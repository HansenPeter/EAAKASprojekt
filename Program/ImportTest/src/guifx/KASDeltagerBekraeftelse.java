package guifx;

import application.model.Tilmelding;
import application.service.Service;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KASDeltagerBekraeftelse extends Stage {
		Tilmelding tilmelding;
	    Label lblTilmeldt, lblDeltagernavn, lblTilKonference, lblKonferenceNavn, lblLedsagerOgOvernatning, lblSamletPris,
	            lblPrisen;
	    Button btnBekraeft, btnAnnuller;
	    KASTilmeldDeltagerWindow mainStage;
	    
    public KASDeltagerBekraeftelse(Tilmelding tilmelding, KASTilmeldDeltagerWindow mainStage) {
    	this.mainStage = mainStage;
    	
        // Subject to change
        this.tilmelding = tilmelding;
        setTitle("KAS Money");
        GridPane gridPane = new GridPane();
        initContent(gridPane);

        Scene scene = new Scene(gridPane);
        setScene(scene);
    }

    public void initContent(GridPane gridPane) {
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(5);

        lblSamletPris = new Label("Samlet Pris:");
        gridPane.add(lblSamletPris, 0, 0);

        lblPrisen = new Label("" + Service.beregnSamletPris(tilmelding));
        gridPane.add(lblPrisen, 1, 0);

        lblTilmeldt = new Label("Du har tilmedt:");
        gridPane.add(lblTilmeldt, 0, 1);

        lblTilKonference = new Label(Service.getKonferenceNavn(tilmelding));
        gridPane.add(lblTilKonference, 1, 1);

        String ledsagerOvernatning = "";
        if (Service.hasLedsager(tilmelding) && Service.hasOvernatning(tilmelding)) {
            ledsagerOvernatning = "Med ledsager og overnatning.";
        } else if (Service.hasLedsager(tilmelding)) {
            ledsagerOvernatning = "Med ledsager.";
        } else if (Service.hasOvernatning(tilmelding)) {
            ledsagerOvernatning = "Med overnatning.";
        }
        lblLedsagerOgOvernatning = new Label(ledsagerOvernatning);
        gridPane.add(lblLedsagerOgOvernatning, 0, 2);

        btnBekraeft = GUITools.stdButton("Bekraeft");
        gridPane.add(btnBekraeft, 0, 4);
        btnBekraeft.setOnAction(event -> bekraeft());

        btnAnnuller = GUITools.stdButton("Annuller");
        gridPane.add(btnAnnuller, 1, 4);
        btnAnnuller.setOnAction(event -> annuller(tilmelding));
    }

    private void bekraeft() {
    	mainStage.close();
        close();
    }

    private void annuller(Tilmelding tilmelding) {
        Service.removeTilmelding(tilmelding);
        close();
    }

}
