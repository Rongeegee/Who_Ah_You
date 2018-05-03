<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>


<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Who-Ah-You</title>
  
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

      <link rel="stylesheet" href="css/style.css">

  
</head>

<body>

  
<!-- Mixins-->
<!-- Pen Title-->
<div class="pen-title">
  <h1>Who-Ah-You</h1><h2>where love starts with <span style="color: #F163FA">"Who-Ah-You"</span></h2>
  <br>
  <h2>sign up now to meet the love of your life</h2>
</div>
	
	<a style="color:white;"><button  class="pink_button_block" style="margin-left:80%;">&nbsp setting</button></a>
	
<div class="big_container">
	<div class="card"></div>
  <div class="card">
    <h1 class="title">Profile(s)</h1>
    <%@ page import ="java.util.*"%>
    <%@ page import = "whoahyou.Profile" %>
    <%@ page import = "javax.servlet.http.HttpServletRequest" %>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> 
    <% 
    	List<Profile> profiles = (ArrayList<Profile>) request.getAttribute("profiles");
     %>
    <!--  generating forloop to display the pictures -->
    <c:forEach var = "pro" items = "<%=profiles %>">
    <div class="proImgBlock"><img src= <c:out value = "${pro.getPicPath()}"/> class="defProImg"/>
    <form method = "get" action="likeServlet">
    <input type="submit" name = "profileID" value="${pro.getProfileID()}">
    </form>
    </div>
    <!--<h2 class ="profileName"> <c:out value = "${pro.getProfileID()}" /></h2></div></a>-->
	</c:forEach>
		<a href="NewProfile.jsp"><div class="proImgBlock"><img src="images/addButton.jpg" class="defProImg"><h2 class ="profileName">new profile</h2></div></a>

</div>
</div>

  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  

    <script  src="js/index.js"></script>


	

</body>
	
</html>