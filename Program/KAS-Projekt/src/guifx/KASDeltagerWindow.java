package guifx;

import application.model.Konference;
import application.service.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KASDeltagerWindow extends Stage {
	private Konference konference;
	private Label lblDeltagere;
	private ImageView kaskas = new ImageView(GUITools.kasKas());
	private ListView<String> lvwDeltagere;
	private Button btnClose;

	public KASDeltagerWindow(Konference konference) {
		// TODO Auto-generated constructor stub
		this.konference = konference;
		this.setTitle("Deltagere");
		GridPane gridPane = new GridPane();
		this.initContent(gridPane);
		Scene scene = new Scene(gridPane);
		this.setScene(scene);

	}

	private void initContent(GridPane gridPane) {
		// TODO Auto-generated method stub
		gridPane.setPadding(new Insets(10));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		gridPane.add(kaskas, 1, 0, 2, 1);
		GridPane.setHalignment(kaskas, HPos.RIGHT);

		lblDeltagere = new Label("Deltagere");
		gridPane.add(lblDeltagere, 0, 0);

		lvwDeltagere = new ListView<>();
		lvwDeltagere.getItems().setAll(Service.getDeltagere(konference));
		gridPane.add(lvwDeltagere, 0, 1);

		btnClose = GUITools.stdButton("Close");
		gridPane.add(btnClose, 1, 2);
		btnClose.setOnAction(event -> this.close());
	}
}
