package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	static HBox qbox;
	static HBox abox;
	static String  word;
	Button btn=new Button();
	Button submit=new Button("SUBMIT");
	ObservableList<Node> buttons;
	ObservableList<Node> fields;
	public static Label hint;
	StackPane dashPane;
	Scene scene;
	BorderPane root;
	StackPane pane;
	public static int GameLevel;
	public static Stage stage;
	public static Stage Configstage;
	public static boolean state;
	@Override
	public void start(Stage primaryStage) {
		try {
			root=new BorderPane();
			File myObj = new File("databasestate.txt");
		     Scanner myReader = new Scanner(myObj);
		     String data="";
		      while (myReader.hasNextLine()) {
		         data = myReader.nextLine();
		      }
		      if(data.contains("not set")) {
		    	  GameConfiguration gameConfig=new GameConfiguration();
		    	  pane=gameConfig.config();
		    	  root.setCenter(pane);
		    	  Configstage=new Stage();
		    	  scene = new Scene(root,460,600);
				  scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				  Configstage.setScene(scene);
				  Configstage.show();
		      }else {
		    	  LoginPage page=new LoginPage();
		    	  state=page.users();
		      }
		      myReader.close();
		    
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void LevelChooser(int i) throws FileNotFoundException {
		
		switch(i) {
		case 1:
			qbox=Components.boxes(1);
			buttons=(ObservableList<Node>) qbox.getChildren();
			abox=Components.BoxAnswers(1);
			fields=(ObservableList<Node>) abox.getChildren();
			LevelOneController.getLevelOneBoxes(buttons, fields);
			LevelOneProcessAnswers.FirstQuestion();
			SOUNDS.playSong();
			break;
		case 2:
			qbox=Components.boxes(2);
			buttons=(ObservableList<Node>) qbox.getChildren();
			abox=Components.BoxAnswers(2);
			fields=(ObservableList<Node>) abox.getChildren();
			LevelTwoController.getLevelTwoBoxes(buttons,fields);
			LevelTwoProcessAnswers.FirstQuestion();
			SOUNDS.playSong();
			break;
		case 3:
			qbox=Components.boxes(3);
			buttons=(ObservableList<Node>) qbox.getChildren();
			abox=Components.BoxAnswers(3);
			fields=(ObservableList<Node>) abox.getChildren();
			LevelThreeController.getLevelThreeBoxes(buttons,fields);
			LevelThreeProcessAnswers.FirstQuestion();
			SOUNDS.playSong();
			break;
			default:
				break;
			
		}
		
	}

	public void MainGame(int level,String username) throws FileNotFoundException {
		stage=new Stage();
		GameLevel=level;
		root = new BorderPane();
		root.setTop(Components.topLevel(level));
		LevelChooser(level);
		VBox center=new VBox();
		VBox bottom=new VBox();
		bottom.getStyleClass().add("bottom");
		bottom.getChildren().addAll(qbox,submit);
		submit.getStyleClass().add("btn");
        dashPane=new StackPane();
		submit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				switch(level) {
				case 1:
					ProcessOne();
					break;
				case 2:
					ProcessTwo();
					break;
				case 3:
					ProcessThree();
					break;
					default:
						break;
				}
				
			}

			private void ProcessThree() {
				// TODO Auto-generated method stub
				word=LevelThreeController.getLettersOnBoxes();
				String answer=LevelThreeProcessAnswers.getCurrentWord();
				if(word.isEmpty()) {
					ClearHint();
					Alert alert=new Alert();
					alert.ALertWrongWord(LevelThreeProcessAnswers.getHint());
				}else {
					if(Compare(word,answer)) {
						SOUNDS.PlayCorrectSong();
						LevelThreeController.ClearFields();
						LevelThreeProcessAnswers.GotoNextQuestion();
						ProcessPoints.IncreasePoints();
						ClearHint();
					}else {
						LevelThreeController.ClearFields();
						Alert alert=new Alert();
						alert.ALertWrongWord(LevelThreeProcessAnswers.getHint());
						ClearHint();
					}
				}
				
				
			}

			private void ProcessTwo() {
				// TODO Auto-generated method stub
				word=LevelTwoController.getLettersOnBoxes();
				String answer=LevelTwoProcessAnswers.getCurrentWord();
				if(word.isEmpty()) {
					ClearHint();
					Alert alert=new Alert();
					alert.ALertWrongWord(LevelTwoProcessAnswers.getHint());
				}else {
					if(Compare(word,answer)) {
						SOUNDS.PlayCorrectSong();
						LevelTwoController.ClearFields();
						LevelTwoProcessAnswers.GotoNextQuestion();
						ProcessPoints.IncreasePoints();
						ClearHint();
					}else {
						LevelTwoController.ClearFields();
						ClearHint();
						Alert alert=new Alert();
						alert.ALertWrongWord(LevelTwoProcessAnswers.getHint());
					
					}
				}
				
			}

			private void ProcessOne() {
				// TODO Auto-generated method stub
				word=LevelOneController.getLettersOnBoxes().toString();
				String answer=LevelOneProcessAnswers.getCurrentWord().toString();
				if(word.isEmpty()) {
					ClearHint();
					Alert alert=new Alert();
					alert.ALertWrongWord(LevelOneProcessAnswers.getHint());
				}else {
					if(Compare(word,answer)) {
						SOUNDS.PlayCorrectSong();
						LevelOneController.ClearFields();
						LevelOneProcessAnswers.GotoNextQuestion();
						ProcessPoints.IncreasePoints();
						ClearHint();
					}else {
						ClearHint();ClearHint();
						Alert alert=new Alert();
						alert.ALertWrongWord(LevelOneProcessAnswers.getHint());
					}
				}
				
			}

			private void ClearHint() {
				// TODO Auto-generated method stub
				hint.setText("");
			}

			private boolean Compare(String word, String answer) {
				boolean state=false;
				if(word.equals(answer)) {
					state=true;
				}
				return state;
			}
			
		});
		hint =new Label();
		hint.getStyleClass().add("hint");
		dashPane=Components.DashBoard(username);
		center.getChildren().addAll(dashPane,hint,abox);
		root.setCenter(center);
		root.setBottom(bottom);
		scene = new Scene(root,460,670);
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
				// TODO Auto-generated method stub
					stage.close();
					LoginPage page=new LoginPage();
			    	try {
						state=page.users();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	SOUNDS.stopSong();
				}
				
				
				
			
		});
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		
		
	}


	public static void main(String[] args) {
		launch(args);
}
	private void closeWindow(Stage stage) {
		stage.close();
	}
	public int getGameLevel() {
		return GameLevel;
	}
	public void CloseMain() {
		stage.close();
	}
	public void CloseConfigStage() {
		Configstage.close();
	}
}
