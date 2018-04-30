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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class KASKonferencePane extends GridPane {
	private Image KASkas = GUITools.kasKas();
    private Label lblAnkomstdato, lblAfrejsedato;
    private ComboBox<Konference> cbbKonference;
    private VBox vbAnkomstdato, vbAfrejsedato;
    private CheckBox chbForedragsholder;
    private HBox imgBox;
    private KASTilmeldDeltagerWindow stage;
    private Konference curKonference;
    private ArrayList<Konference> konferencer;

    private Callback<DatePicker, DateCell> cbAnkomstdato;
    private Callback<DatePicker, DateCell> cbAfrejsedato;
    private LocalDate startDato;
    private LocalDate slutDato;

    private DatePicker dpAnkomstdato, dpAfrejsedato;

    public KASKonferencePane(KASTilmeldDeltagerWindow stage) {

        this.stage = stage;

        // setGridLinesVisible(true);
        setPadding(new Insets(20));
        setHgap(20);
        setVgap(10);
        imgBox = new HBox();
        imgBox.getChildren().add(new ImageView(KASkas));
        imgBox.setAlignment(Pos.BASELINE_RIGHT);
        add(imgBox, 2, 0);

        chbForedragsholder = new CheckBox("Er foredragsholder");
        add(chbForedragsholder, 0, 0);

        konferencer = stage.getKonferencer();

        //opretter en combobox med alle tilgaengelige konferencer
        cbbKonference = new ComboBox<>();
        cbbKonference.setMinWidth(190);
        cbbKonference.getItems().addAll(konferencer);
        cbbKonference.getSelectionModel().select(0);
        GridPane.setValignment(cbbKonference, VPos.BOTTOM);
        add(cbbKonference, 2, 1);

        //laver et event naar en ny konference bliver valgt
        cbbKonference.setOnAction(event -> updateCurKonference());
        //initialiserer den valgte konference, saa vi har et udgangspunkt
        this.curKonference = cbbKonference.getSelectionModel().getSelectedItem();
//        updateCurKonference();

        vbAnkomstdato = new VBox();

        startDato = Service.getKonferenceStartdato(curKonference);
        slutDato = Service.getKonferenceSlutdato(curKonference);
        dpAnkomstdato = GUITools.stdDatePicker(startDato);
        dpAfrejsedato = GUITools.stdDatePicker(slutDato);

        //opretter callbacks til vores datepickers, saa vi ikke kan vaelge datoer udenfor den valgte konference.
        cbAfrejsedato = new Callback<DatePicker, DateCell>() {
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

        cbAnkomstdato = new Callback<DatePicker, DateCell>() {
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

        //bruger Callbacks til at oprette cellerne i vores datepicker, saa nogle af dem bliver utilgaengelige.
        dpAfrejsedato.setDayCellFactory(cbAfrejsedato);
        dpAnkomstdato.setDayCellFactory(cbAnkomstdato);
        dpAfrejsedato.setEditable(false);
        dpAnkomstdato.setEditable(false);

        lblAnkomstdato = new Label("Ankomstdato");

        vbAnkomstdato.getChildren().add(lblAnkomstdato);
        vbAnkomstdato.getChildren().add(dpAnkomstdato);
        add(vbAnkomstdato, 0, 1);

        vbAfrejsedato = new VBox();

        lblAfrejsedato = new Label("Afrejsedato");

        vbAfrejsedato.getChildren().add(lblAfrejsedato);
        vbAfrejsedato.getChildren().add(dpAfrejsedato);
        add(vbAfrejsedato, 1, 1);

    }

    private void updateControls() {
    	//opdaterer konferencen i det bagvedliggende vindue, saa den kan hentes til de andre panes
        this.curKonference = cbbKonference.getSelectionModel().getSelectedItem();

        //nye datoer vaelges til datepickers efter den nye konference
        startDato = Service.getKonferenceStartdato(curKonference);
        slutDato = Service.getKonferenceSlutdato(curKonference);
        this.dpAfrejsedato.setValue(slutDato);
        this.dpAnkomstdato.setValue(startDato);
    }

    private void updateCurKonference() {
        //opdaterer konferencePane efter den nye konference
    	updateControls();
        
    	//opdaterer de andre panes, saa de afspejler den nye valgte konference
        stage.updateCurKonference();
    }

    public Konference getKonference() {
        return curKonference;
    }

    public LocalDate getAnkomstdato() {
        return dpAnkomstdato.getValue();
    }

    public LocalDate getAfrejsedato() {
        return dpAfrejsedato.getValue();
    }

    public Boolean isForedragsholder() {
        return chbForedragsholder.isSelected();
    }

}
