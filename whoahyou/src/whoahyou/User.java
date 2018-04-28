package whoahyou;

import java.sql.Connection;
import java.util.HashMap;

public class User {
	String email;
	String pwd;
	String access;
	Connection conn;
	public HashMap<String, Profile> profiles = new HashMap<String, Profile>(20);
	public User(Connection conn, String email, String pwd, String access) {
		this.conn = conn;
		this.email = email;
		this.pwd = pwd;
		this.access = access;
	}
}
