package guifx;

import java.util.ArrayList;

import application.model.Beboelse;
import application.model.Konference;
import application.service.Service;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class KASOvernatningPane extends GridPane {
    Image KASkas = GUITools.kasKas();
    private Label lblBeboelse, lblServices;
    private ComboBox<String> cbbBeboelse;
    private VBox vbBeboelse, vbServices;
    private ListView<Service> lvwServices;
    private ArrayList<Service> alServices;
    private HBox imgBox;
    private ArrayList<Beboelse> beboelser;
    private KASTilmeldDeltagerWindow stage;
	private Konference curKonference;
    
    public KASOvernatningPane(KASTilmeldDeltagerWindow stage) {
        this.stage = stage;

//        setGridLinesVisible(true);
        setPadding(new Insets(20));
        setHgap(20);
        setVgap(10);

        imgBox = new HBox();
        imgBox.getChildren().add(new ImageView(KASkas));
        imgBox.setAlignment(Pos.BASELINE_RIGHT);
        add(imgBox, 1, 0);

        vbBeboelse = new VBox();

        lblBeboelse = new Label("Beboelse");
        cbbBeboelse = new ComboBox<>();
        cbbBeboelse.setPrefWidth(150);

        vbBeboelse.getChildren().add(lblBeboelse);
        vbBeboelse.getChildren().add(cbbBeboelse);
        add(vbBeboelse, 0, 1);

        vbServices = new VBox();
        lblServices = new Label("Services");
        lvwServices = new ListView<>();
        vbServices.getChildren().add(lblServices);
        vbServices.getChildren().add(lvwServices);
        add(vbServices, 1, 1);

        ArrayList<String> alTest = new ArrayList<>();
        alTest.add("Test");
        alTest.add("Test2");
        lvwServices.getItems().addAll(alTest);
        lvwServices.setCellFactory(CheckBoxListCell.forListView(new Callback<String, ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(String string) {
                BooleanProperty observable = new SimpleBooleanProperty();
                return observable;
            }
        }));
    }

    public void updateControls() {
        
        this.curKonference = stage.getCurKonference();
        this.beboelser = Service.getBeboelser(curKonference);
        
        this.lvwServices.getItems().addAll(alUdflugter);
        
        
        //KASOvernatning.updateControls()
        //KASLedsager.updateControls()
    }
    
    public void updateBeboelser() {
    	this.curKonference = stage.getCurKonference();
        this.beboelser = Service.getBeboelser(curKonference);
        
        
        this.lvwServices.getItems().setAll(alUdflugter);
    }

}
