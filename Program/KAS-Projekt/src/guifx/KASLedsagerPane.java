package guifx;

import java.util.ArrayList;

import application.model.Konference;
import application.service.Service;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;

public class KASLedsagerPane extends GridPane {
    private Image KASkas = GUITools.kasKas();
    private HBox imgBox;
    private Label lblLedsagernavn, lblUdflugter;
    private TextField txfLedsagernavn;
    private VBox vbLedsagernavn, vbUdflugter;
    private ListView<String> lvwUdflugter;
    private ArrayList<Konference> konferencer = Service.getKonferencer();

    public KASLedsagerPane() {

        setGridLinesVisible(true);
        setPadding(new Insets(20));
        setHgap(20);
        setVgap(10);

        imgBox = new HBox();
        imgBox.getChildren().add(new ImageView(KASkas));
        imgBox.setAlignment(Pos.BASELINE_RIGHT);
        add(imgBox, 1, 0);

        vbLedsagernavn = new VBox();

        lblLedsagernavn = new Label("Ledsagernavn");
        txfLedsagernavn = GUITools.stdTextField();

        vbLedsagernavn.getChildren().add(lblLedsagernavn);
        vbLedsagernavn.getChildren().add(txfLedsagernavn);
        add(vbLedsagernavn, 0, 1);

        vbUdflugter = new VBox();
        lblUdflugter = new Label("Udflugter");
        lvwUdflugter = new ListView<>();
        vbUdflugter.getChildren().add(lblUdflugter);
        vbUdflugter.getChildren().add(lvwUdflugter);
        add(vbUdflugter, 1, 1);

        ArrayList<String> alTest = new ArrayList<>();
        alTest.add("Test");
        alTest.add("Test2");
        lvwUdflugter.getItems().addAll(alTest);
        lvwUdflugter.setCellFactory(CheckBoxListCell.forListView(new Callback<String, ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(String string) {
                BooleanProperty observable = new SimpleBooleanProperty();
                return observable;
            }
        }));

    }
}
