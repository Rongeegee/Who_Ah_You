package whoahyou;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Semaphore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sourceforge.jtds.jdbc.DateTime;
import whoahyou.DBConnectionManager;
import java.util.Date;

public class date extends HttpServlet{
	String Profile1;
	String Profile2;
	String CustRep;
	String Date_Time;
	String location;
	float bookingFee;
	String comments;
	int user1Rating;
	int user2Rating;
	String profileURL;
	public date() {
		super();
	}
	public String getP1() {
		return Profile1;
	}
	public String getP2() {
		return Profile2;
	}
	public String getLoc() {
		return location;
	}
	public String getDT() {
		return Date_Time;
	}
	public String getComments() {
		return comments;
	}
	public int getU1R() {
		return user1Rating;
	}
	public int getU2R() {
		return user2Rating;
	}
	public String getURL() {
		return this.profileURL;
	}
	
	
	
    protected boolean createDate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
    	String pro1= req.getParameter("Likee");//Likee parameter TBH WHEN JSP IS CREATED
		String pro2 = req.getParameter("Liker");//Liker parameter
		String custRep = req.getParameter("CustRep");//TB changed
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		String date = dtf.format(now);  
		DBConnectionManager DBcon = new DBConnectionManager();
		//insert into person
		String sql = "insert into likes (like1,like2,datetime)"
		+ "values (?,?,?)";
		PreparedStatement likeSt = DBcon.conn.prepareStatement(sql);  
		likeSt.setString(1, pro1);
		likeSt.setString(2, pro2);
		likeSt.setString(3, date);
		likeSt.executeUpdate(sql);	
		return true;
	}
}
