<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  
 <title>Activities</title>
  
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

      <link rel="stylesheet" href="css/style.css">
</head>
<body>

  

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
		
			<div class="tabPane">
			  <button class="tabButton" onclick="tab('date')" id="dateButton">Dates</button>
			  <button class="tabButton" onclick="tab('like')" id="likeButton" type = "submit">Likes</button>
			  <button class="tabButton" onclick="tab('discover')" id="discoverButton">Discover</button>
			</div>

			<div id="date" class="pane">
			<h2 id="dateHeading">Date:<h2>
			  <div class="dateBlock">
				<div class="dateInfoBlock"><img src="images/defaultProfile.jpg" class="dateImg">
					
					<h2>user</h2>
					<h2>date</h2>
					<h2>time</h2>
					<h2>location</h2>
				</div>
				<div class="dateInfoBlock"><img src="images/defaultProfile.jpg" class="dateImg">
					<h2>user</h2>
					<h2>date</h2>
					<h2>time</h2>
					<h2>location</h2>
				</div>
				<div class="dateInfoBlock"><img src="images/defaultProfile.jpg" class="dateImg">
					<h2>user</h2>
					<h2>date</h2>
					<h2>time</h2>
					<h2>location</h2>
				</div>
				<div class="dateInfoBlock"><img src="images/defaultProfile.jpg" class="dateImg">
					<h2>user</h2>
					<h2>date</h2>
					<h2>time</h2>
					<h2>location</h2>
				</div>
				<div class="dateInfoBlock"><img src="images/defaultProfile.jpg" class="dateImg">
					<h2>user</h2>
					<h2>date</h2>
					<h2>time</h2>
					<h2>location</h2>
				</div>
				<div class="dateInfoBlock"><img src="images/defaultProfile.jpg" class="dateImg">
					<h2>user</h2>
					<h2>date</h2>
					<h2>time</h2>
					<h2>location</h2>
				</div>
				<div class="dateInfoBlock"><img src="images/defaultProfile.jpg" class="dateImg">
					<h2>user</h2>
					<h2>date</h2>
					<h2>time</h2>
					<h2>location</h2>
				</div>
				<div class="dateInfoBlock"><img src="images/defaultProfile.jpg" class="dateImg">
					<h2>user</h2>
					<h2>date</h2>
					<h2>time</h2>
					<h2>location</h2>
				</div>
				<div class="dateInfoBlock"><img src="images/defaultProfile.jpg" class="dateImg">
					<h2>user</h2>
					<h2>date</h2>
					<h2>time</h2>
					<h2>location</h2>
				</div>
			  </div>
			  
			</div>

			<div id="like" class="pane" style="display:none">
			<h1 ID="likeHeading">Like:</h2>
			<%@ page import ="java.util.*"%>
    		<%@ page import = "whoahyou.like" %>
    		<%@ page import = "javax.servlet.http.HttpServletRequest" %>
    		<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> 
    		<% 

    		List<like> likeList = (ArrayList<like>) request.getAttribute("likerList");
    		System.out.println(likeList.size());
     		%>
     		<!--  generating forloop to display the pictures -->
    		<c:forEach var = "pro" items = "<%=likeList %>">
    		<div class="InfoBlock"><img src="images/defaultProfile.jpg" class="likerImg">
    		<h2> <c:out value = "${pro.getLiker()}" /></h2></div>
    		</c:forEach>
			</div>

			<div id="discover" class="pane" style="display:none">
			 <div class="InfoBlock"><img src="images/defaultProfile.jpg" class="likerImg">
					<h2>user</h2>
					<h2>18-Year-Old</h2>
					<h2>20 miles</h2>
					<h2>6 feets 11 inches<h2> 
			  </div>
			  <div class="InfoBlock"><img src="images/defaultProfile.jpg" class="likerImg">
					<h2>user</h2>
					<h2>18-Year-Old</h2>
					<h2>20 miles</h2>
					<h2>6 feets 11 inches<h2> 
			  </div>
			  <div class="InfoBlock"><img src="images/defaultProfile.jpg" class="likerImg">
					<h2>user</h2>
					<h2>18-Year-Old</h2>
					<h2>20 miles</h2>
					<h2>6 feets 11 inches<h2> 
			  </div>
			  <div class="InfoBlock"><img src="images/defaultProfile.jpg" class="likerImg">
					<h2>user</h2>
					<h2>18-Year-Old</h2>
					<h2>20 miles</h2>
					<h2>6 feets 11 inches<h2> 
			  </div>
			  <div class="InfoBlock"><img src="images/defaultProfile.jpg" class="likerImg">
					<h2>user</h2>
					<h2>18-Year-Old</h2>
					<h2>20 miles</h2>
					<h2>6 feets 11 inches<h2> 
			  </div>
			  <div class="InfoBlock"><img src="images/defaultProfile.jpg" class="likerImg">
					<h2>user</h2>
					<h2>18-Year-Old</h2>
					<h2>20 miles</h2>
					<h2>6 feets 11 inches<h2> 
			  </div>
			  <div class="InfoBlock"><img src="images/defaultProfile.jpg" class="likerImg">
					<h2>user</h2>
					<h2>18-Year-Old</h2>
					<h2>20 miles</h2>
					<h2>6 feet 11 inches<h2> 
			  </div>
			  
			</div>

		</div>
	</div>	
</div>
	  
	  
  
  
		
</body>

 <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  

   <script  src="js/index.js"></script>
</html>