package whoahyou;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
       
//	protected void idAndpwd(HttpServletRequest req, HttpServletResponse res) {
//		String id = req.getParameter("id");
//		String pwd = req.getParameter("password");
//		
//		System.out.println(id + " and " + pwd);
//	}
	
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
    	else if(method.equals("GET"))
    		this.doGet(req, res);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.getWriter().append("Served at: ").append(req.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String pwd = req.getParameter("password");
		res.sendRedirect("profile.jsp");
		System.out.println("this is post " + id + " and " + pwd);
		
	}

}
