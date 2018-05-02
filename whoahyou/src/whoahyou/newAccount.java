package whoahyou;


import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import whoahyou.DBConnectionManager;

/**
 * Servlet implementation class newAccount
 */
@WebServlet("/newAccount")
public class newAccount extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newAccount() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	String method = req.getMethod();
		//System.out.println(req.getRequestURI()); // /whoahyou/newAccount
    	if(method.equals("POST"))
    		this.doPost(req,res);
    }
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			makeAccount(req, res);
		} catch (SQLException e) {
			System.out.println("Make account esception thrown");
			e.printStackTrace();
		}
	}
    protected boolean makeAccount(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
				DBConnectionManager DBcon = new DBConnectionManager();
    			String email = req.getParameter("email");
				String sql = "select Email from person where Email=?";
				PreparedStatement pst = DBcon.conn.prepareStatement(sql);
				pst.setString(1, email);
				ResultSet rset = pst.executeQuery();
				if(rset.next()) {
					System.out.println("The acccount already exist with this email.");
					res.sendRedirect("register.jsp");
					return false;
				}
				String pwd = req.getParameter("pwd");
				String confirmPwd = req.getParameter("confirmPwd");
				if(!pwd.equals(confirmPwd)) {
					System.out.println("Password and confirmed password does not match.");
					res.sendRedirect("register.jsp");
					return false;
				}
				String firstName = req.getParameter("firstName");
				String lastName = req.getParameter("lastName");
				String street = req.getParameter("street");
				String city = req.getParameter("city");
				String state = req.getParameter("state");
				int zip = Integer.parseInt(req.getParameter("zip")) ;
				String phone = req.getParameter("phone");
				String ssn = req.getParameter("SSN");
				String cardNum =req.getParameter("cardNum");
				//getting current time for account creation time
				long millis=System.currentTimeMillis();  
				java.sql.Date date=new java.sql.Date(millis);  
				System.out.println(date);
				//open up db to add new user/account/person
				//insert into person
				sql = "insert into person (SSN,Password,FirstName,LastName,Street,City,State,Zipcode,Email,Telephone) values (?,?,?,?,?,?,?,?,?,?);";
				PreparedStatement personSt = DBcon.conn.prepareStatement(sql);  
				personSt.setString(1, ssn);
				personSt.setString(2, pwd);
				personSt.setString(3, firstName);
				personSt.setString(4, lastName);
				personSt.setString(5, street);
				personSt.setString(6, city);
				personSt.setString(7, state);
				personSt.setInt(8, zip);
				personSt.setString(9, email);
				personSt.setString(10, phone);
				personSt.execute();
				//insert into account
				System.out.println("it gets here");
				sql = "insert into account (OwnerSSN,CardNumber,AcctNum,AcctCreationDate) values ((select SSN from person where SSN=?),?,?,?);";
				PreparedStatement accountSt = DBcon.conn.prepareStatement(sql);
				accountSt.setString(1, ssn);
				accountSt.setString(2, cardNum);
				accountSt.setString(3, firstName);
				accountSt.setDate(4, date);
				accountSt.execute();
				System.out.print("everything works");
				DBcon.conn.close();
				res.sendRedirect("profile.jsp");
				
		return true;
	}
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
