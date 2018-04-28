<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "java.sql.*" %>
<% 
	
	try{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("IM HERE");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/who_ah_you","root", "whoahyou");
        PreparedStatement pst = con.prepareStatement("Select * from person");
        System.out.println(username + " and " + password);
        ResultSet resultset = pst.executeQuery();
        
        while(resultset.next()) {
        	String email = resultset.getString("Email");
        	String pass = resultset.getString("Password");
        	
        	if(username.equals(email)) {
        		if(pass.equals(password)) {
        			response.sendRedirect("http://www.google.com");
        		} else {
        			response.sendRedirect("index.jsp");
        		}
        	} else {
        		response.sendRedirect("index.jsp");
        	}
        }
	}
	catch(Exception e){
			System.out.println(e);
			System.out.println("expection occured");
			} 
%>
