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
	String LikerURL;
	public like() {
		super();
	}
	public String getURL() {
		return this.LikerURL;
	}
	public String getLiker() {
		return this.Liker;
	}
	public String getTime() {
		return this.Date_Time;
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
			getEverything(req, res);
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
    protected boolean getEverything(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
    	String currProfile = req.getParameter("profileID");//Likee parameter TBH WHEN JSP IS CREATED
    	Profile currentProfile = new Profile();
		DBConnectionManager DBcon = new DBConnectionManager();
		
		List<like> likers = new ArrayList<like>(); // key = email
		List<date> dates = new ArrayList<date>();
		List<Profile> matches = new ArrayList<Profile>();
		
		//Get likers of the current Profile
		String sql = "SELECT * FROM likes WHERE Likee = ?";
		PreparedStatement likeSt = DBcon.conn.prepareStatement(sql);  
		likeSt.setString(1, currProfile);
		ResultSet result = likeSt.executeQuery();
		while(result.next()) {
			like liker = new like();
			liker.Liker = result.getString("Liker");
			liker.Likee = result.getString("Likee");
			liker.Date_Time = result.getString("Date_Time");
			liker.LikerURL = "images/profileImg/" + liker.Liker + ".jpg";
			likers.add(liker);
		}
		
		//Get current logged in profile
		String profileSQL = "SELECT * FROM profile WHERE ProfileID = ?";
		PreparedStatement currProfileSt = DBcon.conn.prepareStatement(profileSQL);  
		currProfileSt.setString(1, currProfile);
		ResultSet profileResult = currProfileSt.executeQuery();
		if(profileResult.next()){
			currentProfile.ProfileID = profileResult.getString("ProfileID");
			currentProfile.OwnerSSN = profileResult.getString("OwnerSSN");
			currentProfile.DatingRangeStart = Integer.parseInt(profileResult.getString("DatingAgeRangeStart"));
			currentProfile.DatingRangeEnd = Integer.parseInt(profileResult.getString("DatingAgeRangeEnd"));
			currentProfile.DatinGeoRange = Integer.parseInt(profileResult.getString("DatinGeoRange"));
			currentProfile.Age = Integer.parseInt(profileResult.getString("Age"));
			currentProfile.Gender = profileResult.getString("M_F");
			currentProfile.Hobbies = profileResult.getString("Hobbies");
			currentProfile.Height = Integer.parseInt(profileResult.getString("Height"));
			currentProfile.Weight = Integer.parseInt(profileResult.getString("Weight"));
			currentProfile.HairColor = profileResult.getString("HairColor");
			currentProfile.LastModDate = profileResult.getDate("LastModDate");
		}
		
		//Get potential matches for the current profile
		String matchesSQL = "SELECT * FROM profile WHERE Age <= ? AND Age >= ?";
		PreparedStatement matchesST = DBcon.conn.prepareStatement(matchesSQL);  
		matchesST.setString(1, Integer.toString(currentProfile.DatingRangeEnd));
		matchesST.setString(2, Integer.toString(currentProfile.DatingRangeStart));
		ResultSet matchesResult = matchesST.executeQuery();
		while(matchesResult.next()){
			Profile match = new Profile();
			match.ProfileID = profileResult.getString("ProfileID");
			match.OwnerSSN = profileResult.getString("OwnerSSN");
			match.DatingRangeStart = Integer.parseInt(profileResult.getString("DatingAgeRangeStart"));
			match.DatingRangeEnd = Integer.parseInt(profileResult.getString("DatingAgeRangeEnd"));
			match.DatinGeoRange = Integer.parseInt(profileResult.getString("DatinGeoRange"));
			match.Age = Integer.parseInt(profileResult.getString("Age"));
			match.Gender = profileResult.getString("M_F");
			match.Hobbies = profileResult.getString("Hobbies");
			match.Height = Integer.parseInt(profileResult.getString("Height"));
			match.Weight = Integer.parseInt(profileResult.getString("Weight"));
			match.HairColor = profileResult.getString("HairColor");
			match.LastModDate = profileResult.getDate("LastModDate");
			match.picPath = "images/profileImg/" + match.ProfileID + ".jpg";
			matches.add(match);
		}
		
		//GET ALL DATES OF THE CURRENT PROFILE
		String datesSQL = "SELECT * FROM date WHERE Profile1 = ? OR Profile2 = ?";
		PreparedStatement datesST = DBcon.conn.prepareStatement(datesSQL);  
		datesST.setString(1, currentProfile.ProfileID);
		datesST.setString(2, currentProfile.ProfileID);
		ResultSet dateResult = datesST.executeQuery();
		while(dateResult.next()){
			date gotEm = new date();
			gotEm.Profile1 = dateResult.getString("Profile1");
			gotEm.Profile2 = dateResult.getString("Profile2");
			gotEm.location = dateResult.getString("Location");
			gotEm.Date_Time = dateResult.getString("Date_Time");
			gotEm.comments = dateResult.getString("Comments");
			gotEm.user1Rating = dateResult.getInt("User1Rating");
			gotEm.user2Rating = dateResult.getInt("User2Rating");
			if (gotEm.Profile1 == currProfile)
				gotEm.profileURL = "images/profileImg/" + gotEm.Profile2 + ".jpg";
			else
				gotEm.profileURL = "images/profileImg/" + gotEm.Profile1 + ".jpg";
			dates.add(gotEm);
		}
		
		DBcon.conn.close();
		req.setAttribute("likerList",likers);
		req.setAttribute("matchesList",matches);
		req.setAttribute("dateList",dates);
		req.getRequestDispatcher("main_activity.jsp").forward(req, res);
		DBcon.conn.close();
		return true;
    }
}