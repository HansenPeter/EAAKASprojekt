package guifx;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class KASDeltagerPane extends GridPane {
    Image KASkas = GUITools.kasKas();

    public KASDeltagerPane() {
        // setGridLinesVisible(true);
        setPadding(new Insets(20));
        setHgap(20);
        setVgap(5);

        add(new ImageView(KASkas), 2, 0);

        Label lblDeltagernavn = new Label("Deltagernavn*");
        add(lblDeltagernavn, 0, 1);
        TextField txfDeltagernavn = GUITools.stdTextField();
        add(txfDeltagernavn, 0, 2);

        Label lblTlfnr = new Label("Tlf.nr.*");
        add(lblTlfnr, 1, 1);
        TextField txfTlfnr = GUITools.stdTextField();
        add(txfTlfnr, 1, 2);

        Button btnFindTlfnr = GUITools.stdButton("Find tlf.nr.");
        add(btnFindTlfnr, 2, 2);

    }
}
