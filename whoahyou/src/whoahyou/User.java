package whoahyou;

import java.sql.Connection;
import java.util.*;

public class User {
	String email;
	String pwd;
	String access;
	Connection conn;
	public List<Profile> profiles = new ArrayList<Profile>(20); // key = email
	public User(Connection conn, String email, String pwd, String access) {
		this.conn = conn;
		this.email = email;
		this.pwd = pwd;
		this.access = access;
	}
}
