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

@WebServlet("/viewProfile")
public class viewProfile extends HttpServlet{
	public viewProfile() {
		super();
	}
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	String method = req.getMethod();
    	if(method.equals("GET"))
    		this.doPost(req,res);
	}
    	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			view(req, res);
		} catch (SQLException e) {
			System.out.println("Validate Customer Exception thrown");
			e.printStackTrace();
		}
		
	}
	
	protected boolean view(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException{
		DBConnectionManager DBcon = new DBConnectionManager();
		String currProfile = req.getParameter("imageProfile");
		Profile currentProfile = new Profile();
		List<date> dates = new ArrayList<date>();
		List<like> likee = new ArrayList<like>();
		
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
			currentProfile.picPath = "images/profileImg/" + currentProfile.ProfileID + ".jpg";
		}
		
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
			likee.add(liker);
		}
		System.out.println(currentProfile.ProfileID);
		req.setAttribute("likeeList", likee);
		req.setAttribute("dates", dates);
		req.setAttribute("imgPro",currentProfile);
		req.getRequestDispatcher("customer_profile.jsp").forward(req, res);
		DBcon.conn.close();
		return true;
	}
}
