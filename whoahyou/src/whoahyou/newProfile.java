package whoahyou;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
/**
 * Servlet implementation class newProfile
 */
@WebServlet("/newProfile")
public class newProfile extends HttpServlet{
	DBConnectionManager DBcon = Data.DBcon;
	public User user = Data.user;
	//private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newProfile() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	String method = req.getMethod();
    	if(method.equals("POST"))
			this.doPost(req,res);
    }
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
				makeProfile(req, res);
		} catch (Exception e) {
			System.out.println("Make profile exception thrown");
			e.printStackTrace();
		}
	}
    protected boolean makeProfile(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String profileID = "";
		profileID =req.getParameter("profileID");
		//checking whether profileID exist in the db
		String sql = "select ProfileID from profile where ProfileID=?";
		PreparedStatement pst = DBcon.conn.prepareStatement(sql);
		pst.setString(1, profileID);
		ResultSet rset = pst.executeQuery();
		if(rset.next()) {
			System.out.println("The profileID already exist.");
			res.sendRedirect("NewProfile.jsp");
			return false;
		}
		//try to save the profile image into the system.
		String profileName = req.getParameter("profileName");
		int age = Integer.parseInt(req.getParameter("profileAge"));
		String gender = req.getParameter("gender");
		int weight = Integer.parseInt(req.getParameter("weight"));
		String height = req.getParameter("feet") + "\'" + req.getParameter("inches") + "\"";
		int geoRange = Integer.parseInt(req.getParameter("geoRange"));
		int DatingAgeRangeStart = Integer.parseInt(req.getParameter("DatingAgeRangeStart"));
		int DatingAgeRangeEnd = Integer.parseInt(req.getParameter("DatingAgeRangeEnd"));
		String hairColor = req.getParameter("hairColor");
		String Hobbies = req.getParameter("hobbies");
		
		// date right now
		java.sql.Date CreatedDate= new java.sql.Date(System.currentTimeMillis());
		System.out.println(CreatedDate);
		
		sql = "INSERT INTO Profile(ProfileID, OwnerSSN, Age, DatingAgeRangeStart,DatingAgeRangeEnd,"
				+ "DatinGeoRange, M_F, Hobbies, Height, Weight, HairColor,CreationDate, LastModDate) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";

		PreparedStatement ppst = DBcon.conn.prepareStatement(sql);
		ppst.setString(1, profileID);
		ppst.setString(2, user.ssn);
		System.out.println(user.ssn);
		ppst.setInt(3, age);
		ppst.setInt(4, DatingAgeRangeStart);
		ppst.setInt(5, DatingAgeRangeEnd);
		ppst.setInt(6, geoRange);
		ppst.setString(7, gender);
		ppst.setString(8, Hobbies);
		ppst.setString(9, height);
		ppst.setInt(10, weight);
		ppst.setString(11, hairColor);
		ppst.setDate(12, CreatedDate);
		ppst.setDate(13, CreatedDate);
		System.out.println(ppst.execute());
		
		Data.currentProfile.ProfileID = profileID;
		Data.currentProfile.ProfileName = profileName;
		Data.currentProfile.Age = age;
		Data.currentProfile.Gender = gender;
		Data.currentProfile.HairColor = hairColor;
		Data.currentProfile.Height = height;
		Data.currentProfile.Weight = weight;
		Data.currentProfile.Hobbies = Hobbies;
		Data.currentProfile.CreationDate = (java.sql.Date) CreatedDate;
		Data.currentProfile.LastModDate = (java.sql.Date) CreatedDate;
		Data.currentProfile.DatinGeoRange = geoRange;
		Data.currentProfile.DatingRangeStart = DatingAgeRangeStart;
		Data.currentProfile.DatingRangeEnd = DatingAgeRangeEnd;
		user.profiles.add(Data.currentProfile);
		
		// adding it into profile
		System.out.println("profile inserted");
		
		// pickcing ima from the index 0 and generate the rest 
		
		req.setAttribute("user", user);
		req.getRequestDispatcher("profile.jsp").forward(req, res);
	return true;
	}
}
