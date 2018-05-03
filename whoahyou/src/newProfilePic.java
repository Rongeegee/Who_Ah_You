

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import whoahyou.MainInfo;

/**
 * Servlet implementation class newProfilePic
 */
@WebServlet("/newProfilePic")
public class newProfilePic extends HttpServlet implements MainInfo{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newProfilePic() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<FileItem> items = null;
		try {
			items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(new ServletRequestContext(request));
		} catch (FileUploadException e) {
			System.out.println("Failed to get the image file.");
			e.printStackTrace();
		}
		for (FileItem item: items) {
            if (item.isFormField()) {
        		
                // Process regular form fields here the same way as request.getParameter().
                // You can get parameter name by item.getFieldName();
                // You can get parameter value by item.getString();
            } else {
                // Process uploaded fields here.
                 // Write to destination file.
        		String filename = MainInfo.currentProfile.getProfileID() + ".jpg";	// Get filename.
                File file = new File("/images/profileImg/", filename); // Define destination file.
                try {
					item.write(file);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		System.out.println("File is uploaded.");
            }
        }
		
	}

}
