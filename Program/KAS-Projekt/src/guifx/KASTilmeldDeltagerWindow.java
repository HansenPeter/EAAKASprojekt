package guifx;

import java.time.LocalDate;
import java.util.ArrayList;
import application.model.Deltager;
import application.model.Konference;
import application.model.Ledsager;
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

        deltagerPane = new KASDeltagerPane();
        tabDeltager.setContent(deltagerPane);

        ledsagerPane = new KASLedsagerPane(konferencePane);
        tabLedsager.setContent(ledsagerPane);

        overnatningPane = new KASOvernatningPane(konferencePane);
        tabOvernatning.setContent(overnatningPane);

    }

    void cancelAction() {
        close();
    }

    // tager den valgte konference fra konferencePane og opdaterer lister og comboboxes, saa de afspejler valget.
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

    private void okAction() {
    	//Tjekker om de noedvendige felter er udfylt - viser en alert hvis ikke
    	if(deltagerPane.isRequiredFilled()) {
    		
	        Deltager deltager = deltagerPane.getDeltagerInformation();
	        Konference konference = konferencePane.getKonference();
	        LocalDate ankomstdato = konferencePane.getAnkomstdato();
	        LocalDate afrejsedato = konferencePane.getAfrejsedato();
	        Boolean isForedragsholder = konferencePane.isForedragsholder();
	        Tilmelding tilmelding = Service.createTilmelding(deltager, konference, ankomstdato, afrejsedato,
	                isForedragsholder);
	        Ledsager ledsager;
	        if (ledsagerPane.hasLedsager()) {
	            ledsager = tilmelding.createLedsager(ledsagerPane.getLedsagernavn());
	            for (Udflugt u : ledsagerPane.getUdflugter()) {
	                ledsager.addUdflugt(u);
	            }
	        }
	        if (overnatningPane.hasOvernatning()) {
	            Service.createBooking(tilmelding, overnatningPane.getServices(),
	                    overnatningPane.getBeboelse());
	        }
	
	        KASDeltagerBekraeftelse bekraeftelsesWindow = new KASDeltagerBekraeftelse(tilmelding, this);
	        bekraeftelsesWindow.showAndWait();
    	} else {
    		//do nothing
    	}
    }
    
    

}
