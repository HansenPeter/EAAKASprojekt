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
    private KASKonferencePane konferencePane;
    private Konference curKonference;
    private Beboelse curBeboelse;
    private CheckBox chbOvernatning;
    
    //holder styr paa de services brugeren har valgt i oejeblikket
    private ArrayList<application.model.Service> selectedServices = new ArrayList<>();

    public KASOvernatningPane(KASKonferencePane konferencePane) {
        this.konferencePane = konferencePane;

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
        chbOvernatning.setDisable(true);
        
        vbBeboelse = new VBox();

        lblBeboelse = new Label("Beboelse");
        cbbBeboelse = new ComboBox<>();
        cbbBeboelse.setMinWidth(190);
        cbbBeboelse.setMaxWidth(190);
        cbbBeboelse.setDisable(true);

        cbbBeboelse.setOnAction(event -> updateControls());
        
        curKonference = konferencePane.getKonference();

        this.alBeboelser = Service.getBeboelser(curKonference);
        
        //hvis der er nogle tilgaengelige overnatninger, skal knappen vaere enabled.
        if(!alBeboelser.isEmpty()) {
        	chbOvernatning.setDisable(false);
        }
        
        cbbBeboelse.getItems().setAll(alBeboelser);

        vbBeboelse.getChildren().add(lblBeboelse);
        vbBeboelse.getChildren().add(cbbBeboelse);
        add(vbBeboelse, 0, 1);

        vbServices = new VBox();
        lblServices = new Label("Services");
        lvwServices = new ListView<>();
        lvwServices.setDisable(true);

        cbbBeboelse.getSelectionModel().select(0);
        curBeboelse = cbbBeboelse.getSelectionModel().getSelectedItem();
        
        // hvis der ikke er nogle tilgaengelige beboelser, vises en tom liste
        if (curBeboelse != null) {
        	alServices = Service.getServices(curBeboelse);
        } else {
            alServices = new ArrayList<>();
        }

        vbServices.getChildren().add(lblServices);
        vbServices.getChildren().add(lvwServices);
        add(vbServices, 1, 1);

        lvwServices.getItems().addAll(alServices);
        
        //Laver saetter en cellfactory med checkboxes i listviewet, hvor checkboxen hhv. tilfoejer eller fjerner
        //en service fra brugerens valg
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
        //Opdaterer overnatningsPane med services alt efter valgt beboelse
        this.curBeboelse = cbbBeboelse.getSelectionModel().getSelectedItem();
        if (curBeboelse != null) {
            this.alServices = Service.getServices(curBeboelse);
        } else {
            this.alServices = new ArrayList<>();
        }
        
        this.selectedServices.clear();
        this.lvwServices.getItems().setAll(alServices);

    }

    public void updateBeboelser() {
    	//Opdaterer overnatningsPane for at afspejle en ny konference. 
    	//Bliver kaldt naar der vaelges en konference i konferencePane
        this.curKonference = konferencePane.getKonference();

        this.alBeboelser = Service.getBeboelser(curKonference);
        if(!alBeboelser.isEmpty()) {
        	chbOvernatning.setDisable(false);
        } else {
        	chbOvernatning.setDisable(true);
        	chbOvernatning.setSelected(false);
        	toggleOvernatning(false);
        }
        
        cbbBeboelse.getItems().setAll(alBeboelser);
        cbbBeboelse.getSelectionModel().select(0);

        
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
