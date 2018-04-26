package guifx;

import java.time.LocalDate;
import java.util.ArrayList;

import application.model.Konference;
import application.service.Service;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class KASKonferencePane extends GridPane {
    Image KASkas = GUITools.kasKas();
    private Label lblAnkomstdato, lblAfrejsedato;
    private ComboBox<Konference> cbbKonference;
    private VBox vbAnkomstdato, vbAfrejsedato;
    private CheckBox chbForedragsholder;
    private HBox imgBox;
    private KASTilmeldDeltagerWindow stage;
    private Konference curKonference;
    private ArrayList<Konference> konferencer;

    private Callback<DatePicker, DateCell> cfAnkomstdato;
    private Callback<DatePicker, DateCell> cfAfrejsedato;
    LocalDate startDato;
    LocalDate slutDato;

    private DatePicker dpAnkomstdato, dpAfrejsedato;

    private TextField txfAnkomstdato, txfAfrejsedato;

    public KASKonferencePane(KASTilmeldDeltagerWindow stage) {
    	
    	this.stage = stage;

        setGridLinesVisible(true);
        setPadding(new Insets(20));
        setHgap(20);
        setVgap(10);
        imgBox = new HBox();
        imgBox.getChildren().add(new ImageView(KASkas));
        imgBox.setAlignment(Pos.BASELINE_RIGHT);
        add(imgBox, 2, 0);
        
        konferencer = stage.getKonferencer();
        
        cbbKonference = new ComboBox<>();
        cbbKonference.getItems().addAll(konferencer);
        cbbKonference.getSelectionModel().select(0);
        GridPane.setValignment(cbbKonference, VPos.BOTTOM);
        add(cbbKonference, 2, 1);

        cbbKonference.setOnAction(event -> updateUdflugterPane());
        cbbKonference.setMaxWidth(150);
        this.stage.setCurKonference(cbbKonference.getSelectionModel().getSelectedItem());
        this.curKonference = stage.getCurKonference();

        vbAnkomstdato = new VBox();

        stage.setCurKonference(cbbKonference.getSelectionModel().getSelectedItem());
        startDato = Service.getKonferenceStartdato(curKonference);
        slutDato = Service.getKonferenceSlutdato(curKonference);
        dpAnkomstdato = new DatePicker(startDato);
        dpAfrejsedato = new DatePicker(slutDato);

        cfAfrejsedato = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item.isBefore(dpAnkomstdato.getValue()) || item.isAfter(slutDato)) {
                            setDisable(true);
                        }

                    }
                };
            }
        };

        cfAnkomstdato = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item.isAfter(dpAfrejsedato.getValue()) || item.isBefore(startDato)) {
                            setDisable(true);
                        }

                    }
                };
            }
        };

        dpAfrejsedato.setDayCellFactory(cfAfrejsedato);
        dpAnkomstdato.setDayCellFactory(cfAnkomstdato);
        dpAfrejsedato.setEditable(false);
        dpAnkomstdato.setEditable(false);
        dpAnkomstdato.setMaxWidth(150);
        dpAfrejsedato.setMaxWidth(150);

        lblAnkomstdato = new Label("Ankomstdato");
        txfAnkomstdato = GUITools.stdTextField();

        vbAnkomstdato.getChildren().add(lblAnkomstdato);
        vbAnkomstdato.getChildren().add(dpAnkomstdato);
        add(vbAnkomstdato, 0, 1);

        vbAfrejsedato = new VBox();

        lblAfrejsedato = new Label("Afrejsedato");
        txfAfrejsedato = GUITools.stdTextField();

        vbAfrejsedato.getChildren().add(lblAfrejsedato);
        vbAfrejsedato.getChildren().add(dpAfrejsedato);
        add(vbAfrejsedato, 1, 1);

    }

    private void updateControls() {
        this.stage.setCurKonference(cbbKonference.getSelectionModel().getSelectedItem());
        this.curKonference = stage.getCurKonference();
        
        startDato = Service.getKonferenceStartdato(curKonference);
        slutDato = Service.getKonferenceSlutdato(curKonference);
        this.dpAfrejsedato.setValue(slutDato);
        this.dpAnkomstdato.setValue(startDato);
//        dpAfrejsedato.setDayCellFactory(cfAfrejsedato);
//        dpAnkomstdato.setDayCellFactory(cfAnkomstdato);
        //KASOvernatning.updateControls()
        //KASLedsager.updateControls()
    }
    
    private void updateUdflugterPane() {
    	updateControls();
    	stage.updateCurKonference();
    }
    
    
    
    
}
