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

    public KASDeltagerBekraeftelse(Tilmelding tilmelding) {
        // Subject to change
        this.tilmelding = tilmelding;
        setTitle("KAS Money");
        GridPane gridPane = new GridPane();
        initContent(gridPane);

        Scene scene = new Scene(gridPane);
        setScene(scene);
    }

    Tilmelding tilmelding;
    Label lblTilmeldt, lblDeltagernavn, lblTilKonference, lblKonferenceNavn, lblLedsagerOgOvernatning, lblSamletPris,
            lblPrisen;
    Button btnBekraeft, btnAnnuller;

    public void initContent(GridPane gridPane) {
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(5);

        lblSamletPris = new Label("Samlet Pris:");
        gridPane.add(lblSamletPris, 0, 0);

        // skal hentes fra service klassen
        lblPrisen = new Label("" + Service.beregnSamletPris(tilmelding));
        gridPane.add(lblPrisen, 1, 0);

        lblTilmeldt = new Label("Du har tilmedt:");
        gridPane.add(lblTilmeldt, 0, 1);

        lblTilKonference = new Label(Service.getKonferenceNavn(tilmelding));
        gridPane.add(lblTilKonference, 1, 1);

        // To implement
        // lblLedsager og lblOvernatning

        btnBekraeft = GUITools.stdButton("Bekraeft");
        gridPane.add(btnBekraeft, 0, 4);
        btnBekraeft.setOnAction(event -> bekraeft());

        btnAnnuller = GUITools.stdButton("Annuller");
        gridPane.add(btnAnnuller, 1, 4);
        btnAnnuller.setOnAction(event -> annuller(tilmelding));
    }

    private void bekraeft() {
        // TODO Auto-generated method stub
        close();
    }

    private void annuller(Tilmelding tilmelding) {
        Service.removeTilmelding(tilmelding);
        close();
    }

}
