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
	Profile Profile1;
	Profile Profile2;
	String CustRep;
	Date Date_Time;
	String location;
	float bookingFee;
	String comments;
	int user1Rating;
	int user2Rating;
	public date() {
		super();
	}
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	String method = req.getMethod();
    	if(method.equals("POST"))
    		this.doPost(req,res);
    	if(method.equals("GET"))
    		this.doGet(req, res);
    }
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			createDate(req, res);
		} catch (SQLException e) {
			System.out.println("New Date Exception thrown");
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			getDates(req, res);
		} catch (SQLException e) {
			System.out.println("New Date Exception thrown");
			e.printStackTrace();
		}
	}
	
	protected boolean getDates(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		String mainProfile = req.getParameter("ProfileID");//Likee parameter TBH WHEN JSP IS CREATED
		DBConnectionManager DBcon = new DBConnectionManager();
		String sql = "select Liker from likes WHERE Likee = ?";
		PreparedStatement likeSt = DBcon.conn.prepareStatement(sql);  
		likeSt.setString(1, like1);
		ResultSet result = likeSt.executeQuery();
		like likeList = new like();
		while(result.next()) {
			String profileID = result.getString("ProfileID");
			// pulling up corresponding profiles based on the user.
			sql = "select * from profile where ProfileID = ?;";
			PreparedStatement st1 = DBcon.conn.prepareStatement(sql);
			st1.setString(1, profileID);
			ResultSet pR = st1.executeQuery();
			// creating profiles for the user
			while(pR.next()) {
				Profile newProfile = new Profile();
				newProfile.ProfileID = pR.getString("ProfileID");
				newProfile.OwnerSSN = pR.getString("OwnerSSN");
				newProfile.DatingRangeStart = Integer.parseInt(pR.getString("DatingAgeRangeStart"));
				newProfile.DatingRangeEnd = Integer.parseInt(pR.getString("DatingAgeRangeEnd"));
				newProfile.DatinGeoRange = Integer.parseInt(pR.getString("DatinGeoRange"));
				newProfile.Age = Integer.parseInt(pR.getString("Age"));
				newProfile.Gender = pR.getString("M_F");
				newProfile.Hobbies = pR.getString("Hobbies");
				newProfile.Height = Integer.parseInt(pR.getString("Height"));
				newProfile.Weight = Integer.parseInt(pR.getString("Weight"));
				newProfile.HairColor = pR.getString("HairColor");
				newProfile.CreationDate = pR.getDate("CreationDate");
				newProfile.LastModDate = pR.getDate("LastModDate");
				newProfile.picPath = "images/profileImg/" + newProfile.ProfileID + ".jpg";
				System.out.println(newProfile.picPath);
				likeList.likers.add(newProfile);
			}
		}
		req.setAttribute("likerList",likeList.likers);
		req.getRequestDispatcher("main_activity.jsp").forward(req, res);
		return true;
		
	}
    protected boolean createDate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
    	String pro1= req.getParameter("Likee");//Likee parameter TBH WHEN JSP IS CREATED
		String pro2 = req.getParameter("Liker");//Liker parameter
		String custRep = req.getParameter("CustRep")//TB changed
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		String date = dtf.format(now));  
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
}