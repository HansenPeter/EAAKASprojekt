package guifx;

import java.time.LocalDate;
import java.util.ArrayList;

import application.model.Deltager;
import application.model.Konference;
import application.model.Tilmelding;
import application.model.Udflugt;
import application.service.Service;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KASTilmeldDeltagerWindow extends Stage {

    private ArrayList<Konference> konferencer;
    private ArrayList<Udflugt> udflugter;
    private Konference curKonference;
    KASOvernatningPane overnatningPane;
    KASLedsagerPane ledsagerPane;
    KASKonferencePane konferencePane;
    KASDeltagerPane deltagerPane;
    Button btnOK, btnAnnuller;

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
        GridPane gridPane = new GridPane();
        initTabPane(tabPane);
        pane.setCenter(tabPane);

        btnOK = GUITools.stdButton("OK");

        btnAnnuller = GUITools.stdButton("Annuller");

        pane.setBottom(gridPane);
        gridPane.setHgap(20);
        gridPane.setPadding(new Insets(20));
        gridPane.add(btnOK, 0, 0);
        gridPane.add(btnAnnuller, 1, 0);

        btnAnnuller.setOnAction(event -> cancelAction());
        btnOK.setOnAction(event -> okAction());

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

        konferencePane = new KASKonferencePane(this);
        tabKonference.setContent(konferencePane);

        deltagerPane = new KASDeltagerPane(this);
        tabDeltager.setContent(deltagerPane);

        ledsagerPane = new KASLedsagerPane(this);
        tabLedsager.setContent(ledsagerPane);

        overnatningPane = new KASOvernatningPane(this);
        tabOvernatning.setContent(overnatningPane);

    }

    void cancelAction() {
        close();
    }

    public void updateCurKonference() {
        ledsagerPane.updateUdflugter();
        overnatningPane.updateBeboelser();
    }

    public void setKonferencer(ArrayList<Konference> konferencer) {
        this.konferencer = konferencer;
    }

    public void setUdflugter(ArrayList<Udflugt> udflugter) {
        this.udflugter = udflugter;
    }

    public ArrayList<Konference> getKonferencer() {
        return new ArrayList<>(konferencer);
    }

    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    public Konference getCurKonference() {
        return curKonference;
    }

    public void setCurKonference(Konference curKonference) {
        this.curKonference = curKonference;
    }

    private void okAction() {
        // close();
        Deltager deltager = deltagerPane.getDeltagerInformation();
        Konference konference = konferencePane.getKonference();
        LocalDate ankomstdato = konferencePane.getAnkomstdato();
        LocalDate afrejsedato = konferencePane.getAfrejsedato();
        Boolean isForedragsholder = konferencePane.isForedragsholder();
        Tilmelding tilmelding = Service.createTilmelding(deltager, konference, ankomstdato, afrejsedato,
                isForedragsholder);
        KASDeltagerBekraeftelse bekraeftelsesWindow = new KASDeltagerBekraeftelse(tilmelding);
        bekraeftelsesWindow.showAndWait();
    }

}
