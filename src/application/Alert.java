package application;

import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Alert {
 public  void ALertWrong(String message) {
	   Stage stage=new Stage();
	   VBox vbox=new VBox();
	   Button btn=new Button("OK");
	   vbox.getStyleClass().add("ubox");
	   btn.getStyleClass().add("bttn");
	   btn.setOnMouseClicked(new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent arg0) {
			// TODO Auto-generated method stub
			stage.close();
		}

		
		   
	   });
		stage.initModality(Modality.APPLICATION_MODAL);
		StackPane pane=new StackPane();
		Label label =new Label("HINT :"+message);
		label.getStyleClass().add("username");
		vbox.getChildren().addAll(label,btn);
		pane.getChildren().add(vbox);
		Scene scene =new Scene(pane,500,300);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.showAndWait();
 }
 
 public void ALertWrongWord(String message) {
 boolean state=false;
	   Stage stage=new Stage();
	   VBox vbox=new VBox();
	   HBox hbox=new HBox();
	   Button btn=new Button("REMAIN");
	   Button btnNext=new Button("NEXT");
	   vbox.getStyleClass().add("ubox");
	   btn.getStyleClass().add("bttn");
	   btnNext.getStyleClass().add("bttn");
	   btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent arg0) {
			// TODO Auto-generated method stub
			stage.close();
		}
	   });
	   btnNext.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			stage.close();
			int level=Main.GameLevel;
			switch(level) {
			case 1:
				LevelOneProcessAnswers.GotoNextQuestion();
				break;
			case 2:
				LevelTwoProcessAnswers.GotoNextQuestion();
				break;
			case 3:
				LevelThreeProcessAnswers.GotoNextQuestion();
				break;
				default:
					break;
			}
			
		}
		   
	   });
		stage.initModality(Modality.APPLICATION_MODAL);
		StackPane pane=new StackPane();
		Label label =new Label("HINT :"+message);
		label.getStyleClass().add("username");
		hbox.getChildren().addAll(btn,btnNext);
		hbox.getStyleClass().add("alertBox");
		vbox.getChildren().addAll(label,hbox);
		pane.getChildren().add(vbox);
		Scene scene =new Scene(pane,500,300);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.showAndWait();
		
}
 public void AlertCompletedLevel() {
	 Stage stage=new Stage();
	   VBox vbox=new VBox();
	   Button btn=new Button("NEXT");
	   vbox.getStyleClass().add("ubox");
	   btn.getStyleClass().add("bttn");
	   Main main=new Main();
	   SOUNDS.stopSong();
	   btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent arg0) {
			// TODO Auto-generated method stub
			stage.close();
			String user=new LoginPage().getUserName();
			switch(main.getGameLevel()) {
			case 1:
				main.CloseMain();
				LevelTwoProcessAnswers.QuestionNumber=0;
				try {
					main.MainGame(2, user);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				main.CloseMain();
				LevelThreeProcessAnswers.QuestionNumber=0;
				try {
					main.MainGame(3, user);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				main.CloseMain();
				LevelOneProcessAnswers.QuestionNumber=0;
				try {
					main.MainGame(1, user);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				default:
					break;
			}
		}

		
		   
	   });
		stage.initModality(Modality.APPLICATION_MODAL);
		StackPane pane=new StackPane();
		Label label =new Label(LevelName(new Main().getGameLevel())+" LEVEL IS COMPLETED");
		label.getStyleClass().add("username");
		vbox.getChildren().addAll(label,btn);
		pane.getChildren().add(vbox);
		Scene scene =new Scene(pane,300,200);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.showAndWait();
 }
 
 public String LevelName(int level) {
	 String levelName = "";
	 switch(level) {
	 case 1:
		 levelName="EASY";
		 break;
	 case 2:
		 levelName="MEDIUM";
		 break;
	 case 3:
		 levelName="HARD";
		 break;
		 default:
			 break;
	 }
	 return levelName;
 }
}
