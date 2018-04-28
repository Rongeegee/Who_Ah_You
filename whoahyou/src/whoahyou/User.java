package whoahyou;

import java.sql.Connection;

public class User {
	String email;
	String pwd;
	String access;
	Connection conn;
	
	public User(Connection conn, String email, String pwd, String access) {
		this.conn = conn;
		this.email = email;
		this.pwd = pwd;
		this.access = access;
	}
}
