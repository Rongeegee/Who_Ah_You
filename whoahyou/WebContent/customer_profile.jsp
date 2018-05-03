<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

 <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
 <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
 <link rel="stylesheet" href="css/style.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>profile</title>
</head>
<body>
<%@ page import ="java.util.*"%>
    		<%@ page import = "whoahyou.like" %>
    		<%@ page import = "whoahyou.date" %>
    		<%@ page import = "whoahyou.Profile" %>
    		<%@ page import = "whoahyou.undoLike" %>
    		<%@ page import = "whoahyou.createDate" %>
    		<%@ page import = "whoahyou.viewProfile" %>
    		<%@ page import = "javax.servlet.http.HttpServletRequest" %>
    		<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> 
    		<% 
    		Profile currentProfile = (Profile)request.getAttribute("imgPro");
    		System.out.println(currentProfile.getHobbies());
    		System.out.println(currentProfile.getPicPath());
    		List<date>dates = (ArrayList<date>) request.getAttribute("dates");
    		List<like> likerList = (ArrayList<like>) request.getAttribute("likeeList");
			%>
  

<!-- Pen Title-->
<div class="pen-title">
  <h1>Who-Ah-You</h1><h2>where love starts with <span style="color: #F163FA">"Who-Ah-You"</span></h2>
  <br>
</div>
	


<div class="RegInfoContainer">
  <div class="card"></div>
  <div class="card">
   
     
	  
	  
	  
	  
	  <div class="button-container">
	    <img style="width:500px;height:600px;"src= <%=currentProfile.getPicPath() %>>
		<h2 style="font-size:20px;"><%=currentProfile.getProfileID() %></h2>
				<br><br><br><br><br>
		<h2 id="pendingDateHeading">Profile Info:</h2>
		<div class="profileInfoBlock">
			<h2>Age: <%=currentProfile.getAge() %></h2>
			<br>
			<h2>Height: <%=currentProfile.getHeight()%></h2>
			<br>
			<h2>Weight: <%=currentProfile.getWeight()%></h2>
			<br>
			<h2>Hair color: <%=currentProfile.getColor()%></h2>
			<br>
			<h2>Hobbies: <%=currentProfile.getHobbies()%></h2>
		</div>
		<!-- the following code is for the display of past date-->
			<h2 id="pastDateHeading">Dates:<h2>
			  
			<c:forEach var = "pro" items = "<%=dates %>">
				<div class="infoContainer">
				<img src="${pro.getURL()}" class="dateImg">
				<h2  class="dateProfileName">"${pro.getP2()}"</h2>
				</div>
				<div class="infoSection">
				<h2  class="info"><c:out value = "${pro.getDT()}" /></h2><br>
						<h2  class="info"><c:out value = "${pro.getLoc()}" /></h2><br>
						
						<h2 class="info"><c:out value = "${pro.getP1()} 's rating: ${pro.getU1R()}"/></h2><br>
						<h2  class="info"><c:out value = "${pro.getP2()}'s rating: ${pro.getU1R()}"/></h2><br>
						<h2  class="info"><c:out value = "${pro.getComments()}" /></h2>
			  </div>
			  </div>
			</c:forEach>					
			
			
			
			
			
			<!-- the following code is for the display of pending date that needs comment from customers-->
			
       
      </div>     
    </form>
  </div>

</div>



  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  

    <script  src="js/index.js"></script>


	

</body>
  
  
		
   

  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  <script  src="js/index.js"></script>
</html>