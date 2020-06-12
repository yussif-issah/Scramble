package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DataBaseSetUp {
private static Connection connection;
private static String user;
private static String  password;
private static String SCRAMBLE="SCRAMBLE";
boolean control=false;
public DataBaseSetUp(String username,String pword) throws FileNotFoundException {
	
	user=username;
	password=pword;
	FileWriter myWriter;
	try {
		myWriter = new FileWriter("password.txt");
		myWriter.write(password);
	    myWriter.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	FileWriter Writer;
	try {
		Writer = new FileWriter("user.txt");
		Writer.write(user);
	    Writer.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	 connection=DriverManager.getConnection("jdbc:mysql://localhost/?useTimezone=true&serverTimezone=UTC",user,password);
	}catch(Exception e) {
		e.printStackTrace();
	}
	    CreateDataBase();
	    CreateUserTable();
		CreateWordTable();
		InsertWords();
		control=true;
	
}

public boolean getControl() {
	return control;
}

private  boolean InsertWords() throws FileNotFoundException {
	// TODO Auto-generated method stub
	connection=getConnection();
	boolean state=false;
	Statement statement;
	try {
		statement = connection.createStatement();
		String sql="INSERT INTO word (word,hint ,level)"
				+ "VALUES('PHONE','ELECTRONIC DEVICE FOR MAKING CALLS',3),('GOALS','WHAT PEOPLE SEEK TO ACHIEVE',3),"
				+ "('APPLE','NAME OF A FRUIT AND A GIANT ELECTRONIC COMPANY',3),"
				+ "('MESSI','NAME OF A POPULAR FOOTBALLER',3),"
				+ "('QURAN','MUSLIMS HOLY BOOK',3),"
				+ "('FIRE','A FLAME THAT CAN CAUSE BURNS AND DESTRUCTION',2),"
				+ "('CURE','TREATMENT OF AN AILMENT',2),"
				+ "('DOOR','OPENING OF A ROOM',2),"
				+ "('DATE','TIME AND DAY',2),"
				+ "('CANE','STICK USED TO BEAT STUDENTS',2),"
				+ "('CAR','VEHICLE FOR TRAVELING',1),"
				+ "('FAT','USED TO DESCRIBE PLUMBY PEOPLE',1),"
				+ "('SAT','PAST TENSE OF SIT',1),"
				+ "('BAD','SOMETHING THATS NOT GOOD',1),"
				+ "('CAT','A PET THAT MEOOW',1)";
		if(statement.execute(sql)) {
			state=true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		Alert alert= new Alert();
		alert.ALertWrong("UNABLE TO INSERT WORDS");
		e.printStackTrace();
		state=false;
	}
	return state;
}

private void CreateWordTable() throws FileNotFoundException {
	// TODO Auto-generated method stub
	connection=getConnection();
	Statement statement;
	try {
		statement = connection.createStatement();
		String sql="CREATE TABLE WORD("
				+ "word varchar(20),"
				+ "hint varchar(200),"
				+ "level int,"
				+ "word_id int PRIMARY KEY AUTO_INCREMENT)";
		statement.execute(sql);
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		Alert alert= new Alert();
		alert.ALertWrong("UNABLE TO CREATE WORD TABLE");
		e.printStackTrace();
	}
}

private boolean CreateUserTable() throws FileNotFoundException {
	// TODO Auto-generated method stub
	boolean state=false;
	connection=getConnection();
	Statement statement;
	try {
		statement = connection.createStatement();
		String sql="CREATE TABLE USERS("
				+ "fname varchar(20),"
				+ "lname varchar(20),"
				+ "password varchar(20),"
				+ "current_level int,"
				+ "user_id int PRIMARY KEY AUTO_INCREMENT,"
				+ "image_url varchar(200))";
		if(statement.execute(sql)) {
			state=true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		Alert alert= new Alert();
		alert.ALertWrong("UNABLE TO CREATE USER TABLE");
		e.printStackTrace();
	}
	return state;
}

private boolean CreateDataBase() {
	// TODO Auto-generated method stub
	boolean state=true;
	Statement statement;
	try {
		statement = connection.createStatement();
		String sql="CREATE DATABASE SCRAMBLE";
		if(statement.execute(sql)) {
			state=true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		Alert alert= new Alert();
		alert.ALertWrong("UNABLE TO CREATE DATABASE");
		e.printStackTrace();
	}
	return state;
}
public static Connection getConnection() throws FileNotFoundException {
	File myObj = new File("password.txt");
    Scanner myReader = new Scanner(myObj);
    String data="";
     while (myReader.hasNextLine()) {
        data=myReader.nextLine();
        System.out.print(data);
     }
     File Obj = new File("user.txt");
     Scanner Reader = new Scanner(Obj);
     String user="";
      while (Reader.hasNextLine()) {
         user = Reader.nextLine();
      }
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	 connection=DriverManager.getConnection("jdbc:mysql://localhost/"+SCRAMBLE+"?useTimezone=true&serverTimezone=UTC",user,data);
	}catch(Exception e) {
		Alert alert= new Alert();
		alert.ALertWrong("DATABASE CONNECTION ERROR");
		e.printStackTrace();
	}
	return connection;
	
}

}


