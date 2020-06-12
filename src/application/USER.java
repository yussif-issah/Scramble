package application;

public class USER {
	private String fname;
	 private int current_level;
	 private int user_id;
	 private String password;
	 private String lname;
	 
	public USER(String fname, int current_level, int user_id, String password, String lname) {
		super();
		this.fname = fname;
		this.current_level = current_level;
		this.user_id = user_id;
		this.password = password;
		this.lname = lname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getCurrent_level() {
		return current_level;
	}
	public void setCurrent_level(int current_level) {
		this.current_level = current_level;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}
