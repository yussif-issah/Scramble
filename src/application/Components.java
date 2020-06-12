package application;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Components{
	static StackPane pane;
	static Label level ;
	static DropShadow drop;
	static StackPane DashPane;
	static HBox DashBox;
	static StackPane Points;
	static StackPane scramble;
	static BorderPane userDetails;
	static VBox scoreBox;
	static VBox userBox;
	static Label score;
	public static Label scorepoints;
	static Label username;
	static Button Dash;
	static Button settings;
	public static ImageView view=new ImageView();
	public static StackPane topLevel(int number) {
		switch(number) {
		case 1:
			 level =new Label("BEGINNER LEVEL");
			 break;
		case 2:
			 level =new Label("INTERMEDIATE LEVEL");
			 break;
		case 3:
			 level =new Label("MASTER LEVEL");
			 break;
			 default:
				 break;
			
		}
		 pane =new StackPane();
		pane.getStyleClass().add("header");
		level.getStyleClass().add("level");
		drop = new DropShadow();  
	    drop.setBlurType(BlurType.THREE_PASS_BOX);  
	    drop.setColor(Color.BLUE);  
	    drop.setHeight(100);  
	    drop.setWidth(150);  
	    drop.setOffsetX(10);  
	    drop.setOffsetY(10);  
	    drop.setSpread(0.2);  
	    drop.setRadius(10);  
	    pane.setEffect(drop);
		pane.getChildren().add(level);
		return pane;
		
	}
	public static HBox BoxAnswers(int levelNumber) {
		HBox box=new HBox();
		switch (levelNumber) {
		case 1:
			box=levelOneBoxAnswer();
			break;
		case 2:
			box=levelTwoBoxAnswer();
			break;
		case 3:
			box=levelThreeBoxAnswer();
			break;
			default:
				break;
		}
		return box;
		
	}
	private static HBox levelThreeBoxAnswer() {
		TextField field1=new TextField();
		TextField field2=new TextField();
		TextField field3=new TextField();
		TextField field4=new TextField();
		TextField field5=new TextField();
		field1.getStyleClass().add("levelThreeAns");
		field2.getStyleClass().add("levelThreeAns");
		field3.getStyleClass().add("levelThreeAns");
		field4.getStyleClass().add("levelThreeAns");
		field5.getStyleClass().add("levelThreeAns");
		HBox box=new HBox();
		box.getStyleClass().add("answerBox");
		box.setEffect(drop);
		box.getChildren().addAll(field1,field2,field3,field4,field5);
		return box;
	}
	private static HBox levelTwoBoxAnswer() {
		TextField field1=new TextField();
		TextField field2=new TextField();
		TextField field3=new TextField();
		TextField field4=new TextField();
		field1.getStyleClass().add("levelTwoAns");
		field2.getStyleClass().add("levelTwoAns");
		field3.getStyleClass().add("levelTwoAns");
		field4.getStyleClass().add("levelTwoAns");
		HBox box=new HBox();
		box.getStyleClass().add("answerBox");
		box.setEffect(drop);
		box.getChildren().addAll(field1,field2,field3,field4);
		return box;
	}
	private static HBox levelOneBoxAnswer() {
		TextField field1=new TextField();
		TextField field2=new TextField();
		TextField field3=new TextField();
		field1.getStyleClass().add("levelOneAns");
		field2.getStyleClass().add("levelOneAns");
		field3.getStyleClass().add("levelOneAns");
		HBox box=new HBox();
		box.getStyleClass().add("answerBox");
		box.setEffect(drop);
		box.getChildren().addAll(field1,field2,field3);
		return box;
	}
	public static HBox boxes(int levelNumber) {
		HBox box=new HBox();
		switch (levelNumber) {
		case 1:
			box=levelOneBoxes();
			break;
		case 2:
			box=levelTwoBoxes();
			break;
		case 3:
			box=levelThreeBoxes();
			break;
			default:
				break;
		}
		return box;
		
	}
	private static HBox levelThreeBoxes() {
		Button button1=new Button("A");
		Button button2=new Button("B");
		Button button3=new Button("C");
		Button button4=new Button("D");
		Button button5=new Button("E");
		button1.getStyleClass().add("levelThreeBoxes");
		button2.getStyleClass().add("levelThreeBoxes");
		button3.getStyleClass().add("levelThreeBoxes");
		button4.getStyleClass().add("levelThreeBoxes");
		button5.getStyleClass().add("levelThreeBoxes");
		HBox levelThreeBoxes = new HBox();
		levelThreeBoxes.getStyleClass().add("boxThree");
		levelThreeBoxes.setEffect(drop);
		levelThreeBoxes.getChildren().addAll(button1,button2,button3,button4,button5);
		return levelThreeBoxes;
	}
	private static HBox levelTwoBoxes() {
		Button button1=new Button("A");
		Button button2=new Button("B");
		Button button3=new Button("C");
		Button button4=new Button("D");
		button1.getStyleClass().add("levelTwoBoxes");
		button2.getStyleClass().add("levelTwoBoxes");
		button3.getStyleClass().add("levelTwoBoxes");
		button4.getStyleClass().add("levelTwoBoxes");
		HBox levelTwoBoxes = new HBox();
		levelTwoBoxes.getStyleClass().add("boxTwo");
		levelTwoBoxes.setEffect(drop);
		levelTwoBoxes.getChildren().addAll(button1,button2,button3,button4);
		return levelTwoBoxes;
	}
	private static HBox levelOneBoxes() {
		Button button1=new Button("A");
		Button button2=new Button("B");
		Button button3=new Button("C");
		button1.getStyleClass().add("levelOneBoxes");
		button2.getStyleClass().add("levelOneBoxes");
		button3.getStyleClass().add("levelOneBoxes");
		HBox levelOneBoxes = new HBox();
		levelOneBoxes.getStyleClass().add("boxOne");
		levelOneBoxes.setEffect(drop);
		levelOneBoxes.getChildren().addAll(button1,button2,button3);
		return levelOneBoxes;
	}
	
public static StackPane DashBoard(String user) {
	 DashPane =new StackPane();
	 scoreBox=new VBox();
	 scoreBox.getStyleClass().add("scorebox");
	 score=new Label("YOUR POINTS");
	 scorepoints=new Label("00");
	 score.getStyleClass().add("score");
	 scorepoints.getStyleClass().add("scorepoints");
	 settings=new Button("HINT");
	 settings.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int level=Main.GameLevel;
			switch(level) {
			case 1:
				ToggleHintOne();
				break;
			case 2:
				ToggleHintTwo();
				break;
			case 3:
				ToggleHintThree();
				break;
				default:
					break;
			}
		}

		private void ToggleHintOne() {
			// TODO Auto-generated method stub
			if(Main.hint.getText()=="") {
				Main.hint.setText(LevelOneProcessAnswers.getHint().toUpperCase());
			}else {
				Main.hint.setText("");
			}
			
		}
		private void ToggleHintTwo() {
			// TODO Auto-generated method stub
			if(Main.hint.getText()=="") {
				Main.hint.setText(LevelTwoProcessAnswers.getHint().toUpperCase());
			}else {
				Main.hint.setText("");
			}
			
		}
		private void ToggleHintThree() {
			// TODO Auto-generated method stub
			if(Main.hint.getText()=="") {
				Main.hint.setText(LevelThreeProcessAnswers.getHint().toUpperCase());
			}else {
				Main.hint.setText("");
			}
			
		}
		 
	 });
	 settings.getStyleClass().add("userdash");
	scoreBox.getChildren().addAll(score,scorepoints,settings);
	 DashBox=new HBox();
	 Points=new StackPane();
	 Points.getChildren().add(scoreBox);
	 scramble=new StackPane();
	 userDetails=new BorderPane();
	 Dash=new Button("UPDATE PICTURE");
	 Dash.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			FileChooser filechooser=new FileChooser();
			
			filechooser.setTitle("choose file");
			Stage stage=(Stage) DashPane.getScene().getWindow();
			File file=filechooser.showOpenDialog(stage);
			if(file!=null) {
				Image image=new Image(file.toURI().toString());
				view.setImage(image);
				view.setFitHeight(100);
				view.setFitWidth(100);
				view.getStyleClass().add("img");
				try {
					DataBaseHelper.UpdateImageUrl(file.toURI().toString());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				userDetails.setCenter(view);
		}
		}
	 });
		
	 username=new Label(user.toUpperCase());
	 userDetails.setTop(username);
	 userDetails.setBottom(Dash);
	 DashPane.getChildren().add(DashBox);
	 DashBox.getChildren().addAll(Points,scramble,userDetails);
	DashPane.getStyleClass().add("dpane");
	DashBox.getStyleClass().add("dbox");
	Points.getStyleClass().add("points");
	userDetails.getStyleClass().add("user");
	scramble.getStyleClass().add("scramblepic");
	username.getStyleClass().add("username");
	Dash.getStyleClass().add("userdash");
	
	return DashPane;
	
}

public static void UpdateImage(String path) {
	Image image=new Image(new File(path).toURI().toString());
	view.setImage(image);
}

}
