package whoahyou;

import java.sql.*;
import java.sql.Connection;


public class DBConnectionManager {
	protected Connection conn;
	protected DBConnectionManager() {
		String user = "root";
		String pwd = "whoahyou";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/who_ah_you",user,pwd);
			if (conn != null) {
                System.out.println("Connected to the database");
            }
		}
		catch(Exception e){
			System.out.println("Connection Exception: " + e);
			e.printStackTrace();
		}
	}
}
