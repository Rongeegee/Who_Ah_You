package whoahyou;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import net.sourceforge.jtds.jdbc.DateTime;

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
		} catch (Exception e) {
			System.out.println("Make profile exception thrown");
			e.printStackTrace();
		}
	}
    protected boolean makeProfile(HttpServletRequest req, HttpServletResponse res) throws Exception {
		DBConnectionManager DBcon = new DBConnectionManager();
		String profileID = req.getParameter("profileID");
		
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
		List<FileItem> items = null;
		try {
			items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(new ServletRequestContext(req));
		} catch (FileUploadException e) {
			System.out.println("Failed to get the image file.");
			e.printStackTrace();
		}
		for (FileItem item : items) {
            if (item.isFormField()) {
                // Process regular form fields here the same way as request.getParameter().
                // You can get parameter name by item.getFieldName();
                // You can get parameter value by item.getString();
            } else {
                // Process uploaded fields here.
                String filename = profileID + ".jpg";	// Get filename.
                File file = new File("/images/profileImg/", filename); // Define destination file.
                item.write(file); // Write to destination file.
            }
        }
		System.out.println("File is uploaded.");
		
		String profileName = req.getParameter("profileName");
		String age = req.getParameter("profileAge");
		String gender = req.getParameter("gender");
		String weight = req.getParameter("weight");
		String height = req.getParameter("feet") + "\'" + req.getParameter("inches") + "\"";
		String geoRange = req.getParameter("geoRange");
		String DatingAgeRangeStart = req.getParameter("DatingAgeRangeStart");
		String DatingAgeRangeEnd = req.getParameter("DatingAgeRangeEnd");
		String Hobbies = req.getParameter("hobbies");
		
		// date right now
		Date CreatedDate= new Date(System.currentTimeMillis());
		System.out.println(CreatedDate);
		
	      
//		sql = "INSERT INTO Profile(ProfileID, OwnerSSN, Age, DatingAgeRangeStart,DatingAgeRangeEnd,"
//				+ "DatinGeoRange,M_F, Hobbies, Height, Weight, HairColor,CreationDate, LastModDate) "
//				+ "VALUES ('Isabelle2014','555-55-5555','22','20','25','5','Female','Shopping,Cooking','5.7',"
//				+ "'110','Black','2014-10-04 22:43:25','2014-10-09 11:51:19');";
		
		
		
		
		//insert into account

		DBcon.conn.close();
		res.sendRedirect("profile.jsp");
		
	return true;
	}
}
