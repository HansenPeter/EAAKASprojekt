package guifx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class KASDeltagerPane extends GridPane {
    Image KASkas = GUITools.kasKas();
    KASTilmeldDeltagerWindow stage;

    public KASDeltagerPane(KASTilmeldDeltagerWindow stage) {
        this.stage = stage;
        setPadding(new Insets(20));
        setHgap(20);
        setVgap(5);

        HBox imgBox = new HBox();
        imgBox.getChildren().add(new ImageView(KASkas));
        imgBox.setAlignment(Pos.BASELINE_RIGHT);
        add(imgBox, 2, 0);

        Label lblDeltagernavn = new Label("Deltagernavn*");
        TextField txfDeltagernavn = GUITools.stdTextField();
        VBox vbDeltagernavn = new VBox();

        vbDeltagernavn.getChildren().add(lblDeltagernavn);
        vbDeltagernavn.getChildren().add(txfDeltagernavn);
        add(vbDeltagernavn, 0, 1);

        Label lblTlfnr = new Label("Tlf.nr.*");
        TextField txfTlfnr = GUITools.stdTextField();
        VBox vbTlfnr = new VBox();

        vbTlfnr.getChildren().add(lblTlfnr);
        vbTlfnr.getChildren().add(txfTlfnr);
        add(vbTlfnr, 1, 1);

        Button btnFindTlfnr = GUITools.stdButton("Find tlf.nr.");
        GridPane.setValignment(btnFindTlfnr, VPos.BOTTOM);
        add(btnFindTlfnr, 2, 1);

        Label lblAdresse = new Label("Adresse*");
        TextField txfAdresse = GUITools.stdTextField();
        VBox vbAdresse = new VBox();

        vbAdresse.getChildren().add(lblAdresse);
        vbAdresse.getChildren().add(txfAdresse);
        add(vbAdresse, 0, 2);

        Label lblBy = new Label("By*");
        TextField txfBy = GUITools.stdTextField();
        VBox vbBy = new VBox();

        vbBy.getChildren().add(lblBy);
        vbBy.getChildren().add(txfBy);
        add(vbBy, 1, 2);

        Label lblLand = new Label("Land*");
        TextField txfLand = GUITools.stdTextField();
        VBox vbLand = new VBox();

        vbLand.getChildren().add(lblLand);
        vbLand.getChildren().add(txfLand);
        add(vbLand, 2, 2);

        Label lblFirma = new Label("Firma");
        TextField txfFirma = GUITools.stdTextField();
        VBox vbFirma = new VBox();

        vbFirma.getChildren().add(lblFirma);
        vbFirma.getChildren().add(txfFirma);
        add(vbFirma, 0, 3);

        Label lblFirmaTlfnr = new Label("Firma Tlf.nr.");
        TextField txfFirmaTlfnr = GUITools.stdTextField();
        VBox vbFirmaTlfnr = new VBox();

        vbFirmaTlfnr.getChildren().add(lblFirmaTlfnr);
        vbFirmaTlfnr.getChildren().add(txfFirmaTlfnr);
        add(vbFirmaTlfnr, 1, 3);

        Button btnOK = GUITools.stdButton("OK");
        btnOK.setTextAlignment(TextAlignment.CENTER);
        add(btnOK, 0, 5);

        Button btnAnnuller = GUITools.stdButton("Annuller");
        btnAnnuller.setTextAlignment(TextAlignment.CENTER);
        add(btnAnnuller, 2, 5);

        btnAnnuller.setOnAction(event -> cancelAction());
        btnOK.setOnAction(event -> okAction());
    }

    private void cancelAction() {
        stage.cancelAction();
    }

    private void okAction() {
        stage.cancelAction();
    }

}
