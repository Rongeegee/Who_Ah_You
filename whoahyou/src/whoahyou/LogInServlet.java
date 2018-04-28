package whoahyou;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
	public boolean valid = true;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	String method = req.getMethod();
    	System.out.println(method);
    	if(method.equals("POST"))
    		this.doPost(req,res);
//    	else if(method.equals("GET"))
//    		this.doGet(req, res);
    }

//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		res.getWriter().append("Served at: ").append(req.getContextPath());
//	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		try {
			validateCustomer(res,email, pwd);
		} catch (SQLException e) {
			System.out.println("Validate Customer Exception thrown");
			e.printStackTrace();
		}
		System.out.println("this is post " + email + " and " + pwd);
	}
	
	//validate the Customer users
	protected void validateCustomer(HttpServletResponse res, String email, String pwd) 
			throws ServletException, IOException, SQLException {
		DBConnectionManager DBcon = new DBConnectionManager();
		String sql = "select * from person where Email=? and Password=?";
		PreparedStatement st = DBcon.conn.prepareStatement(sql);
		st.setString(1, email);
		st.setString(2, pwd);
		ResultSet result = st.executeQuery();
		if(result.next()) {
			User user = new User(DBcon.conn, email, pwd, "Customer");
			// pulling up corresponding profiles based on the user.
			sql = "select * from profile where OwnerSSN = (select SSN from person where Email =?)";
			PreparedStatement st1 = DBcon.conn.prepareStatement(sql);
			st1.setString(1, user.email);
			ResultSet pR = st1.executeQuery();
			while(pR.next()) {
				Profile newProfile = new Profile();
				newProfile.ProfileID = pR.getString("ProfileID");
				newProfile.OwnerSSN = pR.getString("OwnerSSN");
				newProfile.DatingRangeStart = Integer.parseInt(pR.getString("DatingAgeRangeStart"));
				newProfile.DatingRangeEnd = Integer.parseInt(pR.getString("DatingAgeRangeEnd"));
				newProfile.DatinGeoRange = Integer.parseInt(pR.getString("DatinGeoRange"));
				newProfile.Age = Integer.parseInt(pR.getString("Age"));
				newProfile.ProfileID = pR.getString("M_F");
				newProfile.ProfileID = pR.getString("Hobbies");
				newProfile.height = Integer.parseInt(pR.getString("Height"));
				newProfile.weight = Integer.parseInt(pR.getString("Weight"));
				newProfile.ProfileID = pR.getString("HairColor");
				newProfile.ProfileID = pR.getString("CreationDate");
				newProfile.ProfileID = pR.getString("LastModDate");
				user.profiles.put(newProfile.ProfileID, newProfile);
			}
			res.sendRedirect("profile.jsp");
		}
		else {
			valid = false;
			System.out.println("Email or password is invalid.");
		}
	}
}
