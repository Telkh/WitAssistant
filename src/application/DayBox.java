package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DayBox extends Group {
	
	private int dayNum = 0;
	private int boxWidth;
	private int boxLength;
	private Label dayLabel;
	private Rectangle calBox;
	private int labelYPos = 0;
	public DayBox(int length, int width, int day) {
		dayNum = day;
		boxWidth = width;
		boxLength = length;
		calBox = new Rectangle(0,0,length,width);
		calBox.setStroke(Color.GRAY);
		calBox.setStrokeWidth(.15);
		calBox.setFill(Color.WHITE);
		dayLabel = new Label(Integer.toString(dayNum));
		dayLabel.setLayoutX(5);
		dayLabel.setLayoutY(5);
		getChildren().addAll(calBox,dayLabel);
		EventTime.setDay(day);
	}
	
	private void drawEventLabel(String eventTitle) {
		labelYPos += 25;
		FontLoader fontLoader = Toolkit.getToolkit().getFontLoader();
		Label eventLabel = new Label(eventTitle);
		double labelWidth = fontLoader.computeStringWidth(eventLabel.getText(), eventLabel.getFont());
		eventLabel.setLayoutY(labelYPos);
		eventLabel.setLayoutX((boxLength / 2) - (labelWidth) / 2);
		getChildren().add(eventLabel);
		
	}
	
	public void drawEvents(ArrayList<Event> eventList) {
		String eventTitle = "";
		Event tempEvent;
		for(int i = 0; i < eventList.size(); i++) {
			tempEvent = eventList.get(i);
			drawEventLabel(tempEvent.getEventTitle());
		}
	}
	
	public int getDay() {
		return dayNum;
	}
}
