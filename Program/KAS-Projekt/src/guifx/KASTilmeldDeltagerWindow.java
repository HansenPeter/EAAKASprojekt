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

public class KASTilmeldDeltagerWindow extends Stage{


	public KASTilmeldDeltagerWindow() {
		this.setTitle("Tilmeld Deltager");
		BorderPane pane = new BorderPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	// Image kasKassen = KASkas.png
	Label lblOrganisation;
	ListView lvwOrganisations;
	TextField txfOrganisationName;
	Button btnPickOrganisation;
	Button btnAddOrganisation;
	 // -------------------------------------------------------------------------
	private void initContent(BorderPane pane) {
		
		TabPane tabPane = new TabPane();
		this.initTabPane(tabPane);
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
		

		// gridPane.add(kasKassen, 1, 0);

		
	}
}

	

