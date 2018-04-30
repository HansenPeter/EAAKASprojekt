package guifx;

import java.time.LocalDate;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

public class GUITools {
	public  static final double WIDTH = 190;

	public static Button stdButton(String tekst) {
		Button btn = new Button(tekst);
		btn.setMinWidth(WIDTH);
		return btn;

	}

	public static TextField stdTextField() {
		TextField txf = new TextField();
		txf.setMinWidth(WIDTH);
		txf.setMaxWidth(WIDTH);

		return txf;
	}

	public static Image kasKas() {
		return new Image("File:resources/Kaskas.png");
	}
	
	public static DatePicker stdDatePicker(LocalDate date) {
		DatePicker stdDp = new DatePicker(date);
		stdDp.setMinWidth(WIDTH);
		stdDp.setMaxWidth(WIDTH);
		return stdDp;
	}
	


}
