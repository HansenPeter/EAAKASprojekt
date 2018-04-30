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
import javafx.scene.control.CheckBox;
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
    private ComboBox<Beboelse> cbbBeboelse;
    private ArrayList<Beboelse> alBeboelser;
    private VBox vbBeboelse, vbServices;
    private ListView<application.model.Service> lvwServices;
    private ArrayList<application.model.Service> alServices;
    private HBox imgBox;
    private KASTilmeldDeltagerWindow stage;
    private Konference curKonference;
    private Beboelse curBeboelse;
    private CheckBox chbOvernatning;
    private ArrayList<application.model.Service> selectedServices;

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

        chbOvernatning = new CheckBox("Book overnatning");
        add(chbOvernatning, 0, 0);
        chbOvernatning.setOnAction(event -> toggleOvernatning(chbOvernatning.isSelected()));

        vbBeboelse = new VBox();

        lblBeboelse = new Label("Beboelse");
        cbbBeboelse = new ComboBox<>();
        cbbBeboelse.setMinWidth(190);
        cbbBeboelse.setMaxWidth(190);
        cbbBeboelse.setDisable(true);

        cbbBeboelse.setOnAction(event -> updateControls());
        

        curKonference = stage.getCurKonference();

        this.alBeboelser = Service.getBeboelser(curKonference);

        if (alBeboelser.isEmpty()) {
            cbbBeboelse.getItems().setAll();

        } else {
            cbbBeboelse.getItems().addAll(alBeboelser);
        }
        


        vbBeboelse.getChildren().add(lblBeboelse);
        vbBeboelse.getChildren().add(cbbBeboelse);
        add(vbBeboelse, 0, 1);

        vbServices = new VBox();
        lblServices = new Label("Services");
        lvwServices = new ListView<>();
        lvwServices.setDisable(true);

        cbbBeboelse.getSelectionModel().select(0);
        curBeboelse = cbbBeboelse.getSelectionModel().getSelectedItem();
        // TODO: FIX PLS
        if (curBeboelse != null) {
            alServices = Service.getServices(curBeboelse);
        } else {
            alServices = new ArrayList<>();
        }

        vbServices.getChildren().add(lblServices);
        vbServices.getChildren().add(lvwServices);
        add(vbServices, 1, 1);

        ArrayList<String> alTest = new ArrayList<>();
        alTest.add("Test");
        alTest.add("Test2");
        lvwServices.getItems().addAll(alServices);
        selectedServices = new ArrayList<>();
        lvwServices.setCellFactory(
                CheckBoxListCell.forListView(new Callback<application.model.Service, ObservableValue<Boolean>>() {

                    @Override
                    public ObservableValue<Boolean> call(application.model.Service service) {
                        BooleanProperty observable = new SimpleBooleanProperty();
                        observable.addListener((obs, wasSelected, isNowSelected) -> {
                            if (isNowSelected) {
                                selectedServices.add(service);
                            } else if (wasSelected) {
                                selectedServices.remove(service);
                            }
                        });
                        return observable;
                    }
                }));

        lvwServices.setMinWidth(GUITools.WIDTH*2+20);
        
    }

    public void updateControls() {

        this.curKonference = stage.getCurKonference();
        this.alBeboelser = Service.getBeboelser(curKonference);
        this.curBeboelse = cbbBeboelse.getSelectionModel().getSelectedItem();
        if (curBeboelse != null) {
            this.alServices = Service.getServices(curBeboelse);
        } else {
            this.alServices = new ArrayList<>();
        }

        this.lvwServices.getItems().setAll(alServices);

        // KASOvernatning.updateControls()
        // KASLedsager.updateControls()
    }

    public void updateBeboelser() {
        this.curKonference = stage.getCurKonference();

        this.alBeboelser = Service.getBeboelser(curKonference);

        cbbBeboelse.getItems().setAll(alBeboelser);

        this.lvwServices.getItems().setAll(alServices);
    }

    private void toggleOvernatning(Boolean isSelected) {
        cbbBeboelse.setDisable(!isSelected);
        lvwServices.setDisable(!isSelected);
    }

    public Boolean hasOvernatning() {
        return chbOvernatning.isSelected();
    }

    public Beboelse getBeboelse() {
        return curBeboelse;
    }

    public ArrayList<application.model.Service> getServices() {

        return new ArrayList<>(selectedServices);
    }

}
