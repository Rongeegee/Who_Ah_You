package whoahyou;

import java.sql.Connection;
import java.util.ArrayList;

public class User {
	String email;
	String pwd;
	String access;
	Connection conn;
	ArrayList<Profile> profileArr = new ArrayList<Profile>(20);
	
	public User(Connection conn, String email, String pwd, String access) {
		this.conn = conn;
		this.email = email;
		this.pwd = pwd;
		this.access = access;
		
	}
}
