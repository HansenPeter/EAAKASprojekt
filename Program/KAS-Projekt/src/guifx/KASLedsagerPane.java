package guifx;

import java.util.ArrayList;

import application.model.Konference;
import application.model.Udflugt;
import application.service.Service;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
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
    private ListView<Udflugt> lvwUdflugter;
    private ArrayList<Udflugt> alUdflugter;
    private Konference curKonference;
    private KASTilmeldDeltagerWindow stage;
    private CheckBox chbLedsager;
    

    public KASLedsagerPane(KASTilmeldDeltagerWindow stage) {

//        setGridLinesVisible(true);
        setPadding(new Insets(20));
        setHgap(20);
        setVgap(10);
        
        this.stage = stage;

        imgBox = new HBox();
        imgBox.getChildren().add(new ImageView(KASkas));
        imgBox.setAlignment(Pos.BASELINE_RIGHT);
        add(imgBox, 1, 0);

        chbLedsager = new CheckBox("Ledsager deltager");
        add(chbLedsager,0,0);
        chbLedsager.setOnAction(event -> toggleLedsager(chbLedsager.isSelected()));
        
        vbLedsagernavn = new VBox();

        lblLedsagernavn = new Label("Ledsagernavn");
        txfLedsagernavn = GUITools.stdTextField();
        txfLedsagernavn.setDisable(true);

        vbLedsagernavn.getChildren().add(lblLedsagernavn);
        vbLedsagernavn.getChildren().add(txfLedsagernavn);
        add(vbLedsagernavn, 0, 1);

        vbUdflugter = new VBox();
        lblUdflugter = new Label("Udflugter");
        lvwUdflugter = new ListView<>();
        lvwUdflugter.setDisable(true);
        
        vbUdflugter.getChildren().add(lblUdflugter);
        vbUdflugter.getChildren().add(lvwUdflugter);
        add(vbUdflugter, 1, 1);

        
        curKonference = stage.getCurKonference();
        alUdflugter = Service.getUdflugter(curKonference);
        lvwUdflugter.getItems().addAll(alUdflugter);
        lvwUdflugter.setCellFactory(CheckBoxListCell.forListView(new Callback<Udflugt, ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(Udflugt udflugt) {
                BooleanProperty observable = new SimpleBooleanProperty();
                return observable;
            }
        }));

    }
    
    private void toggleLedsager(boolean isSelected) {
    	txfLedsagernavn.setDisable(!isSelected);
    	lvwUdflugter.setDisable(!isSelected);
		
	}

	public void updateControls() {
        
        this.curKonference = stage.getCurKonference();
        this.alUdflugter = Service.getUdflugter(curKonference);
        
        this.lvwUdflugter.getItems().addAll(alUdflugter);
        
        
        //KASOvernatning.updateControls()
        //KASLedsager.updateControls()
    }
    
    public void updateUdflugter() {
    	this.curKonference = stage.getCurKonference();
        this.alUdflugter = Service.getUdflugter(curKonference);
        
        
        this.lvwUdflugter.getItems().setAll(alUdflugter);
    }
    
    
    
    
    
    
}
