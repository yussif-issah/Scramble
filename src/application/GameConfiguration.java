package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class GameConfiguration implements EventHandler<ActionEvent>{
	 ImageView imageview;
	 VBox box;
	 Image image;
	 HBox namebox;
	 HBox passwordbox;
	 Label namelabel;
	 TextField username;
	 PasswordField password;
	 Label passwordlabel;
	  Button button;
	 Label label;
	public  StackPane config() {
		StackPane pane =new StackPane();
		box=new VBox();
		String file="Scrampic5.jpg";
		image=new Image(new File(file).toURI().toString());
		imageview=new ImageView(image);
		namebox=new HBox();
	    passwordbox=new HBox();
		namelabel=new Label("USERNAME");
		username=new TextField();
	    password=new PasswordField();
		passwordlabel=new Label("PASSWORD");
		button=new Button("CONNECT");
		label=new Label("ENTER YOUR XAMPP USER NAME AND PASSWORD");
		
		imageview.setFitHeight(300);
		imageview.setFitWidth(300);
		password.setMinWidth(290);
		username.setMinWidth(290);
		password.setMinHeight(35);
		username.setMinHeight(35);
		password.setPromptText("PASSWORD");
		username.setPromptText("USERNAME");
		
		
		button.getStyleClass().add("bttn");
		box.getStyleClass().add("box");
		imageview.getStyleClass().add("image");
		namebox.getStyleClass().add("namebox");
		passwordbox.getStyleClass().add("passwordbox");
		namelabel.getStyleClass().add("name");
		passwordlabel.getStyleClass().add("plabel");
		username.getStyleClass().add("usern");
		password.getStyleClass().add("pword");
		label.getStyleClass().add("label");
		button.setOnAction(this);
		namebox.getChildren().addAll(namelabel,username);
		passwordbox.getChildren().addAll(passwordlabel,password);
		box.getChildren().addAll(label,namebox,passwordbox,button);
		pane.getChildren().add(box);
		return pane;
		
	}
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		DataBaseSetUp databasesetup = null;
		try {
			databasesetup = new DataBaseSetUp(username.getText(),password.getText());
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(databasesetup.getControl()) {
			FileWriter myWriter;
			try {
				myWriter = new FileWriter("databasestate.txt");
				myWriter.write("configured");
			    myWriter.close();
			    Main main=new Main();
			    main.CloseConfigStage();
			    LoginPage page=new LoginPage();
		    	 boolean state=page.users();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			Alert alert=new Alert();
			alert.ALertWrong("PROBLEM WITH DATABASE CONNECTION");
		}
		
	      
	}
	}


