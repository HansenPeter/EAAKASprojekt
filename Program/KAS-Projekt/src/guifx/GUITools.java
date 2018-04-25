package guifx;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

public class GUITools {

	public static Button stdButton(String tekst) {
		Button btn = new Button(tekst);
		btn.setMinWidth(120);
		return btn;

	}

	public static TextField stdTextField() {
		TextField txf = new TextField();
		txf.setMinWidth(120);
		txf.setMaxWidth(120);

		return txf;
	}

	public static Button bigButton(String tekst) {
		Button btn = new Button(tekst);
		btn.setMinSize(150, 100);

		return btn;
	}

	public static Image kasKas() {
		return new Image("File:resources/Kaskas.png");
	}

}
