package whoahyou;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebServlet("/likeServlet")
public class like extends HttpServlet{
	String Liker;
	String Likee;
	String Date_Time;
	public like() {
		super();
	}
	public String getLiker() {
		return this.Liker;
	}
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	String method = req.getMethod();
    	if(method.equals("POST"))
    		this.doPost(req,res);
    	if(method.equals("GET"))
    		this.doGet(req,res);
    }
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			createLike(req, res);
		} catch (SQLException e) {
			System.out.println("New like Customer Exception thrown");
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			getLikes(req, res);
		} catch (SQLException e) {
			System.out.println("like table Exception thrown");
			e.printStackTrace();
		}
	}
    protected boolean createLike(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
    	String like1 = req.getParameter("Likee");//Likee parameter TBH WHEN JSP IS CREATED
		String like2 = req.getParameter("Liker");//Liker parameter
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		String datetime = dtf.format(now);  
		DBConnectionManager DBcon = new DBConnectionManager();
		//insert into person
		String sql = "insert into likes (like1,like2,datetime)"
		+ "values (?,?,?)";
		PreparedStatement likeSt = DBcon.conn.prepareStatement(sql);  
		likeSt.setString(1, like1);
		likeSt.setString(2, like2);
		likeSt.setString(3, datetime);
		likeSt.executeUpdate(sql);	
		return true;
	}
    protected boolean getLikes(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
    	String like1 = req.getParameter("profileID");//Likee parameter TBH WHEN JSP IS CREATED
		DBConnectionManager DBcon = new DBConnectionManager();
		String sql = "SELECT * FROM likes WHERE Likee = ?";
		
		PreparedStatement likeSt = DBcon.conn.prepareStatement(sql);  
		likeSt.setString(1, like1);
		System.out.println(likeSt);
		ResultSet result = likeSt.executeQuery();
		System.out.println(result.getFetchSize());
		List<like> likers = new ArrayList<like>(); // key = email

		while(result.next()) {
			like liker = new like();
			liker.Liker = result.getString("Liker");
			liker.Likee = result.getString("Likee");
			liker.Date_Time = result.getString("Date_Time");
			System.out.println(result.getString("Liker"));
			likers.add(liker);
		}
		
		req.setAttribute("likerList",likers);
		req.getRequestDispatcher("main_activity.jsp").forward(req, res);
		return true;
    }
}
