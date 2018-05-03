package whoahyou;

import java.sql.Connection;

import java.util.*;
import javax.servlet.annotation.WebServlet;


@WebServlet("/User")
public class User {
	String email;
	String pwd;
	String access;
	String ssn;
	String ppp;
	int rating;
	String FirstName;
	String LastName;
	Date DateOfLastAct;
	Connection conn;
	public List<Profile> profiles = new ArrayList<Profile>(20); // key = email
	public User() {	}
	public User(Connection conn, String email, String pwd, String access, String ssn, String firstName, String LastName) {
		this.conn = conn;
		this.email = email;
		this.pwd = pwd;
		this.access = access;
		this.ssn = ssn;
		this.FirstName = firstName;
		this.LastName = LastName;
	}
	
}







