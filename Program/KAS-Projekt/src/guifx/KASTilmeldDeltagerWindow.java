package guifx;

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

    public KASTilmeldDeltagerWindow() {
        setTitle("Tilmeld Deltager");
        BorderPane pane = new BorderPane();
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

        Tab tabDeltager = new Tab("Deltager");
        tabPane.getTabs().add(tabDeltager);
        Tab tabLedsager = new Tab("Ledsager");
        tabPane.getTabs().add(tabLedsager);
        Tab tabOvernatning = new Tab("Overnatning");
        tabPane.getTabs().add(tabOvernatning);
        Tab tabKonference = new Tab("Konference");
        tabPane.getTabs().add(tabKonference);

        KASDeltagerPane deltagerPane = new KASDeltagerPane();
        tabDeltager.setContent(deltagerPane);

        KASLedsagerPane ledsagerPane = new KASLedsagerPane();
        tabLedsager.setContent(ledsagerPane);

        KASOvernatningPane overnatningPane = new KASOvernatningPane();
        tabOvernatning.setContent(overnatningPane);

        KASKonferencePane konferencePane = new KASKonferencePane();
        tabKonference.setContent(konferencePane);

    }
}
