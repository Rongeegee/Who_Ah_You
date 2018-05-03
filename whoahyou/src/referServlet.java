

import java.io.IOException;
import java.sql.Date;
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

import whoahyou.DBConnectionManager;
import whoahyou.Profile;
import whoahyou.date;
import whoahyou.like;

/**
 * Servlet implementation class referServlet
 */
@WebServlet("/referServlet")
public class referServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public referServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			createD(req, res);
		} catch (SQLException e) {
			System.out.println("Refer Error thrown");
			e.printStackTrace();
		}
	}
	
	protected boolean createD(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException{
		DBConnectionManager DBcon = new DBConnectionManager();
		Profile currentProfile = new Profile();
		String Profile1 = req.getParameter("ProfileA"); // this profile
		String Profile2 = req.getParameter("ProfileB");// profiles selected
		String Profile3 =req.getParameter("ProfileC");
		System.out.println("test");
		String insertSQL = "INSERT INTO Referral (ProfileA,ProfileB,ProfileC, Date_Time) VALUES (?,?,?,?);";
		PreparedStatement insertSt = DBcon.conn.prepareStatement(insertSQL);  
		insertSt.setString(1, Profile1);
		insertSt.setString(2, Profile2);
		insertSt.setString(3, Profile3);
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);
		insertSt.setDate(4, date);
		insertSt.executeUpdate();
		
		//Get current logged in profile
		String profileSQL = "SELECT * FROM profile WHERE ProfileID = ?";
		PreparedStatement currProfileSt = DBcon.conn.prepareStatement(profileSQL);  
		currProfileSt.setString(1, Profile1);
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
		
		List<Profile> matches = new ArrayList<Profile>();
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
		req.setAttribute("matches", matches);
		req.getRequestDispatcher("main_activity.jsp").forward(req, res);
		DBcon.conn.close();
		return true;
	}
}
