package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

public class LevelOneController {
	
	static Button btn1 ;
	static Button btn2 ;
	static Button btn3 ;
	
	static TextField field1=new TextField();
	static TextField field2=new TextField();
	static TextField field3=new TextField();
	
		
	public static void getLevelOneBoxes(ObservableList<Node> buttons, ObservableList<Node> fields) {
		// TODO Auto-generated method stub
		field1=(TextField) fields.get(0);
		field2=(TextField) fields.get(1);
		field3=(TextField) fields.get(2);
		
		
		btn1=(Button) buttons.get(0);
		btn2=(Button) buttons.get(1);
		btn3=(Button) buttons.get(2);
		
		
		btn1.setOnDragDetected(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				btn1.startFullDrag();
				SOUNDS.PlayDragSound();
				
			}
			
		});
		
		field1.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {

			@Override
			public void handle(MouseDragEvent event) {
				// TODO Auto-generated method stub
				Button value=(Button) event.getGestureSource();
				field1.setText(value.getText());
				SOUNDS.PlayDropSound();
			}
			
		});
		
		
		btn2.setOnDragDetected(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				btn2.startFullDrag();
				SOUNDS.PlayDragSound();
			}
			
		});
		
		field2.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {

			@Override
			public void handle(MouseDragEvent event) {
				// TODO Auto-generated method stub
				Button value=(Button) event.getGestureSource();
				field2.setText(value.getText());
				SOUNDS.PlayDropSound();
			}
			
		});
		
		
		btn3.setOnDragDetected(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				btn3.startFullDrag();
				SOUNDS.PlayDragSound();
				
			}
			
		});
		
		field3.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {

			@Override
			public void handle(MouseDragEvent event) {
				// TODO Auto-generated method stub
				Button value=(Button) event.getGestureSource();
				field3.setText(value.getText());
				SOUNDS.PlayDropSound();
			}
			
		});
		
	}
	public static void ScrambleLettersOnBoxes(String word) {
	char[] letters=ScrambleWords.scramble1(word);
	String one=""+letters[0];
	btn1.setText(one);
	String two=""+letters[1];
	btn2.setText(two);
	String three=""+letters[2];
	btn3.setText(three);
	}
	public static String getLettersOnBoxes() {
		String word=field1.getText()+field2.getText()+field3.getText();
		return word;
	}
	public static void ClearFields() {
		field1.setText("");
		field2.setText("");
		field3.setText("");
	}
	}
	
