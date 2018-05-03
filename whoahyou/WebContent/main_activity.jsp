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

  
<%@ page import ="java.util.*"%>
    		<%@ page import = "whoahyou.like" %>
    		<%@ page import = "whoahyou.date" %>
    		<%@ page import = "whoahyou.Profile" %>
    		<%@ page import = "whoahyou.undoLike" %>
    		<%@ page import = "whoahyou.createDate" %>
    		<%@ page import = "javax.servlet.http.HttpServletRequest" %>
    		<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> 
    		<% 
    		String currentProfile = (String)request.getAttribute("current");
    		List<date>dates = (ArrayList<date>) request.getAttribute("dateList");
    		List<Profile>matches = (ArrayList<Profile>) request.getAttribute("matchesList");
    		List<like> likeList = (ArrayList<like>) request.getAttribute("likerList");
    		List<like> likerList = (ArrayList<like>) request.getAttribute("likeeList");
    		
    		List<Profile> referList = (ArrayList<Profile>)request.getAttribute("referList");
    		List<Profile> referList2 = (ArrayList<Profile>)request.getAttribute("referList2");
    		
			%>
     		
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
			  <button class="tabButton" onclick="tab('like')" id="likeButton">Likes</button>
			  <button class="tabButton" onclick="tab('discover')" id="discoverButton">Discover</button>
			  <button class="tabButton" onclick="tab('refer')" id="referButton">Referral</button>
			</div>

			<div id="date" class="pane">
			<!-- the following code is for the display of past date-->
			<h2 id="pastDateHeading">Past Date:<h2>
			  <c:forEach var = "pro" items = "<%=dates %>">
				<div class="infoContainer">
			  		<div class="dateImageSection">
						<img src="${pro.getURL()}" class="dateImg">
					 	<h2 class="dateProfileName"><c:out value = "${pro.getP1()}" /></h2>
					 	<h2 class="dateProfileName"><c:out value = "${pro.getP2()}" /></h2>
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
			<!-- end of code for past date-->
			
			
			
			<!-- the following code is for the display of pending date that needs comment from customers-->
			<h2 id="pendingDateHeading">pending Date:<h2>
			<div class="infoContainer">
			  <div class="dateImageSection">
				<img src="images/defaultProfile.jpg" class="dateImg">
				<h2  class="dateProfileName">Profile name</h2>
			  </div>

			  <div class="infoSection">
				<h2  class="info">Date_time</h2>
				<h2  class="info">location</h2>
				<br>
				<br>
				<textarea class="commentBox" rows="7" cols="80" name="comment" form="usrform">Please write a comment about your date here</textarea>
				<br>
				<button class="post_button">post</button>
			  </div>
			</div>
			<div class="infoContainer">
			  <div class="dateImageSection">
				<img src="images/defaultProfile.jpg" class="dateImg">
				<h2  class="dateProfileName">Profile name</h2>
			  </div>

			  <div class="infoSection">
				<h2  class="info">Date_time</h2>
				<h2  class="info">location</h2>
				<br>
				<br>
				<textarea class="commentBox" rows="7" cols="80" name="comment" form="usrform">Please write a comment about your date here</textarea>
				<br>
				<button class="post_button">post</button>
			  </div>
			</div>
			<div class="infoContainer">
			  <div class="dateImageSection">
				<img src="images/defaultProfile.jpg" class="dateImg">
				<h2  class="dateProfileName">Profile name</h2>
			  </div>

			  <div class="infoSection">
				<h2  class="info">Date_time</h2>
				<h2  class="info">location</h2>
				<br>
				<br>
				<textarea class="commentBox" rows="7" cols="80" name="comment" form="usrform">Please write a comment about your date here</textarea>
				<br>
				<button class="post_button">post</button>
			  </div>
			</div>
			
			
			
			
			
			
			<!-- the following code is for the display of future date-->
			<h2 id="futureDateHeading">Future Date:<h2>
			
			<div class="futureDateInfoBlock">
				<img src="images/defaultProfile.jpg" class="futureDateProImg" />
				<h2 class="futureDateInfo">Profile Name</h2>
				<h2 class="futureDateInfo">date_time</h2>
				<h2 class="futureDateInfo">location</h2>
				<button class="cancelDateButt" onclick="handleCancelDate(this)">cancel date</button>
			</div>
			
			
			
			<!-- end of future code for future date-->
			
			
			
			
			
			</div>

			
			<!-- the following div with an "like" id is the like page-->
			<div id="like" class="pane" style="display:none">
			<h1 ID="likeHeading">People That Liked You:</h2>
			  
			  <c:forEach var = "pro" items = "<%=likeList %>">
			  		<div class="InfoBlock"><img src="${pro.getURL()}" class="likerImg">
			  			<form method = "post" action = "createDate">
			  			<input type="hidden" name="profileID" value="${pro.getLikee()}">
			  			<input type="hidden" name="LikeeID" value="${pro.getLiker()}">
			  			<input type="hidden" name="Time" value="${pro.getTime()}">
			  			<h2><c:out value = "${pro.getLiker()}" /></h2><br>
			  			<h2><c:out value = "${pro.getTime()}" /></h2><br>
			  			<button type = "submit" class="likeBackButton">Create Date</button>
			  			</form>
			  		</div>
			  </c:forEach>
			  <h1 ID="likeHeading">People That You Liked:</h2>
			  <c:forEach var = "pro" items = "<%=likerList %>">
			  		<div class="InfoBlock"><img src="${pro.getURL()}" class="likerImg">
			  			<form method = "post" action = "undoLike">
			  			<input type="hidden" name="profileID" value="${pro.getLiker()}">
			  			<input type="hidden" name="LikeeID" value="${pro.getLikee()}">
			  			<input type="hidden" name="Time" value="${pro.getTime()}">
			  			<h2><c:out value = "${pro.getLikee()}" /></h2><br>
			  			<h2><c:out value = "${pro.getTime()}"/></h2><br>
			  			<button type = "submit" class="undoLikeButton">Undo Like</button>
			  			</form>
			  		</div>
			  </c:forEach>
			</div>
			
			<div id="discover" class="pane" style="display:none">
			<c:forEach var = "pro" items = "<%=matches %>">
			  		<div class="InfoBlock"><img src="${pro.getPicPath()}" class="likerImg">
			  		<form method = "post" action = "likeServlet">
			  		<input type="hidden" name="chosenOne" value="${pro.getProfileID()}">
			  		<input type="hidden" name="liker" value="<%=currentProfile%>">
					<h2><c:out value = "${pro.getProfileID()}"/></h2>
					<h2>Age: ${pro.getAge()}</h2>
					<h2>Gender: ${pro.getGender()}</h2>
					<button>Like</button>
					</form>
			  </div>
			  </c:forEach>
			</div>
			
			<div id="refer" class="pane" style="display:none">
				<form method = "post" action = "referServlet">
				<c:forEach var = "pro" items = "<%=matches %>">
				  		<div class="InfoBlock"><img src="${pro.getPicPath()}" class="likerImg">
				  		<input type="radio" name="profileC" value="${pro.getProfileID()}"/>
				  		<input type="radio" name="profileB" value="${pro.getProfileID()}"/>
				  		<input type="hidden" name="profileA" value="<%=currentProfile%>"/>
						<h2><c:out value = "${pro.getProfileID()}"/></h2>
						<h2>Age: ${pro.getAge()}</h2>
						<h2>Gender: ${pro.getGender()}</h2>
				  </div>
				  </c:forEach>
				  <button>Refer</button>
				  </form>
			</div>
			

		</div>
	</div>	
</div>
	  
	  
  
  
		
</body>

 <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script  src="js/index.js"></script>
</html>