package guifx;

import java.util.ArrayList;

import application.model.Konference;
import application.service.Service;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KASTilmeldDeltagerWindow extends Stage {

    private ArrayList<Konference> konferencer;

    public KASTilmeldDeltagerWindow() {
        setTitle("Tilmeld Deltager");
        BorderPane pane = new BorderPane();

        konferencer = Service.getKonferencer();

        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);
    }

    // -------------------------------------------------------------------------
    private void initContent(BorderPane pane) {

        TabPane tabPane = new TabPane();
        initTabPane(tabPane);
        pane.setCenter(tabPane);

    }

    private void initTabPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

        Tab tabKonference = new Tab("Konference");
        tabPane.getTabs().add(tabKonference);
        Tab tabDeltager = new Tab("Deltager");
        tabPane.getTabs().add(tabDeltager);
        Tab tabLedsager = new Tab("Ledsager");
        tabPane.getTabs().add(tabLedsager);
        Tab tabOvernatning = new Tab("Overnatning");
        tabPane.getTabs().add(tabOvernatning);

        KASKonferencePane konferencePane = new KASKonferencePane(konferencer);
        tabKonference.setContent(konferencePane);

        KASDeltagerPane deltagerPane = new KASDeltagerPane(this);
        tabDeltager.setContent(deltagerPane);

        KASLedsagerPane ledsagerPane = new KASLedsagerPane();
        tabLedsager.setContent(ledsagerPane);

        KASOvernatningPane overnatningPane = new KASOvernatningPane();
        tabOvernatning.setContent(overnatningPane);

    }

    void cancelAction() {
        hide();
    }
}
