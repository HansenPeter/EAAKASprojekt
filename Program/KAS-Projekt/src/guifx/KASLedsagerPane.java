package guifx;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class KASLedsagerPane extends GridPane {
    Image KASkas = new Image("File:resources/Kaskas.png");

    public KASLedsagerPane() {
        super();

        setGridLinesVisible(true);
        setPadding(new Insets(20));
        setHgap(20);
        setVgap(10);

        add(new ImageView(KASkas), 2, 0);
    }
}
