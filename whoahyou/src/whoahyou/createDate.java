package whoahyou;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/createDate")
public class createDate extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	String method = req.getMethod();
    	if(method.equals("POST"))
    		this.doPost(req,res);
    	if(method.equals("GET"))
    		this.doGet(req,res);
    }
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			createD(req, res);
		} catch (SQLException e) {
			System.out.println("New like Customer Exception thrown");
			e.printStackTrace();
		}
	}
	
	protected boolean createD(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException{
		DBConnectionManager DBcon = new DBConnectionManager();
		Profile currentProfile = new Profile();
		String currProfile = req.getParameter("profileID");
		String likeee = req.getParameter("LikeeID");//Likee parameter TBH WHEN JSP IS CREATED
		String likerr = req.getParameter("profileID");//Liker parameter
		String time = req.getParameter("Time");
		
		String insertSQL = "INSERT INTO date (Profile1,Profile2,Date_Time) VALUES (?,?,?)";
		PreparedStatement insertSt = DBcon.conn.prepareStatement(insertSQL);  
		insertSt.setString(1, likeee);
		insertSt.setString(2, likerr);
		insertSt.setString(3, "2014-10-06 04:30:52");
		insertSt.executeUpdate();
		
		List<like> likee = new ArrayList<like>();
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
		
		String likerSQL = "SELECT * FROM likes WHERE Liker = ?";
		PreparedStatement likerSt = DBcon.conn.prepareStatement(likerSQL);  
		likerSt.setString(1, currProfile);
		ResultSet likerresult = likerSt.executeQuery();
		while(likerresult.next()) {
			like liker = new like();
			liker.Liker = likerresult.getString("Liker");
			liker.Likee = likerresult.getString("Likee");
			liker.Date_Time = likerresult.getString("Date_Time");
			liker.LikerURL = "images/profileImg/" + liker.Likee + ".jpg";
			likee.add(liker);
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
			currentProfile.Height = profileResult.getString("Height");
			currentProfile.Weight = Integer.parseInt(profileResult.getString("Weight"));
			currentProfile.HairColor = profileResult.getString("HairColor");
			currentProfile.LastModDate = profileResult.getDate("LastModDate");
		}
		
		//Get potential matches for the current profile
		String matchesSQL = "SELECT DISTINCT * FROM profile WHERE Age <= ? AND Age >= ?";
		PreparedStatement matchesST = DBcon.conn.prepareStatement(matchesSQL);  
		matchesST.setString(1, Integer.toString(currentProfile.DatingRangeEnd));
		matchesST.setString(2, Integer.toString(currentProfile.DatingRangeStart));
		ResultSet matchesResult = matchesST.executeQuery();
		
		while(matchesResult.next()){
			Profile match = new Profile();
			match.ProfileID = matchesResult.getString("ProfileID");
			match.OwnerSSN = matchesResult.getString("OwnerSSN");
			match.DatingRangeStart = Integer.parseInt(matchesResult.getString("DatingAgeRangeStart"));
			match.DatingRangeEnd = Integer.parseInt(matchesResult.getString("DatingAgeRangeEnd"));
			match.DatinGeoRange = Integer.parseInt(matchesResult.getString("DatinGeoRange"));
			match.Age = Integer.parseInt(matchesResult.getString("Age"));
			match.Gender = matchesResult.getString("M_F");
			match.Hobbies = matchesResult.getString("Hobbies");
			match.Height = matchesResult.getString("Height");
			match.Weight = Integer.parseInt(matchesResult.getString("Weight"));
			match.HairColor = matchesResult.getString("HairColor");
			match.LastModDate = matchesResult.getDate("LastModDate");
			match.picPath = "images/profileImg/" + match.ProfileID + ".jpg";
			if(match.ProfileID.equals(currentProfile.ProfileID) == false) {
				System.out.println(match.ProfileID);
				System.out.println(currentProfile.getProfileID());
				matches.add(match);
			}
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
		
		req.setAttribute("current", currProfile);
		req.setAttribute("likeeList",likee);
		req.setAttribute("likerList",likers);
		req.setAttribute("matchesList",matches);
		req.setAttribute("dateList",dates);
		req.getRequestDispatcher("main_activity.jsp").forward(req, res);
		DBcon.conn.close();
		return true;
	}
}

