package whoahyou;

import java.sql.*;
import java.sql.Connection;

// This class provides the connection to the database

public class DBConnectionManager {
	public Connection conn;
	public DBConnectionManager() {
		String user = "rolli";
		String pwd = "110267045";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/rolli",user,pwd);
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
