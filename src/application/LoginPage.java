package application;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginPage implements EventHandler<ActionEvent>{
  static ScrollPane scroll;
  static BorderPane pane;
  static VBox vbox;
  static HBox hbox;
  static TextField fname;
  static TextField lname;
  static PasswordField password;
  static ArrayList<USER> users;
  static ArrayList<HBox> box;
  static Button login;
  static VBox loginBox;
  ChoiceBox<String> levelChoice;
  static Button reg;
  private int Lchoice=0;
  private  boolean state;
  private String USERNAME="";
  Stage stage;
   
  public  boolean users() throws FileNotFoundException {
	  levelChoice=new ChoiceBox();
	  levelChoice.getItems().addAll("EASY","MEDIUM","HARD");
	  levelChoice.setValue("EASY");
	  users=new ArrayList<>();
	  HBox reglogBox;
	  DataBaseHelper.getAllUsers();
	  users=DataBaseHelper.AllUsers;
	  box=new ArrayList<>();
	  int i=0;
	  while(i<users.size()) {
		Label name=new Label(users.get(i).getFname().toUpperCase()+" "+users.get(i).getLname().toUpperCase());
		name.getStyleClass().add("name");
		Button btn=new Button("SELECT");
		btn.getStyleClass().add("bttn");
		HBox ubox=new HBox();
		ubox.getStyleClass().add("ubox");
		ubox.getChildren().addAll(name,btn);
		box.add(ubox);
		int j=i;
		btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				fname.setText(users.get(j).getFname());
				lname.setText(users.get(j).getLname());
			}
			
		});
		  ++i;
	  }
	  vbox=new VBox();
	  for(int j=0;j<box.size();j++) {
		  vbox.getChildren().add(box.get(j));
	  }
	  
	  reglogBox=new HBox();
	  reg=new Button("SIGNUP");
	  fname=new TextField();
	  fname.setPrefHeight(50);
	  fname.getStyleClass().add("input");
	  fname.setPromptText("FIRSTNAME");
	  lname=new TextField();
	  lname.setPrefHeight(50);
	  lname.setPromptText("LASTNAME");
	  lname.getStyleClass().add("input");
	  login=new Button("SIGNIN");
	  reglogBox.getChildren().addAll(login,reg);
	  login.setOnAction(this);
	  reg.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			 Lchoice=getChoice(levelChoice);
			try {
				if(DataBaseHelper.RegisterUser(fname.getText().toString(), lname.getText().toString(), password.getText().toString(),
						Lchoice)) {
					stage.close();
					Main main=new Main();
					main.MainGame(Lchoice,fname.getText().toString()+" "+lname.getText().toString());
				}else {
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		  
	  });
	  
	  login.getStyleClass().add("bttn");
	  reg.getStyleClass().add("bttn");
	  loginBox=new VBox();
	  password=new PasswordField();
	  password.setPromptText("PASSWORD");
	  password.setPrefHeight(50);
	  password.getStyleClass().add("input");
	  levelChoice.setPrefWidth(300);
	  levelChoice.setPrefHeight(30);
	  levelChoice.getStyleClass().add("levelchoice");
	  loginBox.getChildren().addAll(fname,lname,password,levelChoice,reglogBox);
	  loginBox.getStyleClass().add("loginbox");
	  
	  scroll=new ScrollPane();
	  scroll.setContent(vbox);
	  pane=new BorderPane();
	  pane.setCenter(loginBox);
	  pane.setLeft(scroll);
	 
	   stage=new Stage();
	  Scene scene=new Scene(pane,600,350);
	  scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	  stage.setScene(scene);
	  stage.show();
	  return state;
  }
  private int getChoice(ChoiceBox<String> levelChoice) {
		// TODO Auto-generated method stub
		int choice = 0;
		String level=levelChoice.getValue();
		switch(level) {
		case "EASY":
			choice=1;
			break;
		case "MEDIUM":
			choice=2;
			break;
		case "HARD":
			choice=3;
			break;
			default:
				break;
				
		}
		return choice;
	}
  public int getLevelChoice() {
	  return Lchoice;
  }
  public String getUserName() {
	  USERNAME=fname.getText().toString()+" "+lname.getText().toString();
	  return USERNAME;
  }
  public void CloseLoginPage() {
	  stage.close();
  }
@Override
public void handle(ActionEvent event) {
	// TODO Auto-generated method stub
	if(event.getSource()==login) {
				String firstname=fname.getText().toString();
				String lastname=lname.getText().toString();
				String pword=password.getText().toString();
				Lchoice=getChoice(levelChoice);
				try {
					if(DataBaseHelper.getUserDetails(firstname, lastname, pword, Lchoice)) {
						stage.close();
						Main main=new Main();
						main.MainGame(Lchoice,firstname+" "+lastname);
						
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	}
}
}
