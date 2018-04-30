package guifx;

import java.util.ArrayList;

import application.model.Deltager;
import application.service.Service;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class KASDeltagerPane extends GridPane {
    private Image KASkas = GUITools.kasKas();
    private KASTilmeldDeltagerWindow stage;
    private TextField txfDeltagernavn, txfTlfnr, txfAdresse, txfBy, txfLand, txfFirma, txfFirmaTlfnr;
    private Label lblDeltagernavn, lblTlfnr, lblAdresse, lblBy, lblLand, lblFirma, lblFirmaTlfnr;

    public KASDeltagerPane(KASTilmeldDeltagerWindow stage) {
        // setGridLinesVisible(true);
        this.stage = stage;
        setPadding(new Insets(20));
        setHgap(20);
        setVgap(10);

        HBox imgBox = new HBox();
        imgBox.getChildren().add(new ImageView(KASkas));
        imgBox.setAlignment(Pos.BASELINE_RIGHT);
        add(imgBox, 2, 0);

        lblDeltagernavn = new Label("Deltagernavn*");
        txfDeltagernavn = GUITools.stdTextField();

        VBox vbDeltagernavn = new VBox();

        vbDeltagernavn.getChildren().add(lblDeltagernavn);
        vbDeltagernavn.getChildren().add(txfDeltagernavn);
        add(vbDeltagernavn, 0, 1);

        lblTlfnr = new Label("Tlf.nr.*");
        txfTlfnr = GUITools.stdTextField();
        VBox vbTlfnr = new VBox();

        vbTlfnr.getChildren().add(lblTlfnr);
        vbTlfnr.getChildren().add(txfTlfnr);
        add(vbTlfnr, 1, 1);

        Button btnFindTlfnr = GUITools.stdButton("Find tlf.nr.");
        GridPane.setValignment(btnFindTlfnr, VPos.BOTTOM);
        add(btnFindTlfnr, 2, 1);

        lblAdresse = new Label("Adresse*");
        txfAdresse = GUITools.stdTextField();
        VBox vbAdresse = new VBox();

        vbAdresse.getChildren().add(lblAdresse);
        vbAdresse.getChildren().add(txfAdresse);
        add(vbAdresse, 0, 2);

        lblBy = new Label("By*");
        txfBy = GUITools.stdTextField();
        VBox vbBy = new VBox();

        vbBy.getChildren().add(lblBy);
        vbBy.getChildren().add(txfBy);
        add(vbBy, 1, 2);

        lblLand = new Label("Land*");
        txfLand = GUITools.stdTextField();
        VBox vbLand = new VBox();

        vbLand.getChildren().add(lblLand);
        vbLand.getChildren().add(txfLand);
        add(vbLand, 2, 2);

        lblFirma = new Label("Firma");
        txfFirma = GUITools.stdTextField();
        VBox vbFirma = new VBox();

        vbFirma.getChildren().add(lblFirma);
        vbFirma.getChildren().add(txfFirma);
        add(vbFirma, 0, 3);

        lblFirmaTlfnr = new Label("Firma Tlf.nr.");
        txfFirmaTlfnr = GUITools.stdTextField();
        VBox vbFirmaTlfnr = new VBox();

        vbFirmaTlfnr.getChildren().add(lblFirmaTlfnr);
        vbFirmaTlfnr.getChildren().add(txfFirmaTlfnr);
        add(vbFirmaTlfnr, 1, 3);

        btnFindTlfnr.setOnAction(event -> findNummer());
    }

    public Deltager getDeltagerInformation() {
        
        String deltagerTlfnr = txfTlfnr.getText().replaceAll(" ", "");

        //Hvis deltageren findes i forvejen, bruges det gamle objekt
        if(Service.getDeltager(deltagerTlfnr) != null) {
        	return Service.getDeltager(deltagerTlfnr);
        }
        
        String deltagerNavn = txfDeltagernavn.getText();
        String deltagerAdresse = txfAdresse.getText();
        String deltagerBy = txfBy.getText();
        String deltagerLand = txfLand.getText();
        
        Deltager deltager = Service.createDeltager(deltagerNavn, deltagerAdresse, deltagerBy, deltagerLand,
                deltagerTlfnr);
        return deltager;
    }
    
   public Boolean isRequiredFilled() {
	   ArrayList<TextField> requiredFields = new ArrayList<>();
	   requiredFields.add(txfDeltagernavn);
	   requiredFields.add(txfAdresse);
	   requiredFields.add(txfBy);
	   requiredFields.add(txfLand);
	   requiredFields.add(txfTlfnr);
	   ArrayList<String> missingFields = new ArrayList<>();
	   
	   if(txfDeltagernavn.getText().isEmpty()) {
		   missingFields.add("Deltagernavn");
	   }
	   if(txfAdresse.getText().isEmpty()) {
		   missingFields.add("Adresse");
	   }
	   if(txfBy.getText().isEmpty()) {
		   missingFields.add("By");
	   }
	   if(txfLand.getText().isEmpty()) {
		   missingFields.add("Land");
	   }
	   if(txfTlfnr.getText().isEmpty()) {
		   missingFields.add("Tlfnr.");
	   }
	   
	   if(missingFields.isEmpty()) {
		  return true;
	   }
	   
	   String missingFieldString = "";
	   
	  
	   for (String s : missingFields) {
		   missingFieldString += s + ", ";
	   }
	   
	   missingFieldString = missingFieldString.substring(0, missingFieldString.length()-2);
	   
	   Alert alert = new Alert(AlertType.INFORMATION);
	   alert.setHeaderText("Foelgende felter mangler at blive udfyldt.");
	   alert.setContentText(missingFieldString);
	   alert.showAndWait();
	   return false;
	   
   }

    public String getTest() {
        return txfDeltagernavn.getText();
    }
    
    private void findNummer() {
    	String tlfNr = txfTlfnr.getText().replaceAll(" ", "");
    	Deltager deltager = Service.getDeltager(tlfNr);
    	if (deltager != null) {
    		txfDeltagernavn.setText(deltager.getNavn());
    		txfAdresse.setText(deltager.getAdresse());
    		txfBy.setText(deltager.getBy());
    		txfLand.setText(deltager.getLand());
    	}
    	
    	
    	
    }

}
