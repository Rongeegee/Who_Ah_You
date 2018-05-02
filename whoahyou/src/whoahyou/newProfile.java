package whoahyou;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class newProfile
 */
@WebServlet("/newProfile")
public class newProfile extends HttpServlet {
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
		} catch (SQLException e) {
			System.out.println("Make account esception thrown");
			e.printStackTrace();
		}
	}
    protected boolean makeProfile(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		DBConnectionManager DBcon = new DBConnectionManager();
		String profileID = req.getParameter("profileID");
		String sql = "select ProfileID from person where ProfileID=?";
		PreparedStatement pst = DBcon.conn.prepareStatement(sql);
		pst.setString(1, profileID);
		ResultSet rset = pst.executeQuery();
		if(rset.next()) {
			System.out.println("The profileID already exist.");
			res.sendRedirect("NewProfile.jsp");
			return false;
		}
		String profileName = req.getParameter("profileName");
		String Age = req.getParameter("profileAge");
		int zip = Integer.parseInt(req.getParameter("zip")) ;
		String phone = req.getParameter("phone");
		String cardNum =req.getParameter("cardNum");
		//getting current time for account creation time
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		System.out.println(date);
		//open up db to add new user/account/person
		//insert into person
		sql = "insert into person (SSN,Password,FirstName,LastName,Street,City,State,Zipcode,Email,Telephone) values (?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement personSt = DBcon.conn.prepareStatement(sql);  

		personSt.execute();
		//insert into account

		DBcon.conn.close();
		res.sendRedirect("profile.jsp");
		
return true;
}
}
