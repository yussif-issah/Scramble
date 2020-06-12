package application;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBaseHelper  {
	static Connection connection;
	static ArrayList<USER>AllUsers;
	static ArrayList<WORD>LevelOneQuestions;
	static ArrayList<WORD>LevelTwoQuestions;
	static ArrayList<WORD>LevelThreeQuestions;
	public static int user_id = 0;
	private static String userFirstname;
	private static String userLastname;
	private static String userPassword;
	private static String userImageUrl;
	public static boolean getUserDetails(String firstname,String lastname,String pword,int level) throws FileNotFoundException {
		connection();
		String user;
		boolean state=false;
		try {
			 String query = "SELECT * FROM users WHERE fname = '"+firstname+"' AND lname = '"+lastname+"' AND password = '"+pword+"'";
			Statement st = connection.createStatement();
			ResultSet results=st.executeQuery(query);
			if(results.next()) {
				user_id=results.getInt("user_id");
				userFirstname=results.getString("fname");
				userLastname=results.getString("lname");
				userPassword=results.getString("password");
				userImageUrl=results.getString("image_url");
				
			}
			if(user_id>0) {
				state=true;
			}else {
				Alert alert=new Alert();
				alert.ALertWrong("FIELDS OR PASSWORD MAY BE WRONG");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Alert alert= new Alert();
			alert.ALertWrong("DATABASE CONNECTION ERROR");
			e.printStackTrace();
		}
		return state;
	}
	public static void getAllUsers() throws FileNotFoundException {
		connection();
		AllUsers=new ArrayList<>();
		 try {
			 String query = "SELECT * FROM USERS";
			Statement st = connection.createStatement();
			ResultSet results=st.executeQuery(query);
			while(results.next()) {
				AllUsers.add(new USER(results.getString("fname"),results.getInt("current_level"),results.getInt("user_id"),
						results.getString("password"),results.getString("lname")));
			}
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Alert alert= new Alert();
			alert.ALertWrong("DATABASE CONNECTION ERROR");
			e.printStackTrace();
		}
	}
	
	public static void getAllLevelOneQuestion() throws FileNotFoundException {
		connection();
		LevelOneQuestions=new ArrayList<>();
		 try {
			 String query = "SELECT * FROM WORD WHERE level=1";
			Statement st = connection.createStatement();
			ResultSet results=st.executeQuery(query);
			while(results.next()) {
				LevelOneQuestions.add(new WORD(results.getString("word"),results.getString("hint"),results.getInt("level"),
						results.getInt("word_id")));
			}
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Alert alert= new Alert();
			alert.ALertWrong("DATABASE CONNECTION ERROR");
			e.printStackTrace();
		}
		
	}
	public static void getAllLevelTwoQuestion() throws FileNotFoundException {
		connection();
		LevelTwoQuestions=new ArrayList<>();
		 try {
			 String query = "SELECT * FROM WORD WHERE level=2";
			Statement st = connection.createStatement();
			ResultSet results=st.executeQuery(query);
			while(results.next()) {
				LevelTwoQuestions.add(new WORD(results.getString("word"),results.getString("hint"),results.getInt("level"),
						results.getInt("word_id")));
			}
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Alert alert= new Alert();
			alert.ALertWrong("DATABASE CONNECTION ERROR");
			e.printStackTrace();
		}
		
	}
	public static void getAllLevelThreeQuestion() throws FileNotFoundException {
		connection();
		LevelThreeQuestions=new ArrayList<>();
		 try {
			 String query = "SELECT * FROM WORD WHERE level=3";
			Statement st = connection.createStatement();
			ResultSet results=st.executeQuery(query);
			while(results.next()) {
				LevelThreeQuestions.add(new WORD(results.getString("word"),results.getString("hint"),results.getInt("level"),
						results.getInt("word_id")));
			}
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public static boolean RegisterUser(String fname,String lname,String password,int level) throws FileNotFoundException {
		connection();
		boolean registered=false;
		if(fname.isEmpty()||lname.isEmpty()||password.isEmpty()) {
			Alert alert=new Alert();
			alert.ALertWrong("NO FIELD SHOULD BE EMPTY!");
		}else {
			Statement st;
			try {
				st = connection.createStatement();
				String sql="INSERT INTO users (fname,lname,password, current_level) VALUES('"+fname+"','"+lname+"','"+password+"','"+level+"')";
				st.execute(sql);
				registered=true;
				user_id=getUserId(fname,lname,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Alert alert= new Alert();
				alert.ALertWrong("DATABASE CONNECTION ERROR");
				e.printStackTrace();
			}
		}
		
		return registered;
	}
	private static int getUserId(String firstname,String lastname,String pword) throws FileNotFoundException {
		connection();
		int id=0;
		try {
			 String query = "SELECT * FROM users WHERE fname = '"+firstname+"' AND lname = '"+lastname+"' AND password = '"+pword+"'";
			Statement st = connection.createStatement();
			ResultSet results=st.executeQuery(query);
			if(results.next()) {
				id=results.getInt("user_id");
			}
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		return id;
	}
	public static void UpdateImageUrl(String imageUrl) throws FileNotFoundException {
		connection();
		Statement st;
		try {
			st = connection.createStatement();
			String sql="UPDATE users set image_url='"+imageUrl+"' WHERE user_id ="+user_id;
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Alert alert= new Alert();
			alert.ALertWrong("UNABLE TO UPDATE PROFILE IN DATABASE");
			e.printStackTrace();
		}
	}
	public static String getImageUrl() {
		return userImageUrl;
	}
	private static void connection() throws FileNotFoundException {
		connection=DataBaseSetUp.getConnection();
	}
	
}
